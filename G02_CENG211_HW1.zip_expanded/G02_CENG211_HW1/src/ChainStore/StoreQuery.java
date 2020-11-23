package ChainStore;
/**   
 * This is our StoreQuery Class. It contains methods that execute
 * queries given in homework.
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class StoreQuery {
	// Array which hold ItemTransaction object
	private ItemTransaction[] itemTransactionArray;
	// our constant veraibles
	private int numberOfMonth;
	private int numberOfStore;
	private int numberOfItem;
	
	//Constructor
	public StoreQuery() {
		// We get ItemTransaction array from AnnualSale with HELPER class  
		itemTransactionArray = HELPER.getItemTransactionFromAnnualSale();
		numberOfMonth = HELPER.NUMBER_OF_MONTH;
		numberOfStore = HELPER.NUMBER_OF_STORE;
		numberOfItem = HELPER.NUMBER_OF_ITEM;
	}

	public Item calMostProfitableItemWholeYear(){
		double[] ItemProfitArray = new double[numberOfItem]; 			// this array store the item profits
		for (int itemT = 0; itemT < numberOfItem;itemT++) {
			double profitMonth = 0;
			for(int store=0; store <numberOfStore ; store++) {
				for (int month=0; month<numberOfMonth;month++) {
					// monthly profit calculated by the HELPER class 
					profitMonth = HELPER.profitItemForAMonth(itemTransactionArray[itemT].getTransactionsTDA()[store][month]);
					ItemProfitArray[itemT] += profitMonth;  
				}
			}
		}
		int indexOfLargestItem = HELPER.getIndexOfLargest(ItemProfitArray);
		return itemTransactionArray[indexOfLargestItem].getItem();
	}
			
	public Item calLeastProfitableItemWholeYear(){
		double[] ItemProfitArray = new double[numberOfItem]; 			// this array store the item profits
		for (int itemT = 0; itemT < numberOfItem;itemT++) {
			double profit = 0;
			for(int store=0; store <numberOfStore ; store++) {
				for (int month=0; month<numberOfMonth;month++) {
					// profit calculated by the HELPER class
					profit = HELPER.profitItemForAMonth(itemTransactionArray[itemT].getTransactionsTDA()[store][month]);
					ItemProfitArray[itemT] += profit;
				}
			}
		}
		int indexOfSmallestItem = HELPER.getIndexOfSmallest(ItemProfitArray);	
		return itemTransactionArray[indexOfSmallestItem].getItem();
	}
	
	public Item bestSellingItemWholeYear() {
		double[] ItemSellingArray = new double[numberOfItem]; // this array store the item sales
		for (int itemT = 0; itemT < numberOfItem;itemT++) {
			int sale=0;
			for(int store=0; store <numberOfStore ; store++) {
				for (int month=0; month<numberOfMonth;month++) {
					//we get number of sales
					sale = itemTransactionArray[itemT].getTransactionsTDA()[store][month].getNumberOfSales();
					ItemSellingArray[itemT] +=sale;
				}
			}
		}
		int indexOfLargestSellingItem = HELPER.getIndexOfLargest(ItemSellingArray);
		return itemTransactionArray[indexOfLargestSellingItem].getItem();		
	}
		
	public Item mostProfitableItemForSingleSale() {
		Item choosenItem = null;
		double choosenItemSingleSale = 0;
		for (int itemT = 0; itemT < numberOfItem; itemT++) {
			double totalProfitofSingleSales = 0;     
			for (int store = 0; store < numberOfStore;store++) {
				for (int month=0; month < numberOfMonth;month++){
					// single sale profit of item calculated by the HELPER class
					double singleSaleProfit = HELPER.profitItemForSýngleSale(itemTransactionArray[itemT].getTransactionsTDA()[store][month]);
					totalProfitofSingleSales += singleSaleProfit;
				}
			}
			if (choosenItemSingleSale <= totalProfitofSingleSales) {
				choosenItem = itemTransactionArray[itemT].getItem();
				choosenItemSingleSale = totalProfitofSingleSales;
			}
		}
		return choosenItem;
	}
	
	public String[] mostAndLeastProfitableCategoryWholeYear() {
		double categoryProfitArray[] = new double[5] ;           // This array holds profits according to 5 different category
		// this array is used for define most and least profitable category only at the end of the method
		String categoryArray[] = {"Beverage", "Snack", "Food", "Home", "Personal"};
		
		int beverageCounter = 0;
		int snackCounter = 0;
		int foodCounter = 0;
		int homeCounter = 0;
		int personalCounter = 0;
		
		for (int itemT = 0; itemT < numberOfItem; itemT++) {
			for(int store = 0; store <numberOfStore; store++) {
				for (int month = 0; month < numberOfMonth ; month++ ) {
					// monthly profit calculated by the HELPER class
					double profitMonth = HELPER.profitItemForAMonth(itemTransactionArray[itemT].getTransactionsTDA()[store][month]);
					// profit is added to categoryProfitArray according to category and counters are also increased
					switch (itemTransactionArray[itemT].getItem().getCategory()) {
					//We use if blocks in the each case due to find the number of items in the each category
					//we used only store 0, its enough to know number of items in only one store because every store has same type of items 
					case "Beverage":
						categoryProfitArray[0] += profitMonth;
						if (store == 0) {beverageCounter += 1;}
						break;
					case "Snack":
						categoryProfitArray[1] += profitMonth;
						if (store == 0) {snackCounter += 1;}
						break;
					case "Food":
						categoryProfitArray[2] += profitMonth;
						if (store == 0) {foodCounter += 1;}
						break;
					case "Home":
						categoryProfitArray[3] += profitMonth;
						if (store == 0) {homeCounter += 1;}
						break;
					case "Personal":
						categoryProfitArray[4] += profitMonth;
						if (store == 0) {personalCounter += 1;}
						break;
					default:
						throw new IllegalArgumentException("Unexpected value");
					}
				}
			}
		}
		// we dived each profit to number of that category to find exact profit
		categoryProfitArray[0] = categoryProfitArray[0] / beverageCounter;
		categoryProfitArray[1] = categoryProfitArray[1] / snackCounter;
		categoryProfitArray[2] = categoryProfitArray[2] / foodCounter;
		categoryProfitArray[3] = categoryProfitArray[3] / homeCounter;
		categoryProfitArray[4] = categoryProfitArray[4] / personalCounter;

		// we find indexes of most and least profitable category 
		int mostProfitableCategoryIndex = HELPER.getIndexOfLargest(categoryProfitArray) ;
		int leastProfitableCategoryIndex = HELPER.getIndexOfSmallest(categoryProfitArray);
		// we assign the categories from categoryArray 
		String mostProfitableCategoryName = categoryArray[mostProfitableCategoryIndex];
		String leastProfitableCategoryName = categoryArray[leastProfitableCategoryIndex];
		
		// we append the most and least profitable category names to an array and return it,
		String mostAndLeastProfitableCategoryNameArray[] = {mostProfitableCategoryName,leastProfitableCategoryName}; 
		
		return mostAndLeastProfitableCategoryNameArray; 
		
	}
	
	public int[] mostProfitableStore() {
		int[] storeArrayForMonths = new int[numberOfMonth]; 				// This array holds most profitable store number for each month 
		for (int month = 0; month < numberOfMonth ; month++) {
			double[] totalProfitofStoresArray = new double[numberOfStore];  // This array holds total profit of each store in a month
			for (int store = 0;store < numberOfStore; store++) {
				for (int itemT=0; itemT <numberOfItem;itemT++) {
					// profit calculated by the HELPER class
					double profit = HELPER.profitItemForAMonth(itemTransactionArray[itemT].getTransactionsTDA()[store][month]);
					totalProfitofStoresArray[store] +=profit;				
				}
			}
			storeArrayForMonths[month] = (HELPER.getIndexOfLargest(totalProfitofStoresArray)) +1;
		}
		return storeArrayForMonths;	
	}
}