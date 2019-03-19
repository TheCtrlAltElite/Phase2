/**
 *
 */
package other;

import javax.mail.PasswordAuthentication;

/**
 * @author Ctrl Alt Elite
 *
 */
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication("cmcdatabase2019@gmail.com", "PenguinPower100");
		}
	}
	   

