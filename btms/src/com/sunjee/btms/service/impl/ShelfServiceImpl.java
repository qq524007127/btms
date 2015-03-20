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
import com.sunjee.btms.dao.BlessSeatDao;
import com.sunjee.btms.dao.ShelfDao;
import com.sunjee.btms.service.ShelfService;

@Service("shelfService")
public class ShelfServiceImpl implements ShelfService {

	private ShelfDao shelfDao;
	private BlessSeatDao blessSeatDao;

	public ShelfDao getShelfDao() {
		return shelfDao;
	}

	@Resource(name = "shelfDao")
	public void setShelfDao(ShelfDao shelfDao) {
		this.shelfDao = shelfDao;
	}

	public BlessSeatDao getBlessSeatDao() {
		return blessSeatDao;
	}

	@Resource(name = "blessSeatDao")
	public void setBlessSeatDao(BlessSeatDao blessSeatDao) {
		this.blessSeatDao = blessSeatDao;
	}

	@Override
	public DataGrid<Shelf> getShelfGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.shelfDao.getShelfGrid(page, whereParams, sortParams);
	}

	@Override
	public void addShelf(Shelf shelf) {
		this.shelfDao.saveEntity(shelf);
		for (int i = 0; i < shelf.getShelfRow(); i++) {
			for (int j = 0; j < shelf.getShelfColumn(); j++) {
				BlessSeat bs = new BlessSeat();
				bs.setShelfRow(i + 1);
				bs.setShelfColumn(j + 1);
				bs.setShelf(shelf);
				bs.createBsCode();
				this.blessSeatDao.saveEntity(bs);
			}
		}
	}

	@Override
	public void updateShelf(Shelf shelf){
		Shelf oldShelf = this.shelfDao.getEntityById(shelf.getShelfId());
		if(shelf.getShelfRow() < oldShelf.getShelfRow()){
			throw new RuntimeException("行数不能小于当前的行数：" + oldShelf.getShelfRow());
		}
		if(shelf.getShelfColumn() < oldShelf.getShelfColumn()){
			throw new RuntimeException("列数不能小于当前的行数：" + oldShelf.getShelfColumn());
		}
		shelf.createShelfCode();
		if(!shelf.getShelfCode().equals(oldShelf.getShelfCode())){
			Map<String, Object> whereParams = new HashMap<String, Object>();
			whereParams.put("shelfCode", shelf.getShelfCode());
			List<Shelf> list = this.shelfDao.getEntitys(null, whereParams, null);
			if(list != null && list.size() > 0){
				throw new RuntimeException("所在区域行、列已有福位架，请勿重复添加！");
			} 
		}
		this.shelfDao.updateEntiry(shelf);
		for(int i = oldShelf.getShelfRow(); i < shelf.getShelfRow(); i++){
			for (int j = oldShelf.getShelfColumn(); j < shelf.getShelfColumn(); j++) {
				BlessSeat bs = new BlessSeat();
				bs.setShelfRow(i + 1);
				bs.setShelfColumn(j + 1);
				bs.setShelf(shelf);
				bs.createBsCode();
				this.blessSeatDao.saveEntity(bs);
			}
		}
	}

	@Override
	public void initShelf(Area area) {
		for(int i = 0; i < area.getAreaRow(); i ++){
			for(int j = 0; j < area.getAreaColumn(); j ++){
				Shelf shelf = new Shelf();
				shelf.setShelfRow(area.getAreaRow());
				shelf.setShelfColumn(area.getAreaColumn());
				shelf.setPostionRow(i + 1);
				shelf.setPostionColumn(j + 1);
				shelf.setShelfArea(area.getAreaName());
				shelf.createShelfCode();
				addShelf(shelf);
			}
		}
	}

	@Override
	public List<Area> getAreaList() {
		return this.shelfDao.getAreaList();
	}

}
