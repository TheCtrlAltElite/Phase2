/**
 * 
 */
package other;

/**
 * @author lneuensch001
 *
 */

public class AccountInteraction {

	private AccountController accController;

	
	/**
	 * 
	 */
	public AccountInteraction() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Checks the username and password against the database
	 * Grants account access to the website or alerts them that their credentials were
	 * incorrect.
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		accController.login(username, password);
	}

	/**
	 * 
	 */
	public void logOut() {
		accController.logOut();
	}
	
	/**
	 * 
	 * @param username
	 */
	public void isUserReal(String username) {
		accController.isUserReal(username);
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String getPassword(String username) {
		return accController.getPassword(username);
		
	}
	
	/**
	 * Displays a page with the account profile information
	 * 
	 * @param username
	 */
	public void viewProfile(String username) {
		accController.viewProfile(username);
	}
	
	/**
	 * 
	 * @param username
	 */
	public void editProfile(String username) {
		accController.editProfile(username);
	}
	
	/**
	 * 
	 * @param O
	 * @param n1
	 * @param n2
	 */
	public void resetPassword(String o, String n1, String n2) {
		accController.resetPassword(o, n1, n2);
	}
	
	/**
	 * 
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public void recoverPassword(String email, String firstName, String lastName) {
		accController.recoverPassword(email, firstName, lastName);
	}
	
	/**
	 * 
	 * @param jpeg
	 */
	public void addProfilePicture(String jpeg) {
		//TODO
	}
}
