package test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.sunjee.btms.common.SortType;
import com.sunjee.btms.dao.impl.ModuleDaoImpl;
import com.sunjee.btms.dao.impl.RoleDaoImpl;
import com.sunjee.util.DateUtil;

public class AppTest {

	public static void main(String[] args) {
		System.out.println(new RoleDaoImpl().getTableName());
	}
	
	@Test
	public void test(){
		Map<String, Object> params = new HashMap<>();
		params.put("moduleId", "10001");
		params.put("moduleName", "name");

		Map<String, SortType> sortParams = new HashMap<>();
		sortParams.put("id", null);
		sortParams.put("name", SortType.desc);
		sortParams.put("date", SortType.asc);
		System.out.println(new ModuleDaoImpl().createQueryHql(params,sortParams));
	}
	
	@Test
	public void dateUtilTest(){
		System.out.println(DateUtil.getCurrentDate());
	}

}
