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
	public void searchSchools(String schoolName, String schoolState, String schoolLocation,String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1, String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2, String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2, String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2, String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qualityScale1, String qualityScale2) {
		userInteract.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents1, numberStudents2, percentFemale1, percentFemale2, verbalSAT1, verbalSAT2, mathSAT1, mathSAT2, schoolExpenses1, schoolExpenses2, percentFinancialAid1, percentFinancialAid2, numApplicants1, numApplicants2, percentAdmitted1, percentAdmitted2, percentEnrolled1, percentEnrolled2, academicScale1, academicScale2, socialScale1, socialScale2, qualityScale1, qualityScale2);
	}
	
	/**
	 * Adds UserSchool object to the User's savedSchoolsList.
	 * @param UserSchool userSchool - An object with the school name and date of the addition to the savedSchoolsList.  
	 */	
	public void appendList(University university) {	
		savedSchoolsList.add(university);
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
