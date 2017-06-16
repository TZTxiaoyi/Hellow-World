package com.daointerface;

import java.util.List;

public interface DaoInterface {
	public int add(Object obj);
	public int del(Object obj);
	/**
	 * 
	 * 方法功能说明：   查询方法可以重载。若查询全部可以不载入参数
	 * 创建：2017-6-16 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param obj
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List sel(Object obj);
	public int update(Object obj);
}
