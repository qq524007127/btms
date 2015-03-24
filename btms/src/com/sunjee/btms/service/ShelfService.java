package com.sunjee.btms.service;

import java.util.List;

import com.sunjee.btms.bean.Area;
import com.sunjee.btms.bean.Shelf;

public interface ShelfService extends SupportService<Shelf>{
	
	List<Area> getAreaList();
	/**
	 * 初始化福位架，初始化是添加福位架同时添加此福位架的福位
	 * @param shelf
	 */
	void initShelf(Shelf shelf);
	
	void updateShelfPermit(String[] split, boolean b);
}
