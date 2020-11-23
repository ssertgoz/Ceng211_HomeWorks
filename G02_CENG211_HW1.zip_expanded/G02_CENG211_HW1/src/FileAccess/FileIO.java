package FileAccess;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ChainStore.HELPER;

/**   
 * This is our FileIO Class. It contains two function and we read all
   csv files here.
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class FileIO {
	
	/**
	 * In this getItemTransactions method, we are trying to
	   read all HW1_Transactions_Store1,2,3,4 csv files.
	 * We have two while loop, first one is for stores.It 
	   returns as many as stores to read all files. Second one
	   is for reading lines and it append this lines to two dimensional
	   array according to store numbers.
	  *We just store the values as a String in a two dimensional array with
	   store numbers and then return this array. We will use helper class 
	   to read values as double.
	 */
	public String[][] getItemTransactions() {
		// Rows of this TDA are Stores and columns are Transactions as String
		String[][] TransactionsForAllStoresTDA = null;  //TDA means that "Two Dimensional Array"
		String line;
		int countColumn;                    // it is used for adding Transactions strings to TDA one by one
		int count;   						// it helps us to define item numbers and to initialize columns of TDA
		int numberOfStores;
		int store = 0;						// it is used for first while loop 
		
		try {
			/**
			 *  We get number of stores first with helper, this allow us to use more HW1_Transactions_Store csv file
			 *  at the same time when we had more than 4 store.
			 */
			numberOfStores = HELPER.findNumberOFStores();
			TransactionsForAllStoresTDA = new String[numberOfStores][];         // We just initialize for rows in here 
			
			while(store < numberOfStores) {
				store++;
				count = 0;
				// We get buffer reader from csv files according to store number 
				BufferedReader store_br = new BufferedReader(new FileReader(String.format("HW1_Transactions_Store%d.csv", store)));
				
				// We count the lines to be sure file not empty and find number of items in the store
				count = HELPER.findNumberOfItem(store_br);
				store_br.close();
				TransactionsForAllStoresTDA[store-1] = new String[count];         // We initialize columns for TDA with count
				
				if(count > 0) {
					BufferedReader store_br2 = new BufferedReader(new FileReader(String.format("HW1_Transactions_Store%d.csv", store)));
					countColumn=0;
					while ((line = store_br2.readLine()) != null) {              // we add lines to TDA
						TransactionsForAllStoresTDA[store-1][countColumn++] = line;
					}
					store_br2.close();
				}	
			}		
			
		} catch(FileNotFoundException exception) {
			System.out.println(exception); 
		} catch(IOException exception) {
			System.out.println(exception);
		}
			
		return TransactionsForAllStoresTDA;
	}
	
	
	/**
	 * In this getItems method, we are trying to read only HW1_Items csv file
	 * We have a two-dimensional array, the row of which is the item and the 
	   column is the  name, id, category of the item
	 * @return
	 */
	public static String[][] getItems() {
		String[][] itemsTDA = null;                  		//items TDA, TDA means that "Two Dimensional Array"	
		String line;
		int countColumn;									// it is used for adding Transactions strings to TDA one by one
		int count = 0;										// it helps us to define item numbers and to initialize columns of TDA
		
		try {
			BufferedReader items_br = new BufferedReader(new FileReader("HW1_Items.csv"));
			count = HELPER.findNumberOfItem(items_br);
			items_br.close();
			itemsTDA = new String[count][3];                // we initialize the items TDA with count and 3, 3 is (name,id,category)
			if(count > 0) {
				@SuppressWarnings("resource")
				BufferedReader items_br2 = new BufferedReader(new FileReader("HW1_Items.csv"));
				countColumn=0;
				// we add item features to itemsTDA
				while((line = items_br2.readLine()) != null) {
					itemsTDA[countColumn++] = line.split(",");
				}
			}
		} 
		catch(FileNotFoundException exception) {
			System.out.println("file not found"); 
		}
		catch(IOException exception) {
			System.out.println(exception);
		}
		return itemsTDA; 
	}
	

}
