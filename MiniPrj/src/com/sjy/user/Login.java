package com.sjy.user;

import com.sjy.admin.Admin;
import com.sjy.utill.Utill;

public class Login {
	public static String id;
	public static String pw;
	
	public Login() {
		System.out.print("아이디 입력: ");
		id = Utill.scString().trim();
		System.out.print("패스워드 입력: ");
		pw = Utill.scString().trim();
		
//		id=sc.nextLine();
//		num = sc.nextInt();
//		sc.nextLine();
		if ("admin".equals(id) && "1234".equals(pw)) {
			//admin 
			new Admin();
		}
		else{new User();}
		
		//입력받은 id,pw값이 DB 있는지 판단
		//동일할경우 로그인 완료
		//아니면 다시 로그인 페이지
//		if (condition) {
//			
//		}
		System.out.println("----------------------------");
	}
}
