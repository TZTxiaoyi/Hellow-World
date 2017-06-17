package com.achaction;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.SxmTable;
import com.logic.SxmTableSql;
import com.utils.toJson;

public class SxmTableAction {
	/**
	 * 
	     * ����˵����  
	     * ������2017-6-15 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       st ʵ��������
	     * @������       stname ʵ������������
	     * sts ʵ����SxmTableSql
	     * deskId ʵ��������id
	     * search ���ٲ�������򴫵�ֵ
	     * @return void     
	     * @throws
	 */
	SxmTable st;
	String search;
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
	     * ��������˵����  �������
	     * ������2017-6-15 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	     * ��������˵����  ��ѯ�������Ǵ���
	     * ������2017-6-15 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	 * 
	     * ��������˵����  ��̨������λ����ҳ���Զ�����
	     * ������2017-6-16 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
	     * @return void     
	     * @throws
	 */
	public void tableAdmin(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		Map map=sts.selTableAdmin(null);
		try {
			hsr.getWriter().print(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	     * ��������˵����  ɾ��һ�к�̬ˢ��ҳ��
	     * ������2017-6-17 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	     * ��������˵����  �޸�һ�����ݱ����Զ���ȡ��һ�е�ֵ
	     * ������2017-6-17 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	     * ��������˵����  ���ٲ���
	     * ������2017-6-17 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
	     * @return void     
	     * @throws
	 */
	public void searchTable(){
		System.out.println("----------");
		List ser=sts.selTable(search);
		
		JSON json=toJson.toJson("ss", ser);
		System.out.println(json);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		//System.out.println(json);
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+3333);
		}
	}
}
