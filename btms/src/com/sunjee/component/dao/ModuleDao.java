package com.sunjee.component.dao;

import java.util.List;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Module;

public interface ModuleDao extends SupportDao<Module>{
	Module addModule(Module mod);
	void updateModule(Module mod);
	void deleteModule(Module mod);
	List<Module> getAllModule();
	DataGird<Module> getModuleGrid(Pager page);
	List<Module> getAllRootModule();
	void updatePermitState(String moduleId,boolean permit);
}
