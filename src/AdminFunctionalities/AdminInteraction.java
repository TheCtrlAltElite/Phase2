package AdminFunctionalities;

//imports
import java.util.*;
import UserFunctionalities.*;

/**
 * 
 * @author Ctrl Alt Elite
 * 
 */

public class AdminInteraction {
	
	//instance variable
	private AdminFunctionalityController adminFController;
	
	//constructor
	public AdminInteraction() {
		adminFController = new AdminFunctionalityController();
	}

	
	
	public void addToSavedSchoolsList4(){
		adminFController.addToSavedSchoolsList3();
	}
	
	/**
	 *shows the admin the list of universities by calling
	 *viewUniversities() in the AdminFunctionalityController 
	 */
	public void viewUniversities() {
		adminFController.viewUniversities();
	}
	
	/**
	 * Adds a new university to the database by calling
	 * addUniversity() in AdminFunctionalityController  
	 */
	public void addUniversity() {
		adminFController.addUniversity();
	}
	
	/**
	 * Displays all users and their information in the database
	 * by calling viewUsers() in AdminFunctionalityController 
	 */
	public List<User> viewUsers() {
		return adminFController.viewUsers();
	}
	
//	/**
//	 * Updates the status of users in database
//	 * @param status
//	 */
//	public void updateStatus(String status) {
//		//TODO
//	}
//	
//	/**
//	 * Updates type of user in database
//	 * @param Type
//	 */
//	public void updateType(String Type) {
//		//TODO
//	}
	
	/**
	 * Adds a new user to the database
	 * by calling addUser() in AdminFunctionalityController 
	 */
	public void addUser() {
		adminFController.addUser();
	}
	
	/**
	 * Removes a stored university from the database by
	 * calling removeUniversityDB(String) in AdminFunctionalityController 
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		adminFController.removeUniversityDB(schoolName);
	}
}
