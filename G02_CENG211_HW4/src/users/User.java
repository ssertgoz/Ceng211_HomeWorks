package users;

import enums.UserTypes;
import serviceClasses.IdGenerator;

/*This user abstract class is base class for every user type,
 * and implements the generateId method to generate id automatically for users
 * 
 * @author  Serdar Sertgöz  260201030
 * @author  Ertuðrul Demir  260201059
 */

public abstract class User extends IdGenerator implements IUser{

	private int userId;
	private String userName;
	private String password;
	private String displayedName;
	private UserTypes userType;
	
	public User () {
		this("","","",null);
	}
	
	public User( String userName, String password, String displayedName, UserTypes userType) {
		this.userId = generateID();
		this.userName = userName;
		this.password = password;
		this.displayedName = displayedName;
		this.userType = userType;
	}
	
	public User( int userId, String userName, String password, String displayedName, UserTypes userType) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.displayedName = displayedName;
		this.userType = userType;
	}
	
	
	// getters and setters
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplayedName() {
		return displayedName;
	}
	public void setDisplayedName(String displayedName) {
		this.displayedName = displayedName;
	}
	public UserTypes getUserType() {
		return userType;
	}
	public void setUserType(UserTypes userType) {
		this.userType = userType;
	}
	


	
	
}
