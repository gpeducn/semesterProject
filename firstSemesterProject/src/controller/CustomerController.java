package controller;

import model.Customer;
import model.CustomerContainer;

public class CustomerController {
	
	
	public boolean addCustomer(String name, String phoneNumber, String zipCode, String address) {
		Customer customer = new Customer(name,phoneNumber,zipCode,address);
		return CustomerContainer.getInstance().addCustomer(customer);
	}
	
	public boolean deleteCustomer(int id) {
		return CustomerContainer.getInstance().deleteCustomer(id);
	}
	
	public Customer findCustomer(int id) {
		return CustomerContainer.getInstance().getCustomer(id);
	}
	
	//TODO updateCustomer()
}