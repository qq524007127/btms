package com.sunjee.btms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends BaseAction implements ServletRequestAware{

	private static final long serialVersionUID = 2510272559015999859L;
	
	private HttpSession session;
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.session = request.getSession();
	}

}
