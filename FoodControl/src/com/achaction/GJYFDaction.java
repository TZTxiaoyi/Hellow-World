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
	
	private String search;/*������Ʒ�Ĺؼ���*/
	private int countpage;/*��ǰ��ҳ��ҳ��*/

	private  GJYKIDCategory KID = new GJYKIDCategory();/*������Ʒʵ����*/
	GJYFDInsertemploydao inFKD=new GJYFDInsertemploydao();/*����Dao����*/
	
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
	
	/*��Ӳ�Ʒ*/
	public void kidinsert(){	
		HttpServletResponse hsr=ServletActionContext.getResponse();
		int a=inFKD.insert(KID);
		try {
			hsr.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/*��ѯ��Ʒaction*/
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
	
	/* �޸Ĳ�Ʒaction*/
	public void kidchange(){
		System.out.println("FCchange()");
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int a=inFKD.Change(KID);
	}
	
	/*ɾ����Ʒaction*/
	public void kiddelete(){
		System.out.println("-------");
		System.out.println(inFKD.getallpage());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int n=inFKD.delect(KID);
		
	}
	
	
	
	/* ��ҳ����ѯaction*/
	public void kidgetcount(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=inFKD.getallpage();		
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		} 		
	} 
	
	
	/* ����JSP�е�ҳ�벢����ҳ����action*/
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