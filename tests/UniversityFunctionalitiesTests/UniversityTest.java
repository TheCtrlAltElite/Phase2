package UniversityFunctionalitiesTests;

import static org.junit.Assert.*;

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
}
