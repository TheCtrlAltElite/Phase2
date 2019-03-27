/**Account class
 * 
 */
package other;

//imports
//import java.util.*;

/**
 * @author CtrlAltElite
 *
 */
public class Account {

	/**
	 * Instance variables.
	 */
	private String email, firstName, lastName, password;
	private String profilePic;
	private char type, status;
	//private AccountController controller;
	private boolean loginStatus;

	/**
	 * Creates an Account object
	 */
	public Account() {
		this.loginStatus = false;
	}
	
	/**
	 * Creates an Account object and sets the parameters to the items in the list parameter.
	 * 
	 * @param email, firstName, lastName, password, type, status
	 */
	public Account(String email, String firstName, String lastName, String password, char type, char status) {
		
		//controller = new AccountController();
		
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.status = type;
		this.type = status;
		this.loginStatus = false;
	}
	
	/**
	 * Sets the users status to logged in
	 * @param stat
	 */
	public boolean getLoginStatus() {
		return this.loginStatus;
	}
	
	public void setLoginStatus(boolean enterStatus) {
		this.loginStatus = enterStatus;
	}
		 
	
	/**
	 * Returns the email of the user.
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets the accounts profile picture
	 * @param newPic
	 */
	public void setProfilePic(String newPic) {
		this.profilePic = newPic;
		System.out.println("Jpeg has been set");
	}
	
	public String getProfilePic() {
		return this.profilePic;
	}
	/**
	 * Returns the first name.
	 * @return firstName, the name of the Account
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * returns the last name.
	 * @return lastName, the last name of the Account
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Returns the type.
	 * @return type, the type of the Account
	 */
	public char getType(){
		return this.type;
	}
	
	/**
	 * Returns the status.
	 * @return status, the status of the Account 
	 */
	public char getStatus() {
		return this.status;
	}
	
	/**
	 * Returns the password.
	 * @return password, the password of the account
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Sets firstName to the parameter name.
	 * @param name
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	/**
	 * Sets lastName to the parameter name.
	 * @param name
	 */
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	/**
	 * Sets the type to the parameter type.
	 * @param type
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	/**
	 * Sets the status to the parameter status.
	 * @param status
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * Sets the password to the parameter password.
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
