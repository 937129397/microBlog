package com.microblog.util;

import java.util.Date;
import java.util.Random;

/**
 * 各种常量，静态方法
 * @author 宇
 *
 */
public class Content {
	
	public static String getUid(){
		String str = "U";
		Random rand= new Random();
		Date d= new Date();
		str+=d.getTime();
		str+=(rand.nextInt(90)+10);
		return str;
	}
}
