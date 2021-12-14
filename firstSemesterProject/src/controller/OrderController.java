package controller;

import model.OrderContainer;
import model.Order;
import model.Employee;
import model.Customer;
import model.Product;

import java.util.ArrayList;

/**
 * OrderController - class 
 * @author Gabriel Pêdlowski
 */
public class OrderController {
	
	public OrderController() {
		
	}
	
	/**
	 * Add product to order.
	 * @param orderId
	 * @param product
	 * @return true
	 */
	public boolean addProductToOrder(int orderId, Product product) {
		Order foundOrder = getOrder(orderId);
		foundOrder.addProduct(product);
		return true;
	}
	
	/**
	 * Add order to the list of orders.
	 * @param employee
	 * @param customer
	 * @param deliveryDate
	 * @param status
	 * @return order 
	 */
	public Order addOrder(Employee employee, Customer customer, String deliveryDate, String status) {
		Order newOrder = new Order(employee, customer, deliveryDate, status);
		OrderContainer.getInstance().addOrder(newOrder);
		return newOrder;
	}
	
	/**
	 * Get all existing orders.
	 * @return list of orders
	 */
	public ArrayList<Order> getAllOrders() {
		ArrayList<Order> orders = OrderContainer.getInstance().getAllOrders();
		return orders;
	}
	
	/**
	 * Delete order.
	 * @param id
	 * @return true if order deleted successfully
	 */
	public boolean deleteOrder(int id) {
		return OrderContainer.getInstance().deleteOrder(id);
	}
	
	/**
	 * Update order.
	 * @param id
	 * @param employee
	 * @param customer
	 * @param deliveryDate
	 * @param status
	 * @return true if order updated successfully
	 */
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
	
	/**
	 * Find employee with given ID.
	 * @param id
	 * @return employee with given id
	 */
	public Employee findEmployee(int id) {
		EmployeeController employeeController = new EmployeeController();
		
		Employee foundEmployee = employeeController.getEmployee(id);
		return foundEmployee;
	}
	
	/**
	 * Find customer with given ID.
	 * @param id
	 * @return product with given id 
	 */
	public Customer findCustomer(int id) {
		CustomerController customerController = new CustomerController();
		
		Customer foundCustomer = customerController.findCustomer(id);
		return foundCustomer;
	}
	
	/**
	 * Get order with given ID.
	 * @param id
	 * @return order with given id
	 */
	public Order getOrder(int id) {
		Order foundOrder = OrderContainer.getInstance().getOrder(id);
		return foundOrder;
	}
}
