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
import com.logic.GJYInsertFoodcategory;
import com.utils.toJson;


public class GJYFCaction {
	
	private String search;
	private GJYFoodCategory fdCry;
	GJYInsertFoodcategory inFc=new GJYInsertFoodcategory();
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
	public void uploads(){
		System.out.println("-----");
		try {
			
			String name=new Date().getTime()+phoneFileName.substring(phoneFileName.lastIndexOf("."));
			System.out.println(name);
			File file=new File("e:/"+name);
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