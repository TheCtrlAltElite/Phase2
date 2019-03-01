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
	String firstName, lastName, email, profilePic, status, type, password;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 */
//	public void login(String username, String password) {
//		
//	}
//	
//	/**
//	 * 
//	 */
//	public boolean isLoggedIn() {
//		
//	}
//	
//	/**
//	 * 
//	 */
//	public void logOut() {
//		
//	}
//	
//	/**
//	 * 
//	 */
////public void resetPassword(o, n1, n2) {
//		
//	}
//	
//	/**
//	 * 
//	 */
//	public List<String> getDetails(){
//		
//	}
	
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
