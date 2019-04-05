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
}
