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
 * @�๦��˵���� ���ӵ�Sql���
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�adam
 * @���ߣ�Administrator
 * @����ʱ�䣺2017-6-14 ����3:24:31
 * @�汾��V1.0
 */
public class SxmTableSql implements DaoInterface {

	/**
	 * 
	 * ��������˵���� ������� ������2017-6-14 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * 
	 * @������ @param tab ���Ӵ���
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
	 * ��������˵���� ��ѯ����������Ϣ ������2017-6-14 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * 
	 * @������ @param tab ���� ���ӵ�����
	 * @return void
	 * @throws
	 */
	public int selTableName(Object tab) {
		String sql = "select * from desk";
		List list = (List) DaoFactory.Query(sql);
		int flag = -1;
		for (int i = 0; i < list.size(); i++) {
			SxmTable a = (SxmTable) tab;
			List li = (List) list.get(i);// ��
			String st = (String) li.get(2);// ��
			if (a.getDeskName().equals(st)) {
				flag = 1;
			}
		}
		
		return flag;
	}
	/**
	 * ��̨���ӿ��ٲ�ѯ
	 * @param ser
	 * @return
	 */
	public List selTable(String ser) {
		String sql = "select * from desk_restaff where deskId like'%"+ser+"%' or personNum like'%"+ser+"%' or deskName like'%"+ser+"%' or  Name like'%"+ser+"%' or codeName like'%"+ser+"%'";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * ǰ̨���ӿ��ٲ�ѯ
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
	 *         ��������˵���� ������ӹ���ťʱ��ѯ���ݿ� ������2017-6-15 by Administrator �޸ģ����� by
	 *         songxianmeng �޸����ݣ�
	 * @������
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
	 * ��������˵���� ɾ������ ������2017-6-14 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * 
	 * @������ @param tab ���Ӵ���
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
	 * ��������˵���� �޸�������Ϣ ������2017-6-14 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * 
	 * @������
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
	 * ��������˵������ҳ���ܣ�
	 * 
	 * @������ @param tab ���Ӵ���
	 * @return void
	 * @throws
	 */
	public List page(int currPage) {
		String sql="select top ("+3+") * from desk_restaff where deskId not in(select top "+(currPage)*3+" deskId from desk_restaff)";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * ��ҳ�еĵõ�������
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
