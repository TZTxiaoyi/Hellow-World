package com.lanjieqi.interceptor;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;



public class LyLanJieQi extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation arg0) throws Exception{
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();
		//request.getSession().getAttribute("name");
		String uri = request.getRequestURI();

		System.out.println("lujing:"+uri);
		List list = (List) request.getSession().getAttribute("listvalue");
		for (int i = 0; i < list.size(); i++) {			
			List list6=(List) list.get(i);
			String parturi = (String) list6.get(1);
			//System.out.println("8888"+uri+parturi);
			if(uri.equals(parturi)){
				String result = arg0.invoke();
				return result;
			}
			
		}
		return "login";
	}		
}
