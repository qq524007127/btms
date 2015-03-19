package com.sunjee.btms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.common.Constant;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.UserDao;
import com.sunjee.btms.service.UserService;
import com.sunjee.component.bean.Module;
import com.sunjee.component.bean.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	@Resource(name = "userDao")
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public DataGird<User> getUserGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.userDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public void addUser(User user) {
		this.userDao.saveEntity(user);
	}

	@Override
	public void updateUser(User user) {
		this.userDao.updateEntiry(user);
	}

	@Override
	public void resetPassword(String[] ids) {
		if(ids == null || ids.length < 1){
			return;
		}
		for(String userId : ids){
			this.userDao.changePassword(userId, Constant.INIT_PASSWORD);
		}
	}

	@Override
	public User getUserByCodeAndPassword(String userCode, String password) {
		Map<String, Object> whereParams = new HashMap<String, Object>();
		whereParams.put("userCode",userCode);
		whereParams.put("password",password);
		whereParams.put("permit",true);
		List<User> userList = this.userDao.getEntitys(null,whereParams, null);
		User user = null;
		if(userList != null && userList.size() > 0){
			user = userList.get(0);
		}
		return user;
	}

	@Override
	public List<Module> getModulesOfUser(User user) {
		return this.userDao.getModulesOfUser(user);
	}

}
