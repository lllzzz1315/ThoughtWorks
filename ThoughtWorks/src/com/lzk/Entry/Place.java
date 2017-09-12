package com.lzk.Entry;

public class Place {
	private String type;
	private String date;
	private String time;
	private int count;  //ºÏ¼Æ
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count2) {
		this.count = count2;
	}
	@Override
	public String toString() {
		return "Place [type=" + type + ", date=" + date + ", time=" + time
				+ ", count=" + count + "]";
	}

	

}
