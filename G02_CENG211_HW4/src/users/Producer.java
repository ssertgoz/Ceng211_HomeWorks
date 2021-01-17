package users;

import enums.UserTypes;

/*
 * @author  Serdar Sertg�z  260201030
 * @author  Ertu�rul Demir  260201059
 */

public class Producer extends User{
	
	public Producer() {
		super();
	}
	
	public Producer(String userName, String password, String displayedName) {
		super(userName,password,displayedName,UserTypes.PRODUCER);
	}
	
	public Producer(int userId, String userName, String password, String displayedName) {
		super(userId,userName,password,displayedName,UserTypes.PRODUCER);
	}
}
