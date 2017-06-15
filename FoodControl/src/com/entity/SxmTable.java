package com.entity;
/**
 * 桌子实体类
 * @author Administrator
 *桌位人数	personNum
 *桌名字		deskName	
 *桌位状态	deskState(0:可用，1：占用，2：脏台)
 */
public class SxmTable {
	int deskId;
	int personNum;
	String deskName;
	int deskState;
	public int getDeskId() {
		return deskId;
	}
	public void setDeskId(int deskId) {
		this.deskId = deskId;
	}
	public int getPersonNum() {
		return personNum;
	}
	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}
	public String getDeskName() {
		return deskName;
	}
	public void setDeskName(String deskName) {
		this.deskName = deskName;
	}
	public int getDeskState() {
		return deskState;
	}
	public void setDeskState(int deskState) {
		this.deskState = deskState;
	}
	
}
