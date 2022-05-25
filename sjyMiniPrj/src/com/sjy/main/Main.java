package com.sjy.main;

import com.sjy.member.Member;
import com.sjy.utill.MyUtill;

public class Main {

	
	public static void main(String[] args) {
		System.out.println("sjy mini prj");
		
		System.out.println("======================");
		System.out.println("1 회원가입");
		System.out.println("2 로그인");
		System.out.println("3 333");
		System.out.println("4 4444");
		System.out.println("5 55555");
		
		int n = MyUtill.scInt();
		
		switch (n) {
		case 1: {new Member().join(); break;}
		case 2: {new Member().login(); break;}
		case 3: {break;}
		case 4: {break;}
		case 5: {break;}
		default:{System.out.println("다시 선택하세요");}
		}
		
		
	}

}
