package com.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
/**
 * 
 * @�๦��˵����  ������������ַ�װ��JSON
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-15 ����11:35:56  
 * @�汾��V1.0
 */
public class toJson {
	/**
	 * 
	 * ��������˵����  �������װ��JSON
	 * ������2017-6-15 by Tzt  
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param value	JSON�д�ŵ�Map�ļ�ֵ����MAP+I����ʽ����
	 * @������ @param obj		��������
	 * @������ @return      
	 * @return JSON     
	 * @throws
	 */
	public static JSON toJson(String value,Object[] obj) {
		JSONObject json=new JSONObject();
		for (int i = 0; i <obj.length; i++) {
			Map map=new HashMap();
			map.put(value+""+i,obj[i]);
			json.accumulateAll(map);
		}
		return json;
	}
	/**
	 * 
	 * ��������˵����  	��list��װ��JSON
	 * ������2017-6-15 by tzt   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param vlaue	JSON�д�ŵ�Map�ļ�ֵ����MAP+I����ʽ����	
	 * @������ @param list		��Ҫ��װ������
	 * @������ @return      
	 * @return JSON     
	 * @throws
	 */
	public  static JSON toJson(String vlaue,List list){
		JSONObject json=new JSONObject();
		for(int i=0;i<list.size();i++){
			Map map=new HashMap();
			map.put(vlaue+""+i,	list.get(i) );
			json.putAll(map);
		}
		System.out.println(json);
		return json;	
	}
	
	/**
	 * 
	 * ��������˵����  JSON����
	 * ������2017-6-26 by TZT   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @param vlaue
	 * @������ @param list
	 * @������ @return      
	 * @return JSONArray     
	 * @throws
	 */
	public static  JSONArray toJsonArray(String vlaue,List list) {
		JSONArray json = new JSONArray();
		for(int i=0;i<list.size();i++){
		json.add(list.get(i));
		}
		return json;
	}
}
