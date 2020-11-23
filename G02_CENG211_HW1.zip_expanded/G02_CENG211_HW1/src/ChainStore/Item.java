package ChainStore;



/**
 * This is our Item Class with getter and setter methods
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Item {
	private String ID;
	private String Name;
	private String Category;
	
	public Item() {
		this(null,null,null);
	}
	
	public Item( String Name,String ID, String Category) {
		this.ID = ID;
		this.Name = Name;
		this.Category = Category;
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}


}
