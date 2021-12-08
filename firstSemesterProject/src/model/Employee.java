package model;

public class Employee {

	private static int id;
	private String name;
	private String position;
	private String password;
	
	public Employee(String name, String position, String password) {
		this.id += 1;
		this.name = name;
		this.position = position;
		this.password = password;
	}
	
	// TODO getters & setters
}
