package com.cc.sftp.util;

import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private final static String dateFormat = "yyyy-MM-dd HH:mm:ss";
	
	private final static String yearAndDateFormat = "yyyyMMdd";
	
	private final static String flowCarddateFormat = "yyyyMMddHHmmss";
	
	public static String getStingDate (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	} 

	public static String getPartStringDate (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(yearAndDateFormat);
		return sdf.format(date);
	}
		
	public static String getFlowStingDate (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(flowCarddateFormat);
		return sdf.format(date);
	}

	public static Date getFullDate (String dataStr) {
		if (StringUtils.isBlank(dataStr)) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(flowCarddateFormat);
		try {
			return sdf.parse(dataStr);
		} catch (Exception e) {
			return null;
		}
	}

	public static Date getDateTime (String strDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			return sdf.parse(strDate);
		} catch (Exception e) {
			return null;
		}
	}


}
