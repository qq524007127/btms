package com.sunjee.btms.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Message;
import com.sunjee.btms.common.Pager;
import com.sunjee.component.bean.Module;
import com.sunjee.component.bean.Role;
import com.sunjee.component.service.ModuleService;
import com.sunjee.component.service.RoleService;

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction implements ModelDriven<Role> {

	private static final long serialVersionUID = 6041974902185255145L;

	private RoleService roleService;
	private ModuleService moduleService;
	private DataGird<Role> roleGrid;
	private Role role;
	private List<Module> moduleList;
	private String moduleIds[];

	public RoleService getRoleService() {
		return roleService;
	}

	@Resource(name = "roleService")
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public ModuleService getModuleService() {
		return moduleService;
	}

	@Resource(name = "moduleService")
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	public DataGird<Role> getRoleGrid() {
		return roleGrid;
	}

	public void setRoleGrid(DataGird<Role> roleGrid) {
		this.roleGrid = roleGrid;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Module> getModuleList() {
		return moduleList;
	}

	public void setModuleList(List<Module> moduleList) {
		this.moduleList = moduleList;
	}

	public String[] getModuleIds() {
		return moduleIds;
	}

	public void setModuleIds(String[] moduleIds) {
		this.moduleIds = moduleIds;
	}

	@Override
	public String execute() throws Exception {
		setModuleList(this.moduleService.getEnableModules());
		if (this.moduleList != null) {
			System.out.println("权限数量位：" + moduleList.size());
		}
		return SUCCESS;
	}

	/**
	 * 获取角色Grid
	 * 
	 * @return
	 * @throws Exception
	 */
	public String grid() throws Exception {
		this.roleGrid = this.roleService.getRoleGrid(new Pager(page, rows));
		return SUCCESS;
	}

	public String add() throws Exception {
		if(moduleIds != null){
			Set<Module> modSet = new HashSet<>();
			for(String moduleId : moduleIds){
				Module module = new Module(moduleId);
				modSet.add(module);
			}
			role.setModSet(modSet);
		}
		this.roleService.addRole(role);
		setMessage(new Message());
		return SUCCESS;
	}

	@Override
	public Role getModel() {
		if (role == null) {
			role = new Role();
		}
		return role;
	}

}
