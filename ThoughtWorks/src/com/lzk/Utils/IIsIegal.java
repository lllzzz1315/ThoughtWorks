package com.lzk.Utils;

import java.util.ArrayList;

import com.lzk.Entry.User;

public interface IIsIegal {
	/**
	 * �����Ƿ�Ϸ�
	 * */
	public boolean isDate(String date);
	/**
	 * ʱ���Ƿ�Ϸ�
	 * */
	public boolean isTime(String times);
	/**
	 * �����Ƿ�Ϸ�
	 * */
	public boolean isPlace(String place);
	
	/**
	 * �Ƿ��ص�
	 * */
	public boolean isTime_chongdie(ArrayList<User> list);
	
	/**
	 * �Ƿ� ȡ��
	 * */
	public boolean isCancell(ArrayList<User> list);
}
