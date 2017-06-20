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
	 * employee:员工实体类创建的对象
	 * 
	 * employid：员工账号实体类创建的对象；
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
	 * save:得到响应后，
	 * 调用员工实现类方法
	 * 将员工实体类对象传给员工实现类方法
	 * 
	 */
	public void save(){		
		
		ied.eminsert(employee);	
		
	}
	/**
	 * emterid：得到前端响应，调用enterid方法，
	 * 调用Dao实现类方法
	 * 将员工账号的实体类对象传给插入员工账号的实现类方法
	 */
	public void enterid(){
		ied.emidinsert(employId);
	}
	/**
	 * 
	     * 方法功能说明：  将员工信息放到list中，
	     * 再将list放入json中，
	     * 再有前台data接收json，遍历json
	     * 创建：2017-6-15 by Administrator   
	     * 修改：日期 by 
	     * 修改内容：  
	     * @参数：       
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
