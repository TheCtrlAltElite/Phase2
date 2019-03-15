/**
 * 
 */
package AdminFunctionalities;

import other.*;

import java.awt.*;

import AdminFunctionalities.*;

/**
 * @author lneuensch001
 *
 */
public class Admin extends Account{

	/**
	 * Creates an Admin object
	 * 
	 * @param List adDetails
	 */
	public Admin(String email, String firstName, String lastName, String password, char type, char status) {
		super(email, firstName, lastName, password, type, status);
	}
	 /**
	  * Sets the type for an account
	  * 
	  * @param type
	  */
	public void setType(String type) {
			//TODO 
	}
	/**
	 * Sets the status for an account
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
			//TODO
	}
}
