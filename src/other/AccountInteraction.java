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
		//TODO
	}
	
	/**
	 * 
	 * @param username
	 */
	public void isUserReal(String username) {
		//TODO
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String getPassword(String username) {
		//TODO
		return "";
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
		//TODO
	}
	
	/**
	 * 
	 * @param jpeg
	 */
	public void addProfilePicture(String jpeg) {
		//TODO
	}
}
