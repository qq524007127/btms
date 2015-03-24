package com.sunjee.btms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Area;
import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Shelf;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.ShelfDao;
import com.sunjee.btms.service.AreaService;
import com.sunjee.btms.service.BlessSeatService;
import com.sunjee.btms.service.ShelfService;

@Service("shelfService")
public class ShelfServiceImpl implements ShelfService {

	private ShelfDao shelfDao;

	private AreaService areaService;
	private BlessSeatService blessSeatService;

	public ShelfDao getShelfDao() {
		return shelfDao;
	}

	@Resource(name = "shelfDao")
	public void setShelfDao(ShelfDao shelfDao) {
		this.shelfDao = shelfDao;
	}

	public AreaService getAreaService() {
		return areaService;
	}

	@Resource(name = "areaService")
	public void setAreaService(AreaService areaService) {
		this.areaService = areaService;
	}

	public BlessSeatService getBlessSeatService() {
		return blessSeatService;
	}

	@Resource(name = "blessSeatService")
	public void setBlessSeatService(BlessSeatService blessSeatService) {
		this.blessSeatService = blessSeatService;
	}

	@Override
	public DataGrid<Shelf> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.shelfDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public Shelf add(Shelf shelf) {
		this.shelfDao.saveEntity(shelf);
		return shelf;
	}
	
	@Override
	public void update(Shelf shelf) {
		Shelf oldShelf = this.shelfDao.getEntityById(shelf.getShelfId());
		if (shelf.getShelfRow() < oldShelf.getShelfRow()) {
			throw new RuntimeException("行数不能小于当前的行数：" + oldShelf.getShelfRow());
		}
		if (shelf.getShelfColumn() < oldShelf.getShelfColumn()) {
			throw new RuntimeException("列数不能小于当前的行数："
					+ oldShelf.getShelfColumn());
		}
		shelf.setShelfArea(this.areaService.getById(shelf.getShelfArea().getAreaId()));
		shelf.createShelfCode();
		if (!shelf.getShelfCode().equals(oldShelf.getShelfCode())) {
			Map<String, Object> whereParams = new HashMap<String, Object>();
			whereParams.put("shelfCode", shelf.getShelfCode());
			List<Shelf> list = this.shelfDao
					.getEntitys(null, whereParams, null);
			if (list != null && list.size() > 0) {
				throw new RuntimeException("所在区域行、列已有福位架，请勿重复添加！");
			}
		}
		this.shelfDao.updateEntity(shelf);
		for (int i = oldShelf.getShelfRow(); i < shelf.getShelfRow(); i++) {
			for (int j = oldShelf.getShelfColumn(); j < shelf.getShelfColumn(); j++) {
				BlessSeat bs = new BlessSeat();
				bs.setShelfRow(i + 1);
				bs.setShelfColumn(j + 1);
				bs.setShelf(shelf);
				bs.createBsCode();
				this.blessSeatService.add(bs);
			}
		}
	}

	@Override
	public List<Area> getAreaList() {
		return this.areaService.getAllByParams(null,null,null);
	}

	@Override
	public List<Shelf> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.shelfDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public Shelf getById(String id) {
		return this.shelfDao.getEntityById(id);
	}

	@Override
	public void delete(Shelf t) {
		this.shelfDao.deletEntity(t);
	}

	@Override
	public void initShelf(Shelf shelf) {
		this.shelfDao.saveEntity(shelf);
		for (int i = 0; i < shelf.getShelfRow(); i++) {
			for (int j = 0; j < shelf.getShelfColumn(); j++) {
				BlessSeat bs = new BlessSeat();
				bs.setShelfRow(i + 1);
				bs.setShelfColumn(j + 1);
				bs.setShelf(shelf);
				bs.createBsCode();
				this.blessSeatService.add(bs);
			}
		}
	}

	@Override
	public void updateShelfPermit(String[] shelfIds, boolean b) {
		for(String shelfId : shelfIds){
			Map<String, Object> valueParams = new HashMap<>();
			valueParams.put("permit", b);
			
			Map<String, Object> whereParams = new HashMap<>();
			whereParams.put("shelfId", shelfId);
			this.shelfDao.updateEntity(valueParams, whereParams);
			
			this.blessSeatService.updatePermitByShelfId(shelfId,b);
		}
	}

}
