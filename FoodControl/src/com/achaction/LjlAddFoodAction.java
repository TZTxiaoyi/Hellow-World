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
	 * addfood ��Ʒʵ���� ���� �۸� id
	 * addorder ����ʵ���� id �ܼ� ��Ʒ���� ״̬ �µ�ʱ�� ʹ����̨
	 * st ��̨��Ϣ id ���� ״̬
	 * ddname ��ǰѡ����̨���֣�
	 * kindname ��������
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
	 * ��ѯ���в�Ʒ���������new
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
	 * ��ѯ���в�Ʒ�����new
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
	 * ���ݲ�Ʒ����ѯ��Ʒ�����new������
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
	 * ��������˵����  �µ�����
	 * ������2017-6-21 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������  addorder ����ʵ����     rsid ��Ӷ��������id ,number ÿ���˵�����,dishorder ��Ʒ�Ͷ�����ϵ��ʵ�壬flag ״̬���-1δ�ɹ�1�ɹ�2�����µ�
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
			addorder.setDeskid(tableid);//��������id
			int rsid=orders.rsadd(addorder);//��Ӷ��������id
			session.setAttribute("orderid", Integer.toString(rsid));
			System.out.println("id��"+session.getAttribute("orderid"));
			for (int i = 0; i < foodnames.length; i++) {
				if (foodnames[i]!="dname"&&foodnames[i]!="orderStatus"&&foodnames[i]!="orderid") {
					List list=dish.seldishName(foodnames[i]);
					session.getAttribute(foodnames[i]);
					LjlAddFood addf= (LjlAddFood)session.getAttribute(foodnames[i]);
					int dishnum=addf.getNumber();
					int number=addf.getNumber();//ÿ���˵�����
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
	 * �µ�������Ӳ�Ʒ
	 * ���ж��Ƿ��¹���������״̬�����ݶ���id,��Ʒid����Ӳ�Ʒ�Ͷ�����ϵ��������
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
			int foodnum=0;//������Ʒ������
			int price=0;//������Ʒ�ܼ۸�
			for (int i = 0; i < foodnames.length; i++) {
				if (foodnames[i]!="dname"&&foodnames[i]!="orderStatus"&&foodnames[i]!="orderid") {
					List list=dish.seldishName(foodnames[i]);
					session.getAttribute(foodnames[i]);
					LjlAddFood addf= (LjlAddFood)session.getAttribute(foodnames[i]);
					int number=addf.getNumber();//ÿ���˵�����
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
	 * ��ö������ܼ۸�
	 * ���ݶ���id��ö�����Ϣ
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
	 * ��������˵����  ��תnew���ҳ�������Ʒ
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������ @return      
	 * @return String     
	 * @throws
	 */
	public String newFood(){
		HttpServletRequest request=ServletActionContext.getRequest();
		HttpSession session=request.getSession();
		String dname=request.getParameter("selectvalue");
		tableSql.uptabstate(dname);//��������name�ı�����״̬
		if (dname!=null) {
			session.setAttribute("dname", dname);
		}
		return "newFood";	
	}
	/**
	 * 
	 * ��������˵����  ��Ӳ�Ʒ�����ﳵ
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������     addfood��Ʒʵ����  
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
	 * ��ö�����ϸ��Ϣ��Ʒ�����۸�
	 * �����new�ҵĶ���ģ̬��
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
	 * ��������˵����  ���㹺�ﳵ�ڲ�Ʒ�������ܼ�
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
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
	 * ��������˵����  ������ﳵ���в�Ʒ
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
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
	 * ��������˵����ɾ��������Ʒ  
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void delfood(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.removeAttribute(addfood.getFoodname());
	}

	/**
	 * 
	 * ��������˵����  ��ӡ��Ʒ���ҵĲ˵�
	 * ������2017-6-20 by li   
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
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
	 * ��������˵����  ��ѯ���충��
	 * ������2017-6-21 by sxm  
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
	 * @return void     
	 * @throws
	 */
	public void searchOrder(){
		HttpServletResponse hsr=ServletActionContext.getResponse();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd 00:00:00");//�������ڸ�ʽ
		String time=df.format(new Date());
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
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
	 * ��������˵����  ��������
	 * ������2017-6-21 by sxm  
	 * �޸ģ����� by �޸���  
	 * �޸����ݣ�  
	 * @������       
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
		    long diff = d1.getTime() - d2.getTime();//�����õ��Ĳ�ֵ��΢�뼶��  
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
	 * ����
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
	 * ��������
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
	 * service.jsp��������̨��ť
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
	 * ����ȡ����
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
	 * ������Ʒȡ��
	 */
	public void onedelect(){
		HttpServletResponse response=ServletActionContext.getResponse();
		//���ݲ�Ʒ���ֻ�ȡ��Ʒid
		System.out.println(addorder.getOrdersId()+","+addfood.getFoodname()+","+foodtime+","+foodprice);
		int orderid=addorder.getOrdersId();
		List list=dish.seldish(addfood);
		List li=(List) list.get(0);
		System.out.println(li);
		int dishid=(Integer) li.get(0);//��Ʒid
		//int uprice=(Integer) li.get(2);//��Ʒ����
		List listOD=orders.idselOrder(addorder.getOrdersId());
		List ODlist=(List) listOD.get(0);
		int ODprice=(Integer) ODlist.get(2);//�����۸�
		//System.out.println("dishid:"+dishid+","+"uprice:"+uprice+","+"ODprice:"+ODprice);
		int flag=orders.uporderdish(foodtime,dishid);
		System.out.println(flag);//�����˼�����Ʒ״̬
		int price=ODprice-foodprice;
		System.out.println("foodp:"+price);
		System.out.println("orderid"+orderid);
		orders.upOP(price, orderid);
	}
	/**
	 * �߲�
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
