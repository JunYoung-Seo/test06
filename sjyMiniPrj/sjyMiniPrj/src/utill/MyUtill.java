package com.sjy.utill;

import java.util.Scanner;

public class MyUtill {
	
	public static Scanner sc = new Scanner(System.in);
	
	public static int scInt() {
		int n =  sc.nextInt();	//정수입력
		sc.nextLine();			//엔터키제거
		return n;
	}

	
}
