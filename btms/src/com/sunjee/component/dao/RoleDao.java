package com.sunjee.component.dao;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Role;

public interface RoleDao extends SupportDao<Role>{
	DataGird<Role> getRoleGrid(Pager page);
	void addRole(Role role);
}
