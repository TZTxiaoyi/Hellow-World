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
import com.insertemploydao.GJYInsertFoodcategory;
import com.utils.toJson;


public class GJYFCaction {
	
	private String search;/*������Ʒ�Ĺؼ���*/
	private int countpage;/*��ǰ��ҳ��ҳ��*/
	File phone;
	String phoneFileName;
	public File getPhone() {
		return phone;
	}



	public void setPhone(File phone) {
		this.phone = phone;
	}



	public String getPhoneFileName() {
		return phoneFileName;
	}



	public void setPhoneFileName(String phoneFileName) {
		this.phoneFileName = phoneFileName;
	}
	private GJYFoodCategory fdCry = new GJYFoodCategory();/*������Ʒʵ����*/
	GJYInsertFoodcategory inFc=new GJYInsertFoodcategory();/*����Dao����*/
	
	
	
	public GJYFoodCategory getFdCry() {
		return fdCry;
	}



	public void setFdCry(GJYFoodCategory fdCry) {
		this.fdCry = fdCry;
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
	/**
	 * ���Ӳ�Ʒ
	 */

	public void insertFood(){		
		System.out.println("22121");
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=inFc.FCinsert(fdCry);
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*��ѯ��Ʒaction*/
	public void seekfood(){
		System.out.println("seekfood()");
		List ser=inFc.sekFood(search);
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
	public void FCchange(){
		System.out.println("FCchange()");
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int a=inFc.Change(fdCry);
		try {
			response.getWriter().print(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage()+3333);
		}
	}
	
	/*ɾ����Ʒaction*/
	public void FCdelete(){
		System.out.println("-------");
		System.out.println(fdCry.getDishId());
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int n=inFc.delect(fdCry);
		try {
			response.getWriter().print(n);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//System.out.println(e.getMessage()+3333);
		}
	}
	
	
	
	/* ��ҳ����ѯaction*/
	public void getcount(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=inFc.getallpage();		
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		} 		
	} 
	
	
	/* ����JSP�е�ҳ�벢����ҳ����action*/
	public void getpage(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=inFc.pagepage(countpage);
		JSON json=toJson.toJson("value", list);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void uploads(){
		System.out.println("-----");
		try {
			String name=new Date().getTime()+phoneFileName.substring(phoneFileName.lastIndexOf("."));
			System.out.println(name);
			File file=new File("e:/NO9");
			InputStream is=new FileInputStream(phone);
			OutputStream os=new FileOutputStream(file);
			byte[] b=new byte[1024];
			try {
				while(is.read(b)!=-1){
					os.write(b);
				}
				
				is.close();
				os.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
}