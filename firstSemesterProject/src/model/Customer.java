package model;

import java.time.LocalDate;

public class Customer {

	private static int id;
	private String name;
	private String phoneNumber;
	private String zipCode;
	private String adress;
	private LocalDate registrationDate;
	
	public Customer(String name, String phoneNumber, String zipCode, String adress) {
		this.id += 1;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.adress = adress;
		registrationDate = LocalDate.now();
	}
	
	// TODO getters & setters
	public int getId() {
		return id;
	}
}
