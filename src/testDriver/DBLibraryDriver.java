/**
 * Author: CtrlAltElite
 */
package testDriver;

import java.util.List;

import AccountFunctionalities.AccountController;
import AdminFunctionalities.*;
import CMCDatabase.DBController;
//import CMCDatabase.*;
import other.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;
import dblibrary.project.csci230.UniversityDBLibrary;


public class DBLibraryDriver{
  //private UniversityDBLibrary library;
  
  public DBLibraryDriver() {
  }
  
  public static void main(String[] args) {
    try{

     UniversityController unc = new UniversityController();
     
     //unc.addToSavedSchoolsList2("juser"); 
     //unc.removeFromList("juser", "HARVARD"); 
     //unc.compareUniversity(University university);
     
     //DBController dbc = new DBController();
     //List<University> listUnis = dbc.loadUniversities();
     //unc.recommendedSchools(listUnis.get(4));
     
     //unc.compareUniversity(University university); 	 //not ready
     //unc.recommendedSchools(University university;	//not ready
     //unc.editUniversity();
     //unc.getDetailsUni(); 							//Make sure school being searched is in DB as all caps, otherwise remove toUpperCase() in UniversityController.
     
     AccountController acc = new AccountController();
     
     //acc.login("jmuehls", "Muehlenbein100");
     //acc.logOut();
     //acc.isUserReal("jmuehls");
     //acc.getPassword("jmuehls");
     //acc.viewProfile("juser");
     //acc.editProfile("juser"); 									//does not work
     //acc.resetPassword("Maren", "Maren300000", "Maren300000");
     //acc.recoverPassword(String email, String firstName, String lastName);
     //acc.addProfilePicture(String jpeg);							//not ready
     //acc.passwordRequirements(String password);
 
     
     AdminFunctionalityController afc = new AdminFunctionalityController();
     
     //afc.addToSavedSchoolsList3();
     //afc.viewUniversities();
     //afc.addUniversity();
     //afc.editUniversity();
     //afc.viewUsers();
     //afc.addUser();
     //afc.removeUniversityDB("ZZdzfgds");  //only one that does not work in AdminFunctionalityController
     
     UserFunctionalityController ufc = new UserFunctionalityController();
     
     //ufc.searchSchools(String schoolName, String schoolState, String schoolLocation,String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1, String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2, String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2, String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2, String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qualityScale1, String qualityScale2);
     //ufc.addToSavedSchoolsList3(String userName);
     //ufc.viewSchool(String schoolName);
     //ufc.removeSavedSchool(String username);
     //ufc.updateSavedSchoolsList(List<UserSchool> list);
     //ufc.emailSavedSchools();
     //ufc.getSavedSchoolsList();
     
     
     
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}