package com.yc.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	private static final String LONG_PATTERN="yyyy年MM月dd日 HH:mm:ss";
	private static final String SHORT_PATTERN="yyyy年MM月dd日";
	
	/**
	 * 將日期轉換為字符串
	 */
	public static String parse( Date d, String pattern){
		DateFormat df=null;
		if( pattern!=null&& !"".equals(pattern)){
			df=new SimpleDateFormat(  pattern   );
		}else{
			df=new SimpleDateFormat(   LONG_PATTERN  );
		}
		return df.format( d );
	}
	
	/**
	 * 將字符串轉為Date
	 */
	public static Date parseStringToDate(  String str, String pattern){
		DateFormat df=null;
		if( pattern!=null&& !"".equals(pattern)){
			df=new SimpleDateFormat(  pattern   );
		}else{
			df=new SimpleDateFormat(   LONG_PATTERN  );
		}
		Date d=null;
		try {
			d=df.parse(str);
		} catch (ParseException e) {
			LogUtils.logger.error(e);
		}
		return d;
	}
}
