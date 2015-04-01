package com.sunjee.btms.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.BSRecordService;
import com.sunjee.btms.service.BlessSeatService;

@Controller("bsRecordAction")
@Scope("prototype")
public class BSRecordAction extends BaseAction<BSRecord> implements
		ModelDriven<BSRecord> {

	private static final long serialVersionUID = 3961832535184267214L;

	private BSRecordService bsRecordService;
	private BlessSeatService blessSeatService;

	private DataGrid<BlessSeat> blessSeatGrid;

	private BSRecord bsRecord;
	private String memberId;

	public BSRecordService getBsRecordService() {
		return bsRecordService;
	}

	@Resource(name = "bsRecordService")
	public void setBsRecordService(BSRecordService bsRecordService) {
		this.bsRecordService = bsRecordService;
	}

	public BlessSeatService getBlessSeatService() {
		return blessSeatService;
	}

	@Resource(name = "blessSeatService")
	public void setBlessSeatService(BlessSeatService blessSeatService) {
		this.blessSeatService = blessSeatService;
	}

	public DataGrid<BlessSeat> getBlessSeatGrid() {
		return blessSeatGrid;
	}

	public void setBlessSeatGrid(DataGrid<BlessSeat> blessSeatGrid) {
		this.blessSeatGrid = blessSeatGrid;
	}

	public BSRecord getBsRecord() {
		return bsRecord;
	}

	public void setBsRecord(BSRecord bsRecord) {
		this.bsRecord = bsRecord;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String grid() {
		Map<String, Object> whereParams = getWhereParams();
		whereParams.put("mem.memberId", memberId);
		setDataGrid(this.bsRecordService.getDataGrid(getPager(), whereParams,
				getSortParams()));
		return success();
	}
	
	public String blessSeatGrid(){
		Map<String, Object> whereParams = getWhereParams();
		whereParams.put("member", new Member(memberId));
		Map<String, SortType> sortParams = getSortParams();
		this.blessSeatGrid = this.blessSeatService.getDataGridOnMember(new Member(memberId),getPager(),whereParams,sortParams);
		return success();
	}

	@Override
	public BSRecord getModel() {
		return null;
	}

}
