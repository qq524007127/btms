package com.sunjee.btms.action;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sunjee.btms.bean.DataSummary;
import com.sunjee.btms.common.Constant;
import com.sunjee.btms.common.SortType;
import com.sunjee.btms.service.DataSummaryService;
import com.sunjee.util.DateUtil;
import com.sunjee.util.ExcelUtil;
import com.sunjee.util.HqlNoEquals;

@Controller("dataSummaryAction")
@Scope("prototype")
public class DataSummaryAction extends BaseAction<DataSummary> {

	private static final long serialVersionUID = 2613796523828817096L;
	
	private DataSummaryService dataSummaryService;

	private Date startDate;
	private Date endDate;
	private String fileName;

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
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		try {
			this.fileName = new String(fileName.getBytes(), "ISO8859-1");	//将文件名称转换为Struts2的编码格式(struts2的编码格式为:"ISO8859-1")
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			this.fileName = UUID.randomUUID().toString();
		}
	}
	
	public String grid(){
		Map<String, Object> whereParams = getWhereParams();
		if(startDate != null && endDate != null){
			startDate = DateUtil.getStartOfDay(startDate);
			endDate = DateUtil.getEndOfDay(endDate);
			whereParams.put("createDate", new HqlNoEquals(startDate, endDate));
		}
		else if(startDate != null){
			startDate = DateUtil.getStartOfDay(startDate);
			whereParams.put("createDate", new HqlNoEquals(startDate, HqlNoEquals.MORE_EQ));
		}
		else if(endDate != null){
			endDate = DateUtil.getEndOfDay(endDate);
			whereParams.put("createDate", new HqlNoEquals(endDate, HqlNoEquals.LESS_EQ));
		}
		Map<String, SortType> sortParams = getSortParams();
		if(!sortParams.containsKey("createDate")){
			sortParams.put("createDate", SortType.desc);
		}
		this.setDataGrid(this.dataSummaryService.getDataGrid(getPager(), whereParams, sortParams));
		return success();
	}
	
	/**
	 * 导出数据汇总表
	 * @return
	 */
	public InputStream getSummaryFile(){
		
		int rowIndex = 3;	//从第三行开始写数据
		
		Map<String, Object> whereParams = getWhereParams();
		if(startDate != null && endDate != null){
			startDate = DateUtil.getStartOfDay(startDate);
			endDate = DateUtil.getEndOfDay(endDate);
			whereParams.put("createDate", new HqlNoEquals(startDate, endDate));
		}
		else if(startDate != null){
			startDate = DateUtil.getStartOfDay(startDate);
			whereParams.put("createDate", new HqlNoEquals(startDate, HqlNoEquals.MORE_EQ));
		}
		else if(endDate != null){
			endDate = DateUtil.getEndOfDay(endDate);
			whereParams.put("createDate", new HqlNoEquals(endDate, HqlNoEquals.LESS_EQ));
		}
		Map<String, SortType> sortParams = getSortParams();
		if(!sortParams.containsKey("createDate")){
			sortParams.put("createDate", SortType.desc);
		}
		List<DataSummary> list = this.dataSummaryService.getAllByParams(null, whereParams, sortParams);
		ServletContext context = ServletActionContext.getServletContext();
		/*try {
			return new FileInputStream(ExcelUtil.createExcel(context, Constant.SUMMARY_TEMPLATE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}*/
		try {
			HSSFWorkbook book = new HSSFWorkbook(context.getResourceAsStream(Constant.SUMMARY_TEMPLATE_NAME));
			Sheet sheet = book.getSheetAt(0);
			sheet.getLastRowNum();
			book.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//File tmepFile= ExcelUtil.createExcel(context, Constant.SUMMARY_TEMPLATE_NAME);
		return context.getResourceAsStream(Constant.SUMMARY_TEMPLATE_NAME);
	}
}
