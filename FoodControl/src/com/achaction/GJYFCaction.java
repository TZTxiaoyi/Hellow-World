package com.achaction;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.GJYFoodCategory;


import com.logic.GJYInsertFoodcategory;



import com.utils.toJson;


public class GJYFCaction {
	
	private String search;
	private GJYFoodCategory fdCry;
	GJYInsertFoodcategory inFc=new GJYInsertFoodcategory();
	
	
	
	public GJYFoodCategory getFdCry() {
		return fdCry;
	}



	public void setFdCry(GJYFoodCategory fdCry) {
		this.fdCry = fdCry;
	}



	public void insertfood(){	
		int a=inFc.FCinsert(fdCry);
	}
	
	
	

	public void FindAll(){	
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List list=inFc.FCFindAll();
		//System.out.println("lll"+toJson.toJson("value", list));
		try {
			
			JSON json=toJson.toJson("vc", list);
			response.getWriter().println(json);
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}	

	}
	
	public void seekfood(){
		List ser=inFc.sekFood(search);
		System.out.println("list"+ser);
		JSON json=toJson.toJson("ss", ser);
		System.out.println("json"+json);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("textml;charset=UTF-8");
		hsr.setCharacterEncoding("UTF-8");
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+3333);
		}
	}



	public String getSearch() {
		return search;
	}



	public void setSearch(String search) {
		this.search = search;
	}
	
}