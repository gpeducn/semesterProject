package model;

public class Employee {

	private static int id;
	private int thisId;
	private String name;
	private String position;
	private String password;
	
	public Employee(String name, String position, String password) {
		thisId = id++;
		this.name = name;
		this.position = position;
		this.password = password;
	}
	
	// TODO getters & setters
	public void getInfo() {
		System.out.println("ID: " + thisId);
		System.out.println("Name: " + name);
		System.out.println("Position: " + position);
	}
	
	public int getId() {
		return thisId;
	}
}
