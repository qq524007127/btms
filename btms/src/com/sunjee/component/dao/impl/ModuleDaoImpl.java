package com.sunjee.component.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sunjee.btms.common.SortType;
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
	public List<Module> getAllRootModule(Map<String, SortType> sortParams) {
		/*StringBuffer hql = new StringBuffer("from Module where parentModule is null and permit = true");
		return createQuery(hql.toString(),null).list();*/
		Map<String, Object> whereParams = new HashMap<>();
		whereParams.put("parentModule", null);
		whereParams.put("permit", true);
		return createQuery(whereParams, null).list();
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
