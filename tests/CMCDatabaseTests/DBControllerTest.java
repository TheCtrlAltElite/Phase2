package CMCDatabaseTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import CMCDatabase.DBController;
import UniversityFunctionalities.University;

public class DBControllerTest {
	
	private DBController dbc;
	
	@Before
	public void setUp() throws Exception{
		dbc = new DBController();
		dbc.loadUniversities();
	}

	@After
	public void  tearDown() {
		this.dbc = new DBController();
		dbc.addUniversity("BARD", "NEW YORK","SMALL-CITY", "PRIVATE", 10000, 55, 560, 520, 32239, 80, 4000, 70, 30, 3, 4, 4);
	}
	
	
	@Test
	public void testMaxNumStudents() {
		float num = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", num == (40000));
	}
	
	@Test
	public void testMinNumStudents() {
		float num = dbc.minNumStudents();
		assertTrue("Min for num students is 10000", num == (10000));
	}
	
	@Test
	public void testMaxFemale() {
		float num = dbc.maxFemale();
		assertTrue("Max for percent female is 100", num == (100));
	}
	
	@Test
	public void testMinFemale() {
		float num = dbc.minFemale();
		assertTrue("Min for percent female is 1", num == (1));
	}
	
	@Test
	public void testMaxSATVerbal() {
		float num = dbc.maxSATVerbal();
		assertTrue("Max for SAT verbal is 40000", num == (700));
	}
	
	@Test
	public void testMinSATVerbal() {
		float num = dbc.minSATVerbal();
		assertTrue("Max for SAT verbal is 40000", num == (250));
	}
	
	@Test
	public void testMaxSATMathth() {
		float num = dbc.maxSATMath();
		assertTrue("Max for SAT Math is 780", num == (780));
	}
	
	@Test
	public void testMinSATMath() {
		float num = dbc.minSATMath();
		assertTrue("Min for SAT Math is 250", num == (250));
	}
	
	@Test
	public void testMaxExpenses() {
		float num = dbc.maxExpenses();
		assertTrue("Max for expenses is 62915", num == (62915));
	}
	
	@Test
	public void testMinExpenses() {
		float num = dbc.minExpenses();
		assertTrue("Min for expenses is 10438", num == (10438));
	}
	
	@Test
	public void testMaxFinancialAid() {
		float num = dbc.maxFinancialAid();
		assertTrue("Max for financial aid is 100", num == (100));
	}
	
	@Test
	public void testMinFinancialAid() {
		float num = dbc.minFinancialAid();
		assertTrue("Min for financial aid is 5", num == (5));
	}
	
	@Test
	public void testMaxNumApplicants() {
		float num = dbc.maxNumApplicants();
		assertTrue("Max for number of Applicants is " + num, num == (17000));
	}
	
	@Test
	public void testMinNumApplicants() {
		float num = dbc.minNumApplicants();
		assertTrue("Min for number of Applicants is 4000", num == (4000));
	}
	
	@Test
	public void testMaxPercentAdmitted() {
		float num = dbc.maxPercentAdmitted();
		assertTrue("Max for percent admitted is 100", num == (100));
	}
	
	@Test
	public void testMinPercentAdmitted() {
		float num = dbc.minPercentAdmitted();
		assertTrue("Min for percentAdmitted is 5", num == (5));
	}
	
	@Test
	public void testMaxPercentEnrolled() {
		float num = dbc.maxPercentEnrolled();
		assertTrue("Max for percent enrolled is 95", num == (95));
	}
	
	@Test
	public void testMinPercentEnrolled() {
		float num = dbc.minPercentEnrolled();
		assertTrue("Min for percent enrolled is 10", num == (10));
	}
	
	@Test
	public void testMaxAcademicScale() {
		float num = dbc.maxAcademicScale();
		assertTrue("Max for academic scale is 5", num == (5));
	}
	
	@Test
	public void testMinAcademicScale() {
		float num = dbc.minAcademicScale();
		assertTrue("Min for academic scale is 1", num == (1));
	}
	
	@Test
	public void testMaxSocialScale() {
		float num = dbc.maxSocialScale();
		assertTrue("Max for social scale is 5", num == (5));
	}
	
	@Test
	public void testMinSocialScale() {
		float num = dbc.minSocialScale();
		assertTrue("Min for social scale is 1", num == (1));
	}
	
	@Test
	public void testMaxQualityOfLifeScale() {
		float num = dbc.maxQualityOfLifeScale();
		assertTrue("Max for quality of life is 5", num == (5));
	}
	
	@Test
	public void testMinQualityOfLifeScale() {
		float num = dbc.minQualityOfLifeScale();
		assertTrue("Min for quality of life is 1", num == (1));
	}
	
	@Test
	public void checkPasswordRequirementsIsASuccess() {
		boolean result = dbc.checkPasswordRequirements("CORRECTpassword55");
		assertTrue("Value is true", result);
	}
	
	@Test
	public void checkPasswordRequirementsFailsForNoCaps() {
		boolean result = dbc.checkPasswordRequirements("incorrectpassword55");
		assertFalse("Value is false, there must be caps in the password", result);
	}
	
	@Test
	public void checkPasswordRequirementsFailsForNoLowerCase() {
		boolean result = dbc.checkPasswordRequirements("CORRECTPASSWORD55");
		assertFalse("Value is false, there must be lowercase in the password", result);
	}
	
	@Test
	public void checkPasswordRequirementsFailsForLengthRequirement() {
		boolean result = dbc.checkPasswordRequirements("CORpass55");
		assertFalse("Value is false, the password must be 10 characters", result);
	}
	
	@Test
	public void checkPasswordRequirementsFailsForNumber() {
		boolean result = dbc.checkPasswordRequirements("CORRECTPASSWORD");
		assertFalse("Value is false, there must be number in the password", result);
	}
	
	@Test
	public void containsUpperCasePasses() {
		boolean result = dbc.containsUpperCase("CORRECTPASSWORD55");
		assertTrue("Value is true", result);
	}
	
	@Test
	public void containsUpperCaseFails() {
		boolean result = dbc.containsUpperCase("correctpassword55");
		assertFalse("Must contain an uppercase", result);
	}
	
	@Test
	public void containsLowerCasePasses() {
		boolean result = dbc.containsLowerCase("correctpassword55");
		assertTrue("Value is true", result);
	}
	
	@Test
	public void containsLowerCaseFails() {
		boolean result = dbc.containsLowerCase("PASSWORD55");
		assertFalse("Does not contian a lowercase", result);
	}
	
	@Test
	public void containsNumberPasses() {
		boolean result = dbc.containsNumber("correctpassword55");
		assertTrue("Value is true", result);
	}
	
	@Test
	public void containsNumberFails() {
		boolean result = dbc.containsNumber("correctpassword");
		assertFalse("Does not contain a number", result);
	}
	
	@Test
	public void passwordLengthPasses() {
		boolean result = dbc.passwordLength("correctpassword55");
		assertTrue("Value is true", result);
	}
	
	@Test
	public void passwordLengthFails() {
		boolean result = dbc.passwordLength("correct55");
		assertFalse("Password must be 10 characters long", result);
	}
	
	@Test
	public void sendRecoveryEmailCreatesARandomPasswordWithCorrectRequirements() {
		String newPass = dbc.sendRecoverEmail("joettinge001@gmail.com");
		boolean result = dbc.checkPasswordRequirements(newPass);
		assertTrue("New password was properly created", result);	
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void sendRecoverEmailFailsForInvalidEmail() {
		dbc.sendRecoverEmail("jibberish");
	}

	@Test
	public void removeUniversitySucceeds() {
		dbc.removeUniversityDB("BARD");
		List<University> listUnis =  dbc.loadUniversities();
		boolean result = false;
		for(int i = 0; i < listUnis.size(); i++) {
			if(listUnis.get(i).getSchoolName().equals("BARD")) {
				result = false;
			}
			else {
				result = true;
			}
		}
		assertTrue("Bard was removed from the database.", result);
	}
	
	@Test
	public void removeUniversityFailsBecuaseSchoolIsInvalid() {
		dbc.removeUniversityDB("NOTASCHOOL");
		List<University> listUnis =  dbc.loadUniversities();
		boolean result = false;
		for(int i = 0; i < listUnis.size(); i++) {
			if(listUnis.get(i).getSchoolName().equals("NOTASCHOOL")) {
				result = true;
			}
			else {
				result = false;
			}
		}
		assertFalse("School was not found in the database.", result);
	}
	
	@Test
	public void compareAccountInfoReturnsTrue() {
		dbc.getDetailsProfile2("joettinge001@gmail.com");
		boolean result = dbc.compareAccountInfo("joettinge001@gmail.com", "jackson", "oettinger");
		assertTrue("Account info Matches.", result);
	}
	
	@Test
	public void compareAccountInfoFailsForFirstName() {
		dbc.getDetailsProfile2("joettinge001@gmail.com");
		boolean result = dbc.compareAccountInfo("joettinge001@gmail.com", "jack", "oettinger");
		assertFalse("Incorrect First Name.", result);
	}
	@Test
	public void compareAccountInfoFailsForLastName() {
		dbc.getDetailsProfile2("joettinge001@gmail.com");
		boolean result = dbc.compareAccountInfo("joettinge001@gmail.com", "jackson", "Oet");
		assertFalse("Incorrect Last Name.", result);
	}
	
	@Test
	public void addUserPassesForFirstName(){
		dbc.addUser("Randall", "Clintsman", "rcCOOLguy247@gmail.com", "RandallIsBoss5", 'u');
		List<String> profile = dbc.getDetailsProfile2("rcCOOLguy247@gmail.com");
		assertTrue(profile.get(0).equals("Randall"));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
