package com.lzk.Main;

import java.util.ArrayList;
import java.util.Scanner;

import com.lzk.Entry.Place;
import com.lzk.Entry.User;
import com.lzk.Utils.GetCount;
import com.lzk.Utils.IIsIegal;
import com.lzk.Utils.IsIegalImpl;

public class Main {
	static ArrayList<User> list = new ArrayList<User>();
	public static void main(String[] args) {
		Main m = new Main();
		for (int i = 0; i < 6; i++) {
			m.inputDate();
		}
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i).toString());
//		}
		m.output(list);
	}
	//输入数据
	public void inputDate() {
		Scanner sa = new Scanner(System.in);
		String str = sa.nextLine();
		String[] x = str.split(" ");
		IIsIegal ls = new IsIegalImpl();
		User user = null;
		
		
		if(x.length >= 4) {
			if (ls.isDate(x[1]) && ls.isPlace(x[3]) && ls.isTime(x[2]) == false) {
				System.out.println("Error: the booking is invalid!");
			} else {
				if(x.length == 4) {
					user = new User(x[0], x[1], x[2], x[3]);
					list.add(user);
					if (ls.isTime_chongdie(list) == true) {
						System.out.println("Success: the booking is accepted!");
					} else {
						list.get(list.size() - 1).setState("F");
						System.out.println("Error: the booking conflicts with existing bookings!");
					}
				} else if(x.length == 5) {
					user = new User(x[0], x[1], x[2], x[3], x[4]);
					list.add(user);
					if (ls.isCancell(list)) {
						System.out.println("Success: the booking is accepted!");
					} else {
						list.get(list.size() - 1).setState("F");
						System.out.println("Error: the booking being cancelled does not exist!");
					}
				}
				
			}
		} else {
			System.out.println("Error: the booking is invalid!");
		}
		 
	}
	//输出数据
	public void output(ArrayList<User> list) {
		System.out.println("收⼊入汇总");
		System.out.println("---");
		
		ArrayList<Place> PlaList = new ArrayList<Place>();
		GetCount getcount = new GetCount();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getState() == "M" || list.get(i).getState() == null) {
				Place pla = new Place();
				pla.setType(list.get(i).getPlace());
				pla.setDate(list.get(i).getDates());
				pla.setTime(list.get(i).getTimes());
				int count = (int) getcount.computecount(list.get(i));
				pla.setCount(count);
				//System.out.println(pla.toString());
				PlaList.add(pla);
			}
		}
		System.out.println("场地：A");
		int sumA = 0;
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("A")) {
				if(PlaList.get(i).getCount() >= 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + PlaList.get(i).getCount() + "元");
					sumA += Math.abs(PlaList.get(i).getCount());
				}
				
			}
		}
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("A")) {
				if (PlaList.get(i).getCount() < 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + "违约金 " + " " +  Math.abs(PlaList.get(i).getCount()) + "元");
					sumA += Math.abs(PlaList.get(i).getCount());
				} 
				
			}
		}
		
		System.out.println("小计：" + sumA + "元");
		System.out.println();
		System.out.println("场地：B");
		int sumB = 0;
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("B")) {
				if(PlaList.get(i).getCount() >= 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + PlaList.get(i).getCount() + "元");
					sumB += Math.abs(PlaList.get(i).getCount());
				}
				
			}
		}
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("B")) {
				if (PlaList.get(i).getCount() < 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + "违约金 " + " " +  Math.abs(PlaList.get(i).getCount()) + "元");
					sumB += Math.abs(PlaList.get(i).getCount());
				} 
				
			}
		}
		System.out.println("小计：" + sumB + "元");
		System.out.println();
		System.out.println("场地：C");
		int sumC = 0;
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("C")) {
				if(PlaList.get(i).getCount() >= 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + PlaList.get(i).getCount() + "元");
					sumC += Math.abs(PlaList.get(i).getCount());
				}
				
			}
		}
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("C")) {
				if (PlaList.get(i).getCount() < 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + "违约金 " + " " +  Math.abs(PlaList.get(i).getCount()) + "元");
					sumC += Math.abs(PlaList.get(i).getCount());
				} 
				
			}
		}
		System.out.println("小计：" + sumC + "元");
		System.out.println();
		System.out.println("场地：D");
		int sumD = 0;
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("D")) {
				if(PlaList.get(i).getCount() >= 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + PlaList.get(i).getCount() + "元");
					sumD += Math.abs(PlaList.get(i).getCount());
				}
				
			}
		}
		for (int i = 0; i < PlaList.size(); i++) {
			if(PlaList.get(i).getType().equals("D")) {
				if (PlaList.get(i).getCount() < 0) {
					System.out.println(PlaList.get(i).getDate() + " " + PlaList.get(i).getTime() + " " + "违约金 " + " " +  Math.abs(PlaList.get(i).getCount()) + "元");
					sumD += Math.abs(PlaList.get(i).getCount());
				} 
				
			}
		}
		System.out.println("小计：" + sumD + "元");
		System.out.println("---");
		int sumX = sumA + sumB + sumC + sumD;
		System.out.println("总计：" + sumX);
	}
}
