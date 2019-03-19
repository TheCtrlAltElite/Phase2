/**Account class
 * 
 */
package other;

import java.util.*;

/**
 * @author omatias001
 *
 */
public class Account {

	/**
	 * Instance variables.
	 */
	private String email, firstName, lastName, password, profilePic;
	private char type, status;
	private AccountController controller;
	private boolean loginStatus;

	/**
	 * Creates an Account object and sets the parameters to the items in the list parameter.
	 * 
	 * @param list
	 */
	public Account(String email, String firstName, String lastName, String password, char type, char status) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.status = type;
		this.type = status;
	}
	
	/**
	 * Checks if user is already logged in
	 */
	public void isLoggedIn(boolean stat) {
		this.loginStatus = stat;
	}
	
	/**
	 * Resets password of user/admin
	 */
    public void resetPassword(String o, String n1, String n2) {
		
	}
	
	/**
	 * Retrieves the details of a users profile and puts them in a list
	 */
	public List<String> getDetailsProfile(){
		return null;
	}
	
	/**
	 * Returns the email.
	 */
	public String getEmail() {
		return this.email;
	}
	
	/**
	 * Sets the accounts profile picture
	 */
	public void setProfilePic(String newPic) {
		this.profilePic = newPic;
	}
	
	/**
	 * Returns the first name.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * returns the last name.
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Returns the type.
	 */
	public char getType(){
		return this.type;
	}
	
	/**
	 * Returns the status.
	 */
	public char getStatus() {
		return this.status;
	}
	
	/**
	 * Returns the password.
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Sets firstName to the parameter name.
	 */
	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	/**
	 * Sets lastName to the parameter name.
	 */
	public void setLastName(String name) {
		this.lastName = name;
	}
	
	/**
	 * Sets the type to the parameter type.
	 */
	public void setType(char type) {
		this.type = type;
	}
	
	/**
	 * Sets the status to the parameter status.
	 */
	public void setStatus(char status) {
		this.status = status;
	}

	/**
	 * Sets the password to the parameter password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
