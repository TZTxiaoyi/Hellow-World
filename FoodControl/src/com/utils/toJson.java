package com.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
/**
 * 
 * @类功能说明：  将对象或者数字封装成JSON
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-15 下午11:35:56  
 * @版本：V1.0
 */
public class toJson {
	/**
	 * 
	 * 方法功能说明：  将对象封装成JSON
	 * 创建：2017-6-15 by Tzt  
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param value	JSON中存放的Map的键值，以MAP+I的形式储存
	 * @参数： @param obj		对象数组
	 * @参数： @return      
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
	 * 方法功能说明：  	将list封装成JSON
	 * 创建：2017-6-15 by tzt   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param vlaue	JSON中存放的Map的键值，以MAP+I的形式储存	
	 * @参数： @param list		需要封装的数组
	 * @参数： @return      
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
	 * 方法功能说明：  JSON数组
	 * 创建：2017-6-26 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param vlaue
	 * @参数： @param list
	 * @参数： @return      
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
