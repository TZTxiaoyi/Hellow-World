package com.insertemploydao;

import java.util.List;

import com.utils.DaoFactory;

public class LyOrderDao {
	
	/**
	 * ����ɶ���������
	 * @return
	 */
	public int getcount(){
		String sql="select count(*) from orders_table " +
				" where statuss not in ('��ȡ��')";
		List list =DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		int li=(Integer) list1.get(0);
		//System.out.println(li);
		return li;
	}
	/**
	 * �Դ�ӡ�����Ķ������з�ҳ��
	 * @param startIndex
	 * @return
	 */
	public List pagesize(int startIndex){
		String sql="select top 5 * from orders_table "+
"where ordersId not in(select top ("+startIndex*5+") ordersId from orders_table where statuss not in ('��ȡ��')) and statuss not in ('��ȡ��')";
		//System.out.println("ddddddddddd");         
		return DaoFactory.Query(sql);
	}
	/**
	 * setimeorder����ʱ��β鶩����
	 * @param begintime
	 * @param endtime
	 * @return
	 */
	public List setimeorder(String begintime,String endtime){
		String sql=" select * from orders_table " +
				" where ordersTime between '"+begintime+"' and '"+endtime+"' and statuss not in ('��ȡ��')";
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * @return
	 */
	/*public int selmoney(){
		//String 
	}*/
	
	public int acount(){
		String sql="select count(*) from orders_table " +
				" where statuss in ('��ȡ��')";
		List list =DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		int li=(Integer) list1.get(0);
		System.out.println("li:"+li);
		return li;
	}
	public List asizes(int startIndex){
		String sql="select top ("+2+") * from orders_table"+
				" where ordersId not in(select top ("+startIndex*2+") ordersId from orders_table) and statuss in ('��ȡ��')";
		System.out.println("ddddddddddd:"+startIndex);         
		return DaoFactory.Query(sql);
	}	
	/*public List anothertime(String begintime,String endtime){
		String sql=" select * from orders_table " +
				" where ordersTime between '"+begintime+"' and '"+endtime+"' and status not in ('�����','������')";
		return DaoFactory.Query(sql);
	}*/
	
}
