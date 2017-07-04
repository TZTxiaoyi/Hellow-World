package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.ZbCustomerInfo;
import com.entity.ZbDesk;
import com.entity.ZbUsagedata;
import com.entity.ZbUserdata;
import com.entity.Zbcus_enter1;
import com.insertemploydao.LjlDish;
import com.insertemploydao.ZbRegister;
import com.utils.toJson;
	/**
	 * 
	 * @类功能说明：  
	 * @类修改者：  
	 * @修改日期：  
	 * @修改说明：  
	 * @公司名称：adam  
	 * @作者：zhubin  
	 * @创建时间：2017-6-20 上午9:23:13  
	 * @版本：V1.0
	 */
public class ZbCustomerAction {
	private ZbUserdata userdata;//注册
	ZbUsagedata zbud;
	ZbDesk zbde;
	public LjlDish getDish() {
		return dish;
	}

	public void setDish(LjlDish dish) {
		this.dish = dish;
	}

	public ZbRegister getRe() {
		return re;
	}

	public void setRe(ZbRegister re) {
		this.re = re;
	}

	public Object getAdnm() {
		return adnm;
	}

	public void setAdnm(Object adnm) {
		this.adnm = adnm;
	}
	ZbCustomerInfo zbcin;
	int currpage;
	int currpage1;
	private Zbcus_enter1 zb;
	public Zbcus_enter1 getZb() {
		return zb;
	}

	public void setZb(Zbcus_enter1 zb) {
		this.zb = zb;
	}

	public int getCurrpage() {
		return currpage;
	}

	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	private String ser;
	
	public String getSer() {
		return ser;
	}

	public void setSer(String ser) {
		this.ser = ser;
	}

	public ZbCustomerInfo getZbcin() {
		return zbcin;
	}

	public void setZbcin(ZbCustomerInfo zbcin) {
		this.zbcin = zbcin;
	}
	LjlDish dish=new LjlDish();
	
	public ZbDesk getZbde() {
		return zbde;
	}

	public void setZbde(ZbDesk zbde) {
		this.zbde = zbde;
	}

	public ZbUsagedata getZbud() {
		return zbud;
	}

	public void setZbud(ZbUsagedata zbud) {
		this.zbud = zbud;
	}
	ZbRegister re=new ZbRegister();
	private Object adnm;
	
	public ZbUserdata getUserdata() {
		return userdata;
	}

	public void setUserdata(ZbUserdata userdata) {
		this.userdata = userdata;
	}
	/**
	 * 
	 * 方法功能说明： 开始点餐
	 * 创建：2017-6-21 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public void orders(){
		List list = re.quertDesk();
		JSON json = toJson.toJson("js",list);
		HttpServletResponse hsp = ServletActionContext.getResponse();
		hsp.setContentType("text/html,charset=utf-8");
		
		hsp.setCharacterEncoding("utf-8");
		
		try {
			hsp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//+++++++++++++++++++++++++++++++++++-----------------------------------
	/**
	 * 
	 * 方法功能说明：                                顾客信息
	 * 创建：2017-6-24 by zhubin   
	 * 修改：日期 by 修改者  zbcin
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
		public void client(){
			List list = re.queryinfo();
			JSON json = toJson.toJson("js", list);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html,charset=utf-8");
			resp.setCharacterEncoding("utf-8");
			System.out.println(list);
			try {
				resp.getWriter().print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//-----------------------分页---------------------------------------------------------
		/**
		 * 
		 * 方法功能说明：  		总条数
		 * 创建：2017-6-26 by zhubin   
		 * 修改：日期 by 修改者  
		 * 修改内容：  
		 * @参数：       
		 * @return void     
		 * @throws
		 */
		public void zbtotalpage(){
			int total = re.getCount();
			
			HttpServletResponse resp = ServletActionContext.getResponse();
			
			try {
				resp.getWriter().print(total);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public void zbtabpage(){
			List list = re.page(currpage);
			JSON json = toJson.toJson("ss", list);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html;charset=UTF-8");
			resp.setCharacterEncoding("utf-8");
			
			try {
				resp.getWriter().print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//------------------------------------------------------------------------------------
		/**
		 * 
		 * 方法功能说明：  						快速查询顾客信息
		 * 创建：2017-6-24 by zhubin   
		 * 修改：日期 by 修改者  
		 * 修改内容：  
		 * @参数：       
		 * @return void     
		 * @throws
		 */
		public void zbquinfo(){
			
			List list = re.selcustomer(ser);
			JSON json = toJson.toJson("js", list);
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setContentType("text/html,charset=utf-8");
			resp.setCharacterEncoding("utf-8");
			System.out.println(list);
			try {
				resp.getWriter().print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	/**
	 * 
	 * 方法功能说明：  、、、、注册
	 * 创建：2017-6-20 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public String register(){
		
		System.out.println(userdata.getAccount()+","+userdata.getPwd());
		int li = re.add(userdata);
		if(li == 1){
			
			HttpServletRequest htsr = ServletActionContext.getRequest();
			htsr.setAttribute("zb", 1);
			return "register";
		}
		return null;
		
		
	}
	/**
	 * @param adnm 
	 * 
	 * 方法功能说明：  		顾客信息完善表
	 * 创建：2017-6-26 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public String nom(){
		System.out.println("-----------------");
		System.out.println(zb.getName()+","+zb.getSex()+","+zb.getPhone1()+","+zb.getAdress()+","+zb.getAge());
		int zbli = re.addnom(adnm);
		if(zbli == 1){
			HttpServletRequest req = ServletActionContext.getRequest();
			req.setAttribute("aa", 1);
			return "register";
		}
		return null;
	}
	/**
	 * 
	 * 方法功能说明：     。。。。登录
	 * 创建：2017-6-21 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public String login(){
		
		
		int list = re.loginsel(zbud);
		System.out.println("liost:"+list);
		//JSON json = toJson.toJson("account",list );//转型

	
		

		HttpServletResponse hsr = ServletActionContext.getResponse();
		HttpServletRequest request=ServletActionContext.getRequest();//获取请求
		System.out.println(list);

		hsr.setContentType("text/html,charset=utf-8");
		hsr.setCharacterEncoding("utf-8");
		List list1=dish.sel();
		request.setAttribute("dishList", list1);
		try {
			hsr.getWriter().print(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list==1){
			request.setAttribute("user", zbud.getAccount());
			return "list";
			
		}else{
			HttpServletRequest ht = ServletActionContext.getRequest();
			ht.setAttribute("na", "k");//添加指定的属性，并为其赋指定的值
			return "register";
			
		}
	}
	
	/**
	 * 
	 * 方法功能说明：查询帐号  
	 * 创建：2017-6-20 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void seluser(){
		List list=re.sel(userdata);
		HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.getWriter().println(list.size());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//---------------------------------------------------------------------------------28--------
	public String ordering(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		session.setAttribute("username","dsd" );
		return "ordering";
		
	}	
	public void userInfo(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		String user=(String) session.getAttribute("username");
		List userlist=re.userInfo(user);
		System.out.println("++++="+userlist);
	}
}
