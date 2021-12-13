package controller;

import java.util.ArrayList;

import model.Product;
import model.ProductContainer;

public class ProductController {

	public boolean addProduct(String productName, String location, double price, double purchasePrice, int quantity, 
																	int discount, int minimumStock, int maximumStock) {
		Product product = new Product(productName, location, price, purchasePrice, quantity, 
														discount, minimumStock, maximumStock);
		return ProductContainer.getInstance().addProduct(product);
	}
	
	public boolean deleteProduct(int barcode) {
		return ProductContainer.getInstance().deletePorduct(barcode);
	}
	
	public Product getProduct(int barcode) {
		return ProductContainer.getInstance().getProduct(barcode);
	}
	
	public ArrayList<Product> getAllProducts() {
		return ProductContainer.getInstance().getAllProducts();
	}
	
	public boolean updateProduct(int barcode, String productName, String location, double price, 
			double purchasePrice, int quantity, int discount, int minimumStock, int maximumStock) {
		boolean retVal = false;
		ArrayList<Product> products = getAllProducts();
		
		for(Product element : products) {
			if(element.getBarcode() == barcode) {
				element.setProductName(productName);
				element.setLocation(location);
				element.setPrice(price);
				element.setPurchasePrice(purchasePrice);
				element.setQuantity(quantity);
				element.setDiscount(discount);
				element.setMinimumStock(minimumStock);
				element.setMaximumStock(maximumStock);
				
				retVal = true;
			}
		}
		return retVal;
	}
}
