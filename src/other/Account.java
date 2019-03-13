/**Account class
 * 
 */
package other;

import java.util.List;

/**
 * @author omatias001
 *
 */
public class Account {

	/**
	 * Instance variables.
	 */
	String email, firstName, lastName, password,profilePic;
	private char status, type;
	AccountController controller;
	boolean loginStatus;

	/**
	 * Creates an Account object and sets the parameters to the items in the list parameter.
	 * 
	 * @param userDetails
	 */
	public Account(java.awt.List userDetails) {
		this.email = ((List<String>) userDetails).get(0);
		this.firstName = ((List<String>) userDetails).get(1);
		this.lastName = ((List<String>) userDetails).get(2);
		this.password = ((List<String>) userDetails).get(3);
		this.status = ((List<String>) userDetails).get(4);
		this.type = ((List<String>) userDetails).get(5);
	}
	
	/**
	 * 
	 */
	public void login(String username, String password) {
		controller.login(username, password);
	}
	
	/**
	 * 
	 */
	public void isLoggedIn(boolean stat) {
		this.loginStatus = stat;
	}
	
	/**
	 * 
	 */
	public void logOut() {
		
	}
	
	/**
	 * 
	 */
    public void resetPassword(String o, String n1, String n2) {
		
	}
	
	/**
	 * 
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
	 * 
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
	public String getPasssword() {
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
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * Sets the status to the parameter status.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Sets the password to the parameter password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
