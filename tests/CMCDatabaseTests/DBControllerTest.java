package CMCDatabaseTests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import AccountFunctionalities.Account;
import CMCDatabase.DBController;
import UniversityFunctionalities.University;
import UniversityFunctionalities.UniversityController;
import UserFunctionalities.User;
import dblibrary.project.csci230.UniversityDBLibrary;

public class DBControllerTest {
	
	private DBController dbc;
	private UniversityController unc;
	
	@Before
	public void setUp() throws Exception{
		dbc = new DBController();
		unc = new UniversityController();
		dbc.loadUniversities();
	}

	@After
	public void  tearDown() {
		this.dbc = new DBController();
		dbc.addUniversity("BARD", "NEW YORK","SMALL-CITY", "PRIVATE", 10000, 55, 560, 520, 32239, 80, 4000, 70, 30, 3, 4, 4);
		dbc.removeUserFromDB("rcCOOLguy247@gmail.com");
		dbc.addToSavedSchoolsList1("fuser", "QUEENS");
		dbc.removeFromSavedSchoolsList("fuser", "REED");
		dbc.removeUniversityDB("TESTUNI");
		dbc.updateUniversity("TEMPLE", "PENNSYLVANIA", "URBAN", "STATE", 35000, 50, 475, 500, 15366, 60, 11500, 70, 60, 2, 2, 2);
		dbc.addUser("Rigby", "tux", "tux420@csbsju.edu", "PenguinPower420",'u');
	}
	
	@Test
	public void  constructorTest() {
		UniversityDBLibrary library = dbc.getUnivDBlib();
		boolean result = false;
		if(library != null) {
			result = true;
		}
		assertTrue("Database library was created.", result);
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
	
	@Test
	public void addUserPassesForLastName(){
		dbc.addUser("Randall", "Clintsman", "rcCOOLguy247@gmail.com", "RandallIsBoss5", 'u');
		List<String> profile = dbc.getDetailsProfile2("rcCOOLguy247@gmail.com");
		assertTrue(profile.get(1).equals("Clintsman"));
	}
	
	@Test
	public void addUserPassesForUserName(){
		dbc.addUser("Randall", "Clintsman", "rcCOOLguy247@gmail.com", "RandallIsBoss5", 'u');
		List<String> profile = dbc.getDetailsProfile2("rcCOOLguy247@gmail.com");
		assertTrue(profile.get(2).equals("rcCOOLguy247@gmail.com"));
	}
	
	@Test
	public void addUserPassesForPassword(){
		dbc.addUser("Randall", "Clintsman", "rcCOOLguy247@gmail.com", "RandallIsBoss5", 'u');
		List<String> profile = dbc.getDetailsProfile2("rcCOOLguy247@gmail.com");
		assertTrue(profile.get(3).equals("RandallIsBoss5"));
	}
	
	@Test
	public void addUserPassesForType(){
		dbc.addUser("Randall", "Clintsman", "rcCOOLguy247@gmail.com", "RandallIsBoss5", 'u');
		List<String> profile = dbc.getDetailsProfile2("rcCOOLguy247@gmail.com");
		assertTrue(profile.get(4).equals("u"));
	}
	
	@Test
	public void getPasswordReturnsCorectPassword() {
		String pass = dbc.getPassword("juser");
		assertTrue(pass.equals("JohnMiller5"));	
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void getPasswordFailsForInvalidUsername() {
		dbc.getPassword("jibberish");
	}
	
	@Test
	public void loadUsersWorksForFirstIndexFirstName() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(0).getFirstName().equals("Frodo"));
 	}
	
	@Test
	public void loadUsersWorksForFirstIndexLastName() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(0).getLastName().equals("Baggins"));
 	}
	
	@Test
	public void loadUsersWorksForFirstIndexUserName() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(0).getEmail().equals("FBaggins@gmail.com"));
 	}
	
	@Test
	public void loadUsersWorksForFirstIndexPassword() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(0).getPassword().equals("Gandalf1010"));
 	}
	
	@Test
	public void loadUsersWorksForFirstIndexType() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(0).getType() == 'u');
 	}
	
	@Test
	public void loadUsersWorksForFirstIndexStatus() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(0).getStatus() == 'Y');
 	}
	
	public void loadUsersWorksForLastIndexFirstName() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(users.size() - 1).getFirstName().equals("Eli"));
 	}
	
	@Test
	public void loadUsersWorksForLastIndexLastName() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(users.size() - 1).getLastName().equals("tux"));
 	}
	
	@Test
	public void loadUsersWorksForLastIndexUserName() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(users.size() - 1).getEmail().equals("tux69@csbsju.edu"));
 	}
	
	@Test
	public void loadUsersWorksForLastIndexPassword() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(users.size() - 1).getPassword().equals("TuxIsOurSavior1"));
 	}
	
	@Test
	public void loadUsersWorksForLastIndexType() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(users.size() - 1).getType() == 'a');
 	}
	
	@Test
	public void loadUsersWorksForLastIndexStatus() {
		List<Account> users = dbc.loadUsers();
		assertTrue(users.get(users.size() - 1).getStatus() == 'Y');
 	}
	
	@Test
	public void getSavedSchoolsListPasses() {
		Map<String, String> list = dbc.getSavedSchoolsList("juser");
		assertTrue(list.get("BARD").equals("2019-04-07 15:35:52.0"));
		assertTrue(list.get("QUEENS").equals("2019-03-20 15:06:21.0"));
		assertTrue(list.get("YALE").equals("2019-04-05 14:29:31.0"));
	}
	
	@Test
	public void removeFromSavedSchoolsListPasses() {
		dbc.removeFromSavedSchoolsList("fuser", "QUEENS");
		Map<String, String> list = dbc.getSavedSchoolsList("fuser");
		Set<String> keys = list.keySet();
		boolean result = false;
		for(String key : keys) {
			if(key.equals("QUEENS")) {
				result = false;
				break;
			}
			else {
				result = true;
			}
		}
		assertTrue("School removed from saved Schools list.", result);
	}
	
	@Test
	public void addToSavedSchoolsListPasses() {
		dbc.addToSavedSchoolsList1("fuser", "REED");
		Map<String, String> list = dbc.getSavedSchoolsList("fuser");
		Set<String> keys = list.keySet();
		boolean result = false;
		for(String key : keys) {
			if(key.equals("QUEENS")) {
				result = true;
				break;
			}
			else {
				result = false;
			}
		}
		assertTrue("School added to saved Schools list.", result);
	}
	
	@Test
	public void addUniversityPassesForUniversityName() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(0).equals("TESTUNI"));
	}
	
	@Test
	public void addUniversityPassesForUniversityState() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(1).equals("COLORADO"));
	}
	
	@Test
	public void addUniversityPassesForUniversityLocal() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(2).equals("SUBURBAN"));
	}
	
	@Test
	public void addUniversityPassesForUniversityControl() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(3).equals("PRIVATE"));
	}
	
	@Test
	public void addUniversityPassesForUniversityEnrollment() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(4).equals("10000"));
	}
	
	@Test
	public void addUniversityPassesForUniversityPercentFemale() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(5).equals("50"));
	}
	
	@Test
	public void addUniversityPassesForUniversitySATVerbal() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(6).equals("500"));
	}
	
	@Test
	public void addUniversityPassesForUniversitySATMath() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(7).equals("500"));
	}
	
	@Test
	public void addUniversityPassesForUniversityExpenses() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(8).equals("23451"));
	}
	
	
	@Test
	public void addUniversityPassesForUniversityPercentFinancialAid() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(9).equals("25"));
	}
	
	@Test
	public void addUniversityPassesForUniversityNumApplicants() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(10).equals("12355"));
	}
	@Test
	public void addUniversityPassesForUniversityPercentAdmitted() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(11).equals("23"));
	}
	@Test
	public void addUniversityPassesForUniversityPercentEnrolled() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(12).equals("65"));
	}
	@Test
	public void addUniversityPassesForUniversitySocialScale() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(13).equals("5"));
	}
	@Test
	public void addUniversityPassesForUniversityAcademciScale() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(14).equals("5"));
	}
	@Test
	public void addUniversityPassesForUniversityQualityScale() {
		dbc.addUniversity("TESTUNI", "COLORADO", "SUBURBAN", "PRIVATE", 10000, 50, 500, 500, 23451, 25, 12355, 23, 65, 5, 5, 5);
		List<String> uni = unc.getDetailsUni("TESTUNI");
		assertTrue(uni.get(15).equals("5"));
	}
	
	@Test
	public void updateUniversityPassesForState() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(1).equals("PENN"));
	}
	
	@Test
	public void updateUniversityPassesForLocal() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(2).equals("SUBURBAN"));
	}
	
	@Test
	public void updateUniversityPassesForControl() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(3).equals("PRIVATE"));
	}
	
	@Test
	public void updateUniversityPassesForEnrollment() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(4).equals("40000"));
	}
	
	@Test
	public void updateUniversityPassesForFemales() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(5).equals("60"));
	}
	
	@Test
	public void updateUniversityPassesForVerbal() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(6).equals("500"));
	}
	
	@Test
	public void updateUniversityPassesForMath() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(7).equals("550"));
	}
	
	@Test
	public void updateUniversityPassesForExpenses() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(8).equals("16745"));
	}
	
	@Test
	public void updateUniversityPassesForPercentFinAid() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(9).equals("70"));
	}
	
	@Test
	public void updateUniversityPassesForNumApplicants() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(10).equals("1200"));
	}
	
	@Test
	public void updateUniversityPassesForPercentAdmitted() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(11).equals("65"));
	}
	
	@Test
	public void updateUniversityPassesForPercentEnrolled() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(12).equals("70"));
	}
	
	@Test
	public void updateUniversityPassesForSocial() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(13).equals("3"));
	}
	
	@Test
	public void updateUniversityPassesForAcademic() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(14).equals("3"));
	}
	
	@Test
	public void updateUniversityPassesForQuality() {
		dbc.updateUniversity("TEMPLE","PENN", "SUBURBAN", "PRIVATE", 40000, 60,	500, 550, 16745, 70, 1200,	65, 70, 3, 3, 3);
		List<String> uni = unc.getDetailsUni("TEMPLE");
		assertTrue(uni.get(15).equals("3"));
	}
	
	@Test
	public void loadUniversitiesWorksForFirstUni() {
		List<University> listUnis = dbc.loadUniversities();
		assertTrue(listUnis.get(0).getSchoolName().equals("ABILENE CHRISTIAN UNIVERSITY"));
	}
	
	@Test
	public void loadUniversitiesWorksForLastUni() {
		List<University> listUnis = dbc.loadUniversities();
		assertTrue(listUnis.get(listUnis.size()-1).getSchoolName().equals("ZZZZZUNIVERSITY"));
	}

	@Test
	public void loadUniversitiesWorksForAMiddleIndex() {
		List<University> listUnis = dbc.loadUniversities();
		assertTrue(listUnis.get(listUnis.size()-6).getSchoolName().equals("WESLEYAN"));
	}
	
	@Test
	public void loadUniversitiesWorksForAnotherMiddleIndex() {
		List<University> listUnis = dbc.loadUniversities();
		assertTrue(listUnis.get(5).getSchoolName().equals("AUGSBURG"));
	}
	
	@Test
	public void removeUserFromBDPasses() {
		int num = dbc.removeUserFromDB("tux420@csbsju.edu");
		boolean result= false;
		if(num == -1) {
			result = false;
		}
		else {
			result = true;
		}
		assertTrue("User removed", result);
	}
	
	@Test
	public void isUserRealPasses() {
		boolean result= dbc.isUserReal("juser");
		assertTrue("User Exists", result);
	}
	
	@Test
	public void isUserRealFails() {
		boolean result= dbc.isUserReal("jib");
		assertFalse("User Does Not Exist", result);
	}
	//test for fails as well
	@Test
	public void getUniversityReturnsUniversityName() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getSchoolName().equals("REED"));
	}
	@Test
	public void getUniversityReturnsUniversityState() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getSchoolState().equals("OREGON"));
	}
	@Test
	public void getUniversityReturnsUniversityLocal() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getSchoolLocation().equals("SUBURBAN"));
	}
	@Test
	public void getUniversityReturnsUniversityControl() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getSchoolControl().equals("PRIVATE"));
	}
	@Test
	public void getUniversityReturnsUniversityEnrollment() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getNumberStudents() == 10000);
	}
	@Test
	public void getUniversityReturnsUniversityFemale() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getPercentFemale() == 40);
	}
	@Test
	public void getUniversityReturnsUniversityVerbal() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getVerbalSAT() == 625);
	}
	@Test
	public void getUniversityReturnsUniversityMath() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getMathSAT() == 625);
	}
	@Test
	public void getUniversityReturnsUniversityExpenses() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getSchoolExpenses() == 37915);
	}
	@Test
	public void getUniversityReturnsUniversityPercentAid() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getPercentFinancialAid() == 40);
	}
	@Test
	public void getUniversityReturnsUniversityNumApplicants() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getNumApplicants() == 4000);
	}
	@Test
	public void getUniversityReturnsUniversityPercentAdmitted() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getPercentAdmitted() == 80);
	}
	@Test
	public void getUniversityReturnsUniversityPercentEnrolled() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getPercentEnrolled() == 40);
	}
	@Test
	public void getUniversityReturnsUniversityAcademic() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getAcademicScale() == 4);
	}
	@Test
	public void getUniversityReturnsUniversitySocial() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getSocialScale() == 3);
	}
	@Test
	public void getUniversityReturnsUniversityQuality() {
		University uni = dbc.getUniversity("REED");
		assertTrue(uni.getQualityScale() == 4);
	}
	@Test (expected=IllegalArgumentException.class)
	public void getUniversityFailsForInvalidUni() {
		dbc.getUniversity("JIB");
	}
	
	@Test
	public void getDetailsProfile2WorksForFistName() {
		List<String> user = dbc.getDetailsProfile2("juser");
		assertTrue(user.get(0).equals("John"));
	}
	@Test
	public void getDetailsProfile2WorksForLastName() {
		List<String> user = dbc.getDetailsProfile2("juser");
		assertTrue(user.get(1).equals("User"));
	}
	@Test
	public void getDetailsProfile2WorksForUserName() {
		List<String> user = dbc.getDetailsProfile2("juser");
		assertTrue(user.get(2).equals("juser"));
	}
	@Test
	public void getDetailsProfile2WorksForPassword() {
		List<String> user = dbc.getDetailsProfile2("juser");
		assertTrue(user.get(3).equals("JohnMiller5"));
	}
	@Test
	public void getDetailsProfile2WorksForType() {
		List<String> user = dbc.getDetailsProfile2("juser");
		assertTrue(user.get(4).equals("u"));
	}
	@Test
	public void getDetailsProfile2WorksForStatus() {
		List<String> user = dbc.getDetailsProfile2("juser");
		assertTrue(user.get(5).equals("Y"));
	}
	
	@Test
	public void edituserEditsTheUser() {
		boolean result = false;
		List<Account> users = dbc.loadUsers();
		int num = dbc.editUser(users.get(1));
		if(num != -1) {
			result = true;
		}
		assertTrue("The user was updated.", result);
	}
	
	

}
