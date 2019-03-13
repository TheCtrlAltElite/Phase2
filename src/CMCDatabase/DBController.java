/**
 * 
 */

package CMCDatabase;
import java.awt.List;
import java.util.Collection;
import other.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;
import dblibrary.project.csci230.*;

/**
 * @author lneuensch001
 *
 */
public class DBController {

	UniversityDBLibrary library;
	
	/**
	 * Creates a DBController object.
	 */
	public DBController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Gets the details for the profile of username.
	 * 
	 * @param String username
	 * @return List with all the details of the profile
	 */
	public List getDetailsProfile(String username){
		return null;
	}
	/**
	 * Gets the details for the university with name school.
	 * 
	 * @param String school the name of the school
	 * @return a Collection of the details for that University
	 */
	public Collection<String> getDetailsUni(String school) {
		return null;
	}
	/**
	 * Checks the database to see if that username exists in the database.
	 * 
	 * @param username
	 * @return boolean true if the username is in the database or false if the username is not in the database
	 */
	public boolean isUserReal(String username) {
		return false;
	}
	/**
	 * 
	 * 
	 * @param username
	 */
	public void editUser(User user) {
		this.library.user_editUser(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPasssword(), user.getType(), user.getStatus());
	}
	/**
	 * 
	 */
	public String[][] loadUniversities(String state, int numStudents) {
		String[][] listUnis = library.university_getUniversities();
		System.out.println(listUnis[0][0]);
		return listUnis;
	}
	/**
	 * 
	 * @param search
	 */
	public void compareSearchCriteria(SearchCriteria search) {
		//TODO
	}
	/**
	 * 
	 * @param search
	 */
	public void updateUniversity(SearchCriteria search) {
		//TODO
	}
	/**
	 * 
	 * @param list of UserSchool's
	 */
	public void updateSavedSschoolsList(List list) {
		//TODO
	}
	/**
	 * 
	 */
	public void loadUsers() {
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
	 * @return
	 */
	public String getPassword(String username) {
		return null;
	}
	/**
	 * 
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param profilePic
	 * @param Type
	 * @param Status
	 */
	public void addUser(String password, String firstName, String lastName, String email, String profilePic, String Type, String Status) {
		//TODO
	}
	/**
	 * 
	 * @param type
	 */
	public void update(String type) {
		
	}
	/**
	 * 
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public boolean compareAccountInfo(String email, String firstName, String lastName) {
		return false;
	}
	/**
	 * 
	 */
	public void sendRecoverEmail() {
		//TODO
	}
	/**
	 * 
	 * @param list of UserSchool's
	 */
	public void emailSavedSchoolsList(List list) {
		//TODO
	}
	/**
	 * 
	 * @param jpeg
	 */
	public void updateProfilePic(String jpeg) {
		
	}
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkPasswordRequirements(String password) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsLowerCase(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsUpperCase(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsSpecialCharacter(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsNumber(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		//TODO
	}
}