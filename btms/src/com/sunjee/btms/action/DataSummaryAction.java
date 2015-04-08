package com.sunjee.btms.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;
import com.sunjee.btms.bean.DataPager;
import com.sunjee.btms.bean.DataSummary;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.DataSummaryService;

@Controller("dataSummaryAction")
@Scope("prototype")
public class DataSummaryAction extends BaseAction<DataSummary> {

	private static final long serialVersionUID = 2613796523828817096L;

	private DataSummaryService dataSummaryService;

	private Date startDate;
	private Date endDate;

	public DataSummaryService getDataSummaryService() {
		return dataSummaryService;
	}

	@Resource(name = "dataSummaryService")
	public void setDataSummaryService(DataSummaryService dataSummaryService) {
		this.dataSummaryService = dataSummaryService;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String grid(){
		Map<String, Object> whereParams = getWhereParams();
		Map<String, SortType> sortParams = getSortParams();
		if(!sortParams.containsKey("createDate")){
			sortParams.put("createDate", SortType.desc);
		}
		this.setDataGrid(this.dataSummaryService.getDataGrid(getPager(), whereParams, sortParams));
		return success();
	}
}
