package com.insertemploydao;

import java.util.List;

import net.sf.json.JSON;

import com.daointerface.DaoInterface;
import com.utils.DaoFactory;
import com.utils.toJson;

public class LjlDish implements DaoInterface{

	public int add(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int del(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List sel(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	public List sel() {
		String sql="select * from dish";
		List list=DaoFactory.Query(sql);
		return list;
	}
	public List seldishName(String dishname) {
		
		String sql="select * from dish where dishName='"+dishname+"'";
		List list=DaoFactory.Query(sql);
		return list;
	}
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
