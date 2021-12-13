package ui;

/**
 * MainMenu - class that creates main menu.
 * @author brynjar
 */

public class MainMenu {

	private CustomerMenu customerMenu;
	private ProductMenu productMenu;
	private OrderMenu orderMenu;
	private EmployeeMenu employeeMenu;
	private TryMe tryMe;
	
	/**
	 * Start the program.
	 * @param args
	 */
	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
		mainMenu.start();
	}
	
	/**
	 * Constructor of objects of MainMenu.
	 */
	public MainMenu() {
		customerMenu = new CustomerMenu();
		productMenu = new ProductMenu();
		orderMenu = new OrderMenu();
		employeeMenu = new EmployeeMenu();
		tryMe = new TryMe();
	}

	/**
	 * Start the main menu.
	 */
	public void start() {
		boolean running = true;
		while(running) {
			int choice = writeMainMenu();
			switch(choice) {
				case 1:
//					customerMenu.start();
					break;
				case 2:
//					productMenu.start();
					break;
				case 3:
					orderMenu.start();
					break;
				case 4:
//					employeeMenu.start();
					break;
				case 5:
					tryMe.newData();
					tryMe.printData();
					break;
				default:
					writeEnd();
					running = false;
			}
		}
	}
	
	/**
	 * Print main menu.
	 * @return what user want to do
	 */
	private int writeMainMenu() {
		TextOptions menu = new TextOptions("\n ***Main menu***", "Quit the program");
		menu.addOption("Customer menu");
		menu.addOption("Product menu");
		menu.addOption("Order menu");
		menu.addOption("Employee menu");
		menu.addOption("Generate data");
		
		return menu.prompt();
	}

	/**
	 * Print goodbye message.
	 */
	private void writeEnd() {
		System.out.println("Thank you, goodbye.");
	}
}