package com.sunjee.component.service;

import java.util.List;

import com.sunjee.component.bean.Module;

public interface ModuleService {
	Module addModule(Module mod);
	void updateModule(Module mod);
	void deleteModule(Module mod);
	List<Module> getAllModule();
	void initModule(List<Module> modList);
}
