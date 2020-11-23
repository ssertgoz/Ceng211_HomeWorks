package ChainStore;

/**   
 * This is our ItemTransaction Class. It initialize the Transaction two dimensional array
 * We have some getter and setter methods 
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class ItemTransaction {
	
	private Item item;
	private Transaction[][] transactionsTDA; 									// TDA mean is "Two Dimensional Array"
	private int numberOfStore;
	private int numberOfMonth;
	// Constructor 
	public ItemTransaction(Item item)   {
		this.item = item;
		numberOfStore = HELPER.NUMBER_OF_STORE;
		numberOfMonth = HELPER.NUMBER_OF_MONTH;
		transactionsTDA = new Transaction[numberOfStore][numberOfMonth];    	// we define TransactionsTDA
		setTransactionsTDA(); 													// we call setTransactionsTDA method to initialize 
		    											    
	}
	
	// we make it private set method because we do not want that using of this method by the someone
	// this method used for initializing transactionsTDA
	private void setTransactionsTDA(){
		// we use try-catch block for catch the exceptions
		try {
			int count =0;
			int monthCount = 0;
			double purchasePrice = 0;
			double salePrice = 0;
			int numberOfSales = 0;
			
			for (int i = 0; i < numberOfStore; i++) {
				monthCount = 0;
				// we get Transaction values as double with item id and store number(-1)
				double[] arrayOfTransactionsForItem = HELPER.getTransactionsAsDouble(i,item.getID());
				for (int j = 1; j < arrayOfTransactionsForItem.length; j++) {
					count++;
					// This switch is used for initialize transaction values every 3 j because we have three features, purchasePrise
					// salePrice and numberOfSales. It repeats every 3 j for each month.
					switch (count) {
					case 1:
						purchasePrice = arrayOfTransactionsForItem[j];
						break;
					case 2:
						salePrice = arrayOfTransactionsForItem[j];
						break;
					case 3:
						numberOfSales = (int)arrayOfTransactionsForItem[j];
						//we create a transaction object
						Transaction transaction = new Transaction(purchasePrice, salePrice, numberOfSales);
						//we add transaction to transactionTDA according to store and month
						transactionsTDA[i][monthCount++] = transaction;
						count = 0; // we make count zero every 3 value to skip month
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + count);
					}
				}
			}
			
		} 
		catch (NumberFormatException e) {
			System.out.println(e);
		}
		
	}
	
	public Transaction[][] getTransactionsTDA() {
		return transactionsTDA;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	

}
