/**
 * Author: Osbaldo Matias
 */
package testDriver;

import dblibrary.project.csci230.*;

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
    	System.out.println("THIS IS THE DRIVER, TO TEST METHODS UNCOMMENT THEM AND RUN DRIVER. BE CAREFUL BEFORE YOU CHANGE ANYTHING. ");

    	
    	
    	DBController dbc = new DBController();
    	
//WORKS:   
    	//dbc.testAdd();                      Do Not Uncomment; will add a duplicate ZTESTUNI unless you edit testAdd in DBController. 
    	//dbc.rMethod();
    	//dbc.loadUniversities();
    	//dbc.addUniversity(newUni);          Can only be tested through addUniversityInfo in UniversityController
    	
//ALL METHODS: 
    	
    	//dbc.addUser(password, firstName, lastName, email, profilePic, Type, Status);
    	//dbc.checkPasswordRequirements(password)
    	//dbc.compareAccountInfo(email, firstName, lastName);
    	//dbc.compareSearchCriteria(search);
    	//dbc.containsLowerCase(array);
    	//dbc.containsNumber(array);
    	//dbc.containsSpecialCharacter(array);
    	//dbc.containsUpperCase(array);
    	//dbc.editUser(user);
    	//dbc.emailSavedSchoolsList(list);
    	//dbc.equals(obj);
    	//dbc.getClass();
    	//dbc.getDetailsProfile(username);
    	//dbc.getDetailsUni(school);
    	//dbc.getPassword(username);
    	//dbc.getUnivDBlib();
    	//dbc.hashCode();
    	//dbc.isUserReal(username);
    	//dbc.loadUniversities();
    	//dbc.loadUsers();
    	//dbc.notify();
    	//dbc.notifyAll();
    	//dbc.removeUniversityDB(schoolName);
    	//dbc.removeUniversityDB(schoolName);
    	//dbc.sendRecoverEmail();
    	//dbc.toString();
    	//dbc.update(type);
    	//dbc.updateProfilePic(jpeg);
    	//dbc.updateSavedSschoolsList(list);
    	//dbc.updateStatus(status);
    	//dbc.updateType(type);
    	//dbc.updateUniversity(school, state, location, control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
    	//dbc.wait();
    	//dbc.wait(timeout);
    	//dbc.wait(timeout, nanos);
    	
    	
    	
    	
    	
    	UniversityController unc = new UniversityController();
    	
//WORKS:    	
    	//unc.editUniversity();           //use "testzuni"
    	//unc.addUniversityInfo();        Must be ran in UniversityController

//ALL METHODS:
    	
    	//unc.getDetailsUni();
    	//unc.addToList(university);
    	//unc.compareUniversity(university);
    	//unc.editUniversity();
    	//unc.equals(obj);
    	//unc.getClass();
    	//unc.getDetailsUni(university);
    	//unc.hashCode();
    	//unc.notify();
    	//unc.notifyAll();
    	//unc.recommendedSchools(university);
    	//unc.toString();
    	//unc.wait();
    	//unc.wait(timeout);
    	//unc.wait(timeout, nanos);

    	
    	
    	
    	
    	
    	AccountController acc = new AccountController();
    	
//WORKS:   
    	
    	
//ALL METHODS:
    	
    	//acc.addProfilePicture(jpeg);
    	acc.editProfile("tux69@csbsju.edu");
    	//acc.equals(obj);
    	//acc.getClass();
    	//acc.getPassword(username);
    	//acc.hashCode();
    	//acc.isUserReal(username);
    	//acc.login("username", "password");
    	//acc.logOut();
    	//acc.notify();
    	//acc.passwordRequirements(password);
    	//acc.recoverPassword(email, firstName, lastName);
    	//acc.resetPassword(o, n1, n2);
    	//acc.toString();
    	//acc.viewProfile(username);
    	//acc.viewProfile(username);
    	//acc.wait();
    	//acc.wait(timeout);
    	//acc.wait(timeout, nanos);
    	
    	
    	
    	
   	
    	AdminFunctionalityController afc = new AdminFunctionalityController();

//WORKS:   
    	
    	
//ALL METHODS:    	
    	
    	//afc.addUser();
    	//afc.editUniversity();
    	//afc.equals(obj);
    	//afc.getClass();
    	//afc.hashCode();
    	//afc.notify();
    	//afc.removeUniversityDB(schoolName);
    	//afc.setStatus();
    	//afc.setType();
    	//afc.toString();
    	//afc.update(type);
    	//afc.updateStatus(status);
    	//afc.updateType(type);
    	//afc.viewUniversities();
    	//afc.viewUsers();
    	//afc.wait();
    	//afc.wait(timeout);
    	//afc.wait(timeout, nanos);
    	
    	
    	
    	
    	
    	UserFunctionalityController ufc = new UserFunctionalityController();
    	
    	//ufc.addToList(user);
    	//ufc.emailSavedSchools();
    	//ufc.equals(obj);
    	//ufc.getClass();
    	//ufc.getSavedSchoolsList();
    	//ufc.hashCode();
    	//ufc.notify();
    	//ufc.notifyAll();
    	//ufc.removeSavedSchool(schoolName);
    	//ufc.saveSchool(schoolName);
    	//ufc.searchSchools(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
    	//ufc.toString();
    	//ufc.updateSavedSchoolsList(list);
    	//ufc.viewSavedSchools();
    	//ufc.viewSchool(schoolName);
    	//ufc.wait();
    	//ufc.wait(timeout);
    	//ufc.wait(timeout, nanos);
    
    
    	
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}