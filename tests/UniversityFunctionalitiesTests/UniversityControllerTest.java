package UniversityFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import AdminFunctionalities.AdminFunctionalityController;
import CMCDatabase.DBController;
import UniversityFunctionalities.University;
import UniversityFunctionalities.UniversityController;
import UserFunctionalities.UserFunctionalityController;

public class UniversityControllerTest {
	
	private UniversityController uc;
	private AdminFunctionalityController afc;
	private DBController dbc;
	private UserFunctionalityController ufc;
	
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
	public void editUniversityChangesUniversityState() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(1).equals("MN"));
	}
	
	@Test
	public void editUniversityChangesUniversityLocation() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(2).equals("URBAN"));
	}
	
	@Test
	public void editUniversityChangesUniversityControl() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(3).equals("STATE"));
	}
	
	@Test
	public void editUniversityChangesUniversityNumStudents() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(4).equals("155"));
	}
	
	@Test
	public void editUniversityChangesPercentFemale() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(5).equals("155"));
	}
	
	@Test
	public void editUniversityChangesSATVerbal() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(6).equals("155"));
	}
	
	@Test
	public void editUniversityChangesSATMath() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(7).equals("155"));
	}
	
	@Test
	public void editUniversityChangesExpenses() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(8).equals("155"));
	}
	
	@Test
	public void editUniversityChangesPercentFinancialAid() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(9).equals("155"));
	}
	
	@Test
	public void editUniversityChangesNumberOfApplicants() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(10).equals("155"));
	}
	
	@Test
	public void editUniversityChangesPercentAdmitted() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(11).equals("155"));
	}
	
	@Test
	public void editUniversityChangesPercentEnrolled() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(12).equals("155"));
	}
	
	@Test
	public void editUniversityChangesAcademicScale() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(13).equals("5"));
	}
	
	@Test
	public void editUniversityChangesSocialScale() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(14).equals("5"));
	}
	
	@Test
	public void editUniversityChangesQualityScale() {
		uc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(15).equals("5"));
	}
	
	
	@Test//This does not work
	public void editUniversityFailsForInvalidUniversity() {
		boolean result = uc.editUniversity("IDKWHATSGOINGON", "MN", "URBAN", "STATE", 155, 155, 155, 155, 155, 155, 155, 155, 155, 5, 5, 5);
		assertFalse("Edit University value is FALSE", result);
	}

	//ADD UNIVERSITY WORKS YET HAS NOT BEEN TESTED
	@Test
	public void addUniversityAddsTheSchoolCompletely(){
		uc.addUniversityInfo("ZZZZZUNIVERSITY", "AZ", "URBAN", "STATE", 10000, 544, 677, 23, 54, 12, 31451, 54, 77, 5, 5, 5);
		List<University> school = ufc.searchSchools("ZZZZZUNIVERSITY", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);		
		assertTrue(school.get(0).getSchoolName().equals("ZZZZZUNIVERSITY"));
	}
	
	@Test
	public void removeFromListSuccess() {		
		boolean result = uc.removeFromList("juser","BROWN");                     //make sure that school is present in list of user b4 running :)
		assertTrue("University has been removed from the users list", result);
	}
	
	@Test
	public void removeFromListInvalidUniversity() {
		boolean result = uc.removeFromList("luser","NOTASCHOOL");
		assertFalse("Univseristy does not exist on users list", result);
	}

	
	

	
	

}
