package com.sunjee.component.dao.impl;

import org.springframework.stereotype.Repository;

import com.sunjee.component.bean.Function;
import com.sunjee.component.dao.FunctionDao;

@Repository("functionDao")
public class FunctionDaoImpl extends SupportDaoImpl implements FunctionDao{

	private static final long serialVersionUID = -7240927326279582834L;

	@Override
	public Function addFunction(Function fun) {
		getSession().save(fun);
		return fun;
	}

	@Override
	public void updateFunction(Function fun) {
		getSession().update(fun);
	}

	@Override
	public void deleteFunction(Function fun) {
		getSession().delete(fun);
	}

}
