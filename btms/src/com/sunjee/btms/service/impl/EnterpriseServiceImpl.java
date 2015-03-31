package com.sunjee.btms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sunjee.btms.bean.Enterprise;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.EnterpriseDao;
import com.sunjee.btms.service.EnterpriseService;

@Service("enterpriseService")
public class EnterpriseServiceImpl implements EnterpriseService {
	
	private EnterpriseDao enterpriseDao;
	

	public EnterpriseDao getEnterpriseDao() {
		return enterpriseDao;
	}
	
	@Resource(name="enterpriseDao")
	public void setEnterpriseDao(EnterpriseDao enterpriseDao) {
		this.enterpriseDao = enterpriseDao;
	}

	@Override
	public DataGrid<Enterprise> getDataGrid(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.enterpriseDao.getDataGrid(page, whereParams, sortParams);
	}

	@Override
	public Enterprise add(Enterprise t) {
		return this.enterpriseDao.saveEntity(t);
	}

	@Override
	public void update(Enterprise t) {
		this.enterpriseDao.updateEntity(t);
	}

	@Override
	public List<Enterprise> getAllByParams(Pager page,
			Map<String, Object> whereParams, Map<String, SortType> sortParams) {
		return this.enterpriseDao.getEntitys(page, whereParams, sortParams);
	}

	@Override
	public Enterprise getById(String id) {
		return this.enterpriseDao.getEntityById(id);
	}

	@Override
	public void delete(Enterprise t) {
		this.enterpriseDao.deletEntity(t);
	}

}
