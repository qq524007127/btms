package com.sunjee.btms.service;

import java.util.Map;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public interface BlessSeatService {
	void addBlessSeat(BlessSeat bs);
	DataGird<BlessSeat> getBlessSeatGrid(Pager page, Map<String, Object> whereParams, Map<String,SortType> sortParams);
}
