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
import com.insertemploydao.LjlDish;
import com.insertemploydao.LjlOrders;


public class LjlAddFoodAction {
	private LjlAddFood addfood;
	private LjlAddOrder addorder;
	//private String datatime1;
	LjlOrders orders=new LjlOrders();
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
	public void addOrder(){
		System.out.println(addorder.getFoodNum()+","+addorder.getOrderPrice()+","+addorder.getOrderStatus()+","+addorder.getCost()+","+addorder.getOrdersTime()+","+addorder.getDeskid());
		int flag=orders.add(addorder);
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
		LjlDish dish=new LjlDish();
		List list=dish.sel();
		System.out.println("newFood:"+list);
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
			System.out.println(addf.getFoodname()+","+addf.getNumber()+","+addf.getPrice()+","+addf.getUprice());
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
		System.out.println("------------------");
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
		System.out.println("del---------------");
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
	
}
