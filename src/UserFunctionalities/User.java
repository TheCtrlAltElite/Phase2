package UserFunctionalities;

import java.util.List;
import UniversityFunctionalities.*;
import other.*;

/**
 * 
 */

/**
 * User class is a type of Account that keeps track of User specific information such as a list of saved schools
 * and methods for searching schools.
 *
 */
public class User {

	/**
	 * Instance Variables
	 */
	List<UserSchool> savedSchoolsList;
	UserInteraction userInteract;
	
	//
	public User() {
		
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 */
	public void searchSchools(String state, int numStudents) {
		userInteract.searchSchools(state, numStudents);
	}
	
	/**
	 * Adds UserSchool object to the User's savedSchoolsList.
	 * @param UserSchool userSchool - An object with the school name and date of the addition to the savedSchoolsList.  
	 */	
	public void appendList(UserSchool userSchool) {
		
	}
	
	/**
	 * Fetches the user's savedSchoolsList and return it.
	 * @return List<UserSchool> - A list of the schools the user has saved.  
	 */	
	public List<UserSchool> getSavedSchoolsList(){
		return null;
	}

	/**
	 * Removes a school from the User's savedSchoolsList.
	 * @param String schoolName - the name of the school to be removed from the User's savedSchoolsList.
	 */	
	public void removeSavedSchool(String schoolName) {
		
	}
}
