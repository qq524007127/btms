package com.sunjee.component.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Module;
import com.sunjee.component.dao.ModuleDao;

@Repository("moduleDao")
public class ModuleDaoImpl extends SupportDaoImpl<Module> implements ModuleDao {

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

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getAllModule() {
		String hql = "from Module";
		return createQuery(hql, null).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DataGird<Module> getAllModuleByPage(Pager page) {
		DataGird<Module> dg = new DataGird<>();
		
		String hql = "select count(module.moduleId) from Module as module";
		dg.setTotal(getRecordTotal(hql, null));

		hql = "from Module order by permit desc";
		Query query = createQuery(hql, null);
		query.setFirstResult(page.getFirstIndex());
		query.setMaxResults(page.getRows());
		dg.setRows(query.list());
		return dg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getAllRootModule() {
		String hql = "from Module where parentModule is null and permit = true";
		return createQuery(hql, null).list();
	}

	@Override
	public void updatePermitState(String moduleId,boolean permit) {
		String hql = "update Module set permit = :permit where moduleId =:moduleId";
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("permit", permit);
		params.put("moduleId", moduleId);
		createQuery(hql, params).executeUpdate();
	}
}
