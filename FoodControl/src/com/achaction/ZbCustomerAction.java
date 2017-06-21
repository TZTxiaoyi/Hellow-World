package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.ZbUsagedata;
import com.entity.ZbUserdata;
import com.logic.ZbRegister;
import com.utils.toJson;
	/**
	 * 
	 * @�๦��˵����  
	 * @���޸��ߣ�  
	 * @�޸����ڣ�  
	 * @�޸�˵����  
	 * @��˾���ƣ�adam  
	 * @���ߣ�zhubin  
	 * @����ʱ�䣺2017-6-20 ����9:23:13  
	 * @�汾��V1.0
	 */
public class ZbCustomerAction {
	private ZbUserdata userdata;//ע��
	ZbUsagedata zbud;
	
	
	public ZbUsagedata getZbud() {
		return zbud;
	}

	public void setZbud(ZbUsagedata zbud) {
		this.zbud = zbud;
	}
	ZbRegister re=new ZbRegister();
	public ZbUserdata getUserdata() {
		return userdata;
	}

	public void setUserdata(ZbUserdata userdata) {
		this.userdata = userdata;
	}
	/**
	 * 
	 * ��������˵����  
	 * ������2017-6-20 by zhubin   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return String     
	 * @throws
	 */
	public String register(){
		
		
		System.out.println(userdata.getAccount()+","+userdata.getPwd());
		int li = re.add(userdata);
		if(li == 1){
			HttpServletRequest htsr = ServletActionContext.getRequest();
			htsr.setAttribute("zb", 1);
			return "register";
		}
		return null;
		
		
	}
	public String login(){
		
		
		int list = re.loginsel(zbud);
		//JSON json = toJson.toJson("account",list );//ת��
		HttpServletResponse hsr = ServletActionContext.getResponse();//��ȡ����
		System.out.println(list);
		hsr.setContentType("text/html,charset=utf-8");
		hsr.setCharacterEncoding("utf-8");
		
		try {
			
			hsr.getWriter().print(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list==1){
			return "list";
			
		}else{
			HttpServletRequest ht = ServletActionContext.getRequest();
			ht.setAttribute("na", "k");
			return "register";
			
		}
	}
	
	/**
	 * 
	 * ��������˵������ѯ�ʺ�  
	 * ������2017-6-20 by zhubin   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void seluser(){
		List list=re.sel(userdata);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.getWriter().println(list.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
