/**
 * 
 */
package AccountFunctionalities;

import java.util.*;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import CMCDatabase.DBController;
import UniversityFunctionalities.*;
import UserFunctionalities.User;
import other.SMTPAuthenticator;

/**
 * @author CtrlAltElite
 * 
 */
public class AccountController {

	private DBController database;
	private UniversityController unc;
	private Account account;

	/**
	 * 
	 */
	public AccountController() {
		this.database = new DBController();
		this.unc = new UniversityController();
		this.account = new Account();
	}

	/**
	 * Logs in the user
	 * 
	 * @param username
	 *            - username associated with the profile to be logged in (Same as
	 *            email).
	 * @param password
	 *            - password associated with the profile to be logged in.
	 * @throws Exception
	 */
	public Account login(String username, String password) throws Exception {
		String msg = "Your username or password is incorrect. Please try again.";
		if (database.isUserReal(username)) { // makes sure user is real
			String pw = database.getPassword(username);
			if (pw.equals(password)) { // checks that the password enter is correct and corresponds with the account
				List<String> details = database.getDetailsProfile2(username);
				this.account = new Account(details.get(0), details.get(1), details.get(2), details.get(3),
						details.get(4).charAt(0), details.get(5).charAt(0));
				if (this.account.getStatus() == 'N') {
					throw new Exception("Your account has been deactivated.");
				}
				this.account.setLoginStatus(true);
				System.out.println("You have been successfully logged in.");
			} else {
				throw new IllegalArgumentException(msg);
			}
		} else {
			throw new IllegalArgumentException(msg);
		}
		return this.account;
	}

	/**
	 * Logs the account out of the system.
	 */
	public Account logOut() {
		this.account.setLoginStatus(false);
		System.out.println("You have successfully logged out.");
		return this.account;
	}

	/**
	 * Checks to make sure the passed username is real in the database.
	 * 
	 * @param username
	 *            - checked to make sure it exists in the database.
	 */
	public boolean isUserReal(String username) {
		boolean real = database.isUserReal(username);
		if (real == true) {
			System.out.println("User is real.");
		} else {
			System.out.println("User does not exist");
		}
		return real;
	}

	/**
	 * The method returns the password associated with the username.
	 * 
	 * @param username
	 * 
	 * @return String which is the password for the profile.
	 */
	public String getPassword(String username) {
		String pass = database.getPassword(username);
	    
		System.out.println(pass);
		return pass;
	}

	/**
	 * Displays the selected profile.
	 * 
	 * @param username
	 *            - the profile that will be viewed
	 */
	public List<String> viewProfile(String username) {
		List<String> accDetails = database.getDetailsProfile2(username);
		System.out.println(accDetails);
		return accDetails;
	}

	/**
	 * Edit/Updates the profile in the selected fields.
	 * 
	 * @param username
	 *            - the profile that will be edited
	 */
	public boolean editProfile(String firstName, String lastName, String email, String password, char type,
			char status) {
		boolean e = false;
		Account acc = new Account(email, firstName, lastName, password, type, status);
		int record = this.database.editUser(acc);
		List<Account> users = this.database.loadUsers();
		List<String> usernames = new ArrayList<String>();
		for(int i = 0; i < users.size(); i++) {
			usernames.add(users.get(i).getEmail());
		}
		if(record == -1 || !usernames.contains(acc.getEmail())) {
			return e;
		} else {
			e = true;
		}
		return e;
	}

	/**
	 * Resets the password of the user. Checks to make sure old password is current
	 * with database, the new password is the same in n1 and n2, then sets n2 as the
	 * new password.
	 * 
	 * @param o
	 *            - old password
	 * @param n1
	 *            - new password, must be the same as n2
	 * @param n2
	 *            - new password, must be the same as n1
	 */
	public boolean resetPassword(String o, String n1, String n2) { //WILL NEED TO CHANGE ONCE WE START TO USE GUI
	
		List<Account> listUsers = database.loadUsers();
		boolean changeStatus = false;
		for (int i = 0; i < listUsers.size(); i++) { // goes through users in database and finds which one corresponds
														// with the account email
			if (listUsers.get(i).getPassword().equals(o)) { // compares the old password with the current
				if (n1.equals(n2)) { // checks that n1 is the same as n2 to avoid error
					if (this.passwordRequirements(n2)) { // checks that the new password (n2) meets the password
															// requirements
						Account acc = listUsers.get(i);
						acc.setPassword(n2); // sets the password for the account
						changeStatus = true;
						database.editUser(listUsers.get(i));
						System.out.println("Your password has been changed.");// sets the password in database
						break;
					}
				} else {
					System.out.print("Your new passwords do not match.");
				}
			} else if (i == listUsers.size() - 1) {
				System.out.println("Your old password was incorrect. Please try again.");
			}
		}
		return changeStatus;
	}

	/**
	 * Sends an email to the user's email with a randomly generated password.
	 * 
	 * @param email
	 *            - same as the username.
	 * @param firstName
	 *            - the first name of the user on the account to verify. Used for
	 *            security purposes.
	 * @param lastName
	 *            - the last name of the user on the account to verify. Used for
	 *            security purposes.
	 * @throws MessagingException
	 */
	public boolean recoverPassword(String email) throws MessagingException {

		String newPassword = database.sendRecoverEmail(email);
		boolean statusOfReset = this.resetPassword(database.getPassword(email), newPassword, newPassword); // Resets the
																											// recovered
																											// password
																											// as the
																											// new
																											// password
		if (statusOfReset) {
			try {
				Properties props = new Properties();
				props.put("mail.smtp.user", "cmcdatabase2019@gmail.com"); // sets email to be sent from
																			// cmcdatabase2019@gmail.com
				props.put("mail.smtp.host", "smtp.gmail.com"); // sets server host as gmail
				props.put("mail.smtp.starttls.enable", "true");
				props.put("mail.smtp.auth", "true");
				props.put("mail.smtp.port", "587"); // sets the port

				System.out.println(props); // displays server information

				Authenticator auth = new SMTPAuthenticator();
				Session session = Session.getInstance(props, auth);

				String mail_body = "Here's your new password: " + newPassword; // body of email

				MimeMessage message = new MimeMessage(session); // creates MimeMessage object to send email
				message.setFrom(new InternetAddress("cmcdatabase2019@gmail.com")); // sets from email which is
																					// cmcdatabase2019@gmail.com
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); // receiver of
																											// the email
				message.setSubject("Password Recovery"); // subject of the email
				message.setText(mail_body); // sets the body of the email to mail_body

				System.out.println(message); // shows email has begun to send out
				Transport.send(message); // Sends out email
				System.out.println("Message sent!"); // Informs message is sent

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return statusOfReset;
	}
	
	/**
	 * Sets a jpeg the user wants as their profile pic. Will be named their email to
	 * simplify process.
	 * 
	 * @param jpeg
	 *            - the name of the jpeg the user wants as their profile pic. Will
	 *            be named their email to simplify process.
	 */
	public boolean addProfilePicture(String email, String jpeg) {
		List<Account> accounts = database.loadUsers();
		for (int i = 0; i < accounts.size(); i++) {
			if (accounts.get(i).getEmail().equals(email)) {
				accounts.get(i).setProfilePic(jpeg);
				return true;
			}
		}
		return false;
	}

	/**
	 * This method is called in resetPassword(). It checks the passed parameter
	 * 'password' to make sure it's up to security standards.
	 * 
	 * @param password
	 *            - the new password that will replace the old password.
	 */
	public boolean passwordRequirements(String password) {
		return database.checkPasswordRequirements(password); // returns true if checkPasswordRequirements(password) returned true
	}
}
