package com.sunjee.btms.service;

import java.util.List;

import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Role;

public interface RoleService{

	DataGrid<Role> getRoleGrid(Pager page);

	void addRole(Role role);
	
	void update(Role role);
	
	List<Role> getAllRoles();
}
