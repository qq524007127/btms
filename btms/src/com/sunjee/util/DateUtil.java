package com.sunjee.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public final static String DEFAULT_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public final static String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";

	public static String getCurrentDateTime() {
		Calendar calendar = Calendar.getInstance();
		return getSimpleDateFormat(DEFAULT_DATE_TIME_FORMAT).format(calendar.getTime());
	}
	
	public static String getCurrentDate(){
		Calendar calendar = Calendar.getInstance();
		return getSimpleDateFormat(DEFAULT_DATE_FORMAT).format(calendar.getTime());
	}
	
	private static SimpleDateFormat getSimpleDateFormat(String format){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf;
	}
	
	public static Date getAfterYears(Date date,int amount){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, amount);
		return calendar.getTime();
	}
}
