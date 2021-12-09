package model;

import java.util.ArrayList;

public class EmployeeContainer {
	private Employee employee;;
	private  CustomerContainer stEmployee;
	private ArrayList<Employee> employees;
	
	public ArrayList getInstane() {
		return employees;
	}
	
	public boolean addEmployee(Employee employee) {
		return employees.add(employee);
	}
	
	public boolean removeEmployee(String name) {
		return employees.remove(employee);
	}
	
	//implement read, update, search

	public void xd() {
		System.out.println("xd");
	}
}
