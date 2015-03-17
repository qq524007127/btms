package com.sunjee.component.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Role;
import com.sunjee.component.dao.RoleDao;
import com.sunjee.component.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	private RoleDao roleDao;

	public RoleDao getRoleDao() {
		return roleDao;
	}

	@Resource(name = "roleDao")
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public DataGird<Role> getRoleGrid(Pager page) {
		return this.roleDao.getRoleGrid(page);
	}

	@Override
	public void addRole(Role role) {
		this.roleDao.addRole(role);
	}

}
