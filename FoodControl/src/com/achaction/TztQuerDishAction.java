package com.achaction;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.entity.TztDish;
import com.entity.TztDishOrder;
import com.insertemploydao.TztDishImp;
import com.insertemploydao.TztDishOrderImp;
import com.jspsmart.upload.Request;
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
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
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
		TztDishOrderImp dao =new TztDishOrderImp();
		List result = dao.queryMade();
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
		TztDishOrderImp  dao =new TztDishOrderImp();
		List result = dao.queryMading();
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
		TztDishImp dao=new TztDishImp();
		TztDish dish = new TztDish();
		dish.setDishId(dishId);
		List madedish =dao.sel(dish);
		TztDishImp dishImp = new TztDishImp();
		dishImp.changeDish(13,(List)madedish.get(0),12);
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
		TztDishImp dao=new TztDishImp();
		TztDish dish = new TztDish();
		dish.setDishId(dishId);
		List madedish =dao.sel(dish);
		TztDishImp dishImp = new TztDishImp();
		dishImp.changeDish(14,(List)madedish.get(0),13);
		System.out.println("change");
		try {
			rep.getWriter().print("sucess");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
