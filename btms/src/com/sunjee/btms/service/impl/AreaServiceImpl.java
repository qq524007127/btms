package com.sunjee.btms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Area;
import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.AreaDao;
import com.sunjee.btms.service.AreaService;
import com.sunjee.btms.service.ShelfService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	private AreaDao areaDao;

	private ShelfService shelfService;

	public AreaDao getAreaDao() {
		return areaDao;
	}

	@Resource(name = "areaDao")
	public void setAreaDao(AreaDao areaDao) {
		this.areaDao = areaDao;
	}

	public ShelfService getShelfService() {
		return shelfService;
	}

	@Resource(name = "shelfService")
	public void setShelfService(ShelfService shelfService) {
		this.shelfService = shelfService;
	}

	@Override
	public DataGrid<Area> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return areaDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public Area add(Area area) {
		return this.areaDao.saveEntity(area);
	}

	@Override
	public void initArea(Area area) {
		this.areaDao.saveEntity(area);
		for (int i = 0; i < area.getAreaRow(); i++) {
			for (int j = 0; j < area.getAreaColumn(); j++) {
				Shelf shelf = new Shelf();
				shelf.setShelfRow(area.getShelfRow());
				shelf.setShelfColumn(area.getShelfColumn());
				shelf.setPostionRow(i + 1);
				shelf.setPostionColumn(j + 1);
				shelf.setShelfArea(area);
				shelf.createShelfCode();
				this.shelfService.initShelf(shelf);
			}
		}
	}

	@Override
	public void update(Area area) {
		this.areaDao.updateEntity(area);
	}

	@Override
	public List<Area> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.areaDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public Area getById(String id) {
		return this.areaDao.getEntityById(id);
	}

	@Override
	public void delete(Area area) {
		this.areaDao.deletEntity(area);
	}

}
