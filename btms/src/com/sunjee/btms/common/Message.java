package com.sunjee.btms.common;

import com.sunjee.btms.bean.BaseBean;

public class Message extends BaseBean {

	private static final long serialVersionUID = -9030257371895491980L;

	private boolean success = true;
	private String msg = "操作成功";

	public Message() {
		super();
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
