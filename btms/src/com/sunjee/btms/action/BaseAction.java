package com.sunjee.btms.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.sunjee.btms.common.DataGrid;
import com.sunjee.btms.common.Message;
import com.sunjee.btms.common.Pager;
import com.sunjee.btms.common.SortType;
import com.sunjee.util.HqlLikeType;
import com.sunjee.util.LikeType;

public class BaseAction<T> extends ActionSupport {

	private static final long serialVersionUID = 4964579154676466502L;

	private DataGrid<T> dataGrid;

	private Message message;
	protected int page;
	protected int rows;
	protected String sort;
	protected String order;
	protected String searchKey;

	public DataGrid<T> getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(DataGrid<T> dataGrid) {
		this.dataGrid = dataGrid;
	}

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

	protected Map<String, SortType> getSortParams() {
		Map<String, SortType> sortParams = new HashMap<String, SortType>();
		if (!StringUtils.isEmpty(sort)) {
			SortType sortType = SortType.asc;
			if (!StringUtils.isEmpty(order)
					&& order.trim().toLowerCase()
							.equals(SortType.desc.toString())) {
				sortType = SortType.desc;
			}
			sortParams.put(sort, sortType);
		}
		return sortParams;
	}
	
	protected Map<String, Object> getWhereParams(){
		return getWhereParams(null);
	}
	
	protected Map<String, Object> getWhereParams(String key){
		return getWhereParams(key, LikeType.allLike);
	}
	
	protected Map<String, Object> getWhereParams(String key,LikeType likeType){
		Map<String, Object> whereParams = new HashMap<>();
		if(!StringUtils.isEmpty(searchKey) && !StringUtils.isEmpty(key)){
			if(likeType == null){
				likeType = LikeType.allLike;
			}
			whereParams.put(key, new HqlLikeType(searchKey.trim(), likeType));
		}
		return whereParams;
	}

	protected Pager getPager() {
		return new Pager(page, rows);
	}
}
