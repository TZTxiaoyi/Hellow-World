
/**     
 * @文件名称: TztDishImp.java  
 * @类路径: com.insertemploydao  
 * @描述: TODO  
 * @作者：TZT  
 * @时间：2017-6-20 下午3:03:18  
 * @版本：V1.0     
 */  
package com.insertemploydao;

import java.util.List;

import com.daointerface.DaoInterface;
import com.entity.TztDish;
import com.utils.DaoFactory;

/**  
 * @类功能说明：  菜品的增删改查的接口实现类
 * @类修改者：  
 * @修改日期：  
 * @修改说明：   
 * @作者：TZT
 * @创建时间：2017-6-20 下午3:03:18  
 * @版本：V1.0  
 */
public class TztDishImp implements DaoInterface {

	/* (non-Javadoc)
	 * @see com.daointerface.DaoInterface#add(java.lang.Object)
	 */
	public int add(Object obj) {
		TztDish dish = (TztDish) obj;
		String sql=" insert into dish values(?,?,?,?,?,?,?)";
		Object[] objects = new Object[]{dish.getDishName(),dish.getPrice(),
				dish.getKindId(),dish.getMakeTime(),dish.getPriority(),dish.getPicture(),dish.getMaxCopise()};

		return DaoFactory.Updata(sql, objects);
	}

	/* (non-Javadoc)
	 * @see com.daointerface.DaoInterface#del(java.lang.Object)
	 */
	public int del(Object obj) {
		TztDish dish = (TztDish) obj;
		String sql ="updata dish set dishStatus=20 from dish where dishId=?";
		Object[] objects = new Object[]{dish.getDishId()};
		return DaoFactory.Updata(sql, objects);
	}

	/* (non-Javadoc)
	 * @see com.daointerface.DaoInterface#sel(java.lang.Object)
	 */
	public List sel(Object obj) {
		TztDish dish = (TztDish) obj;
		String sql ="select * from dish where dishId= "+dish.getDishId()+"" ;
		return DaoFactory.Query(sql);
	}

	/* (non-Javadoc)
	 * @see com.daointerface.DaoInterface#update(java.lang.Object)
	 */
	public int update(Object obj) {
		TztDish dish = (TztDish) obj;
		String sql =" update dish set dishName=? ,price =? ,kindId=? ,makeTime=?,priority=?,picture=?,maxCopies= ? where dishId=?  ";
		Object[] object =new Object[]{dish.getDishName(),dish.getPrice(),dish.getKindId(),dish.getMakeTime(),dish.getPriority(),dish.getPicture(),dish.getMaxCopise(),dish.getDishId()};		
		return DaoFactory.Updata(sql, object);
	}



	
}

