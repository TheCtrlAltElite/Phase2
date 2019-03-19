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
	private List<University> savedSchoolsList;
	private UserInteraction userInteract;
	
	//
	public User(String email, String firstName, String lastName, String password, char type, char status) {
		super(email, firstName, lastName, password, type, status);
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 */
	public void searchSchools(String schoolName, String schoolState, String schoolLocation, String schoolControl, String numberStudents, String percentFemale, String verbalSAT, String mathSAT, String schoolExpenses, String percentFinancialAid, String numApplicants, String percentAdmitted, String percentEnrolled, String academicScale, String socialScale, String qualityScale) {
		userInteract.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicScale,  socialScale, qualityScale);
	}
	
	/**
	 * Adds UserSchool object to the User's savedSchoolsList.
	 * @param UserSchool userSchool - An object with the school name and date of the addition to the savedSchoolsList.  
	 */	
	public void appendList(University university) {		//NEEDS WORK
		savedSchoolsList.add(university);				//NEEDS WORK
	}
	
	/**
	 * Fetches the user's savedSchoolsList and return it.
	 * @return List<UserSchool> - A list of the schools the user has saved.  
	 */	
	public List<University> getSavedSchoolsList(){
		return this.savedSchoolsList;
	}

	/**
	 * Removes a school from the User's savedSchoolsList.
	 * @param String schoolName - the name of the school to be removed from the User's savedSchoolsList.
	 */	
	public void removeSavedSchool(String schoolName) {
		
	}
}
