package AccountFunctionalitiesTests;

import static org.junit.Assert.*;

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
}
