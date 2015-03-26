package com.sunjee.btms.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.ExpensItem;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.bean.PayDetail;
import com.sunjee.btms.bean.Tablet;
import com.sunjee.btms.bean.TabletRecord;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.DonationType;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.BlessSeatService;
import com.sunjee.btms.service.ExpensItemService;
import com.sunjee.btms.service.MemberService;
import com.sunjee.btms.service.TabletService;
import com.sunjee.component.bean.User;
import com.sunjee.util.DateUtil;

@Controller("memberPayAction")
@Scope("prototype")
public class MemberPayAction extends BaseAction<Member> implements ModelDriven<Member>{

	private static final long serialVersionUID = 6409678087839635517L;

	private MemberService memberService;
	private BlessSeatService blessSeatService;
	private TabletService tabletService;
	private ExpensItemService expensItemService;

	DataGrid<BlessSeat> blessSeatGrid;
	DataGrid<Tablet> tabletGrid;
	DataGrid<ExpensItem> expensItemGrid;

	private Member member;
	private String withoutIds;
	
	private String blessSeatIds[];	//捐赠的福位ID
	private int blessSeatBuyTypes[];	//捐赠福位类型（普通捐赠或租赁）
	private int bsLeaseLongTime[];	//租赁时长（年限）
	private float blessSeatPrices[];	//福位价格
	
	private String tabletIds[];	//捐赠的牌位ID
	private int tabletBuyLongTime[];	//捐赠时长（年限）
	private float tabletPrices[];	//牌位单价
	
	private String itemIds[];	//捐赠的其它收费项目ID
	private int itemBuyLongTime[];	//捐赠时长（年限）
	private float itemPrices[];	//项目单价
	private String itemNames[];	//名称

	public MemberService getMemberService() {
		return memberService;
	}

	@Resource(name = "memberService")
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public TabletService getTabletService() {
		return tabletService;
	}

	@Resource(name = "tabletService")
	public void setTabletService(TabletService tabletService) {
		this.tabletService = tabletService;
	}

	public ExpensItemService getExpensItemService() {
		return expensItemService;
	}

	@Resource(name = "expensItemService")
	public void setExpensItemService(ExpensItemService expensItemService) {
		this.expensItemService = expensItemService;
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

	public DataGrid<Tablet> getTabletGrid() {
		return tabletGrid;
	}

	public void setTabletGrid(DataGrid<Tablet> tabletGrid) {
		this.tabletGrid = tabletGrid;
	}

	public DataGrid<ExpensItem> getExpensItemGrid() {
		return expensItemGrid;
	}

	public void setExpensItemGrid(DataGrid<ExpensItem> expensItemGrid) {
		this.expensItemGrid = expensItemGrid;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getWithoutIds() {
		return withoutIds;
	}

	public void setWithoutIds(String withoutIds) {
		this.withoutIds = withoutIds;
	}

	public String[] getBlessSeatIds() {
		return blessSeatIds;
	}

	public void setBlessSeatIds(String[] blessSeatIds) {
		this.blessSeatIds = blessSeatIds;
	}

	public int[] getBlessSeatBuyTypes() {
		return blessSeatBuyTypes;
	}

	public void setBlessSeatBuyTypes(int[] blessSeatBuyTypes) {
		this.blessSeatBuyTypes = blessSeatBuyTypes;
	}

	public int[] getBsLeaseLongTime() {
		return bsLeaseLongTime;
	}

	public void setBsLeaseLongTime(int[] bsLeaseLongTime) {
		this.bsLeaseLongTime = bsLeaseLongTime;
	}

	public float[] getBlessSeatPrices() {
		return blessSeatPrices;
	}

	public void setBlessSeatPrices(float[] blessSeatPrices) {
		this.blessSeatPrices = blessSeatPrices;
	}

	public String[] getTabletIds() {
		return tabletIds;
	}

	public void setTabletIds(String[] tabletIds) {
		this.tabletIds = tabletIds;
	}

	public int[] getTabletBuyLongTime() {
		return tabletBuyLongTime;
	}

	public void setTabletBuyLongTime(int[] tabletBuyLongTime) {
		this.tabletBuyLongTime = tabletBuyLongTime;
	}

	public String[] getItemIds() {
		return itemIds;
	}

	public void setItemIds(String[] itemIds) {
		this.itemIds = itemIds;
	}

	public int[] getItemBuyLongTime() {
		return itemBuyLongTime;
	}

	public void setItemBuyLongTime(int[] itemBuyLongTime) {
		this.itemBuyLongTime = itemBuyLongTime;
	}

	public float[] getTabletPrices() {
		return tabletPrices;
	}

	public void setTabletPrices(float[] tabletPrices) {
		this.tabletPrices = tabletPrices;
	}

	public float[] getItemPrices() {
		return itemPrices;
	}

	public void setItemPrices(float[] itemPrices) {
		this.itemPrices = itemPrices;
	}
	
	public String[] getItemNames() {
		return itemNames;
	}

	public void setItemNames(String[] itemNames) {
		this.itemNames = itemNames;
	}
	
	/*=====================逻辑方法开始（以上内容均为getter,setter方法）=====================*/
	
	@Override
	public String execute() throws Exception {
		this.member = this.memberService.getById(this.member.getMemberId());
		return super.execute();
	}

	public String blessSeatGrid() throws Exception {
		Map<String, Object> whereParams = getWhereParams();
		if(!StringUtils.isEmpty(searchKey)){
			whereParams.put("searchKey", searchKey.trim());
		}
		if (!StringUtils.isEmpty(withoutIds)) {
			whereParams.put("withoutIds", withoutIds.split(","));
		}
		Map<String, SortType> sortParams = getSortParams();
		this.blessSeatGrid = this.blessSeatService.getEnableDataGrid(
				getPager(), whereParams, sortParams);
		return success();
	}
	
	public String tabletGrid() throws Exception {
		Map<String, Object> whereParams = getWhereParams();
		if(!StringUtils.isEmpty(searchKey)){
			whereParams.put("searchKey", searchKey.trim());
		}
		if (!StringUtils.isEmpty(withoutIds)) {
			whereParams.put("withoutIds", withoutIds.split(","));
		}
		Map<String, SortType> sortParams = getSortParams();
		this.tabletGrid = this.tabletService.getEnableDataGrid(getPager(), whereParams, sortParams);
		return success();
	}
	
	public String expensItemGrid() throws Exception {
		Map<String, Object> whereParams = getWhereParams("itemName");
		whereParams.put("permit", true);
		Map<String, SortType> sortParams = getSortParams();
		this.expensItemGrid = this.expensItemService.getDataGrid(getPager(), whereParams, sortParams);
		return success();
	}
	
	/**
	 * 确认捐赠
	 * @return
	 * @throws Exception
	 */
	public String doPay() throws Exception {
		List<BSRecord> BSRList = new ArrayList<BSRecord>();
		List<TabletRecord> TLRList = new ArrayList<>();
		List<PayDetail> payDetailList = new ArrayList<>();
		
		initBSRecordList(BSRList);
		
		initTabletRecord(TLRList);
		
		initPayDetailList(payDetailList);
		
		return success();
	}
	
	/**
	 * 初始化其它收费项目列表
	 * @param payDetailList
	 */
	private void initPayDetailList(List<PayDetail> payDetailList) {
		if(itemIds == null){
			return;
		}
		for(int i = 0; i < itemIds.length; i ++){
			String id = itemIds[i];
			PayDetail pd = new PayDetail();
			pd.setDetailItemName(itemNames[i]);
			pd.setDetailLength(itemBuyLongTime[i]);
			pd.setDetTotalPrice(itemPrices[i] * itemBuyLongTime[i]);
			pd.setItemPrice(itemPrices[i]);
			payDetailList.add(pd);
		}
	}

	/**
	 * 初始化牌位捐赠列表
	 * @param tLRList
	 */
	private void initTabletRecord(List<TabletRecord> tLRList) {
		if(tabletIds == null){
			return;
		}
		for(int i = 0; i < tabletIds.length; i ++){
			TabletRecord tlr = new TabletRecord();
			tlr.setTablet(new Tablet(tabletIds[i]));
			tlr.setMember(member);
			tlr.setTlRecCreateDate(new Date());
			tlr.setTlRecLength(tabletBuyLongTime[i]);
			tlr.setTlRecOverdue(DateUtil.getAfterYears(new Date(), tabletBuyLongTime[i]));
			tlr.setTlRecUser((User)this.session.get("user"));
			tlr.setTlTotalPrice(tabletPrices[i] * tabletBuyLongTime[i]);
			tLRList.add(tlr);
		}
	}

	/*
	 * 初始化福位捐赠记录列表
	 */
	private void initBSRecordList(List<BSRecord> BSRList){
		if(blessSeatIds == null){
			return;
		}
		for(int i = 0; i < blessSeatIds.length; i ++){
			BSRecord bsr = new BSRecord();
			bsr.setBlessSeat(new BlessSeat(blessSeatIds[i]));
			bsr.setBsRecCreateDate(new Date());
			bsr.setMember(member);
			bsr.setBsRecUser((User)this.session.get("user"));
			DonationType donaType = DonationType.values()[blessSeatBuyTypes[i]];
			bsr.setDonatType(donaType);
			bsr.setBsRecToltalPrice(blessSeatPrices[i]);
			if(donaType.equals(DonationType.lease)){
				bsr.setDonatLength(bsLeaseLongTime[i]);
				bsr.setDonatOverdue(DateUtil.getAfterYears(new Date(), bsLeaseLongTime[i]));
				bsr.setBsRecToltalPrice(0f);
			}
			BSRList.add(bsr);
		}
	}

	@Override
	public Member getModel() {
		if(this.member == null){
			this.member = new Member();
		}
		return this.member;
	}
	
}
