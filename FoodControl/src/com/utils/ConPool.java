
package com.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * 
 * @类功能说明：  连接池
 * @作者：TZT  
 * @创建时间：2017-6-13 上午9:01:32
 */
public class ConPool {
	/**
	 * 运行set方法。创建连接池
	 */
	public ConPool(){
		setcon();
	}

	/**
	 * 静态创建连接池变量
	 */
	
	private static BasicDataSource dataScource= null;

	/**
	 * 
	 * 方法功能说明：  创建连接池
	 * 创建：2017-6-13 by TZT  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	private void setcon(){
		dataScource = new BasicDataSource();
		dataScource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataScource.setUrl("jdbc:sqlserver://172.16.22.62:1433; DatabaseName= FoodControl");

		dataScource.setUsername("sa");
		dataScource.setPassword("123456");
	}
	/**
	 * 
	 * 方法功能说明：  获得连接池的链接
	 * 创建：2017-6-13 by TZT  
	 * @参数：     
	 * @return Connection     
	 * @throws
	 */
	public Connection getConnection(){

		try {
			if(dataScource !=null){
				return dataScource.getConnection();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage()+"package com.utils/getConnection()错误");

		}
		return null;

	}
	/**
	 * 
	 * 方法功能说明：  关闭连接池 全部用完后关闭。不再返回资源
	 * 创建：2017-6-13 by TZT  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public static void close(){
		try {
			dataScource.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}