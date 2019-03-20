/**
 *
 */
package other;

import javax.mail.PasswordAuthentication;

/**
 * This class is used to Authenticate the login for sending out the email.
 * @author CtrlAltElite
 */
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication("cmcdatabase2019@gmail.com", "PenguinPower100");
		}
	}
	   

