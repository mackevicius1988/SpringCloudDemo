package com.csc.reports.model;

public class UserInfo {

	private String id;
	private String name;
	private String position;
	private Adress address;

	public UserInfo(String id, String name, String position, Adress adress) {
		this.id = id;
		this.name = name;
		this.position = position;
		this.address = adress;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Adress getAddress() {
		return address;
	}

	public void setAddress(Adress address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
