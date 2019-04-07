package UniversityFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
		afc = new AdminFunctionalityController();
		dbc = new DBController();
		ufc = new UserFunctionalityController();
		
		
	}

	@Test
	public void addToSavedSchoolsListSuccess() {
		boolean result = uc.addToSavedSchoolsList2("juser", "BARD");
		assertTrue("Universtiy was successfully added.", result);
	}//CREATE A METHOD THAT CHECKS TO MAKE SURE THE UNIVERSITY IS ADDED TO THE LIST
	
	@Test
	public void addToSavedSchoolsListInvalidSchool() {
		boolean result = uc.addToSavedSchoolsList2("tux69@csbsju.edu","NOTASCHOOL");
		assertFalse("Universtiy is not in the Database", result);
	}
	
	@Test
	public void editUniversityChangesUniversityState() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(1).equals("MINNESOTA"));
	}
	
	@Test
	public void editUniversityChangesUniversityLocation() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(2).equals("URBAN"));
	}
	
	@Test
	public void editUniversityChangesUniversityControl() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(3).equals("STATE"));
	}
	
	@Test
	public void editUniversityChangesUniversityNumStudents() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(4).equals("200"));
	}
	
	@Test
	public void editUniversityChangesPercentFemale() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(5).equals("200"));
	}
	
	@Test
	public void editUniversityChangesSATVerbal() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(6).equals("200"));
	}
	
	@Test
	public void editUniversityChangesSATMath() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(7).equals("200"));
	}
	
	@Test
	public void editUniversityChangesExpenses() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(8).equals("200"));
	}
	
	@Test
	public void editUniversityChangesPercentFinancialAid() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(9).equals("200"));
	}
	
	@Test
	public void editUniversityChangesNumberOfApplicants() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(10).equals("200"));
	}
	
	@Test
	public void editUniversityChangesPercentAdmitted() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(11).equals("200"));
	}
	
	@Test
	public void editUniversityChangesPercentEnrolled() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(12).equals("200"));
	}
	
	@Test
	public void editUniversityChangesAcademicScale() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(13).equals("5"));
	}
	
	@Test
	public void editUniversityChangesSocialScale() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(14).equals("5"));
	}
	
	@Test
	public void editUniversityChangesQualityScale() {
		uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		List<String> details = uc.getDetailsUni("CSBSJU");
		assertTrue(details.get(15).equals("5"));
	}
	
	
	@Test//This does not work
	public void editUniversityFailsForInvalidUniversity() {
		boolean result = uc.editUniversity("IDKWHATSGOINGON", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		assertFalse("Edit University value is FALSE", result);
	}
	
	@Test
	public void editUniversityMakesSureTheUniversityIsValid() {
		boolean result = uc.editUniversity("CSBSJU", "MINNESOTA", "URBAN", "STATE", 200, 200, 200, 200, 200, 200, 200, 200, 200, 5, 5, 5);
		assertTrue("Edit University value is TRUE", result);
	}

	//ADD UNIVERSITY WORKS YET HAS NOT BEEN TESTED
	@Test
	public void addUniversityAddsTheSchoolCompletely(){
		uc.addUniversityInfo("ZZZZZUNIVERSITY", "AZ", "URBAN", "STATE", 10000, 544, 677, 23, 54, 12, 31451, 54, 77, 5, 5, 5);
		List<University> school = ufc.searchSchools("ZZZZZUNIVERSITY", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);		
		assertTrue(school.get(0).getSchoolName().equals("ZZZZZUNIVERSITY"));
	}

	@Test
	public void recommendedSchoolsGetsClosestSchool() {
		List<University> listUnis = dbc.loadUniversities();
		List<University> recUnis = uc.recommendedSchools(listUnis.get(4));
		assertTrue(recUnis.get(0).getSchoolName().equals("UNIVERSITY OF ALABAMA"));	
	}
	
	@Test
	public void recommendedSchoolsGetsSecondClosestSchool() {
		List<University> listUnis = dbc.loadUniversities();
		List<University> recUnis = uc.recommendedSchools(listUnis.get(4));
		assertTrue(recUnis.get(1).getSchoolName().equals("UNIVERSITY OF GEORGIA"));	
	}
	
	@Test
	public void recommendedSchoolsThirdGetsClosestSchool() {
		List<University> listUnis = dbc.loadUniversities();
		List<University> recUnis = uc.recommendedSchools(listUnis.get(4));
		assertTrue(recUnis.get(2).getSchoolName().equals("UNIVERSITY OF MAINE"));	
	}
	
	@Test
	public void recommendedSchoolsGetsFourthClosestSchool() {
		List<University> listUnis = dbc.loadUniversities();
		List<University> recUnis = uc.recommendedSchools(listUnis.get(4));
		assertTrue(recUnis.get(3).getSchoolName().equals("PURDUE"));	
	}
	
	@Test
	public void recommendedSchoolsGetsFifthClosestSchool() {
		List<University> listUnis = dbc.loadUniversities();
		List<University> recUnis = uc.recommendedSchools(listUnis.get(4));
		assertTrue(recUnis.get(4).getSchoolName().equals("FLORIDA STATE"));	

	}
	
	/*@Test
	public void compareSchoolsReturnsCorrectValue() {
		List<University> listUnis = dbc.loadUniversities();
		Map<Float, University> scores = uc.compareUniversity(listUnis.get(0));
		String result = scores.get((float)5.482062).getSchoolName();
		assertTrue(result.equals("DALLAS BAPTIST COLLEGE"));
	}*/
	
	@Test
	public void getDetailsUniWorksForSchoolName() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(0).equals("YALE"));
	}
	@Test
	public void getDetailsUniWorksForSchoolState() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(1).equals("CONNECTICUT"));
	}
	@Test
	public void getDetailsUniWorksForSchoolLocation() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(2).equals("SMALL-CITY"));
	}
	@Test
	public void getDetailsUniWorksForSchoolControl() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(3).equals("PRIVATE"));
	}
	@Test
	public void getDetailsUniWorksForSchoolNumStudents() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(4).equals("10000"));
	}
	@Test
	public void getDetailsUniWorksForSchoolPercentFemale() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(5).equals("45"));
	}
	@Test
	public void getDetailsUniWorksForSchoolVerbalSAT() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(6).equals("675"));
	}
	@Test
	public void getDetailsUniWorksForSchoolMathSAT() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(7).equals("675"));
	}
	@Test
	public void getDetailsUniWorksForSchoolExpenses() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(8).equals("33014"));
	}
	
	@Test
	public void getDetailsUniWorksForSchoolPercentFinancialAid() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(9).equals("40"));
	}
	@Test
	public void getDetailsUniWorksForSchoolNumApplicants() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(10).equals("11500"));
	}
	@Test
	public void getDetailsUniWorksForSchoolPercentAdmitted() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(11).equals("20"));
	}
	@Test
	public void getDetailsUniWorksForSchoolPercentEnrolled() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(12).equals("60"));
	}
	@Test
	public void getDetailsUniWorksForSchoolAcademicScale() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(13).equals("5"));
	}
	@Test
	public void getDetailsUniWorksForSchoolSocialScale() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(14).equals("3"));
	}
	@Test
	public void getDetailsUniWorksForSchoolQualityScale() {
		List<String> details = uc.getDetailsUni("YALE");
		assertTrue(details.get(15).equals("4"));
	}
}
