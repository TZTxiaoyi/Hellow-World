package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.ZbCustomerInfo;
import com.entity.ZbDetails;
import com.entity.ZbUsagedata;
import com.entity.ZbUserdata;
import com.entity.Zbcus_enter1;
import com.utils.DaoFactory;

public class ZbRegister implements DaoInterface{

	/**
	 * zhuce
	 */
	public int add(Object user) {
		ZbUserdata userdata=(ZbUserdata)user;
		// TODO Auto-generated method stub
		String sql="insert customerEnter values (?,?,?)";
		Object[] params=new Object[]{userdata.getAccount(),userdata.getPwd(),19};
		int flag=DaoFactory.Updata(sql, params);
		return flag;
	}
	
	public int addnom(Object adnm){
		System.out.println("++++++++++++++++++++++");
		Zbcus_enter1 zb = (Zbcus_enter1) adnm;
		String sql = "insert cus_enter1 values ('"+zb.getName()+"','"+zb.getSex()+"','"+zb.getPhone1()+"','"+zb.getAdress()+"','"+zb.getAge()+"')";
		//Object[] params = new Object[]{zb.getName(),zb.getSex(),zb.getPhone1(),zb.getAdress(),zb.getAge()};
		int flag = DaoFactory.Updata(sql, null);
		return flag;
	}
	/**
	 * 
	 * 方法功能说明：  增加顾客信息sql
	 * 创建：2017-6-24 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param zbcin
	 * @参数： @return      
	 * @return int     
	 * @throws
	 */
	//------------------------------------------------------------------------
	public int addinfo(Object zbcin){
		ZbCustomerInfo zbcinfo =(ZbCustomerInfo) zbcin;
		String sql = "insert customerInfo values(?,?,?,?)";
		
		return 0;
		}
	public List queryinfo(){
		String sql = "select c1.Name,c1.sex,c1.phone,c1.adress,c1.age from customerInfo c1,customerEnter c2 where c1.enterId = c2.enterId";
		List list = DaoFactory.Query(sql);
		return list;
	}
	/**
	 * 
	 * 方法功能说明：  		后台顾客快速查找
	 * 创建：2017-6-24 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param ser
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List selcustomer(String ser) {
		String sql = "select * from cus_enter1 where Name like '%"+ser+"%' or sex like '%"+ser+"%' or phone like '%"+ser+"%' or adress like '%"+ser+"%' or age like '%"+ser+"%'";
		List list = DaoFactory.Query(sql);
		return list;
	}
	//-------------------------------------------------------------------
	public int del(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	public int loginsel(Object userdata) {
		
		ZbUsagedata zbsd =(ZbUsagedata) userdata;
		String sql="select * from customerEnter";
		
		// TODO Auto-generated method stub
		List list = DaoFactory.Query(sql);
		int flag = -1;
		for(int i=0; i<list.size();i++){
			
			List a =(List) list.get(i);
			String acc= (String) a.get(1);
			String pwd = (String) a.get(2);
			if(zbsd.getAccount().equals(acc)&& zbsd.getPwd().equals(pwd)){
				flag = 1;		
			}	
		}
		
		return flag;
	}
	

	
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public List sel(Object userdata) {
		ZbUserdata user=(ZbUserdata)userdata;
		String sql="select * from customerEnter where account='"+user.getAccount()+"'";
		// TODO Auto-generated method stub
		
		return DaoFactory.Query(sql);
	}
	/**
	 * 
	 * 方法功能说明：  查询桌子
	 * 创建：2017-6-21 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return List     
	 * @throws
	 */
	public List quertDesk(){
		
		String sql = "select * from desk where deskState='6' and deskdelState='19'";
		List list = DaoFactory.Query(sql);
		
		return list;
	}
	/**
	 * 
	 * 方法功能说明：     		--分页中得到的总条数--cus_enter (视图)
	 * 创建：2017-6-26 by zhubin   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return int     
	 * @throws
	 */
	public int getCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from cus_enter1";
		List list = DaoFactory.Query(sql);
		int total = 0;
		List li = (List) list.get(0);
		total = (Integer) li.get(0);
		return total;
	}
	public List page(int currPage) {
		//System.out.println("currPage:"+currPage);
		String sql="select top ("+5+") * from cus_enter1 where Id not in(select top "+(currPage)*5+" Id from cus_enter1)";
		List list = DaoFactory.Query(sql);
		
		return list;
	}
	//----------------------------------------------------------------------28--------
	public List userInfo(String user){
		String sql="select * from customerEnter ce,customerInfo ci where ce.account='"+user+"' and ce.enterId=ci.enterId";
		return DaoFactory.Query(sql);
	}
	//查询所有菜品
	public List dishnumsql(){
		String sql="select * from dish";
		return DaoFactory.Query(sql);
		
	} 	
	//查询桌子
	public List zbSelectDesk(){
		String sql = "select * from desk";
		List list = DaoFactory.Query(sql);
		return list;
	}
	//查询订单详情
	public List zbordersInfo(int orderid){
		
		String sql = "select * from zb_order where ordersId="+orderid;
		List list =DaoFactory.Query(sql);
		
		return list;
	}
	public List totalcurr(ZbDetails zbde){
		//System.out.println("0099");
		//System.out.println(zbde.getVa()+","+zbde.getVa1()+","+zbde.getVa2());
		String sql="select  count(*) from orders where ordersTime>'"+zbde.getVa1()+
				"' and ordersTime<'"+zbde.getVa2()+"' and deskId="+zbde.getVa();
		return DaoFactory.Query(sql);
	}
	public List ZbOrderss(ZbDetails zbde){
		//System.out.println("curr:"+zbde.getCurr());
		//System.out.println("not:"+zbde.getCurr()*3);
		//System.out.println(zbde.getVa()+","+zbde.getVa1()+","+zbde.getVa2());
		String sql ="select top 5 * from orders where ordersId not in(select top ("+zbde.getCurr()*5+
				") ordersId from orders where ordersTime>'"+zbde.getVa1()+"' and ordersTime<'"+zbde.getVa2()+
				"' and deskId="+zbde.getVa()+") and ordersTime>'"+zbde.getVa1()+"' and ordersTime<'"+zbde.getVa2()+
				"' and deskId="+zbde.getVa();
		List list = DaoFactory.Query(sql);
		return list;
		
	}
	public List ZbDeskStatistics(ZbDetails zbde){
		String sql="select  ordersStatus,COUNT (*),sum(ordersPrice) from orders where ordersTime>'"+zbde.getVa1()+
				"' and ordersTime<'"+zbde.getVa2()+"' and deskId="+zbde.getVa()+
				" and ordersStatus!=15 GROUP BY ordersStatus";
		return DaoFactory.Query(sql);
	}
	public List zbdishtotal(ZbDetails zbde){
		String sql="SELECT MAX(id)  FROM orders_dish od where dishId="+zbde.getVa()+
				" and dishtime>'"+zbde.getVa1()+"' and dishtime<'"+zbde.getVa2()+
				"'  GROUP BY od.dishId,od.ordersId";
		return DaoFactory.Query(sql);
	}
	public List ZbOrdersdish(ZbDetails zbde){
		String sql ="select * from (SELECT MAX(id) numid,COUNT(*) num  FROM orders_dish od where "+
				"dishId="+zbde.getVa()+" and dishtime>'"+zbde.getVa1()+"' and dishtime<'"+zbde.getVa2()+"'  "+
				"GROUP BY od.dishId,od.ordersId  )a  join (select top(5) od.id,od.ordersId,od.dishId,"+
				"od.dishStatus,od.dishtime,od.addDish,d.dishName,d.price,c.id as cid,c.codeName FROM orders_dish od,"+
				"dish d,codetable c where od.id in(SELECT MAX(id) ds FROM orders_dish where dishId="+zbde.getVa()+
				" and dishtime>'"+zbde.getVa1()+"' and dishtime<'"+zbde.getVa2()+"' GROUP BY dishId,ordersId)and "+
				"od.id not in(select top("+zbde.getCurr()*5+") id FROM orders_dish where id in(SELECT MAX(id) ds "+
				"FROM orders_dish where dishId="+zbde.getVa()+" and dishtime>'"+zbde.getVa1()+"' and dishtime<'"+zbde.getVa2()+
				"' GROUP BY dishId,ordersId) order by id desc ) and od.dishId=d.dishId and od.dishStatus=c.id "+
				"order by od.id desc )as b on a.numid=b.id  order by id desc";
		List list = DaoFactory.Query(sql);
		//System.out.println("list:"+list);
		return list;
		
	}
	public List ZbDishStatistics(ZbDetails zbde){
		String sql ="select dishStatus,SUM(price*num) numprice,MAX(price) price,sum(num) num  from "+
				"(select od.id,od.dishStatus,d.price from orders_dish od,dish d where od.dishId=d.dishId)as od "+
				"join (SELECT MAX(id) id,COUNT(*) num  FROM orders_dish od where dishId="+zbde.getVa()+
				" and dishtime>'"+zbde.getVa1()+"' and dishtime<'"+zbde.getVa2()+"'  GROUP BY od.dishId,od.ordersId)as"+
				" b on od.id=b.id group by dishStatus";
		List list=DaoFactory.Query(sql);
		return list;
	}
	public List ZbDeskAllno(ZbDetails zbde){
		//System.out.println("no");
		String sql="select dd.deskId,dd.desknum,dd.op,d.deskName from (select d.deskId, count(o.deskId) "+
				"desknum,SUM(o.ordersPrice) op from desk d left join orders o  on  o.deskId=d.deskId group by d.deskId) "+
				"dd join  desk d on d.deskId=dd.deskId join (select  top(5)  d.deskId from desk d where "+
				"d.deskId not in(select top("+zbde.getCurr()*5+") deskId from desk order by deskId asc)) "+
				"selid on selid.deskId=d.deskId";
		return DaoFactory.Query(sql);
	}
	public List ZbDeskAllnoStatistics(ZbDetails zbde){
		String sql="select dd.deskId,dd.desknum,dd.op,d.deskName from (select d.deskId, count(o.deskId) "+
				"desknum,SUM(o.ordersPrice) op from desk d left join orders o  on  o.deskId=d.deskId group by d.deskId) "+
				"dd join  desk d on d.deskId=dd.deskId join (select  top(5)  d.deskId from desk d where "+
				"d.deskId not in(select top("+zbde.getCurr()*5+") deskId from desk order by deskId asc)) "+
				"selid on selid.deskId=d.deskId";
		return DaoFactory.Query(sql);
		
	}
	public List ZbDeskAll(ZbDetails zbde){
		String sql="select dd.deskId,dd.desknum,dd.op,d.deskName from (select d.deskId, count(o.deskId) "+
				"desknum,SUM(o.ordersPrice) op from desk d left join orders o  on  o.deskId=d.deskId and "+
				"o.ordersTime>'"+zbde.getVa1()+"' and o.ordersTime<'"+zbde.getVa2()+"' group by d.deskId) "+
				"dd join  desk d on d.deskId=dd.deskId join (select  top(5)  d.deskId from desk d where "+
				"d.deskId not in(select top("+zbde.getCurr()*5+") deskId from desk order by deskId asc)) "+
				"selid on selid.deskId=d.deskId";
		return DaoFactory.Query(sql);
	}
	public List ZbDishAll(ZbDetails zbde){
		String sql="select top(5)* from (select z.dishId,z.dishName, sum(z.ss) '数量',MAX(z.pri) '单价',max(ss*pri) '总金额' from("
				+"select c.dishId,c.dishName,count(c.dishId) ss,MAX(c.price) pri,MAX(c.dishState) st from("
				+"select d.dishName,"
				+"d.dishId,d.dishState,od.dishNnum,d.price from dish d left join " 
				+"orders_dish od on d.dishId=od.dishId and od.dishtime<'"+zbde.getVa2()+"' and od.dishtime>'"+zbde.getVa1()+"')"
				+"c where  c.dishState=19 group by c.dishId,c.dishName)"
				+"z where  z.st=19 group by z.dishId,z.dishName)"
				+"f where f.dishId not in (select top ("+zbde.getCurr()*5+")zf.dishId from ("
				+"select z.dishId,z.dishName, sum(z.ss) '数量',MAX(z.pri) '单价',max(ss*pri) '总金额' from("
				+"select c.dishId,c.dishName,count(c.dishId) ss,MAX(c.price) pri,MAX(c.dishState) st from("
				+"select d.dishName,"
				+"d.dishId,d.dishState,od.dishNnum,d.price from "+
				"dish d left join orders_dish od on d.dishId=od.dishId and od.dishtime<'"+zbde.getVa2()+"' and od.dishtime>'"+zbde.getVa1()+"')"
				+"c where  c.dishState=19 group by c.dishId,c.dishName)"
				+"z where  z.st=19 group by z.dishId,z.dishName"
				+")zf)";
		return DaoFactory.Query(sql);
	}
	public List ZbDishAllno(ZbDetails zbde){
		String sql="select top(5)* from (select z.dishId,z.dishName, sum(z.ss) '数量',MAX(z.pri) '单价',max(ss*pri) '总金额' from("
				+"select c.dishId,c.dishName,count(c.dishId) ss,MAX(c.price) pri,MAX(c.dishState) st from("
				+"select d.dishName,"
				+"d.dishId,d.dishState,od.dishNnum,d.price from dish d left join " 
				+"orders_dish od on d.dishId=od.dishId )"
				+"c where  c.dishState=19 group by c.dishId,c.dishName)"
				+"z where  z.st=19 group by z.dishId,z.dishName)"
				+"f where f.dishId not in (select top ("+zbde.getCurr()*5+")zf.dishId from ("
				+"select z.dishId,z.dishName, sum(z.ss) '数量',MAX(z.pri) '单价',max(ss*pri) '总金额' from("
				+"select c.dishId,c.dishName,count(c.dishId) ss,MAX(c.price) pri,MAX(c.dishState) st from("
				+"select d.dishName,"
				+"d.dishId,d.dishState,od.dishNnum,d.price from "+
				"dish d left join orders_dish od on d.dishId=od.dishId )"
				+"c where  c.dishState=19 group by c.dishId,c.dishName)"
				+"z where  z.st=19 group by z.dishId,z.dishName"
				+")zf)";
		return DaoFactory.Query(sql);
		
	}
	public List ZbDeskNum(){
		String sql="select count(deskId) from desk";
		return DaoFactory.Query(sql);
	}
	public List ZbDishNum(){
		String sql="select count(dishId) from dish";
		return DaoFactory.Query(sql);
	}
}
