
/**     
 * @�ļ�����: TztDefaultSoftImp.java  
 * @��·��: com.logic  
 * @����: TODO  
 * @���ߣ�TZT  
 * @ʱ�䣺2017-6-22 ����4:11:29  
 * @�汾��V1.0     
 */  
package com.logic;

import java.util.List;

import com.alibaba.fastjson.parser.ParseContext;
import com.daointerface.TztSort;
import com.entity.TztDish;
import com.insertemploydao.TztDishImp;
import com.insertemploydao.TztDishOrderImp;

/**  
 * @�๦��˵����  Ĭ�������㷨
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-22 ����4:11:29  
 * @�汾��V1.0  
 */
public class TztDefaultSortImp implements TztSort {
	public List queryMade() {
		TztDishOrderImp dao =new TztDishOrderImp();
		List result = dao.queryMade();
		System.out.println(result);
		return result;
	}

	public List queryMading() {
		TztDishOrderImp  dao =new TztDishOrderImp();
		List result = dao.queryMading();
		return result;
	}

	public List made(String dishId) {
		TztDishImp dao=new TztDishImp();
		TztDish dish = new TztDish();
		int dishid = Integer.parseInt(dishId);
		dish.setDishId(dishid);
		List madedish =dao.sel(dish);
		TztDishOrderImp  dishImp= new TztDishOrderImp();
		dishImp.changeDish(13,(List)madedish.get(0),12);
		return null;
	}

	public List mading(String dishId) {
		TztDishImp dao=new TztDishImp();
		TztDish dish = new TztDish();
		int dishid = Integer.parseInt(dishId);
		dish.setDishId(dishid);
		List madedish =dao.sel(dish);
		TztDishOrderImp dishOrder =new TztDishOrderImp();
		List list = dishOrder.selectMax(13, (List)madedish.get(0));
		dishOrder.changeDish(14,(List)madedish.get(0),13);
		List tableList=dishOrder.queryDishTable(list);
		return tableList;
	}

}
