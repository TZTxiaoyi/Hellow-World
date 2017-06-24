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
		System.out.println(dishOrder.getOrderId()+","+dishOrder.getDishId()+","+dishOrder.getDishStatus()+","+dishOrder.getDeskId()+","+dishOrder.getDishNum());
		String sql ="insert into orders_dish values(?,?,?,?,?)";
		Object[] ob =new Object[]{dishOrder.getOrderId(),dishOrder.getDishId(),dishOrder.getDishStatus(),dishOrder.getDeskId(),dishOrder.getDishNum()};
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
	/**
	 * 
	 * 方法功能说明： 查找所有的订单点菜表 
	 * 创建：2017-6-22 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List sel() {
		String sql="select * from orders_dish";
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * 方法功能说明：查找菜肴最大并菜数量前提下的制作中或者待制作的比较早下单的菜  
	 * 创建：2017-6-22 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param vv
	 * @参数： @param cc
	 * @参数： @param madedish
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List selectMax(int cc,List madedish){
		int  top= (Integer) madedish.get(7);
		int id =	(Integer) madedish.get(0);
		String sql =" select  top "+top+" id from orders_dish where dishId ="+id+"and dishStatus= "+cc;
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * 方法功能说明：  
	 * 创建：2017-6-22 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param vv
	 * @参数： @param madedish
	 * @参数： @param cc
	 * @参数： @return      
	 * @return int     
	 * @throws
	 */
	public int changeDish( int vv ,List madedish,int cc){
		int  top= (Integer) madedish.get(7);
		int id =	(Integer) madedish.get(0);
		String sql="update orders_dish set dishStatus=? where id  in" +
				"( select  top "+top+" id from orders_dish where dishId ="+id+"and dishStatus= "+cc+ ") ";
		Object[] obj = new Object[]{vv};
		return DaoFactory.Updata(sql, obj);
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
		String sql="select  d.dishId,d.dishName ,count (*)  from orders_dish od,dish d where dishStatus = 12 and od.dishId=d.dishId group by d.dishName,d.dishId ";
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
	/**
	 * 
	 * 方法功能说明： 查询订单菜肴表中菜肴所对应的桌号 
	 * 创建：2017-6-22 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param list
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public  List queryDishTable(List list){
		String str="";
		for(int i =0;i<list.size();i++){
			str= str+((List) list.get(i)).get(0)+",";
		}
		str=str.substring(0,str.length()-1);
		String sql="select deskName from desk  where deskId in (select deskId from orders_dish where id in("+ str +"))" ;
		return DaoFactory.Query(sql);
	}
}
