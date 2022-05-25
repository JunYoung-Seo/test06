package com.sjy.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleDB {
	
	public static Connection getOracleConnection() {
		
		//파일에 ip port url 연결 정보 저장
		//파일에서 읽어 들어여서 연결
		//파일은 각자 본인 환경에 맞게 가지고 있으면됨
		//위파일은 깃허브에 올리면 안되겠죠? -> gitignore
		
		String driver ="oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";

		//드라이버등록
		Connection conn= null;
		
		String id = "C##KH";
		String pwd = "KH";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			
				
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("커넥션 가져오기 실패");
		}
		return conn;
	}//getOraCon
	
	public static void close(Connection conn) {
		
		if(conn!=null)try {conn.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void close(Statement stmt) {//PreparedStatement는 Statement상속받고있음
		if(stmt!=null)try {stmt.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
	public static void close(ResultSet rs) {
		if(rs!=null)try {rs.close();} catch (SQLException e) {e.printStackTrace();}
	}
	
	
}// class
