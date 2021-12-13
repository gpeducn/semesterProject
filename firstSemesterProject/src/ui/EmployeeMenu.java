package ui;

import java.util.ArrayList;

import controller.EmployeeController;
import model.Customer;
import model.Employee;
import model.Order;

public class EmployeeMenu {
	
	private EmployeeController employeeController;
	
	/**
	 * Constructor for objects of EmployeeMenu.
	 */
	public EmployeeMenu() {
		employeeController = new EmployeeController();
	}
	
	/**
	 * Start the employee menu.
	 */
	public void start() {
		boolean running = true;
		while(running) {
			int choice = writeEmployeeMenu();
			switch(choice) {
				case 1:
					createEmployee();
					break;
				case 2:
					printAllEmployees();
					break;
				case 3:
					updateEmployee();
					break;
				case 4:
					deleteEmployee();
					break;
				default:
					running = false;
			}
		}
	}
	
	/**
	 * Print employee menu.
	 * @return what user wants to do with employee
	 */
	public int writeEmployeeMenu() {
		TextOptions menu = new TextOptions("\n ***** Employee Menu *****", "Back");
		menu.addOption("Create employee");
		menu.addOption("Show all employees");
		menu.addOption("Update employee");
		menu.addOption("Delete employee");
		
		return menu.prompt();
	}
	
	/**
	 * Create employee.
	 */
	public void createEmployee() {
		String name = writeString("Enter employee name: ");
		String position = writeString("Enter employee position: ");
		String password = writeString("Enter employee password: ");
		employeeController.addEmployee(name, position, password);
	}
	
	/**
	 * Print all existing employees.
	 */
	public void printAllEmployees() {
		ArrayList<Employee> employees = employeeController.getAllEmployees();
		if(employees.size() > 0) {
			for(int i = 0; i < employees.size(); i++) {
				System.out.println("Employee [" + (i + 1) + "/" + employees.size() + "]:");
				employees.get(i).getInfo(); 
			}
		} else {
			System.out.println("There are no employees.");
		}
	}
	
	/**
	 * Update employee.
	 */
	private void updateEmployee() {
		int id = findEmployee().getId();
		updateEmployeeById(id);
	}
	
	/**
	 * Update employee with given ID.
	 * @param id
	 * @return true if employee updated successfully
	 */
	private boolean updateEmployeeById(int id) {
		boolean retVal = false;
		
		if(checkIdValidity(id)) {
			if(updateFields(id)) {
				System.out.println("The update was succesful.");
				retVal = true;
			} else {
				System.out.println("The update was not succesful.");
			}
		} else {
			System.out.println("The ID of employee is not correct...");
		}
		return retVal;
	}
	
	/**
	 * Delete employee.
	 */
	private void deleteEmployee() {
		int id = findEmployee().getId();
		deleteEmployeeById(id);
	}
	
	/**
	 * Delete employee with given ID.
	 * @param id
	 * @return true if employee deleted successfully
	 */
	private boolean deleteEmployeeById(int id) {
		if(checkIdValidity(id)) {
			if(confirm()) {
				if(employeeController.deleteEmployee(id)) { 
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
	 * Take employee ID from the user and find the employee.
	 * @return employee with the given id
	 */
	private Employee findEmployee() {	
		int id = writeInt("Enter employee ID: ");
		Employee employee = employeeController.getEmployee(id);
		employee.getInfo();
		return employee;
	}
	
	/**
	 * Check if user is sure about the change e.g delete employee.
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
	 * Take new employee info from user and update employee with it.
	 * @param id
	 * @return true if employee updated successfully
	 */
	private boolean updateFields(int id) {
		boolean retVal = false;
		String name = writeString("Enter employee name: ");
		String position = writeString("Enter employee position: ");
		String password = writeString("Enter employee password: ");
		if(name.equals("")) {
			name = employeeController.getEmployee(id).getName();
		}
		if(position.equals("")) {
			position = employeeController.getEmployee(id).getPosition();
		}
		if(password.equals("")) {
			password = employeeController.getEmployee(id).getPassword();
		}
		
		if(employeeController.updateEmployee(id, name, position, password)) { 
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * Check if employee with given id exist.
	 * @param id
	 * @return true if there is an employee with given id
	 */
	private boolean checkIdValidity(int id) {
		boolean retVal = false;
		
		if(employeeController.getEmployee(id) != null) { 
			retVal = true;
		} else {
			System.out.println("There is no employee with that ID.");
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
 