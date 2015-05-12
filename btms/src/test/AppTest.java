package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.sunjee.component.bean.User;

public class AppTest {

	public static void main(String[] args) {
		String num = String.valueOf(new Date().getTime());
		List<String> nums = new ArrayList<String>();
		for(int i = 0; i < 100; i ++){
			String str = String.valueOf((Math.random()+1)*10000).substring(0,5);
			//System.out.println(num + str);
			nums.add(num +str);
		}
		for(int i = 0; i < nums.size(); i ++){
			for(int j = 0; j < nums.size(); j ++){
				if(i == j){
					continue;
				}
				if(nums.get(i) == nums.get(j)){
					System.out.println(i + "与" + j + "值为：" + nums.get(j));
				}
			}
			System.out.println(nums.get(i));
			User user = new User();
			user.setEmail("dsafsdaf");
		}
	}

	@Test
	public void orderNumTest() {
		long num = new Date().getTime();
		System.out.println(num);
	}
}
