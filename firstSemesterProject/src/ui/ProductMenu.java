package ui;

import java.util.ArrayList;

import controller.ProductController;
import model.Product;

public class ProductMenu {

	private ProductController productController;
	
	/**
	 * Constructor for objects of ProductMenu.
	 */
	public ProductMenu() {
		productController = new ProductController();
	}
	
	/**
	 * Start the product menu.
	 */
	public void start() {
		boolean running = true;
		while(running) {
			int choice = writeProductMenu();
			switch(choice) {
				case 1:
					createProduct();
					break;
				case 2:
					printAllProducts();
					break;
				case 3:
					updateProduct();
					break;
				case 4:
					deleteProduct();
					break;
				default:
					running = false;
			}
		}
	}
	
	/**
	 * Print product menu.
	 * @return what user wants to do with product
	 */
	public int writeProductMenu() {
		TextOptions menu = new TextOptions("\n ***** Product Menu *****", "Back");
		menu.addOption("Create product");
		menu.addOption("Show all products");
		menu.addOption("Update product");
		menu.addOption("Delete product");
		
		return menu.prompt();
	}
	
	/**
	 * Create product.
	 */
	public void createProduct() {
		String productName = writeString("Enter product name: ");
		String location = writeString("Enter product location: ");
		double price = writeInt("Enter product price: ");
		double purchasePrice = writeInt("Enter product purchase price: ");
		int quantity = writeInt("Enter product quantity: ");
		int discount = writeInt("Enter product discount: ");
		int minimumStock = writeInt("Enter product minimum stock: ");
		int maximumStock = writeInt("Enter product maximum stock: ");
		productController.addProduct(productName, location, price, purchasePrice, quantity, 
														discount, minimumStock, maximumStock);
	}
	
	/**
	 * Print all existing products.
	 */
	public void printAllProducts() {
		ArrayList<Product> products = productController.getAllProducts();
		if(products.size() > 0) {
			for(int i = 0; i < products.size(); i++) {
				System.out.println("Product [" + (i + 1) + "/" + products.size() + "]:");
				products.get(i).getInfo(); 
			}
		} else {
			System.out.println("There are no products.");
		}
	}
	
	/**
	 * Update product.
	 */
	private void updateProduct() {
		int barcode = findProduct().getBarcode();
		updateProductByBarcode(barcode);
	}
	
	/**
	 * Update product with given barcode.
	 * @param barcode
	 * @return true if product updated successfully
	 */
	private boolean updateProductByBarcode(int barcode) {
		boolean retVal = false;
		
		if(checkBarcodeValidity(barcode)) {
			if(updateFields(barcode)) {
				System.out.println("The update was succesful.");
				retVal = true;
			} else {
				System.out.println("The update was not succesful.");
			}
		} else {
			System.out.println("The barcode of product is not correct...");
		}
		return retVal;
	}
	
	/**
	 * Delete product.
	 */
	private void deleteProduct() {
		int barcode = findProduct().getBarcode();
		deleteProductByBarcode(barcode);
	}
	
	/**
	 * Delete product with given barcode.
	 * @param barcode
	 * @return true if product deleted successfully
	 */
	private boolean deleteProductByBarcode(int barcode) {
		if(checkBarcodeValidity(barcode)) {
			if(confirm()) {
				if(productController.deleteProduct(barcode)) { 
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
	 * Take product barcode from the user and find the product.
	 * @return product with the given barcode
	 */
	private Product findProduct() {	
		int barcode = writeInt("Enter product barcode: ");
		Product product = productController.getProduct(barcode);
		product.getInfo();
		return product;
	}
	
	/**
	 * Check if user is sure about the change e.g delete product.
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
	 * Take new product info from user and update product with it.
	 * @param barcode
	 * @return true if product updated successfully
	 */
	private boolean updateFields(int barcode) {
		boolean retVal = false;
		String productName = writeString("Enter product name: ");
		String location = writeString("Enter product location: ");
		double price = writeInt("Enter product price: ");
		double purchasePrice = writeInt("Enter product purchase price: ");
		int quantity = writeInt("Enter product quantity: ");
		int discount = writeInt("Enter product discount: ");
		int minimumStock = writeInt("Enter product minimum stock: ");
		int maximumStock = writeInt("Enter product maximum stock: ");
		
		if(productName.equals("")) {
			productName = productController.getProduct(barcode).getProductName();
		}
		if(location.equals("")) {
			location = productController.getProduct(barcode).getLocation();
		}
		
		if(productController.updateProduct(barcode, productName, location, price, 
					purchasePrice, quantity, discount, minimumStock, maximumStock)) { 
			retVal = true;
		}
		return retVal;
	}
	
	/**
	 * Check if product with given barcode exist.
	 * @param barcode
	 * @return true if there is a product with given barcode
	 */
	private boolean checkBarcodeValidity(int barcode) {
		boolean retVal = false;
		
		if(productController.getProduct(barcode) != null) { 
			retVal = true;
		} else {
			System.out.println("There is no product with that barcode.");
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
