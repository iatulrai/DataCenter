package com.program;

class TestA {
	public void play() {
		System.out.println("HI");
	}
}

public class TestB extends TestA {
	public void display() {
		System.out.println("I am in play");
	}

	public static void main(String[] args) {

		TestB ob = new TestA();
		ob.play();
		ob.display();

	}
}
