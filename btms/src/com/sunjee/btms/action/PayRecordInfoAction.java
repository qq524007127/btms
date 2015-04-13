package com.sunjee.btms.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.PayRecord;
import com.sunjee.btms.service.PayRecordService;

@Controller("payRecordInfoAction")
@Scope("prototype")
public class PayRecordInfoAction extends BaseAction<PayRecord> implements
		ModelDriven<PayRecord> {

	private static final long serialVersionUID = -2508101366318059275L;

	private PayRecordService payRecordService;

	private PayRecord payRecord;

	public PayRecordService getPayRecordService() {
		return payRecordService;
	}

	@Resource(name = "payRecordService")
	public void setPayRecordService(PayRecordService payRecordService) {
		this.payRecordService = payRecordService;
	}

	public PayRecord getPayRecord() {
		return payRecord;
	}

	public void setPayRecord(PayRecord payRecord) {
		this.payRecord = payRecord;
	}

	@Override
	public String execute() throws Exception {
		this.payRecord = this.payRecordService.getFetchPayRecord(payRecord.getPayRecId());
		return SUCCESS;
	}
	
	@Override
	public PayRecord getModel() {
		if(this.payRecord == null){
			this.payRecord = new PayRecord();
		}
		return this.payRecord;
	}

}
