package model;

import java.time.LocalDate;

public class Customer {

	private static int id;
	private int thisId;
	private String name;
	private String phoneNumber;
	private String zipCode;
	private String adress;
	private LocalDate registrationDate;
	
	public int getThisId() {
		return thisId;
	}

	public void setThisId(int thisId) {
		this.thisId = thisId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Customer(String name, String phoneNumber, String zipCode, String adress) {
		thisId = id++;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.adress = adress;
		registrationDate = LocalDate.now();
	}
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public void getInfo() {
		System.out.println("ID: " + thisId);
		System.out.println("Name: " + name);
		System.out.println("Phone number: " + phoneNumber);
		System.out.println("Zipcode: " + zipCode);
		System.out.println("Adress: " + adress);
		System.out.println("Registration date: " + registrationDate);
	}
	
	public int getId() {
		return thisId;
	}
}
