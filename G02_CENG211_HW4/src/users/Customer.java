package users;

import enums.UserTypes;

/*
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Customer extends User {
	
	public Customer() {
		super();
	}
	
	public Customer(String userName, String password, String displayedName) {
		super(userName,password,displayedName,UserTypes.CUSTOMER);
	}
	
	public Customer(int userId, String userName, String password, String displayedName) {
		super(userId,userName,password,displayedName,UserTypes.CUSTOMER);
	}

}
