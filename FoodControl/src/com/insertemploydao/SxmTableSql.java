package com.insertemploydao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.daointerface.DaoInterface;
import com.entity.SxmTable;
import com.utils.DaoFactory;
import com.utils.toJson;

/**
 * 
 * @类功能说明： 桌子的Sql语句
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：adam
 * @作者：Administrator
 * @创建时间：2017-6-14 下午3:24:31
 * @版本：V1.0
 */
public class SxmTableSql implements DaoInterface {

	/**
	 * 
	 * 方法功能说明： 添加桌子 创建：2017-6-14 by Administrator 修改：日期 by 修改者 修改内容：
	 * 
	 * @参数： @param tab 桌子传参
	 * @return void
	 * @throws
	 */
	public int add(Object tabp) {
		SxmTable tab = (SxmTable) tabp;
		String sql = "insert into desk values (?,?,?,?)";
		Object[] params = new Object[] { tab.getPersonNum(), tab.getDeskName(),tab.getDeskState(),tab.getDeskdelState()};
		return DaoFactory.Updata(sql, params);
	}

	/**
	 * 
	 * 方法功能说明： 查询桌子名字信息 创建：2017-6-14 by Administrator 修改：日期 by 修改者 修改内容：
	 * 
	 * @参数： @param tab 传参 桌子的名字
	 * @return void
	 * @throws
	 */
	public int selTableName(Object tab) {
		String sql = "select * from desk";
		List list = (List) DaoFactory.Query(sql);
		int flag = -1;
		for (int i = 0; i < list.size(); i++) {
			SxmTable a = (SxmTable) tab;
			List li = (List) list.get(i);// 行
			String st = (String) li.get(2);// 列
			if (a.getDeskName().equals(st)) {
				flag = 1;
			}
		}
		
		return flag;
	}
	/**
	 * 后台桌子快速查询
	 * @param ser
	 * @return
	 */
	public List selTable(String ser) {
		String sql = "select * from desk_restaff where deskId like'%"+ser+"%' or personNum like'%"+ser+"%' or deskName like'%"+ser+"%' or  Name like'%"+ser+"%' or codeName like'%"+ser+"%'";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * 前台桌子快速查询
	 * @param ser
	 * @return
	 */
	public List serviceTable(String ser) {
		String sql = "select * from desk_restaff where deskName like'%"+ser+"%'";
		List list = DaoFactory.Query(sql);
		return list;
	}
	public List idTablename(String ser) {
		String sql = "select * from desk_restaff where deskName ='"+ser+"'";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * @return
	 * 
	 *         方法功能说明： 点击桌子管理按钮时查询数据库 创建：2017-6-15 by Administrator 修改：日期 by
	 *         songxianmeng 修改内容：
	 * @参数：
	 * @return void
	 * @throws
	 */
	public List selTableAdmin(Object obj) {
		String sql = "select d.deskState,d.deskName,o.ordersTime,o.ordersId,o.FoodNum "+
				"from desk_restaff d left join orders o on ordersStatus=15 and d.deskId=o.deskId";
		List list = DaoFactory.Query(sql);
		
		return list;
	}

	/**
	 * 
	 * 方法功能说明： 删除桌子 创建：2017-6-14 by Administrator 修改：日期 by 修改者 修改内容：
	 * 
	 * @参数： @param tab 桌子传参
	 * @return void
	 * @throws
	 */
	public int del(Object tabp) {
		SxmTable tab = (SxmTable) tabp;
		String sql = "update desk set deskState=null,deskdelState=20 where deskId=?";
		Object[] params = new Object[] { tab.getDeskId() };
		return DaoFactory.Updata(sql, params);
		
	}

	/**
	 * 
	 * 方法功能说明： 修改桌子信息 创建：2017-6-14 by Administrator 修改：日期 by 修改者 修改内容：
	 * 
	 * @参数：
	 * @return void
	 * @throws
	 */
	public int update(Object tabp) {
		SxmTable tab = (SxmTable) tabp;
		String sql = "update desk set personNum=?,deskName=? where deskId=?";
		Object[] params = new Object[] { tab.getPersonNum(), tab.getDeskName(), tab.getDeskId() };
		return DaoFactory.Updata(sql, params);

	}
	public int uptabstate(String tablest) {
		String sql = "update desk set deskState=7 where deskName=?";
		Object[] params = new Object[] {tablest};
		return DaoFactory.Updata(sql, params);

	}
	/**
	 * @return 
	 * 
	 * 方法功能说明：分页功能；
	 * 
	 * @参数： @param tab 桌子传参
	 * @return void
	 * @throws
	 */
	public List page(int currPage) {
		String sql="select top ("+3+") * from desk_restaff where deskId not in(select top "+(currPage)*3+" deskId from desk_restaff)";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * 分页中的得到总条数
	 * @return
	 */
	public int getCount(){
		String sql="select count(*) from desk_restaff";
		List list = DaoFactory.Query(sql);
		int total=0;
		List li=(List) list.get(0);
		total=(Integer) li.get(0);
		return total;
	}

	public List sel(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
