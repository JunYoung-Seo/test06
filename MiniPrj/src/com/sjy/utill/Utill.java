package com.sjy.utill;

import java.util.Scanner;

public class Utill {
	public static Scanner sc =new Scanner(System.in);

	public static String scString() {
		String n = sc.nextLine();
		return n;
	}
	
	public static int scInt() {
		int n = sc.nextInt();
		sc.nextLine();
		return n;
	}
}
