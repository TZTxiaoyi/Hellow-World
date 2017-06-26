package com.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.GJYFoodCategory;

import com.utils.DaoFactory;

public class GJYInsertFoodcategory {
	
	public int FCinsert(GJYFoodCategory FC){
		System.out.println("fcinsert");
		String sql="insert into dish values(?,?,?,?,?,?,?,?)";
		Object[] params=new Object[]{FC.getDishName(),FC.getPrice(),FC.getKindId(),FC.getMakeTime(),FC.getPriority(),FC.getDishName(),FC.getMaxCopies(),FC.getDishState()};
		return DaoFactory.Updata(sql, params);	
	}
	
	public List FCFindAll(){
		System.out.println("ssss");
		String sql="select d1.dishId,d1.dishName,d1.price,k1.kindName,d1.makeTime,d1.priority,d1.picture,d1.maxCopies,d1.dishState from kind k1,dish d1 where k1.kindId=d1.kindId";
		System.out.println("hhhhh");
		List list=DaoFactory.Query(sql);
		return list;
	}
	
	public List sekFood(String ser) {
		String sql = "select * from dish where dishId like'%"+ser+"%' or dishName like'%"+ser+"%' or price like'%"+ser+"%' or kindId like'%"+ser+"%' or makeTime like'%"+ser+"%' or priority like'%"+ser+"%'or picture like'%"+ser+"%'or maxCopies like'%"+ser+"%'";
		List list = DaoFactory.Query(sql);
		return list;
	}

}	
	

