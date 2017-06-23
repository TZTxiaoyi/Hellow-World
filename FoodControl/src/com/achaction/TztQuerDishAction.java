package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.daointerface.TztSort;
import com.entity.TztDish;
import com.insertemploydao.TztDishImp;
import com.insertemploydao.TztDishOrderImp;
import com.logic.TztDefaultSortImp;
import com.logic.TztTimeSortImp;
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
	int dishId;
	int method;
	private TztSort sort;
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
	public int getDishId() {
		return dishId;
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
				 TztSort sort = new TztTimeSortImp();
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
		try {
			rep.getWriter().print(toJson.toJson("tztjs", result).toString());
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
		HttpServletResponse rep =ServletActionContext.getResponse();
		rep.setContentType("html/text;charset =utf-8");
		createImp(method);
		List result= sort.queryMading();
		try {
			rep.getWriter().print(toJson.toJson("tztjs", result).toString());
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
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setContentType("html/text;charset=utf-8");
		createImp(method);
		sort.made(dishId);
		try {
			rep.getWriter().print("sucess");
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
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setContentType("html/text;charset=utf-8");
		createImp(method);
		List result =sort.mading(dishId);
		System.out.println(result+"madeing++++++++++++==");
		try {
			System.out.println("ffff"+toJson.toJson("js", result).toString());
			rep.getWriter().print(toJson.toJson("js", result).toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
