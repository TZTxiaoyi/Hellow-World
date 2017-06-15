package com.insertemploydao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import com.utils.ConPool;

public class InsertEmployDao {
	private ConPool conPool = new ConPool();
	public void eminsert(int emid,String emname,int emsex,int emage,int emphone,String empart,String emadress,String emjointime,int empartid){
		Connection con=conPool.getConnection();
		PreparedStatement ps=null;
		String sql="insert into staffinfo values(?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, emid);
			ps.setString(2,emname);
			ps.setInt(3, emage);
			ps.setInt(4, emphone);
			ps.setString(5, empart);
			ps.setString(6, emadress);
			ps.setString(7, emjointime);
			ps.setInt(9, empartid);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
