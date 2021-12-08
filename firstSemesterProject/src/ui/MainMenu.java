package ui;

/**
 * @author brynjar
 *
 */

public class MainMenu {

	private CustomerMenu customerMenu;
	private ProductMenu productMenu;
	private OrderMenu orderMenu;
	private EmployeeMenu employeeMenu;

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.start();
}
	
	public MainMenu() {
		customerMenu = new CustomerMenu();
		productMenu = new ProductMenu();
		orderMenu = new OrderMenu();
		employeeMenu = new EmployeeMenu();
	}

	public void start() {
		boolean exit = false;
		while (!exit) {
			int choice = writeMainMenu();
			if (choice == 1) {
				orderMenu.start();
			} 
			else if (choice == 2) {
				//customerMenu.start();
			} else if (choice == 3) {
				//productMenu.start();
			} else if (choice == 4) {
				orderMenu.start();
			} else if (choice == 5) {
				//employeeMenu.start();
			} else {
				writeEnd();
				exit = true;
			}
		}
	}
	
	private int writeMainMenu() {
		TextOptions menu = new TextOptions("\n ***Main menu***", "Quit the program");
		menu.addOption("Contractor menu");
		menu.addOption("Customer menu");
		menu.addOption("Product menu");
		menu.addOption("Order menu");
		menu.addOption("Employee menu");
		return menu.prompt();
	}

	private void writeEnd() {
		System.out.println(" Goodbye ");
	}
}