package com.entity;
/**
 * 
 * @�๦��˵����  �û�ע��ʵ����
 * @���޸��ߣ�  account �ʺ�
 * 			 pwd ����
 * @�޸����ڣ�  
 * @�޸�˵����  
 * @��˾���ƣ�adam  
 * @���ߣ�zhubin  
 * @����ʱ�䣺2017-6-20 ����9:21:16  
 * @�汾��V1.0
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
