package users;

import enums.UserTypes;

/* All user types should use this interface by extend the User abstract class
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public interface IUser{
	int getUserId();
	void setUserId(int userId);
	String getUserName();
	void setUserName(String userName);
	String getPassword();
	void setPassword(String password);
	String getDisplayedName();
	void setDisplayedName(String displayedName);
	UserTypes getUserType();
	void setUserType(UserTypes userType);
}
