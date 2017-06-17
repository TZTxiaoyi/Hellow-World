package com.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.daointerface.DaoInterface;
import com.entity.SxmTable;
import com.utils.DaoFactory;

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
		String sql = "insert into desk values (?,?,?)";
		Object[] params = new Object[] { tab.getPersonNum(), tab.getDeskName(),
				tab.getDeskState() };
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
		String sql = "select deskName from desk";
		List list = (List) DaoFactory.Query(sql);
		int flag = -1;
		for (int i = 0; i < list.size(); i++) {
			System.out.println(555);
			SxmTable a = (SxmTable) tab;
			List li = (List) list.get(i);// ��
			String st = (String) li.get(0);// ��
			System.out.println(st);
			if (a.getDeskName().equals(st)) {
				flag = 1;
			}
		}
		
		return flag;
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
	public Map selTableAdmin(Object obj) {
		String sql = "select * from desk_refresh";
		List list = DaoFactory.Query(sql);
		JSONObject json = new JSONObject();
		for (int i = 0; i < list.size(); i++) {
			Map map = new HashMap();
			map.put("df" + i, list.get(i));
			json.accumulateAll(map);
		}
		return json;
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
		//delete from desk_staff where deskId=2
		SxmTable tab = (SxmTable) tabp;
		String sqlds="delete from desk_staff where deskId=?";
		Object [] paramsds=new Object[] {tab.getDeskId()};
		DaoFactory.Updata(sqlds, paramsds);
		
		String sql = "delete from desk where deskId=?";
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
		String sql = "update desk set personNum=?,deskName=?,deskState=? where deskId=?";
		Object[] params = new Object[] { tab.getPersonNum(), tab.getDeskName(),
				tab.getDeskState(), tab.getDeskId() };
		return DaoFactory.Updata(sql, params);

	}

	/**
	 * 
	 * ��������˵���� ��ѯ����������Ϣ ������2017-6-14 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * 
	 * @������ @param tab ���Ӵ���
	 * @return void
	 * @throws
	 */
	public List sel(Object obj) {
		String sql = "select * from desk";
		List list = DaoFactory.Query(sql);
		// if(tab.getDeskName().equals(sql));
		return list;
	}

}
