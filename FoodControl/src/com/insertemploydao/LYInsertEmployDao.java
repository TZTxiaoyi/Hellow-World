package com.insertemploydao;


import java.util.ArrayList;
import java.util.List;

import com.entity.LYEmployId;
import com.entity.LYEmployee;
import com.entity.LyPart;

import com.sun.faces.lifecycle.UpdateModelValuesPhase;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath.Step;
import com.utils.DaoFactory;

public class LYInsertEmployDao {
	/**
	 * selemply:查询后台员工信息，多表查询
	 * @param em
	 * @return
	 */
	public  List selemploy(LYEmployee em){
		String sql="select ss.Name,ss.staffId,ss.phone,ss.codeName,ss.age,ss.adress,ss.accession,ss.partName,ss.account" +
				" from staffinfo_sf ss";		
		return DaoFactory.Query(sql);
				
	}
	  /**
	   * 查询员工编号
	   */
	public List selstaffid(LYEmployee em){
		String sql="select *from staffInfo where staffId='"+em.getEmid()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * eminsert：员工的实现类
	 * 添加员工
	 * @param em
	 * @return
	 */
	public int eminsert(LYEmployee em,int countpage,int enterId){
		
		String sql="insert into staffInfo values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params=new Object[]{em.getEmid(),em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),countpage,enterId,19};		
		System.out.println(em.getEmid()+";"+em.getEmname()+";"+em.getEmsex()+";"+em.getEmage()+";"+em.getEmphone()+";"+em.getEmadress()+";"+em.getEmjointime()+";"+countpage+";"+enterId+";"+19);
		return DaoFactory.Updata(sql, params);	
	}
	/**
	 * 查询员工的角色实现类
	 * @return
	 */
	public List selpaList(){
		String sql="select p1.partName,p1.partId"+
				" from part p1"+
				" where partName not in('管理员') and partState=19";
	 return DaoFactory.Query(sql);
	}
	
	
	/**
	 * 根据账号，找到账号对应的id 
	 */
	public int selectenterid(LYEmployId emword){
		//System.out.println("000000000");
		//System.out.println(emword.getEmword());
		String sql="select enterId from staffEnter where account='"+emword.getEmenter()+"'";
		List list = DaoFactory.Query(sql);
		System.out.println(list);
		List list1=(List) list.get(0);
		int list2=(Integer) list1.get(0);
		return list2;
	}
	/**
	 * 修改账号的状态为已分配
	 */
	public int updatestate(int enterId){
		String sql="update staffEnter set enterState=1 where enterId=?";
		Object[] params=new Object[]{enterId};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 删除账号
	 */
	public int delnumber(LYEmployId en){
		String sql="update staffEnter set enterState=3 where account=?";
		Object[] params=new Object[]{en.getEmenter()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * emidinsert:员工账号的实现类
	 * 
	 * @param eld
	 * @return
	 */
	
	/**
	 * 模糊查询找你
	 */
	public List searchacclist(String putvalue){
		String sql="select sp.account,sp.pwd,sp.codeName " +
				" from staffEnter_pic sp" +
				" where account like'%"+putvalue+"%' or pwd like'%"+putvalue+"%' or codeName like'%"+putvalue+"%' ";
		return DaoFactory.Query(sql);
	}
	public int emidinsert(LYEmployId eld){		
		String sql="insert into staffEnter values(?,?,?)";
		Object[] params = new Object[]{eld.getEmenter(),eld.getEmword(),2};

		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 失焦事件查询是否有相同账号
	 */
	public List selacc(LYEmployId ld){
		String sql="select * from staffEnter where account='"+ld.getEmenter()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * delong:删除员工的实现类
	 * 调用Dao工厂，
	 * @param lye
	 * @return
	 */
	
	public int delone(LYEmployee lye){
		String sql="update staffInfo set staffinfoState=20 where staffId=?";
		Object[] params = new Object[]{lye.getEmid()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 被删除的员工拥有的账号状态改为未分配
	 */
	public int upstate(LYEmployId ld){
		System.out.println("00000:::"+ld.getEmenter());
		String sql="update staffEnter set enterState=3 where account=?";
		
		Object[] params = new Object[]{ld.getEmenter()};
		return DaoFactory.Updata(sql, params);
		
	}
	/**
	 * update:修改员工信息的实现类
	 * @param em
	 * @return
	 */
	public int update(LYEmployee em,int partId){

		String sql="Update staffInfo set Name=?,sex=?,age=?,phone=?,adress=?,accession=?,partId=? where staffId=?";
		
		Object[] params=new Object[]{em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),partId,em.getEmid()};
												
		//System.out.println(em.getEmname()+","+em.getEmsex()+","+em.getEmage()+","+em.getEmphone()+","+em.getEmadress()+","+em.getEmjointime()+","+partId);
		return DaoFactory.Updata(sql, params);
	}
	/**e
	 * searchsome:模糊查询实现类
	 * @param em
	 * @return
	 */
	public List searchsome(String em){
		//System.out.println(em.getEmid()+"ss");
		String sql="select * from  staffinfo_sf where Name like'%"+em+"%' or staffId like'%"+em+"%' or phone like'%"+em+"%' or codeName like'%"+em+"%' or age like'%"+em+"%'  or adress like'%"+em+"%'  or accession like'%"+em+"%' or partName like'%"+em+"%' or account like'%"+em+"%'";		
		return DaoFactory.Query(sql);
	}
	/**
	 * selectemid：查询员工账号表实现类
	 * LYEmployId：员工账号实体类
	 * @param ld
	 * @return
	 */
	
	public List selectemid(LYEmployId ld){

		String sql="select s1.account,s1.pwd " +
				" from staffEnter s1 " +
				" where account='"+ld.getEmenter()+"' and pwd='"+ld.getEmword()+"' and enterState=1";
		//Object[] params=new Object[]{ld.getEmenter(),ld.getEmword()};
		return DaoFactory.Query(sql); 
	}
	public String selectpart(LYEmployId ld){
		String sql="select p1.partName"+
				" from part p1,staffEnter s1,staffInfo st"+
				" where p1.partId=st.partId and st.enterId=s1.enterId and account='"+ld.getEmenter()+"'";
		List list = DaoFactory.Query(sql);
		List list2 =(List) list.get(0);
		String pname =(String) list2.get(0);
		//System.out.println(pname);
		return pname;
	}
	/**
	 * getallpage：查询员工表count实现类，
	 * 得到二维数组list，
	 * @retur\n
	 */
	public int getallpage(){
		String sql="select count(*) from staffInfo where staffInfoState=19";
		List list =DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		int li=(Integer) list1.get(0);
		return li;
	}
	/**
	 * pagepage:分页实体类
	 * @param startIndex 当前页
	 * @return
	 */
	public List pagepage(int startIndex){
		//System.out.println("aaaaaaaaaa");
		String sql="select top 5 ss.Name,ss.staffId,ss.phone,ss.codeName,ss.age,ss.adress,ss.accession,ss.partName,ss.account"+
				   " from (select * from staffinfo_sf s1 where s1.staffInfoState=19) ss where ss.staffId"+
				   " not in (select top ("+startIndex+"*5) staffId from staffinfo_sf s2 where s2.staffInfoState =19) and ss.staffInfoState=19";
		//System.out.println("ddddddddddd");         
		return DaoFactory.Query(sql);
	}
	
	/**
	 * 角色权限表实现类
	 */
	public List aperson(String partname){
		//System.out.println("00000");
		String sql="select pa.partName,pa.powersUul" +
				" from pa_auth pa where partName='"+partname+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * selectpartname:查询角色表除管理员、服务员、厨师外
	 * 将查询的结果返回给调用其方法的action
	 * @return
	 */
	public List selectpartname(){
		String sql="select p1.partName"+
					" from part p1"+
					" where partName not in('管理员','服务员','厨师') and partState=19";
		 return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * addpartname：添加角色实现类
	 * @param pt
	 * @return
	 */
	public int addpartname(LyPart pt){
		//System.out.println("444444");
		String sql="insert into part values(?,?)";
		Object[] params=new Object[]{pt.getPartname(),19};
		//System.out.println(pt.getPartname());
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 失焦事件查询数据库是否有该角色
	 */
	public List selpt(LyPart lp){
		String sql="select * from part where partname='"+lp.getPartname()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * getallpage：查询员工账号表count实现类，
	 * 得到二维数组list，
	 * @return
	 */
	public int getpages(){
		String sql="select count(*) from staffEnter where enterState not in (3)";
		List list =DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		int li=(Integer) list1.get(0);
		return li;
	}
	/**
	 * pagepage:分页实体类
	 * @param startIndex 当前页
	 * @return
	 */
	public List setpages(int startIndex){
		//System.out.println("aaaaaaaaaa");
		String sql="select top 5 aa.account,aa.pwd,aa.codeName " +
				"from(select * from staffEnter_pic ss where " +
				"ss.codeName not in ('已禁用')) aa where aa.enterId " +
				"not in(select top ("+startIndex+"*5) enterId from staffEnter_pic  " +
				"s1 where s1.codeName not in ('已禁用')) and aa.codeName " +
				"not in ('已禁用')";
		//System.out.println("ddddddddddd");
		return DaoFactory.Query(sql);
	}
	/**
	 * update:修改员工账号的实现类
	 * @param em
	 * @return
	 */
	public int updateid(LYEmployId em){

		String sql="Update staffEnter set pwd=? where account=?";
		
		Object[] params=new Object[]{em.getEmword(),em.getEmenter(),};

		//System.out.println(em.getEmname()+","+em.getEmsex()+","+em.getEmage()+","+em.getEmphone()+","+em.getEmadress()+","+em.getEmjointime()+","+em.getEmid());
		return DaoFactory.Updata(sql, params);
	}
	
	/**
	 * selectpowers:查询权限实现类
	 */
	public List selectpowers(LyPart partname){
		String sql = "select pa.powersName,pa.powersId"+
					" from pa_auth pa"+ 
					" where partName='"+partname.getPartname()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * selectpartId: 根据角色找到该角色id
	 */
	public int selectpartId(LyPart partname){
		//System.out.println("-----");
		String sql="select partId from part where partName='"+partname.getPartname()+"'";		
		List list = DaoFactory.Query(sql);
		List list1=(List) list.get(0);
		//System.out.println("list1"+list1);
		int list2=(Integer) list1.get(0);
		//System.out.println("list2"+list2);
		return list2;
	}
	/**
	 * deletpowers: 得到角色id后，删除该角色id下所有权限；
	 * @param partId：角色id
	 * @return
	 */
	public int deletpowers(int partId){
		String sql="delete from part_powers where partId=?";
		Object[] params=new Object[]{partId};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * insertpowers:在该角色id下将得到的权限，插入数据库角色权限表
	 * @param partId：角色id；
	 * @param powersId：权限id的数组； 
	 */
	public void insertpowers(int partId,ArrayList<Integer> powersId){
		//System.out.println("1314");
		//System.out.println("55555:"+powersId.size());
		for(int i=0; i<powersId.size();i++){
			String sql="insert into part_powers values(?,?)";
			Object[] params=new Object[]{partId,powersId.get(i)};
			//System.out.println("9999:"+partId+powersId.get(i));
			DaoFactory.Updata(sql, params);
		}
		//return null;
	}
	public List selectfu(){
		String sql="select Name,staffId from staffInfo where partId=3";
		return DaoFactory.Query(sql);
	}
	/**
	 * 删除角色
	 */
	public int deletepart(LyPart lp){
		String sql="update part set partState=20 where partName=? ";
		Object[] params=new Object[]{lp.getPartname()};
		return DaoFactory.Updata(sql, params);
	}
	
}
