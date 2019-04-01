package AccountFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;

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
	public void editProfileTest() {
		////////////////TODO///////////////////
	}
	
	@Test
	public void resetPasswordTest() {
		boolean resetStatus = acc.resetPassword("SuperPenguinTux1", "TuxIsOurSavior1", "TuxIsOurSavior1");
		assertTrue(resetStatus);
		String newPassSet = acc.getPassword("tux69@csbsju.edu");
		assertTrue("The new password has been set.", newPassSet.equals("TuxIsOurSavior1"));
	}
}
