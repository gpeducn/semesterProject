package controller;

import model.Customer;
import model.CustomerContainer;

public class CustomerController {
	
	private CustomerContainer customerContainer;
	
	public boolean addCustomer(String name, String phoneNumber, String zipCode, String address) {
		Customer cust = new Customer(name,phoneNumber,zipCode,address);
		return customerContainer.addCustomer(cust);
	}
	
	public boolean removeCustomer(int input) {
		return customerContainer.removeCustomer(customerContainer.getCustomer(input));
	}
	//update read !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public Customer search(int input) {
		return customerContainer.getCustomer(input);
	}
}

/*	public Customer findCustomer(int id) {
		Customer customer = null;
		return customer;
	}
*/	
