package com.program;

import java.awt.Rectangle;

import net.sourceforge.sizeof.SizeOf;

public class SizeOfObject {
	public static void main(String[] args) {

		Rectangle rectTwo = new Rectangle(50, 100);
		System.out.println(SizeOf.deepSizeOf(rectTwo));

	}

}
