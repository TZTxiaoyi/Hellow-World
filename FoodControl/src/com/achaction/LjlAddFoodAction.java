package com.achaction;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;


import com.entity.LjlAddFood;
import com.entity.LjlAddOrder;
import com.entity.TztDishOrder;
import com.insertemploydao.LjlDish;
import com.insertemploydao.LjlOrders;
import com.insertemploydao.TztDishOrderImp;
import com.logic.SxmTableSql;


public class LjlAddFoodAction {
	private LjlAddFood addfood;
	private LjlAddOrder addorder;
	private String desknub;
	
	LjlOrders orders=new LjlOrders();
	LjlDish dish=new LjlDish();
	TztDishOrderImp DishOrderImp=new TztDishOrderImp();
	SxmTableSql tableSql=new SxmTableSql();
	
	
	public String getDesknub() {
		return desknub;
	}
	public void setDesknub(String desknub) {
		this.desknub = desknub;
	}
	public LjlAddOrder getAddorder() {
		return addorder;
	}
	public void setAddorder(LjlAddOrder addorder) {
		this.addorder = addorder;
	}
	public LjlAddFood getAddfood() {
		return addfood;
	}
	public void setAddfood(LjlAddFood addfood) {
		this.addfood = addfood;
	}
	/**
	 * 
	 * ��������˵����  �µ�����
	 * ������2017-6-21 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������  addorder ����ʵ����     
	 * @return void     
	 * @throws
	 */
	public void addOrder(){
		int dishStatus=12;
		int flag=-1;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String[] foodnames=session.getValueNames();
		String tablename=(String) session.getAttribute("dname");
		List listtable=tableSql.idTablename(tablename);
		List listtId=(List) listtable.get(0);
		int tableid=(Integer) listtId.get(0);
		addorder.setDeskid(tableid);//��������id
		int rsid=orders.rsadd(addorder);//��Ӷ��������id
		for (int i = 0; i < foodnames.length; i++) {
			if (foodnames[i]!="dname") {
				List list=dish.seldishName(foodnames[i]);
				session.getAttribute(foodnames[i]);
				LjlAddFood addf= (LjlAddFood)session.getAttribute(foodnames[i]);
				int number=Integer.parseInt(addf.getNumber());
				List listdish=(List) list.get(0);
				int dishid=(Integer) listdish.get(0);
				TztDishOrder dishorder=new TztDishOrder(rsid,dishid,dishStatus,tableid);
				for (int j = 0; j < number; j++) {
					DishOrderImp.add(dishorder);
				}
				flag=1;
			}
			
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.getWriter().println(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * ��������˵����  ��תnew���ҳ�������Ʒ
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return String     
	 * @throws
	 */
	public String newFood(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String dname=request.getParameter("selectvalue");
		List list=dish.sel();
		request.setAttribute("dishList",list); 
		tableSql.uptabstate(dname);//��������name�ı�����״̬
		if (dname!=null) {
			session.setAttribute("dname", dname);
		}
		return "newFood";	
	}
	/**
	 * 
	 * ��������˵����  ��Ӳ�Ʒ�����ﳵ
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������     addfood��Ʒʵ����  
	 * @return void     
	 * @throws
	 */
	public void addFood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute(addfood.getFoodname(), addfood);
		LjlAddFood addf=(LjlAddFood) session.getAttribute(addfood.getFoodname());
		System.out.println("addfood:"+addf.getNumber()+","+addf.getFoodname());
		try {
			
			response.getWriter().print("1");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * ��������˵����  ���㹺�ﳵ�ڲ�Ʒ�������ܼ�
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void OrderTotal(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String[] sname=session.getValueNames();
		int price=0;
		int num=0;
		for (int i = 0; i <sname.length; i++) {
			if(sname[i]!="dname"){
				LjlAddFood addf= (LjlAddFood)session.getAttribute(sname[i]);
				price=Integer.parseInt(addf.getPrice())+price;
				num=Integer.parseInt(addf.getNumber())+num;
			}	
		}
		Map map=new HashMap();
		map.put("price", price);
		map.put("num",num);
		JSONObject json=new JSONObject();
		json.putAll(map);
		try {
			response.getWriter().print(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * ��������˵����  ������ﳵ���в�Ʒ
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void clearfood(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String tablename=(String) session.getAttribute("dname");
		session.invalidate();
		
		session.setAttribute("dname", tablename);
	}
	/**
	 * 
	 * ��������˵����ɾ��������Ʒ  
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void delfood(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute(addfood.getFoodname());
	}

	/**
	 * 
	 * ��������˵����  ��ӡ��Ʒ���ҵĲ˵�
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void lookFood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=ServletActionContext.getRequest().getSession();
		String[] sname=session.getValueNames();
		int price=0;
		JSONObject json=new JSONObject();
		for (int i = 0; i <sname.length; i++) {
			if(sname[i]!="dname"){
				LjlAddFood addf= (LjlAddFood)session.getAttribute(sname[i]);
				int number=Integer.parseInt(addf.getNumber());
				if (number!=0) {
					Map map=new HashMap();
					map.put("ad"+i,addf);
					json.accumulateAll(map);
				}
				price=Integer.parseInt(addf.getPrice())+price;	
			}
		}
		try {
			response.getWriter().print(json.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String backhome(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "backhome";
	}
	
}
