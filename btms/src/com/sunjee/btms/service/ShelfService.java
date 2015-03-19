package com.sunjee.btms.service;

import java.util.Map;

import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.exception.AppRuntimeException;

public interface ShelfService {
	
	DataGird<Shelf> getShelfGrid(Pager page,Map<String, Object> whereParams,Map<String, SortType> sortParams);
	void addShelf(Shelf shelf);
	void updateShelf(Shelf shelf);
}
