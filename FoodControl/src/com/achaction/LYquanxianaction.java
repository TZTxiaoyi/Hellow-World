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
		if (list.size()==1){			
			request.getSession().invalidate();
			String partname =ied.selectpart(employId);			
			if(partname.equals("服务员")){							
				request.getSession().setAttribute("username", employId.getEmenter());
				return "part";
			}else if(partname.equals("厨师")){
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
	 * selpowers：查询角色所拥有的权限action
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
	 * 由角色Id找到该id下拥有的所有权限
	 * 由前端得到的权限Id，然后将角色id和权限id一并传给selectpartId
	 */
	public void sertpow(){
		//System.out.println("00000000");
		//System.out.println("a:"+powersId);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int partId= ied.selectpartId(partname);
		
		//System.out.println("8888:"+partId);
		
		ied.deletpowers(partId);//将角色的Id传到实现类，根据id删除该id下的所有权限；
		ied.insertpowers(partId,powersId);		
	}
	/**
	 * 删除角色
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

