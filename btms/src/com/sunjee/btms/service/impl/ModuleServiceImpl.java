package com.sunjee.btms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.ModuleDao;
import com.sunjee.btms.service.ModuleService;
import com.sunjee.component.bean.Module;

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
		return this.moduleDao.getEntitys(null,null, null);
	}

	@Override
	public DataGird<Module> getModuleGrid(Pager page) {
		Map<String, SortType> sortParams = new HashMap<String, SortType>();
		sortParams.put("moduleSort", SortType.asc);
		sortParams.put("permit",SortType.desc);
		sortParams.put("parentModule",SortType.asc);
		return this.moduleDao.getDataGrid(page, null, sortParams);
	}

	@Override
	public List<Module> getAllRootModule() {
		return this.moduleDao.getAllRootModule(null);
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
		List<Module> all = this.moduleDao.getEntitys(null,null, null);
		for(Module mod : all){
			if(mod.getParentModule() != null && mod.isPermit()){
				enableModules.add(mod);
			}
		}
		return enableModules;
	}

}
