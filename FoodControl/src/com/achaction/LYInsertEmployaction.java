package com.achaction;



import com.entity.LYEmployId;
import com.entity.LYEmployee;
import com.insertemploydao.LYInsertEmployDao;

public class LYInsertEmployaction {
	/*
	 * employee:Ա��ʵ���ഴ���Ķ���
	 * 
	 * employid��Ա���˺�ʵ���ഴ���Ķ���
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
	/*
	 * save():
	 * 
	 */
	public void save(){		
		
		ied.eminsert(employee);		
	}
	/*
	 * enterid():
	 * 
	 */
	public void enterid(){
		ied.emidinsert(employId);
	}
	
}
