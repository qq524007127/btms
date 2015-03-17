package com.sunjee.component.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Module;
import com.sunjee.component.dao.ModuleDao;
import com.sunjee.component.service.ModuleService;

@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {

	private ModuleDao moduleDao;

	public ModuleDao getModuleDao() {
		return moduleDao;
	}

	@Resource(name = "moduleDao")
	public void setModuleDao(ModuleDao moduleDao) {
		this.moduleDao = moduleDao;
	}

	@Override
	public Module addModule(Module mod) {
		return this.moduleDao.addModule(mod);
	}

	@Override
	public void updateModule(Module mod) {
		this.moduleDao.updateModule(mod);
	}

	@Override
	public void deleteModule(Module mod) {
		this.moduleDao.deleteModule(mod);
	}

	@Override
	public List<Module> getAllModule() {
		return this.moduleDao.getAllModule();
	}

	@Override
	public DataGird<Module> getModuleGrid(Pager page) {
		return this.moduleDao.getModuleGrid(page);
	}

	@Override
	public List<Module> getAllRootModule() {
		return this.moduleDao.getAllRootModule();
	}

	/**
	 * 禁用模块
	 */
	@Override
	public void updateDisable(String... moduleIds) {
		if (moduleIds == null) {
			return;
		}
		for (String moduleId : moduleIds) {
			this.moduleDao.updatePermitState(moduleId, false);
		}
	}

	/**
	 * 启用模块
	 */
	@Override
	public void updateEnable(String... moduleIds) {
		if (moduleIds == null) {
			return;
		}
		for (String moduleId : moduleIds) {
			this.moduleDao.updatePermitState(moduleId, true);
		}
	}

	@Override
	public List<Module> getEnableModules() {
		List<Module> enableModules = new ArrayList<Module>();
		List<Module> all = this.moduleDao.getAllModule();
		for(Module mod : all){
			if(mod.getParentModule() != null && mod.isPermit()){
				enableModules.add(mod);
			}
		}
		return enableModules;
	}

}
