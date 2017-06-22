
package com.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
/**
 * 
 * @�๦��˵����  ���ӳ�
 * @���ߣ�TZT  
 * @����ʱ�䣺2017-6-13 ����9:01:32
 */
public class ConPool {
	/**
	 * ����set�������������ӳ�
	 */
	public ConPool(){
		setcon();
	}

	/**
	 * ��̬�������ӳر���
	 */
	
	private static BasicDataSource dataScource= null;

	/**
	 * 
	 * ��������˵����  �������ӳ�
	 * ������2017-6-13 by TZT  
	 * @������       
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
	 * ��������˵����  ������ӳص�����
	 * ������2017-6-13 by TZT  
	 * @������     
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
			System.out.println(e.getMessage()+"package com.utils/getConnection()����");

		}
		return null;

	}
	/**
	 * 
	 * ��������˵����  �ر����ӳ� ȫ�������رա����ٷ�����Դ
	 * ������2017-6-13 by TZT  
	 * @������       
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