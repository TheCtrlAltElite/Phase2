 /**
 * 
 */
package AccountFunctionalities;

//imports
import javax.mail.MessagingException;

/**
 * @author CtrlAltElite
 */

public class AccountInteraction {

	private AccountController accController;

	
	/**
	 * Constructor for Account interaction
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
	 * @throws Exception 
	 */
	public void login(String username, String password) throws Exception {
		accController.login(username, password);
	}

	/**
	 * Calls the logOut() method from AccountController
	 */
	public void logOut() {
		accController.logOut();
	}
	
	/**
	 * Calls the isUserReal() Method in AccountContoller
	 * @param username
	 */
	public void isUserReal(String username) {
		accController.isUserReal(username);
	}
	
	/**
	 * returns the password for the username given by calling getPassword() in AccountController
	 * @param username
	 * @return the password for the account
	 */
	public String getPassword(String username) {
		return accController.getPassword(username);
		
	}
	
	/**
	 * Displays a page with the account profile information by calling view profile in AccountController
	 * 
	 * @param username
	 */
	public void viewProfile(String username) {
		accController.viewProfile(username);
	}
	
	/**
	 *allows the user to edit their profile by calling edit profile in AccountController
	 * @param username
	 */
	public void editProfile(String username) {
		accController.editProfile(username);
	}
	
	/**
	 * Allows the user to reset their password by calling resetPassword() in AccountController
	 * @param O
	 * @param n1
	 * @param n2
	 */
	public void resetPassword(String o, String n1, String n2) {
		accController.resetPassword(o, n1, n2);
	}
	
	/**
	 * sends the user an email to allow them to change their password by
	 * calling recoverPassword in AccountController
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @throws MessagingException 
	 */
	public void recoverPassword(String email, String firstName, String lastName) throws MessagingException {
		accController.recoverPassword(email, firstName, lastName);
	}
	
	/**
	 * adds a profile picture by finding the string  JPEG the picture is saved as by
	 * calling addProfile picture in Account Controller
	 * @param jpeg
	 */
	public void addProfilePicture(String jpeg) {
		accController.addProfilePicture(jpeg);
	}
}
