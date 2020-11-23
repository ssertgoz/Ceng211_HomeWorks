package ChainStore;

/**
 * This is our Transaction Class with getter and setter methods
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Transaction {
	private double PurchasePrice;
	private double SalePrice;
	private int NumberOfSales;
	
	public Transaction(double PurchasePrice, double SalePrice, int NumberOfSales) {
		this.PurchasePrice = PurchasePrice;
		this.SalePrice = SalePrice;
		this.NumberOfSales = NumberOfSales;
	}

	public double getPurchasePrice() {
		return PurchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		PurchasePrice = purchasePrice;
	}

	public double getSalePrice() {
		return SalePrice;
	}

	public void setSalePrice(double salePrice) {
		SalePrice = salePrice;
	}

	public int getNumberOfSales() {
		return NumberOfSales;
	}

	public void setNumberOfSales(int numberOfSales) {
		NumberOfSales = numberOfSales;
	}

}
