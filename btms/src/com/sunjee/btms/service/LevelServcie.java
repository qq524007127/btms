package com.sunjee.btms.service;

import java.util.List;
import java.util.Map;

import com.sunjee.btms.bean.Level;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public interface LevelServcie {
	DataGrid<Level> getLevelGrid(Pager page, Map<String, Object> whereParams, Map<String, SortType> sortParams);

	void addLevel(Level level);

	void updateLevel(Level level);

	List<Level> getAllLevels();
}
