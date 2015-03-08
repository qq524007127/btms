package com.sunjee.btms.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.component.bean.Module;
import com.sunjee.component.service.ModuleService;

@Controller("moduleAction")
@Scope("prototype")
public class ModuleAction extends BaseAction {

	private static final long serialVersionUID = 3268235124557471080L;

	private List<Module> modList;
	private ModuleService moduleService;

	public List<Module> getModList() {
		return modList;
	}

	public void setModList(List<Module> modList) {
		this.modList = modList;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	@Resource(name = "moduleService")
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	@Override
	public String execute() throws Exception {
		this.modList = this.moduleService.getAllModule();
		return super.SUCCESS;
	}
}
