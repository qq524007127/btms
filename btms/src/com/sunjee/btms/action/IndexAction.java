package com.sunjee.btms.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.component.bean.Module;
import com.sunjee.component.bean.User;
import com.sunjee.component.service.UserService;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends BaseAction implements ServletRequestAware{

	private static final long serialVersionUID = 2510272559015999859L;
	
	private HttpSession session;
	
	private UserService userService;
	
	private List<Module> moduleList;
	
	public UserService getUserService() {
		return userService;
	}
	@Resource(name="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}

	@Override
	public String execute() throws Exception {
		User user = (User) session.getAttribute("user");
		if(user == null){
			return LOGIN;
		}
		this.moduleList = this.userService.getModulesOfUser(user);
		return super.execute();
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.session = request.getSession();
	}

}
