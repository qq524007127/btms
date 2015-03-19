package com.sunjee.btms.service;

import java.util.Map;

import com.sunjee.btms.bean.Area;
import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.exception.AppRuntimeException;

public interface ShelfService {
	
	DataGrid<Shelf> getShelfGrid(Pager page,Map<String, Object> whereParams,Map<String, SortType> sortParams);
	void addShelf(Shelf shelf);
	void updateShelf(Shelf shelf);
	void initShelf(Area area);
}
