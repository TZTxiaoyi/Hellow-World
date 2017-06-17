package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		System.out.println("--------1111------");
		try{
			ConPool conpool=new ConPool();
			Connection con= conpool.getConnection();
			PreparedStatement ps= con.prepareStatement(sql);
			Setparams(ps, params);
			flag = ps.executeUpdate();
			System.out.println("--------------");
			System.out.println(flag);
			CloseAll(con, ps, null);
		}catch(Exception e){
			System.out.println(e.getMessage()+"com.utils.Daofactory.Updata()错误");
		}
		return flag;
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
			System.out.println(e.getMessage()+"com.utils.Daofactory.Quert()错误");
		}
		return dataTable;
	}
}


