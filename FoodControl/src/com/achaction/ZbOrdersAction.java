package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSON;

import com.entity.LjldishS;
import com.entity.ZbDetails;
import com.insertemploydao.ZbRegister;
import com.utils.toJson;

public class ZbOrdersAction {
	private LjldishS dish;
	private ZbDetails zbde;
	private int orderD;//
	private int currpage;
	ZbRegister re=new ZbRegister();
	public int getOrderD() {
		return orderD;
	}

	public void setOrderD(int orderD) {
		this.orderD = orderD;
	}

	public int getCurrpage() {
		return currpage;
	}

	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}

	public ZbDetails getZbde() {
		return zbde;
	}

	public void setZbde(ZbDetails zbde) {
		this.zbde = zbde;
	}
	
	
	public LjldishS getDish() {
		return dish;
	}

	public void setDish(LjldishS dish) {
		this.dish = dish;
	}
	
	public void ZbOrder(){
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=utf-8");
		List list =re.zbordersInfo(orderD);
		JSON json = toJson.toJson("toj", list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void dishnum(){
		//System.out.println("ttt");
		List list=re.dishnumsql();
		JSON json=toJson.toJson("dish", list);
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void orders(){	
		//System.out.println("ddf");
		List list = re.zbSelectDesk();
		JSON json = toJson.toJson("js",list);
		HttpServletResponse hsp = ServletActionContext.getResponse();
		hsp.setContentType("text/html;charset=UTF-8");
		hsp.setCharacterEncoding("utf-8");
		
		try {
			hsp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void zbtotalpage(){
		//System.out.println("ji");
		//System.out.println(zbde.getVa()+","+zbde.getVa1()+","+zbde.getVa2());
		HttpServletResponse response=ServletActionContext.getResponse();
		int totalpage=-1;
		//System.out.println("flag:"+zbde.getSelflag());
		if(zbde.getSelflag()==1){
			List list=re.totalcurr(zbde);
			List list1=(List) list.get(0);
			totalpage=(Integer) list1.get(0);	
		}else if(zbde.getSelflag()==2){
			List list=re.zbdishtotal(zbde);
			totalpage=list.size();	
		}else if(zbde.getSelflag()==3||zbde.getSelflag()==5){
			System.out.println("ssd");
			List list=re.ZbDeskNum();
			List list2=(List) list.get(0);
			totalpage=(Integer) list2.get(0);
		}else if(zbde.getSelflag()==4||zbde.getSelflag()==6){
			List list=re.ZbDishNum();
			List list2=(List) list.get(0);
			totalpage=(Integer) list2.get(0);
		}
		//System.out.println("zongye:"+totalpage);
		try {
			response.getWriter().print(totalpage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void zbDeskQu(){
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		List list = re.ZbOrderss(zbde);
		//System.out.println("dfsf"+list);
		JSON json = toJson.toJson("jsn", list);
		//System.out.println(json);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void zbDishQu(){
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		//System.out.println("£º"+zbde.getCurr());
		List list=re.ZbOrdersdish(zbde);
		JSON json=toJson.toJson("dish", list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ZbdishStatistics(){
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		List list=re.ZbDishStatistics(zbde);
		//System.out.println("slist:"+list);
		JSON json=toJson.toJson("dishStatistics", list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void ZbdeskStatistics(){
		//System.out.println("ddd");
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setContentType("text/html;charset=UTF-8");
		List list =re.ZbDeskStatistics(zbde);
		JSON json=toJson.toJson("desk", list);
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void Zbdeskall(){
		//System.out.println("ALL");
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=re.ZbDeskAll(zbde);
		//System.out.println("all"+list);
		JSON json=toJson.toJson("deskall", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Zbdishall(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=re.ZbDishAll(zbde);
		System.out.println("alldish:"+list);
		JSON json=toJson.toJson("dishall", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void Zbdeskallno(){
		//System.out.println("ALno");
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=re.ZbDeskAllno(zbde);
		System.out.println("allno:"+list);
		JSON json=toJson.toJson("deskallno", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void Zbdishallno(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=re.ZbDishAllno(zbde);
		System.out.println("alldishno:"+list);
		JSON json=toJson.toJson("dishallno", list);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
