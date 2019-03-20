/**
 *
 */
package other;

import javax.mail.PasswordAuthentication;

/**
 * This class is used to Authenticate the login for sending out the email.
 * @author Ctrl Alt Elite
 */
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		
		/*
		 * verifies that the email to send from is a valid email address
		 */
		public PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication("cmcdatabase2019@gmail.com", "PenguinPower100");
		}
	}
	   

