package com.sunjee.btms.dao;

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
	
	T getEntityById(java.io.Serializable id);

	/**
	 * 自动拼接HQL语句并查询
	 * 
	 * @param params
	 *            查询条件
	 * @return
	 */
	List<T> getEntitys(Pager page,Map<String, Object> whereParams,Map<String, SortType> sortParams);
	
	@Deprecated
	List<T> getEntitys(Pager page,String hql,Map<String, Object> whereParams,Map<String, SortType> sortParams);
	
	List<T> getEntitysByHql(Pager page,String hql,Map<String, Object> whereParams);
	
	DataGird<T> getDataGrid(Pager page, Map<String, Object> whereParams,Map<String, SortType> sortParams);
	DataGird<T> getDataGridByHql(Pager page, String hql, Map<String, Object> whereParams);
	
	int executeUpate(Map<String, Object> valueParams, Map<String, Object> whereParams);
	
	int executeUpate(String hql, Map<String, Object> whereParams);
}
