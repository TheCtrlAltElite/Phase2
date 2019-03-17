package AdminFunctionalities;

/**
 * 
 * @author lneuensch001
 * @version February 28, 2019
 * 
 */

public class AdminInteraction {
	
	private AdminFunctionalityController adminFController;
	
	public AdminInteraction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Logs in the admin
	 * @param username
	 * @param password
	 */
	public void login(String username, String password) {
		//TODO
	}
	
	/**
	 * Logs out the admin
	 */
	public void logOut() {
		//TODO
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
		//TODO
	}
	
	/**
	 * Displays all users and their information in the database
	 */
	public void viewUsers() {
		//TODO
	}
	
	/**
	 * Updates the status of users in database
	 * @param status
	 */
	public void updateStatus(String status) {
		//TODO
	}
	
	/**
	 * Updates type of user in database
	 * @param Type
	 */
	public void updateType(String Type) {
		//TODO
	}
	
	/**
	 * Adds a new user to the database
	 */
	public void addUser() {
		//TODO
	}
	
	/**
	 * Updates something (??) might be deleted
	 * @param type
	 */
	public void update(String type) {
		//TODO
	}
	
	/**
	 * Removes a stored university from the database (must not have emphases)
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		//TODO
	}
}
