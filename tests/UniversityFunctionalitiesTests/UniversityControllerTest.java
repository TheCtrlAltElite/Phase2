package UniversityFunctionalitiesTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import UniversityFunctionalities.UniversityController;

public class UniversityControllerTest {
	
	private UniversityController uc;
	
	@Before
	public void setUp() throws Exception {
		uc = new UniversityController();
	}

	@Test
	public void addToSavedSchoolsListSuccess() {
		boolean result = uc.addToSavedSchoolsList2("tux69@csbsju.edu", "YALE");
		assertTrue("Universtiy was successfully added.", result);
	}//CREATE A METHOD THAT CHECKS TO MAKE SURE THE UNIVERSITY IS ADDED TO THE LIST
	
	@Test
	public void addToSavedSchoolsListInvalidSchool() {
		boolean result = uc.addToSavedSchoolsList2("tux69@csbsju.edu","NOTASCHOOL");
		assertFalse("Universtiy is not in the Database", result);
	}
	

	
	

}
