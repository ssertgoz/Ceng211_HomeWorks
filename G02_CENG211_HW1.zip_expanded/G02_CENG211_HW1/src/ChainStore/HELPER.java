package ChainStore;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import FileAccess.FileIO;

/**   
 * This is our HELPER Class. It contains some methods and veraibles   
 * to help to StoreQuery Class and FileIO class
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */
public  class HELPER {
	public static final int NUMBER_OF_MONTH = 12;
	public static final int NUMBER_OF_ITEM = 32;
	public static final int NUMBER_OF_STORE = findNumberOFStores();
	
	public static int findNumberOFStores() {
		
		int numberOfStores = 0;
		
		try {
			while (true) {
				BufferedReader store_br = new BufferedReader(new FileReader(String.format("HW1_Transactions_Store%d.csv", numberOfStores+1)));
				store_br.close();
				numberOfStores++;
			}	
			
		} catch(FileNotFoundException exception) {
			return numberOfStores;
		} 
		catch (IOException e) {
			return numberOfStores;
		}
		
	}
	
	// we use this method to find number of item in the store. It is used in FileIO class
	public static int findNumberOfItem(BufferedReader br) {
		int numberOfÝtems = 0;
		try {
			while(br.readLine() != null) {
				numberOfÝtems++;
			}
		} 
		catch (FileNotFoundException e) {
			System.out.println(e);
		}catch (IOException e) {
			System.out.println(e);
		}
		return numberOfÝtems;
	}
	
	// Get Transactions from fileIO according to store number and item ID and then change the String values to 
	// double to compute some computations and return an array with double values
	public static double[] getTransactionsAsDouble(int storeNumber, String itemID) {
		double[] temp = null;
		FileIO file = new FileIO();
		String[] strList = file.getItemTransactions()[storeNumber][Integer.parseInt(itemID)-1].split(",");
		
		temp = new double[strList.length];
		
		for(int i = 0; i< strList.length; i++) {
			temp[i] = Double.parseDouble(strList[i]);
		}
		
		return temp;
	}
	
	// we get ItemTransaction array from AnnualSale here because we want more clean code
	// and we will use it in the StoreQuery class
	public static ItemTransaction[] getItemTransactionFromAnnualSale() {
		try {
			AnnualSale annualSale = new AnnualSale();
			ItemTransaction[] itemTransaction = annualSale.getItemTransactionArray(); 
			return itemTransaction;
			}
		catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}
	
	// it finds the index of largest value in an array
	public static int getIndexOfLargest( double[] array )
	{
	  if ( array == null || array.length == 0 ) return -1; // null or empty

	  int largest = 0;
	  for ( int i = 1; i < array.length; i++ )
	  {
	      if ( array[i] > array[largest] ) largest = i;
	  }
	  return largest; // position of the first largest found
	}
	
	// it finds the index of smallest value in an array
	public static int getIndexOfSmallest( double[] array )
	{
	  if ( array == null || array.length == 0 ) return -1; // null or empty

	  int smallest = 0;
	  for ( int i = 1; i < array.length; i++ )
	  {
	      if ( array[i] < array[smallest] ) smallest = i;
	  }
	  return smallest; // position of the first smallest found
	}
	
	public static double profitItemForAMonth(Transaction x) {
		return profitItemForSýngleSale(x) * x.getNumberOfSales();
	}
	
	public static double profitItemForSýngleSale(Transaction x) {
		return x.getSalePrice()-x.getPurchasePrice();
	}
}
