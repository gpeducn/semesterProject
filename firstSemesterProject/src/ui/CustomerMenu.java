package ui;

import java.util.ArrayList;

import controller.CustomerController;
import model.Customer;

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
					createCustomer();
					break;
				case 2:
					printAllCustomers();
					break;
				case 3:
					updateCustomer();
					break;
				case 4:
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
		menu.addOption("Create customer");
		menu.addOption("Show all customers");
		menu.addOption("Update customer");
		menu.addOption("Delete customer");
		
		return menu.prompt();
	}
	
	/**
	 * Create customer.
	 */
	public void createCustomer() {
		String name = writeString("Enter customer name: ");
		String phoneNumber = writeString("Enter customer phone number: ");
		String zipcode = writeString("Enter customer zipcode: ");
		String adress = writeString("Enter customer adress: ");
		customerController.addCustomer(name, phoneNumber, zipcode, adress);
	}
	
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
	 * Update employee.
	 */
	private void updateCustomer() {
		int id = findCustomer().getId();
		updateCustomerById(id);
	}
	
	/**
	 * Update customer with given ID.
	 * @param id
	 * @return true if customer updated successfully
	 */
	private boolean updateCustomerById(int id) {
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
	private void deleteCustomer() {
		int id = findCustomer().getId();
		deleteCustomerById(id);
	}
	
	/**
	 * Delete customer with given ID.
	 * @param id
	 * @return true if customer deleted successfully
	 */
	private boolean deleteCustomerById(int id) {
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
	private Customer findCustomer() {	
		int id = writeInt("Enter customer ID: ");
		Customer customer = customerController.findCustomer(id);
		customer.getInfo();
		return customer;
	}
	
	/**
	 * Check if user is sure about the change e.g delete customer.
	 * @return true if user choose "Yes"
	 */
	private boolean confirm() {
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
	private boolean updateFields(int id) {
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
	private boolean checkIdValidity(int id) {
		boolean retVal = false;
		
		if(customerController.findCustomer(id) != null) { 
			retVal = true;
		} else {
			System.out.println("There is no customer with that ID.");
		}
		return retVal;
	}
	
	/**
	 * Write string input field.
	 * @param text
	 * @return input line
	 */
	private String writeString(String text) {
		String output = TextInput.inputString(text);
		return output;
	}
	
	/**
	 * Write int input field.
	 * @param number
	 * @return input line
	 */
	private int writeInt(String number) {
		int output = TextInput.inputNumber(number);
		return output;
	}
	
}
 