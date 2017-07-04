package com.achaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.LYEmployId;
import com.entity.LyPart;
import com.insertemploydao.LYInsertEmployDao;
import com.utils.toJson;

public class LYquanxianaction {
	
	private LYEmployId employId;
	private LyPart partname;
	String pname;
	private ArrayList<Integer> powersId;
	
	public ArrayList<Integer> getPowersId() {
		return powersId;
	}
	public void setPowersId(ArrayList<Integer> powersId) {
		this.powersId = powersId;
	}
	public LYEmployId getEmployId() {
		return employId;
	}
	public void setEmployId(LYEmployId employId) {
		this.employId = employId;
	}

	
	public LyPart getPartname() {
		return partname;
	}

	public void setPartname(LyPart partname) {
		this.partname = partname;
	}
	
	
	public String staffinfo(){
		return "sa";
	}
	public String staffid(){
		return "se";
	}
	public String powers(){
		return "ss";
	}
	public String deskmanage(){
		return "sc";
	}
	public String dishmanage(){
		return "sd";
	}
	public String kindmanage(){
		return "sf";
	}
	public String orderdetail(){
		return "sg";
	}
	public String returnorder(){
		return "sh";
	}
	public String incomedetail(){
		return "si";
	}	
	
	
	LYInsertEmployDao ied=new LYInsertEmployDao();
	/**
	 * getusername:��̨��¼��֤action
	 * �õ�ʵ���෵�ظ���listֵ���ж�list�ĳ��ȣ�������ҵ���ƥ��ĵ�ֵ��
	 * list�ĳ���һ��Ϊ1������Ҳ�����list�ĳ��Ⱦ�Ϊ1 
	 * ���Ϊ1�����û���������������success��struts���գ�������̨��ҳ����մ���ֵ
	 * �����Ϊ1����cuo��Ϣ���棬����false,struts���գ��ɺ�̨��¼������մ�����Ϣ��Ȼ�������жϣ�����������Ϣ
	 * @return
	 */
	public String getusername(){
		System.out.println("1");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//request.getSession().setAttribute("username", employId.getEmenter());	
		
		List list = ied.selectemid(employId);
		if (list.size()==1){			
			request.getSession().invalidate();
			String partname =ied.selectpart(employId);			
			if(partname.equals("����Ա")){							
				request.getSession().setAttribute("username", employId.getEmenter());
				return "part";
			}else if(partname.equals("��ʦ")){
				//request.getSession().setAttribute("username", employId.getEmenter());
				return "cook";
			}else{
				request.setAttribute("username", employId.getEmenter());
				List list4 = ied.aperson(partname);
				//System.out.println("999:"+list4);
				request.getSession().setAttribute("username",employId.getEmenter());
				request.getSession().setAttribute("listvalue", list4);
				return "success";
				
			}				
		}else {
			request.setAttribute("cuo", "haha");
			return "false";
		}
		
	}
	/**
	 * selpowers����ѯ��ɫ��ӵ�е�Ȩ��action
	 */
	public void selpowers(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");		
		List list = ied.selectpowers(partname);
		toJson json=new toJson();
		//System.out.println(json.toJson("value", list).toString());
		try {
			response.getWriter().print(json.toJson("value", list).toString());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * �ɽ�ɫId�ҵ���id��ӵ�е�����Ȩ��
	 * ��ǰ�˵õ���Ȩ��Id��Ȼ�󽫽�ɫid��Ȩ��idһ������selectpartId
	 */
	public void sertpow(){
		//System.out.println("00000000");
		//System.out.println("a:"+powersId);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int partId= ied.selectpartId(partname);
		
		//System.out.println("8888:"+partId);
		
		ied.deletpowers(partId);//����ɫ��Id����ʵ���࣬����idɾ����id�µ�����Ȩ�ޣ�
		ied.insertpowers(partId,powersId);		
	}
	/**
	 * ɾ����ɫ
	 */
	public void delpart(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int flag=ied.deletepart(partname);
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

