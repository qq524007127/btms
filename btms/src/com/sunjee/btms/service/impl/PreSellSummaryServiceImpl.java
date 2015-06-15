package com.sunjee.btms.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.PreSell;
import com.sunjee.btms.bean.PreSellSummary;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.PreSellSummaryDao;
import com.sunjee.btms.service.PreSellService;
import com.sunjee.btms.service.PreSellSummaryService;
import com.sunjee.util.DateUtil;
import com.sunjee.util.HqlNoEquals;

@Service("preSellSummaryService")
public class PreSellSummaryServiceImpl implements PreSellSummaryService {

	private PreSellSummaryDao preSellSummaryDao;
	private PreSellService preSellService;

	public PreSellSummaryDao getPreSellSummaryDao() {
		return preSellSummaryDao;
	}

	@Resource(name = "preSellSummaryDao")
	public void setPreSellSummaryDao(PreSellSummaryDao preSellSummaryDao) {
		this.preSellSummaryDao = preSellSummaryDao;
	}

	public PreSellService getPreSellService() {
		return preSellService;
	}

	@Resource(name="preSellService")
	public void setPreSellService(PreSellService preSellService) {
		this.preSellService = preSellService;
	}

	@Override
	public DataGrid<PreSellSummary> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		this.addSummaryOfDay(new Date(), true);
		return this.preSellSummaryDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public PreSellSummary add(PreSellSummary t) {
		return this.preSellSummaryDao.saveEntity(t);
	}

	@Override
	public void update(PreSellSummary t) {
		this.preSellSummaryDao.updateEntity(t);
	}

	@Override
	public List<PreSellSummary> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.preSellSummaryDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public PreSellSummary getById(String id) {
		return this.preSellSummaryDao.getEntityById(id);
	}

	@Override
	public void delete(PreSellSummary t) {
		this.preSellSummaryDao.deletEntity(t);
	}

	@Override
	public void initSumOfBefore() {
		String selectors[] = new String[1];
		selectors[0] = "min(createDate)";
		List<Object> result = this.preSellService.getParam("min(createDate)",null, null, null);
		if (result == null || result.size() < 1) {
			return;
		}
		Date minDate = (Date) result.get(0);
		while(minDate.before(new Date())){
			addSummaryOfDay(minDate, false);
			minDate = DateUtils.addDays(minDate, 1);
		}
	}

	@Override
	public void addSummaryOfDay(Date day, boolean over) {
		if(over){
			PreSellSummary pSum = getSummaryByDay(day);
			if(pSum !=null && !StringUtils.isEmpty(pSum.getSumId())){
				this.preSellSummaryDao.deletEntity(pSum);
			}
		}
		PreSellSummary preSellSummary = getSummaryByDay(day);
		if(preSellSummary == null){
			return;
		}
		preSellSummary.setCreateDate(day);
		this.preSellSummaryDao.saveEntity(preSellSummary);
	}

	private PreSellSummary getSummaryByDay(Date day) {
		PreSellSummary psSum = new PreSellSummary();
		
		Date starteDateTime = DateUtil.getStartTimeOfDay(day);
		Date endDateTime = DateUtil.getEndTimeOfDay(day);
		Map<String, Object> whereParams = new HashMap<>();
		whereParams.put("createDate", new HqlNoEquals(starteDateTime,
				endDateTime));
		List<PreSellSummary> result = this.preSellSummaryDao.getEntitys(null,
				whereParams, null);
		if (result.size() > 0) {
			return result.get(0);
		}

		whereParams.clear();
		whereParams.put("createDate", new HqlNoEquals(starteDateTime, endDateTime));
		whereParams.put("permit", true);
		List<PreSell> psList = this.preSellService.getAllByParams(null, whereParams, null);
		for (PreSell preSell : psList) {
			psSum.setPsCount(psSum.getPsCount() + preSell.getPsCount());
			psSum.setPsTotal(psSum.getPsTotal() + preSell.getTotalPrice());
			if(preSell.isCash()){
				psSum.setCashCount(psSum.getCashCount() + preSell.getPsCount());
				psSum.setPsCharge(psSum.getPsCharge() + preSell.getTotalPrice());
				psSum.setShouldCharge(psSum.getShouldCharge() + preSell.getShouldCharge());
				psSum.setRealCharge(psSum.getRealCharge() + preSell.getRealCharge());
			}
		}
		psSum.setTotal(psSum.getPsTotal() + psSum.getRealCharge());
		return psSum;
	}
}
