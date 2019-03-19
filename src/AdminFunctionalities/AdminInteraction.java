package AdminFunctionalities;


import java.util.*;
import UserFunctionalities.*;

/**
 * 
 * @author Ctrl Alt Elite
 * 
 */

public class AdminInteraction {
	
	private AdminFunctionalityController adminFController;
	
	public AdminInteraction() {
		adminFController = new AdminFunctionalityController();
	}

	
	
	public void addToSavedSchoolsList4(){
		adminFController.addToSavedSchoolsList3();
	}
	
	/**
	 * 
	 */
	public void viewUniversities() {
		adminFController.viewUniversities();
	}
	
	/**
	 * Adds a new university to the database
	 */
	public void addUniversity() {
		adminFController.addUniversity();
	}
	
	/**
	 * Displays all users and their information in the database
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
	 */
	public void addUser() {
		adminFController.addUser();
	}
	
	/**
	 * Removes a stored university from the database (must not have emphases)
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		adminFController.removeUniversityDB(schoolName);
	}
}
