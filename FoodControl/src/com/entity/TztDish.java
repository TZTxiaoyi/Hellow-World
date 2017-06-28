
/**     
 * @文件名称: TztDish.java  
 * @类路径: com.entity  
 * @描述: TODO  
 * @作者：TZT  
 * @时间：2017-6-20 下午2:48:37  
 * @版本：V1.0     
 */  
package com.entity;

/**  
 * @类功能说明：  菜品实体类
 * @类修改者：   tzt 
 * @修改日期：  6.12
 * @修改说明：   增加菜品状态（表示删除和可用）
 * @作者：TZT
 * @创建时间：2017-6-20 下午2:48:37  
 * @版本：V1.0  
 */
public class TztDish {
	int dishId;
	String dishName;
	int price;
	int kindId;
	int makeTime;
	int priority;
	String picture;
	int maxCopise;
	String dishStatus;
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getKindId() {
		return kindId;
	}
	public void setKindId(int kindId) {
		this.kindId = kindId;
	}
	public int getMakeTime() {
		return makeTime;
	}
	public void setMakeTime(int makeTime) {
		this.makeTime = makeTime;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getMaxCopise() {
		return maxCopise;
	}
	public void setMaxCopise(int maxCopise) {
		this.maxCopise = maxCopise;
	}
	public String getDishStatus() {
		return dishStatus;
	}
	public void setDishStatus(String dishStatus) {
		this.dishStatus = dishStatus;
	}
	
	
	
}
