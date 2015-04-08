package test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

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
}
