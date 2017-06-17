package com.logic;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.TztDishOrder;
import com.utils.DaoFactory;

/**
 * 
 * 
 * @�๦��˵����  �˺Ͷ�����ϵ������ݿ�Dao�ӿڵ�ʵ����
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-15 ����11:40:06  
 * @�汾��V1.0
 */
public class TztDishOrderImp implements DaoInterface{
	/**
	 * 
	 */
	public int add(Object obj) {
		TztDishOrder dishOrder=(TztDishOrder)obj;
		String sql ="insert into orders_dish values(?,?,?,?)";
		Object[] ob =new Object[]{dishOrder.getOrderId(),dishOrder.getDishId(),dishOrder.getDishStatus(),dishOrder.getDeskId()};
		return DaoFactory.Updata(sql, ob);
	}
	/**
	 * 
	 */
	public int del(Object obj) {
		TztDishOrder dishOrder=(TztDishOrder)obj;
		String sql ="delete from orders_dish where id=?";
		Object[] ob =new Object[]{dishOrder.getId()};
		return DaoFactory.Updata(sql, ob);
	}

	public List sel(Object obj) {
		TztDishOrder dishOrder=(TztDishOrder)obj;
		String sql="select * from orders_dish where id=?" ;
		Object [] ob=new Object[]{dishOrder.getId()};
		return DaoFactory.Query(sql);
	}
	public List sel() {
		String sql="select * from orders_dish";
		return DaoFactory.Query(sql);
	}

	public int update(Object obj) {
		TztDishOrder dishOrder=(TztDishOrder)obj;
		String sql="update orders_dish set	ordersId=?,dishId=?, dishSttaus=?  where id=?";
		Object[] ob = new Object[]{dishOrder.getOrderId(),dishOrder.getDeskId(),dishOrder.getDishStatus(),dishOrder.getId()};
		return DaoFactory.Updata(sql, ob);

	}
	public List queryMading(){
		String sql="select  d.dishName ,count (*)  from orders_dish od,dish d where dishStatus = 12 and od.dishId=d.dishId group by d.dishName";
		return DaoFactory.Query(sql);
	}

}
