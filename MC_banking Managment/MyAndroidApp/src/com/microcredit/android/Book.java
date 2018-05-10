package com.microcredit.android;

public class Book {
	private String acc;
	private String date;
	private String name;
	private String phone;
	private String nid;
	private String occupation;
	private String address;
	private Book() {

	}

	public Book(String acc, String date, String name, String phone,
			String nid, String occupation, String address) {
		super();
		this.acc = acc;
		this.date = date;
		this.name = name;
		this.phone = phone;
		this.nid= nid;
		this.occupation = occupation ;
		this.address = address ;
	}

	public String getAcc() {
		return acc;
	}

	public void setAcc(String acc) {
		this.acc = acc;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name ;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}
	
	public String getOccupation() {
		return occupation;
	}

	public void setOccuaption(String occupation) {
		this.occupation = occupation;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
