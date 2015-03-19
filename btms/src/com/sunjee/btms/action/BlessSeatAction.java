package com.sunjee.btms.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.BlessSeatService;

@Controller("blessSeatAction")
@Scope("prototype")
public class BlessSeatAction extends BaseAction implements
		ModelDriven<BlessSeat> {

	private static final long serialVersionUID = 3053794916587390844L;

	private BlessSeatService blessSeatService;

	private BlessSeat blessSeat;
	private DataGird<BlessSeat> blessSeatGrid;

	public BlessSeatService getBlessSeatService() {
		return blessSeatService;
	}

	@Resource(name = "blessSeatService")
	public void setBlessSeatService(BlessSeatService blessSeatService) {
		this.blessSeatService = blessSeatService;
	}

	public BlessSeat getBlessSeat() {
		return blessSeat;
	}

	public void setBlessSeat(BlessSeat blessSeat) {
		this.blessSeat = blessSeat;
	}

	public DataGird<BlessSeat> getBlessSeatGrid() {
		return blessSeatGrid;
	}

	public void setBlessSeatGrid(DataGird<BlessSeat> blessSeatGrid) {
		this.blessSeatGrid = blessSeatGrid;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public String grid() {
		Map<String, Object> whereParams = new HashMap<String, Object>();
		//whereParams.put("permit", true);
		
		Map<String, SortType> sortParams = new HashMap<String, SortType>();
		//sortParams.put("bsCode",SortType.asc);
		this.blessSeatGrid = this.blessSeatService.getBlessSeatGrid(new Pager(page, rows), whereParams, sortParams);
		return SUCCESS;
	}

	@Override
	public BlessSeat getModel() {
		if(blessSeat == null){
			blessSeat = new BlessSeat();
		}
		return null;
	}

}
