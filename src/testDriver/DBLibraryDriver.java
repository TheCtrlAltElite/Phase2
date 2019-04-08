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
     
     //unc.addToSavedSchoolsList2("luser", "YALE"); 
     //unc.removeFromList("juser", "HARVARD"); 
     //unc.compareUniversity(University university);

     //unc.addToSavedSchoolsList2("luser", "YALE"); 
     //unc.removeFromList("luser", "AUBURN");                 	<<<<<<<<<<<<<<< //PROBABLY GOING TO DELETE
     //unc.compareUniversity(realUni);

     
     DBController dbc = new DBController();

     //List<University> listUnis = dbc.loadUniversities();
     //unc.recommendedSchools(listUnis.get(4));

     //List<University> listUnis = dbc.loadUniversities();
     //unc.recommendedSchools(listUnis.get(0));

     //dbc.sendRecoverEmail("juser");
     //dbc.checkPasswordRequirements("PenguinPower");
     //unc.compareUniversity(listUnis.get(5)); 	 //not ready
     //unc.recommendedSchools(University university;	//not ready
     //unc.editUniversity("CSBSJU", "MN", "URBAN", "STATE", 20000, 50, 70, 600, 600, 31500, 20, 1000, 3, 5, 5, 5);
     //dbc.addUniversity("TESTUNIDONTDELETE", "-1", "-1", "-1", -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
     //unc.getDetailsUni("YALE"); 							//Make sure school being searched is in DB as all caps, otherwise remove toUpperCase() in UniversityController.
     
     AccountController acc = new AccountController();
     
     //acc.login("luser", "ImadRahal4");
     //acc.logOut();
     //acc.isUserReal("jmuehls");
     //acc.getPassword("juser");
     //acc.viewProfile("juser");
     //acc.editProfile("Eli123", "Tux", "tux420@csbsju.edu", "TuxIsOurSavior1", 'u', 'Y'); 									//does not work
     //acc.resetPassword("Maren", "Maren300000", "Maren300000");
     //acc.recoverPassword("joettinge001@gmail.com");		
     //acc.addProfilePicture(String jpeg);							//not ready
     //acc.passwordRequirements(String password);
 
     
     AdminInteraction aic = new AdminInteraction();

     //aic.addToSavedSchoolsList4();  //works 100%
     //aic.addUniversity();    //works 100%
     //aic.removeUniversityDB();     //works 100%
     //aic.addUser();     //work 100%
     //aic.viewUniversities();     //work 100%
     //aic.viewUsers();    //work 100%
     //aic.editUniversity();     //works 100%


     AdminFunctionalityController afc = new AdminFunctionalityController();
     
     //afc.addToSavedSchoolsList3("luser", "zxy");     //works 100%; call from AdminInteraction
     //afc.addUniversity("zza", "gb", "bg", "bg", 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2);     //works 100%; call from AdminInteraction
     //afc.removeUniversityDB("zzo");     //works 100%; call from AdminInteraction
     //afc.addUser("zosbaldo", "zmatias", "omuser", "pass", 'a');     //works 100%; call from AdminInteraction
     //afc.viewUniversities();    //works 100%
     //afc.viewUsers();     //works 100%

     
     UserFunctionalityController ufc = new UserFunctionalityController();
     
     //ufc.searchSchools(String schoolName, String schoolState, String schoolLocation,String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1, String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2, String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2, String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2, String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2, String socialScale1, String socialScale2, String qualityScale1, String qualityScale2);
     //ufc.addToSavedSchoolsList3("juser", "YALE");
     //ufc.viewSchool(String schoolName);
     //ufc.removeSavedSchool("luser", "BARUCH");
     //ufc.updateSavedSchoolsList(List<UserSchool> list);
     //ufc.emailSavedSchools();
     //ufc.getSavedSchoolsList("juser");
     
     
     
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}