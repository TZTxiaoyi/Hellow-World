package com.daointerface;

import java.util.List;

public interface DaoInterface {
	public int add(Object obj);
	public int del(Object obj);
	public List sel(Object obj);
	public int update(Object obj);
}
