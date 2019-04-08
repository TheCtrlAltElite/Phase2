package AdminFunctionalitiesTests;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import AccountFunctionalities.Account;
import AdminFunctionalities.AdminFunctionalityController;
import CMCDatabase.DBController;
import UniversityFunctionalities.University;


public class AdminFunctionalityControllerTest {

	private AdminFunctionalityController afc;
	private DBController dbc;
	private String username;
	private String schoolTest1;
	
	@Before
	public void setUp() {
		this.afc = new AdminFunctionalityController();
		this.username = "fuser";
		this.schoolTest1 = "reed";
	}
	
	@After
	public void  tearDown() {
		this.dbc = new DBController();
		dbc.removeFromSavedSchoolsList(this.username, this.schoolTest1);
	}
	
	@Test
	public void addToSavedSchoolsList3Success() {
		int result = afc.addToSavedSchoolsList3(this.username, this.schoolTest1);
		assertEquals("University was successfully added.", 4, result);
	}
	
	@Test
	public void addToSavedSchoolsList3InvalidSchool() {
		int result = afc.addToSavedSchoolsList3("fuser", "NOTASCHOOL");
		assertEquals("Universtiy is not in the Database", 5, result);
	}
	
	@Test
	public void addToSavedSchoolsList3InvalidUser() {
		int result = afc.addToSavedSchoolsList3("user", "yale");
		assertEquals("User is not in the Database", 2, result);
	}
	
	@Test
	public void addToSavedSchoolsList3AlreadyExistsInList() {
		int result = afc.addToSavedSchoolsList3("fuser", "yale");
		assertEquals("University is already in the User's SavedSchool list", 6, result);
	}
	
//	@Test
//	public void addUniversity() {
//		boolean = ;
//		assetTrue("",);
//	}
	
	@Test
	public void viewUniversitiesTest() {
		List<University> listUnis = afc.viewUniversities();
		assertTrue(listUnis.size() == 181);
	}
	
	@Test
	public void viewUsersTest() {
		List<Account> listUsers = afc.viewUsers();
		assertTrue(listUsers.size() == 9);
	}
	
	
	
}
