package com.sunjee.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;

import com.sunjee.btms.common.Constant;
import com.sunjee.btms.exception.AppRuntimeException;
import com.sunjee.component.bean.BaseBean;

public class ExcelUtil extends BaseBean {

	private static final long serialVersionUID = 513138871084698662L;
	
	/**
	 * 生成Excel文件
	 * @param context
	 * @param templateName
	 * @return
	 * @throws IOException 
	 */
	public static File createExcel(ServletContext context,String templateName){
		HSSFWorkbook workBook;
		File tmp = null;
		try {
			InputStream is = getResourceAsStream(context,templateName);
			workBook = new HSSFWorkbook(is);
			tmp = new File(Constant.TEMP_PATH + UUID.randomUUID() + ".xls");
			tmp.createNewFile();
			workBook.write(new FileOutputStream(tmp));
			workBook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tmp;
		
		/*HSSFWorkbook workBook = null;
				try {
					workBook = new HSSFWorkbook(getTemplateInputStream(Constant.SUMMARY_TEMPLATE_PATH));
					Sheet sheet = workBook.getSheetAt(0);
					Row templateRow = sheet.getRow(rowIndex);
					for(DataSummary ds : list){
						Row row  = sheet.getRow(rowIndex);
						if(row == null){
							row = sheet.createRow(rowIndex);
						}
						for(int i = templateRow.getFirstCellNum(); i < templateRow.getLastCellNum(); i ++){
							Cell cell = row.getCell(i);
							if(cell == null){
								row.createCell(i);
							}
							CellStyle style = templateRow.getCell(i).getCellStyle();
							cell.setCellStyle(style);
							cell.setCellValue(ds.getTotal());
						}
						rowIndex ++;
					}
					//File tmpFile = new File(Constant.TEMP_PATH + UUID.randomUUID() + ".xls");
					//workBook.write(new FileOutputStream(tmpFile));
					//return new FileInputStream(tmpFile);
					setFileName("数据汇总表.xls");
					return getTemplateInputStream(Constant.SUMMARY_TEMPLATE_PATH);
				} catch (Exception e) {
					throw new AppRuntimeException("文件不存在", e);
				} finally{
					if(workBook != null){
						try {
							workBook.close();
						} catch (IOException e) {}
					}
				}*/
	}
	
	private static InputStream getResourceAsStream(ServletContext context,String templateName){
		return context.getResourceAsStream(templateName);
	}
}
