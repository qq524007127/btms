package com.sunjee.btms.common;

import java.util.List;

import com.sunjee.btms.bean.BaseBean;

public class DataGird<T> extends BaseBean {

	private static final long serialVersionUID = -4713422924951840211L;

	private float total;
	private List<T> rows;

	public DataGird() {
		super();
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
