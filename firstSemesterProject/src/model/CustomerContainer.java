package model;
import java.util.ArrayList;
public class CustomerContainer {	
	
	private Customer customer;
	private  CustomerContainer stCustomer;
	private ArrayList<Customer> customers;
	private CustomerContainer() {
	}
	public ArrayList getInstance(){
		return customers;
	}
	public boolean addCustomer(Customer customer) {
		return customers.add(customer);
	}
	public  boolean removeCustomer(Customer customer) {
		return customers.remove(customer);
	}
	//implement update and read !!!!!!!!!!!!!!!!!!!!!
	
	public Customer searchCustomer(String inputVal) {
		Customer returnCustomer = null;
		for (Customer val : customers) {
			if(val.getPhoneNumber() == inputVal) {
				returnCustomer = customer;
			}
		
		}
		return returnCustomer;
	}
}

