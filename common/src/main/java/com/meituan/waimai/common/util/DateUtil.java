package com.meituan.waimai.common.util;

import java.util.Calendar;

public class DateUtil {

	/**
	 * 获取到第二日凌晨的秒数
	 * @return
	 */
	public static Long getSecondsNextEarlyMorning() {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, 1);
		// 改成这样就好了
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
	}

	/**
	 * 获取当前时间的秒数
	 * @return
	 */
	public static Long getCurrentSeconds(){
		return System.currentTimeMillis() / 1000;
	}
}
