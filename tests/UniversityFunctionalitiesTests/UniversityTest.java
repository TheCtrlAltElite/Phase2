package UniversityFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import UniversityFunctionalities.University;

public class UniversityTest {

	private University uni;
	
	@Before
	public void setUp() throws Exception {
		uni = new University("YANKTOWN COLLEGE", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400, 15736, 95, 4000, 95, 90, 1, 2, 2);
	}
	
	@Test
	public void UniversityConstructerTest() {
		University university = new University("YALE", "CONNECTICUT", "SMALL-CITY", "PRIVATE", 10000, 45, 675, 675, 33014, 40, 11500, 20, 60, 5, 3, 4);
	}

	@Test(expected=IllegalArgumentException.class)
	public void UniversityConstructerNullNametest() {
		new University(null, "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400, 15736, 95, 4000, 95, 90, 1, 2, 2);
	}

	@Test(expected=IllegalArgumentException.class)
	public void UniversityConstructerBlankNametest() {
		new University("", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400, 15736, 95, 4000, 95, 90, 1, 2, 2);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void UniversityConstructerNumbersInNametest() {
		new University("YANKTOWN COLLEGE420", "SOUTH DAKOTA", "SUBURBAN", "PRIVATE", 10000, 30, 450, 400, 15736, 95, 4000, 95, 90, 1, 2, 2);
	}
	
	//SchoolName contains Special Character??
	
	@Test
	public void getSchoolNameTest() {
		String schoolName = uni.getSchoolName();
		assertTrue("The School Name received is YANKTOWN COLLEGE.", schoolName.equals("YANKTOWN COLLEGE"));
	}
	
	@Test
	public void getSchoolStateTest() {
		String state = uni.getSchoolState();
		assertTrue("The School state received is SOUTH DAKOTA.", state.equals("SOUTH DAKOTA"));
	}
	
	@Test
	public void getSchoolLocationTest() {
		String location = uni.getSchoolLocation();
		assertTrue("The School location received is SUBURBAN.", location.equals("SUBURBAN"));
	}
	
	@Test
	public void getSchoolControlTest() {
		String control = uni.getSchoolControl();
		assertTrue("The School Control received is PRIVATE.", control.equals("PRIVATE"));
	}
	
	@Test
	public void getNumberStudentsTest() {
		int numStudents = uni.getNumberStudents();
		assertTrue("The Number of Students received is 10000.", numStudents == 10000);
		assertFalse("The Number of Students received is not equal to 10000.", numStudents != 10000);
	}
	
	@Test
	public void getPercentFemaleTest() {
		int percent = uni.getPercentFemale();
		assertTrue("The Percent Female received is 30%.", percent == 30);
		assertFalse("The Percent Female received is not equal to 30%.", percent != 30);
	}
	
	@Test
	public void getVerbalSATTest() {
		int verbal = uni.getVerbalSAT();
		assertTrue("The Verbal SAT received is 450.", verbal == 450);
		assertFalse("The Verbal SAT received is not equal to 450.", verbal != 450);
	}
	
	@Test
	public void getMathSATTest() {
		int math = uni.getMathSAT();
		assertTrue("The Math SAT received is 400.", math == 400);
		assertFalse("The Math SAT received is not equal to 400.", math != 400);
	}
	
	@Test
	public void getSchoolExpensesTest() {
		int expense = uni.getSchoolExpenses();
		assertTrue("The School Expenses received is 15736.", expense == 15736);
		assertFalse("The School Expenses received is not equal to 15736.", expense != 15736);
	}
	
	@Test
	public void getPercentFinancialAidTest() {
		int aid = uni.getPercentFinancialAid();
		assertTrue("The Percent Financial Aid received is 95.", aid == 95);
		assertFalse("The Percent Financial Aid received is not equal to 95.", aid != 95);
	}
	
	@Test
	public void getNumApplicantsTest() {
		int num = uni.getNumApplicants();
		assertTrue("The Number of Applicants received is 4000.", num == 4000);
		assertFalse("The Number of Applicants received is not equal to 4000.", num != 4000);
	}
	
	@Test
	public void getPercentAdmittedTest() {
		int percent = uni.getPercentAdmitted();
		assertTrue("The Percent Admitted received is 95.", percent == 95);
		assertFalse("The Percent Admitted received is not equal to 95.", percent != 95);
	}
	
	@Test
	public void getPercentEnrolledTest() {
		int percent = uni.getPercentEnrolled();
		assertTrue("The Percent Enrolled received is 90.", percent == 90);
		assertFalse("The Percent Enrolled received is not equal to 90.", percent != 90);
	}
	
	@Test
	public void getAcademicScaleTest() {
		int academic = uni.getAcademicScale();
		assertTrue("The Academic Scale received is 1.", academic == 1);
		assertFalse("The Academic Scale received is not equal to 1.", academic != 1);
	}
	
	@Test
	public void getSocialScaleTest() {
		int social = uni.getSocialScale();
		assertTrue("The Social Scale received is 2.", social == 2);
		assertFalse("The Social Scale received is not equal to 2.", social != 2);
	}
	
	@Test
	public void getQualityScaleTest() {
		int quality = uni.getQualityScale();
		assertTrue("The Quality Scale received is 2.", quality == 2);
		assertFalse("The Quality Scale received is not equal to 2.", quality != 2);
	}
	
	//Yo we need to write emphasis?
	
	@Test
	public void getEmphasisTest() {
		List<String> emphasis = uni.getEmphasis();
		assertTrue("The emphasis receiver is null.", emphasis == null);
	}
	
	@Test
	public void setSchoolStateTest() {
		
	}
}
