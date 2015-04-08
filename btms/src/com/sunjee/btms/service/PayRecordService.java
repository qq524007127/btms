package com.sunjee.btms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.bean.PayDetail;
import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.bean.TabletRecord;
import com.sunjee.btms.common.DonationType;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.component.bean.User;

public interface PayRecordService extends SupportService<PayRecord> {
	
	public PayRecord addPayRecord(List<BSRecord> bsRecordList,List<TabletRecord> tabletRecord,List<PayDetail> payDetailList,Member member,User user);
	
	public PayRecord addPayRecord(List<BSRecord> bsRecordList,List<TabletRecord> tabletRecord,List<PayDetail> payDetailList,Enterprise enterprise,User user);

	public void addBSRToShopBusOnMember(String[] blessSeatIds, Member member, User user, DonationType buyType);
	
	public void addBSRToShopBusOnEnterprise(String[] blessSeatIds, Enterprise enterprise, User user, DonationType buyType);

	public List<BSRecord> getUnPayedRSRecodes(String memberId);
	/**
	 * 得到收费记录时间最早的记录对应的时间
	 * @return
	 */
	public Date getMinDate();

	public List<PayRecord> getAllByDate(Pager pager, Date start, Date end, Map<String, SortType> sorts);

}
