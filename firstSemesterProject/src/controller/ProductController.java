package controller;

import java.util.ArrayList;

import model.Product;
import model.ProductContainer;

/**
 * ProductController - class 
 * @author Gabriel Pêdlowski
 */
public class ProductController {

	/**
	 * Add product to the product container.
	 * @param productName
	 * @param location
	 * @param price
	 * @param purchasePrice
	 * @param quantity
	 * @param discount
	 * @param minimumStock
	 * @param maximumStock
	 * @return true if product added successfully
	 */
	public boolean addProduct(String productName, String location, double price, double purchasePrice, int quantity, 
																	int discount, int minimumStock, int maximumStock) {
		Product product = new Product(productName, location, price, purchasePrice, quantity, 
														discount, minimumStock, maximumStock);
		return ProductContainer.getInstance().addProduct(product);
	}
	
	/**
	 * Delete product from the list.
	 * @param barcode
	 * @return true if product deleted successfully
	 */
	public boolean deleteProduct(int barcode) {
		return ProductContainer.getInstance().deletePorduct(barcode);
	}
	
	/**
	 * Find product with given barcode.
	 * @param barcode
	 * @return product with given barcode
	 */
	public Product getProduct(int barcode) {
		return ProductContainer.getInstance().getProduct(barcode);
	}
	
	/**
	 * Get all existing products.
	 * @return list of products
	 */
	public ArrayList<Product> getAllProducts() {
		return ProductContainer.getInstance().getAllProducts();
	}
	
	/**
	 * Update product.
	 * @param barcode
	 * @param productName
	 * @param location
	 * @param price
	 * @param purchasePrice
	 * @param quantity
	 * @param discount
	 * @param minimumStock
	 * @param maximumStock
	 * @return true if product updated successfully
	 */
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
