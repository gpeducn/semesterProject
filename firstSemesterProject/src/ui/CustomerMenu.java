package ui;

import java.util.ArrayList;

import controller.CustomerController;
import model.Customer;

/**
 * CustomerMenu - class that creates customer menu and
 * let user take some actions related to customer.
 * @author Gabriel Pêdlowski
 */
public class CustomerMenu {
	
	private CustomerController customerController;
	
	/**
	 * Constructor for objects of CustomerMenu.
	 */
	public CustomerMenu() {
		customerController = new CustomerController();
	}
	
	/**
	 * Start the customer menu.
	 */
	public void start() {
		boolean running = true;
		while(running) {
			int choice = writeCustomerMenu();
			switch(choice) {
				case 1:
					createPrivateCustomer();
					break;
				case 2:
					createContractor();
					break;
				case 3:
					printAllCustomers();
					break;
				case 4:
					updateCustomer();
					break;
				case 5:
					deleteCustomer();
					break;
				default:
					running = false;
			}
		}
	}
	
	/**
	 * Print customer menu.
	 * @return what user wants to do with employee
	 */
	public int writeCustomerMenu() {
		TextOptions menu = new TextOptions("\n ***** Customer Menu *****", "Back");
		menu.addOption("Create private customer");
		menu.addOption("Create contractor");
		menu.addOption("Show all customers");
		menu.addOption("Update customer");
		menu.addOption("Delete customer");
		
		return menu.prompt();
	}
	
	/**
	 * Create private customer.
	 */
	public void createPrivateCustomer() {
		String name = writeString("Enter customer name: ");
		String phoneNumber = writeString("Enter customer phone number: ");
		String zipcode = writeString("Enter customer zipcode: ");
		String adress = writeString("Enter customer adress: ");
		customerController.addCustomer(name, phoneNumber, zipcode, adress,-1);
	}
	
	public void createContractor() {
		String name = writeString("Enter contractor name: ");
		String phoneNumber = writeString("Enter contractor phone number: ");
		String zipcode = writeString("Enter contractor zipcode: ");
		String adress = writeString("Enter contractor adress: ");
		int discount = writeInt("Enter contractor discount: ");
		customerController.addCustomer(name, phoneNumber, zipcode, adress,discount);
	}
	
	/**
	
	/**
	 * Print all existing customers.
	 */
	public void printAllCustomers() {
		ArrayList<Customer> customers = customerController.getAllCustomers();
		if(customers.size() > 0) {
			for(int i = 0; i < customers.size(); i++) {
				System.out.println("Customer [" + (i + 1) + "/" + customers.size() + "]:");
				customers.get(i).getInfo();
			}
		} else {
			System.out.println("There are no customers.");
		}
	}
	
	/**
	 * Update customer.
	 */
	public void updateCustomer() {
		try {
			int id = findCustomer().getThisId();
			updateCustomerById(id);
		} catch(NullPointerException e) {
			
		}
	}
	
	/**
	 * Update customer with given ID.
	 * @param id
	 * @return true if customer updated successfully
	 */
	public boolean updateCustomerById(int id) {
		boolean retVal = false;
		
		if(checkIdValidity(id)) {
			if(updateFields(id)) {
				System.out.println("The update was succesful.");
				retVal = true;
			} else {
				System.out.println("The update was not succesful.");
			}
		} else {
			System.out.println("The ID of customer is not correct...");
		}
		return retVal;
	}
	
	/**
	 * Delete customer.
	 */
	public void deleteCustomer() {
		int id = findCustomer().getThisId();
		deleteCustomerById(id);
	}
	
	/**
	 * Delete customer with given ID.
	 * @param id
	 * @return true if customer deleted successfully
	 */
	public boolean deleteCustomerById(int id) {
		if(checkIdValidity(id)) {
			if(confirm()) {
				if(customerController.deleteCustomer(id)) { 
					System.out.println("Deleted succesfully.");
					return true;
				}
			} else {
				System.out.println("Deletion was not succesful.");
			}
		}
		return false;
	}
	
	/**
	 * Take customer ID from the user and find the customer.
	 * @return customer with the given id
	 */
	public Customer findCustomer() {	
		int id = writeInt("Enter customer ID: ");
		Customer customer = null;
		if(checkIdValidity(id)) {
			customer = customerController.findCustomer(id);
			customer.getInfo();
		} else {
			updateCustomer();
		}
		return customer;
	}
	
	/**
	 * Check if user is sure about the change e.g delete customer.
	 * @return true if user choose "Yes"
	 */
	public boolean confirm() {
		boolean retVal = false;
		
		TextOptions menu = new TextOptions("\n Are you sure?", "Back");
		menu.addOption("Yes");
		menu.addOption("No");
		
		int choice = menu.prompt();
		
		switch(choice) {
			case 1:
				retVal = true;
				break;
			default:
				
		}
		return retVal;
	}
	
	/**
	 * Take new customer info from user and update customer with it.
	 * @param id
	 * @return true if customer updated successfully
	 */
	public boolean updateFields(int id) {
		boolean retVal = false;
		String name = writeString("Enter customer name: ");
		String phoneNumber = writeString("Enter customer phone number: ");
		String zipcode = writeString("Enter customer zipcode: ");
		String adress = writeString("Enter customer adress: ");
		if(name.equals("")) {
			name = customerController.findCustomer(id).getName();
		}
		if(phoneNumber.equals("")) {
			phoneNumber = customerController.findCustomer(id).getPhoneNumber();
		}
		if(zipcode.equals("")) {
			zipcode = customerController.findCustomer(id).getZipcode();
		}
		if(adress.equals("")) {
			adress = customerController.findCustomer(id).getAdress();
		}
		
		if(customerController.updateCustomer(id, name, phoneNumber, zipcode, adress)) { 
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * Check if customer with given id exist.
	 * @param id
	 * @return true if there is an customer with given id
	 */
	public boolean checkIdValidity(int id) {
		boolean retVal = false;
		
		if(customerController.findCustomer(id).getThisId() == id) { 
			retVal = true;
		} else {
			System.out.println("There is no customer with that ID, try again!");
		}
		return retVal;
	}
	
	/**
	 * Write string input field.
	 * @param text
	 * @return input line
	 */
	public String writeString(String text) {
		String output = TextInput.inputString(text);
		return output;
	}
	
	/**
	 * Write int input field.
	 * @param number
	 * @return input line
	 */
	public int writeInt(String number) {
		int output = TextInput.inputNumber(number);
		return output;
	}
	
}
 