package product;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */
public interface IProduct {
	int getProducerId();
	void setProducerId(int producerId);
	int getProductId();
	void setProductId(int productId);
	String getProductName();
	void setProductName(String productName);
	String getProductType();
	void setProductType(String productType);
}
