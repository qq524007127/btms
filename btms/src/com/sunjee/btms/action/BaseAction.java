package com.sunjee.btms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Message;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 4964579154676466502L;

	private Message message;
	private DataGird dataGrid;
	protected int page;
	protected int rows;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public DataGird getDataGrid() {
		return dataGrid;
	}

	public void setDataGrid(DataGird dataGrid) {
		this.dataGrid = dataGrid;
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

}
