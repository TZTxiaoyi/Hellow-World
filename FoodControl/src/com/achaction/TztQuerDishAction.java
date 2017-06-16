package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.TztDishOrder;
import com.logic.TztDishOrderImp;
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
	/**
	 * 
	 * ��������˵����  
	 * ������2017-6-16 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return String     
	 * @throws
	 */
	public void query() {
		HttpServletResponse rep= ServletActionContext.getResponse();
		rep.setContentType("text/html;charset=utf-8");
		TztDishOrderImp dao =new TztDishOrderImp();
		TztDishOrder dishorder = new TztDishOrder();
		List result = dao.queryMading();
		System.out.println(result.size());
		try {
			rep.getWriter().print(toJson.toJson("tztjs", result).toString());
			System.out.println(toJson.toJson("tztjs", result));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
		
	}
}
