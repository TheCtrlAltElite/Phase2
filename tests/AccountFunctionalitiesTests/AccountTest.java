package AccountFunctionalitiesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AccountFunctionalities.Account;

public class AccountTest {
	
	private Account testAccount;
	
	@Before
	public void setUp() throws Exception {
		testAccount = new Account("rookid9492@hotmail.com", "Randall", "Clintsman", "TestPassword72", 'u', 'y');
	}
	
	@Test
	public void AccountConstructerBlank() {
		Account blank = new Account();
	}
	
	@Test
	public void AccountConstructerUserActive() {
		Account account = new Account("irahal@csbsju.edu","Imad","Rahal","PenguinPower720",'u','y');
	}
	
	@Test
	public void AccountConstructerUserDeactivated() {
		Account account = new Account("irahal@csbsju.edu","Imad","Rahal","PenguinPower720",'u','n');
	}
	
	@Test
	public void AccountConstructerAdminActive() {
		Account account = new Account("irahal@csbsju.edu","Imad","Rahal","PenguinPower720",'a','y');
	}
	
	@Test
	public void AccountConstructerAdminDeactivated() {
		Account account = new Account("irahal@csbsju.edu","Imad","Rahal","PenguinPower720",'a','n');
	}

	@Test(expected=IllegalArgumentException.class)
	public void AccountConstructerStatusFailTest() {
		Account account = new Account("irahal@csbsju.edu","Imad", "Rahal", "PenguinPower720",'a', 'w');
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void AccountConstructerTypeFailTest() {
		Account account = new Account("irahal@csbsju.edu","Imad", "Rahal", "PenguinPower720",'o', 'y');
	}
	
	@Test
	public void setLoginStatusTrue() {
		testAccount.setLoginStatus(true);
		assertTrue("Account set to true", testAccount.getLoginStatus());
	}
	
	@Test
	public void setLoginStatusFalse() {
		testAccount.setLoginStatus(false);
		assertFalse("Account set to False", testAccount.getLoginStatus());
	}
	
	//Unsure how to test this \/\/\/\/\/\/
	
	@Test
	public void getLoginStatusTest() {
		testAccount.setLoginStatus(true);
		boolean result = testAccount.getLoginStatus();
		assertTrue("Login Status is True", result);
	}
	
	@Test
	public void getEmailTest() {
		String email = testAccount.getEmail();
		assertTrue("The email is rookid9492@hotmail.com", email.equals("rookid9492@hotmail.com"));
	}
	
	@Test
	public void setProfilePicTest() {
		testAccount.setProfilePic("rookid9492@hotmail.com");
		assertTrue("The profile picture was set", testAccount.getProfilePic().equals("rookid9492@hotmail.com"));
	}
	
	@Test
	public void getProfilePicTest() {
		testAccount.setProfilePic("rookid9492@hotmail.com");
		String jpeg = testAccount.getProfilePic();
		assertTrue("The profile picture that is received is named rookid9492@hotmail.com", jpeg.equals("rookid9492@hotmail.com"));
	}

}
