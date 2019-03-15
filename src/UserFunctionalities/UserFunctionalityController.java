package UserFunctionalities;

import java.util.*;
import CMCDatabase.*;
import UniversityFunctionalities.*;
import other.*;

/**
 * 
 */

/**
 * @author rclintsma001
 *
 */
public class UserFunctionalityController {

	/**
	 * Instance Variables
	 */
	University university;
	DBController database;
	String firstName;
	String lastName;
	String email;
	String profilePic;
	String status;
	String type;
	String password;
	
	public UserFunctionalityController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 * @param SearchCriteria searchCriteria - an object containing the search information
	 */
	public void searchSchools(String schoolName, String schoolState, String schoolLocation, String schoolControl, String numberStudents, int percentFemale, int verbalSAT, int mathSAT, int schoolExpenses, int percentFinancialAid, int numApplicants, int percentAdmitted, int percentEnrolled, int academicScale, int socialScale, int qualityScale) {
		List<University> listUnis = database.loadUniversities();
		List<University> matchingUnis = new ArrayList<University>();
		if(!schoolName.isEmpty()) {
			for(int i = 0; i <= listUnis.size(); i++) {
				if(listUnis.get(i).getSchoolName().equals(schoolName)) {
					matchingUnis.add();
				}
			}
		}
		
	}
	
	/**
	 * Saves a school to the User's savedSchoolsList
	 * @param String schoolName - name of the school
	 */	
	public void saveSchool(String schoolName) {
		
	}

	/**
	 * Presents the user with the information of a school
	 * @param String schoolName - name of the school
	 */	
	public void viewSchool(String schoolName) {
		
	}

	/**
	 * Presents the user with the list of saved schools
	 */		
	public void viewSavedSchools() {
		
	}
	
	/**
	 * Removes a school from the user's savedSchoolsList
	 * @param String schoolName - name of the school
	 */		
	public void removeSavedSchool(String schoolName) {
		
	}
	
	/**
	 * Updates the user's savedSchoolsList in the database
	 * @param List<UserSchool> list - list of the user's saved schools
	 */			
	public void updateSavedSchoolsList(List<UserSchool> list) {
		
	}
	
	/**
	 * Adds User to view all users
	 * @param User user - a user
	 */		
	public void addToList(User user) {
		
	}
	
	/**
	 * Emails the user's savedSchoolsList to the user's email
	 */		
	public void emailSavedSchools() {
		
	}
	
	/**
	 * Fetches the user's savedSchoolsList
	 */	
	public List<UserSchool> getSavedSchoolsList(){
		return null;
	}
}
