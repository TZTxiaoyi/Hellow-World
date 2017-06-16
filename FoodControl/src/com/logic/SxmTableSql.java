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
 * @类功能说明：  桌子的Sql语句
 * @类修改者：  
 * @修改日期：  
 * @修改说明：  
 * @公司名称：adam  
 * @作者：Administrator  
 * @创建时间：2017-6-14 下午3:24:31  
 * @版本：V1.0
 */
public class SxmTableSql implements DaoInterface{
	
	/**
	 * 
	 * 方法功能说明：  添加桌子
	 * 创建：2017-6-14 by Administrator   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param tab   桌子传参  
	 * @return void     
	 * @throws
	 */
	public int add(Object tabp ){
		SxmTable tab=(SxmTable)tabp;
		String sql="insert into desk values (?,?,?)";
		Object[] params=new Object[]{tab.getPersonNum(),tab.getDeskName(),tab.getDeskState()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 
	 * 方法功能说明：  查询桌子名字信息
	 * 创建：2017-6-14 by Administrator   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param tab    传参    桌子的名字
	 * @return void     
	 * @throws
	 */
	public int selTableName(Object tab){
		String sql="select deskName from desk";
		List list=(List)DaoFactory.Query(sql); 
		int flag=0;
		for(int i=0;i<list.size();i++){
			String a=(String) tab;
			List li=(List) list.get(i);
			String st=(String) li.get(0);
			if(a.equals(st)){
				flag=1;
			}
		}
		return flag;
	}
	/**
	 * @return 
	 * 
	     * 方法功能说明：  点击桌子管理按钮时查询数据库
	     * 创建：2017-6-15 by Administrator   
	     * 修改：日期 by songxianmeng
	     * 修改内容：  
	     * @参数：       
	     * @return void     
	     * @throws
	 */
	public Map selTableAdmin(Object obj){
		String sql="select d.deskName,d.personNum,s.Name,d.deskState,s.staffId from" +
				" desk d left outer join desk_staff ds on d.deskId=ds.deskId " +
				"left join staffInfo s on s.staffId=ds.staffId";
		List list=DaoFactory.Query(sql);
		JSONObject json=new JSONObject();
		for(int i=0;i<list.size();i++){
			Map map=new HashMap();
			map.put("df"+i,	list.get(i) );
			json.accumulateAll(map);
		}
		return json;	
	}

			
		
		


	/**
	 * 
	 * 方法功能说明：   删除桌子
	 * 创建：2017-6-14 by Administrator   
	 * 修改：日期 by 修改者  
	 * 修改内容： 
	 * @参数： @param tab   桌子传参  
	 * @return void     
	 * @throws
	 */
	public int del(Object tabp){
		SxmTable tab=(SxmTable)tabp;
		String sql="delete from desk where deskId=?";
		Object[] params=new Object[]{tab.getDeskId()};
		return DaoFactory.Updata(sql, params);
	}
	/**
	 * 
	 * 方法功能说明：  修改桌子信息
	 * 创建：2017-6-14 by Administrator   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public int update(Object tabp){
		SxmTable tab=(SxmTable)tabp;
		String sql="update desk set personNum=?,deskName=?,deskState=? where deskId=?";
		Object[] params=new Object[]{tab.getPersonNum(),tab.getDeskName(),tab.getDeskState(),tab.getDeskId()};
		return DaoFactory.Updata(sql, params);
		
	}
	/**
	 * 
	 * 方法功能说明：  查询桌子所有信息
	 * 创建：2017-6-14 by Administrator   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param tab    桌子传参    
	 * @return void     
	 * @throws
	 */
	public List sel(Object obj){
		String sql="select * from desk";
		List list=DaoFactory.Query(sql);
		//if(tab.getDeskName().equals(sql));
		return list;
	}
	
}
