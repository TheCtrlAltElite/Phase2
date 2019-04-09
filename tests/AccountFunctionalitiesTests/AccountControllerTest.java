package AccountFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;

import javax.mail.MessagingException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import AccountFunctionalities.AccountController;

public class AccountControllerTest {

	private AccountController acc;
	
	@Before
	public void setUp() throws Exception {
		acc = new AccountController();
	}
	
	@Test
	public void loginTest_correctArguments() throws Exception {
		acc.login("juser", "JohnMiller5");
		
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void loginTest_invalidUserName() throws Exception {
		acc.login("jjjjjjjj", "JohnMiller5");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void loginTest_invalidPassword() throws Exception{
		acc.login("juser", "JhonMiller5");
	}
	
	@Test(expected=Exception.class)
	public void loginTest_inactiveAccount() throws Exception {
		acc.login("luser", "ImadRahal4");
	}
	
	@Test
	public void logOutTest() {
		acc.logOut();
	}
	
	@Test
	public void isUserRealTest() {
		boolean result = acc.isUserReal("juser");
		assertTrue("The user juser is real.", result);
	}
	
	@Test
	public void isUserRealFailTest() {
		boolean result = acc.isUserReal("Nobody");
		assertFalse("The user Nobody is not a user.", result);
	}
	
	@Test
	public void getPasswordTest() {
		String pass = acc.getPassword("juser");
		assertTrue("The user juser's password is: ", pass.equals("JohnMiller5"));
	}
	
	@Test
	public void getPasswordFailTest() {
		String pass = acc.getPassword("Nobody");
		assertTrue("The user Nobody is not a user", pass.equals("That user does not exist."));
	}
	
	@Test
	public void viewProfileTest() {
		List<String> details = acc.viewProfile("juser");
		assertTrue(details.get(0).equals("John"));
		assertTrue(details.get(1).equals("User"));
		assertTrue(details.get(2).equals("juser"));
		assertTrue(details.get(3).equals("JohnMiller5"));
		assertTrue(details.get(4).equals("u"));
		assertTrue(details.get(5).equals("Y"));
	}
	
	@Test
	public void viewProfileFailTest() {
		List<String> details = acc.viewProfile("Nobody");
		assertTrue("The user Nobody is not a user", details.isEmpty());
	}
	
	@Test
	public void editProfileFirstNameTest() {
		boolean result = acc.editProfile("Rigby", "tux", "tux420@csbsju.edu", "PenguinPower420", 'u', 'Y');
		assertTrue(result);
		List<String> details = acc.viewProfile("tux420@csbsju.edu");
		assertTrue("The first name is now Rigby for username tux420@csbsju.edu", details.get(0).equals("Rigby"));
	}
	
	@Test
	public void editProfileLastNameTest() {
		boolean result = acc.editProfile("Eli2", "Neuenschwander", "tux420@csbsju.edu", "PenguinPower420", 'u', 'Y');
		assertTrue(result);
		List<String> details = acc.viewProfile("tux420@csbsju.edu");
		assertTrue("The last name is now Neuenschwander for username tux420@csbsju.edu", details.get(1).equals("Neuenschwander"));
	}
	
	@Test
	public void editProfileUsernameFailsTest() {
		boolean result = acc.editProfile("Eli2", "Tux", "fakeUserName@csbsju.edu", "PenguinPower420", 'u', 'Y');
		assertFalse(result);
		List<String> details = acc.viewProfile("fakeUserName@csbsju.edu");
		assertTrue("The username has not changed so this user does not exist.", details.isEmpty());
	}
	
	@Test
	public void editProfilePasswordTest() {
		boolean result = acc.editProfile("Eli2", "Tux", "tux420@csbsju.edu", "TuxIsOurSavior1", 'u', 'Y');
		assertTrue(result);
		List<String> details = acc.viewProfile("tux420@csbsju.edu");
		assertTrue("This user's password is now TuxIsOurSavior1", details.get(3).equals("TuxIsOurSavior1"));
	}
	
	@Test
	public void editProfileTypeTest() {
		boolean result = acc.editProfile("Eli2", "Tux", "tux420@csbsju.edu", "PenguinPower420", 'a', 'Y');
		assertTrue(result);
		List<String> details = acc.viewProfile("tux420@csbsju.edu");
		assertTrue("This user's type is now admin", details.get(4).equals("a"));
	}
	
	@Test
	public void editProfileStatusTest() {
		boolean result = acc.editProfile("Eli2", "Tux", "tux420@csbsju.edu", "PenguinPower420", 'u', 'N');
		assertTrue(result);
		List<String> details = acc.viewProfile("tux420@csbsju.edu");
		assertTrue("This user's status is now inactive.", details.get(5).equals("N"));
	}
	
	/**
	 * Old and new passwords must be changed each time.
	 */
	@Test
	public void resetPasswordTest() {
		boolean resetStatus = acc.resetPassword("TuxIsOurSavior1", "SuperPenguinTux1", "SuperPenguinTux1");
		assertTrue(resetStatus);
		String newPassSet = acc.getPassword("tux69@csbsju.edu");
		assertTrue("The new password has been set.", newPassSet.equals("SuperPenguinTux1"));
	}
	
	@Test
	public void resetPasswordIncorrectOldPasswordTest() {
		boolean resetStatus = acc.resetPassword("Nobody", "PenguinAtHeart123", "PenguinAtHeart123");
		assertFalse(resetStatus);
	}
	
	@Test
	public void resetPasswordReEnterDoesNotMatchTest() {
		boolean resetStatus = acc.resetPassword("TuxIsOurSavior1", "NewPasswordToBeChanged123", "DifferentPassword123");
		assertFalse(resetStatus);
		String newPassSet = acc.getPassword("tux69@csbsju.edu");
		assertTrue("The password has not changed.", newPassSet.equals("TuxIsOurSavior1"));
	}
	
	@Test
	public void resetPasswordTest_doesNotMeetRequirements() {
		boolean resetStatus = acc.resetPassword("TuxIsOurSavior1", "ThIsPaSsWoRdWoNtWoRk", "ThIsPaSsWoRdWoNtWoRk");
		assertFalse(resetStatus);
		String newPassSet = acc.getPassword("tux69@csbsju.edu");
		assertTrue("The password has not changed.", newPassSet.equals("TuxIsOurSavior1"));
	}
	
	@Test
	public void passwordRequirementsTest() {
		boolean requirements = acc.passwordRequirements("ThisIsAValidPassword1");
		assertTrue(requirements);
	}
	
	@Test
	public void recoverPasswordSuccessTest() throws MessagingException {
		boolean result = acc.recoverPassword("jmuehls@gmail.com");
		assertTrue("Recover Password returned TRUE and was successful.", result);
	}
	
	@Test
	public void addProfilePictureCorrectEmailTest() {
		boolean result = acc.addProfilePicture("joettinge001@gmail.com", "Tux-icon.png");
		assertTrue("Add Profile Picture returned TRUE and was successful.", result);
	}
	
	@Test
	public void addProfilePictureIncorrectEmailTest() {
		boolean result = acc.addProfilePicture("joe777", "Tux-icon.png");
		assertFalse("Add Profile Picture returned FALSE and was NOT successful.", result);
	}
	
	@After
	public void reset() {
		acc.resetPassword("SuperPenguinTux1", "TuxIsOurSavior1", "TuxIsOurSavior1");
		//acc.editProfile("Eli2", "Tux", "tux420@csbsju.edu", "TuxIsOurSavior1", 'u', 'Y');
	}
}
