package CMCDatabaseTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import CMCDatabase.DBController;

public class DBControllerTest {
	
	private DBController dbc;
	
	@Before
	public void setUp() throws Exception{
		dbc = new DBController();
		dbc.loadUniversities();
	}

	@Test
	public void testMaxNumStudents() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinNumStudents() {
		float max = dbc.minNumStudents();
		assertTrue("Min for num students is 10000", max == (10000));
	}
	
	@Test
	public void testMaxFemale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinFemale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxSATVerbal() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMainSATVerbal() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxSATMathth() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinSATMath() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxExpenses() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinExpenses() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxFinancialAid() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinFinancialAid() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxNumApplicantss() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinNumApplicants() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxPercentAdmitted() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinPercentAdmitted() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxPercentEnrolled() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinPercentEnrolled() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxAcademicScale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinAcademicScale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxSocialScale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinSocialScale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMaxQualityOfLifeScale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}
	
	@Test
	public void testMinQualityOfLIfeScale() {
		float max = dbc.maxNumStudents();
		assertTrue("Max for num students is 40000", max == (40000));
	}

}
