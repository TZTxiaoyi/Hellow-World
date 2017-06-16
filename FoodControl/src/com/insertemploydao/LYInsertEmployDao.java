package com.insertemploydao;


import com.entity.LYEmployId;
import com.entity.LYEmployee;

import com.utils.DaoFactory;

public class LYInsertEmployDao {
	
	
	public int eminsert(LYEmployee em){
		String sql="insert into staffinfo values(?,?,?,?,?,?,?,?)";
		Object[] params=new Object[]{em.getEmid(),em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),em.getEmpartid()};		
		return DaoFactory.Updata(sql, params);	
	}
	public int emidinsert(LYEmployId eld){
		System.out.println("sssss");
		String sql="insert into staffEnter values(?,?)";
		Object[] params = new Object[]{eld.getEmenter(),eld.getEmenter()};
		return DaoFactory.Updata(sql, params);
	}
}
