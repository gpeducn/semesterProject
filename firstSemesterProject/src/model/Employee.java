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


	public void setThisId(int thisId) {
		this.thisId = thisId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void getInfo() {
		System.out.println("ID: " + thisId);
		System.out.println("Name: " + name);
		System.out.println("Position: " + position);
	}
	
	public int getId() {
		return thisId;
	}
}
