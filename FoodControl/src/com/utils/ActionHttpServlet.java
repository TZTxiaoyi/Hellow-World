package com.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class ActionHttpServlet {
	public void setRequest(String Key ,Object Value){
		//耦合式
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute(Key, Value);
		//解耦式
		//Map<String, Object> requestMap = (Map<String, Object>) ActionContext.getContext().get("request");
	}
	public String getParameter(String name){
		//获取属性值
		HttpServletRequest request = ServletActionContext.getRequest();
		return request.getParameter(name);
	}
	public HttpServletRequest getrRequest(){
		HttpServletRequest request=ServletActionContext.getRequest();
		return request;
	}
	public HttpServletResponse getResponse(String Key ,Object Value){
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		return response;
	}
	public void setSession(String key ,Object value){//设置session
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		sessionMap.put(key,value);
	}
	public Object getSessionName(String key ){//获取session
		Map<String,Object> sessionMap = ActionContext.getContext().getSession();
		return sessionMap.get(key);
	}
}
