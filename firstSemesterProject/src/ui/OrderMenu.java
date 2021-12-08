package ui;

import controller.OrderController;
import controller.ProductController;
import model.OrderContainer;
import model.Order;
import model.Employee;
import model.Contractor;
import model.Customer;
import model.Product;

import java.util.ArrayList;

public class OrderMenu {
	
	private OrderController orderController;
	private ProductController productController;
	
	public OrderMenu() {
		orderController = new OrderController();
		productController = new ProductController();
	}
	
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
	
	private int writeOrderMenu() {
		TextOptions menu = new TextOptions("\n ***** Order Menu *****", "Back");
		menu.addOption("Create order");
		menu.addOption("View orders");
		menu.addOption("Update order");
		menu.addOption("Delete order");
		
		int choice = menu.prompt();
		return choice;
	}
	
	private void createOrder() {
		Employee employee = findEmployee();
		Customer customer = findCustomer();
		String deliveryDate = writeString("Enter delivery date: ");
		String status = writeString("Enter status of the order: ");
		Order createdOrder = orderController.addOrder(employee, customer, deliveryDate, status);
		if(createdOrder != 

				) { 
			System.out.println("Order created succesfully.");
			boolean keepAdding = true;
			while(keepAdding) {
				String result = writeString("To cancel adding products to the order press N");
				if(result.equals("N")) {
					keepAdding = false;
					break;
				}
				Product product = findProduct();
				orderController.addProductToOrder(createdOrder.getId(), product);
			}
		} else {
			System.out.println("Order was not created cuccesfully.");
		}
	}
	
	private void printAllOrders() {
		ArrayList<Order> orders = orderController.getAllOrders(); 
		if(orders.size() > 0) {
			for(int i = 0; i < orders.size(); i++) {
				System.out.println("Order [" + (i + 1) + "/" + orders.size() + "]:");
				System.out.println(orders.get(i).getInfo()); 
			}
		} else {
			System.out.println("There are no orders.");
		}
	}
	
	private void updateOrder() {
		int id = findOrder().getId();
		updateOrderById(id);
	}
	
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
	
	private void deleteOrder() {
		int id = findOrder().getId();
		deleteOrderById(id);
	}
	
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
	
	private Order findOrder() {	
		int id = writeInt("Enter order ID: ");
		Order order = orderController.getOrder(id);
		System.out.println(order.getInfo());
		return order;
	}
	
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
			retVal = false;
		}
		return retVal;
	}
	
	private boolean updateFields(int id) {
		boolean retVal = false;
		Employee employee = findEmployee();
		Customer customer = findCustomer();
		String deliveryDate = writeString("Enter delivery date: ");
		String status = writeString("Enter status of the order: ");
		
		if(orderController.updateOrder(id, employee, customer, deliveryDate, status)) { 
			retVal = true;
		}
		return retVal;
	}
	
	private Employee findEmployee() {
		Employee employee = orderController.findEmployee(writeInt("Enter employee ID: ")); 
		return employee;
	}
	
	private Customer findCustomer() {
		Customer customer = orderController.findCustomer(writeInt("Enter customer ID: ")); 
		return customer;
	}
	
	private Product findProduct() {
		String productId = writeString("Enter product ID: ");
		Product product = productController.getProductById(Integer.valueOf(productId));
		
		return product;
	}
	
	private boolean checkIdValidity(int id) {
		boolean retVal = false;
		int foundId;
		
		if(orderController.getOrder(id) != null) { 
			foundId = orderController.getOrder(id).getInfo(); 
			
			System.out.println("Found: " + foundId + "a");
			retVal = true;
		} else {
			System.out.println("There is no order with that ID.");
		}
		return retVal;
	}
	
	private String writeString(String text) {
		String output = TextInput.inputString(text);
		return output;
	}
	
	private int writeInt(String number) {
		int output = TextInput.inputNumber(number);
		return output;
	}
}
