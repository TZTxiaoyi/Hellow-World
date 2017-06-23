package com.insertemploydao;


import java.util.List;

import com.entity.LYEmployId;
import com.entity.LYEmployee;

import com.sun.faces.lifecycle.UpdateModelValuesPhase;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;
import com.utils.DaoFactory;

public class LYInsertEmployDao {
	/**
	 * selemply:��ѯ��̨Ա����Ϣ������ѯ
	 * @param em
	 * @return
	 */
	public  List selemploy(LYEmployee em){
		String sql="select ss.Name,ss.staffId,ss.phone,ss.sex,ss.age,ss.adress,ss.accession,ss.partName" +
				" from staffinfo_sf ss";
		
		return DaoFactory.Query(sql);
				
	}
	/**
	 * eminsert��Ա����ʵ����
	 * 
	 * @param em
	 * @return
	 */
	public int eminsert(LYEmployee em){

		String sql="insert into staffInfo values(?,?,?,?,?,?,?,?,?)";
		Object[] params=new Object[]{em.getEmid(),em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),em.getEmpart(),em.getAccount()};		
		
		return DaoFactory.Updata(sql, params);	
	}
	/**
	 * emidinsert:Ա���˺ŵ�ʵ����
	 * 
	 * @param eld
	 * @return
	 */
	public int emidinsert(LYEmployId eld){		
		String sql="insert into staffEnter values(?,?)";
		Object[] params = new Object[]{eld.getEmenter(),eld.getEmenter()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * delong:ɾ��Ա����ʵ����
	 * ����Dao������
	 * @param lye
	 * @return
	 */
	
	public int delone(LYEmployee lye){
		String sql="update staffInfo set staffinfoState=20 where staffId=?";
		Object[] params = new Object[]{lye.getEmid()};
		return DaoFactory.Updata(sql, params);
	}
	
	/**
	 * update:�޸�Ա����Ϣ��ʵ����
	 * @param em
	 * @return
	 */
	public int update(LYEmployee em){

		String sql="Update staffInfo set Name=?,sex=?,age=?,phone=?,adress=?,accession=?,staffinfoState=? where staffId=?";
		
		Object[] params=new Object[]{em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),em.getStaffinfoState(),em.getEmid()};

		//System.out.println(em.getEmname()+","+em.getEmsex()+","+em.getEmage()+","+em.getEmphone()+","+em.getEmadress()+","+em.getEmjointime()+","+em.getEmid());
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * searchsome:ģ����ѯʵ����
	 * @param em
	 * @return
	 */
	public List searchsome(String em){
		//System.out.println(em.getEmid()+"ss");
		String sql="select * from  staffinfo_sf where Name like'%"+em+"%' or staffId like'%"+em+"%' or phone like'%"+em+"%' or sex like'%"+em+"%' or age like'%"+em+"%'  or adress like'%"+em+"%'  or accession like'%"+em+"%' or partName like'%"+em+"%' or account like'%"+em+"%'";		
		return DaoFactory.Query(sql);
	}
	/**
	 * selectemid����ѯԱ���˺ű�ʵ����
	 * LYEmployId��Ա���˺�ʵ����
	 * @param ld
	 * @return
	 */
	
	public List selectemid(LYEmployId ld){
		String sql="select s1.account,s1.pwd " +
				" from staffEnter s1 " +
				" where account='"+ld.getEmenter()+"' and pwd='"+ld.getEmword()+"'";
		//Object[] params=new Object[]{ld.getEmenter(),ld.getEmword()};
		return DaoFactory.Query(sql);
	}
	/**
	 * getallpage����ѯԱ����countʵ���࣬
	 * �õ���ά����list��
	 * @return
	 */
	public int getallpage(){
		String sql="select count(*) from staffInfo";
		List list =DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		int li=(Integer) list1.get(0);
		return li;
	}
	/**
	 * pagepage:��ҳʵ����
	 * @param startIndex ��ǰҳ
	 * @return
	 */
	public List pagepage(int startIndex){
		//System.out.println("aaaaaaaaaa");
		String sql="select top "+2+" ss.Name,ss.staffId,ss.phone,ss.sex,ss.age,ss.adress,ss.accession,ss.partName" +
				" from staffinfo_sf ss" +
				" where staffId not in(select top "+startIndex*2+" staffId from staffinfo_sf)";
		//System.out.println("ddddddddddd");
		return DaoFactory.Query(sql);
	}
}
