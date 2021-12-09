package model;

import java.util.ArrayList;

public class CustomerContainer {	
	
	private static CustomerContainer instance;
	private ArrayList<Customer> customers;
	
	private CustomerContainer() {
		customers = new ArrayList<>();
	}
	
	public static CustomerContainer getInstance() {
		if(instance == null) {
			instance = new CustomerContainer();
		}
		return instance;
	}
	
	public ArrayList<Customer> getAllCustomers() {
		return customers;
	}
	
	public Customer getCustomer(int id) {
		Customer foundCustomer = new Customer();
		for(Customer element : customers) {
			if(element.getId() == id) {
				foundCustomer = element;
			}
		}
		return foundCustomer;
	}
	
	public boolean addCustomer(Customer customer) {
		if(customer != null) {
			customers.add(customer);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteCustomer(int id) {
		return customers.removeIf(customer -> customer.getId() == id);
	}
	
	
}

