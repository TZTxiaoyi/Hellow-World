package com.entity;

import java.sql.Date;

public class GJYFoodCategory {
	
	 private String dishName;//菜品名
	 private int price;//价格
	 private int kindId;//菜品类别编号
	 private int makeTime ;//制作时间
	 private int priority ;//优先级
	 private String pictureName;//照片名
	 private int maxCopies;//最大并菜数
	 private int dishState;//菜品状态
	
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
	public String getPictureName() {
		return pictureName;
	}
	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}
	public int getMaxCopies() {
		return maxCopies;
	}
	public void setMaxCopies(int maxCopies) {
		this.maxCopies = maxCopies;
	}
	public int getDishState() {
		return dishState;
	}
	public void setDishState(int dishState) {
		this.dishState = dishState;
	}
	 
	 
	
	 
	 
	 
}
