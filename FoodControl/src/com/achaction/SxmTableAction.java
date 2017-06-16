package com.achaction;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.SxmTable;
import com.logic.SxmTableSql;

public class SxmTableAction {
	SxmTable st;
	String stname;
	SxmTableSql sts=new SxmTableSql();
	private Object request;
	public String getStname() {
		return stname;
	}

	public void setStname(String stname) {
		this.stname = stname;
	}

	public SxmTable getSt() {
		return st;
	}

	public void setSt(SxmTable st) {
		this.st = st;
	}
	/**
	 * 
	     * 方法功能说明：  添加桌子
	     * 创建：2017-6-15 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void appendTable(){
		sts.add(st);
	}
	/**
	 * 
	     * 方法功能说明：  查询桌子名是存在
	     * 创建：2017-6-15 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void equalTable(){
		int tname=sts.selTableName(stname);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		try {
			hsr.getWriter().print(tname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void TableAdmin(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		Map map=sts.selTableAdmin(null);
		System.out.println(map);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		try {
			hsr.getWriter().print(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
