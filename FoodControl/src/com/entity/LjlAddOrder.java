package com.entity;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LjlAddOrder {
	private int orderStatus;
	private int orderPrice;
	private int foodNum;
	private int cost;
	private String ordersTime;
	private String deskname;
	private int deskid;
	public int getDeskid() {
		
		return deskid;
	}
	public String getDeskname() {
		return deskname;
	}
	public void setDeskname(String deskname) {
		this.deskname = deskname;
	}
	public void setDeskid(int deskid) {
		this.deskid = deskid;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(int foodNum) {
		this.foodNum = foodNum;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getOrdersTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}
	public void setOrdersTime(String ordersTime) {
		
		this.ordersTime = ordersTime;
	}
	
}
