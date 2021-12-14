package controller;

import java.util.ArrayList;

import model.Employee;
import model.EmployeeContainer;

/**
 * EmployeeController - class 
 * @author Gabriel Pêdlowski
 */
public class EmployeeController {
	
	public boolean addEmployee(String name, String position, String password) {
		Employee employee = new Employee(name, position, password);
		return EmployeeContainer.getInstance().addEmployee(employee);

	}
	
	public boolean deleteEmployee(int id) {
		return EmployeeContainer.getInstance().deleteEmployee(id);
	}
	
	public Employee getEmployee(int id) {
		return EmployeeContainer.getInstance().getEmployee(id);
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return EmployeeContainer.getInstance().getAllEmployees();
	}
	
	public boolean updateEmployee(int id, String name, String position, String password) {
		boolean retVal = false;
		ArrayList<Employee> employees = getAllEmployees();
		
		for(Employee element : employees) {
			if(element.getThisId() == id) {
				element.setName(name);
				element.setPosition(position);
				element.setPassword(password);
				
				retVal = true;
			}
		}
		return retVal;
	}
	
	
}