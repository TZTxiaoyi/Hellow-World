package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.LjlAddOrder;
import com.utils.DaoFactory;

public class LjlOrders implements DaoInterface{


	public int rsadd(Object order) {
		LjlAddOrder orders=(LjlAddOrder)order;
		// TODO Auto-generated method stub
		String sql="insert into orders values(?,?,?,?,?,?)";
		Object[] params=new Object[]{orders.getOrderStatus(),orders.getOrderPrice(),orders.getFoodNum(),orders.getCost(),orders.getOrdersTime(),orders.getDeskid()};
		return DaoFactory.rsUpdata(sql,params);
	}

	public int del(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List sel(Object obj) {
		// TODO Auto-generated method stub
		String sql="select ordersStatus from orders";
		List list=DaoFactory.Query(sql);
		return list;
	}
	/**
	 * 自动刷新显示当天订单已结未结状态
	 * @param t1
	 * @param t2
	 * @return
	 */
	public List selOrder(String t1,String t2) {
		// TODO Auto-generated method stub
		String sql="select ordersStatus from orders where ordersTime>'"+t1+"' and ordersTime<'"+t2+"'";
		List list=DaoFactory.Query(sql);
		return list;
	}
	public List orderDish(int oId){
		String sql="select d.deskName,o.ordersId,o.ordersTime,ds.dishName,o.FoodNum,ds.price from  " +
				"desk_restaff d join orders o on d.deskId=o.deskId and o.ordersId="+oId+
				"join orders_dish od on o.ordersId=od.ordersId " +
				"join dish ds on ds.dishId=od.dishId";
		List list=DaoFactory.Query(sql);
		return list;
	}
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
}
