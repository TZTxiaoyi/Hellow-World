
/**     
 * @文件名称: TztDefaultSoftImp.java  
 * @类路径: com.logic  
 * @描述: TODO  
 * @作者：TZT  
 * @时间：2017-6-22 下午4:11:29  
 * @版本：V1.0     
 */  
package com.logic;

import java.util.List;

import com.alibaba.fastjson.parser.ParseContext;
import com.daointerface.TztSort;
import com.entity.TztDish;
import com.insertemploydao.TztDishImp;
import com.insertemploydao.TztDishOrderImp;

/**  
 * @类功能说明：  默认排序算法
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-22 下午4:11:29  
 * @版本：V1.0  
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
