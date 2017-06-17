package com.logic;


import java.util.List;

import com.entity.LYEmployId;
import com.entity.LYEmployee;

import com.utils.DaoFactory;

public class LYInsertEmployDao {
	/**
	 * selemply:��ѯ��̨Ա����Ϣ������ѯ
	 * @param em
	 * @return
	 */
	public  List selemploy(LYEmployee em){
		String sql="select s1.Name,s1.staffId,s1.phone,s1.sex,s1.age,s1.adress,s1.accession,p1.partId,d1.deskId" +
				" from staffInfo s1,part p1, desk_staff d1" +
				" where s1.partId=p1.partId and s1.staffId=d1.staffId";
		
		return DaoFactory.Query(sql);
				
	}
	/**
	 * eminsert��Ա����ʵ����
	 * 
	 * @param em
	 * @return
	 */
	public int eminsert(LYEmployee em){
		String sql="insert into staffinfo values(?,?,?,?,?,?,?,?,?)";
		Object[] params=new Object[]{em.getEmid(),em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),em.getEmpart(),em.getEmenter()};		
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
	 * delong:ʵ����
	 * ����Dao������
	 * @param lye
	 * @return
	 */
	public int delone(LYEmployee lye){
		String sql="truncate table staffinfo where staffId=?";
		Object[] params = new Object[]{lye.getEmid()};
		return DaoFactory.Updata(sql, params);
	}
}
