package com.sunjee.component.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Module;
import com.sunjee.component.dao.ModuleDao;

@Repository("moduleDao")
public class ModuleDaoImpl extends SupportDaoImpl implements ModuleDao {

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

	@SuppressWarnings("unchecked")
	@Override
	public DataGird<Module> getAllModuleByPage(Pager page) {
		DataGird<Module> dg = new DataGird<>();
		
		String hql = "select count(module.moduleId) from Module as module";
		dg.setTotal(getCount(hql, null));

		hql = "from Module";
		Query query = getSession().createQuery(hql);
		query.setFirstResult(page.getFirstIndex());
		query.setMaxResults(page.getRows());
		dg.setRows(query.list());
		return dg;
	}

	@Override
	public List<Module> getAllRootModule() {
		String hql = "from Module where parentModule is null";
		Query query = getSession().createQuery(hql);
		return query.list();
	}

	@Override
	public void updateModuleDisable(String moduleId) {
		String hql = "update Module set permit = true where moduleId =:moduleId";
		Query query = getSession().createQuery(hql);
		query.setParameter("modId", moduleId);
		query.executeUpdate();
	}
}
