package AccountFunctionalitiesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import AccountFunctionalities.Account;

public class AccountTest {
	
	private Account testAccount;
	private Account testAdminAccount;

	
	@Before
	public void setUp() throws Exception {
		testAccount = new Account("rookid9492@hotmail.com", "Randall", "Clintsman", "TestPassword72", 'u', 'y');
		testAdminAccount = new Account ("jiverson002@csbsju.edu", "Jeremy", "Iverson", "NikeAirMax99", 'a', 'n');
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
		new Account("irahal@csbsju.edu","Imad", "Rahal", "PenguinPower720",'a', 'w');
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void AccountConstructerTypeFailTest() {
		new Account("irahal@csbsju.edu","Imad", "Rahal", "PenguinPower720",'o', 'y');
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

	@Test
	public void getFirstNameTest() {
		String firstName = testAccount.getFirstName();
		assertTrue("The First name is Randall", firstName.equals("Randall"));
	}
	
	@Test
	public void getLastNameTest() {
		String lastName = testAccount.getLastName();
		assertTrue("The Last name is Clintsman", lastName.equals("Clintsman"));
	}
	
	@Test
	public void getTypeUserTest() {
		char type = testAccount.getType();
		assertTrue("The Type of Account is user", type == 'u');
	}
	
	@Test
	public void getTypeAdminTest() {
		char type = testAdminAccount.getType();
		assertTrue("The Type of Account is Admin", type == 'a');
	}
	
	@Test
	public void getStatusActiveTest() {
		char status = testAccount.getStatus();
		assertTrue("The Status of Account is active", status == 'y');
	}
	
	@Test
	public void getStatusDeactivatedTest() {
		char status = testAdminAccount.getStatus();
		assertTrue("The Status of Account is deactivated", status == 'n');
	}
	
	@Test
	public void getPasswordTest() {
		String password = testAccount.getPassword();
		assertTrue("The Password for the Account is TestPassword72", password.equals("TestPassword72"));
	}
	
	@Test
	public void setFirstNameTest() {
		testAccount.setFirstName("Eli");
		assertTrue("The first name was set to Eli", testAccount.getFirstName().equals("Eli"));
	}
	
	@Test
	public void setLastNameTest() {
		testAccount.setLastName("Anderson");
		assertTrue("The last name was set to Anderson", testAccount.getLastName().equals("Anderson"));
	}
	
	@Test
	public void setTypeAdminTest() {
		testAccount.setType('a');
		assertTrue("The Account has been set to type Admin", testAccount.getType() == 'a');
	}
	
	@Test
	public void setTypeUserTest() {
		testAdminAccount.setType('u');
		assertTrue("The Account has been set to type Admin", testAdminAccount.getType() == 'u');
	}
	
	@Test
	public void setStatusDeactivatedTest() {
		testAccount.setStatus('n');
		assertTrue("The Account has been deactivated", testAccount.getStatus() == 'n');
	}
	
	@Test
	public void setStatusActiveTest() {
		testAdminAccount.setStatus('y');
		assertTrue("The Account has been deactivated", testAccount.getStatus() == 'y');
	}
	
	@Test
	public void setPasswordTest() {
		testAccount.setPassword("ChesterCheetah232");
		assertTrue("The Password has been set to ChesterCheetah232", testAccount.getPassword().equals("ChesterCheetah232"));
	}
}
