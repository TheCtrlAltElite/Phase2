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
	public void addToSavedSchoolsListSuccess() {
		boolean result = uc.addToSavedSchoolsList3("FBaggins@gmail.com", "YALE");
		assertTrue("University was successfully added to users list.", result);
	}
	
	@Test
	public void addToSavedSchoolsListInvalidUni() {
		boolean result = uc.addToSavedSchoolsList3("FBaggins@gmail.com", "NOTAUNI");
		assertFalse("University does not exist, University not added to list.", result);
	}

	@Test
	public void addToSavedSchoolsListInvalidUniAndUser() {
		boolean result = uc.addToSavedSchoolsList3("NOTAUSER", "NOTAUNI");
		assertFalse("User does not exist, University does not exist.", result);
	}

	@Test
	public void viewSchoolUniversityNameSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University name is correct.", result.get(0).equals("YALE"));
	}
	
	@Test
	public void viewSchoolUniversityLocationSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University state is correct.", result.get(1).equals("CONNECTICUT"));
	}
	
	@Test
	public void viewSchoolUniversityControlSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University location is correct.", result.get(2).equals("SMALL-CITY"));
	}

	@Test
	public void viewSchoolNumStudentsSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University number of students is correct.", result.get(4).equals("10000"));
	}
	
	@Test
	public void viewSchoolPercentFemaleSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University percent female is correct.", result.get(5).equals("45"));
	}
	
	@Test
	public void viewSchoolSATVerbalSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University SAT Verbal is correct.", result.get(6).equals("675"));
	}
	
	@Test
	public void viewSchoolSATMathSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University SAT Math is correct.", result.get(7).equals("675"));
	}
	
	@Test
	public void viewSchoolExpensesSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University expenses is correct.", result.get(8).equals("33014"));
	}
	
	@Test
	public void viewSchoolPercentFinAidSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University percent financial aid is correct.", result.get(9).equals("40"));
	}
	
	@Test
	public void viewSchoolNumApplicantsSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University number of applicants is correct.", result.get(10).equals("11500"));
	}
	
	@Test
	public void viewSchoolPercentAdmitSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University percent admitted is correct.", result.get(11).equals("20"));
	}
	
	@Test
	public void viewSchoolPercentEnrolledSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University percent enrolled is correct.", result.get(12).equals("60"));
	}
	
	@Test
	public void viewSchoolAcademicScaleSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University academic scale is correct.", result.get(13).equals("5"));
	}
	
	@Test
	public void viewSchoolSocialScaleSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University social scale is correct.", result.get(14).equals("3"));
	}
	
	@Test
	public void viewSchoolQualityLifeScaleSuccess() {
		List<String> result = uc.viewSchool("YALE");
		assertTrue("University quality of life scale is correct.", result.get(15).equals("4"));
	}
	
	@Test
	public void viewSchoolInvalid() {
		List<String> result = uc.viewSchool("NOTASCHOOL");
		assertFalse("University does not exist", result.equals("NOTASCHOOL"));
	}

	@Test
	public void savedSchoolsListSuccess() {
		Map<String, String> result = uc.getSavedSchoolsList("juser");
		assertTrue("Univeristy is on users saved school list.", result.containsKey("QUEENS"));
		assertTrue("University is on users saved school list.", result.containsKey("YALE"));
	}

	@Test
	public void savedSchoolsListInvalidUser() {
		Map<String, String> result = uc.getSavedSchoolsList("NOTAUSER");
		assertFalse("User does not exist", result.containsValue(null));
	}

	@Test

	public void savedSchoolsListUserHasNone() {
		Map<String, String> result = uc.getSavedSchoolsList("joettinge001@gmail.com");
		assertFalse("User has no saved universities.", result.containsValue(null));
	}
	
	@Test 
	public void removeSavedSchoolsSuccess() {
		boolean result = uc.removeSavedSchool("FBaggins@gmail.com", "BOSTON UNIVERSITY");
		assertTrue("University has been removed from users list.", result);
	}
	
	@Test
	public void removeSavedSchoolsInvalidUser() {
		boolean result = uc.removeSavedSchool("NOTAUSER", "YALE");
		assertFalse("User does not exist in the system", result);
	}
	
	@Test
	public void removeSavedSchoolsInvalidUniversity() {
		boolean result = uc.removeSavedSchool("FBaggins@gmail.com", "NOTAUNI");
		assertFalse("University does not exist in the system", result); 
	}
	
	@Test
	public void removeSavedSchoolsInvalidUniversityAndUser() {
		boolean result = uc.removeSavedSchool("FBaggins@gmail.com", "NOTAUNI");
		assertFalse("University does not exist in the system", result);
	}
}
