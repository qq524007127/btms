package com.sunjee.btms.dao.impl;

import org.springframework.stereotype.Repository;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.dao.BlessSeatDao;

@Repository("blessSeatDao")
public class BlessSeatDaoImpl extends SupportDaoImpl<BlessSeat> implements
		BlessSeatDao {

	private static final long serialVersionUID = 1211403946136687061L;

}
