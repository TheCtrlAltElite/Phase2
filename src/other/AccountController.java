/**
 * 
 */
package other;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;

import CMCDatabase.DBController;
import UserFunctionalities.User;

/**
 * @author Ctrl Alt Elite
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
	 * Logs in the user
	 * @param username - username associated with the profile to be logged in (Same as email).
	 * @param password - password associated with the profile to be logged in.
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
	 * Checks to make sure the passed username is real in the database.
	 * @param username - checked to make sure it exists in the database.
	 */
	public void isUserReal(String username) {
		database.isUserReal(username);
	}
	
	/**
	 * The method returns the password associated with the username.
	 * @param username - returns the password for the associated username.
	 * @return String which is the password for the profile.
	 */
	public String getPassword(String username) {
		return database.getPassword(username);
	}
	
	/**
	 * Displays the selected profile.
	 * @param username - the profile that will be viewed
	 */
	public List<String> viewProfile(String username) {
		List<String> accDetails = database.getDetailsProfile(username);
		return accDetails;
	}
	
	/**
	 * Edit/Updates the profile in the selected fields.
	 * @param username - the profile that will be edited
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
	 * Resets the password of the user. Checks to make sure old password is current with database, the new password is 
	 * the same in n1 and n2, then sets n2 as the new password.
	 * @param o - old password
	 * @param n1 - new password, must be the same as n2
	 * @param n2 - new password, must be the same as n1
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
	 * Sends an email to the user's email with instructions for resetting their password.
	 * @param email - same as the username.
	 * @param firstName - the first name of the user on the account to verify. Used for security purposes.
	 * @param lastName - the last name of the user on the account to verify. Used for security purposes.
	 * @throws MessagingException 
	 */
	public void recoverPassword(String email, String firstName, String lastName) throws MessagingException {
		//if(database.isUserReal(email)){      //Returns Null??
		
		
		try {
            Properties props = new Properties();
            props.put("mail.smtp.user", "cmcdatabase2019@gmail.com");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            
            System.out.println(props);
            
            Authenticator auth = new SMTPAuthenticator();
            Session session = Session.getInstance(props, auth);
        
        String mail_body = "Here's your new password: ";
        //String encodingOptions = "text/html; charset=UTF-8";
		
		MimeMessage message= new MimeMessage(session);  
		message.setFrom(new InternetAddress("cmcdatabase2019@gmail.com"));  
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("jmuehls@gmail.com"));
		message.setSubject("Password Recovery");  
		message.setText(mail_body); 

        System.out.println(message);
        	Transport.send(message);
        	System.out.println("Message sent!");
        	
    } catch (Exception e) {
        e.printStackTrace();
    	}
	   }
	//}
	
	/**
	 * Sets a jpeg the user wants as their profile pic. Will be named their email to simplify process.
	 * @param jpeg - the name of the jpeg the user wants as their profile pic. Will be named their email to simplify process.
	 */
	public void addProfilePicture(String jpeg) {
		account.setProfilePic(jpeg);
	}
	/**
	 * This method is called in resetPassword(). It checks the passed parameter 'password' to make sure it's up to security standards.
	 * @param password - the new password that will replace the old password.
	 */
	public boolean passwordRequirements(String password){
		if(database.checkPasswordRequirements(password)) {
			return true;
		}
		return false;
	}
}
