package com.sunjee.btms.dao;

import java.util.Map;

import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public interface ShelfDao extends SupportDao<Shelf> {
	DataGrid<Shelf> getShelfGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams);
	
}
