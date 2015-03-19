package com.sunjee.btms.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.dao.RoleDao;
import com.sunjee.component.bean.Role;

@Repository("roleDao")
public class RoleDaoImpl extends SupportDaoImpl<Role> implements RoleDao {

	private static final long serialVersionUID = -5628717533485365773L;

	@Override
	public void addRole(Role role) {
		getSession().save(role);
	}

}
