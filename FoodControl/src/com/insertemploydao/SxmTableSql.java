package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.LYEmployee;
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
		String sql = "insert  into desk values (?,?,?,?)";
		Object[] params = new Object[] { tab.getPersonNum(), tab.getDeskName(),tab.getDeskState(),tab.getDeskdelState()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * �����������ֻ�ȡ����id
	 * @param tabp
	 * @return
	 */
	public List seltabid(Object tabp){
		SxmTable tab = (SxmTable) tabp;
		String sql="select deskId from desk where deskName='"+tab.getDeskName()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * ��������id��Ա��id����Ա�����ӱ�
	 * @param tabid
	 * @param emid
	 * @return
	 */
	public int insertstaff(int tabid,int emid){
		String sql="insert into desk_staff values(?,?)";
		Object[] params = new Object[] {tabid,emid};
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
	 * ��̨���ӿ��ٲ�ѯ+��ҳ
	 * @param ser
	 * @return
	 */
	public List selTable(int currPage,String ser) {
		System.out.println("sql"+currPage);
		String sql = "select top(3)* from (select  * from  " +
				"desk_restaff where deskId like'%"+ser+"%' or personNum " +
				"like'%"+ser+"%' or deskName like'%"+ser+"%' or  Name " +
				"like'%"+ser+"%' or codeName like'%"+ser+"%') ss where " +
				"ss.deskId not in(select top ("+currPage+"*3 )d.deskId from " +
				"desk_restaff d where deskId like'%"+ser+"%' or " +
				"personNum like'%"+ser+"%' or deskName like'%"+ser+
				"%' or  Name like'%"+ser+"%' or codeName " +
				"like'%"+ser+"%')";
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
		String sql = "select d.deskState,d.deskName,o.ordersTime,o.ordersId,o.FoodNum,d.deskId "+
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
	 * ��������id�޸���������������
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
	/**
	 * ��������˵���� �޸�������Ϣ ������2017-6-24 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * ����Ա�����ֲ�ѯԱ��id
	 * @param emp
	 * @return
	 */
	public List updateper(Object emp){
		LYEmployee em=(LYEmployee) emp;
		String sql="select staffId from staffInfo where Name='"+em.getEmname()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * ��������˵���� �޸�������Ϣ ������2017-6-24 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * ��������id����Ա��id---Ա�����ӱ�
	 * @param tabp
	 * @param emId
	 * @return
	 */
	public int uppertab(Object tabp,int emId){
		SxmTable tab = (SxmTable) tabp;
		String sql="update desk_staff set staffId=? where deskId=?";
		Object[] params = new Object[] {emId,tab.getDeskId()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * ��������˵���� �޸�������Ϣ ������2017-6-24 by Administrator �޸ģ����� by �޸��� �޸����ݣ�
	 * ��������id��Ա��id����---Ա�����ӱ�
	 * @param tabp
	 * @param emId
	 * @return
	 */
	public int insertcharge(int emp,Object tabp){
		SxmTable tab = (SxmTable) tabp;
		String sql="insert into desk_staff values(?,?)";
		Object[] params=new Object[]{tab.getDeskId(),emp};
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
		String sql="select distinct  top(3)* from desk_restaff where " +
				"deskId not in (select distinct top ("+currPage+"*3) deskId " +
				"from desk_restaff)";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * ��ҳ�еĵõ�������
	 * @return
	 */
	public int getCount(String ser){
		String sql="select count(distinct deskId) from desk_restaff where deskId like'%"+
				ser+"%' or personNum like'%"+ser+"%' or deskName like'%"+ser+
				"%' or Name like'%"+ser+"%' or codeName like'%"+ser+"%'";
		List list = DaoFactory.Query(sql);
		int total=0;
		List li=(List) list.get(0);
		total=(Integer) li.get(0);
		return total;
	}
	/**
	 * ���ݸ���ǰ��������ȡ����id
	 */
	public List getbeforeid(Object tabp){
		SxmTable tab = (SxmTable) tabp;
		String sql="select deskId from desk where deskName='"+tab.getDeskName()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * ���ݸ��ĺ��������ȡ����id
	 */
	public List gettableid(String tname){
		String sql="select deskId from desk where deskName='"+tname+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * ���ݸ���ǰ������id��ȡ����id
	 */
	public List getorderid(int beforeid){
		String sql="select ordersId from orders where deskId="+beforeid;
		return DaoFactory.Query(sql);
	}
	/**
	 * ���ݶ���id�����Ӹ���Ϊ���ĺ��
	 */
	public int changeid(int tableid,int ordersid){
		String sql="update orders set deskId=? where ordersId=?";
		Object[] params = new Object[] {tableid,ordersid};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * ���ݸ���ǰ�������ı�����״̬Ϊ����
	 */
	public int changedstate(Object tabp){
		SxmTable tab = (SxmTable) tabp;
		String sql="update desk set deskState=6 where deskName=?";
		Object[] params = new Object[] {tab.getDeskName()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * ���ݸ���ǰ��������������״̬Ϊռ��
	 */
	public int changeafterdstate(String tname){
		String sql="update desk set deskState=7 where deskName=?";
		Object[] params = new Object[] {tname};
		return DaoFactory.Updata(sql, params);
	}
	public List sel(Object obj) {
		// TODO Auto-generated method stub
		
		return null;
	}

	

}
