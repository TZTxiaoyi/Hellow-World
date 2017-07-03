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
	 * selemply:��ѯ��̨Ա����Ϣ������ѯ
	 * @param em
	 * @return
	 */
	public  List selemploy(LYEmployee em){
		String sql="select ss.Name,ss.staffId,ss.phone,ss.codeName,ss.age,ss.adress,ss.accession,ss.partName,ss.account" +
				" from staffinfo_sf ss";		
		return DaoFactory.Query(sql);
				
	}
	  
	/**
	 * eminsert��Ա����ʵ����
	 * ���Ա��
	 * @param em
	 * @return
	 */
	public int eminsert(LYEmployee em,int partId,int enterId){
		
		String sql="insert into staffInfo values(?,?,?,?,?,?,?,?,?,?)";
		Object[] params=new Object[]{em.getEmid(),em.getEmname(),em.getEmsex(),em.getEmage(),em.getEmphone(),em.getEmadress(),em.getEmjointime(),partId,enterId,19};		
		System.out.println(em.getEmid()+";"+em.getEmname()+";"+em.getEmsex()+";"+em.getEmage()+";"+em.getEmphone()+";"+em.getEmadress()+";"+em.getEmjointime()+";"+partId+";"+enterId+";"+19);
		return DaoFactory.Updata(sql, params);	
	}
	/**
	 * �����˺ţ��ҵ��˺Ŷ�Ӧ��id 
	 */
	public int selectenterid(LYEmployId emword){
		//System.out.println("000000000");
		System.out.println(emword.getEmword());
		String sql="select enterId from staffEnter where account='"+emword.getEmenter()+"'";
		List list = DaoFactory.Query(sql);
		System.out.println(list);
		List list1=(List) list.get(0);
		int list2=(Integer) list1.get(0);
		return list2;
	}
	/**
	 * emidinsert:Ա���˺ŵ�ʵ����
	 * 
	 * @param eld
	 * @return
	 */
	public int emidinsert(LYEmployId eld){		
		String sql="insert into staffEnter values(?,?,?)";
		Object[] params = new Object[]{eld.getEmenter(),eld.getEmword(),1};

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
												
		System.out.println(em.getEmname()+","+em.getEmsex()+","+em.getEmage()+","+em.getEmphone()+","+em.getEmadress()+","+em.getEmjointime()+","+em.getEmid());
		return DaoFactory.Updata(sql, params);
	}
	/**e
	 * searchsome:ģ����ѯʵ����
	 * @param em
	 * @return
	 */
	public List searchsome(String em){
		//System.out.println(em.getEmid()+"ss");
		String sql="select * from  staffinfo_sf where Name like'%"+em+"%' or staffId like'%"+em+"%' or phone like'%"+em+"%' or codeName like'%"+em+"%' or age like'%"+em+"%'  or adress like'%"+em+"%'  or accession like'%"+em+"%' or partName like'%"+em+"%' or account like'%"+em+"%'";		
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
	 * getallpage����ѯԱ����countʵ���࣬
	 * �õ���ά����list��
	 * @retur\n
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
		String sql="select top "+2+" ss.Name,ss.staffId,ss.phone,ss.codeName,ss.age,ss.adress,ss.accession,ss.partName,ss.account" +
				" from staffinfo_sf ss" +
				" where staffId not in(select top "+startIndex*2+" staffId from staffinfo_sf)";
		//System.out.println("ddddddddddd");         
		return DaoFactory.Query(sql);
	}
	
	/**
	 * ��ɫȨ�ޱ�ʵ����
	 */
	public List aperson(String partname){
		//System.out.println("00000");
		String sql="select pa.partName,pa.powersUul" +
				" from pa_auth pa where partName='"+partname+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * selectpartname:��ѯ��ɫ�������Ա������Ա����ʦ��
	 * ����ѯ�Ľ�����ظ������䷽����action
	 * @return
	 */
	public List selectpartname(){
		String sql="select p1.partName"+
					" from part p1"+
					" where partName not in('����Ա','����Ա','��ʦ')";
		 return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * addpartname����ӽ�ɫʵ����
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
	 * getallpage����ѯԱ���˺ű�countʵ���࣬
	 * �õ���ά����list��
	 * @return
	 */
	public int getpages(){
		String sql="select count(*) from staffEnter";
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
	public List setpages(int startIndex){
		//System.out.println("aaaaaaaaaa");
		String sql="select top "+2+" ss.account,ss.pwd,ss.codeName" +
				" from staffEnter_pic ss" +
				" where enterId not in(select top "+startIndex*2+" enterId from staffEnter_pic) and codeName='������' or codeName='δ������'";
		//System.out.println("ddddddddddd");
		return DaoFactory.Query(sql);
	}
	/**
	 * update:�޸�Ա���˺ŵ�ʵ����
	 * @param em
	 * @return
	 */
	public int updateid(LYEmployId em){

		String sql="Update staffEnter set pwd=?,enterState=? where account=?";
		
		Object[] params=new Object[]{em.getEmword(),em.getEnterstate(),em.getEmenter(),};

		//System.out.println(em.getEmname()+","+em.getEmsex()+","+em.getEmage()+","+em.getEmphone()+","+em.getEmadress()+","+em.getEmjointime()+","+em.getEmid());
		return DaoFactory.Updata(sql, params);
	}
	
	/**
	 * selectpowers:��ѯȨ��ʵ����
	 */
	public List selectpowers(LyPart partname){
		String sql = "select pa.powersName,pa.powersId"+
					" from pa_auth pa"+ 
					" where partName='"+partname.getPartname()+"'";
		return DaoFactory.Query(sql);
	}
	/**
	 * selectpartId: ���ݽ�ɫ�ҵ��ý�ɫid
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
	 * deletpowers: �õ���ɫid��ɾ���ý�ɫid������Ȩ�ޣ�
	 * @param partId����ɫid
	 * @return
	 */
	public int deletpowers(int partId){
		String sql="delete from part_powers where partId=?";
		Object[] params=new Object[]{partId};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * insertpowers:�ڸý�ɫid�½��õ���Ȩ�ޣ��������ݿ��ɫȨ�ޱ�
	 * @param partId����ɫid��
	 * @param powersId��Ȩ��id�����飻 
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
}
