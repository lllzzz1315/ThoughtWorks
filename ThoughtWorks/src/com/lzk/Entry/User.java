package com.lzk.Entry;
/****
 * �������
 * 
 * 
 */
import java.util.Date;

public class User {
	private String UsetId;
	private String dates;
	private String times;
	private String place;
	private String state;  //״̬��ΪC��ȡ����������M��ΥԼ�𣩣��Ϳգ�null��,F(��ʾ����)
	public String getUsetId() {
		return UsetId;
	}
	public void setUsetId(String usetId) {
		UsetId = usetId;
	}
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getTimes() {
		return times;
	}
	public void setTimes(String times) {
		this.times = times;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "User [UsetId=" + UsetId + ", dates=" + dates + ", times="
				+ times + ", place=" + place + ", state=" + state + "]";
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String usetId, String dates, String times, String place,
			String state) {
		super();
		UsetId = usetId;
		this.dates = dates;
		this.times = times;
		this.place = place;
		this.state = state;
	}
	
	public User(String usetId, String dates, String times, String place) {
		super();
		UsetId = usetId;
		this.dates = dates;
		this.times = times;
		this.place = place;
	}
	
	
}
