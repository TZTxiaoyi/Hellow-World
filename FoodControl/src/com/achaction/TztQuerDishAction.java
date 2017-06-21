package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.TztDish;
import com.entity.TztDishOrder;
import com.insertemploydao.TztDishImp;
import com.insertemploydao.TztDishOrderImp;
import com.jspsmart.upload.Request;
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
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
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
		TztDishOrderImp dao =new TztDishOrderImp();
		List result = dao.queryMade();
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
		TztDishOrderImp  dao =new TztDishOrderImp();
		List result = dao.queryMading();
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
		TztDishImp dao=new TztDishImp();
		TztDish dish = new TztDish();
		dish.setDishId(dishId);
		List madedish =dao.sel(dish);
		TztDishImp dishImp = new TztDishImp();
		dishImp.changeDish(13,(List)madedish.get(0),12);
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
		TztDishImp dao=new TztDishImp();
		TztDish dish = new TztDish();
		dish.setDishId(dishId);
		List madedish =dao.sel(dish);
		TztDishImp dishImp = new TztDishImp();
		dishImp.changeDish(14,(List)madedish.get(0),13);
		System.out.println("change");
		try {
			rep.getWriter().print("sucess");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
