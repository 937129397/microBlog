package com.yc.utils;

public class RegexUtils {
	/*
	 * 
	 */
	public static final String reg1 = "[1-9]\\d*"; 
	
	public static final String reg2 = "-[1-9]\\d*";
	public static final String reg3 = "-?[1-9]\\d*|0";
	public static final String reg4 = "[1-9]\\d*|0";
	public static final String reg5 = "-[1-9]\\d*|0";
	public static final String reg6 = "[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*";//Õý¸¡µãÊý
	public static final String reg7 = "-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*)";
	public static final String reg8 = "-?([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0)";
	public static final String reg9 = "[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*|0?\\.0+|0";
	public static final String reg10 = "(-([1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*))|0?\\.0+|0";
	public static final String reg11 = "0£¿\\.0+|0";
	
	
	
	
	
}
