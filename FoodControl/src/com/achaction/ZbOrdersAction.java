package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.ZbDetails;
import com.insertemploydao.ZbRegister;
import com.utils.toJson;

public class ZbOrdersAction {
	
	private int orderD;//
	int currpage;
	ZbRegister re=new ZbRegister();
	public ZbRegister getRe() {
		return re;
	}
	public void setRe(ZbRegister re) {
		this.re = re;
	}
	ZbDetails zbde = new ZbDetails();
	
	public ZbDetails getZbde() {
		return zbde;
	}
	public void setZbde(ZbDetails zbde) {
		this.zbde = zbde;
	}
	ZbRegister zbre=new ZbRegister();
	public int getOrderD() {
		return orderD;
	}
	public void setOrderD(int orderD) {
		this.orderD = orderD;
	}
	public void ZbOrder(){
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		List list =zbre.zbordersInfo(orderD);
		
		JSON json = toJson.toJson("toj", list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void zbDeskQu(){
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		
		List list = zbre.ZbOrderss(zbde);
		System.out.println("dfsf"+list);
		JSON json = toJson.toJson("jsn", list);
		System.out.println(json);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void orders(){				
		List list = re.zbSelectDesk();
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
	 * 方法功能说明：  		总条数
	 * 创建：2017-7-1 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void zbtotalpage(){
		int total = re.getCount1();
		
		HttpServletResponse resp = ServletActionContext.getResponse();
		
		try {
			resp.getWriter().print(total);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void zbtabpage1(){
		
		List list = re.page1(currpage);
		JSON json = toJson.toJson("jj", list);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
}
}
