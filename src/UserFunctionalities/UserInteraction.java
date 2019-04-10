package UserFunctionalities;

import java.util.List;
import java.util.Scanner;

import javax.mail.MessagingException;

import UniversityFunctionalities.University;

//import UniversityFunctionalities.University;
//import other.*;



/**
 * @author CtrlAltElite
 *UserInteraction is a class that holds all methods involving the User's interaction with the database, as well as the UserFunctionalityController.
 */
public class UserInteraction {
/**
 * Instance Variables
 */
	private UserFunctionalityController userController;

	
	public UserInteraction() {
		userController = new UserFunctionalityController();
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 * @param SearchCriteria searchCriteria - an object containing the search information
	 */
	public void searchSchools(String schoolName, String schoolState, String schoolLocation,String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1, String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2, String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2, String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2, String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qualityScale1, String qualityScale2, List<String> emphases) {
		userController.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents1, numberStudents2, percentFemale1, percentFemale2, verbalSAT1, verbalSAT2, mathSAT1, mathSAT2, schoolExpenses1, schoolExpenses2, percentFinancialAid1, percentFinancialAid2, numApplicants1, numApplicants2, percentAdmitted1, percentAdmitted2, percentEnrolled1, percentEnrolled2, academicScale1, academicScale2, socialScale1, socialScale2, qualityScale1, qualityScale2, emphases);
	}

	/**
	 * Saves a school to the User's savedSchoolsList
	 * @param String schoolName - name of the school
	 */		
	public void addToSavedSchoolsList4(String userName, String school) {
		userController.addToSavedSchoolsList3(userName, school);
	}
	
	/**
	 * Presents the user with the information of a school
	 * @param String schoolName - name of the school
	 */	
	public void viewSchool() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter school you wish to get details from: ");
		String schoolName = sc.nextLine().toUpperCase();
		sc.close();
		userController.viewSchool(schoolName);
	}
	
	/**
	 * Presents the user with the list of saved schools
	 */		
	public void viewSavedSchools() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter a user to view thier saved schools list:");
		String user = sc.nextLine();
		userController.getSavedSchoolsList(user);
	}
	
	/**
	 * Removes a school from the user's savedSchoolsList
	 * @param String schoolName - name of the school
	 */	
	public void removeSavedSchool(String username, String schoolName) {
		userController.removeSavedSchool(username, schoolName);
	}
	
	/**
	 * Emails the user's savedSchoolsList to the user's email
	 * @throws MessagingException 
	 */	
	public void emailSavedSchools(String username) throws MessagingException {
		userController.emailSavedSchools(username);
	}
}
