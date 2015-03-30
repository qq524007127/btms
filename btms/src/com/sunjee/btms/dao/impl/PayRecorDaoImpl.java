package com.sunjee.btms.dao.impl;


import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.dao.PayRecordDao;

@Repository("payRecordDao")
public class PayRecorDaoImpl extends SupportDaoImpl<PayRecord> implements
		PayRecordDao {

	private static final long serialVersionUID = -7802060362212508447L;

	@Override
	public void saveOrUpdate(PayRecord payRecord) {
		getSession().saveOrUpdate(payRecord);
	}

}
