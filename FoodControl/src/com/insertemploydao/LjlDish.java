package com.insertemploydao;

import java.util.List;

import net.sf.json.JSON;

import com.daointerface.DaoInterface;
import com.entity.LjlAddFood;
import com.entity.LjlAddOrder;
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
	/**
	 * 根据菜品名称查菜品id
	 * @param obj
	 * @param obj1
	 * @return
	 */
	public List seldish(Object obj){
		LjlAddFood addf=(LjlAddFood) obj;
		String sql="select * from dish where dishName='"+addf.getFoodname()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * genju 菜品id查菜有没有做
	 */
	public List seldishstatus(int did){
		String sql="select dishStatus from orders_dish where dishId="+did;
		return DaoFactory.Query(sql);
	}
	/**
	 * 根据订单id和菜品id改变菜的状态为17
	 * @param obj
	 * @param obj1
	 * @return
	 */
	public int onedel(int did,Object obj){
		String sql="update orders_dish set dishStatus=17 where dishId=? and ordersId=?";
		LjlAddOrder addo=(LjlAddOrder) obj;
		Object[] params=new Object[]{did,addo.getOrdersId()};
		return DaoFactory.Updata(sql, params);
	}
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

}
