package com.sunjee.component.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.component.bean.Module;
import com.sunjee.component.dao.ModuleDao;

@Repository("moduleDao")
public class ModuleDaoImpl extends SupportDaoImpl implements ModuleDao{

	private static final long serialVersionUID = -7240927326279582834L;

	@Override
	public Module addModule(Module mod) {
		getSession().persist(mod);
		return mod;
	}

	@Override
	public void updateModule(Module mod) {
		getSession().merge(mod);
	}

	@Override
	public void deleteModule(Module mod) {
		getSession().delete(mod);
	}

	@Override
	public List<Module> getAllModule() {
		String hql = "from Module";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

}
