package AdminFunctionalities;

import java.util.*;

import CMCDatabase.*;
import UniversityFunctionalities.University;
import UserFunctionalities.*;

public class AdminFunctionalityController {

	private DBController database;
	
	public AdminFunctionalityController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Sets the status for an account
	 */
	public void setStatus() {
		//TODO
	}
	
	/**
	 *  Sets Type for an account
	 */
	public void setType() {
		//TODO
	}
	
	/**
	 * Retrieves universities from database
	 */
	public void viewUniversities() {
		database.loadUniversities();
	}
	
	/**
	 * Edits the info stored for a university
	 */
	public void editUniversity() {
		//TODO
	}
	
	/**
	 * Retrieves user info from database 
	 */
	public void viewUsers() {
		//TODO
	}
	
	/**
	 * Updates account status in database (active or deactive)
	 * @param status
	 */
	public void updateStatus(String status) {
		//TODO
	}
	
	/**
	 * Updates account type stored in database
	 * @param type
	 */
	public void updateType(String type) {
		//TODO
	}
	
	/**
	 * Adds a user to the database
	 */
	public void addUser() {
		//TODO
	}
	
	/**
	 * Updates something (??)
	 * @param type
	 */
	public void update(String type) {
		//TODO
	}
	
	/**
	 * Removes university from the database
	 */
	public void removeUniversityDB(String schoolName) {
		List<User> users = database.loadUsers();
		List<University> unis;		
		for (int i = 0; i < users.size(); i++) {
			unis = users.get(i).getSavedSchoolsList();
			if(unis.contains(unis.get(i))) {
				System.out.println("This School Cannot be Removed");
				break;
			}
		}
		database.removeUniversityDB(schoolName);
	}
}
