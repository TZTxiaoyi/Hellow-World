package com.achaction;



import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSON;
import org.apache.struts2.ServletActionContext;
import com.entity.LYEmployId;
import com.entity.LYEmployee;
import com.entity.LyPart;
import com.insertemploydao.LYInsertEmployDao;

import com.utils.toJson;

public class LYInsertEmployaction {
	/*
	 * employee:Ա��ʵ���ഴ���Ķ���
	 * 
	 * employid��Ա���˺�ʵ���ഴ���Ķ���
	 * 
	 * putvalue(��ǰ�����)�����մ���Ϊstring���͵�ֵ��
	 * 
	 * countp  age(��ǰ�����)�����մ���Ϊint���͵�ֵ
	 */	
	private LYEmployee employee;
	private LYEmployId employId;
	private String putvalue;
	private int countpage;
	private LyPart partname;
	
	public LyPart getPartname() {
		return partname;
	}

	public void setPartname(LyPart partname) {
		this.partname = partname;
	}
	/**
	 * LYInsertEmployDao��ʵ����
	 * 
	 * ied:ʵ������󣬿��Ե���ʵ����ķ���
	 */
	LYInsertEmployDao ied=new LYInsertEmployDao();
	
	/**
	 * һϵ��set��get����
	 * @return
	 */
	public int getCountpage() {
		return countpage;
	}

	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
	public LYEmployId getEmployId() {
		return employId;
	}

	public void setEmployId(LYEmployId employId) {
		this.employId = employId;
	}	
	public LYEmployee getEmployee(){
		return employee;
	}
	public void setEmployee(LYEmployee employee) {
		this.employee = employee;
	}
	public String getPutvalue(){
		return putvalue;
	}
	public void setPutvalue(String putvalue) {
		this.putvalue = putvalue;
	}
	
	
	/**
	 * ʧ��ʱ���ѯԱ�����
	 */
	public void selemid(){
		HttpServletResponse response=ServletActionContext.getResponse();
		System.out.println(00000);
		List list=ied.selstaffid(employee);		
		try {	
				response.getWriter().print(list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	/**
	 * �ȸ��ݽ�ɫ���Ʋ�ѯ��ɫid
	 * �ٸ����˺Ų�ѯ�˺�id
	 * save:�õ���Ӧ��
	 * ����Ա��ʵ���෽��
	 * ��Ա��ʵ������󴫸�Ա��ʵ���෽��
	 * 
	 */
	public void save(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int partId = ied.selectpartId(partname);
		int enterId = ied.selectenterid(employId);
		ied.updatestate(enterId);
		int flag=ied.eminsert(employee,partId,enterId);	
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * ��ѯԱ�������н�ɫ����
	 */
	public void selpa(){	
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	
		//System.out.println("888888888");
		List list = ied.selpaList();
		JSON json=toJson.toJson("value", list);	
		//System.out.println(json);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * ɾ���˺�
	 */
	public void delaccount(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int flag=ied.delnumber(employId);
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * ģ����ѯ�˺�
	 */
	public void searchac(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	
		List list=ied.searchacclist(countpage,putvalue);
		JSON json=toJson.toJson("value", list);
		System.out.println(json);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	/**
	 * emterid���õ�ǰ����Ӧ������enterid������
	 * ����Daoʵ���෽��
	 * ��Ա���˺ŵ�ʵ������󴫸�����Ա���˺ŵ�ʵ���෽��
	 */
	public void enterid(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int flag=ied.emidinsert(employId);		
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * ʧ���¼���ѯ�˺�
	 */
	public void selaccount(){
		HttpServletResponse response=ServletActionContext.getResponse();
		List list=ied.selacc(employId);
		try {	
				response.getWriter().print(list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	   /**
		 * 
	     * ��������˵����  ��Ա����Ϣ�ŵ�list�У�
	     * �ٽ�list����json�У�
	     * ����ǰ̨data����json������json
	     * ������2017-6-15 by Administrator   
	     * �޸ģ����� by 
	     * �޸����ݣ�  
	     * @������       
	     * @return void     
	     * @throws
	   */
	public void selem(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		List<String> list=ied.selemploy(employee);	
		System.out.println("000:"+list);
		toJson json=new toJson();
	
		json.toJson("vlaue", list);	
		
		try {
			response.getWriter().print(json.toJson("vlaue", list).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * delem:ɾ��Ա��action
	 */
	public void delem(){
		 HttpServletResponse response=ServletActionContext.getResponse();
		 ied.upstate(employId);
		 int flag=ied.delone(employee);
		 try {
			response.getWriter().print(flag);
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * updatestaff:�޸�Ա����Ϣ��action
	 * �õ�Ա��dao�������ظ��޸�Ա��ʵ�����ֵ��
	 * �ٽ�ֵ��ǰ̨���ж��Ƿ��޸ĳɹ����
	 * @return
	 */
	public void updatestaff(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		int flag=9;
		int partId = ied.selectpartId(partname);
		flag=ied.update(employee,partId);		
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		} 	
	}
	
	/**
	 * searchEM:ģ����ѯaction
	 */
	public void searchEM(){		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");			
		List<String> list=ied.searchsome(putvalue);
		//System.out.println(list);
		toJson json=new toJson();
		try {			
			response.getWriter().print(json.toJson("value", list).toString());			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}


	/**
	 * getcount:���Ա������������action
	 */
	public void getcount(){		
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=ied.getallpage();		
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		} 		
	} 
	/**
	 * getpage:��ǰ̨data������ֵ��countpage���գ�����pagepage(ʵ���෽��)
	 * �õ�����list������ѯ�Ľ���ŵ�json�У����ظ�ǰ̨data
	 */
	public void getpage(){		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=ied.pagepage(countpage);
		JSON json=toJson.toJsonArray("value", list);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * modul:Ȩ�ޱ�action
	 */
	public void modul(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	
		List list = ied.selectpartname();
		JSON json=toJson.toJson("value", list);		
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * ��ӽ�ɫaction
	 */
	public void addpart(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int flag=ied.addpartname(partname);
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * ��ӽ�ɫʧ���¼��ж��Ƿ��Ѵ��ڵĽ�ɫ
	 */
	public void reselpart(){
		HttpServletResponse response=ServletActionContext.getResponse();
		List list=ied.selpt(partname);
		try {
			response.getWriter().print(list.size());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * getacount:���Ա���˺ű���������action
	 */
	public void getaccount(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		int a=ied.getpages(putvalue);		
		try {
			response.getWriter().print(a);
		} catch (Exception e) {
			// TODO: handle exception
		} 		
	} 
	/**
	 * getpage:��ǰ̨data������ֵ��countpage���գ�����pagepage(ʵ���෽��)
	 * �õ�����list������ѯ�Ľ���ŵ�json�У����ظ�ǰ̨data
	 */
	public void getidpage(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list=ied.setpages(countpage);
		JSON json=toJson.toJsonArray("value", list);
		//System.out.println(json);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * updatestaff:�޸�Ա����Ϣ��action
	 * �õ�Ա��dao�������ظ��޸�Ա��ʵ�����ֵ��
	 * �ٽ�ֵ��ǰ̨���ж��Ƿ��޸ĳɹ����
	 * @return
	 */
	public void updatestaffid(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");

		int	flag=ied.updateid(employId);
		//System.out.println("7777:"+flag);
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		} 	
	}
	/**
	 * ��������̨��Ϣʱ�Զ���ʾ���з���Ա
	 */
	public void selectservice(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List list=ied.selectfu();
		JSON json=toJson.toJson("cc", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void appendlogin(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=ied.applogin();
		JSON json=toJson.toJson("cc", list);
		try {
			response.getWriter().print(json);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
