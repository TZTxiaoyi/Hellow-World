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
		String kindname=(String) obj;
		String sql="select d.dishId,d.dishName,d.price,d.picture,d.kindId,k.kindName from dish d,kind k where d.kindId=k.kindId and d.dishState=19 and k.kindState=19 and k .kindName='"+kindname+"'";
		List list=DaoFactory.Query(sql);
		return list;
	}
	public List sel() {
		String sql="select d.dishId,d.dishName,d.price,d.picture,d.kindId,k.kindName from dish d,kind k where d.kindId=k.kindId and d.dishState=19 and k.kindState=19";
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
