package com.entity;
/**
 * 
 * @�๦��˵����  ���ȶ���ʵ����
 * @���޸��ߣ�  
 * @�޸����ڣ�  
 * @�޸�˵����   
 * @���ߣ�TZT
 * @����ʱ�䣺2017-6-15 ����10:15:55  
 * @�汾��V1.0
 */
public class TztDishOrder {
	int OrderId;
	int dishId;
	int dishStatus;
	int id;
	int deskId;
	int dishNnum;
	public int getDishNnum() {
		return dishNnum;
	}
	public void setDishNnum(int dishNnum) {
		this.dishNnum = dishNnum;
	}
	public TztDishOrder(int rsid, int dishid2, int dishStatus2, int deskid2) {
		// TODO Auto-generated constructor stub
		this.OrderId= rsid;
		this.dishId=dishid2;
		this.dishStatus=dishStatus2;
		this.deskId=deskid2;
	}
	public TztDishOrder() {
		// TODO Auto-generated constructor stub
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getDishId() {
		return dishId;
	}
	public void setDishId(int dishId) {
		this.dishId = dishId;
	}
	public int getDishStatus() {
		return dishStatus;
	}
	public void setDishStatus(int dishStatus) {
		this.dishStatus = dishStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDeskId() {
		return deskId;
	}
	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}
	
	
}
