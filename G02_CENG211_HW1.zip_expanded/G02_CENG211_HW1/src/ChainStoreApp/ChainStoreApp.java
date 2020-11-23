package ChainStoreApp;

import ChainStore.StoreQuery;

/**   
 * This is our ChainStoreApp where has the main method.
 * So program starts from here and creates an StoreQuery class 
 * then calls our homework questions one by one
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  2602010359
 */
public class ChainStoreApp {
	
	public static void main(String[] args)  {
		
		StoreQuery storeQ = new StoreQuery();
		
		System.out.println("1 - Most profitable item for the whole year :      " + storeQ.calMostProfitableItemWholeYear().getName().toUpperCase()); 
		System.out.println("2 - Most profitable category for the whole year :  " + storeQ.mostAndLeastProfitableCategoryWholeYear()[0].toUpperCase());
		System.out.println("3 - Least profitable item for the whole year :     " + storeQ.calLeastProfitableItemWholeYear().getName().toUpperCase()); 
		System.out.println("4 - Least profitable category for the whole year : " + storeQ.mostAndLeastProfitableCategoryWholeYear()[1].toUpperCase());
		System.out.println("5 - Most profitable item for a single sale :       " + storeQ.mostProfitableItemForSingleSale().getName().toUpperCase());
		System.out.println("6 - Best-selling item for the whole year :         " + storeQ.bestSellingItemWholeYear().getName().toUpperCase()); 
		System.out.println();
		System.out.println("                  MOST PROFITABLE STORES ACCORDING TO MONTHS");
		for (int i = 0; i < 12; i++) {
			System.out.println(String.format("Month %d : STORE %d",i+1, storeQ.mostProfitableStore()[i]));
		}
		
	}

}
