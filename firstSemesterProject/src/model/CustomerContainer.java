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
		Customer foundCustomer = null;
		for(Customer element : customers) {
			if(element.getId() == id) {
				foundCustomer = element;
			}
		}
		return foundCustomer;
	}
	
	public  boolean removeCustomer(Customer customer) {
		return customers.remove(customer);
	}
	//implement update and read !!!!!!!!!!!!!!!!!!!!!
	
//	public Customer searchCustomer(String inputVal) {
//		Customer returnCustomer = null;
//		for (Customer val : customers) {
//			if(val.getPhoneNumber() == inputVal) {
//				returnCustomer = customer;
//			}
//		
//		}
//		return returnCustomer;
//	}
}

