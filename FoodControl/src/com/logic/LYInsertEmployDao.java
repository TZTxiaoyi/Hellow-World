package com.logic;


import java.util.List;

import com.entity.LYEmployId;
import com.entity.LYEmployee;

import com.sun.faces.lifecycle.UpdateModelValuesPhase;
import com.utils.DaoFactory;

public class LYInsertEmployDao {
	/**
	 * selemply:查询后台员工信息，多表查询
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
	 * eminsert：员工的实现类
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
	 * emidinsert:员工账号的实现类
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
	 * delong:删除员工的实现类
	 * 调用Dao工厂，
	 * @param lye
	 * @return
	 */
	
	public int delone(LYEmployee lye){
		String sql="truncate table staffInfo where staffId=?";
		Object[] params = new Object[]{lye.getEmid()};
		return DaoFactory.Updata(sql, params);
	}
	
	/**
	 * update:修改员工信息的实现类
	 * @param em
	 * @return
	 */
	public int update(LYEmployee em){
		String sql="Update staffInfo set Name=?,sex=?,age=?,phone=?,adress=?,accession=? where staffId=?";
		
		Object[] params=new Object[]{em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),em.getEmid()};
		//System.out.println(em.getEmname()+","+em.getEmsex()+","+em.getEmage()+","+em.getEmphone()+","+em.getEmadress()+","+em.getEmjointime()+","+em.getEmid());
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * searchsome:
	 * @param em
	 * @return
	 */
	public List searchsome(String em){
		//System.out.println(em.getEmid()+"ss");
		String sql="select * from  staffinfo where Name like'%"+em+"%' or sex like'%"+em+"%' or age like'%"+em+"%' or phone like'%"+em+"%'  or adress like'%"+em+"%'  or accession like'%"+em+"%' or partId like'%"+em+"%'";		
		return DaoFactory.Query(sql);
	}
}
