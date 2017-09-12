package com.lzk.Utils;

import java.util.ArrayList;

import com.lzk.Entry.User;

public interface IIsIegal {
	/**
	 * 日期是否合法
	 * */
	public boolean isDate(String date);
	/**
	 * 时间是否合法
	 * */
	public boolean isTime(String times);
	/**
	 * 场地是否合法
	 * */
	public boolean isPlace(String place);
	
	/**
	 * 是否重叠
	 * */
	public boolean isTime_chongdie(ArrayList<User> list);
	
	/**
	 * 是否 取消
	 * */
	public boolean isCancell(ArrayList<User> list);
}
