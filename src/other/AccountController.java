/**
 * 
 */
package other;

import java.awt.*;
import java.util.*;
import java.util.List;

import CMCDatabase.DBController;
import UserFunctionalities.User;

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
				List<String> details = database.getDetailsProfile(username);
				this.account = new Account(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4).charAt(0), details.get(5).charAt(0));
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
	 * Logs the account out.
	 */
	public void logOut() {
		this.account.isLoggedIn(false);
	}
	
	/**
	 * 
	 * @param username
	 */
	public void isUserReal(String username) {
		database.isUserReal(username);
	}
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	public String getPassword(String username) {
		return database.getPassword(username);
	}
	
	/**
	 * 
	 * @param username
	 */
	public List<String> viewProfile(String username) {
		List<String> accDetails = account.getDetailsProfile();
		return accDetails;
	}
	
	/**
	 * 
	 * @param username
	 */
	public void editProfile(String username) {
		Scanner console = new Scanner(System.in);
		List<String> profileDetails = new ArrayList<String>(database.getDetailsProfile(username));
		this.account = new Account(profileDetails.get(0), profileDetails.get(1), profileDetails.get(2), profileDetails.get(3), profileDetails.get(4).charAt(0), profileDetails.get(5).charAt(0));
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
		}
		console.close();
	}
	
	/**
	 * 
	 * @param o - old password
	 * @param n1
	 * @param n2
	 */
	public void resetPassword(String o, String n1, String n2) {
		List<User> listUsers = database.loadUsers();
		for (int i = 0; i < listUsers.size(); i++) {
			if(this.account.getEmail().equals(listUsers.get(i).getEmail())) {
				if(listUsers.get(i).getPassword().equals(o)) {
					if (n1.equals(n2)) {
						if(this.passwordRequirements(n2)) {
							this.account.setPassword(n2);
							database.editUser(listUsers.get(i));
						}
					}
				}	
			}
		}
	}
	
	/**
	 * 
	 * @param email
	 * @param firstName
	 * @param lastName
	 */
	public void recoverPassword(String email, String firstName, String lastName) {

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
	public boolean passwordRequirements(String password){
		if(database.checkPasswordRequirements(password)) {
			return true;
		}
		return false;
	}
}
