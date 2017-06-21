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

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;


import com.entity.LjlAddFood;
import com.entity.LjlAddOrder;
import com.entity.TztDishOrder;
import com.insertemploydao.LjlDish;
import com.insertemploydao.LjlOrders;

import com.utils.toJson;

import com.insertemploydao.TztDishOrderImp;



public class LjlAddFoodAction {
	private LjlAddFood addfood;
	private LjlAddOrder addorder;
	//private String datatime1;
	LjlOrders orders=new LjlOrders();
	LjlDish dish=new LjlDish();
	TztDishOrderImp DishOrderImp=new TztDishOrderImp();
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
	 * 方法功能说明：  下单功能
	 * 创建：2017-6-21 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：  addorder 订单实体类     
	 * @return void     
	 * @throws
	 */
	public void addOrder(){

		int rsid=orders.rsadd(addorder);
		int dishStatus=12;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String[] foodnames=session.getValueNames();
		System.out.println("ger:"+foodnames.length);
		for (int i = 0; i < foodnames.length; i++) {
			List list=dish.seldishName(foodnames[i]);
			List listdish=(List) list.get(0);
			int dishid=(Integer) listdish.get(0);
			TztDishOrder dishorder=new TztDishOrder(rsid,dishid,dishStatus,addorder.getDeskid());
			DishOrderImp.add(dishorder);
		}

		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.getWriter().println(rsid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 方法功能说明：  跳转new点菜页面输出菜品
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public String newFood(){
		HttpServletRequest request=ServletActionContext.getRequest();
		
		List list=dish.sel();
		request.setAttribute("dishList", list); 
		return "newFood";	
	}
	/**
	 * 
	 * 方法功能说明：  添加菜品到购物车
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：     addfood菜品实体类  
	 * @return void     
	 * @throws
	 */
	public void addFood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute(addfood.getFoodname(), addfood);
		try {
			
			response.getWriter().print("1");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 方法功能说明：  计算购物车内菜品总数和总价
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
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
			LjlAddFood addf= (LjlAddFood)session.getAttribute(sname[i]);
			price=Integer.parseInt(addf.getPrice())+price;
			num=Integer.parseInt(addf.getNumber())+num;
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
	 * 方法功能说明：  清除购物车所有菜品
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void clearfood(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
	}
	/**
	 * 
	 * 方法功能说明：删除单个菜品  
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void delfood(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute(addfood.getFoodname());
	}

	/**
	 * 
	 * 方法功能说明：  打印菜品到我的菜单
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
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
			LjlAddFood addf= (LjlAddFood)session.getAttribute(sname[i]);
			int number=Integer.parseInt(addf.getNumber());
			if (number!=0) {
				Map map=new HashMap();
				map.put("ad"+i,addf);
				json.accumulateAll(map);
			}
			price=Integer.parseInt(addf.getPrice())+price;
		}
		try {
			response.getWriter().print(json.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 方法功能说明：  
	 * 创建：2017-6-21 by sxm  
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void searchOrder(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");//设置日期格式
		String time=df.format(new Date());
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time1=df1.format(new Date());
		System.out.println("time"+time);
		System.out.println("time1"+time1);
		List list=orders.selOrder(time,time1);
		System.out.println("list"+list);
		JSON json=toJson.toJson("val", list);
		
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
