package com.sunjee.btms.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.sunjee.btms.common.Message;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 4964579154676466502L;

	private Message message;
	protected int page;
	protected int rows;
	protected String sort;
	protected String order;
	protected String searchKey;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	protected String success() {
		setMessage(new Message());
		return SUCCESS;
	}
	
	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	protected Map<String, SortType> getSortParams(){
		Map<String, SortType> sortParams = new HashMap<String, SortType>();
		if(!StringUtils.isEmpty(sort)){
			SortType sortType = SortType.asc;
			if(!StringUtils.isEmpty(order) && order.trim().toLowerCase().equals(SortType.desc.toString())){
				sortType = SortType.desc;
			}
			sortParams.put(sort, sortType);
		}
		return sortParams;
	}
	
	protected Pager getPager(){
		return new Pager(page, rows);
	}
}
