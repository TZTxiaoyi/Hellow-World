package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.TztDishOrder;
import com.sun.org.apache.xerces.internal.util.Status;
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
	 * ��������˵���� �������еĶ�����˱� 
	 * ������2017-6-22 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return List     
	 * @throws
	 */
	public List sel() {
		String sql="select * from orders_dish";
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * ��������˵��������order_dish���еĶ�Ӧ״̬�Ĳ���
	 * ������2017-6-22 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param vv
	 * @������ @param cc
	 * @������ @param madedish
	 * @������ @return      
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
	 * ��������˵���� ��ѯ�������ȱ��в�������Ӧ������ 
	 * ������2017-6-22 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param list
	 * @������ @return      
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
	 * ��������˵����  ��ѯ����״̬�µĲ�Ʒ���ȼ����ڵ�һЩ��Ϣ
	 * ������2017-6-24 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param status ״̬���
	 * @������ @return      
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
	 * ��������˵����  �޸Ķ�ӦID�µĲ�Ʒ״̬
	 * ������2017-6-26 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param status
	 * @������ @param id      
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
	 * ��������˵����   ͨ�����odID��ѯDIsh�������Ϣ
	 * ������2017-6-26 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param dishID
	 * @������ @return      
	 * @return List     
	 * @throws
	 */
	public List queryDishMax(String dishID){
		String sql="select * from dish d,orders_dish od where od.id in("+ dishID+") and d.dishId=od.dishId ";
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * ��������˵����  ͨ�����orders_dish ID ��ѯ������Ϣ
	 * ������2017-6-26 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param dishId
	 * @������ @return      
	 * @return List     
	 * @throws
	 */
	public List queryDesk(String dishId){
		String sql= "select * from orders_dish od,desk d where od.id in("+ dishId+") and od.deskId= d.deskId";
		return DaoFactory.Query(sql);
	}
}
