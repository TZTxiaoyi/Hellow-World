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
	 * employee:员工实体类创建的对象
	 * 
	 * employid：员工账号实体类创建的对象；
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
	 * updatestaff:修改员工信息的action
	 * 得到员工dao工厂返回给修改员工实现类的值，
	 * 再将值给前台可判断是否修改成功与否；
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
