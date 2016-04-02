package com.csc.reports.model;

public class Adress {
	private String street;
	private String houseNo;
	private String city;

	public Adress(String street, String houseNo, String city) {
		super();
		this.street = street;
		this.houseNo = houseNo;
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Override
	public String toString() {
		return street + " " + houseNo + ", " + city;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
