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
	String OrderId;
	String dishId;
	String dishStatus;
	String id;
	String deskId;
	public String getOrderId() {
		return OrderId;
	}
	public void setOrderId(String orderId) {
		OrderId = orderId;
	}
	public String getDishId() {
		return dishId;
	}
	public void setDishId(String dishId) {
		this.dishId = dishId;
	}
	public String getDishStatus() {
		return dishStatus;
	}
	public void setDishStatus(String dishStatus) {
		this.dishStatus = dishStatus;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeskId() {
		return deskId;
	}
	public void setDeskId(String deskId) {
		this.deskId = deskId;
	}
	
	
}
