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
	     * ����˵����  
	     * ������2017-6-15 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       st ʵ��������
	     * @������       stname ʵ������������
	     * sts ʵ����SxmTableSql
	     * deskId ʵ��������id
	     * search ���ٲ�������򴫵�ֵ
	     * pagestate ��ҳ״̬
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
		List list=sts.seltabid(st);
		List li=(List) list.get(0);
		int tabid=(Integer) li.get(0);//��ȡ����id
		//��������id,Ա��id��������Ա����
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
	 * @throws ParseException 
	 
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
	     * ��������˵���� ��̨ ���ٲ���
	     * ������2017-6-17 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	     * ��������˵���� ǰ̨ ���ٲ���
	     * ������2017-6-17 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	     * ��������˵����  ��ҳ �Զ�ˢ��
	     * ������2017-6-19 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	     * ��������˵����  ������
	     * ������2017-6-19 by Administrator   
	     * �޸ģ����� by songxianmeng
	     * �޸����ݣ�  
	     * @������       
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
	 * ������̨
	 */
	public void changedesk(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		//���ݸ���ǰ��������ȡ����id
		System.out.println("ǰ����"+st.getDeskName());
		List beforelist=sts.getbeforeid(st);
		List beforeli=(List) beforelist.get(0);
		int getbeid=(Integer) beforeli.get(0);
		System.out.println("b"+getbeid);
		//���ݸ������������ȡid
		System.out.println("������"+tablename);
		List list=sts.gettableid(tablename);
		List li=(List) list.get(0);
		int getid=(Integer) li.get(0);
		System.out.println("a"+getid);
		//���ݸ���ǰ���ӵ�id��ȡ����id
		List getorderid=sts.getorderid(getbeid);
	
		List getoid=(List) getorderid.get(getorderid.size()-1);
		System.out.println("getoid"+getoid);
		int orderid=(Integer) getoid.get(0);
		System.out.println("orderid"+orderid);
		int chaid=-1;
		int castate=-1;
		int aftercastate=-1;
		if(getoid.size()!=0){
			//���ݶ���id�����Ӹ���Ϊ���ĺ��
			chaid=sts.changeid(getid, orderid);
			//���ݸ���ǰ��������������״̬Ϊ����
			castate=sts.changedstate(st);
			//���ݸ���ǰ��������������״̬Ϊռ��
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
