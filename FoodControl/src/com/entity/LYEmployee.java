package com.entity;
/**
 * 
 * @author Administrator
 * 功能：员工的实体类
 */
public class LYEmployee {	
	private int emid;
	private String emname;
	private int emsex;
	private int emage;
	private String emphone;			
	private String emadress;
	private String emjointime;
	private int empart;
	private int ementer;
	
	public int getEmenter() {
		return ementer;
	}
	public void setEmenter(int ementer) {
		this.ementer = ementer;
	}
	public int getEmpart() {
		return empart;
	}
	public void setEmpart(int empart) {
		this.empart = empart;
	}
	
	public int getEmid() {
		return emid;
	}
	public void setEmid(int emid) {
		this.emid = emid;
	}
	public String getEmname() {
		return emname;
	}
	public void setEmname(String emname) {
		this.emname = emname;
	}
	public int getEmsex() {
		return emsex;
	}
	public void setEmsex(int emsex) {
		this.emsex = emsex;
	}
	public int getEmage() {
		return emage;
	}
	public void setEmage(int emage) {
		this.emage = emage;
	}
	public String getEmphone() {
		return emphone;
	}
	public void setEmphone(String emphone) {
		this.emphone = emphone;
	}
	public String getEmadress() {
		return emadress;
	}
	public void setEmadress(String emadress) {
		this.emadress = emadress;
	}
	public String getEmjointime() {
		return emjointime;
	}
	public void setEmjointime(String emjointime) {
		this.emjointime = emjointime;
	}
	
}
