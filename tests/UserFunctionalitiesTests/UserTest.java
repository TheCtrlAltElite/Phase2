package UserFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import UserFunctionalities.User;
import CMCDatabase.DBController;

public class UserTest {

	private User user, realUser;
	private DBController dbc;
	
	@Before
	public void setUp() throws Exception {
		this.user = new User("neuenschwanderlevi@gmail.com", "Levi", "Neuenschwander", "DecentPassword12", 'u', 'Y');
		this.realUser = new User("luser", "Lynn", "User", "ImadRahal4", 'u', 'N');
		this.dbc = new DBController();
	}

	@Test
	public void searchSchoolsTest() {
		boolean works = user.searchSchools(null, "MINNESOTA", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("The method found schools that are similar.", works);
	}
	
	@Test(expected=NullPointerException.class)
	public void searchSchoolsTestFailsWithNoArguments() {
		user.searchSchools(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
	}
	
	@Test
	public void searchSchoolsFailsWithAnEmptyListFromNoSimilaritiesToAnySchools() {
		boolean works = user.searchSchools(null, "asdf", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertFalse("There are no matching schools.", works);
	}
	
	@Test
	public void removeSavedSchoolsTest() {
		boolean removed = realUser.removeSavedSchool("YANKTOWN COLLEGE");
		assertTrue("The university has been removed from that user's list", removed);
		Map<String, String> savedSchools = this.dbc.getSavedSchoolsList(this.realUser.getEmail());
		assertFalse("The school is no longer in the saved schools list.", savedSchools.containsKey("TANKTOWN COLLEGE"));
	}
	
	@Test
	public void removeSavedSchoolsFailsTest() {
		boolean removed = realUser.removeSavedSchool("NotASchool");
		assertFalse("This school is not in the user's saved schools list.", removed);
	}
	
	@Test
	public void appendListTest() {
		boolean added = realUser.appendList("AUGSBURG");
		assertTrue("The university has been added to the saved schools list.", added);
		Map<String, String> savedSchools = this.dbc.getSavedSchoolsList(this.realUser.getEmail());
		assertTrue("The university is actually in the saved schools list.", savedSchools.containsKey("AUGSBURG"));
	}
	
	@Test
	public void appendListFailsTest() {
		boolean added = realUser.appendList("YANKTOWN COLLEGE");
		assertFalse("This school is already in the users saved schools list.", added);
	}
	
	@Test
	public void viewSchoolTest() {
		Map<String, String> details = realUser.getSavedSchoolsList();
		assertTrue("The saved schools list is correct.", details.containsKey("YANKTOWN COLLEGE"));
	}
	
	@After
	public void tearDown(){
		realUser.appendList("YANKTOWN COLLEGE");
		realUser.removeSavedSchool("AUGSBURG");
	}
}
