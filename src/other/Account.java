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
	String email, firstName, lastName, password, status, type, profilePic;
	AccountController controller;
	boolean loginStatus;

	@SuppressWarnings("unchecked")
	public Account(java.awt.List list) {
		this.email = ((List<String>) list).get(0);
		this.firstName = ((List<String>) list).get(1);
		this.lastName = ((List<String>) list).get(2);
		this.password = ((List<String>) list).get(3);
		this.status = ((List<String>) list).get(4);
		this.type = ((List<String>) list).get(5);
	}
	
	/**
	 * Logs in user/admin
	 */
	public void login(String username, String password) {
		controller.login(username, password);
	}
	
	/**
	 * Checks if user is already logged in
	 */
	public void isLoggedIn(boolean stat) {
		this.loginStatus = stat;
	}
	
	/**
	 * Logs out the user/admin
	 */
	public void logOut() {
		
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
	public String getType(){
		return this.type;
	}
	
	/**
	 * Returns the status.
	 */
	public String getStatus() {
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
