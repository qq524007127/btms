package com.sunjee.component.service.impl;

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
	public void updateModuleDisable(String moduleIds[]) {
		for (String moduleId : moduleIds) {
			this.moduleDao.updateModuleDisable(moduleId);
		}
	}

	@Override
	public List<Module> getAllModule() {
		return this.moduleDao.getAllModule();
	}

	@Override
	public DataGird<Module> getAllModuleByPage(Pager page) {
		return this.moduleDao.getAllModuleByPage(page);
	}

	@Override
	public List<Module> getAllRootModule() {
		return this.moduleDao.getAllRootModule();
	}

}
