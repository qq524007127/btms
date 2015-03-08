package com.sunjee.component.service;

import java.util.List;

import com.sunjee.component.bean.Function;

public interface FunctionService {
	Function addFunction(Function fun);
	void updateFunction(Function fun);
	void deleteFunction(Function fun);
	void initFunction(List<Function> funList);
}
