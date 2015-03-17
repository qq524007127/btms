package com.sunjee.component.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Role;
import com.sunjee.component.dao.RoleDao;

@Repository("roleDao")
public class RoleDaoImpl extends SupportDaoImpl<Role> implements RoleDao {

	private static final long serialVersionUID = -5628717533485365773L;

	@SuppressWarnings("unchecked")
	@Override
	public DataGird<Role> getRoleGrid(Pager page) {
		DataGird<Role> dg = new DataGird<>();
		String hql = "select count(roleId) from Role";
		dg.setTotal(getRecordTotal(hql, null));
		hql = "from Role";
		Query query = createQuery(hql, null);
		query.setFirstResult(page.getFirstIndex());
		query.setMaxResults(page.getRows());
		dg.setRows(query.list());
		return dg;
	}

	@Override
	public void addRole(Role role) {
		getSession().save(role);
	}

}
