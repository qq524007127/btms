package com.sunjee.component.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.sunjee.component.bean.Module;
import com.sunjee.component.bean.Role;
import com.sunjee.component.bean.User;
import com.sunjee.component.dao.UserDao;

@Repository("userDao")
public class UserDaoImpl extends SupportDaoImpl<User> implements UserDao {

	private static final long serialVersionUID = -145776372827483926L;
	
	/**
	 * 修改用户密码
	 */
	@Override
	public void changePassword(String userId, String newPassword) {
		String hql = "update User set password = :password where userId = :userId";
		Map<String, Object> whereParams = new HashMap<String, Object>();
		whereParams.put("password", newPassword);
		whereParams.put("userId", userId);
		createQuery(hql, whereParams).executeUpdate();
	}

	@Override
	public List<Module> getModulesOfUser(User user) {
		List<Module> moduleList = new ArrayList<Module>();
		Map<String, Object> whereParams = new HashMap<>();
		whereParams.put("userId", user.getUserId());
		String hql = "select user.roleSet from User as user where user.userId = :userId";
		/*List<Set<Role>> list = createQuery(hql, whereParams).list();
		for(Set<Role> roleSet : list){
			if(roleSet == null){
				continue;
			}
			for(Role role : roleSet){
				moduleList.addAll(role.getModSet());
			}
		}*/
		List<Role> list = createQuery(hql, whereParams).list();
		for(Role role : list){
			moduleList.addAll(role.getModSet());
		}
		hql = "from Module mod,User user,Role role where mod.permit = true and mod.parentModule is not null and mod.";
		
		return moduleList;
	}

}
