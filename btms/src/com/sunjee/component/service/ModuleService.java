package com.sunjee.component.service;

import java.util.List;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Module;

public interface ModuleService {
	Module addModule(Module mod);
	void updateModule(Module mod);
	void deleteModule(Module mod);
	List<Module> getAllModule();
	DataGird<Module> getAllModuleByPage(Pager page);
	List<Module> getAllRootModule();
	void updateModuleDisable(String moduleIds[]);
}
