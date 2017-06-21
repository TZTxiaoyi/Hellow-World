package com.achaction;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.SxmTable;
import com.logic.SxmTableSql;
import com.utils.toJson;

public class SxmTableAction {
	/**
	 * 
	     * 功能说明：  
	     * 创建：2017-6-15 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       st 实体类桌子
	     * @参数：       stname 实体类桌子名字
	     * sts 实例化SxmTableSql
	     * deskId 实体类桌子id
	     * search 快速查找输入框传的值
	     * pagestate 分页状态
	     * 
	     * @return void     
	     * @throws
	 */
	SxmTable st;
	String search;
	int currPage;

	
	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	
	SxmTableSql sts=new SxmTableSql();
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
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
		int state=sts.add(st);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		try {
			hsr.getWriter().print(state);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		int tname=sts.selTableName(st);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		try {
			hsr.getWriter().print(tname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 
	     * 方法功能说明：  后台进入桌位管理页面自动加载
	     * 创建：2017-6-16 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void tableAdmin(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		List list=sts.selTableAdmin(null);
		JSON json=toJson.toJson("aa", list);
		try {
			hsr.getWriter().print(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	     * 方法功能说明：  删除一行后动态刷新页面
	     * 创建：2017-6-17 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void delLineTable(){
		int tableid=sts.del(st);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		try {
			hsr.getWriter().print(tableid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	     * 方法功能说明：  修改一行数据表单里自动获取这一行的值
	     * 创建：2017-6-17 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void upLineTable(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		int table=sts.update(st);
		try {
			hsr.getWriter().print(table);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+3333);
		}
	}
	/**
	 * 
	     * 方法功能说明： 后台 快速查找
	     * 创建：2017-6-17 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void searchTable(){
		List ser=sts.selTable(search);
		JSON json=toJson.toJson("ss", ser);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+3333);
		}
	}
	/**
	 * 
	     * 方法功能说明： 前台 快速查找
	     * 创建：2017-6-17 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void indexTable(){
		List it=sts.serviceTable(search);
		JSON json=toJson.toJson("ss", it);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+3333);
		}
	}
	/**
	 * 
	     * 方法功能说明：  分页 自动刷新
	     * 创建：2017-6-19 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void tabPage(){
		List list=sts.page(currPage);
		JSON json=toJson.toJson("ss", list);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 
	     * 方法功能说明：  总条数
	     * 创建：2017-6-19 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public void pageTotal(){
		int total=sts.getCount();
		HttpServletResponse hsr=ServletActionContext.getResponse();
		try {
			hsr.getWriter().print(total);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
}
