

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import AccountFunctionalitiesTests.AccountControllerTest;
import AccountFunctionalitiesTests.AccountTest;
import AdminFunctionalitiesTests.AdminFunctionalityControllerTest;
import CMCDatabaseTests.DBControllerTest;
import UniversityFunctionalitiesTests.UniversityControllerTest;
import UniversityFunctionalitiesTests.UniversityTest;
import UserFunctionalitiesTests.UserFunctionalityControllerTest;
import UserFunctionalitiesTests.UserTest;

@RunWith(Suite.class)
@SuiteClasses({ AccountControllerTest.class, AccountTest.class , AdminFunctionalityControllerTest.class, DBControllerTest.class, UniversityControllerTest.class, UniversityTest.class, UserFunctionalityControllerTest.class, UserTest.class})
public class AllTests {

}
