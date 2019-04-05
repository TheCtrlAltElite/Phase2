 /**
 * 
 */
package AccountFunctionalities;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//imports
import javax.mail.MessagingException;
import CMCDatabase.DBController;

/**
 * @author CtrlAltElite
 */

public class AccountInteraction {

	private AccountController accController;
	private Account account;
	private DBController database;

	
	/**
	 * Constructor for Account interaction
	 */
	public AccountInteraction() {
		this.accController = new AccountController();
		this.account = new Account();
		this.database = new DBController();
		
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
		Scanner console = new Scanner(System.in);
		List<String> profileDetails = new ArrayList<String>(database.getDetailsProfile2(username));
		this.account = new Account(profileDetails.get(0), profileDetails.get(1), profileDetails.get(2), profileDetails.get(3), profileDetails.get(4).charAt(0), profileDetails.get(5).charAt(0));
		while(console.nextLine() != "Stop") {
			System.out.println("Please enter a field you would like to change. CAPS LOCK MATTERS.");
			if(account.getType() == 'u') {			//'u' for user
				System.out.println("First Name, Last Name, Password, or Stop to End Editing.");
			}
			else if(account.getType() == 'a') {		//'a' for admin
				System.out.println("First Name, Last Name, Password, Type, Status or Stop to End Editing.");
			}
			String input = console.nextLine();
			if(input.equals("First Name")) {
				System.out.println("Enter First Name");
				input = console.nextLine();
				account.setFirstName(input);			//account.getFirstName() = input;
			}
			else if(input.equals("Last Name")) {
				System.out.println("Enter Last Name");
				input = console.nextLine();
				account.setLastName(input);				//account.getLastName() = input;
			}
			else if(input.equals("Password")) {
				System.out.println("Enter your password");
				String o = console.nextLine();
				System.out.println("Enter your new password");
				String n1 = console.nextLine();
				System.out.println("Re-enter your new password");
				String n2 = console.nextLine();
				if(n1.equals(n2)) {
					resetPassword(o, n1, n2);
				}
				else {
					System.out.println("New password entries did not match.");
					editProfile(username);
				}
			}
			else if(input.equals("Type") && account.getType() == 'a') {
					System.out.println("Enter New Type");
					input = console.nextLine();
					account.setType(input.charAt(0));					//account.getType() = input.charAt(0);
			}
			else if(input.equals("Status") && account.getType() == 'a') {
					System.out.println("Enter New Status");
					input = console.nextLine();
					account.setStatus(input.charAt(0));					//account.getStatus() = input.charAt(0);
			}
			else if(input.equals("Stop")){
				this.accController.editProfile(username);
				break;
			}
		}
		console.close();
		
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
