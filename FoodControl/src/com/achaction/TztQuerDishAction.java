package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.daointerface.TztSort;
import com.entity.TztDish;
import com.insertemploydao.TztDishImp;
import com.insertemploydao.TztDishOrderImp;
import com.logic.TztDefaultSortImp;
import com.logic.TztPrioritySortImp;
import com.entity.TztDishOrder;

import com.utils.toJson;



/**
 * 
 * @�๦��˵����  
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-16 ����12:00:46  
 * @�汾��V1.0
 */
public class TztQuerDishAction {
	int method;
	String dishId;
	private TztSort sort;
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public TztSort getSort() {
		return sort;
	}
	public void setSort(TztSort sort) {
		this.sort = sort;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	/**
	 * 
	 * ��������˵���� ��ͬ�İ�ť������ͬ�Ľӿ� 
	 * ������2017-6-22 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param method      
	 * @return void     
	 * @throws
	 */
	public void createImp(int method){
			if(method==1){
			}else if(method ==2){
				TztSort sort =new TztPrioritySortImp();
				setSort(sort);
			}else {
				TztSort sort = new TztDefaultSortImp();
				setSort(sort);
			}
		} 
		
	
	/**
	 * 
	 * ��������˵����  ��ѯ��Ҫ�����Ĳ�
	 * ������2017-6-16 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return String     
	 * @throws
	 */
	public void queryMade() {
		HttpServletResponse rep= ServletActionContext.getResponse();
		rep.setContentType("text/html;charset=utf-8");
		createImp(method);
		List result= sort.queryMade();
		System.out.println("made"+result);
		try {
			rep.getWriter().print(toJson.toJsonArray("tztjs", result).toString());
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
	}
	/**
	 * 
	 * ��������˵����  ��ѯ���������Ĳ�
	 * ������2017-6-17 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void queryMading() {
		HttpServletRequest req	=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		HttpServletResponse rep =ServletActionContext.getResponse();
		rep.setContentType("html/text;charset =utf-8");
		createImp(method);
		List result= sort.queryMading();
		System.out.println("mading"+result);
		try {
			rep.getWriter().print(toJson.toJsonArray("tztjs", result).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}
	/**
	 * 
	 * ��������˵����  ���������ť�޸Ĳ˵�״̬Ϊ������
	 * ������2017-6-21 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void make(){
		HttpServletRequest req= ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setContentType("html/text;charset=utf-8");
		createImp(method);
		List result =sort.made(dishId);
		session.setAttribute((String) result.get(0),result);
		try {
			rep.getWriter().print(toJson.toJsonArray("tztjs", result).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * ��������˵�������������ɰ�ť�޸Ĳ�Ʒ״̬Ϊ�������  
	 * ������2017-6-21 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void makding(){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session =req.getSession();
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setContentType("html/text;charset=utf-8");
		createImp(method);
		List result =sort.mading(dishId);
		System.out.println("madeing++++++++++++=="+result);
		try {
			rep.getWriter().print(toJson.toJsonArray("js", result).toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session =req.getSession();
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setContentType("html/text;charset=utf-8");
		createImp(method);
		List result =sort.remove(dishId);
		System.out.println("remove++++++++++++=="+result);
		try {
			rep.getWriter().print(toJson.toJsonArray("js", result).toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
