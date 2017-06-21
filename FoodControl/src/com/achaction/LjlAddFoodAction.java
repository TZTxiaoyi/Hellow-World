package com.achaction;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.entity.LjlAddFood;


public class LjlAddFoodAction {
	private LjlAddFood addfood;

	public LjlAddFood getAddfood() {
		return addfood;
	}
	public void setAddfood(LjlAddFood addfood) {
		this.addfood = addfood;
	}
	public void addFood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute(addfood.getFoodname(), addfood);
		String[] sname=session.getValueNames();
		int price=0;
		for (int i = 0; i <sname.length; i++) {
			LjlAddFood addf= (LjlAddFood)session.getAttribute(sname[i]);
			System.out.println(addf.getFoodname()+","+addf.getNumber()+","+addf.getPrice()+","+addf.getUprice());
			price=Integer.parseInt(addf.getPrice())+price;
		}
		try {
			response.getWriter().print(price);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
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
