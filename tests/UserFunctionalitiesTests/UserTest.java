package UserFunctionalitiesTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import UserFunctionalities.User;

public class UserTest {

	private User user;
	
	@Before
	public void setUp() throws Exception {
		this.user = new User("neuenschwanderlevi@gmail.com", "Levi", "Neuenschwander", "DecentPassword12", 'u', 'Y');
	}

	
	
	
}
