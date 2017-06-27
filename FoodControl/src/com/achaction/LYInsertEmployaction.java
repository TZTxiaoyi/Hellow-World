package com.achaction;



import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSON;
import org.apache.struts2.ServletActionContext;
import com.entity.LYEmployId;
import com.entity.LYEmployee;
import com.insertemploydao.LYInsertEmployDao;

import com.utils.toJson;

public class LYInsertEmployaction {
	/*
	 * employee:员工实体类创建的对象
	 * 
	 * employid：员工账号实体类创建的对象；
	 * 
	 * putvalue(当前类变量)：接收传来为string类型的值，
	 * 
	 * countp  age(当前类变量)：接收传来为int类型的值
	 */	
	private LYEmployee employee;
	private LYEmployId employId;
	private String putvalue;
	private int countpage;
	/**
	 * LYInsertEmployDao：实现类
	 * 
	 * ied:实现类对象，可以调用实现类的方法
	 */
	LYInsertEmployDao ied=new LYInsertEmployDao();
	
	/**
	 * 一系列set、get方法
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
	 * save:得到响应后，
	 * 调用员工实现类方法
	 * 将员工实体类对象传给员工实现类方法
	 * 
	 */
	public void save(){		
		
		ied.eminsert(employee);	
		
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
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		List<String> list=ied.selemploy(employee);		
		toJson json=new toJson();
	
		json.toJson("vlaue", list);	
	
		try {
			response.getWriter().print(json.toJson("vlaue", list).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * delem:删除员工action
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
	public void updatestaff(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int flag=9;
		flag=ied.update(employee);		
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		} 	
	}
	/**
	 * searchEM:模糊查询action
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
	 * getcount:获得员工表数据条数action
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
	 * getpage:由前台data传来的值，countpage接收，调用pagepage(实现类方法)
	 * 得到返回list，将查询的结果放到json中，返回给前台data
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
	/**
	 * modul:权限表action
	 
	public void modul(){		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	
		List list = ied.aperson();	
		JSON json=toJson.toJson("value", list);		
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}*/
}
