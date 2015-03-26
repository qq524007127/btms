package com.sunjee.btms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Tablet;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.TabletDao;
import com.sunjee.btms.service.TabletService;

@Service("tabletService")
public class TabletServiceImpl implements TabletService {

	private TabletDao tabletDao;

	public TabletDao getTabletDao() {
		return tabletDao;
	}

	@Resource(name = "tabletDao")
	public void setTabletDao(TabletDao tabletDao) {
		this.tabletDao = tabletDao;
	}

	@Override
	public DataGrid<Tablet> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.tabletDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public Tablet add(Tablet t) {
		return this.tabletDao.saveEntity(t);
	}

	@Override
	public void update(Tablet t) {
		this.tabletDao.updateEntity(t);
	}

	@Override
	public List<Tablet> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.tabletDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public Tablet getById(String id) {
		return this.tabletDao.getEntityById(id);
	}

	@Override
	public void delete(Tablet t) {
		this.tabletDao.deletEntity(t);
	}

	@Override
	public DataGrid<Tablet> getEnableDataGrid(Pager pager,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.tabletDao.getDataEnableGrid(pager, whereParams, sortParams);
	}

}
