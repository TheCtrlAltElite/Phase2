package AdminFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import AccountFunctionalities.Account;
import AdminFunctionalities.AdminFunctionalityController;
import CMCDatabase.DBController;
import UniversityFunctionalities.University;
import UniversityFunctionalities.UniversityController;


public class AdminFunctionalityControllerTest {

	private AdminFunctionalityController afc;
	private DBController dbc;
	private UniversityController uc;
	private String username;
	private String schoolTest1;
	private String schoolName;
	private String schoolState;
	private String schoolLocation;
	private String schoolControl;
	private int numberStudents;
	private int percentFemale;
	private int verbalSAT;
	private int mathSAT;
	private int schoolExpenses;
	private int percentFinancialAid;
	private int numApplicants;
	private int percentAdmitted;
	private int percentEnrolled;
	private int academicScale;
	private int socialScale;
	private int qualityScale;
	private String firstName;
	private String lastName;
	private String username2;
	private String password;
	private String password2;
	char type;
	
	@Before
	public void setUp() {
		this.afc = new AdminFunctionalityController();
		this.uc = new UniversityController();
		this.username = "fuser";
		this.schoolTest1 = "reed";
		this.schoolName = "zuni";
		this.schoolState = "MINNESOTA";
		this.schoolLocation = "URBAN";
		this.schoolControl = "STATE";
		this.numberStudents = 10000;
		this.percentFemale = 50;
		this.verbalSAT = 500;
		this.mathSAT = 500;
		this.schoolExpenses = 23451;
		this.percentFinancialAid = 25;
		this.numApplicants = 12355;
		this.percentAdmitted = 23;
		this.percentEnrolled = 65;
		this.academicScale = 5;
		this.socialScale = 5;
		this.qualityScale = 5;
		this.firstName = "z";
		this.lastName = "test";
		this.username2 = "ztest";
		this.password = "PenguinPower911";
		this.password2 = "lol";
		this.type = 'a';
	}
	
	@After
	public void  tearDown() {
		this.dbc = new DBController();
		dbc.removeFromSavedSchoolsList(this.username, this.schoolTest1);
		dbc.removeUniversityDB(this.schoolName);
		dbc.removeUserFromDB(username2);
		
	}
	
	@Test
	public void addToSavedSchoolsList3Success() {
		int result = afc.addToSavedSchoolsList3(this.username, this.schoolTest1);
		assertEquals("University was successfully added.\n ", 4, result);
	}
	
	@Test
	public void addToSavedSchoolsList3InvalidSchool() {
		int result = afc.addToSavedSchoolsList3("fuser", "NOTASCHOOL");
		assertEquals("Universtiy is not in the database.\n ", 5, result);
	}
	
	@Test
	public void addToSavedSchoolsList3InvalidUser() {
		int result = afc.addToSavedSchoolsList3("user", "yale");
		assertEquals("User is not in the database.\n ", 2, result);
	}
	
	@Test
	public void addToSavedSchoolsList3AlreadyExistsInList() {
		int result = afc.addToSavedSchoolsList3("fuser", "yale");
		assertEquals("University is already in the User's SavedSchool list.\n ", 6, result);
	}
	
	@Test
	public void addUniversityCorrectStateAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(details.get(1).equals("MINNESOTA"));
	}
	
	@Test
	public void addUniversityCorrectLocationAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(details.get(2).equals("URBAN"));
	}
	
	@Test
	public void addUniversityCorrectControlAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(details.get(3).equals("STATE"));
	}
	
	@Test
	public void addUniversityCorrectNumberOfStudentsAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(4)) == 10000);
	}
	
	@Test
	public void addUniversityCorrectPercentFemalesAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(5)) == 50);
	}
	
	@Test
	public void addUniversityCorrectSATVerbalAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(6)) == 500);
	}
	
	@Test
	public void addUniversityCorrectSATMathAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(7)) == 500);
	}
	
	@Test
	public void addUniversityCorrectExpensesAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(8)) == 23451);
	}
	
	@Test
	public void addUniversityCorrectPercentFinancialAidAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
				this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
				this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(9)) == 25);
	}
	
	@Test
	public void addUniversityCorrectNumberOfApplicantsAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(10)) == 12355);
	}
	
	@Test
	public void addUniversityCorrectPercentAdmittedAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(11)) == 23);
	}
	
	@Test
	public void addUniversityCorrectPercentEnrolledAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(12)) == 65);
	}
	
	@Test
	public void addUniversityCorrectAcademicsScaleAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(13)) == 5);
	}
	
	@Test
	public void addUniversityCorrectSocialScaleAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(14)) == 5);
	}
	
	@Test
	public void addUniversityCorrectQualityOfLifeScaleAdded() {
		afc.addUniversity(this.schoolName , this.schoolState , this.schoolLocation , this.schoolControl , this.numberStudents , 
		this.percentFemale , this.verbalSAT , this.mathSAT , this.schoolExpenses, this.percentFinancialAid , this.numApplicants , 
		this.percentAdmitted, this.percentEnrolled , this.academicScale , this.socialScale , this.qualityScale);		
		List<String> details = uc.getDetailsUni("zuni");
		assertTrue(Integer.parseInt(details.get(15)) == 5);
	}
	
	@Test
	public void addUserSuceess() {
		int result = afc.addUser(this.firstName, this.lastName, this.username2, this.password, this.type);
		assertEquals("User was added. \n", 3, result);
	}
	
	@Test
	public void addUserInvalidPassword() {
		int result = afc.addUser(this.firstName, this.lastName, this.username2, this.password2, this.type);
		assertEquals("User was not added becasue password is invalid. \n", 1, result);
	}
	
	@Test
	public void addUserFailBecasueUsernameExists() {
		int result = afc.addUser(this.firstName, this.lastName, "fuser", this.password, this.type);
		assertEquals("User was not added because username already exists. \n", 2, result);
	}
	
	@Test
	public void removeUniversityDBInvalidUniversity() {
		int result = afc.removeUniversityDB("bs");
		assertEquals("University was not removed from database because it does not exist.\n ", 2, result);
	}
	
	@Test
	public void removeUniversityDBUniversityInASavedSchoolList() {
		int result = afc.removeUniversityDB("yale");
		assertEquals("University was not removed from database because it is in someone's savedSchool list.\n ", 3, result);
	}
	
	@Test
	public void removeUniversityDBValidUniversityToBeRemoved() {
		afc.addUniversity("zschool", "xx", "yy", "zz", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
		int result = afc.removeUniversityDB("zschool");
		assertEquals("University was removed.\n ", 4, result);
	}
	
//	@Test
//	public void viewUniversitiesTest() {
//		List<University> listUnis = afc.viewUniversities();
//		assertTrue(listUnis.size() == 181);
//	}
	
	@Test
	public void viewUniversitiesWorksForLastUni() {
		List<University> listUnis = afc.viewUniversities();
		assertTrue(listUnis.get(listUnis.size()-1).getSchoolName().equals("ZZZZZUNIVERSITY"));
	}

	@Test
	public void viewUniversitiesWorksForAMiddleIndex() {
		List<University> listUnis = afc.viewUniversities();
		assertTrue(listUnis.get(listUnis.size()-6).getSchoolName().equals("WESLEYAN"));
	}
	
	@Test
	public void viewUniversitiesWorksForAnotherMiddleIndex() {
		List<University> listUnis = afc.viewUniversities();
		assertTrue(listUnis.get(5).getSchoolName().equals("AUGSBURG"));
	}
	
	@Test
	public void viewUniversitiesWorksForFirstIndex() {
		List<University> listUnis = afc.viewUniversities();
		assertTrue(listUnis.get(0).getSchoolName().equals("ABILENE CHRISTIAN UNIVERSITY"));
	}
	
//	@Test
//	public void viewUsersTest() {
//		List<Account> listUsers = afc.viewUsers();
//		assertTrue(listUsers.size() == 9);
//	}
	
	@Test
	public void viewUserWorksForLastUni() {
		List<Account> listUsers = afc.viewUsers();
		assertTrue(listUsers.get(listUsers.size()-1).getEmail().equals("tux69@csbsju.edu"));
	}

	@Test
	public void viewUserWorksForAMiddleIndex() {
		List<Account> listUsers = afc.viewUsers();
		assertTrue(listUsers.get(4).getEmail().equals("juser"));
	}
	
	@Test
	public void viewUserWorksForFirstIndex() {
		List<Account> listUsers = afc.viewUsers();
		assertTrue(listUsers.get(0).getEmail().equals("FBaggins@gmail.com"));
	}
	
	
	
}
