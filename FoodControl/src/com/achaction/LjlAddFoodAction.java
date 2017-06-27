package com.achaction;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.entity.LjlAddFood;
import com.entity.LjlAddOrder;
import com.entity.SxmTable;
import com.entity.TztDishOrder;
import com.insertemploydao.LjlDish;
import com.insertemploydao.LjlKind;
import com.insertemploydao.LjlOrders;
import com.insertemploydao.SxmTableSql;
import com.insertemploydao.TztDishOrderImp;
import com.utils.toJson;





public class LjlAddFoodAction {
	private LjlAddFood addfood;
	private LjlAddOrder addorder;
	private String desknub;
	private SxmTable st;
	private String ddname;
	private String kindname;
	public String getDdname() {
		return ddname;
	}
	public void setDdname(String ddname) {
		this.ddname = ddname;
	}
	public SxmTable getSt() {
		return st;
	}
	public void setSt(SxmTable st) {
		this.st = st;
	}
	LjlOrders orders=new LjlOrders();
	LjlDish dish=new LjlDish();
	TztDishOrderImp DishOrderImp=new TztDishOrderImp();
	SxmTableSql tableSql=new SxmTableSql();
	LjlKind kind=new LjlKind();
	
	public String getDesknub() {
		return desknub;
	}
	public void setDesknub(String desknub) {
		this.desknub = desknub;
	}
	public LjlAddOrder getAddorder() {
		return addorder;
	}
	public void setAddorder(LjlAddOrder addorder) {
		this.addorder = addorder;
	}
	public LjlAddFood getAddfood() {
		return addfood;
	}
	public void setAddfood(LjlAddFood addfood) {
		this.addfood = addfood;
	}
	/**
	 * 
	 */
	public void kindfood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=kind.sel(null);
		toJson.toJson("kind", list);
		try {
			response.getWriter().println(toJson.toJson("kind", list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void newlfood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=dish.sel();
		toJson.toJson("newlfood", list);

		try {
			response.getWriter().println(toJson.toJson("newlfood", list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void kindnewfood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		List list=dish.sel(kindname);
		toJson.toJson("newlfood", list);
		try {
			response.getWriter().println(toJson.toJson("newlfood", list));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public String getKindname() {
		return kindname;
	}
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	/**
	 * 
	 * 方法功能说明：  下单功能
	 * 创建：2017-6-21 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：  addorder 订单实体类     
	 * @return void     
	 * @throws
	 */
	public void addOrder(){
		int dishStatus=12;
		int flag=-1;
		int addDish=0;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		String orderup=(String) session.getAttribute("orderStatus");
		if (orderup!="1") {
			String[] foodnames=session.getValueNames();
			String tablename=(String) session.getAttribute("dname");
			List listtable=tableSql.idTablename(tablename);
			List listtId=(List) listtable.get(0);
			int tableid=(Integer) listtId.get(0);
			addorder.setDeskid(tableid);//设置桌子id
			int rsid=orders.rsadd(addorder);//添加订单并获得id
			session.setAttribute("orderid", Integer.toString(rsid));
			System.out.println("id："+session.getAttribute("orderid"));
			for (int i = 0; i < foodnames.length; i++) {
				if (foodnames[i]!="dname"&&foodnames[i]!="orderStatus"&&foodnames[i]!="orderid") {
					List list=dish.seldishName(foodnames[i]);
					session.getAttribute(foodnames[i]);
					LjlAddFood addf= (LjlAddFood)session.getAttribute(foodnames[i]);
					int dishnum=addf.getNumber();
					int number=addf.getNumber();//每个菜的数量
					List listdish=(List) list.get(0);
					int dishid=(Integer) listdish.get(0);
					TztDishOrder dishorder=new TztDishOrder(rsid,dishid,dishStatus,tableid,number,addDish);
					for (int j = 0; j < number; j++) {
						DishOrderImp.add(dishorder);
					}
					flag=1;
				}
			}
		}else{
			flag=2;
		}
		session.setAttribute("orderStatus", "1");
		//HttpServletResponse response=ServletActionContext.getResponse();
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addOrderfood(){
		int dishStatus=12;
		int flag=-1;
		int addDish=1;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		String orderup=(String) session.getAttribute("orderStatus");
		System.out.println("orderup:"+orderup);
		if (orderup=="1") {
			System.out.println("jin");
			String[] foodnames=session.getValueNames();
			String tablename=(String) session.getAttribute("dname");
			System.out.println("tablename"+tablename);
			List listtable=tableSql.idTablename(tablename);
			List listtId=(List) listtable.get(0);
			int tableid=(Integer) listtId.get(0);
			System.out.println("tableid"+tableid);
			System.out.println("session:"+session.getAttribute("orderid"));
			String rsid1= (String) session.getAttribute("orderid");
			int rsid=Integer.parseInt(rsid1);
			List orderlists=orders.idselOrder(rsid);
			List orderlist=(List) orderlists.get(0);
			int ordersnum=(Integer)orderlist.get(3);
			int ordersprice=(Integer)orderlist.get(2);
			int foodnum=0;//新增菜品的数量
			int price=0;//新增菜品总价格
			System.out.println("ordersnum"+ordersnum);
			System.out.println("ordersprice"+ordersprice);
			for (int i = 0; i < foodnames.length; i++) {
				if (foodnames[i]!="dname"&&foodnames[i]!="orderStatus"&&foodnames[i]!="orderid") {
					List list=dish.seldishName(foodnames[i]);
					session.getAttribute(foodnames[i]);
					LjlAddFood addf= (LjlAddFood)session.getAttribute(foodnames[i]);
					System.out.println("foodname"+addf.getFoodname());
					int number=addf.getNumber();//每个菜的数量
					int foodprice=addf.getPrice();
					foodnum=foodnum+number;
					price=price+foodprice;
					List listdish=(List) list.get(0);
					int dishid=(Integer) listdish.get(0);
					TztDishOrder dishorder=new TztDishOrder(rsid,dishid,dishStatus,tableid,number,addDish);
					for (int j = 0; j < number; j++) {
						DishOrderImp.add(dishorder);
					}
					flag=0;
				}
			}
			if (flag==0) {
				int ordernum=foodnum+ordersnum;
				int orderprice=price+ordersprice;
				LjlAddOrder orderfoodadd=new LjlAddOrder();
				orderfoodadd.setOrdersId(rsid);
				orderfoodadd.setFoodNum(ordernum);
				orderfoodadd.setOrderPrice(orderprice);
				System.out.println("ddd"+orderfoodadd.getOrdersId()+","+orderfoodadd.getFoodNum()+","+orderfoodadd.getOrderPrice());
				flag=orders.upOrdersPN(orderfoodadd);
			}
			
		}else{
			flag=2;
		}
		try {
			System.out.println("er"+flag);
			response.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ordertotal(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		String rsid1= (String) session.getAttribute("orderid");
		int rsid=Integer.parseInt(rsid1);
		List orderlists=orders.idselOrder(rsid);
		JSON json=toJson.toJson("total", orderlists);
		try {
			response.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * 方法功能说明：  跳转new点菜页面输出菜品
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public String newFood(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String dname=request.getParameter("selectvalue");
		tableSql.uptabstate(dname);//根据桌子name改变桌子状态
		if (dname!=null) {
			session.setAttribute("dname", dname);
		}
		return "newFood";	
	}
	/**
	 * 
	 * 方法功能说明：  添加菜品到购物车
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：     addfood菜品实体类  
	 * @return void     
	 * @throws
	 */
	public void addFood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		LjlAddFood addf= (LjlAddFood)session.getAttribute(addfood.getFoodname());
		if (session.getAttribute(addfood.getFoodname())!=null) {
			int foodnum=addf.getNumber();
			addfood.setNumber(addfood.getNumber()+foodnum);
			int foodprice=addf.getPrice();
			addfood.setPrice(addfood.getPrice()+foodprice);	
		}
		System.out.println(addfood.getFoodname()+","+addfood.getNumber()+","+addfood.getUprice()+","+addfood.getPrice());
		session.setAttribute(addfood.getFoodname(), addfood);
		try {
			
			response.getWriter().print("1");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void selOrder(){
		System.out.println("sel");
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=ServletActionContext.getRequest().getSession();
		String orderid=(String) session.getAttribute("orderid");
		if (orderid!=null) {
			int ordersid=Integer.parseInt(orderid);
			List list=orders.orderDish(ordersid);
			JSON json=toJson.toJson("orderfood", list);
			try {
				response.getWriter().print(json);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	/**
	 * 
	 * 方法功能说明：  计算购物车内菜品总数和总价
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void OrderTotal(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String[] sname=session.getValueNames();
		int price=0;
		int num=0;
		for (int i = 0; i <sname.length; i++) {
			if(sname[i]!="dname"&&sname[i]!="orderStatus"&&sname[i]!="orderid"){
				LjlAddFood addf= (LjlAddFood)session.getAttribute(sname[i]);
				price=addf.getPrice()+price;
				num=addf.getNumber()+num;
			}	
		}
		Map map=new HashMap();
		map.put("price", price);
		map.put("num",num);
		JSONObject json=new JSONObject();
		json.putAll(map);
		try {
			response.getWriter().print(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * 
	 * 方法功能说明：  清除购物车所有菜品
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void clearfood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=ServletActionContext.getRequest().getSession();
		String[] removename=session.getValueNames();
		for (int i = 0; i < removename.length; i++) {
			if (removename[i]!="dname"&&removename[i]!="orderStatus"&&removename[i]!="orderid") {
				session.removeAttribute(removename[i]);
			}
			
		}
		try {
			response.getWriter().print("d");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 方法功能说明：删除单个菜品  
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void delfood(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute(addfood.getFoodname());
	}

	/**
	 * 
	 * 方法功能说明：  打印菜品到我的菜单
	 * 创建：2017-6-20 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void lookFood(){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=ServletActionContext.getRequest().getSession();
		String[] sname=session.getValueNames();
		int price=0;
		JSONObject json=new JSONObject();
		for (int i = 0; i <sname.length; i++) {
			if(sname[i]!="dname"&&sname[i]!="orderStatus"&&sname[i]!="orderid"){
				LjlAddFood addf= (LjlAddFood)session.getAttribute(sname[i]);
				int number=addf.getNumber();
				if (number!=0) {
					Map map=new HashMap();
					map.put("ad"+i,addf);
					json.accumulateAll(map);
				}
				price=addf.getPrice()+price;	
			}
		}
		try {
			response.getWriter().print(json.toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String backhome(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.invalidate();
		return "backhome";
	}
	
	/**
	 * 
	 * 方法功能说明：  查询当天订单
	 * 创建：2017-6-21 by sxm  
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void searchOrder(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");//设置日期格式
		String time=df.format(new Date());
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String time1=df1.format(new Date());
		List list=orders.selOrder(time,time1);
		JSON json=toJson.toJson("val", list);
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 方法功能说明：  桌子详情
	 * 创建：2017-6-21 by sxm  
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void orderDish(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
		String ddname=(String) request.getAttribute("ddname");
		String ddna=(String) request.getAttribute("ord");
		LjlDish dish=new LjlDish();
		List listdish=dish.sel();	
		request.getSession().setAttribute("dish",listdish );
		String retime=null;
		List list=orders.orderDish(addorder.getOrdersId());
		
		JSON json=toJson.toJson("val", list);
			List li=(List) list.get(0);			
			try {
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String time=df.format(new Date()); 
				String time1=df.format(li.get(2));
				Date d1 = df.parse(time);
				Date d2 = df.parse(time1); 
			    long diff = d1.getTime() - d2.getTime();//这样得到的差值是微秒级别  
			    long days = diff / (1000 * 60 * 60 * 24);  
			   	long hours = (diff-days*(1000 * 60 * 60 * 24))/(1000* 60 * 60);  
			    long minutes = (diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60))/(1000* 60);
			    long ss=(diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*(1000* 60))/(1000);
			   retime=hours+":"+minutes+":"+ss;  	
			   request.getSession().setAttribute("retime", retime);	
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		try {
			hsr.getWriter().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void updateOrder(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		int ud=orders.updesk(st);
		int od=orders.upOrders(addorder);
		int flag=-1;
		if(od!=-1&&ud!=-1){
			flag=1;
		}
		try {
			response.getWriter().println(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 清理桌子
	 */
	public void clearDesk(){
		System.out.println("cler");
		HttpServletResponse response=ServletActionContext.getResponse();
		int cd=orders.clearDesk(st);
		System.out.println("cd"+cd);
		try {
			response.getWriter().println("dd");
			System.out.println("dddd");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 催菜
	 */
	public void anxious(){
		HttpServletResponse response=ServletActionContext.getResponse();
		List list=orders.anxiousOrder(addorder);
		try {
			response.getWriter().println(list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
