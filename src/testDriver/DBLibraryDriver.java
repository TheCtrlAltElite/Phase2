/**
 * Author: CtrlAltElite
 */
package testDriver;

import AdminFunctionalities.*;
import CMCDatabase.*;
import other.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;


public class DBLibraryDriver extends DBController {
  //private UniversityDBLibrary library;
  
  public DBLibraryDriver() {
	 
  }
  
  public static void main(String[] args) {
    try{
    	System.out.println("THIS IS THE DRIVER, TO TEST METHODS UNCOMMENT THEM AND RUN DRIVER. BE CAREFUL BEFORE YOU CHANGE ANYTHING. \n\n");

    	DBController dbc = new DBController();
    	
//WORKS:   
    	//dbc.testAdd();                      //Do Not Uncomment, will add a duplicate ZTESTUNI unless you edit testAdd in DBController. 
    	//dbc.testSaveUni();					//Do not Uncomment, will save BROWN to juser unless you edit testSaveUni in DBCController
    	rMethod();
    	//dbc.addUser("Jackson", "Oettinger", "Jack@gmail.com", "helloworld", 'a'); 
    	
    	//dbc.loadUniversities();				//loads universities into a list, uncomment print statement in DBController to test it.
    	//dbc.viewAllUnis();					//view list of Universities
    	//dbc.loadUsers();						//loads users into a list, uncomment print statement in DBController to test it.
    	
    	//dbc.viewAllUsers();					//view list of users
    	//dbc.getDetailsProfile();			//gets details of a single user
    	//dbc.getDetailsProfile2("juser");
    	
    	//dbc.compareAccountInfo("juser", "John", "User");
    	
    	//dbc.checkPasswordRequirements("ArandomPa55word");

    	//dbc.containsLowerCase(password);
    	//dbc.containsNumber(password);
    	//dbc.containsUpperCase(password);
    	//dbc.passwordLength(password);
    
    	
    
    	
    	
//ALL METHODS: 
    	
    	//dbc.editUser("juser");
    	//dbc.emailSavedSchoolsList(list);
    	//dbc.equals(obj);
    	//dbc.getClass();  
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
    	//unc.addUniversityInfo();        //RUN HERE, adds newUniversity to database
    	
    	//unc.editUniversity();           //RUN HEREuse "ztestuni"
    	
    	//unc.getDetailsUni();			// gets details of one university, Run from AccountController

    	
    	
//Needs Work
    	//unc.recommendedSchools(dbc.loadUniversities().get(9));			//reccomended schools
    	
//ALL METHODS:
 
    	//unc.addToList(university);
    	//unc.compareUniversity(university);
    	//unc.editUniversity();
    	//unc.equals(obj);
    	//unc.getClass();
    	//unc.getDetailsUni("YANKTOWN");
    	//unc.toString();
    	
    	
    	
	
    	AccountController acc = new AccountController();
    	
//WORKS:   
    	//acc.getDetailsUni();					//RUN HERE, get details of one university   //654654654654656546546546546655463546464464646645645646654654654654656546546546546655463546464464646645645646
    	
//ALL METHODS:
    	

    	
    	//acc.addProfilePicture(jpeg);
    	
    	//acc.addProfilePicture("jpeg");     //654654654654656546546546546655463546464464646645645646654654654654656546546546546655463546464464646645645646
    	
    	//acc.editProfile("tux420@csbsju.edu");

    	//acc.equals(obj);
    	//acc.getClass();
    	//acc.getPassword(username);
    	//acc.isUserReal(username);
    	//acc.login("juser", "user");
    	//acc.logOut();
    	//acc.passwordRequirements(password);
    	//acc.recoverPassword("email", "firstName", "lastName");
    	
    	//acc.resetPassword("Penguin", "newpassword", "newpassword");   //654654654654656546546546546655463546464464646645645646654654654654656546546546546655463546464464646645645646
    	
    	//acc.toString();
    	//acc.viewProfile(username);
    	//acc.viewProfile(username);
    	
    	

    	AdminFunctionalityController afc = new AdminFunctionalityController();

//WORKS:   
    	//afc.addUser();					//adds new user to database, Run from University Controller
        //afc.viewUniversities();
    	//afc.viewUsers();
    	
//ALL METHODS:    	
    	
    	
    	//afc.addToSavedSchoolsList3();   //5456465465465465465566546546565465465654654654654654654656546546546546655463546464464646645645646
    	
    	//afc.editUniversity();
    	//afc.equals(obj);
    	//afc.getClass();
    	//afc.removeUniversityDB("yanktown");			doesn't work, returns null pointer
    	//afc.removeUniversityDB(schoolName);
    	//afc.setStatus();
    	//afc.setType();
    	//afc.toString();
    	//afc.update(type);
    	//afc.updateStatus(status);
    	//afc.updateType(type);

    	
    	
    	
    	
    	UserFunctionalityController ufc = new UserFunctionalityController();
//WORKS: 
    	//ufc.viewSchool("Bard");
    	
//ALL METHODS: 
    	
    	//ufc.addToList(user);
    	//ufc.emailSavedSchools();
    	//ufc.equals(obj);
    	//ufc.getClass();
    	//ufc.getSavedSchoolsList();
    	//ufc.removeSavedSchool(schoolName);
    	//ufc.saveSchool("name");
    	//ufc.searchSchools("UNI", "MI", null, null, null, "null, null, null", null, null", null, null, null", "20000", "25", "75", "5000", "10000", "50", "100", "50", "100", "1", "5", "1", "5", "1", "5");

    	//ufc.searchSchools("UNI", "MI", "URBAN", "STATE", "35000", "40000", "40", "70", "400", "500", "400", "600", "10000", "20000", "25", "75", "5000", "10000", "50", "100", "50", "100", "1", "5", "1", "5", "1", "5");
    	//ufc.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
    	//ufc.toString();
    	//ufc.updateSavedSchoolsList(list);
    	//ufc.viewSavedSchools();
    	

    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}