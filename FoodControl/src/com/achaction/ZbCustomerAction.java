package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.ZbDesk;
import com.entity.ZbUsagedata;
import com.entity.ZbUserdata;
import com.insertemploydao.LjlDish;
import com.insertemploydao.ZbRegister;
import com.utils.toJson;
	/**
	 * 
	 * @类功能说明：  
	 * @类修改者：  
	 * @修改日期：  
	 * @修改说明：  
	 * @公司名称：adam  
	 * @作者：zhubin  
	 * @创建时间：2017-6-20 上午9:23:13  
	 * @版本：V1.0
	 */
public class ZbCustomerAction {
	private ZbUserdata userdata;//注册
	ZbUsagedata zbud;
	ZbDesk zbde;
	LjlDish dish=new LjlDish();
	
	public ZbDesk getZbde() {
		return zbde;
	}

	public void setZbde(ZbDesk zbde) {
		this.zbde = zbde;
	}

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
	 * 方法功能说明： 开始点餐
	 * 创建：2017-6-21 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public void orders(){
		List list = re.quertDesk();
		JSON json = toJson.toJson("js",list);
		HttpServletResponse hsp = ServletActionContext.getResponse();
		hsp.setContentType("text/html,charset=utf-8");
		
		hsp.setCharacterEncoding("utf-8");
		
		try {
			hsp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * 方法功能说明：  、、、、注册
	 * 创建：2017-6-20 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
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
	/**
	 * 
	 * 方法功能说明：     。。。。登录
	 * 创建：2017-6-21 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public String login(){
		
		
		int list = re.loginsel(zbud);
		System.out.println("liost:"+list);
		//JSON json = toJson.toJson("account",list );//转型
		HttpServletResponse hsr = ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();//获取请求
		System.out.println(list);
		hsr.setContentType("text/html,charset=utf-8");
		hsr.setCharacterEncoding("utf-8");
		List list1=dish.sel();
		request.setAttribute("dishList", list1);
		try {
			hsr.getWriter().print(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list==1){
			request.setAttribute("user", zbud.getAccount());
			return "list";
			
		}else{
			HttpServletRequest ht = ServletActionContext.getRequest();
			ht.setAttribute("na", "k");
			return "register";
			
		}
	}
	
	/**
	 * 
	 * 方法功能说明：查询帐号  
	 * 创建：2017-6-20 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
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
