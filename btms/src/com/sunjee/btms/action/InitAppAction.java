package com.sunjee.btms.action;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.component.bean.Function;
import com.sunjee.component.bean.Module;
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
		List<Module> modList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			String modName = UUID.randomUUID().toString();
			Module mod = new Module();
			mod.setModuleName(modName);
			mod.setPageUrl("pageUrl" + (i + 1));
			mod.setRemark(modName + "的备注，备注序号为 " + (i + 1));
			if (i % 4 == 0) {
				mod.setPermit(false);
			}
			Set<Function> funSet = new HashSet<>();
			for (int j = 0; j < 8; j++) {
				Function fun = new Function(modName + "的功能" + (j + 1),
						"callback" + (i + 1) + "()");
				fun.setIcon("icon" + (i + 1));
				fun.setRemark(modName + "的功能" + (j + 1) + " 的备注信息...");
				if (i % 5 == 0) {
					fun.setPermit(false);
				}
				funSet.add(fun);
			}
			mod.setFuns(funSet);
			modList.add(mod);
		}
		this.moduleService.initModule(modList);
		this.msg = "系统初始化成功...";
		return super.execute();
	}
}
