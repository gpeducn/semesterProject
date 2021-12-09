package controller;

import model.Customer;
import model.CustomerContainer;
import model.Employee;
import model.EmployeeContainer;

public class EmployeeController {
	
	public boolean addEmployee(String name, String position, String password) {
		Employee employee = new Employee(name, position, password);
		return EmployeeContainer.getInstance().addEmployee(employee);

	}
	
	public boolean deleteCustomer(int id) {
		return CustomerContainer.getInstance().deleteCustomer(id);
	}
	
	public Employee findEmployee(int id) {
		return EmployeeContainer.getInstance().getEmployee(id);
	}
	
	//TODO updateEmployee()
}