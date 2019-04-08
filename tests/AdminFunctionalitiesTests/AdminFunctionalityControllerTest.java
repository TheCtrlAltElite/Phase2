package AdminFunctionalitiesTests;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Before;

import org.junit.Test;
import AdminFunctionalities.AdminFunctionalityController;
import UniversityFunctionalities.University;
import UserFunctionalities.User;

public class AdminFunctionalityControllerTest {

	private AdminFunctionalityController adc;
	
	@Before
	public void setUp() {
		this.adc = new AdminFunctionalityController();
	}
	
	@Test
	public void viewUniversitiesTest() {
		List<University> listUnis = adc.viewUniversities();
		assertTrue(listUnis.size() == 181);
	}
	
	@Test
	public void viewUsersTest() {
		List<User> listUsers = adc.viewUsers();
		assertTrue(listUsers.size() == 7);
	}
	
	
	
}
