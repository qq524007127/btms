package com.sunjee.btms.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.Deader;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.DeaderService;

@Controller("deaderAction")
@Scope("prototype")
public class DeaderAction extends BaseAction<Deader> implements
		ModelDriven<Deader> {

	private static final long serialVersionUID = -4838577754667135212L;

	private DeaderService deaderService;

	private Deader deader;

	public DeaderService getDeaderService() {
		return deaderService;
	}

	@Resource(name = "deaderService")
	public void setDeaderService(DeaderService deaderService) {
		this.deaderService = deaderService;
	}

	public Deader getDeader() {
		return deader;
	}

	public void setDeader(Deader deader) {
		this.deader = deader;
	}

	public String grid() {
		Map<String, Object> whereParams = getWhereParams();
		Map<String, SortType> sortParams = getSortParams();
		setDataGrid(this.deaderService.getDataGrid(getPager(), whereParams, sortParams));
		return success();
	}

	@Override
	public Deader getModel() {
		if (this.deader == null) {
			this.deader = new Deader();
		}
		return this.deader;
	}

}
