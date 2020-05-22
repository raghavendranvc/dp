package com.my.fb;

public class BillionUsers {

	int getFullDays(double growthRate) {
		double value = (double) 9 / Math.log10(growthRate);
		return (int) Math.round(value + 0.5);
	}
	
	public static void main(String[] args) {
		BillionUsers billionUsers = new BillionUsers();
		int val = billionUsers.getFullDays(1.5);
		System.out.println("val="+val);
	}

}
