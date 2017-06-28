package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.ZbUsagedata;
import com.entity.ZbUserdata;
import com.utils.DaoFactory;

public class ZbRegister implements DaoInterface{

	
	public int add(Object user) {
		ZbUserdata userdata=(ZbUserdata)user;
		// TODO Auto-generated method stub
		String sql="insert customerEnter values (?,?,?)";
		Object[] params=new Object[]{userdata.getAccount(),userdata.getPwd(),19};
		int flag=DaoFactory.Updata(sql, params);
		return flag;
	}

	
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


	
}
