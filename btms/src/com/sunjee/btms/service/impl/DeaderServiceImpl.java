package com.sunjee.btms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Deader;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.DeaderDao;
import com.sunjee.btms.service.DeaderService;

@Service("deaderService")
public class DeaderServiceImpl implements DeaderService {

	private DeaderDao deaderDao;

	public DeaderDao getDeaderDao() {
		return deaderDao;
	}

	@Resource(name = "deaderDao")
	public void setDeaderDao(DeaderDao deaderDao) {
		this.deaderDao = deaderDao;
	}

	@Override
	public DataGrid<Deader> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.deaderDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public Deader add(Deader t) {
		return this.deaderDao.saveEntity(t);
	}

	@Override
	public void update(Deader t) {
		this.deaderDao.updateEntity(t);
	}

	@Override
	public List<Deader> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.deaderDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public Deader getById(String id) {
		return this.deaderDao.getEntityById(id);
	}

	@Override
	public void delete(Deader t) {
		this.deaderDao.deletEntity(t);
	}

}
