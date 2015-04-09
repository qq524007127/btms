package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Test;

import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.impl.ModuleDaoImpl;
import com.sunjee.btms.dao.impl.RoleDaoImpl;
import com.sunjee.util.DateUtil;
import com.sunjee.util.HqlNoEquals;

public class AppTest {

	public static void main(String[] args) {
		System.out.println(new RoleDaoImpl().getTableName());
	}
	
	@Test
	public void test(){
		Map<String, Object> params = new HashMap<>();
		params.put("moduleId", "10001");
		params.put("moduleName", "name");
		params.put("child.createDate", new HqlNoEquals(new Date(), new Date()));

		Map<String, SortType> sortParams = new HashMap<>();
		sortParams.put("id", null);
		sortParams.put("name", SortType.desc);
		sortParams.put("date", SortType.asc);
		System.out.println(new ModuleDaoImpl().createQueryHql(params,sortParams));
	}
	
	@Test
	public void dateUtilTest(){
		System.out.println(DateUtil.getAfterYears(new Date(), 4));
	}

	@Test
	public void dateUtilsTest(){
		System.out.println(DateUtil.parseDate("2015-10-23"));
		System.out.println(DateUtil.parseDateTime("2015-10-23 23:59:00"));
		System.out.println(DateUtil.getCurrentDate());
		System.out.println(DateUtil.parseDateTime(DateUtil.getCurrentDate() + " 23:59:00"));
	}
	
	@Test
	public void timerTest(){
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("定时器正在执行");
			}
		}, new Date(),1000 * 30);
	}
	
	@Test
	public void poiTest(){
		File f = new File("summarytemplate.xls");
		try {
			if(!f.exists()){
				f.createNewFile();
			}
			System.out.println(f.getAbsolutePath());
			HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(f));
			/*int count = book.getNumberOfSheets();
			for(int index = count; index > 1; index --){
				Sheet tmp = book.getSheetAt(index);
				if(tmp != null){
					book.removeSheetAt(index);
				}
				book.removeSheetAt(index);
			}*/
			Sheet sheet = book.getSheetAt(0);
			//book.setSheetName(0, "测试数据");
			Row row= sheet.getRow(sheet.getLastRowNum());
			CellStyle style = row.getRowStyle();
			for(int i = 1; i <= 365; i ++){
				int index = sheet.getLastRowNum() + 1;
				Row lr = sheet.getRow(sheet.getLastRowNum());
				Row nr = sheet.createRow(index);
				for(int cn = 0; cn < lr.getLastCellNum(); cn ++){
					CellStyle cs = lr.getCell(cn).getCellStyle();
					Cell cell = nr.createCell(cn);
					cell.setCellStyle(cs);
					cell.setCellValue("hello");
				}
				//nr.setRowStyle(style);
			}
			
			book.close();
			File tmpFile = new File(UUID.randomUUID().toString()+".xls");
			tmpFile.createNewFile();
			book.write(new FileOutputStream(tmpFile));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
