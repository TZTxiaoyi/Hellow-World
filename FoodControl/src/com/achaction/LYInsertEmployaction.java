package com.achaction;



import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
		List<String> list=ied.selemploy(employee);		
		toJson json=new toJson();		
		json.toJson("vlaue", list);		
		try {
			response.getWriter().print(json.toJson("vlaue", list).toString());
			//System.out.println(json.toJson("vlaue", list).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * 
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
}
