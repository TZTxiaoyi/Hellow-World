package com.achaction;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.LYEmployId;
import com.entity.LYEmployee;
import com.utils.toJson;

public class LYInsertEmployaction {
	/*
	 * employee:Ա��ʵ���ഴ���Ķ���
	 * 
	 * employid��Ա���˺�ʵ���ഴ���Ķ���
	 * 
	 */
	
	private LYEmployee employee;
	private LYEmployId employId;
	private String putvalue;
	
	LYInsertEmployDao ied=new LYInsertEmployDao();
	
	
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
		response.setContentType("text/html;charset=GBK");
		response.setCharacterEncoding("GBK");
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
	 * delem:
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
	public void searchEM(){
		System.out.println(putvalue);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=GBK");
		response.setCharacterEncoding("GBK");
		System.out.println("hoihoh");
		List<String> list=ied.searchsome(putvalue);
		System.out.println(list);
		toJson json=new toJson();
		try {
			
			response.getWriter().print(json.toJson("value", list).toString());
			System.out.println(json.toJson("value", list).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public String getPutvalue() {
		return putvalue;
	}

	public void setPutvalue(String putvalue) {
		this.putvalue = putvalue;
	}
}
