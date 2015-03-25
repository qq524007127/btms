package com.sunjee.btms.service;

import java.util.Map;

import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Level;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public interface BlessSeatService extends SupportService<BlessSeat> {
	void addBlessSeat(BlessSeat bs);

	int updateBlessSeatLeve(String bsIds[], Level level);

	void updatePermitByShelfId(String shelfId, boolean b);

	DataGrid<BlessSeat> getEnableDataGrid(Pager pager,
			Map<String, Object> whereParams, Map<String, SortType> sortParams);
}
