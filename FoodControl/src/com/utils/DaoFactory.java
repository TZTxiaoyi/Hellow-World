package com.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoFactory {
/**
 * 
 * 方法功能说明：  关闭所有资源
 * 创建：2017-6-13 by TZT  
 * @参数： @param con	Connection链接
 * @参数： @param ps	PreparedStatement 
 * @参数： @param rs  ResultSet
 * @return void     
 * @throws
 */
	public static void CloseAll(Connection con , PreparedStatement ps , ResultSet rs){
		try{	
			if(con!=null){con.close(); con=null;};
			if(ps!=null){ps.close();ps=null;};
			if(rs!=null){rs.close();rs=null;};
		}catch(Exception e){
			System.out.println(e.getMessage()+"com.utils.Daofactory. CloseAll()错误");
		}
	}
	/**
	 * 
	 * 方法功能说明：  PreparedStatement添加参数
	 * 创建：2017-6-13 by TZT  
	 * @参数： @param ps	PreparedStatement
	 * @参数： @param params   参数数组
	 * @return void     
	 * @throws
	 */
	public static void Setparams(PreparedStatement ps, Object[] params){

		for(int i = 0 ;i<params.length;i++){
			try {
				ps.setObject(i+1, params[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"com.utils.Daofactory Setparams()错误");
			}
		}
	}
	/**
	 * 
	 * 方法功能说明：  向更新数据
	 * 创建：2017-6-13 by TZT  
	 * @参数： @param sql	数据库语句
	 * @参数： @param params	参数数组
	 * @参数： @return      
	 * @return int     
	 * @throws
	 */
	public static int Updata(String sql, Object[]params){
		int flag=-1;
		try{
			ConPool conpool=new ConPool();
			Connection con= conpool.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			Setparams(ps, params);
			flag = ps.executeUpdate();
			CloseAll(con, ps, null);
		}catch(Exception e){
			System.out.println(e.getMessage()+"com.utils.Daofactory.Updata()错误");
			e.printStackTrace();
		}
		return flag;
	}
	/**
	 * 更新后返回结果集
	 * 方法功能说明：  
	 * 创建：2017-6-21 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param sql
	 * @参数： @param params
	 * @参数： @return      
	 * @return int     
	 * @throws
	 */
	public static int rsUpdata(String sql,Object[]params){
		ResultSet rs =null;
		int key=-1;
		try{
			ConPool conpool=new ConPool();
			Connection con= conpool.getConnection();
			PreparedStatement ps=con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			Setparams(ps, params);
			ps.executeUpdate();
	        rs = ps.getGeneratedKeys();  
	        if(rs.next()){  
	            key = rs.getInt(1);  
	        } 
	        CloseAll(con, ps, null);
		}catch(Exception e){
			System.out.println(e.getMessage()+"com.utils.Daofactory.rsUpdata()错误");
		}
		return key;
	}
	/**
	 * 
	 * 方法功能说明：  查询数据库数据
	 * 创建：2017-6-13 by TZT  
	 * @参数： @param sql 数据库语句
	 * @参数： @return      
	 * @return List     将查询结果封装成List返回
	 * @throws
	 */
	public static List Query(String sql){
		List dataTable =new ArrayList();
		try{
			ConPool conpool=new ConPool();
			Connection con = conpool.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			int colum = rs.getMetaData().getColumnCount();
			while(rs.next()){
				List rowList = new ArrayList();
				for(int i = 0 ;i<colum;i++){
					rowList.add(rs.getObject(i+1));
				}
				dataTable.add(rowList);
			}
			CloseAll(con, ps, rs);
		}catch(Exception e){
			System.out.println(e.getMessage()+"com.utils.Daofactory.Query()错误");
		}
		return dataTable;
	}
}


