package ui;

import controller.OrderController;
import controller.ProductController;
import model.Order;
import model.Employee;
import model.Customer;
import model.Product;

import java.util.ArrayList;

/**
 * OrderMenu - class that creates order menu and
 * let user take some actions related to order.
 * @author Gabriel Pêdlowski
 */
public class OrderMenu {
	
	private OrderController orderController;
	private ProductController productController;
	
	/**
	 * Constructor for objects of OrderMenu.
	 */
	public OrderMenu() {
		orderController = new OrderController();
		productController = new ProductController();
	}
	
	/**
	 * Start the order menu.
	 */
	public void start() {
		boolean running = true;
        while(running) {
            int choice = writeOrderMenu();
            switch(choice) {
                case 1:
                    createOrder();
                    break;
                case 2:
                    printAllOrders();
                    break;
                case 3:
                	updateOrder();
                	break;
                case 4:
                	deleteOrder();
                	break;
                default:
                    running = false;
            }
        }
	}
	
	/**
	 * Print order menu.
	 * @return what user wants to do with order
	 */
	private int writeOrderMenu() {
		TextOptions menu = new TextOptions("\n ***** Order Menu *****", "Back");
		menu.addOption("Create order");
		menu.addOption("View orders");
		menu.addOption("Update order");
		menu.addOption("Delete order");
		
		return menu.prompt();
	}
	
	/**
	 * Create order.
	 */
	private void createOrder() {
		Employee employee = findEmployee();
		Customer customer = findCustomer();
		String deliveryDate = writeString("Enter delivery date: ");
		String status = writeString("Enter status of the order: ");
		Order createdOrder = orderController.addOrder(employee, customer, deliveryDate, status);
		if(createdOrder != null) { 
			System.out.println("Order created succesfully.");
			boolean keepAdding = true;
			while(keepAdding) {
				System.out.println("Add product");
				Product productToAdd = productController.getProduct(writeInt("Enter ID of the product: "));
				createdOrder.addProduct(productToAdd);
				String result = writeString("If you want to add next product enter Y, otherwise enter N.");
				if(result.equals("Y")) {
					keepAdding = true;
				} else {
					keepAdding = false;
					break;
				}
			}
		} else {
			System.out.println("Order was not created cuccesfully.");
		}
	}
	
	/**
	 * Print all existing orders.
	 */
	private void printAllOrders() {
		ArrayList<Order> orders = orderController.getAllOrders(); 
		if(orders.size() > 0) {
			for(int i = 0; i < orders.size(); i++) {
				System.out.println("Order [" + (i + 1) + "/" + orders.size() + "]:");
				orders.get(i).getInfo(); 
			}
		} else {
			System.out.println("There are no orders.");
		}
	}
	
	/**
	 * Update order.
	 */
	private void updateOrder() {
		int id = findOrder().getId();
		updateOrderById(id);
	}
	
	/**
	 * Update order with given ID.
	 * @param id
	 * @return true if order updated successfully
	 */
	private boolean updateOrderById(int id) {
		boolean retVal = false;
		
		if(checkIdValidity(id)) {
			if(updateFields(id)) {
				System.out.println("The update was succesful.");
				retVal = true;
			} else {
				System.out.println("The update was not succesful.");
			}
		} else {
			System.out.println("The ID of order is not correct...");
		}
		return retVal;
	}
	
	/**
	 * Delete order.
	 */
	private void deleteOrder() {
		int id = findOrder().getId();
		deleteOrderById(id);
	}
	
	/**
	 * Delete order with given ID.
	 * @param id
	 * @return true if order deleted successfully
	 */
	private boolean deleteOrderById(int id) {
		if(checkIdValidity(id)) {
			if(confirm()) {
				if(orderController.deleteOrder(id)) { 
					System.out.println("Deleted succesfully.");
					return true;
				}
			} else {
				System.out.println("Deletion was not succesful.");
				
			}
		}
		return false;
	}
	
	/**
	 * Take order ID from the user and find the order.
	 * @return order with the given id
	 */
	private Order findOrder() {	
		int id = writeInt("Enter order ID: ");
		Order order = orderController.getOrder(id);
		order.getInfo();
		return order;
	}
	
	/**
	 * Check if user is sure about the change e.g delete order.
	 * @return true if user choose "Yes"
	 */
	private boolean confirm() {
		boolean retVal = false;
		
		TextOptions menu = new TextOptions("\n Are you sure?", "Back");
		menu.addOption("Yes");
		menu.addOption("No");
		
		int choice = menu.prompt();
		
		switch(choice) {
			case 1:
				retVal = true;
				break;
			default:
				
		}
		return retVal;
	}
	
	/**
	 * Take new order details from user and update order with them.
	 * @param id
	 * @return true if order updated successfully
	 */
	private boolean updateFields(int id) {
		boolean retVal = false;
		Employee employee = findEmployee();
		Customer customer = findCustomer();
		String deliveryDate = writeString("Enter delivery date: ");
		if(deliveryDate.equals("")) {
			deliveryDate = orderController.getOrder(id).getDeliveryDate();
		}
		String status = writeString("Enter status of the order: ");
		if(status.equals("")) {
			status = orderController.getOrder(id).getStatus();
		}
		
		if(orderController.updateOrder(id, employee, customer, deliveryDate, status)) { 
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * Take employee ID from user and find the employee.
	 * @return employee with given id
	 */
	private Employee findEmployee() {
		Employee employee = orderController.findEmployee(writeInt("Enter employee ID: ")); 
		return employee;
	}
	
	/**
	 * Take customer ID from user and find the customer.
	 * @return customer with given id
	 */
	private Customer findCustomer() {
		Customer customer = orderController.findCustomer(writeInt("Enter customer ID: ")); 
		return customer;
	}
	
	/**
	 * Check if order with given id exist.
	 * @param id
	 * @return true if there is an order with given id
	 */
	private boolean checkIdValidity(int id) {
		boolean retVal = false;
		
		if(orderController.getOrder(id) != null) { 
			retVal = true;
		} else {
			System.out.println("There is no order with that ID.");
		}
		return retVal;
	}
	
	/**
	 * Write string input field.
	 * @param text
	 * @return input line
	 */
	private String writeString(String text) {
		String output = TextInput.inputString(text);
		return output;
	}
	
	/**
	 * Write int input field.
	 * @param number
	 * @return input line
	 */
	private int writeInt(String number) {
		int output = TextInput.inputNumber(number);
		return output;
	}
}
