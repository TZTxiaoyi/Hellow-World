package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.TztDishOrder;
import com.sun.org.apache.xerces.internal.util.Status;
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
	 * 方法功能说明：查找order_dish表中的对应状态的菜肴
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
	public List selectMax(int status){
		String sql =" select * from orders_dish where dishStatus ="+status;
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
	
	/**
	 * 
	 * 方法功能说明：  查询需求状态下的菜品优先级在内的一些信息
	 * 创建：2017-6-24 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param status 状态编号
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List queryDishpriority( int status){
		String sql="select od.id,od.ordersId,od.dishId,od.dishStatus,od.deskId ,"+
				"o.orderpriority ,d.priority ,d.makeTime,d.dishName from orders_dish od ,orders o ,dish d "+
				"where od.ordersId =o.ordersId and d.dishId= od.dishId and od.dishStatus=" +status;
		return DaoFactory.Query(sql);
	}
	
	/**
	 * 
	 * 方法功能说明：  修改对应ID下的菜品状态
	 * 创建：2017-6-26 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param status
	 * @参数： @param id      
	 * @return void     
	 * @throws
	 */
	public void updataDishStatus(int status,String id){
	String	sql="update orders_dish set dishStatus=? where id in ("+ id +")";
	Object[] obj=new Object[]{ status };
	DaoFactory.Updata(sql, obj);
	}
	
	/**
	 * 
	 * 方法功能说明：   通过多个odID查询DIsh的相关信息
	 * 创建：2017-6-26 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param dishID
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List queryDishMax(String dishID){
		String sql="select * from dish d,orders_dish od where od.id in("+ dishID+") and d.dishId=od.dishId ";
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * 方法功能说明：  通过多个orders_dish ID 查询基本信息
	 * 创建：2017-6-26 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param dishId
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List queryDesk(String dishId){
		String sql= "select * from orders_dish od,desk d where od.id in("+ dishId+") and od.deskId= d.deskId";
		return DaoFactory.Query(sql);
	}
}
