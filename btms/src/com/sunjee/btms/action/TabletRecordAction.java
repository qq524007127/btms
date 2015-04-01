package com.sunjee.btms.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.TabletRecord;
import com.sunjee.btms.service.TabletRecordService;

@Controller("tabletRecordAction")
@Scope("prototype")
public class TabletRecordAction extends BaseAction<TabletRecord> implements
		ModelDriven<TabletRecord> {

	private static final long serialVersionUID = 4187111490954178285L;

	private TabletRecordService tabletRecordService;

	private TabletRecord tabletRecord;

	public TabletRecordService getTabletRecordService() {
		return tabletRecordService;
	}
	
	@Resource(name="tabletRecordService")
	public void setTabletRecordService(TabletRecordService tabletRecordService) {
		this.tabletRecordService = tabletRecordService;
	}

	public TabletRecord getTabletRecord() {
		return tabletRecord;
	}

	public void setTabletRecord(TabletRecord tabletRecord) {
		this.tabletRecord = tabletRecord;
	}

	@Override
	public TabletRecord getModel() {
		if(this.tabletRecord == null){
			this.tabletRecord = new TabletRecord();
		}
		return this.tabletRecord;
	}

}
