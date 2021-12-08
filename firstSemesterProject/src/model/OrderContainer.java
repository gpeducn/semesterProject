package model;

import java.util.ArrayList;

public class OrderContainer {

	private static OrderContainer instance;
	private ArrayList<Order> orders;
	
	private OrderContainer() {
		orders = new ArrayList<>();
	}
	
	public static OrderContainer getInstance() {
		if(instance == null) {
			instance = new OrderContainer();
		}
		return instance;
	}
	
	public ArrayList<Order> getAllOrders() {
		return orders;
	}
	
	public Order getOrder(int id) {
		Order foundOrder = new Order();
		for(Order element : orders) {
			if(element.getId() == id) {
				foundOrder = element;
			}
		}
		return foundOrder;
	}
	
	public boolean addOrder(Order order) {
		orders.add(order);
		return true;
	}
	
	public boolean deleteOrder(int id) {
		return orders.removeIf(order -> order.getId() == id);
	}
}
