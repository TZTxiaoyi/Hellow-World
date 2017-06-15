package com.insertemploy;

import com.insertemploydao.InsertEmployDao;

public class InsertEmploy {
	private Employee employee;
	
	public Employee getEmployee(){
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String execute(){
		
		InsertEmployDao ied=new InsertEmployDao();
		System.out.println("aaa"+employee.getEmid());
		ied.eminsert(employee.getEmid(), employee.getEmname(), employee.getEmsex(), employee.getEmage(), employee.getEmphone(), employee.getEmpart(), employee.getEmadress(), employee.getEmjointime(), employee.getEmpartid());
		return null;
	}
}
