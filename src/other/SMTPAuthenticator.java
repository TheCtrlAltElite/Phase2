/**
 * 
 */
package other;

import javax.mail.PasswordAuthentication;

/**
 * @author rclintsma001
 *
 */
	public class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication(){
			return new PasswordAuthentication("cmcdatabase2019@gmail.com", "PenguinPower100");
		}
	}
	   

