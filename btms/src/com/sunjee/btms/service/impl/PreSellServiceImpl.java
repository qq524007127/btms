package com.sunjee.btms.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Member;
import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.bean.PreSell;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.PreSellDao;
import com.sunjee.btms.service.PayRecordService;
import com.sunjee.btms.service.PreSellService;
import com.sunjee.component.bean.User;
import com.sunjee.util.CommonUtil;

@Service("preSellService")
public class PreSellServiceImpl implements PreSellService {

	private PreSellDao preSellDao;
	private PayRecordService payRecordService;

	public PreSellDao getPreSellDao() {
		return preSellDao;
	}

	@Resource(name = "preSellDao")
	public void setPreSellDao(PreSellDao preSellDao) {
		this.preSellDao = preSellDao;
	}

	public PayRecordService getPayRecordService() {
		return payRecordService;
	}

	@Resource(name = "payRecordService")
	public void setPayRecordService(PayRecordService payRecordService) {
		this.payRecordService = payRecordService;
	}

	@Override
	public DataGrid<PreSell> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.preSellDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public PreSell add(PreSell t) {
		t.setCash(false);
		t.setOrderCode(CommonUtil.getUniqueCode());
		t.setPermit(true);
		this.preSellDao.saveEntity(t);
		return t;
	}

	@Override
	public void update(PreSell t) {

	}

	@Override
	public List<PreSell> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return null;
	}

	@Override
	public PreSell getById(String id) {
		return null;
	}

	@Override
	public void delete(PreSell t) {
		this.preSellDao.deletEntity(t);
	}

	@Override
	public PreSell addByMember(PreSell preSell, String memberId, User user) {
		PayRecord pr = new PayRecord();
		pr.setMem(new Member(memberId));
		pr.setPayDate(new Date());
		pr.setPayUser(user);
		pr.setTotalPrice(preSell.getTotalPrice());
		this.payRecordService.add(pr);
		
		preSell.setpRecord(pr);
		add(preSell);
		return preSell;
	}

	@Override
	public PreSell addByEnterprise(PreSell preSell, String enterpriseId,
			User user) {
		PayRecord pr = new PayRecord();
		pr.setMem(new Member(enterpriseId));
		pr.setPayDate(new Date());
		pr.setPayUser(user);
		pr.setTotalPrice(preSell.getTotalPrice());
		this.payRecordService.add(pr);
		
		preSell.setpRecord(pr);
		add(preSell);
		return preSell;
	}

	@Override
	public void updatePermit(String[] ids, boolean permit) {
		if(ids == null){
			return;
		}
		Map<String, Object> values = new HashMap<String, Object>();
		values.put("permit", permit);
		Map<String, Object> whereParams = new HashMap<>();
		for(String id : ids){
			whereParams.put("psId", id);
			this.preSellDao.executeUpate(values, whereParams);
		}
	}

	@Override
	public void deleteByIds(String[] ids) {
		if(ids == null){
			return;
		}
		for(String id : ids){
			PreSell ps = this.preSellDao.getEntityById(id);
			if(!ps.isCash()){
				delete(ps);
				this.payRecordService.delete(ps.getpRecord());
			}
		}
	}

}
