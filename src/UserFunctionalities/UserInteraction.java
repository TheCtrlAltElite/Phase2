package UserFunctionalities;

import UniversityFunctionalities.University;
import other.*;



/**
 * @author CtrlAltElite
 *
 */
public class UserInteraction {

	private UserFunctionalityController userController;

	
	/**
	 * 
	 */
	public UserInteraction() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 * @param SearchCriteria searchCriteria - an object containing the search information
	 */
	public void searchSchools(String schoolName, String schoolState, String schoolLocation, String schoolControl, String numberStudents, String percentFemale, String verbalSAT, String mathSAT, String schoolExpenses, String percentFinancialAid, String numApplicants, String percentAdmitted, String percentEnrolled, String academicScale, String socialScale, String qualityScale) {
		userController.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
	}

	/**
	 * Saves a school to the User's savedSchoolsList
	 * @param String schoolName - name of the school
	 */		
	public void saveSchool(String school) {
			userController.saveSchool(school);
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
	 * Emails the user's savedSchoolsList to the user's email
	 */	
	public void emailSavedSchools() {
		
	}
}
