package com.entity;
/**
 * 
 * @类功能说明：  用户注册实体类
 * @类修改者：  account 帐号
 * 			 pwd 密码
 * @修改日期：  
 * @修改说明：  
 * @公司名称：adam  
 * @作者：zhubin  
 * @创建时间：2017-6-20 上午9:21:16  
 * @版本：V1.0
 */
public class ZbUserdata {
	
	private String account;
	private String pwd;
	private String userState;
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
