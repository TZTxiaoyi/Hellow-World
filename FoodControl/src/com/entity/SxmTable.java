package com.entity;
/**
 * ����ʵ����
 * @author Administrator
 *��λ����	personNum
 *������		deskName	
 *��λ״̬	deskState(0:���ã�1��ռ�ã�2����̨)
 */
public class SxmTable {
	int deskId;
	int personNum;
	String deskName;
	int deskState;
	int deskdelState;
	public int getDeskdelState() {
		deskdelState=19;
		return deskdelState;
	}
	public void setDeskdelState(int deskdelState) {
		this.deskdelState = deskdelState;
	}
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
		deskState=6;
		return deskState;
	}
	public void setDeskState(int deskState) {
		this.deskState = deskState;
	}
	
}
