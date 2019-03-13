package AdminFunctionalities;

import CMCDatabase.*;

public class AdminFunctionalityController {

	DBController database;
	
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
	 * 
	 */
	public void setType() {
		//TODO
	}
	
	/**
	 * 
	 */
	public void viewUniversities(String state, int numStudents) {
		database.loadUniversities(state, numStudents);
	}
	
	/**
	 * 
	 */
	public void editUniversity() {
		//TODO
	}
	
	/**
	 * 
	 */
	public void viewUsers() {
		//TODO
	}
	
	/**
	 * 
	 * @param status
	 */
	public void updateStatus(String status) {
		//TODO
	}
	
	/**
	 * 
	 * @param type
	 */
	public void updateType(String type) {
		//TODO
	}
	
	/**
	 * 
	 */
	public void addUser() {
		//TODO
	}
	
	/**
	 * 
	 * @param type
	 */
	public void update(String type) {
		//TODO
	}
	
	/**
	 * 
	 */
	public void removeUniversityDB(String schoolName) {
		//TODO
	}
}
