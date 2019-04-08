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
		assertTrue("Max for num students is 40000", num == (250));
	}
	
	@Test
	public void testMaxSATMathth() {
		float num = dbc.maxSATMath();
		assertTrue("Max for num students is 780", num == (780));
	}
	
	@Test
	public void testMinSATMath() {
		float num = dbc.minSATMath();
		assertTrue("Max for num students is 250", num == (250));
	}
	
	@Test
	public void testMaxExpenses() {
		float num = dbc.maxExpenses();
		assertTrue("Max for num students is 62915", num == (62915));
	}
	
	@Test
	public void testMinExpenses() {
		float num = dbc.minExpenses();
		assertTrue("Max for num students is 10438", num == (10438));
	}
	
	@Test
	public void testMaxFinancialAid() {
		float num = dbc.maxFinancialAid();
		assertTrue("Max for num students is 100", num == (100));
	}
	
	@Test
	public void testMinFinancialAid() {
		float num = dbc.minFinancialAid();
		assertTrue("Max for num students is 5", num == (5));
	}
	
	@Test
	public void testMaxNumApplicants() {
		float num = dbc.maxNumApplicants();
		assertTrue("Max for num students is 17000", num == (17000));
	}
	
	@Test
	public void testMinNumApplicants() {
		float num = dbc.minNumApplicants();
		assertTrue("Max for num students is 4000", num == (4000));
	}
	
	@Test
	public void testMaxPercentAdmitted() {
		float num = dbc.maxPercentAdmitted();
		assertTrue("Max for num students is 100", num == (100));
	}
	
	@Test
	public void testMinPercentAdmitted() {
		float num = dbc.minPercentAdmitted();
		assertTrue("Max for num students is 5", num == (5));
	}
	
	@Test
	public void testMaxPercentEnrolled() {
		float num = dbc.maxPercentEnrolled();
		assertTrue("Max for num students is 95", num == (95));
	}
	
	@Test
	public void testMinPercentEnrolled() {
		float num = dbc.minPercentEnrolled();
		assertTrue("Max for num students is 10", num == (10));
	}
	
	@Test
	public void testMaxAcademicScale() {
		float num = dbc.maxAcademicScale();
		assertTrue("Max for num students is 5", num == (5));
	}
	
	@Test
	public void testMinAcademicScale() {
		float num = dbc.minAcademicScale();
		assertTrue("Max for num students is 1", num == (1));
	}
	
	@Test
	public void testMaxSocialScale() {
		float num = dbc.maxSocialScale();
		assertTrue("Max for num students is 5", num == (5));
	}
	
	@Test
	public void testMinSocialScale() {
		float num = dbc.minSocialScale();
		assertTrue("Max for num students is 1", num == (1));
	}
	
	@Test
	public void testMaxQualityOfLifeScale() {
		float num = dbc.maxQualityOfLifeScale();
		assertTrue("Max for num students is 5", num == (5));
	}
	
	@Test
	public void testMinQualityOfLifeScale() {
		float num = dbc.minQualityOfLifeScale();
		assertTrue("Max for num students is 1", num == (1));
	}

}
