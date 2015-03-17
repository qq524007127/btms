package com.sunjee.component.service;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Role;

public interface RoleService {
	DataGird<Role> getRoleGrid(Pager page);
	void addRole(Role role);
}
