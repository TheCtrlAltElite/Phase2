package AdminFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;

import org.junit.Test;

import AccountFunctionalities.Account;
import AdminFunctionalities.AdminFunctionalityController;
import UniversityFunctionalities.University;
import UserFunctionalities.User;

public class AdminFunctionalityControllerTest {

	private AdminFunctionalityController afc;
	
	@Before
	public void setUp() {
		this.afc = new AdminFunctionalityController();
	}
	
	
	@Test
	public void addToSavedSchoolsListSuccess() {
		boolean result = afc.addToSavedSchoolsList3("juser", "BARD");
		assertTrue("Universtiy was successfully added.", result);
	}
	
	@Test
	public void addToSavedSchoolsListInvalidSchool() {
		boolean result = afc.addToSavedSchoolsList3("tux69@csbsju.edu","NOTASCHOOL");
		assertFalse("Universtiy is not in the Database", result);
	}
	
	
	
	
	@Test
	public void viewUniversitiesTest() {
		List<University> listUnis = afc.viewUniversities();
		assertTrue(listUnis.size() == 181);
	}
	
	@Test
	public void viewUsersTest() {
		List<Account> listUsers = afc.viewUsers();
		assertTrue(listUsers.size() == 7);
	}
	
	
	
}
