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
	
	private String search;/*搜索菜品的关键词*/
	private int countpage;/*当前分页的页码*/
	File myfile;
	String myfileFileName;

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}



	public String getMyfileFileName() {
		return myfileFileName;
	}



	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}



	private GJYFoodCategory fdCry = new GJYFoodCategory();/*创建菜品实体类*/
	GJYInsertFoodcategory inFc=new GJYInsertFoodcategory();/*创建Dao对象*/
	
	
	
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
	 * 添加菜品
	 */

	public void insertFood(){		
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=inFc.FCinsert(fdCry);
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*查询菜品action*/
	public void seekfood(){
		List ser=inFc.sekFood(countpage,search);
		JSON json=toJson.toJsonArray("ss", ser);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		hsr.setCharacterEncoding("UTF-8");
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+3333);
		}
	}
	
	/* 修改菜品action*/
	public void FCchange(){
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
	
	/*删除菜品action*/
	public void FCdelete(){
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
	
	
	
	/* 总页数查询action*/
	public void getcount(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=inFc.getallpage(search);		
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		} 		
	} 
	
	
	/* 接收JSP中的页码并返回页码结果action*/
	public void getpage(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=inFc.pagepage(countpage); 
		JSON json=toJson.toJsonArray("value", list);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void uploads(){
		try {
			String name=new Date().getTime()+myfileFileName.substring(myfileFileName.lastIndexOf("."));
			File file=new File("E:/"+name);
			InputStream is=new FileInputStream(myfile);
			OutputStream os=new FileOutputStream(file);
			byte[] b=new byte[1024];
			try {
				while(is.read(b)!=-1){
					os.write(b);
				}
				is.close();
				os.close();
				HttpServletResponse response=ServletActionContext.getResponse();

				response.getWriter().print(name);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	}
	
	public void getselect(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=inFc.getselect(fdCry);
		JSON json=toJson.toJson("value",list);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	
	
}