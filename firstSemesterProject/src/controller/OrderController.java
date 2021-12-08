package controller;

import model.OrderContainer;
import model.Order;
import model.Employee;
import model.Customer;
import model.Product;

import java.util.ArrayList;

public class OrderController {
	
	public OrderController() {
		
	}
	
	public boolean addProductToOrder(int orderId, Product product) {
		Order foundOrder = getOrder(orderId);
		foundOrder.addProduct(product);
		return true;
	}
	
	public Order addOrder(Employee employee, Customer customer, String deliveryDate, String status) {
		Order newOrder = new Order(employee, customer, deliveryDate, status);
		OrderContainer.getInstance().addOrder(newOrder);
		return newOrder;
	}
	
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = OrderContainer.getInstance().getAllOrders();
		return orders;
	}
	
	public boolean deleteOrder(int id) {
		return OrderContainer.getInstance().deleteOrder(id);
	}
	
	public boolean updateOrder(int id, Employee employee, Customer customer, String deliveryDate, String status) {
		boolean retVal = false;
		ArrayList<Order> orders = getAllOrders();
		
		for(Order element : orders) {
			if(element.getId() == id) {
				element.setEmployee(employee);
				element.setCustomer(customer);
				element.setDeliveryDate(deliveryDate);
				element.setStatus(status);
				element.updateDate();
				
				retVal = true;
			}
		}
		
		return retVal;
	}
	
	public Employee findEmployee(int id) {
		EmployeeController employeeController = new EmployeeController();
		
		Employee foundEmployee = employeeController.findEmployee(id); // need to add findEmployee(String name) to EmployeeController
		return foundEmployee;
	}
	
	public Customer findCustomer(String phoneNumber) {
		CustomerController customerController = new CustomerController();
		
		Customer foundCustomer = customerController.search(phoneNumber); // need to add findCustomer(String name) to CustomerController
		return foundCustomer;
	}
	
	public Order getOrder(int id) {
		Order foundOrder = OrderContainer.getInstance().getOrder(id);
		return foundOrder;
	}
}
