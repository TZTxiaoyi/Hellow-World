package com.achaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.GJYFoodCategory;
import com.entity.GJYKIDCategory;
import com.insertemploydao.GJYFDInsertemploydao;
import com.utils.toJson;


public class GJYFDaction {
	
	private String search;/*搜索菜品的关键词*/
	private int countpage;/*当前分页的页码*/

	private  GJYKIDCategory KID = new GJYKIDCategory();/*创建菜品实体类*/
	GJYFDInsertemploydao inFKD=new GJYFDInsertemploydao();/*创建Dao对象*/
	
	public GJYKIDCategory getKID() {
		return KID;
	}



	public void setKID(GJYKIDCategory kID) {
		KID = kID;
	}



	public int getCountpage() {
		return countpage;
	}



	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}

	
	
	public String getSearch() {
		return search;
	}



	public void setSearch(String search) {
		this.search = search;
	}
	
	/*添加菜品*/
	public void kidinsert(){	
		HttpServletResponse hsr=ServletActionContext.getResponse();
		int a=inFKD.insert(KID);
		try {
			hsr.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*查询菜品action*/
	public void kidseek(){
		System.out.println("seekfood()");
		List ser=inFKD.sekKID(search);
		JSON json=toJson.toJson("ss", ser);
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
	
	/* 修改菜品action*/
	public void kidchange(){
		System.out.println("FCchange()");
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int a=inFKD.Change(KID);
	}
	
	/*删除菜品action*/
	public void kiddelete(){
		System.out.println("-------");
		System.out.println(inFKD.getallpage());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int n=inFKD.delect(KID);
		
	}
	
	
	
	/* 总页数查询action*/
	public void kidgetcount(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=inFKD.getallpage();		
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		} 		
	} 
	
	
	/* 接收JSP中的页码并返回页码结果action*/
	public void kidgetpage(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=inFKD.pagepage(countpage);
		JSON json=toJson.toJson("value", list);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	public void estiName(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=inFKD.getestiName(KID);
		JSON json=toJson.toJson("value",list);
		System.out.println(json);
		try {
			System.out.println(list.size());
			response.getWriter().print(list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}