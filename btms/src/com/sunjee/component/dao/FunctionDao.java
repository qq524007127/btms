package com.sunjee.component.dao;

import com.sunjee.component.bean.Function;

public interface FunctionDao {
	Function addFunction(Function fun);
	void updateFunction(Function fun);
	void deleteFunction(Function fun);
}
