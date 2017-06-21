package com.achaction;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.LYEmployId;
import com.entity.LYEmployee;
import com.logic.LYInsertEmployDao;
import com.utils.toJson;

public class LYInsertEmployaction {
	/*
	 * employee:Ա��ʵ���ഴ���Ķ���
	 * 
	 * employid��Ա���˺�ʵ���ഴ���Ķ���
	 * 
	 * putvalue(��ǰ�����)�����մ���Ϊstring���͵�ֵ��
	 * 
	 * countp  age(��ǰ�����)�����մ���Ϊint���͵�ֵ
	 */	
	private LYEmployee employee;
	private LYEmployId employId;
	private String putvalue;
	private int countpage;
	/**
	 * LYInsertEmployDao��ʵ����
	 * 
	 * ied:ʵ������󣬿��Ե���ʵ����ķ���
	 */
	LYInsertEmployDao ied=new LYInsertEmployDao();
	
	/**
	 * һϵ��set��get����
	 * @return
	 */
	public int getCountpage() {
		return countpage;
	}

	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
	public LYEmployId getEmployId() {
		return employId;
	}

	public void setEmployId(LYEmployId employId) {
		this.employId = employId;
	}	
	public LYEmployee getEmployee(){
		return employee;
	}
	public void setEmployee(LYEmployee employee) {
		this.employee = employee;
	}
	public String getPutvalue(){
		return putvalue;
	}
	public void setPutvalue(String putvalue) {
		this.putvalue = putvalue;
	}
	
	
	
	/**
	 * save:�õ���Ӧ��
	 * ����Ա��ʵ���෽��
	 * ��Ա��ʵ������󴫸�Ա��ʵ���෽��
	 * 
	 */
	public void save(){		
		
		ied.eminsert(employee);	
		
	}
	/**
	 * emterid���õ�ǰ����Ӧ������enterid������
	 * ����Daoʵ���෽��
	 * ��Ա���˺ŵ�ʵ������󴫸�����Ա���˺ŵ�ʵ���෽��
	 */
	public void enterid(){
		ied.emidinsert(employId);
	}
	   /**
		 * 
	     * ��������˵����  ��Ա����Ϣ�ŵ�list�У�
	     * �ٽ�list����json�У�
	     * ����ǰ̨data����json������json
	     * ������2017-6-15 by Administrator   
	     * �޸ģ����� by 
	     * �޸����ݣ�  
	     * @������       
	     * @return void     
	     * @throws
	   */
	public void selem(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<String> list=ied.selemploy(employee);		
		toJson json=new toJson();
		//System.out.println(list.size());
		json.toJson("vlaue", list);	
		//System.out.println(json.toJson("vlaue", list).toString());
		try {
			response.getWriter().print(json.toJson("vlaue", list).toString());
			//System.out.println(json.toJson("vlaue", list).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * delem:ɾ��Ա��action
	 */
	public void delem(){
		int flag=ied.delone(employee);
		 HttpServletResponse response=ServletActionContext.getResponse();		 
		 try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * updatestaff:�޸�Ա����Ϣ��action
	 * �õ�Ա��dao�������ظ��޸�Ա��ʵ�����ֵ��
	 * �ٽ�ֵ��ǰ̨���ж��Ƿ��޸ĳɹ����
	 * @return
	 */
	public int updatestaff(){
		int flag=9;
		return flag=ied.update(employee);	
	}
	/**
	 * searchEM:ģ����ѯaction
	 */
	public void searchEM(){		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List<String> list=ied.searchsome(putvalue);
		//System.out.println(list);
		toJson json=new toJson();
		try {			
			response.getWriter().print(json.toJson("value", list).toString());			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * getusername:��̨��¼��֤action
	 * �õ�ʵ���෵�ظ���listֵ���ж�list�ĳ��ȣ�������ҵ���ƥ��ĵ�ֵ��
	 * list�ĳ���һ��Ϊ1������Ҳ�����list�ĳ��Ⱦ�Ϊ1
	 * ���Ϊ1�����û���������������success��struts���գ�������̨��ҳ����մ���ֵ
	 * �����Ϊ1����cuo��Ϣ���棬����false,struts���գ��ɺ�̨��¼������մ�����Ϣ��Ȼ�������жϣ�����������Ϣ
	 * @return
	 */
	public String getusername(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//request.getSession().setAttribute("username", employId.getEmenter());		
		List list = ied.selectemid(employId);
		if (list.size()==1) {
			request.setAttribute("username", employId.getEmenter());			
			return "success";
		}else {
			request.setAttribute("cuo", "haha");
			return "false" ;
		}	
	}
	/**
	 * getcount:���Ա������������action
	 */
	public void getcount(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=ied.getallpage();
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		} 		
	} 
	/**
	 * getpage:��ǰ̨data������ֵ��countpage���գ�����pagepage(ʵ���෽��)
	 * �õ�����list������ѯ�Ľ���ŵ�json�У����ظ�ǰ̨data
	 */
	public void getpage(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=ied.pagepage(countpage);
		JSON json=toJson.toJson("value", list);
		//System.out.println(json);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
