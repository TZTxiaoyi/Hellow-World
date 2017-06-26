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
	 * getusername:后台登录验证action
	 * 得到实现类返回给的list值，判断list的长度，如果能找到相匹配的的值，
	 * list的长度一定为1，如果找不到，list的长度就为1
	 * 如果为1，将用户名存起来，返回success，struts接收，跳到后台主页面接收存入值
	 * 如果不为1，将cuo信息保存，返回false,struts接收，由后台登录界面接收存入信息，然后做出判断，弹出错误信息
	 * @return
	 */
	public String getusername(){
		System.out.println("1");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		//request.getSession().setAttribute("username", employId.getEmenter());		
		List list = ied.selectemid(employId);
		
		System.out.println("0000:Z");		
		if (list.size()==1){
			String partname =ied.selectpart(employId);
			if(partname.equals("服务员")){				
				request.setAttribute("username", employId.getEmenter());
				return "part";
			}else if(partname.equals("厨师")){
				request.setAttribute("username", employId.getEmenter());
				return "cook";
			}else{
				System.out.println("5555");
				List list4 = ied.aperson(partname);
				//System.out.println("999:"+list4);
				request.setAttribute("username", employId.getEmenter());
				request.getSession().setAttribute("listvalue", list4);
				return "success";
				
			}				
		}else {
			request.setAttribute("cuo", "haha");
			return "false";
		}
		
	}
}

