package com.lzk.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import com.lzk.Entry.User;

public class GetCount {
	User user;

	public double computecount(User user) {
		Date tmpDate = null;
		double count = 0;
		//得到时间
		String x[] = user.getTimes().split("~"); // 18:00~20:00
		int x1_int = Integer.valueOf(x[0].substring(0, 2)); // 18
		int x2_int = Integer.valueOf(x[1].substring(0, 2)); // 20
		
		//得到日期
		try {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			tmpDate = format.parse(user.getDates());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String week = getWeekOfDate(tmpDate);
		
		if (user.getState() == null) { //不是违约的
			if(week.equals("星期六") || week.equals("星期天")) {
				if(x1_int >= 9 && x1_int <= 12) {
					if(x2_int >= 9 && x2_int <= 12) count = (x2_int - x1_int) * 40;
					if(x2_int >= 12 && x2_int <= 18) count = (12 - x1_int) * 40 + (x2_int - 12) * 50;
					if(x2_int >= 18 && x2_int <= 22) count = (12 - x1_int) * 40 + (18 - 12) * 50 + (x2_int - 18) * 60;
				} 
				if(x1_int >= 12 && x1_int <= 18) {
					if(x2_int >= 12 && x2_int <= 18) count = (x2_int - x1_int) * 50;
					if(x2_int >= 18 && x2_int <= 22) count = (18 - x1_int) * 50 + (x2_int - 18) * 60;
				} 
				if(x1_int >= 18 && x1_int <= 22) {
					if(x2_int >= 18 && x2_int <= 22) count = (x2_int - x1_int) * 60;
				} 
			} else {           //除了星期六和天以外 
				if(x1_int >= 9 && x1_int <= 12) {
					if(x2_int >= 9 && x2_int <= 12) count =  (x2_int - x1_int) * 30;
					if(x2_int >= 12 && x2_int <= 18) count = (12 - x1_int) * 30 + (x2_int - 12) * 50;
					if(x2_int >= 18 && x2_int <= 20) count = (12 - x1_int) * 30 + (18 - 12) * 50 + (x2_int - 18) * 80;
					if(x2_int >= 20 && x2_int <= 22) count = (12 - x1_int) * 30 + (18 - 12) * 50 + (20 - 18) * 80 + (x2_int - 20) * 60;
				}
				if(x1_int >= 12 && x1_int <= 18) {
					if(x2_int >= 12 && x2_int <= 18) count = (x2_int - x1_int) * 50;
					if(x2_int >= 18 && x2_int <= 20) count = (18 - x1_int) * 50 + (x2_int - 18) * 80;
					if(x2_int >= 20 && x2_int <= 22) count = (18 - x1_int) * 50 + (20 - 18) * 80 + (x2_int - 20) * 60;
				}
				if(x1_int >= 18 && x1_int <= 20) {
					if(x2_int >= 18 && x2_int <= 20) count = (x2_int - x1_int) * 80;;
					if(x2_int >= 20 && x2_int <= 22) count = (20 - x1_int) * 80 + (x2_int - 20) * 60;
				}
				if(x1_int >= 20 && x1_int <= 22) {
					if(x2_int >= 20 && x2_int <= 22) count = (x2_int - x1_int) * 60;
				}
			}
			return count;
		} else {  //违约了
			if(week.equals("星期六") || week.equals("星期天")) {
				if(x1_int >= 9 && x1_int <= 12) {
					if(x2_int >= 9 && x2_int <= 12) count = ((x2_int - x1_int) * 40) * (-0.25);
					if(x2_int >= 12 && x2_int <= 18) count = ((12 - x1_int) * 40 + (x2_int - 12) * 50) * (-0.25);
					if(x2_int >= 18 && x2_int <= 22) count = ((12 - x1_int) * 40 + (18 - 12) * 50 + (x2_int - 18) * 60) * (-0.25);
				} 
				if(x1_int >= 12 && x1_int <= 18) {
					if(x2_int >= 12 && x2_int <= 18) count = ((x2_int - x1_int) * 50) * (-0.25);
					if(x2_int >= 18 && x2_int <= 22) count = ((18 - x1_int) * 50 + (x2_int - 18) * 60) * (-0.25);
				} 
				if(x1_int >= 18 && x1_int <= 22) {
					if(x2_int >= 18 && x2_int <= 22) count = ((x2_int - x1_int) * 60) * (-0.25);
				} 
			} else {           //除了星期六和天以外 
				if(x1_int >= 9 && x1_int <= 12) {
					if(x2_int >= 9 && x2_int <= 12) count =  ((x2_int - x1_int) * 30) * (-0.5);
					if(x2_int >= 12 && x2_int <= 18) count = ((12 - x1_int) * 30 + (x2_int - 12) * 50) * (-0.5);
					if(x2_int >= 18 && x2_int <= 20) count = ((12 - x1_int) * 30 + (18 - 12) * 50 + (x2_int - 18) * 80) * (-0.5);
					if(x2_int >= 20 && x2_int <= 22) count = ((12 - x1_int) * 30 + (18 - 12) * 50 + (20 - 18) * 80 + (x2_int - 20) * 60) * (-0.5);
				}
				if(x1_int >= 12 && x1_int <= 18) {
					if(x2_int >= 12 && x2_int <= 18) count = ((x2_int - x1_int) * 50) * (-0.5);
					if(x2_int >= 18 && x2_int <= 20) count = ((18 - x1_int) * 50 + (x2_int - 18) * 80) * (-0.5);
					if(x2_int >= 20 && x2_int <= 22) count = ((18 - x1_int) * 50 + (20 - 18) * 80 + (x2_int - 20) * 60) * (-0.5);
				}
				if(x1_int >= 18 && x1_int <= 20) {
					if(x2_int >= 18 && x2_int <= 20) count = ((x2_int - x1_int) * 80) * (-0.5);
					if(x2_int >= 20 && x2_int <= 22) count = ((20 - x1_int) * 80 + (x2_int - 20) * 60) * (-0.5);
				}
				if(x1_int >= 20 && x1_int <= 22) {
					if(x2_int >= 20 && x2_int <= 22) count = ((x2_int - x1_int) * 60) * (-0.5);
				}
			}
			return count;
		}
	}

	/**
	 * 获取当前日期是星期几<br>
	 * 
	 */
	public static String getWeekOfDate(Date dt) {
		String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (w < 0)
			w = 0;
		return weekDays[w];
	}
	
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tmp123 = format.parse("2017-09-09");
		System.out.println(getWeekOfDate(tmp123));
	}
}
