package com.logic;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.daointerface.TztSort;
import com.insertemploydao.TztDishOrderImp;

/**  
 * @类功能说明：  
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-26 下午9:11:46  
 * @版本：V1.0  
 */
public class TztDeskSortImp implements TztSort {

	public List queryMade() {
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session =req.getSession();
		Integer dd= (Integer) session.getAttribute("desk");
		if(dd==null){
			dd=0;
		}
		TztDishOrderImp dao= new TztDishOrderImp();
		List dishpriority =dao.queryDishpriority(12);
		List desk = dao.quertDesk(12);
		//合并桌位合并后数组内剩下未重复的桌号
		List deskList= new ArrayList();
		for(int i=0;i<desk.size();i++){
			int a=(Integer) ((List) desk.get(i)).get(0);
			for (int j = i+1; j <dishpriority.size(); j++) {
				int b=(Integer) ((List) desk.get(j)).get(0);
				if(a==b){
					desk.remove(j);
					j--;
				}
		}
		
		
		
			
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
	public List remove(String dishId) {
		return null;
	}

}
