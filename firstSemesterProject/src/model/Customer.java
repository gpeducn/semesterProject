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
	
	public Customer(String name, String phoneNumber, String zipCode, String adress) {
		thisId = id++;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.adress = adress;
		registrationDate = LocalDate.now();
	}
	
	// TODO getters & setters
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
