package com.sunjee.component.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunjee.btms.common.SortType;
import com.sunjee.component.dao.SupportDao;
import com.sunjee.util.GenericTypeUtil;

public class SupportDaoImpl<T> implements SupportDao<T>{

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

	public Query createQuery(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		initQueryParams(query, params);
		return query;
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
			query.setParameter(key, whereParams.get(key));
		}
	}

	@Override
	public final String getTableName() {
		return GenericTypeUtil.getGenerParamType(this.getClass()).getSimpleName();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAllEntity() {
		StringBuffer hql = new StringBuffer("from ");
		hql.append(getTableName());
		return createQuery(hql.toString(), null).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getEntiresByParams(Map<String, Object> params) {
		String hql = createQueryHql(params).toString();
		return createQuery(hql, params).list();
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
				hql.append(" and " + key.trim() + "=:" + key.trim());
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
		return hql.toString();
	}
}
