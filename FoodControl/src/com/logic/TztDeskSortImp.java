package com.logic;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.daointerface.TztSort;
import com.entity.TztDish;
import com.insertemploydao.TztDishOrderImp;

/**  
 * @�๦��˵����  ��λ��ת����
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-26 ����9:11:46  
 * @�汾��V1.0  
 */
public class TztDeskSortImp implements TztSort {

	public List queryMade() {
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session =req.getSession();
		Integer dd= (Integer) session.getAttribute("desk");
		if(dd==null){
			dd=0;
			session.setAttribute("desk", dd);
		}
		TztDishOrderImp dao= new TztDishOrderImp();
		//��ѯ����������Ҫ�����Ĳ�
		List dishpriority =dao.queryDishpriority(12);
		List desk = dao.quertDesk(12);
		//�ϲ���λ�ϲ���������ʣ��δ�ظ�������
		for(int i=0;i<desk.size();i++){
			int a=(Integer) ((List) desk.get(i)).get(0);
			for (int j = i+1; j <desk.size(); j++) {
				int b=(Integer) ((List) desk.get(j)).get(0);
				if(a==b){
					desk.remove(j);
					j--;
				}
			}
		}
		int table =dd;
		//�ֽ����в˰�����λ˳��ϲ���֮���漰����λ�϶�Ĳ�����ǰ��
		//�����������в�
		List madeList=new ArrayList();

		for(int d=0;d<desk.size();d++){//���ҵ���Ӧ������
			//Ѱ�ҵ�Ӧ�����ĸ�����Ϊ��һ���ȼ�
			if(table>=desk.size()){
				table=0;
			}
			int deskn=  (Integer) ((List) desk.get(table)).get(0);
			//�ҵ���������µĵ�һ���˽��в��˲���
			for( int i=0;i<dishpriority.size();i++){//����Ϊ�ϲ����ӳ�ͻ 
				List dishList=new ArrayList();
				int deska=(Integer) ((List)dishpriority.get(i)).get(4);
				int a=0;
				String odId="";
				int sum=0;
				int tablenum=table;
				String dishName="";

				if (deska==deskn) {//�������Ѱ�ҵ������ӱ��
					//��һ�˵Ĳ��˺�����
					dishName=(String) ((List)dishpriority.get(i)).get(8);
					a=(Integer) ((List)dishpriority.get(i)).get(2);
					
					for(int z=0;z<dishpriority.size();z++){//ѭ��������ѭ����Ϻ�δ�ܽ����в�Ʒ�ϲ����������ŵĲ˱��ж�Ϊ�ڶ�����
						//Ѱ��Ӧ���������λ�õ�����
						if(tablenum>=desk.size()){
							tablenum=0;
						}
						int desknum=  (Integer) ((List) desk.get(tablenum)).get(0);
						//��ͷ��ʼ��ʼ�ȶԲ�Ʒ�Ͷ�Ӧ������
						
						for (int j =0; j <dishpriority.size(); j++) {
							//ȡ�ñȽϵĲ�ƷB��źͲ�ƷB������
							int b=(Integer) ((List)dishpriority.get(j)).get(2);
							int deskb=(Integer) ((List)dishpriority.get(j)).get(4);
							if(a==b){//�����Ʒ��ͬ
								if(desknum==deskb){//���������ͬ
									odId=odId+((List)dishpriority.get(j)).get(0)+",";
									dishpriority.remove(j);
									sum++;
									////////BUG��û
								}
								z=-1;
							}
						}
						tablenum++;

					}//�����ڶ�
					odId=odId.substring(0,odId.length()-1);
					dishList.add(odId);
					dishList.add(dishName);
					dishList.add(sum);	

					//�ϲ�����
					List list= dao.queryDesk(odId);
					String de="";
					for(int j=0;j<list.size();j++){
						int aa=(Integer) ((List)list.get(j)).get(4);
						de=de+(String)((List) list.get(j)).get(10)+",";
						for (int k = j+1; k<list.size();k++) {
							int bb=(Integer) ((List)list.get(k)).get(4);
							if(aa==bb){
								list.remove(k);
								k--;
							}
						}

					}
					de=de.substring(0,de.length()-1);
					dishList.add(de);
					madeList.add(dishList);
				}//if
			}//����
			table++;
		}
		return madeList;
	}
	public List queryMading() {
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession Session = req.getSession();
		Enumeration<String> e=Session.getAttributeNames();
		List resultList=new ArrayList();
		while (e.hasMoreElements()) {
			resultList.add(Session.getAttribute(e.nextElement()));
		}
		return resultList;
	}

	public List made(String dishId) {
		HttpServletRequest req= ServletActionContext.getRequest();
		HttpSession session =req.getSession();
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

		List delist= dao.queryDesk(m);
		String de="";
		for(int j=0;j<delist.size();j++){
			int aa=(Integer)((List) delist.get(j)).get(4);
			de=de+(String)((List) delist.get(j)).get(10)+",";

			for (int k = j+1; k<delist.size();k++) {
				int bb=(Integer) ((List)delist.get(k)).get(4);
				if(aa==bb){
					delist.remove(k);
					k--;
				}
			}
		} 
		de=de.substring(0,de.length()-1);
		list.add(de);
		int aa=(Integer) session.getAttribute("desk");
		session.setAttribute("desk", aa+1);
		session.setAttribute((String) list.get(0),list);
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
			int a=(Integer) ((List)list.get(i)).get(4);
			int sum=1;
			String desk = (String) ( (List)list.get(i)).get(10);
			for (int j = i+1; j <list.size(); j++) {
				int b=(Integer) ((List)list.get(j)).get(4);
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
		Integer dd = (Integer) session.getAttribute("desk");
		session.removeAttribute(dishId);
		session.setAttribute("desk", dd);
		return null;
	}

}
