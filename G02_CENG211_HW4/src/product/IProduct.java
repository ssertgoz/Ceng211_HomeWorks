package product;

/*
 * @author  Serdar Sertg�z  260201030
 * @author  Ertu�rul Demir  260201059
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
