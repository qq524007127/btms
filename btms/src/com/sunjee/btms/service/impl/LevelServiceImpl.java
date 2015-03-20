package com.sunjee.btms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Level;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.LevelDao;
import com.sunjee.btms.service.LevelServcie;

@Service("levelService")
public class LevelServiceImpl implements LevelServcie {
	
	private LevelDao levelDao;
	

	public LevelDao getLevelDao() {
		return levelDao;
	}

	@Resource(name="levelDao")
	public void setLevelDao(LevelDao levelDao) {
		this.levelDao = levelDao;
	}



	@Override
	public DataGrid<Level> getLevelGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.levelDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public void addLevel(Level level) {
		this.levelDao.saveEntity(level);
	}

	@Override
	public void updateLevel(Level level) {
		this.levelDao.updateEntiry(level);
	}

	@Override
	public List<Level> getAllLevels() {
		Map<String, SortType> sorts = new HashMap<String, SortType>();
		sorts.put("levPrice", SortType.asc);
		return this.levelDao.getEntitys(null, null, sorts);
	}

}
