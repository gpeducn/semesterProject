
/*	public Customer findCustomer(int id) {
		Customer customer = null;
		return customer;
	}
*/	

package controller;
import model.Customer;
import model.CustomerContainer;

public class CustomerController {
	
	private CustomerContainer customerContainer;
	
	public boolean addCustomer(String name, String phoneNumber, int zipCode, String address) {
		Customer cust = new Customer(name,phoneNumber,zipCode,address);
		return customerContainer.addCustomer(cust);
	}
	
	public boolean removeCustomer(String input) {
		return customerContainer.removeCustomer(search(input));
	}
	//update read !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	
	public Customer search(String input) {
		return customerContainer.searchCustomer(input);
	}
}
