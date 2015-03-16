package com.sunjee.component.dao.impl;

import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sunjee.component.bean.BaseBean;

public class SupportDaoImpl<T> extends BaseBean {

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
	
	public Query createQuery(String hql,Map<String, Object> params){
		Query query = getSession().createQuery(hql);
		initQueryParams(query, params);
		return query;
	}
	
	/**
	 * 获取满足查询条件的数据总条数
	 * @param hql
	 * @param params
	 * @return
	 */
	public float getCount(String hql, Map<String, Object> params) {
		Query query = getSession().createQuery(hql);
		initQueryParams(query, params);
		return Float.valueOf(query.uniqueResult().toString());
	}
	
	/**
	 * 初始化查询参数
	 * @param query
	 * @param params
	 */
	public void initQueryParams(Query query, Map<String, Object> params) {
		if (params == null)
			return;
		for (String key : params.keySet()) {
			query.setParameter(key, params.get(key));
		}
	}
}
