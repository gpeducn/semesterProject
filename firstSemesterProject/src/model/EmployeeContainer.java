package model;

import java.util.ArrayList;

public class EmployeeContainer {
	
	private static EmployeeContainer instance;
	private ArrayList<Employee> employees;
	
	private EmployeeContainer() {
		employees = new ArrayList<>();
	}
	
	public static EmployeeContainer getInstance() {
		if(instance == null) {
			instance = new EmployeeContainer();
		}
		return instance;
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return employees;
	}
	
	public Employee getEmployee(int id) {
		Employee foundEmployee = null;
		for(Employee element : employees) {
			if(element.getId() == id) {
				foundEmployee = element;
			}
		}
		return foundEmployee;
	}
	
	public boolean addEmployee(Employee employee) {
		if(employee != null) {
			employees.add(employee);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deleteEmployee(int id) {
		return employees.removeIf(employee -> employee.getId() == id);
	}
	
}
