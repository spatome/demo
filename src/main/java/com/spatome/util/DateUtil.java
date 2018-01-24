/**   
 * Copyright © 2017 ****. All rights reserved.
 * 
 * @Title: DateUtil.java 
 * @Prject: api-core
 * @Package: com.hengpeng.api.util 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年7月24日 下午1:51:24 
 * @version: V1.0   
 */
package com.spatome.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName: DateUtil
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年7月24日 下午1:51:24
 */
public class DateUtil
{
	public static final DateFormat YM_DATE_FORMAT = new SimpleDateFormat("yyyy-MM");
	
	public static final DateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static final DateFormat LONG_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static final DateFormat LONG_DATE_FORMAT_NOMM = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public static final DateFormat ORDER_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHH");

	public static final DateFormat LONG_DATE_FORMAT_NO_SPLIT = new SimpleDateFormat("yyyyMMddHHmmss");

	/**
	 * @Description: 默认
	 * @param date
	 * @return
	 * @return: String
	 */
	public static String formatDate(Date date)
	{
		if (date == null)
		{
			return null;
		}

		return LONG_DATE_FORMAT.format(date);
	}

	public static Date parseLongDateNoSplit(String time)
	{
		if (time == null || time.length() <= 0)
			return null;
		try
		{
			Date date = LONG_DATE_FORMAT_NO_SPLIT.parse(time);
			return date;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误");
		}
	}

	public static Date parseFormatNoMM(String time)
	{
		if (time == null || time.length() <= 0)
			return null;
		try
		{
			Date date = LONG_DATE_FORMAT_NOMM.parse(time);
			return date;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误");
		}
	}

	public static Date parseFormat(String time)
	{
		if (time == null || time.length() <= 0)
			return null;
		try
		{
			Date date = LONG_DATE_FORMAT.parse(time);
			return date;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误", ex);
		}
	}

	public static String formatDateNoMM(Date date)
	{
		return LONG_DATE_FORMAT_NOMM.format(date);
	}

	public static String formatShortDate(Date date)
	{
		return formatDate(date, SHORT_DATE_FORMAT);
	}

	public static String formatYMDate(Date date)
	{
		if(date==null){
			return null;
		}
		return formatDate(date, YM_DATE_FORMAT);
	}

	public static Date parseFormatShort(String time)
	{
		if (time == null || time.length() <= 0)
			return null;
		try
		{
			Date date = SHORT_DATE_FORMAT.parse(time);
			return date;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误", ex);
		}
	}

	public static Date parseFormatYM(String time)
	{
		if (time == null || time.length() <= 0)
			return null;
		try
		{
			Date date = YM_DATE_FORMAT.parse(time);
			return date;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException("格式化时间错误", ex);
		}
	}
	
	public static String formatDate(Date date, DateFormat format)
	{
		if(date==null){
			return "";
		}
		return format.format(date);
	}

	public static Date getCurrentDateShort()
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE), 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取某天的开始时间
	 * @return
	 */
	public static Date getSomeDayStartTimes(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 获取某天的结束时间
	 * @return
	 */
	public static Date getSomeDayEndTimes(Date date)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 获取多少天前的开始时间
	 * @param dayCount
	 * @return
	 */
	public static Date getSomeDayStartTime(int dayCount)
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, dayCount);
		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}
}