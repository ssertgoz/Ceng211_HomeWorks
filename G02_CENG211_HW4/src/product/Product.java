package product;

import serviceClasses.IdGenerator;

/* This Product class include products information 
 * and extend IdGenerator to generate id automatically for product
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Product extends IdGenerator implements IProduct{
	
	private int producerId;
	private int productId;
	private String productName;
	private String productType;
	
	public Product() {
		this(0,"","");
	}
	
	public Product(int producerId, String productName, String productType) {
		this.producerId = producerId;
		this.productId = generateID();
		this.productName = productName;
		this.productType = productType;
	}
	
	public Product(int productId, int producerId, String productName, String productType) {
		this.producerId = producerId;
		this.productId = productId;
		this.productName = productName;
		this.productType = productType;
	}




	public int getProducerId() {
		return producerId;
	}

	public void setProducerId(int producerId) {
		this.producerId = producerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

}
