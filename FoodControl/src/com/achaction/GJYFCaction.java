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
	 * ��Ӳ�Ʒ
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
	
	/*��ѯ��Ʒaction*/
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
	
	/* �޸Ĳ�Ʒaction*/
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
	
	/*ɾ����Ʒaction*/
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
	
	
	
	/* ��ҳ����ѯaction*/
	public void getcount(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=inFc.getallpage(search);		
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