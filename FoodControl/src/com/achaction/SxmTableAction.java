package com.achaction;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.processors.JsonBeanProcessor;

import org.apache.struts2.ServletActionContext;

import sun.awt.SunToolkit.InfiniteLoop;

import com.entity.LYEmployee;
import com.entity.SxmTable;
import com.insertemploydao.SxmTableSql;
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
	LYEmployee em;
	String chargename;
	String tablename;
	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getChargename() {
		return chargename;
	}

	public void setChargename(String chargename) {
		this.chargename = chargename;
	}

	public LYEmployee getEm() {
		return em;
	}

	public void setEm(LYEmployee em) {
		this.em = em;
	}


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
		List list=sts.seltabid(st);
		List li=(List) list.get(0);
		int tabid=(Integer) li.get(0);//获取桌子id
		//根据桌子id,员工id插入桌子员工表
		int aa=sts.insertstaff(tabid,em.getEmid());
		int flag=-1;
		if(state!=-1 && aa!=-1){
			flag=1;
		}
		try {
			hsr.getWriter().print(flag);
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
	 * @throws ParseException 
	 
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
		JSON json=toJson.toJson("ss", list);
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+3333);
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
		int tname=-1;
		/*List list=(List) sts.updateper(em);
		System.out.println("list"+list);
		List li=(List) list.get(0);
		int emp=(Integer) li.get(0);	*/
		tname=sts.uppertab(st,em.getEmid());
		int flag=-1;
		if(table!=-1&&tname!=-1){
			flag=1;
		}
		System.out.println(flag);
		try {
			hsr.getWriter().print(flag);
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
		System.out.println("curr"+currPage);
		List ser=sts.selTable(currPage,search);
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
			System.out.print(json);
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
		JSON json=toJson.toJsonArray("ss", list);
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
		int total=sts.getCount(search);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		try {
			hsr.getWriter().print(total);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	/**
	 * 更改桌台
	 */
	public void changedesk(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		//根据更换前的桌名获取桌子id
		System.out.println("前桌名"+st.getDeskName());
		List beforelist=sts.getbeforeid(st);
		List beforeli=(List) beforelist.get(0);
		int getbeid=(Integer) beforeli.get(0);
		System.out.println("b"+getbeid);
		//根据更换后的桌名获取id
		System.out.println("后桌名"+tablename);
		List list=sts.gettableid(tablename);
		List li=(List) list.get(0);
		int getid=(Integer) li.get(0);
		System.out.println("a"+getid);
		//根据更改前桌子的id获取订单id
		List getorderid=sts.getorderid(getbeid);
	
		List getoid=(List) getorderid.get(getorderid.size()-1);
		System.out.println("getoid"+getoid);
		int orderid=(Integer) getoid.get(0);
		System.out.println("orderid"+orderid);
		int chaid=-1;
		int castate=-1;
		int aftercastate=-1;
		if(getoid.size()!=0){
			//根据订单id将桌子更改为更改后的
			chaid=sts.changeid(getid, orderid);
			//根据更换前的桌名更改桌子状态为可用
			castate=sts.changedstate(st);
			//根据更换前的桌名更改桌子状态为占用
			aftercastate=sts.changeafterdstate(tablename);
		}
		
		int flag=-1;
		if(chaid!=-1 && castate!=-1 && aftercastate!=-1){
			flag=1;
		}
		try {
			hsr.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
}
