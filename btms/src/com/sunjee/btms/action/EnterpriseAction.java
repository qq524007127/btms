package com.sunjee.btms.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.EnterpriseService;

@Controller("enterpriseAction")
@Scope("prototype")
public class EnterpriseAction extends BaseAction<Enterprise> implements
		ModelDriven<Enterprise> {

	private static final long serialVersionUID = -2283481835301650347L;

	private Enterprise enterprise;
	
	private EnterpriseService enterpriseService;
	
	
	public Enterprise getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(Enterprise enterprise) {
		this.enterprise = enterprise;
	}

	public EnterpriseService getEnterpriseService() {
		return enterpriseService;
	}
	
	@Resource(name="enterpriseService")
	public void setEnterpriseService(EnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	public String grid() throws Exception {
		Map<String, Object> whereParams = getWhereParams();
		Map<String, SortType> sortParams = getSortParams();
		if(!sortParams.containsKey("enterPermit")){
			sortParams.put("enterPermit", SortType.desc);
		}
		setDataGrid(this.enterpriseService.getDataGrid(getPager(), whereParams, sortParams));
		return success();
	}
	
	public String add() throws Exception {
		this.enterpriseService.add(enterprise);
		return success();
	}
	
	public String edit() throws Exception {
		this.enterpriseService.update(enterprise);
		return success();
	}

	public String disable(){
		this.enterpriseService.updatePermit(enterprise,false);
		return success();
	}
	
	@Override
	public Enterprise getModel() {
		if (this.enterprise == null) {
			this.enterprise = new Enterprise();
		}
		return this.enterprise;
	}

}
