package com.sunjee.component.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.component.bean.BaseBean;
import com.sunjee.component.dao.SupportDao;
import com.sunjee.util.GenericTypeUtil;

public class SupportDaoImpl<T extends BaseBean> implements SupportDao<T>{

	private static final long serialVersionUID = -1856809819767706244L;

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}


	/**
	 * 获取满足查询条件的数据总条数
	 * 
	 * @param hql
	 * @param params
	 * @return
	 */
	@Deprecated
	public float getRecordTotal(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		initQueryParams(query, params);
		return Float.valueOf(query.uniqueResult().toString());
	}
	
	/**
	 * 查询满足条件的数据总条数
	 * @param whereParams
	 * @return
	 */
	public float getRecordTotal(Map<String,Object> whereParams){
		StringBuffer hql = new StringBuffer("select count(*) ").append(createQueryHql(whereParams));
		Query query = createQuery(hql.toString(), whereParams);
		return Float.valueOf(query.uniqueResult().toString());
	}


	@SuppressWarnings("unchecked")
	@Override
	public DataGird<T> getDataGrid(Pager page,Map<String,Object> whereParams,Map<String, SortType> sortParams) {
		DataGird<T> dg = new DataGird<>();
		
		dg.setTotal(getRecordTotal(null));

		String hql = createQueryHql(whereParams, sortParams);
		Query query = createQuery(hql, null);
		query.setFirstResult(page.getFirstIndex());
		query.setMaxResults(page.getRows());
		dg.setRows(query.list());
		return dg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getEntitys(Map<String, Object> whereParmas,Map<String,SortType> sortParams) {
		return createQuery(whereParmas,sortParams).list();
	}
	
	/**
	 * 组装hql语句
	 * @param whereParams	{"id":"1001","name":"testName"}
	 * @return	from Entiry where 1=1 and id=:id and name=:name
	 */
	public String createQueryHql(Map<String, Object> whereParams){
		return createQueryHql(whereParams,null);
	}
	
	/**
	 * 组装hql语句
	 * @param whereParams	{"id":"1001","name":"testName"}
	 * @param sortParams	排序的字段（{"id":"asc","name":"desc"}）
	 * @return	from Entiry where 1=1 and id=:id and name=:name order by id asc,name desc
	 */
	public String createQueryHql(Map<String, Object> whereParams,Map<String, SortType> sortParams) {
		StringBuffer hql = new StringBuffer("from ");
		hql.append(getTableName());
		hql.append(" where 1=1");
		if (whereParams != null && whereParams.size() > 0) {
			for (String key : whereParams.keySet()) {
				if(StringUtils.isEmpty(key)){
					continue;
				}
				if(whereParams.get(key) == null){
					hql.append(" and " + key.trim() + " is null");
				}
				else{
					hql.append(" and " + key.trim() + "=:" + key.trim());
				}
			}
		}
		
		if (sortParams != null && sortParams.size() > 0) {
			hql.append(" order by ");
			for (String key : sortParams.keySet()) {
				if(StringUtils.isEmpty(key)){
					continue;
				}
				SortType sortType = sortParams.get(key);
				if(sortType == null){
					sortType = SortType.asc;
				}
				hql.append(key.trim()).append(" ").append(sortType).append(",");
			}
		}
		if(hql.toString().endsWith(",")){
			return hql.subSequence(0, hql.length()-1).toString();
		}
		System.out.println(hql);
		return hql.toString();
	}
	
	/**
	 * 创建一个查询对象
	 * @param hql
	 * @param whereParams
	 * @return
	 */
	public Query createQuery(Map<String, Object> whereParams,Map<String,SortType> sortParams) {
		String hql = createQueryHql(whereParams,sortParams);
		return createQuery(hql,whereParams);
	}
	
	/**
	 * 创建一个查询对象
	 * @param hql
	 * @param params
	 * @return
	 */
	public Query createQuery(String hql, Map<String, Object> whereParams) {
		Query query = getSession().createQuery(hql);
		initQueryParams(query, whereParams);
		return query;
	}
	
	/**
	 * 初始化查询参数
	 * 
	 * @param query
	 * @param whereParams
	 */
	public void initQueryParams(Query query, Map<String, Object> whereParams) {
		if (whereParams == null)
			return;
		for (String key : whereParams.keySet()) {
			if(StringUtils.isEmpty(key)){
				continue;
			}
			if(whereParams.get(key) == null){
				continue;
			}
			query.setParameter(key, whereParams.get(key));
		}
	}
	
	
	@Override
	public final String getTableName() {
		return GenericTypeUtil.getGenerParamType(this.getClass()).getSimpleName();
	}

	@Override
	public int executeUpate(Map<String, Object> valueParams,
			Map<String, Object> whereParams) {
		return 0;
	}

	@Override
	public int executeUpate(String hql, Map<String, Object> whereParams) {
		return createQuery(hql, whereParams).executeUpdate();
	}

	@Override
	public void updateEntiry(T t) {
		getSession().update(t);
	}

	@Override
	public void saveEntity(T t) {
		getSession().save(t);
	}
}
