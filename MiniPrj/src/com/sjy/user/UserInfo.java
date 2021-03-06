package com.sjy.user;

import java.util.List;

public class UserInfo {
	private String id;
	private String pwd;
	private String name;
	private int age;
	private char gender;
	private String nick;
	private List<String> favorites;
	private String rank;
	
	//생성자
	public UserInfo() {}

	public UserInfo(String id, String pwd, String name, int age, char gender, String nick, List<String> favorites,
			String rank) {
		super();
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.nick = nick;
		this.favorites = favorites;
		this.rank = rank;
	}
	
	//getter||setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public List<String> getFavorites() {
		return favorites;
	}
	public void setFavorites(List<String> favorites) {
		this.favorites = favorites;
	}
	public String getRnakk() {
		return rank;
	}
	public void setRnakk(String rnakk) {
		this.rank = rnakk;
	}
	
	// -----------------------------------------------------------------------------
	// method
	// Secarch
	public void connSearch() {
		System.out.println("----------------------------");
		System.out.println("검색 페이지로이동");
		// new 메서드명();
	}

	// Check
	public void connCheck() {
		System.out.println("----------------------------");
		System.out.println("체크 페이지로이동");
	}

	// Help
	public void connHelp() {
		System.out.println("----------------------------");
		System.out.println("도움말 페이지로이동");
	}

	// Reservation
	public void connRsv() {
		System.out.println("----------------------------");
		System.out.println("예약 페이지로이동");
	}

	// Advertisement
	public void delAd() {
		System.out.println("----------------------------");
		System.out.println("광고 페이지로이동");

	}

	// 회원탈퇴
	public void delUser() {
		System.out.println("----------------------------");
		// db연동
		// 입력 받은 id값을 참고해서
		// String sql = "delete 테이블명 where = 'id' ";
		System.out.println("탈퇴");
	}
}	
