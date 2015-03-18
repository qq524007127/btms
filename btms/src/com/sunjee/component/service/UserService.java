package com.sunjee.component.service;

import java.util.List;
import java.util.Map;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.component.bean.Module;
import com.sunjee.component.bean.User;

public interface UserService {

	DataGird<User> getUserGrid(Pager page, Map<String, Object> whereParams,Map<String, SortType> sortParams);

	void addUser(User user);

	void updateUser(User user);

	void resetPassword(String[] ids);
	
	User getUserByCodeAndPassword(String userCode, String password);
	
	List<Module> getModulesOfUser(User user);
}