package controller;

import model.Employee;
import model.EmployeeContainer;

public class EmployeeController {
	
	public boolean addEmployee(int id, String name, String position, String password) {
		Employee emp = new Employee(id, name, position, password);
		return EmployeeContainer.addEmployee(emp);

	}
	
	public boolean removeEmployee(String employee) {
		return EmployeeContainer.removeEmployee(search(input));
	}
	
	
	public Employee searchEmployee(String employee) {
		return EmployeeContainer.searchEmployee(input);

	}
	
	//implement update, read
	
	
	public Employee findEmployee(int id) {
		Employee employee = null;
		return employee;
	}
}