package UserFunctionalities;

import java.util.*;
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
public class User extends Account{

	/**
	 * Instance Variables
	 */
	private List savedSchoolsList;
	private UserInteraction userInteract;
	
	//
	public User(String email, String firstName, String lastName, String password, char type, char status) {
		super(email, firstName, lastName, password, type, status);
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 */
	public void searchSchools(String schoolName, String schoolState, String schoolLocation, String schoolControl, String numberStudents, int percentFemale, int verbalSAT, int mathSAT, int schoolExpenses, int percentFinancialAid, int numApplicants, int percentAdmitted, int percentEnrolled, int academicScale, int socialScale, int qualityScale) {
		userInteract.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicScale,  socialScale, qualityScale);
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
	public List getSavedSchoolsList(){
		return null;
	}

	/**
	 * Removes a school from the User's savedSchoolsList.
	 * @param String schoolName - the name of the school to be removed from the User's savedSchoolsList.
	 */	
	public void removeSavedSchool(String schoolName) {
		
	}
}
