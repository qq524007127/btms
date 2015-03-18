package com.sunjee.component.dao;

import java.util.List;
import java.util.Map;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.component.bean.BaseBean;

public interface SupportDao<T extends BaseBean> extends java.io.Serializable {
	
	String getTableName();
	
	void updateEntiry(T t);
	void saveEntity(T t);

	/**
	 * 查询所有符合条件的实体
	 * 
	 * @param params
	 *            查询条件
	 * @return
	 */
	List<T> getEntitys(Map<String, Object> whereParams,Map<String, SortType> sortParams);

	DataGird<T> getDataGrid(Pager page, Map<String, Object> whereParams,Map<String, SortType> sortParams);
	
	int executeUpate(Map<String, Object> valueParams, Map<String, Object> whereParams);
	
	int executeUpate(String hql, Map<String, Object> whereParams);
}
