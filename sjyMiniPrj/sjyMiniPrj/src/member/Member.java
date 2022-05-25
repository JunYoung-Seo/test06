package com.sjy.member;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sjy.db.OracleDB;
import com.sjy.utill.MyUtill;

public class Member {
	
	//로그인
	public boolean login() {
		System.out.println("=========로그인=========");
		System.out.print("아이디: ");
		String id = MyUtill.sc.nextLine();
		System.out.print("비밀번호: ");
		String pwd = MyUtill.sc.nextLine();
		
		//db연결 얻기
		Connection conn = OracleDB.getOracleConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//해당 아이디에 맞는 패스워드 디비에서 조회
		String sql ="SELECT PWD FROM MEMBER WHERE ID = ?";//UPPER() 사용 ID, ?에 
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 
				String dbPwd = rs.getString(1);// 첫번째 칼럼을 의미
				if (dbPwd.equalsIgnoreCase(pwd)) {//equalsIgnoreCase:대소문자 구분x
					//로그인성공
					System.out.println("로그인 성공");
					return true;
				}
			}
			
		} catch (SQLException e) {
			System.out.println("SQL예외 발생");
			e.printStackTrace();
		}finally {OracleDB.close(conn);OracleDB.close(pstmt);OracleDB.close(rs);}
		
		
		//디비에서 조회한 패스워드가 일치하는지 확인
		System.out.println("로그인 실패");
		return false;
	}//login

	
	//회원가입
	
	/*
	 * 아이디, 비번, 닉네임 입력
	 * 아이디 중복 검사
	 * 비밀번호 유효성검사 (8글자 이상인지..)
	 * db저장
	 * */
	public boolean join() {
		System.out.println("=============회원가입=============");
		System.out.print("아이디입력: ");
		String id = MyUtill.sc.nextLine().trim();
		System.out.print("비밀번호입력: ");
		String pwd = MyUtill.sc.nextLine().trim();
		System.out.print("닉네임입력: ");
		String nick = MyUtill.sc.nextLine().trim();
		
		int no=0;
		
		//비번 유효성 검사
		if (pwd.length() < 4) {
			//회원가입 실패
			System.out.println("비밀 번호는 4글자 이상 이어야 합니다.");
			return false;
		}
		
		
		//아이디 중복검사
		//1. 디비접속
		Connection conn = OracleDB.getOracleConnection();//접속 /객체 생성x 
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//2. 디비에서 현재 입력받은 아이디와 일치여부 확인
		try {
			//String sql = "SELECT * FROM MEMBER WHERE ID ='" +id+"'";
			String sql = "SELECT * FROM MEMBER WHERE ID = ?";
			
			//Statement stmtDup = conn.createStatement();//PreparedStatment
			//ResultSet rs = stmtDup.executeQuery(sql);
			
			//PreparedStatement 사용
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,id);	//pstmt에 String타입으로 채워주어라 (몇번째(?), 값)
			rs =pstmt.executeQuery();
			
			if (rs.next()) {
				//중복o 회원가입 실패
				System.out.println("아이디 중복됨..");
				return false;
			}
			
			//db에 데이터 저장
			//3 회원가입 성공: db저장
			
//			String sqlInsert
//			= "INSERT INTO MEMBER(NO,ID,PWD,NICK) "
//					+ "VALUES(4,'" + id + "','" + pwd + "','" + nick +"')";
			
			String sqlInsert
			= "INSERT INTO MEMBER(NO,ID,PWD,NICK) "
					+ "VALUES(?,?,?,?)";
			
			
//			Statement stmtInsert = conn.createStatement();
//			int result = stmtInsert.executeUpdate(sqlInsert);

			PreparedStatement pstmt2 = conn.prepareStatement(sqlInsert);
			pstmt2.setInt(1, 5);
			pstmt2.setString(2, id);
			pstmt2.setString(3, pwd);
			pstmt2.setString(4, nick);
			int result = pstmt2.executeUpdate();
			
			if(result == 1) {
				System.out.println("회원 가입 성공!!!");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 예외 발생");
		}finally {OracleDB.close(conn);OracleDB.close(pstmt);OracleDB.close(rs);}
		
		
		System.out.println("회원 가입 실패...");
		return false;
	}//join
	
	
}//class
