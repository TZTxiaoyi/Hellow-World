package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.LjlAddOrder;
import com.entity.SxmTable;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.utils.DaoFactory;

public class LjlOrders implements DaoInterface{

/**
 * 下单插入数据库订单数据
 * @param order
 * @return
 */
	public int rsadd(Object order) {
		LjlAddOrder orders=(LjlAddOrder)order;
		// TODO Auto-generated method stub
		String sql="insert into orders values(?,?,?,?,?,?,?)";
		Object[] params=new Object[]{orders.getOrderStatus(),orders.getOrderPrice(),orders.getFoodNum(),orders.getCost(),orders.getOrdersTime(),orders.getDeskid(),0};
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
	/**
	 * 自动刷新显示当天订单已结未结状态
	 * 根据订单查询菜品订单表

	 * @param oId
	 * @return
	 */
	public List orderDish(int oId){
		String sql="select distinct d.deskName,o.ordersId,o.ordersTime,ds.dishName,o.FoodNum," +
				"ds.price,od.dishNnum,ds.dishId,od.dishStatus,od.addDish,od.dishtime,o.ordersPrice from  " +
				"desk_restaff d join orders o on d.deskId=o.deskId and o.ordersId="+oId+
				"join orders_dish od on o.ordersId=od.ordersId " +
				"join dish ds on ds.dishId=od.dishId";
		List list=DaoFactory.Query(sql);
		return list;
	}
	/**
	 * 根据订单获得订单数据
	 * @param orderid
	 * @return
	 */
	public List idselOrder(int orderid){
		String sql="select * from orders where ordersId="+orderid;
		return DaoFactory.Query(sql);
	}
	/**
	 * 根据订单改变订单菜品数量和总价
	 * @param order
	 * @return
	 */
	public int upOrdersPN(LjlAddOrder order){
		//System.out.println(order.getOrderPrice()+","+order.getFoodNum()+","+order.getOrdersId());
		String sql="update orders set ordersPrice=?,FoodNum=? where ordersId=?";
		Object[] params =new Object[] {order.getOrderPrice(),order.getFoodNum(),order.getOrdersId()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 根据订单号更新订单状态
	 * @return
	 */
	public int upOrders(Object order){
		LjlAddOrder ord=(LjlAddOrder)order;
		String sql="update orders set ordersStatus=16 where ordersId=? and ordersStatus=15";
		Object[] params = new Object[] {ord.getOrdersId()}; 
		return DaoFactory.Updata(sql, params);
		
	}
	public int upOP(int price,int orid){
		//System.out.println("price"+price+","+orid);
		String sql="update orders set ordersPrice=? where ordersId=?";
		Object[] params = new Object[] {price,orid}; 
		return DaoFactory.Updata(sql, params);
		
	}
	public int uporderdish(String foodtime,int dishid){
		//System.out.println("food:"+foodtime+"，"+dishid);
		String sql="update orders_dish set dishStatus=17 where dishtime=? and dishId=?";
		Object[] params = new Object[] {foodtime,dishid}; 
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 催菜 获取订单权重
	 * @param obj
	 * @return
	 */
	public List anxiousOrder(Object obj){
		LjlAddOrder ord=(LjlAddOrder)obj;
		String sql="select orderpriority from orders where ordersId="+ord.getOrdersId();
		return DaoFactory.Query(sql);
	}
	/**
	 * 催菜 权重+1
	 * @return
	 */
	public int proty(int pro,Object obj){
		LjlAddOrder ord=(LjlAddOrder)obj;
		String sql="update orders set orderpriority=? where ordersId=?";
		Object[] params = new Object[] {pro,ord.getOrdersId()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 根据桌子名字更新桌子状态
	 * @return
	 */
	public int updesk(Object dnam){
		SxmTable dname = (SxmTable) dnam;
		String sql="update desk set deskState=8 where deskName=?";
		Object[] params = new Object[] {dname.getDeskName()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 桌子详情里的清理桌台按钮；
	 * @param dnam
	 * @return
	 */
	public int clearDesk(Object dnam){
		SxmTable dname = (SxmTable) dnam;
		String sql="update desk set deskState=6 where deskName=? and deskState=8";
	
		Object[] params = new Object[] {dname.getDeskName()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 服务员界面的清理桌台按钮
	 * @return
	 */
	public int clearAllDesk(){
		String sql="update desk set deskState=6 where deskState=?";
		Object[] params = new Object[] {8};
		return DaoFactory.Updata(sql,params);
	}
	/**
	 * 整单取消按钮；
	 * @param ords
	 * @return
	 */
	public int allDelect(Object ords){
		LjlAddOrder ord=(LjlAddOrder) ords;
		String sql="update orders set ordersStatus=17 where ordersId=?";
		Object[] params=new Object[] {ord.getOrdersId()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 点击整单取消之后桌子状态更改为可用
	 */
	public int alterDeskstate(Object tstate){
		SxmTable tst = (SxmTable) tstate;
		String sql="update desk set deskState=6 where deskName=?";
		Object[] params = new Object[] {tst.getDeskName()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 点击整单取消查询订单菜品表里菜品的状态
	 */
	public List vagestate(int ords){
		String sql="select dishStatus from orders_dish where ordersId="+ords+" and (dishStatus=13 or dishStatus=14)";
		return DaoFactory.Query(sql);
	}
	/**
	 * 根据订单id改变菜的状态为17
	 * @param obj
	 * @param obj1
	 * @return
	 */
	public int alldel(Object obj){
		String sql="update orders_dish set dishStatus=17 where ordersId=?";
		LjlAddOrder addo=(LjlAddOrder) obj;
		Object[] params=new Object[]{addo.getOrdersId()};
		return DaoFactory.Updata(sql, params);
	}
	
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int add(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 
	 * 方法功能说明： 根据订单编号查询查询特定状态的订单信息
	 * 创建：2017-6-24 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param oId	订单号
	 * @参数： @param status 状态编号
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List selOrder(int oId,int status) {
		String sql ="select * from orders where ordersId = " + oId+" and ordersStatus = "+ status;
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * 方法功能说明：查询所有订单特定状态的订单信息  
	 * 创建：2017-6-24 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param status状态编号
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List selOrder(int status) {
		String sql ="select * from orders where ordersStatus = "+ status;
		return DaoFactory.Query(sql);
	}
}
