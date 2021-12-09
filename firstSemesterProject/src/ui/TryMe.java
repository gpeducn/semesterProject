package ui;

import java.util.ArrayList;

import model.*;

public class TryMe {

	private Category category1;
	private Category category2;
	
	private Customer customer1;
	private Customer customer2;
	
	private Employee employee1;
	private Employee employee2;
	
	private Product product1;
	private Product product2;
	
	private Order order1;
	private Order order2;
	
	public TryMe() {
		
	}
	
	public void newData() {
		category1 = new Category("Garden tools");
		category2 = new Category("Furnitures");
		
		CategoryContainer.getInstance().addCategory(category1);
		CategoryContainer.getInstance().addCategory(category2);
		
		customer1 = new Customer("Big Boss", "123456789", "59-100", "Aalborg 12");
		customer2 = new Customer("Small Boss", "918273912", "50192", "Copenhagen 29A");
		
		CustomerContainer.getInstance().addCustomer(customer1);
		CustomerContainer.getInstance().addCustomer(customer2);
		
		employee1 = new Employee("Good Employee", "Warehouse Boi", "qwerty123");
		employee2 = new Employee("Bad Employee", "Sales Assistant", "akushSdd123bua6sd");
		
		EmployeeContainer.getInstance().addEmployee(employee1);
		EmployeeContainer.getInstance().addEmployee(employee2);
		
		product1 = new Product("Paint");
		product2 = new Product("Machine???");
		
		ProductContainer.getInstance().addProduct(product1);
		ProductContainer.getInstance().addProduct(product2);
		
		order1 = new Order(employee1, customer1, "yesterday", "delivered");
		order2 = new Order(employee2, customer2, "today", "sent");
		
		OrderContainer.getInstance().addOrder(order1);
		OrderContainer.getInstance().addOrder(order2);
	}
	
	public void printData() {
        ArrayList<Category> categories = CategoryContainer.getInstance().getAllCategories();    
        ArrayList<Customer> customers = CustomerContainer.getInstance().getAllCustomers();
        ArrayList<Employee> employees = EmployeeContainer.getInstance().getAllEmployees();
        ArrayList<Product> products = ProductContainer.getInstance().getAllProducts();
        ArrayList<Order> orders = OrderContainer.getInstance().getAllOrders();

        System.out.println("*** Categories in the container: ***");
        for(Category element : categories) {
        	System.out.println(element.getCategory());
        }

        System.out.println("*** Customers in the container: ***");
        for(Customer element : customers) {
        	element.getInfo();
        }
        
        System.out.println("*** Employees in the container: ***");
        for(Employee element : employees) {
        	element.getInfo();
        }
        
        System.out.println("*** Products in the container: ***");
        for(Product element : products) {
        	element.getInfo();
        }
        
        System.out.println("*** Orders in the container: ***");
        for(Order element : orders) {
            element.getInfo();
        }
    }
}
