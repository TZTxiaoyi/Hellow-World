package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.TztDishOrder;
import com.utils.DaoFactory;

/**
 * 
 * 
 * @类功能说明：  菜和订单关系表的数据库Dao接口的实现类
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-15 下午11:40:06  
 * @版本：V1.0
 */
public class TztDishOrderImp implements DaoInterface{
	/**
	 * 
	 */
	public int add(Object obj) {
		TztDishOrder dishOrder=(TztDishOrder)obj;
		System.out.println(dishOrder.getOrderId()+","+dishOrder.getDishId()+","+dishOrder.getDishStatus()+","+dishOrder.getDeskId());
		String sql ="insert into orders_dish values(?,?,?,?)";
		Object[] ob =new Object[]{dishOrder.getOrderId(),dishOrder.getDishId(),dishOrder.getDishStatus(),dishOrder.getDeskId()};
		return DaoFactory.Updata(sql, ob);
	}
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
	/**
	 * 
	 * 方法功能说明：  查询需要制作的菜品
	 * 创建：2017-6-17 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List queryMade(){
		String sql="select  d.dishId,d.dishName ,count (*)  from orders_dish od,dish d where dishStatus = 12 and od.dishId=d.dishId group by d.dishName,d.dishId";
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * 方法功能说明： 查询正在制作的菜品 
	 * 创建：2017-6-17 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List queryMading()	{
		String sql ="select  d.dishId,d.dishName ,count (*)  from orders_dish od,dish d where dishStatus = 13 and od.dishId=d.dishId group by d.dishName,d.dishId";
		return DaoFactory.Query(sql);
	}
}
