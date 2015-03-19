package com.sunjee.btms.dao;

import java.util.Map;

import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public interface ShelfDao extends SupportDao<Shelf> {
	DataGird<Shelf> getShelfGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams);
	
}
