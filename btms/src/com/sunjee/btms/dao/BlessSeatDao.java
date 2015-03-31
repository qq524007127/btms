package com.sunjee.btms.dao;

import java.util.Map;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.bean.Member;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public interface BlessSeatDao extends SupportDao<BlessSeat> {

	DataGrid<BlessSeat> getEnableDataGrid(Pager pager,
			Map<String, Object> whereParams, Map<String, SortType> sortParams);

	DataGrid<BlessSeat> getSaledGrid(Member member, Pager pager,
			String searchKey, Map<String, SortType> sortParams);

	DataGrid<BlessSeat> getSaledGrid(Enterprise enterprise, Pager pager,
			String searchKey, Map<String, SortType> sortParams);


}
