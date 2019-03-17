/**
 * 
 */
package other;

import java.awt.*;
import java.util.*;
import java.util.List;

import CMCDatabase.DBController;

/**
 * @author lneuensch001
 *
 */
public class AccountController {

	private DBController database;
	private Account account;
	
	/**
	 * 
	 */
	public AccountController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		if(database.isUserReal(username)) {
			String pw = database.getPassword(username);
			if(pw.equals(password)) {
				this.account = new Account(database.getDetailsProfile(username));
				this.account.isLoggedIn(true);
				System.out.println("You have been successfully logged in.");
				if(this.account.getStatus() == 'N') {
					System.out.println("Your account has been deactivated.");
				}
			}
		}
		else {
			System.out.println("Your username or password is incorrect. Please try again.");
		}
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
	 * 
	 * @param username
	 */
	public void viewProfile(String username) {
		List accDetails = (List) account.getDetailsProfile();
	}
	
	/**
	 * 
	 * @param username
	 */
	public void editProfile(String username) {
		Scanner console = new Scanner(System.in);
		while(console.nextLine() != "Stop") {
			System.out.println("Please enter a field you would like to change. CAPS LOCK MATTERS.");
			if(account.getType() == 'u') {
				System.out.println("First Name, Last Name, Password, or Stop to End Editing.");
			}
			else if(account.getType() == 'a') {
				System.out.println("First Name, Last Name, Password, Type, Status or Stop to End Editing.");
			}
			String input = console.nextLine();
			if(input.equals("First Name")) {
				System.out.println("Enter First Name");
				input = console.nextLine();
				account.firstName = input;
			}
			else if(input.equals("Last Name")) {
				System.out.println("Enter Last Name");
				input = console.nextLine();
				account.lastName = input;
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
					account.type = input.charAt(0);
			}
			else if(input.equals("Status") && account.getType() == 'a') {
					System.out.println("Enter New Status");
					input = console.nextLine();
					account.status = input.charAt(0);
			}
		}
		console.close();
	}
	
	/**
	 * 
	 * @param O
	 * @param n1
	 * @param n2
	 */
	public void resetPassword(String o, String n1, String n2) {
		database.checkPasswordRequirements(n2);
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
	/**
	 * 
	 * @param password
	 */
	public void passwordRequirements(String password){
		//TODO
	}
}
