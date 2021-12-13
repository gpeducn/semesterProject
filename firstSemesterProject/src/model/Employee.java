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
	
	public int getThisId() {
		return thisId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void getInfo() {
		System.out.println("ID: " + thisId);
		System.out.println("Name: " + name);
		System.out.println("Position: " + position);
	}
}
