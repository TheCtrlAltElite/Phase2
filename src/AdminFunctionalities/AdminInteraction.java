package AdminFunctionalities;

/**
 * 
 * @author lneuensch001
 * @version February 28, 2019
 * 
 */

public class AdminInteraction {
	
	AdminFunctionalityController adminFController;
	
	public AdminInteraction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		//TODO
	}
	
	/**
	 * 
	 */
	public void logOut() {
		//TODO
	}
	
	/**
	 * 
	 */
	public void viewUniversities(String state, int numStudents) {
		adminFController.viewUniversities(state, numStudents);
	}
	
	/**
	 * 
	 */
	public void addUniversity() {
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
	 * @param Type
	 */
	public void updateType(String Type) {
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
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		//TODO
	}
}
