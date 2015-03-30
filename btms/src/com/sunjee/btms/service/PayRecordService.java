package com.sunjee.btms.service;

import java.util.List;

import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.bean.MemberCard;
import com.sunjee.btms.bean.PayDetail;
import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.bean.TabletRecord;
import com.sunjee.btms.common.DonationType;
import com.sunjee.component.bean.User;

public interface PayRecordService extends SupportService<PayRecord> {
	
	public MemberCard addPayRecord(List<BSRecord> bsRecordList,List<TabletRecord> tabletRecord,List<PayDetail> payDetailList,Member member,User user);
	
	public MemberCard addPayRecord(List<BSRecord> bsRecordList,List<TabletRecord> tabletRecord,List<PayDetail> payDetailList,Enterprise enterprise,User user);

	public void addBSRToShopBusOnMember(String[] blessSeatIds, Member member, User user, DonationType buyType);

	public List<BSRecord> getUnPayedRSRecodes(String memberId);

}
