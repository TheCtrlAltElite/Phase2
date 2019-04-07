package UserFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import UserFunctionalities.UserFunctionalityController;

public class UserFunctionalityControllerTest {
	
	private UserFunctionalityController uc;

	@Before
	public void setUp() throws Exception {
		uc = new UserFunctionalityController();
	}
	
	@Test
	public void viewSchoolSuccess ()  {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University name is correct.", result.get(0).equals("YALE"));
		assertTrue("University state is correct.", result.get(1).equals("CONNECTICUT"));
		assertTrue("University location is correct.", result.get(2).equals("SMALL-CITY"));
		assertTrue("University control is correct.", result.get(3).equals("PRIVATE"));
		assertTrue("University number of students is correct.", result.get(4).equals("10000"));
		assertTrue("University percent female is correct.", result.get(5).equals("45"));
		assertTrue("University SAT Verbal is correct.", result.get(6).equals("675"));
		assertTrue("University SAT Math is correct.", result.get(7).equals("675"));
		assertTrue("University expenses is correct.", result.get(8).equals("33014"));
		assertTrue("University percent financial aid is correct.", result.get(9).equals("40"));
		assertTrue("University number of applicants is correct.", result.get(10).equals("11500"));
		assertTrue("University percent admitted is correct.", result.get(11).equals("20"));
		assertTrue("University percent enrolled is correct.", result.get(12).equals("60"));
		assertTrue("University academic scale is correct.", result.get(13).equals("5"));
		assertTrue("University social scale is correct.", result.get(14).equals("3"));
		assertTrue("University quality of life scale is correct.", result.get(15).equals("4"));
		
	}
	
	@Test
	public void viewSchoolInvalid() {
		List<String >result = uc.viewSchool("NOTASCHOOL");
		assertFalse("University does not exist", result.equals("NOTASCHOOL"));
	}
	
	@Test
	public void savedSchoolsListSuccess() {
		ArrayList<String> result = uc.getSavedSchoolsList("juser");
		assertTrue("Univeristy is on users saved school list.", result.get(0).equals("QUEENS"));
		assertTrue("University is on users saved school list.", result.get(1).equals("YALE"));
	}
}
