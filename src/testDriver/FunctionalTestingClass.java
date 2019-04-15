package testDriver;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import AccountFunctionalities.AccountController;
import AdminFunctionalities.*;
import CMCDatabase.DBController;
//import CMCDatabase.*;
import other.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;
import dblibrary.project.csci230.UniversityDBLibrary;


public class FunctionalTestingClass {

	private static UniversityController unc = new UniversityController();
	private static DBController dbc = new DBController();
	private static AccountController acc = new AccountController();
	private static AdminInteraction aic = new AdminInteraction();
	private static AdminFunctionalityController  afc = new AdminFunctionalityController();
	private static UserFunctionalityController  ufc = new UserFunctionalityController();
	
	
	public FunctionalTestingClass() {
	 //    unc = new UniversityController();
	 //    dbc = new DBController();
	 //    acc = new AccountController();
	 //    aic = new AdminInteraction();
	 //    afc = new AdminFunctionalityController();
	 //    ufc = new UserFunctionalityController();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

    try{

    	/**
    	 * LogIn
    	 */
     //   acc.login("juser", "JohnMiller5");
        
        /**
         * Logout
         */
     //   acc.logOut();
        
        /**
         * LogIn with deactivated user
         */
     //	acc.login("luser", "ImadRahal4");
        
        /**
         * View Profile
         */
     //   acc.viewProfile("juser");   
        
        /**
         * Edit Profile
         * INCLUDES DEACTIVATE PROFILE AND TYPE
         */
     //   acc.editProfile("Rigby", "Tux", "tux420@csbsju.edu", "PenguinPower420", 'u', 'Y');  
   
        /**
         * View All Users
         */
     //   aic.viewUsers();   
    	
    	/**
    	 * Add New User
    	 */
     //   aic.addUser();     //Not hard coded, asks for parameters
     //   afc.addUser("BEEBOOPBOPBOOP", "Robot", "zuser259@gmail.com", "Zpasswordis99", 'a'); //call from AdminInteraction	
        
    	/**
    	 * Reset Password
    	 * INCLUDES MEETS PASSWORD REQUIREMENTS **ADDITIONAL FUNCTIONALITY**
    	 */
     //   acc.resetPassword("Gandalf1010", "Gandalf2020", "Gandalf2020");  	   	
    	
        /**
         * Search Schools with emphases
         * INCLUDES SEARCH SCHOOL RESULTS
         */     
     //   List<String> emphases = new ArrayList<String>();
     //   emphases.add("BIOLOGY");
     //   ufc.searchSchools(null, "NEW YORK", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, emphases);       
     
        /**
         * Search Schools Template
         * INCLUDES SEARCH SCHOOL RESULTS
         */
     //   ufc.searchSchools(String schoolName, String schoolState, String schoolLocation,String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1, String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2, String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2, String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2, String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qualityScale1, String qualityScale2, List<String> emphases);
    	
        /**
         * Save school from search
         */        
     //   ufc.addToSavedSchoolsList3("FBaggins@gmail.com", "YANKTOWN COLLEGE");
  
        /**
         * Get saved school list
         */
     //   ufc.getSavedSchoolsList("jmuehls@gmail.com");
        
        /**
         * remove save school
         */
     //   ufc.removeSavedSchool("FBaggins@gmail.com", "YANKTOWN COLLEGE");  
        
        /**
         * View school information
         * INCLUDES RECOMMENDED SCHOOLS
         */        
     //   ufc.viewSchool("ABILENE CHRISTIAN UNIVERSITY");
     //   List<University> listUnis = dbc.loadUniversities();
     //   unc.recommendedSchools(listUnis.get(0));        
       
        /**
         * Edit University
         * 
         * edit on Worcester. Original state: MASSACHUSETTS
         * Original stats for Worcester: ("WORCESTER", "MASSACHUSETTS", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70, 4000, 50, 50, 4, 3, 4)
         */   
     //   unc.editUniversity("WORCESTER", "MINNESOTA", "URBAN", "PRIVATE", 10000, 20, 550, 650, 30973, 70, 4000, 50, 50, 4, 3, 4);
        
        /**
         * View all Universities
         */
     //   aic.viewUniversities();    
     //   afc.viewUniversities();     //call from AdminInteraction
  
        /**
         * Add University
         */
     //   aic.addUniversity();     //Not hard coded, asks for parameters
     //   afc.addUniversity("zootoopa", "-1", "-1", "-1", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);  //call from AdminInteraction

    	/**
    	 * Remove University from Database ***ADDITIONAL FUNCTIONALITY
    	 */
     //   afc.removeUniversityDB("zootoopa");     //call from AdminInteraction	
        
        /**
         * Send Recovery Password  ****ADDITIONAL FUNCTIONALITY
         * INCLUDES RANDOM PASSWORD GENERATOR ***ADDITIONAL FUNCTIONALITY
         */
     //   acc.recoverPassword("jmuehls@gmail.com");	    
        
    	/**
    	 * Email saved schools list   ***ADDITIONAL FUNCTIONALITY
    	 * needs fix
    	 */
     //	  ufc.emailSavedSchools("jmuehls@gmail.com")
    	
    	/**
    	 * Set profile pic	****ADDITIONAL FUNCTIONALITY
    	 */
     //	  acc.addProfilePicture("joettinge001@gmail.com", "joettinge001@gmail.com");
    	
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}

