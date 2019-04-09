package UserFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import CMCDatabase.DBController;
import UniversityFunctionalities.University;
import UserFunctionalities.UserFunctionalityController;

public class UserFunctionalityControllerTest {

	private UserFunctionalityController uc;
	private DBController db;
	private String username;
	private String schoolTest1;
	private String schoolTest2;

	@Before
	public void setUp() throws Exception {
		uc = new UserFunctionalityController();
		db = new DBController();
		this.username = "FBaggins@gmail.com";
		this.schoolTest1 = "BOSTON UNIVERSITY";
		this.schoolTest2 = "HARVARD";
	}

	@After
	public void tearDown() {
		this.db = new DBController();
		db.addToSavedSchoolsList1(username, schoolTest2);
		db.removeFromSavedSchoolsList(username, schoolTest1);
	}

	// @Test
	// public void searchSchoolsAllNull() {
	// List<University> result = uc.searchSchools(null, null, null,null, null, null,
	// null, null, null, null, null, null, null, null, null, null, null, null, null,
	// null, null, null, null, null, null, null, null, null);
	// assertNull("University was not found.", result);
	// }

	@Test
	public void searchSchoolsSchoolName() {
		List<University> result = uc.searchSchools("YALE", null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("YALE"));
	}

	@Test
	public void searchSchoolsSchoolState() {
		List<University> result = uc.searchSchools(null, "MAINE", null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("UNIVERSITY OF MAINE"));
	}

	@Test
	public void searchSchoolsSchoolLocation() {
		List<University> result = uc.searchSchools(null, null, "-1", null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}

	@Test
	public void searchSchoolsSchoolControl() {
		List<University> result = uc.searchSchools(null, null, null, "-1", null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}

	@Test
	public void searchSchoolsNumStudents() {
		List<University> result = uc.searchSchools(null, null, null, null, "-1", "-1", null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}

	@Test
	public void searchSchoolsPercentFemale() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, "-1", "-1", null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}

	@Test
	public void searchSchoolsVerbalSAT() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, "-1", "-1", null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}

	@Test
	public void searchSchoolsMathSAT() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, "-1",
				"-1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}
	
	@Test
	public void searchSchoolsSchoolExpenses() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, "-1", "-1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}
	 
	@Test
	public void searchSchoolsPercentFinAid() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, "-1", "-1", null, null, null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	} 
	    
	@Test
	public void searchSchoolsNumApplicants() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, "-1", "-1", null, null, null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}  
	
	@Test
	public void searchSchoolsPercentAdmit() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, "-1", "-1", null, null, null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}  
	    
	@Test
	public void searchSchoolsPercentEnrolled() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, "-1", "-1", null, null, null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}   
	    
	@Test
	public void searchSchoolsAcademicScale() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, "-1", "-1", null, null, null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}   
	      
	@Test
	public void searchSchoolsSocialScale() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, "-1", "-1", null, null, null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}   
	    
	@Test
	public void searchSchoolsQualityOfLife() {
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "-1", "-1", null);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	}   
	
	@Test
	public void searchSchoolsEmphases() {
		List<String> emphases = new ArrayList<String>();
		emphases.add("BIOLOGY");
		List<University> result = uc.searchSchools(null, null, null, null, null, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, emphases);
		assertTrue("University was found.", result.get(0).getSchoolName().equals("TESTUNIDONTDELETE"));
	} 
	    
	
	@Test
	public void addToSavedSchoolsListSuccess() {
		boolean result = uc.addToSavedSchoolsList3(username, schoolTest1);
		assertTrue("University was successfully added to users list.", result);
	}
	
	@Test
	public void addToSavedSchoolsListInvalidUni() {
		boolean result = uc.addToSavedSchoolsList3(username, "NOTAUNI");
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
		boolean result = uc.removeSavedSchool(username, schoolTest2);
		assertTrue("University has been removed from users list.", result);
	}
	
	@Test
	public void removeSavedSchoolsInvalidUser() {
		boolean result = uc.removeSavedSchool("NOTAUSER", "YALE");
		assertFalse("User does not exist in the system", result);
	}
	
	@Test
	public void removeSavedSchoolsInvalidUniversity() {
		boolean result = uc.removeSavedSchool(username, "NOTAUNI");
		assertFalse("University does not exist in the system", result); 
	}
	
	@Test
	public void removeSavedSchoolsInvalidUniversityAndUser() {
		boolean result = uc.removeSavedSchool(username, "NOTAUNI");
		assertFalse("University does not exist in the system", result);
	}
}
