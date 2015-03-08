package com.sunjee.component.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.component.bean.Function;
import com.sunjee.component.dao.FunctionDao;
import com.sunjee.component.service.FunctionService;

@Service("functionService")
public class FunctionServiceImpl implements FunctionService {

	private FunctionDao functionDao;
	
	
	
	public FunctionDao getFunctionDao() {
		return functionDao;
	}

	@Resource(name="functionDao")
	public void setFunctionDao(FunctionDao functionDao) {
		this.functionDao = functionDao;
	}

	@Override
	public Function addFunction(Function fun) {
		this.functionDao.addFunction(fun);
		return fun;
	}

	@Override
	public void updateFunction(Function fun) {
		this.functionDao.updateFunction(fun);
	}

	@Override
	public void deleteFunction(Function fun) {
		this.functionDao.deleteFunction(fun);
	}

	@Override
	public void initFunction(List<Function> funList) {
		for(Function fun : funList){
			this.functionDao.addFunction(fun);
		}
	}

}
