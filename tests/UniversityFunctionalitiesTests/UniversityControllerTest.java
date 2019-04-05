package UniversityFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void editUniversityChangesFields() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(0).equals("CSBSJU"));
		assertTrue(details.get(1).equals("MN"));
		assertTrue(details.get(2).equals("URBAN"));
		assertTrue(details.get(3).equals("STATE"));
		assertTrue(details.get(4).equals("155"));
		assertTrue(details.get(5).equals("155"));
		assertTrue(details.get(6).equals("155"));
		assertTrue(details.get(7).equals("155"));
		assertTrue(details.get(8).equals("155"));
		assertTrue(details.get(9).equals("155"));
		assertTrue(details.get(10).equals("155"));
		assertTrue(details.get(11).equals("155"));
		assertTrue(details.get(12).equals("155"));
		assertTrue(details.get(13).equals("5"));
		assertTrue(details.get(14).equals("5"));
		assertTrue(details.get(15).equals("5"));	
	}
	
	@Test
	public void editUniversityFailsForInvalidUniversity() {
		boolean result = uc.editUniversity("IDKWHATSGOINGON", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		assertFalse("Edit University value is FALSE", result);
	}

	public void removeFromListSuccess() {
		boolean result = uc.removeFromList("luser","YALE");                     //make sure that school is present in list of user b4 running :)
		assertTrue("University has been removed from the users list", result);
	}
	
	@Test
	public void removeFromListInvalidUniversity() {
		boolean result = uc.removeFromList("luser","NOTASCHOOL");
		assertFalse("Univseristy does not exist on users list", result);
	}

		

	
	

}
