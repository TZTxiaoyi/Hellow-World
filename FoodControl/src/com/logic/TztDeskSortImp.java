
/**     
 * @�ļ�����: TztDeskSortImp.java  
 * @��·��: com.logic  
 * @����: TODO  
 * @���ߣ�TZT  
 * @ʱ�䣺2017-6-26 ����9:11:46  
 * @�汾��V1.0     
 */  
package com.logic;

import java.util.List;

import com.daointerface.TztSort;
import com.insertemploydao.TztDishOrderImp;

/**  
 * @�๦��˵����  
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-26 ����9:11:46  
 * @�汾��V1.0  
 */
public class TztDeskSortImp implements TztSort {

	public List queryMade() {
		TztDishOrderImp dao= new TztDishOrderImp();
		List dishpriority =dao.queryDishpriority(12);
		
		return null;
	}
	public List queryMading() {
		return null;
	}

	public List made(String dishId) {
		return null;
	}

	public List mading(String dishId) {
		return null;
	}

}
