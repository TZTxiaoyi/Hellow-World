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
 * ��������˵����  �ر�������Դ
 * ������2017-6-13 by TZT  
 * @������ @param con	Connection����
 * @������ @param ps	PreparedStatement 
 * @������ @param rs  ResultSet
 * @return void     
 * @throws
 */
	public static void CloseAll(Connection con , PreparedStatement ps , ResultSet rs){
		try{	
			if(con!=null){con.close(); con=null;};
			if(ps!=null){ps.close();ps=null;};
			if(rs!=null){rs.close();rs=null;};
		}catch(Exception e){
			System.out.println(e.getMessage()+"com.utils.Daofactory. CloseAll()����");
		}
	}
	/**
	 * 
	 * ��������˵����  PreparedStatement��Ӳ���
	 * ������2017-6-13 by TZT  
	 * @������ @param ps	PreparedStatement
	 * @������ @param params   ��������
	 * @return void     
	 * @throws
	 */
	public static void Setparams(PreparedStatement ps, Object[] params){

		for(int i = 0 ;i<params.length;i++){
			try {
				ps.setObject(i+1, params[i]);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"com.utils.Daofactory Setparams()����");
			}
		}
	}
	/**
	 * 
	 * ��������˵����  ���������
	 * ������2017-6-13 by TZT  
	 * @������ @param sql	���ݿ����
	 * @������ @param params	��������
	 * @������ @return      
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
			System.out.println(e.getMessage()+"com.utils.Daofactory.Updata()����");
		}
		return flag;
	}
	/**
	 * 
	 * ��������˵����  ��ѯ���ݿ�����
	 * ������2017-6-13 by TZT  
	 * @������ @param sql ���ݿ����
	 * @������ @return      
	 * @return List     ����ѯ�����װ��List����
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
			System.out.println(e.getMessage()+"com.utils.Daofactory.Quert()����");
		}
		return dataTable;
	}
}


