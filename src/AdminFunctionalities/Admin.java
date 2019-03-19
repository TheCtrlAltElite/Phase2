/**
 * 
 */
package AdminFunctionalities;

import other.*;
//import AdminFunctionalities.*;

/**
 * @author Ctrl Alt Elite
 *
 */
public class Admin extends Account{

	/**
	 * Creates an Admin object under the super class Account
	 * 
	 * @param email - email (username) for the Admin profile
	 * @param firstName - firstName for the Admin profile
	 * @param lastName - lastName for the Admin profile
	 * @param password - password for the Admin profile
	 * @param type - type of profile which will be 'a' to verify account is an Admin
	 * @param status - status for the Admin profile
	 */
	public Admin(String email, String firstName, String lastName, String password, char type, char status) {
		super(email, firstName, lastName, password, type, status);
	}
//	/**
//	 * Sets the type to the parameter type.
//	 */
//	public void setType(char type) {
//		this.type = type;
//	}
//	
//	/**
//	 * Sets the status to the parameter status.
//	 */
//	public void setStatus(char status) {
//		this.status = status;
//	}
}
