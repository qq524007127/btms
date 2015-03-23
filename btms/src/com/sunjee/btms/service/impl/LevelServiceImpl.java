package com.sunjee.btms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

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
	public DataGrid<Level> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.levelDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public Level add(Level level) {
		return this.levelDao.saveEntity(level);
	}

	@Override
	public void update(Level level) {
		this.levelDao.updateEntity(level);
	}


	@Override
	public List<Level> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.levelDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public Level getById(String id) {
		return this.levelDao.getEntityById(id);
	}

	@Override
	public void delete(Level lev) {
		this.levelDao.deletEntity(lev);
	}

}
