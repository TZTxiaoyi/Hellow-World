package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.ZbCustomerInfo;
import com.entity.ZbUsagedata;
import com.entity.ZbUserdata;
import com.entity.Zbcus_enter1;
import com.utils.DaoFactory;

public class ZbRegister implements DaoInterface{

	/**
	 * zhuce
	 */
	public int add(Object user) {
		ZbUserdata userdata=(ZbUserdata)user;
		// TODO Auto-generated method stub
		String sql="insert customerEnter values (?,?,?)";
		Object[] params=new Object[]{userdata.getAccount(),userdata.getPwd(),19};
		int flag=DaoFactory.Updata(sql, params);
		return flag;
	}
	
	public int addnom(Object adnm){
		System.out.println("++++++++++++++++++++++");
		Zbcus_enter1 zb = (Zbcus_enter1) adnm;
		String sql = "insert cus_enter1 values ('"+zb.getName()+"','"+zb.getSex()+"','"+zb.getPhone1()+"','"+zb.getAdress()+"','"+zb.getAge()+"')";
		//Object[] params = new Object[]{zb.getName(),zb.getSex(),zb.getPhone1(),zb.getAdress(),zb.getAge()};
		int flag = DaoFactory.Updata(sql, null);
		return flag;
	}
	/**
	 * 
	 * 方法功能说明：  增加顾客信息sql
	 * 创建：2017-6-24 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param zbcin
	 * @参数： @return      
	 * @return int     
	 * @throws
	 */
	//------------------------------------------------------------------------
	public int addinfo(Object zbcin){
		ZbCustomerInfo zbcinfo =(ZbCustomerInfo) zbcin;
		String sql = "insert customerInfo values(?,?,?,?)";
		
		return 0;
		}
	public List queryinfo(){
		String sql = "select c1.Name,c1.sex,c1.phone,c1.adress,c1.age from customerInfo c1,customerEnter c2 where c1.enterId = c2.enterId";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * 
	 * 方法功能说明：  		后台顾客快速查找
	 * 创建：2017-6-24 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param ser
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List selcustomer(String ser) {
		String sql = "select * from cus_enter1 where Name like '%"+ser+"%' or sex like '%"+ser+"%' or phone like '%"+ser+"%' or adress like '%"+ser+"%' or age like '%"+ser+"%'";
		List list = DaoFactory.Query(sql);
		return list;
	}
	//-------------------------------------------------------------------
	public int del(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	public int loginsel(Object userdata) {
		
		ZbUsagedata zbsd =(ZbUsagedata) userdata;
		String sql="select * from customerEnter";
		
		// TODO Auto-generated method stub
		List list = DaoFactory.Query(sql);
		int flag = -1;
		for(int i=0; i<list.size();i++){
			
			List a =(List) list.get(i);
			String acc= (String) a.get(1);
			String pwd = (String) a.get(2);
			if(zbsd.getAccount().equals(acc)&& zbsd.getPwd().equals(pwd)){
				flag = 1;
				
			}
			
		}
		
		return flag;
	}
	

	
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List sel(Object userdata) {
		ZbUserdata user=(ZbUserdata)userdata;
		String sql="select * from customerEnter where account='"+user.getAccount()+"'";
		// TODO Auto-generated method stub
		
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * 方法功能说明：  查询桌子
	 * 创建：2017-6-21 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List quertDesk(){
		
		String sql = "select * from desk where deskState='6' and deskdelState='19'";
		List list = DaoFactory.Query(sql);
		
		return list;
	}
	/**
	 * 
	 * 方法功能说明：     		--分页中得到的总条数--cus_enter (视图)
	 * 创建：2017-6-26 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return int     
	 * @throws
	 */
	public int getCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from cus_enter1";
		List list = DaoFactory.Query(sql);
		int total = 0;
		List li = (List) list.get(0);
		total = (Integer) li.get(0);
		return total;
	}
	public List page(int currPage) {
		System.out.println("currPage:"+currPage);
		String sql="select top ("+3+") * from cus_enter1 where Id not in(select top "+(currPage)*3+" Id from cus_enter1)";
		List list = DaoFactory.Query(sql);
		
		return list;
	}
	//----------------------------------------------------------------------28--------
	public List userInfo(String user){
		String sql="select * from customerEnter ce,customerInfo ci where ce.account='"+user+"' and ce.enterId=ci.enterId";
		return DaoFactory.Query(sql);
	}
	
}
