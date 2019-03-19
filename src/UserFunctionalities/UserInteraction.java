package UserFunctionalities;

//import UniversityFunctionalities.University;
//import other.*;



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
		userController = new UserFunctionalityController();
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 * @param SearchCriteria searchCriteria - an object containing the search information
	 */
	public void searchSchools(String schoolName, String schoolState, String schoolLocation,String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1, String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2, String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2, String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2, String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qualityScale1, String qualityScale2) {
		userController.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents1, numberStudents2, percentFemale1, percentFemale2, verbalSAT1, verbalSAT2, mathSAT1, mathSAT2, schoolExpenses1, schoolExpenses2, percentFinancialAid1, percentFinancialAid2, numApplicants1, numApplicants2, percentAdmitted1, percentAdmitted2, percentEnrolled1, percentEnrolled2, academicScale1, academicScale2, socialScale1, socialScale2, qualityScale1, qualityScale2);
	}

	/**
	 * Saves a school to the User's savedSchoolsList
	 * @param String schoolName - name of the school
	 */		
	public void addToSavedSchoolsList4(String school) {
		userController.addToSavedSchoolsList3(school);
	}
	
	/**
	 * Presents the user with the information of a school
	 * @param String schoolName - name of the school
	 */	
	public void viewSchool(String schoolName) {
		userController.viewSchool(schoolName);
	}
	
	/**
	 * Presents the user with the list of saved schools
	 */		
	public void viewSavedSchools() {
		userController.getSavedSchoolsList();
	}
	
	/**
	 * Removes a school from the user's savedSchoolsList
	 * @param String schoolName - name of the school
	 */	
	public void removeSavedSchool(String schoolName) {
		userController.removeSavedSchool(schoolName);
	}
	
	/**
	 * Emails the user's savedSchoolsList to the user's email
	 */	
	public void emailSavedSchools() {
		userController.emailSavedSchools();
	}
}
