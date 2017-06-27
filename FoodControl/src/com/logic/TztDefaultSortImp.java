
/**     
 * @文件名称: TztDefaultSoftImp.java  
 * @类路径: com.logic  
 * @描述: TODO  
 * @作者：TZT  
 * @时间：2017-6-22 下午4:11:29  
 * @版本：V1.0     
 */  
package com.logic;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.views.xslt.ArrayAdapter;

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
		List dishpriority = new ArrayList();
		dishpriority = dao.queryDishpriority(12);
		List madeList=new ArrayList();
		
		for(int i=0;i<dishpriority.size();i++){
			List dishList=new ArrayList();
			int a=(Integer) ((List)dishpriority.get(i)).get(2);
			int sum=1;
			String odId=((List)dishpriority.get(i)).get(0)+",";
			for (int j = i+1; j <dishpriority.size(); j++) {
				int b=(Integer) ((List)dishpriority.get(j)).get(2);
				if(a==b){
					//可能多运行一次
					odId=odId+((List)dishpriority.get(j)).get(0)+",";
					dishpriority.remove(j);
					sum++;
					j--;
				}
			}
			odId=odId.substring(0,odId.length()-1);
			dishList.add(odId);
			dishList.add(((List)dishpriority.get(i)).get(8));
			dishList.add(sum);		
			madeList.add(dishList);
		}
		return madeList;
	}

	public List queryMading() {
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession Session = req.getSession();
		Enumeration<String> e=Session.getAttributeNames();
		List resultList=new ArrayList();
		while (e.hasMoreElements()) {
			List list = new ArrayList();
			resultList.add(Session.getAttribute(e.nextElement()));
		}
		return resultList;
	}

	public List made(String dishId) {
		TztDishOrderImp dao =new TztDishOrderImp();
		TztDish dish = new TztDish();
		List list=new ArrayList();
		List dishList = dao.queryDishMax(dishId);
		int dishmax=(Integer) ((List) dishList.get(0)).get(7);
		dishId=dishId+",";
		String m="";
		int count =0;
		for (int i = 0; i < dishmax; i++) {
			int ind=dishId.indexOf(",");
			if (ind!=-1){
				m=m+dishId.substring(0,ind+1);
				dishId=dishId.substring(ind+1,dishId.length());
				count++;
			}else {
				break;
			}
		}
		m=m.substring(0,m.length()-1);
		dao.updataDishStatus(13, m);
		list.add(m);
		list.add(((List) dishList.get(0)).get(1));
		list.add(count);
		return list;
	}

	public List mading(String dishId) {
		HttpServletRequest req= ServletActionContext.getRequest();
		HttpSession session =req.getSession();
		List result=new ArrayList();
		TztDishOrderImp dao = new  TztDishOrderImp();
		dao.updataDishStatus(14, dishId);
		session.removeAttribute(dishId);
		List list= dao.queryDesk(dishId);
		
		for (int i=0; i<list.size();i++){
			List deskList=new ArrayList();
			int a=(Integer) ((List)list.get(i)).get(2);
			int sum=1;
			String desk = (String) ( (List)list.get(i)).get(10);
				for (int j = i+1; j <list.size(); j++) {
				int b=(Integer) ((List)list.get(j)).get(2);
				if(a==b){
					list.remove(j);
					sum++;
					j--;
				}
			}
			deskList.add(desk);
			deskList.add(sum);
			result.add(deskList);
		}
		return result;
	}

	public List remove(String dishId) {
		HttpServletRequest req= ServletActionContext.getRequest();
		HttpSession session =req.getSession();
		TztDishOrderImp dao = new  TztDishOrderImp();
		dao.updataDishStatus(12, dishId);
		session.removeAttribute(dishId);
		
		return null;
	}

}
