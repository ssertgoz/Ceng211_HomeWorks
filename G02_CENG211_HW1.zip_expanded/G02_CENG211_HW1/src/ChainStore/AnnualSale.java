package ChainStore;

import FileAccess.FileIO;

/**
 * This is our AnnualSale Class which contains only one method
 * Name of it is getItemTransactionArray and return ItemTransaction[]
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */
public class AnnualSale {
	private ItemTransaction[] itemTransactionArray;
	private int numberOfItem = HELPER.NUMBER_OF_ITEM;
	
	/**
	 * This method get items from FileIO as String TDA, 
	 * creates item objects with that values and then creates 
	 * a transaction objects with that items. After that it
	 * return an array which include transaction objects
	 * 
	 * @return itemTransactionArray
	 */
	public ItemTransaction[] getItemTransactionArray() {
		String[][] itemsTDA = FileIO.getItems();
		itemTransactionArray = new ItemTransaction[numberOfItem];
		int count = 0;
		
		for(String[] splitedItem : itemsTDA) {
			Item item = new Item(splitedItem[0], splitedItem[1], splitedItem[2]); // item name, item ID, item category
			ItemTransaction itemTransaction = new ItemTransaction(item);
			itemTransactionArray[count] = itemTransaction;
			count++;
		}
		
		return itemTransactionArray;
	}
	
}
