package controller;

import model.Contractor;
import model.Customer;
import model.CustomerContainer;
//import model.Contractor;
//import model.PrivateCustomer;
import model.PrivateCustomer;

import java.util.ArrayList;

/**
 * CustomerController - class 
 * @author Gabriel P?dlowski
 */
public class CustomerController {
	
	public boolean addCustomer(String name, String phoneNumber, String zipcode, String address,int discount) {
		Customer customer;
		if(discount == - 1) {
		customer = new PrivateCustomer(name,phoneNumber,zipcode,address);}
		else {
			customer = new Contractor(name,phoneNumber,zipcode,address,discount);
		}
		return CustomerContainer.getInstance().addCustomer(customer);
	}
	
	public boolean deleteCustomer(int id) {
		return CustomerContainer.getInstance().deleteCustomer(id);
	}
	
	public Customer findCustomer(int id) {
		return CustomerContainer.getInstance().getCustomer(id);
	}
	
	public ArrayList<Customer> getAllCustomers(){
		return CustomerContainer.getInstance().getAllCustomers();
	}
	
	public boolean updateCustomer(int id,String name,String phoneNumber, String zipcode, String address) {
		boolean retVal = false;
		ArrayList<Customer> customers = getAllCustomers();
		
		for(Customer element : customers) {
			if(element.getThisId() == id) {
				element.setName(name);
				element.setPhoneNumber(phoneNumber);
				element.setZipcode(zipcode);
				element.setAdress(address);
				
				retVal = true;
			}
		}
		return retVal;
	}


}