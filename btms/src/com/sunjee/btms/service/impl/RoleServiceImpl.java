package com.sunjee.btms.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.dao.RoleDao;
import com.sunjee.btms.service.RoleService;
import com.sunjee.component.bean.Role;

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
	public DataGrid<Role> getRoleGrid(Pager page) {
		return this.roleDao.getDataGrid(page, null, null);
	}

	@Override
	public void addRole(Role role) {
		this.roleDao.addRole(role);
	}

	@Override
	public void update(Role role) {
		this.roleDao.updateEntiry(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return this.roleDao.getEntitys(null,null, null);
	}

}
