package com.program;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ans = "";

		if (n % 2 == 1) {
			ans = "Weird";
		} else if (n % 2 == 0) {

			ans = "Not Weired";

		} else if (n % 2 == 0) {
			for (n = 6; n <= 20; n++)
				ans = "Weired";

		} else {
			ans = "Not Wired";
		}
		System.out.println(ans);

	}
}