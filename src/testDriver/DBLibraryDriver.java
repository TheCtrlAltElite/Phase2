/**
 * Author: CtrlAltElite
 */
package testDriver;

import AdminFunctionalities.*;
//import CMCDatabase.*;
import other.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;


public class DBLibraryDriver{
  //private UniversityDBLibrary library;
  
  public DBLibraryDriver() {
  
  }
  
  public static void main(String[] args) {
    try{

     UniversityController unc = new UniversityController();
     
     //unc.addToSavedSchoolsList2("juser"); 
     //unc.removeFromList(User user, University university)
     //unc.compareUniversity(University university)
     //unc.recommendedSchools(University university;
     //unc.editUniversity();
     //unc.getDetailsUni();
     
     AccountController acc = new AccountController();
     
     //acc.login(String username, String password);
     //acc.logOut();
     //cc.isUserReal(String username);
     //acc.getPassword(String username);
     //acc.viewProfile(String username);
     //acc.editProfile("juser"); //?
     //acc.resetPassword(String o, String n1, String n2);
     //acc.recoverPassword(String email, String firstName, String lastName);
     //acc.addProfilePicture(String jpeg);
     //acc.passwordRequirements(String password);
     //acc.getDetailsUni();
     
     AdminFunctionalityController afc = new AdminFunctionalityController();
     
     //afc.addToSavedSchoolsList3();
     //afc.viewUniversities();
     //afc.addUniversity();
     //afc.editUniversity();
     //afc.viewUsers();
     //afc.addUser();
     //afc.removeUniversityDB(String schoolName)
     
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