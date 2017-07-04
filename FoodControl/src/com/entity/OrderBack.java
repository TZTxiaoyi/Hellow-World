package com.entity;

public class OrderBack {
	public int chargebackId;
	public int ordersId;
	public String reason;
	public String dishName;
	public int getChargebackId() {
		return chargebackId;
	}
	public void setChargebackId(int chargebackId) {
		this.chargebackId = chargebackId;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public String getReason() {
		reason="";
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getDishName() {
		return dishName;
	}
	public void setDishName(String dishName) {
		this.dishName = dishName;
	}
}
