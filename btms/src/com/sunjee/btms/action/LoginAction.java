package com.sunjee.btms.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.component.bean.User;

@Controller("loginAction")
@Scope("prototype")
public class LoginAction extends BaseAction implements ModelDriven<User>,ServletRequestAware {

	private static final long serialVersionUID = -4119287606729621361L;
	
	private HttpSession session;
	
	private User user;
	private String msg;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	public String login(){
		if(user.getUserCode().equals(user.getPassword()) && user.getUserCode().equals("admin")){
			user.setUserName("系统管理员");
			this.session.setAttribute("user", user);
			return SUCCESS;
		} else {
			this.msg = "用户名或密码错误，请重新输入！";
		}
		return LOGIN;
	}

	public String loginOut() {
		this.session.invalidate();
		return LOGIN;
	}

	@Override
	public User getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.session = request.getSession();
	}

}
