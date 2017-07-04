package com.insertemploydao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.GJYFoodCategory;

import com.utils.DaoFactory;

public class GJYInsertFoodcategory {
	
	
	/*删除数据*/
	public int delect(GJYFoodCategory FC){
		System.out.println("delect");
		String sql="update dish set dishState=20 where dishId=?";
		System.out.println(FC.getDishId());
		Object[] params=new Object[]{FC.getDishId()};
		return DaoFactory.Updata(sql, params);	
	}
	
	
	
	/*插入数据*/
	public int FCinsert(GJYFoodCategory FC){
		String sql="insert into dish values(?,?,?,?,?,?,?,?)";
		Object[] params=new Object[]{FC.getDishName(),FC.getPrice(),FC.getKindId(),FC.getMakeTime(),FC.getPriority(),FC.getPictureName(),FC.getMaxCopies(),FC.getDishState()};
		return DaoFactory.Updata(sql, params);	
	}
	
	
	/*查询数据*/
	public List sekFood(int curr,String ser) {
		String sql ="select top(5)* from (select * from dish_kind d1 where " +
				" d1.dishId like '%"+ser+"%' or  d1.dishName like'%"+ser+
				"%' or d1.price like '%"+ser+"%' or d1.makeTime like'%"+ser+
				"%' or d1.priority like'%"+ser+"%' or d1.maxCopies like '%"+
				ser+"%' or d1.kindName " +"like '%"+ser+"%') ss where " +
				"ss.dishId not in (select top ("+curr+"*5 ) d.dishId " +
				"from dish_kind d where d.dishId like '%"+ser+
				"%' or  d.dishName like'%"+ser+"%' or d.price like " +
				"'%"+ser+"%' or d.makeTime like'%"+ser+"%' or " +
				"d.priority like'%"+ser+"%' or d.maxCopies like '%"+ser+
				"%' or d.kindName like '%"+ser+"%')";	
		List list = DaoFactory.Query(sql);
		return list;
	
	}

	/*修改数据*/
	public int Change(GJYFoodCategory FC){
		String sql="update dish set dishName=?,Price=?,kindId=?,makeTime=?,priority=?,picture=?,maxCopies=?,dishState=? where dishId=?";
		Object[] params=new Object[]{FC.getDishName(),FC.getPrice(),FC.getKindId(),FC.getMakeTime(),FC.getPriority(),FC.getPictureName(),FC.getMaxCopies(),FC.getDishState(),FC.getDishId()};
		return DaoFactory.Updata(sql, params);	
		
	}
	
	
	
	
	/*获取分页总数*/
	public int getallpage(String ser){
		String sql="select count(*) from dish_kind d1 where " +
				" d1.dishId like '%"+ser+"%' or  d1.dishName like'%"+ser+
				"%' or d1.price like '%"+ser+"%' or d1.makeTime like'%"+ser+
				"%' or d1.priority like'%"+ser+"%' or d1.maxCopies like '%"+
				ser+"%' or d1.kindName " +
				"like '%"+ser+"%'";
		List list =DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		int li=(Integer) list1.get(0);
		return li;
	}
	
	/*显示分页数据*/
	public List pagepage(int startIndex){
		String sql="select top(5)* from dish_kind dk where " +
				" dk.dishId not in(select top("+startIndex+"*5)" +
						" dishId from dish_kind)";
		return DaoFactory.Query(sql);
	}


	public List getselect(GJYFoodCategory FC){
		
		String sql="select kindId,kindName from kind where kindState=19 order by kindId asc";

		return DaoFactory.Query(sql);
		
	}


}


