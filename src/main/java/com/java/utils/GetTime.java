/*
 * File name:          GetTime.java
 * Copyright@Lanqiao (China)
 * Editor:           JDK1.7.32
 */
package com.java.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * TODO: File comments
 * <p>
 * <p>
 * Author:          LF
 * <p>
 * Date:           2017年12月28日
 * <p>
 * Time:           上午10:49:39
 * <p>
 * Director:        LF
 * <p>
 * <p>
 */
public class GetTime {
	/**
	 * 获取当前时间戳
	 * @return
	**/
	public static String Getdate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		return date;
	}
	/**
	 * 获取当前日期
	 * @return
	 **/
	public static String Getdata() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
		return date;
	}

	/**
	 * 计算出昨天的日期
	 * @return
	 **/
	public static String getYesterday() {
		Date date = new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, -1);//把日期往前减少一天，若想把日期向后推一天则将负数改为正数
		date = calendar.getTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		return dateString;
	}

	/**
	 * 给一个日期和一个数字算出几天后的时间，如果给的数字为负数则为这个日期前的几天
	 * @param str
	 * @param num
	 * @return
	 **/
	public static String getTime(String str, int num) {
		// 时间表示格式可以改变，yyyyMMdd需要写例如20160523这种形式的时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 将字符串的日期转为Date类型，ParsePosition(0)表示从第一个字符开始解析
		Date date = sdf.parse(str, new ParsePosition(0));
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		// add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
		calendar.add(Calendar.DATE, num);
		Date date1 = calendar.getTime();
		String out = sdf.format(date1);
		return out;
	}

	/**
	 * 比较两个时间
	 * @param
	 * @param
	 * @return
	 * @throws ParseException 
	 **/
	public static int compare_date(String DATE1, String DATE2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date dt1 = df.parse(DATE1);
			Date dt2 = df.parse(DATE2);
			if (dt1.getTime() <= dt2.getTime()) {
				return 1;
			} else {
				return -1;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
			return 0;
		}
	}

	public static int differentDays(Date date1, Date date2) {
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);

		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		int day1 = cal1.get(Calendar.DAY_OF_YEAR);
		int day2 = cal2.get(Calendar.DAY_OF_YEAR);

		int year1 = cal1.get(Calendar.YEAR);
		int year2 = cal2.get(Calendar.YEAR);
		if (year1 != year2) //同一年
		{
			int timeDistance = 0;
			for (int i = year1; i < year2; i++) {
				if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) //闰年  
				{
					timeDistance += 366;
				} else //不是闰年
				{
					timeDistance += 365;
				}
			}

			return timeDistance + (day2 - day1);
		} else //不同年
		{
			return day2 - day1;
		}
	}
}
