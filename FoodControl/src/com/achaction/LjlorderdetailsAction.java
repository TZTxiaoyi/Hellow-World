package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.insertemploydao.LjlBackgroundOrders;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.utils.toJson;


public class LjlorderdetailsAction {
	private  int currpage;
	LjlBackgroundOrders backgroundOrders=new LjlBackgroundOrders();
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	
	public void selorder(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		System.out.println(currpage);
		List list=backgroundOrders.page(currpage);
		try {
			response.getWriter().println(toJson.toJson("order1", list).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void pageTotal(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int total=backgroundOrders.getCount();
		System.out.println(total);
		try {
			response.getWriter().println(total);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
