package UserFunctionalities;

import java.util.*;

import CMCDatabase.*;
import UniversityFunctionalities.*;
//import other.*;

/**
 * 
 */

/**
 * @author rclintsma001
 * UserFunctionalityContoller is a class which receives information from methods in DBController, edits them/searches the data received, and makes it available for UserInteraction.
 */
public class UserFunctionalityController {

	/**
	 * Instance Variables
	 */
//	private User user;
//	private University university;
//	private DBController database;
	private UniversityController unc;
//	private String firstName;
//	private String lastName;
//	private String email;
//	private String profilePic;
//	private String status;
//	private String type;
//	private String password;
	
	public UserFunctionalityController() {
//		database = new DBController();
		unc = new UniversityController();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 * @param SearchCriteria searchCriteria - an object containing the search information
	 */
	public List<University> searchSchools(String schoolName, String schoolState, String schoolLocation,String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1, String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2, String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2, String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2, String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qualityScale1, String qualityScale2) {
		DBController dbc = new DBController();
		List<University> listUnis = dbc.loadUniversities();
		List<University> matchingUnis = new ArrayList<University>();
		int counter =0;
		for(int i = 0; i < listUnis.size(); i++){
			if(schoolName != null) {
				counter++;
				if(!(listUnis.get(i).getSchoolName()).contains(schoolName)){
					continue;
				}
			}
			if(schoolState != null) {
				counter++;
				if(!(listUnis.get(i).getSchoolState()).contains(schoolState)){
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
			if(numberStudents1 != null && numberStudents2 != null) {
				counter++;
				if(!((Integer.parseInt(numberStudents1) <= (listUnis.get(i).getNumberStudents()) && 
					   (listUnis.get(i).getNumberStudents()) <= Integer.parseInt(numberStudents2)))){
					continue;
				}
			}
			if(percentFemale1 != null && percentFemale2 != null) {
				counter++;
				if(!((Integer.parseInt(percentFemale1) <= (listUnis.get(i).getPercentFemale()) && 
						   (listUnis.get(i).getPercentFemale()) <= Integer.parseInt(percentFemale2)))){
					continue;
				}
			}
			if(verbalSAT1 != null && verbalSAT2 != null) {
				counter++;
				if(!((Integer.parseInt(verbalSAT1) <= (listUnis.get(i).getVerbalSAT()) && 
						   (listUnis.get(i).getVerbalSAT()) <= Integer.parseInt(verbalSAT2)))){
					continue;
				}
			}
			if(mathSAT1 != null && mathSAT2 != null) {
				counter++;
				if(!((Integer.parseInt(mathSAT1) <= (listUnis.get(i).getMathSAT()) && 
						   (listUnis.get(i).getMathSAT()) <= Integer.parseInt(mathSAT2)))){
					continue;
				}
			}
			if(schoolExpenses1 != null && schoolExpenses2 != null) {
				counter++;
				if(!((Integer.parseInt(schoolExpenses1) <= (listUnis.get(i).getSchoolExpenses()) && 
						   (listUnis.get(i).getSchoolExpenses()) <= Integer.parseInt(schoolExpenses2)))){
					continue;
				}
			}
			if(percentFinancialAid1 != null && percentFinancialAid2 != null) {
				counter++;
				if(!((Integer.parseInt(percentFinancialAid1) <= (listUnis.get(i).getPercentFinancialAid()) && 
						   (listUnis.get(i).getPercentFinancialAid()) <= Integer.parseInt(percentFinancialAid2)))){
					continue;
				}
			}
			if(numApplicants1 != null && numApplicants2 != null) {
				counter++;
				if(!((Integer.parseInt(numApplicants1) <= (listUnis.get(i).getNumApplicants()) && 
						   (listUnis.get(i).getNumApplicants()) <= Integer.parseInt(numApplicants2)))){
					continue;
				}
			}
			if(percentAdmitted1 != null && percentAdmitted2 != null) {
				counter++;
				if(!((Integer.parseInt(percentAdmitted1) <= (listUnis.get(i).getPercentAdmitted()) && 
						   (listUnis.get(i).getPercentAdmitted()) <= Integer.parseInt(percentAdmitted2)))){
					continue;
				}
			}
			if(percentEnrolled1 != null && percentEnrolled2 != null) {
				counter++;
				if(!((Integer.parseInt(percentEnrolled1) <= (listUnis.get(i).getPercentEnrolled()) && 
						   (listUnis.get(i).getPercentEnrolled()) <= Integer.parseInt(percentEnrolled2)))){
					continue;
				}
			}
			if(academicScale1 != null && academicScale2 != null) {
				counter++;
				if(!((Integer.parseInt(academicScale1) <= (listUnis.get(i).getAcademicScale()) && 
						   (listUnis.get(i).getAcademicScale()) <= Integer.parseInt(academicScale2)))){
					continue;
				}
			}
			if(socialScale1 != null && socialScale2 != null) {
				counter++;
				if(!((Integer.parseInt(socialScale1) <= (listUnis.get(i).getSocialScale()) && 
						   (listUnis.get(i).getSocialScale()) <= Integer.parseInt(socialScale2)))){
					continue;
				}
			}
			if(qualityScale1 != null && qualityScale2 != null) {
				counter++;
				if(!((Integer.parseInt(qualityScale1) <= (listUnis.get(i).getQualityScale()) && 
						   (listUnis.get(i).getQualityScale()) <= Integer.parseInt(qualityScale2)))){
					continue;
				}
			}
			matchingUnis.add(listUnis.get(i));
		}
		if(counter > 0) {
			for (int i =0; i < matchingUnis.size(); i++) {
				System.out.println(matchingUnis.get(i).getSchoolName());
			}
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
	public void addToSavedSchoolsList3(String userName) {	
		unc.addToSavedSchoolsList2(userName);
	}

	/**
	 * Presents the user with the information of a school
	 * @param String schoolName - name of the school
	 */	
	public void viewSchool(String schoolName) {
		unc.getDetailsUni(schoolName);
	}
	
	/**
	 * Removes a school from the user's savedSchoolsList
	 * @param String schoolName - name of the school
	 */		
	public void removeSavedSchool(String username) {
		DBController dbc = new DBController();
		Scanner sc = new Scanner(System.in);
    	System.out.println("Enter school to be removed from " + username + "'s list: \n");
    	//asks for university that will be removed from the user's saved school list
    	String uniToFind = sc.nextLine().toUpperCase();
    	sc.close();
    	
    	int i = 0;  		
    	boolean e = false;
    	
    	//searches through list of saved schools for the user
    	while(i<dbc.getSavedSchoolsList(username).size()) {
    		String name = dbc.getSavedSchoolsList(username).get(i).getSchoolName();
   			
    		//confirms that the uniToFind is in that user's saved schools list
    		if (name.equals(uniToFind)){
   				e= true;
   				System.out.println("YES, " + uniToFind + " exists.");   			
   				break;
    		}
    		
    		//if the while loop reaches the end of the list, uniToFind is not in that user's saved schools list
    		if(i == (dbc.getSavedSchoolsList(username).size())-1) {
		   		System.out.print(uniToFind + " does NOT exist. \n");
    		}
   			i++;    			
   		}
    	
    	//if uniToFind exists in the saved schools list, calls removeFromSavedSchoolsList1() from DBController 
   		if(e) {
   			//System.out.println("reached 2nd if");
   			dbc.removeFromSavedSchoolsList(username, uniToFind);
    	}
	}
	 
//		public void removeSavedSchool(String username) {
//			DBController dbc = new DBController();
//			Scanner sc = new Scanner(System.in);
//	    	System.out.println("Enter school to be removed from " + username + "'s list: \n");
//	    	//asks for university that will be removed from the user's saved school list
//	    	String uniToFind = sc.nextLine().toUpperCase();
//	    	sc.close();
//	    	
//	    	int i = 0;  		
//	    	boolean e = false;
//	    	
//	    	//searches through list of saved schools for the user
//	    	while(i<dbc.getSavedSchoolsList(username).size()) {
//	    		String name = dbc.getSavedSchoolsList(username).get(i).getSchoolName();
//	   			
//	    		//confirms that the uniToFind is in that user's saved schools list
//	    		if (name.equals(uniToFind)){
//	   				e= true;
//	   				System.out.println("YES, " + uniToFind + " exists.");   			
//	   				break;
//	    		}
//	    		
//	    		//if the while loop reaches the end of the list, uniToFind is not in that user's saved schools list
//	    		if(i == (dbc.getSavedSchoolsList(username).size())-1) {
//			   		System.out.print(uniToFind + " does NOT exist. \n");
//	    		}
//	   			i++;    			
//	   		}
//	    	
//	    	//if uniToFind exists in the saved schools list, calls removeFromSavedSchoolsList1() from DBController 
//	   		if(e) {
//	   			//System.out.println("reached 2nd if");
//	   			dbc.removeFromSavedSchoolsList(username, uniToFind);
	   			
	   			
	/**
	 * Updates the user's savedSchoolsList in the database
	 * 
	 * @param List<UserSchool> list - list of the user's saved schools
	 */			
	public void updateSavedSchoolsList(List<UserSchool> list) {
		
	}
	
	/**
	 * Email's the user's savedSchoolsList to the user's email
	 */		
	public void emailSavedSchools() {
		
	}
	
	/**
	 * Fetches the user's savedSchoolsList
	 */	
	public void getSavedSchoolsList(){
		DBController database = new DBController();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Username to see their saved schools: ");
		String username = sc.nextLine();
		Map<String, String> savedSchoolsList = database.getSavedSchoolsList(username);	
		for (Map.Entry entry : savedSchoolsList.entrySet())
		{
		    System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
