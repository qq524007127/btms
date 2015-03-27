package com.sunjee.btms.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.bean.MemberCard;
import com.sunjee.btms.bean.PayDetail;
import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.bean.TabletRecord;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.PayRecordDao;
import com.sunjee.btms.exception.AppRuntimeException;
import com.sunjee.btms.service.BSRecordService;
import com.sunjee.btms.service.MemberService;
import com.sunjee.btms.service.PayDetailService;
import com.sunjee.btms.service.PayRecordService;
import com.sunjee.btms.service.TabletRecordService;
import com.sunjee.component.bean.User;

@Service("payRecordService")
public class PayRecordServiceImpl implements PayRecordService {

	private PayRecordDao payRecordDao;
	private MemberService memberService;
	private BSRecordService bsRecordService;
	private TabletRecordService tabletRecordService;
	private PayDetailService payDetailService;

	public PayRecordDao getPayRecordDao() {
		return payRecordDao;
	}

	@Resource(name = "payRecordDao")
	public void setPayRecordDao(PayRecordDao payRecordDao) {
		this.payRecordDao = payRecordDao;
	}
	
	public MemberService getMemberService() {
		return memberService;
	}
	
	@Resource(name="memberService")
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	public BSRecordService getBsRecordService() {
		return bsRecordService;
	}

	@Resource(name="bsRecordService")
	public void setBsRecordService(BSRecordService bsRecordService) {
		this.bsRecordService = bsRecordService;
	}

	public TabletRecordService getTabletRecordService() {
		return tabletRecordService;
	}
	
	@Resource(name="tabletRecordService")
	public void setTabletRecordService(TabletRecordService tabletRecordService) {
		this.tabletRecordService = tabletRecordService;
	}

	public PayDetailService getPayDetailService() {
		return payDetailService;
	}
	
	@Resource(name="payDetailService")
	public void setPayDetailService(PayDetailService payDetailService) {
		this.payDetailService = payDetailService;
	}

	@Override
	public DataGrid<PayRecord> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.payRecordDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public PayRecord add(PayRecord t) {
		return this.payRecordDao.saveEntity(t);
	}

	@Override
	public void update(PayRecord t) {
		this.payRecordDao.updateEntity(t);
	}

	@Override
	public List<PayRecord> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.payRecordDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public PayRecord getById(String id) {
		return this.payRecordDao.getEntityById(id);
	}

	@Override
	public void delete(PayRecord t) {
		this.payRecordDao.deletEntity(t);
	}

	@Override
	public MemberCard addPayRecord(List<BSRecord> bsRecordList,
			List<TabletRecord> tabletRecord, List<PayDetail> payDetailList,
			Member member, User user) {
		PayRecord payRecord = new PayRecord();
		float total = 0f;
		for(BSRecord t : bsRecordList){
			total += t.getBsRecToltalPrice();
		}
		for(TabletRecord t : tabletRecord){
			total += t.getTlTotalPrice();
		}
		for(PayDetail t : payDetailList){
			total += t.getDetTotalPrice();
		}
		payRecord.setTotalPrice(total);
		payRecord.setMember(member);
		payRecord.setPayUser(user);
		payRecord.setPayDate(new Date());
		this.payRecordDao.saveEntity(payRecord);
		for(BSRecord t : bsRecordList){
			if(this.bsRecordService.getIsSelled(t.getBlessSeat().getBsId())){
				throw new AppRuntimeException("同一个福位同时只能被一个会员捐赠或租赁。");
			}
			t.setPayRecord(payRecord);
			this.bsRecordService.add(t);
		}
		for(TabletRecord t : tabletRecord){
			if(this.tabletRecordService.getIsSelled(t.getTablet().getTabletId())){
				throw new AppRuntimeException("同一个牌位同时只能被一个会员捐赠。");
			}
			t.setPayRecord(payRecord);
			this.tabletRecordService.add(t);
		}
		for(PayDetail t : payDetailList){
			t.setPayRecord(payRecord);
			this.payDetailService.add(t);
		}
		member = this.memberService.getById(member.getMemberId());
		return member.getMemberCard();
	}

	@Override
	public MemberCard addPayRecord(List<BSRecord> bsRecordList,
			List<TabletRecord> tabletRecord, List<PayDetail> payDetailList,
			Enterprise enterprise, User user) {
		PayRecord payRecord = new PayRecord();
		float total = 0f;
		for(BSRecord t : bsRecordList){
			total += t.getBsRecToltalPrice();
		}
		for(TabletRecord t : tabletRecord){
			total += t.getTlTotalPrice();
		}
		for(PayDetail t : payDetailList){
			total += t.getDetTotalPrice();
		}
		payRecord.setTotalPrice(total);
		payRecord.setBsRecordSet(new HashSet<>(bsRecordList));
		payRecord.setPayDatailSet(new HashSet<>(payDetailList));
		payRecord.setTlRecordSet(new HashSet<>(tabletRecord));
		payRecord.setEnterprise(enterprise);
		payRecord.setPayUser(user);
		payRecord.setPayDate(new Date());
		this.payRecordDao.saveEntity(payRecord);
		for(BSRecord t : bsRecordList){
			if(this.bsRecordService.getIsSelled(t.getBlessSeat().getBsId())){
				throw new AppRuntimeException("同一个福位同时只能被一个企业捐赠或租赁。");
			}
			t.setPayRecord(payRecord);
			this.bsRecordService.add(t);
		}
		for(TabletRecord t : tabletRecord){
			if(this.tabletRecordService.getIsSelled(t.getTablet().getTabletId())){
				throw new AppRuntimeException("同一个牌位同时只能被一个企业捐赠。");
			}
			t.setPayRecord(payRecord);
			this.tabletRecordService.add(t);
		}
		for(PayDetail t : payDetailList){
			t.setPayRecord(payRecord);
			this.payDetailService.add(t);
		}
		return null;
	}

}
