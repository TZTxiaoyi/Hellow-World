package com.daointerface;

import java.util.List;

public interface DaoInterface {
	public int add(Object obj);
	public int del(Object obj);
	/**
	 * 
	 * ��������˵����   ��ѯ�����������ء�����ѯȫ�����Բ��������
	 * ������2017-6-16 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param obj
	 * @������ @return      
	 * @return List     
	 * @throws
	 */
	public List sel(Object obj);
	public int update(Object obj);
}
