package com.lzk.Utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.lzk.Entry.User;

public class IsIegalImpl implements IIsIegal {

	@Override
	public boolean isDate(String date) {
		String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(date);
		boolean dateType = mat.matches();
		return dateType;
	}

	@Override
	public boolean isTime(String times) {
		String[] x = times.split("~");
		if (x[0].equals(x[1]) || x.length == 1) {
			return false;
		}
		String rexp = "((0?[0-9])|([1-2][0-9]))\\:([0]?[0])?$";
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(x[1]);
		Matcher mat1 = pat.matcher(x[0]);
		return mat1.matches() && mat.matches();
	}

	@Override
	public boolean isPlace(String place) {
		if (place.equals("A") || place.equals("B") || place.equals("C")
				|| place.equals("D")) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isTime_chongdie(ArrayList<User> list) {

		boolean flag = true;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i).getPlace().equals(list.get(list.size() - 1).getPlace())
					&& list.get(i).getDates().equals(list.get(list.size() - 1).getDates())) { // 同一天内同一个场地
				if (list.get(i).getState() == null) {
					String x[] = list.get(i).getTimes().split("~"); // 18:00~20:00
					int x1_int = Integer.valueOf(x[0].substring(0, 2)); // 18
					int x2_int = Integer.valueOf(x[1].substring(0, 2)); // 20

					String y[] = list.get(list.size() - 1).getTimes()
							.split("~"); // 18:00~20:00
					int y1_int = Integer.valueOf(y[0].substring(0, 2)); // 18
					int y2_int = Integer.valueOf(y[1].substring(0, 2)); // 20
					if ((x1_int < y2_int) || (x2_int > y1_int)) {
						flag = false;
					}
				}
			}
		}
		return flag;
	}

	@Override
	public boolean isCancell(ArrayList<User> list) {
		boolean flag = true;
		for (int i = 0; i < list.size() - 1; i++) {	
			if (list.get(i).getUsetId().equals(list.get(list.size() - 1).getUsetId())
					&& list.get(i).getTimes().equals(list.get(list.size() - 1).getTimes())
					&& list.get(i).getPlace().equals(list.get(list.size() - 1).getPlace())
					&& list.get(i).getDates().equals(list.get(list.size() - 1).getDates())
					&& list.get(i).getState() == null) {
				list.get(i).setState("M");
				break;
			} else {
				flag = false;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		IsIegalImpl im = new IsIegalImpl();
		User user = null;
		ArrayList<User> list = new ArrayList<User>();
		for (int i = 0; i < 2; i++) {
			user = new User("U003", "2017-08-01", "18:00~20:00", "A");
			list.add(user);
		}
		System.out.println(im.isTime_chongdie(list));
	}

}
