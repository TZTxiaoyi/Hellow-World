package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.daointerface.TztSort;
import com.entity.TztDish;
import com.insertemploydao.TztDishImp;
import com.insertemploydao.TztDishOrderImp;
import com.logic.TztDefaultSortImp;
import com.logic.TztTimeSortImp;
import com.entity.TztDishOrder;
import com.utils.toJson;



/**
 * 
 * @类功能说明：  
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-16 上午12:00:46  
 * @版本：V1.0
 */
public class TztQuerDishAction {
	int dishId;
	int method;
	private TztSort sort;
	public TztSort getSort() {
		return sort;
	}
	public void setSort(TztSort sort) {
		this.sort = sort;
	}
	public int getMethod() {
		return method;
	}
	public void setMethod(int method) {
		this.method = method;
	}
	public int getDishId() {
		return dishId;
	}	
	
	/**
	 * 
	 * 方法功能说明： 不同的按钮更换不同的接口 
	 * 创建：2017-6-22 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @param method      
	 * @return void     
	 * @throws
	 */
	public void createImp(int method){
			if(method==1){
				 TztSort sort = new TztTimeSortImp();
				 setSort(sort);
			}else {
				TztSort sort = new TztDefaultSortImp();
				setSort(sort);
			}
		} 
		
	
	/**
	 * 
	 * 方法功能说明：  查询需要制作的菜
	 * 创建：2017-6-16 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数： @return      
	 * @return String     
	 * @throws
	 */
	public void queryMade() {
		HttpServletResponse rep= ServletActionContext.getResponse();
		rep.setContentType("text/html;charset=utf-8");
		createImp(method);
		List result= sort.queryMade();
		try {
			rep.getWriter().print(toJson.toJson("tztjs", result).toString());
		} catch (IOException e) {
			e.printStackTrace();
			e.getMessage();
		}
		
		
	}
	/**
	 * 
	 * 方法功能说明：  查询正在制作的菜
	 * 创建：2017-6-17 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void queryMading() {
		HttpServletResponse rep =ServletActionContext.getResponse();
		rep.setContentType("html/text;charset =utf-8");
		createImp(method);
		List result= sort.queryMading();
		try {
			rep.getWriter().print(toJson.toJson("tztjs", result).toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
		}
	}
	/**
	 * 
	 * 方法功能说明：  点击制作按钮修改菜的状态为制作中
	 * 创建：2017-6-21 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void make(){
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setContentType("html/text;charset=utf-8");
		createImp(method);
		sort.made(dishId);
		try {
			rep.getWriter().print("sucess");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 方法功能说明：点击制作完成按钮修改菜品状态为制作完成  
	 * 创建：2017-6-21 by TZT   
	 * 修改：日期 by 修改者  
	 * 修改内容：  
	 * @参数：       
	 * @return void     
	 * @throws
	 */
	public void makding(){
		HttpServletResponse rep = ServletActionContext.getResponse();
		rep.setContentType("html/text;charset=utf-8");
		createImp(method);
		List result =sort.mading(dishId);
		System.out.println(result+"madeing++++++++++++==");
		try {
			System.out.println("ffff"+toJson.toJson("js", result).toString());
			rep.getWriter().print(toJson.toJson("js", result).toString());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
