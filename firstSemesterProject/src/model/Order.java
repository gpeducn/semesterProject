package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class Order {

	private static int id;
	private ArrayList<Product> products;
	private Employee employee;
	private Customer customer;
	private LocalDate orderDate;
	private String deliveryDate;
	private String status;
	
	public Order() {
		
	}
	
	public Order(Employee employee, Customer customer, String deliveryDate, String status) {
		this.id += 1;
		products = new ArrayList<>();
		this.employee = employee;
		this.customer = customer;
		this.deliveryDate = deliveryDate;
		this.status = status;
		orderDate = LocalDate.now();
	}
	
	public void getInfo() {
		System.out.println("ID: " + id);
		System.out.println("Products: ");
		for(Product element : products) {
			element.getInfo();
		}
		System.out.println("Employee: " + employee);
		System.out.println("Customer: " + customer);
		System.out.println("Delivery date: " + deliveryDate);
		System.out.println("Status: "  + status);
		System.out.println("Order date: " + orderDate);
	}
	
	public void addProduct(Product product) {	
		products.add(product);
	}
	
	public int getId() {
		return id;
	}
	
	public ArrayList<Product> getProducts() {
		return products;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public String getDate() {
		return orderDate.toString();
	}
	
	public void updateDate() {
		orderDate = LocalDate.now();
	}
	
	public String getDeliveryDate() {
		return deliveryDate;
	}
	
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
