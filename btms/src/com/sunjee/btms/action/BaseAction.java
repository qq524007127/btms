package com.sunjee.btms.action;

import com.opensymphony.xwork2.ActionSupport;
import com.sunjee.btms.common.DataGird;
import com.sunjee.btms.common.Message;

public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 4964579154676466502L;

	private Message message;
	protected int page;
	protected int rows;

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
	
	protected void doSuccess(){
		setMessage(new Message());
	}

}
