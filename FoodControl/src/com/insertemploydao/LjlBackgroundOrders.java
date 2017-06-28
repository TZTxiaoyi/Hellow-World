package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.utils.DaoFactory;

public class LjlBackgroundOrders implements DaoInterface {

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

	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	public List page(int currPage) {
		String sql="select top (5) * from backorder where ordersId not in(select top "+(currPage*5)+" ordersId from backorder order by  ordersId  desc)order by  ordersId  desc";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * 分页中的得到总条数
	 * @return
	 */
	public int getCount(){
		String sql="select count(*) from backorder";
		List list = DaoFactory.Query(sql);
		int total=0;
		List li=(List) list.get(0);
		total=(Integer) li.get(0);
		return total;
	}

}
