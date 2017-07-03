package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.utils.DaoFactory;

public class LjlKind implements DaoInterface {

	public int add(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int del(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List sel(Object obj) {
		String sql="select * from kind where kindState=19";
		return DaoFactory.Query(sql);
	}

	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
