package com.sunjee.btms.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.ExpensItem;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.bean.Tablet;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.BlessSeatService;
import com.sunjee.btms.service.MemberService;

@Controller("memberPayAction")
@Scope("prototype")
public class MemberPayAction extends BaseAction<Member> {

	private static final long serialVersionUID = 6409678087839635517L;

	private MemberService memberService;
	private BlessSeatService blessSeatService;

	DataGrid<BlessSeat> blessSeatGrid;
	DataGrid<Tablet> tabLetGrid;
	DataGrid<ExpensItem> exPensItemGrid;

	private Member member;
	private String memberId;
	private String bsIds;
	
	public MemberService getMemberService() {
		return memberService;
	}

	@Resource(name = "memberService")
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
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

	public DataGrid<Tablet> getTabLetGrid() {
		return tabLetGrid;
	}

	public void setTabLetGrid(DataGrid<Tablet> tabLetGrid) {
		this.tabLetGrid = tabLetGrid;
	}

	public DataGrid<ExpensItem> getExPensItemGrid() {
		return exPensItemGrid;
	}

	public void setExPensItemGrid(DataGrid<ExpensItem> exPensItemGrid) {
		this.exPensItemGrid = exPensItemGrid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getBsIds() {
		return bsIds;
	}

	public void setBsIds(String bsIds) {
		this.bsIds = bsIds;
	}

	@Override
	public String execute() throws Exception {
		this.member = this.memberService.getById(memberId);
		return super.execute();
	}
	

	public String blessSeatGrid() throws Exception {
		Map<String, Object> whereParams = new HashMap<>();
		if(!StringUtils.isEmpty(searchKey)){
			whereParams.put("searchKey",searchKey);
		}
		if(!StringUtils.isEmpty(bsIds)){
			whereParams.put("withOutIds", bsIds.split(","));
		}
		Map<String, SortType> sortParams = getSortParams();
		this.blessSeatGrid = this.blessSeatService.getEnableDataGrid(getPager(),whereParams,sortParams);
		return success();
	}
}
