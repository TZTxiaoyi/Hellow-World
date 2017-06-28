package com.achaction;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Flags.Flag;
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
	/**
	 * addfood 菜品实体类 名字 价格 id
	 * addorder 订单实体类 id 总计 菜品数量 状态 下单时间 使用桌台
	 * st 桌台信息 id 名字 状态
	 * ddname 当前选用桌台名字；
	 * kindname 分类名字
	 * 
	 */
	private LjlAddFood addfood;
	private LjlAddOrder addorder;
	private SxmTable st;
	private String foodtime;
	private int foodprice;
	public int getFoodprice() {
		return foodprice;
	}
	public void setFoodprice(int foodprice) {
		this.foodprice = foodprice;
	}
	public String getFoodtime() {
		return foodtime;
	}
	public void setFoodtime(String foodtime) {
		this.foodtime = foodtime;
	}
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
	public String getKindname() {
		return kindname;
	}
	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
	/**
	 * 查询所有菜品分类输出到new
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
	/**
	 * 查询所有菜品输出到new
	 */
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
	/**
	 * 根据菜品类别查询菜品输出到new分类里
	 */
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
	
	/**
	 * 
	 * 方法功能说明：  下单功能
	 * 创建：2017-6-21 by li   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：  addorder 订单实体类     rsid 添加订单并获得id ,number 每个菜的数量,dishorder 菜品和订单关系表实体，flag 状态标记-1未成功1成功2不能下单
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
	/**
	 * 下单后再添加菜品
	 * 先判断是否下过订单返回状态，根据订单id,菜品id，添加菜品和订单关系表内数据
	 */
	public void addOrderfood(){
		int dishStatus=12;
		int flag=-1;
		int addDish=1;
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse response=ServletActionContext.getResponse();
		HttpSession session=request.getSession();
		String orderup=(String) session.getAttribute("orderStatus");
		if (orderup=="1") {
			System.out.println("jin");
			String[] foodnames=session.getValueNames();
			String tablename=(String) session.getAttribute("dname");
			List listtable=tableSql.idTablename(tablename);
			List listtId=(List) listtable.get(0);
			int tableid=(Integer) listtId.get(0);
			String rsid1= (String) session.getAttribute("orderid");
			int rsid=Integer.parseInt(rsid1);
			List orderlists=orders.idselOrder(rsid);
			List orderlist=(List) orderlists.get(0);
			int ordersnum=(Integer)orderlist.get(3);
			int ordersprice=(Integer)orderlist.get(2);
			int foodnum=0;//新增菜品的数量
			int price=0;//新增菜品总价格
			for (int i = 0; i < foodnames.length; i++) {
				if (foodnames[i]!="dname"&&foodnames[i]!="orderStatus"&&foodnames[i]!="orderid") {
					List list=dish.seldishName(foodnames[i]);
					session.getAttribute(foodnames[i]);
					LjlAddFood addf= (LjlAddFood)session.getAttribute(foodnames[i]);
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
	/**
	 * 获得订单的总价格
	 * 根据订单id获得订单信息
	 */
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
		session.setAttribute(addfood.getFoodname(), addfood);
		try {
			
			response.getWriter().print("1");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 获得订单详细信息菜品数量价格
	 * 输出到new我的订单模态框
	 * 
	 */
	public void selOrder(){
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
			hsr.getWriter().print(json);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void ordertime(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpServletResponse hsr=ServletActionContext.getResponse();
		hsr.setContentType("text/html;charset=UTF-8");
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
		    long minu=(diff-days*(1000 * 60 * 60 * 24)-hours*(1000* 60 * 60)-minutes*((1000* 60)))/(1000);
		    
		   retime=hours+":"+minutes+":"+minu;  	
		   
		   try {
			hsr.getWriter().println(retime);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	/**
	 * 结账
	 */
	public void updateOrder(){
		
		HttpServletResponse response=ServletActionContext.getResponse();
		int flag =-1;
		int od=orders.upOrders(addorder);
		System.out.println("od:"+od);
		if(od>0){
			int ud=orders.updesk(st);
			if(ud>0){
				flag=1;	
			}
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
		HttpServletResponse response=ServletActionContext.getResponse();	
		int cd=orders.clearDesk(st);
		try {
			response.getWriter().println(cd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * service.jsp里的清除脏台按钮
	 */
	public void clearAllDesk(){
		HttpServletResponse response=ServletActionContext.getResponse();
		int acd=orders.clearAllDesk();
		try {
			response.getWriter().println(acd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 整单取消；
	 */
	public void alldelect(){
		HttpServletResponse response=ServletActionContext.getResponse();
		List list=orders.vagestate(addorder.getOrdersId());
		int flag=-1;
		if(list.size()==0){
			int delOrd=orders.allDelect(addorder);
			int cd=orders.alterDeskstate(st);
			int delst=orders.alldel(addorder);
			if(delOrd!=-1&&cd!=-1&&delst!=-1){
				flag=1;	
			}
		}
		try {
			response.getWriter().print(flag);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 单个菜品取消
	 */
	public void onedelect(){
		HttpServletResponse response=ServletActionContext.getResponse();
		//根据菜品明字获取菜品id
		System.out.println(addorder.getOrdersId()+","+addfood.getFoodname()+","+foodtime+","+foodprice);
		int orderid=addorder.getOrdersId();
		List list=dish.seldish(addfood);
		List li=(List) list.get(0);
		System.out.println(li);
		int dishid=(Integer) li.get(0);//菜品id
		//int uprice=(Integer) li.get(2);//菜品单价
		List listOD=orders.idselOrder(addorder.getOrdersId());
		List ODlist=(List) listOD.get(0);
		int ODprice=(Integer) ODlist.get(2);//订单价格
		//System.out.println("dishid:"+dishid+","+"uprice:"+uprice+","+"ODprice:"+ODprice);
		int flag=orders.uporderdish(foodtime,dishid);
		System.out.println(flag);//更新了几条菜品状态
		int price=ODprice-foodprice;
		System.out.println("foodp:"+price);
		System.out.println("orderid"+orderid);
		orders.upOP(price, orderid);
	}
	/**
	 * 催菜
	 */
	public void anxious(){
		System.out.println("----");
		HttpServletResponse response=ServletActionContext.getResponse();
		List list=orders.anxiousOrder(addorder);
		List li=(List) list.get(0);
		int pri=(Integer) li.get(0);
		int anx=pri+1;
		int orderspro=orders.proty(anx, addorder);
		System.out.println("aaa"+orderspro);
		try {
			response.getWriter().println(orderspro);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
