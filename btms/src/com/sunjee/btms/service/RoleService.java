package com.sunjee.btms.service;

import java.util.List;

import com.sunjee.component.bean.Role;

public interface RoleService extends SupportService<Role>{

	List<Role> getAllRoles();
}
