package com.sunjee.btms.dao.impl;

import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.BSRecord;
import com.sunjee.btms.dao.BSRecordDao;

@Repository("bsRecordDao")
public class BSRecordDaoImpl extends SupportDaoImpl<BSRecord> implements BSRecordDao {

	private static final long serialVersionUID = -2487281350094630378L;

}
