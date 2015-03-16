package com.sunjee.btms.action;


import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.component.service.ModuleService;

@Controller("initAppAction")
@Scope("prototype")
public class InitAppAction extends BaseAction {

	private static final long serialVersionUID = -4785173734437008811L;

	private String msg;
	private ModuleService moduleService;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	public InitAppAction() {
		System.out.println("Action正在初始化...");
	}
	
	@Resource(name = "moduleService")
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@Override
	public String execute() throws Exception {
		
		return super.execute();
	}
}
