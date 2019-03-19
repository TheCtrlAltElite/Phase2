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
	private User user;
	private University university;
	private DBController database;
	private UniversityController uniController;
	private String firstName;
	private String lastName;
	private String email;
	private String profilePic;
	private String status;
	private String type;
	private String password;
	
	public UserFunctionalityController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 * @param SearchCriteria searchCriteria - an object containing the search information
	 */
	public List<University> searchSchools(String schoolName, String schoolState, String schoolLocation, String schoolControl, String numberStudents, String percentFemale, String verbalSAT, String mathSAT, String schoolExpenses, String percentFinancialAid, String numApplicants, String percentAdmitted, String percentEnrolled, String academicScale, String socialScale, String qualityScale) {
		List<University> listUnis = database.loadUniversities();
		List<University> matchingUnis = new ArrayList<University>();
		int counter =0;
		for(int i = 0; i < listUnis.size(); i++){
			if(schoolName != null) {
				counter++;
				if(!schoolName.equals(listUnis.get(i).getSchoolName())){
					continue;
				}
			}
			if(schoolState != null) {
				counter++;
				if(!schoolState.equals(listUnis.get(i).getSchoolState())){
					continue;
				}
			}
			if(schoolLocation != null) {
				counter++;
				if(!schoolLocation.equals(listUnis.get(i).getSchoolLocation())){
					continue;
				}
			}
			if(schoolControl != null) {
				counter++;
				if(!schoolControl.equals(listUnis.get(i).getSchoolControl())){
					continue;
				}
			}
			if(numberStudents != null) {
				counter++;
				if(Integer.parseInt(numberStudents) != (listUnis.get(i).getNumberStudents())){
					continue;
				}
			}
			if(percentFemale != null) {
				counter++;
				if(Integer.parseInt(percentFemale) != (listUnis.get(i).getPercentFemale())){
					continue;
				}
			}
			if(verbalSAT != null) {
				counter++;
				if(Integer.parseInt(verbalSAT) != (listUnis.get(i).getVerbalSAT())){
					continue;
				}
			}
			if(mathSAT != null) {
				counter++;
				if(Integer.parseInt(mathSAT) != (listUnis.get(i).getMathSAT())){
					continue;
				}
			}
			if(schoolExpenses != null) {
				counter++;
				if(Integer.parseInt(schoolExpenses) != (listUnis.get(i).getSchoolExpenses())){
					continue;
				}
			}
			if(percentFinancialAid != null) {
				counter++;
				if(Integer.parseInt(percentFinancialAid) != (listUnis.get(i).getPercentFinancialAid())){
					continue;
				}
			}
			if(numApplicants != null) {
				counter++;
				if(Integer.parseInt(numApplicants) != (listUnis.get(i).getNumApplicants())){
					continue;
				}
			}
			if(percentAdmitted != null) {
				counter++;
				if(Integer.parseInt(percentAdmitted) != (listUnis.get(i).getPercentAdmitted())){
					continue;
				}
			}
			if(percentEnrolled != null) {
				counter++;
				if(Integer.parseInt(percentEnrolled) != (listUnis.get(i).getPercentEnrolled())){
					continue;
				}
			}
			if(academicScale != null) {
				counter++;
				if(Integer.parseInt(academicScale) != (listUnis.get(i).getAcademicScale())){
					continue;
				}
			}
			if(socialScale != null) {
				counter++;
				if(Integer.parseInt(socialScale) != (listUnis.get(i).getSocialScale())){
					continue;
				}
			}
			if(qualityScale != null) {
				counter++;
				if(Integer.parseInt(qualityScale) != (listUnis.get(i).getQualityScale())){
					continue;
				}
			}
			matchingUnis.add(listUnis.get(i));
		}
		if(counter > 0) {
			return matchingUnis;
		}
		else {
			System.out.println("You have not entered any arguments to search for.");
			throw new NullPointerException("Enter some arguments.");
		}
	}
	
	/**
	 * Saves a school to the User's savedSchoolsList
	 * @param String schoolName - name of the school
	 */	
	public void saveSchool(String schoolName) {			//NEEDS WORK
		uniController.addToList(user, university);		//NEEDS WORK
		user.appendList(university);					//NEEDS WORK
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
	public void addUserToList(User user) {
		
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
