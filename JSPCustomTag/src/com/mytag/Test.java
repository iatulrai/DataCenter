package com.mytag;

import java.util.Calendar;

public class Test {

	int ctr;

	public int getCtr() {
		ctr++;
		return ctr;
	}

	public String getDate() {
		Calendar c = Calendar.getInstance();
		return c.get(c.DATE) + " / " + (c.get(c.MONTH) + 1) + " / " + c.get(c.YEAR);

	}

	public String getTime() {
		Calendar c = Calendar.getInstance();
		return c.get(c.HOUR_OF_DAY) + " : " + c.get(c.MINUTE) + " : " + c.get(c.SECOND);
	}

	public int sum(int a, int b) {
		return a + b;
	}
}
