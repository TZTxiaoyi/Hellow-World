package com.insertemploydao;

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
	 * ��������˵�������Ҳ�����󲢲�����ǰ���µ������л��ߴ������ıȽ����µ��Ĳ�  
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
	public List selectMax(int cc,List madedish){
		int  top= (Integer) madedish.get(7);
		int id =	(Integer) madedish.get(0);
		String sql =" select  top "+top+" id from orders_dish where dishId ="+id+"and dishStatus= "+cc;
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * ��������˵����  
	 * ������2017-6-22 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param vv
	 * @������ @param madedish
	 * @������ @param cc
	 * @������ @return      
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
	 * ��������˵����  ��ѯ��Ҫ�����Ĳ�Ʒ
	 * ������2017-6-17 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return List     
	 * @throws
	 */
	public List queryMade(){
		String sql="select  d.dishId,d.dishName ,count (*)  from orders_dish od,dish d where dishStatus = 12 and od.dishId=d.dishId group by d.dishName,d.dishId ";
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * ��������˵���� ��ѯ���������Ĳ�Ʒ 
	 * ������2017-6-17 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return List     
	 * @throws
	 */
	public List queryMading()	{
		String sql ="select  d.dishId,d.dishName ,count (*)  from orders_dish od,dish d where dishStatus = 13 and od.dishId=d.dishId group by d.dishName,d.dishId";
		return DaoFactory.Query(sql);
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
}
