package com.sunjee.btms.dao;

import java.util.List;

import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.bean.Member;

public interface BSRecordDao extends SupportDao<BSRecord> {

	List<BSRecord> getUnPayedRSRecodes(String memberId);

	int deleteUnPayedByMember(String id, Member member);

	void saveOrUpdate(BSRecord t);

	int deleteUnPayedByEnterprise(String id, Enterprise enterprise);

}
