package com.achaction;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.SxmTable;
import com.logic.SxmTableSql;

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
	     * @return void     
	     * @throws
	 */
	SxmTable st;
	SxmTableSql sts=new SxmTableSql();
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
	public void delLineTable(){
		int tableid=sts.del(st);
		HttpServletResponse hsr=ServletActionContext.getResponse();
		System.out.println(tableid);
		try {
			hsr.getWriter().print(tableid);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
