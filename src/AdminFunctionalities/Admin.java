/**
 * 
 */
package AdminFunctionalities;

import other.*;

import java.awt.*;

import AdminFunctionalities.*;

/**
 * @author Ctrl Alt Elite
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
