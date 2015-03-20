package com.sunjee.btms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Area;
import com.sunjee.btms.bean.BlessSeat;
import com.sunjee.btms.bean.Level;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.BlessSeatDao;
import com.sunjee.btms.service.BlessSeatService;

@Service("blessSeatService")
public class BlessSeatServiceImpl implements BlessSeatService {
	
	private BlessSeatDao blessSeatDao;

	public BlessSeatDao getBlessSeatDao() {
		return blessSeatDao;
	}
	@Resource(name="blessSeatDao")
	public void setBlessSeatDao(BlessSeatDao blessSeatDao) {
		this.blessSeatDao = blessSeatDao;
	}

	@Override
	public void addBlessSeat(BlessSeat bs) {
		this.blessSeatDao.saveEntity(bs);
	}
	
	@Override
	public DataGrid<BlessSeat> getBlessSeatGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.blessSeatDao.getDataGrid(page, whereParams, sortParams);
	}
	
	@Override
	public int updateBlessSeatLeve(String bsIds[],Level level) {
		Map<String, Object> values = new HashMap<>();
		values.put("lev", level);
		
		Map<String,Object> params = new HashMap<>();
		for(String id : bsIds){
			params.put("bsId", id);
			this.blessSeatDao.updateEntity(values, params);
		}
		return 0;
	}

}
