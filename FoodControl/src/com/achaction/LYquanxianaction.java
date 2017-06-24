package com.achaction;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.LYEmployId;
import com.insertemploydao.LYInsertEmployDao;


public class LYquanxianaction {
	
	private LYEmployId employId;
	
	public LYEmployId getEmployId() {
		return employId;
	}
	public void setEmployId(LYEmployId employId) {
		this.employId = employId;
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
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//request.getSession().setAttribute("username", employId.getEmenter());		
		List list = ied.selectemid(employId);
		
		//System.out.println("0000:"+list1);		
		if (list.size()==1){
			request.getSession().invalidate();
			String partname =ied.selectpart(employId);
			if(partname.equals("����Ա")){			
				
				request.getSession().setAttribute("username", employId.getEmenter());
				return "part";
			}else if(partname.equals("��ʦ")){
				request.getSession().setAttribute("username", employId.getEmenter());
				return "cook";
			}else{
				request.setAttribute("username", employId.getEmenter());
				List list4 = ied.aperson(partname);
				//System.out.println("999:"+list4);
				request.getSession().setAttribute("username", employId.getEmenter());
				request.getSession().setAttribute("listvalue", list4);
				return "success";
			}				
		}else {
			request.setAttribute("cuo", "haha");
			return "false";
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
}

