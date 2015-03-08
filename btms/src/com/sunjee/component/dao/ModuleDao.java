package com.sunjee.component.dao;

import java.util.List;

import com.sunjee.component.bean.Module;

public interface ModuleDao {
	Module addModule(Module mod);
	void updateModule(Module mod);
	void deleteModule(Module mod);
	List<Module> getAllModule();
}
