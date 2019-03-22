/**
 * Author: Ctrl Alt Elite
 */
package testDriver;

import AdminFunctionalities.*;
import CMCDatabase.*;
import other.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;


public class DBLibraryDriver {
  //private UniversityDBLibrary library;
  
  public DBLibraryDriver() {
	 
  }
  
  public static void main(String[] args) {
    try{
    	System.out.println("THIS IS THE DRIVER, TO TEST METHODS UNCOMMENT THEM AND RUN DRIVER. BE CAREFUL BEFORE YOU CHANGE ANYTHING. \n\n");

    	DBController dbc = new DBController();
    	
//WORKS:   
    	//dbc.testAdd();                      //Do Not Uncomment; will add a duplicate ZTESTUNI unless you edit testAdd in DBController. 
    	//dbc.rMethod();
    	//dbc.loadUniversities();
    	//dbc.loadUsers();
    	//dbc.addUser(password, firstName, lastName, email, profilePic, Type, Status);        //Cannot be tested here. Test from AdminFunctionalityController.
    	//dbc.checkPasswordRequirements("Randall");
    	//dbc.containsLowerCase(password);
    	//dbc.containsNumber(password);
    	//dbc.containsUpperCase(password);
    	//dbc.passwordLength(password);
    	//dbc.addUniversity(newUni);          //Can only be tested through addUniversityInfo in UniversityController
    	//dbc.getDetailsUni("HARVARD");		//Can only be ran here. Method in UniversityController probably not necessary.
    	//dbc.viewAllUnis();
    	
    	//dbc.viewAllUsers();
    	
    	
    	//dbc.testSaveUni();
    	
//ALL METHODS: 
    	//dbc.compareAccountInfo(email, firstName, lastName);
    	//dbc.editUser(juser);
    	//dbc.emailSavedSchoolsList(list);
    	//dbc.equals(obj);
    	//dbc.getClass();
    	//dbc.getDetailsProfile(username);
    	//dbc.getPassword(username);
    	//dbc.getUnivDBlib();
    	//dbc.isUserReal(username);
    	//dbc.removeUniversityDB("ZTESTUNI");
    	//dbc.sendRecoverEmail();
    	//dbc.toString();
    	//dbc.update(type);
    	//dbc.updateProfilePic(jpeg);
    	//dbc.updateSavedSschoolsList(list);
    	//dbc.updateStatus(status);
    	//dbc.updateType(type);
    	//dbc.updateUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
    	
    	
    	
    	UniversityController unc = new UniversityController();
    	
//WORKS:    	
    	//unc.editUniversity();           //use "testzuni"
    	//unc.addUniversityInfo();        //Must be ran HERE
    	//unc.getDetailsUni();			//Not needed here (?)

//ALL METHODS:
 
    	//unc.addToList(university);
    	//unc.compareUniversity(university);
    	//unc.editUniversity();
    	//unc.equals(obj);
    	//unc.getClass();
    	//unc.getDetailsUni("YANKTOWN");
    	//unc.recommendedSchools(university);
    	//unc.toString();
    	
    	
    	
	
    	AccountController acc = new AccountController();
    	
//WORKS:   
    	
    	
//ALL METHODS:
    	
    	//acc.addProfilePicture("jpeg");
    	//acc.editProfile("tux69@csbsju.edu");
    	//acc.equals(obj);
    	//acc.getClass();
    	//acc.getPassword(username);
    	//acc.isUserReal(username);
    	//acc.login("username", "password");
    	//acc.logOut();
    	//acc.passwordRequirements(password);
    	//acc.recoverPassword("email", "firstName", "lastName");
    	//acc.resetPassword(o, n1, n2);
    	//acc.toString();
    	//acc.viewProfile(username);
    	//acc.viewProfile(username);
    	
    	

    	AdminFunctionalityController afc = new AdminFunctionalityController();

//WORKS:   
    	//afc.addUser();
    	//afc.addUniversity();				//Must be ran from university controller
    	
//ALL METHODS:    	
    	
    	
    	//afc.addToSavedSchoolsList3();
    	
    	//afc.editUniversity();
    	//afc.equals(obj);
    	//afc.getClass();
    	//afc.removeUniversityDB(schoolName);
    	//afc.setStatus();
    	//afc.setType();
    	//afc.toString();
    	//afc.update(type);
    	//afc.updateStatus(status);
    	//afc.updateType(type);
    	//afc.viewUniversities();
    	//afc.viewUsers();
    	
    	
    	
    	
    	UserFunctionalityController ufc = new UserFunctionalityController();
    	
    	//ufc.addToList(user);
    	//ufc.emailSavedSchools();
    	//ufc.equals(obj);
    	//ufc.getClass();
    	//ufc.getSavedSchoolsList();
    	//ufc.removeSavedSchool(schoolName);
    	//ufc.saveSchool("name");
    	//ufc.searchSchools("UNI", "MIN", "URBAN", "STATE", "35000", "40000", "40", "70", "400", "500", "400", "600", "10000", "20000", "25", "75", "5000", "10000", "50", "100", "50", "100", "1", "5", "1", "5", "1", "5");
    	//ufc.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
    	//ufc.toString();
    	//ufc.updateSavedSchoolsList(list);
    	//ufc.viewSavedSchools();
    	//ufc.viewSchool(schoolName);

    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}