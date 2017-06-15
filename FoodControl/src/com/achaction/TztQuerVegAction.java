package com.achaction;

import java.sql.Connection;

import com.utils.ConPool;


public class TztQuerVegAction {
	public String query() {
		Connection con= new ConPool().getConnection();
		
		return "querok";
	}
}
