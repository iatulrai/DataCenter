package com.program;

import net.sourceforge.sizeof.SizeOf;

public class Student {
	int roll;
	String name;

	public static void main(String[] args) {
		Student stu = new Student();

		System.out.println(SizeOf.humanReadable(SizeOf.deepSizeOf(stu)));
	}

}
