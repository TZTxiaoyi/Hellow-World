package com.achaction;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;

import org.apache.struts2.ServletActionContext;

import com.entity.LjlAddOrder;
import com.insertemploydao.LjlOrders;
import com.insertemploydao.LyOrderDao;
import com.utils.toJson;

public class LyOrderAction {
	private int countpage;
	
	private String begintime;
	private String endtime;
	
	LjlOrders ljd=new LjlOrders();
	LyOrderDao ld= new LyOrderDao();
	
	public String getBegintime() {
		return begintime;
	}
	public void setBegintime(String begintime) {
		this.begintime = begintime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public int getCountpage() {
		return countpage;
	}
	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
	
	public void pageTotal(){
		HttpServletResponse response=ServletActionContext.getResponse();	
		int flag = ld.getcount();	
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getpage(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	
		//System.out.println("9999999:"+countpage);
		List list=ld.pagesize(countpage);
		JSON json=toJson.toJson("value", list);
		//System.out.println("8888:"+json);
		try {
			response.getWriter().print(json);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 得到id后
	 */
	public void orderdish(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//System.out.println("56565:"+countpage);
		List list=ljd.orderDish(countpage);
		System.out.println("1314:"+list);
		JSON json=toJson.toJson("value", list);
		try {
			response.getWriter().print(json);
		}catch (Exception e){
			// TODO: handle exception
		}
	}
	public void selorder(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		List list=ld.setimeorder(begintime,endtime);
		//System.out.println("1314:"+list);
		JSON json=toJson.toJson("value", list);
		try {
			response.getWriter().print(json);
		}catch (Exception e){
			// TODO: handle exception
		}
	}
	
	
	
	
	public void removeTotal(){
		HttpServletResponse response=ServletActionContext.getResponse();	
		int flag = ld.acount();	
		try {
			response.getWriter().print(flag);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void apages(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");	
		System.out.println("9999999:"+countpage);
		List list=ld.asizes(countpage);
		JSON json=toJson.toJson("value", list);
		System.out.println("json:"+json);
		try {
			response.getWriter().print(json);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 得到id后
	 */
	/*public void relorder(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
	
		List list=ld.anothertime(begintime,endtime);
		//System.out.println("1314:"+list);
		JSON json=toJson.toJson("value", list);
		try {
			response.getWriter().print(json);
		}catch (Exception e){
			// TODO: handle exception
		}
	}*/
}
