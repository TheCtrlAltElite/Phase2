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

}
