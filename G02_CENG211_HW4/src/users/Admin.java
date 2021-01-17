package users;

import enums.UserTypes;

/* 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public class Admin extends User{
	public Admin() {
		super();
	}
	
	public Admin(String userName, String password, String displayedName) {
		super(userName,password,displayedName,UserTypes.ADMIN);
	}
	
	public Admin(int userId, String userName, String password, String displayedName) {
		super(userId,userName,password,displayedName,UserTypes.ADMIN);
	}
}
