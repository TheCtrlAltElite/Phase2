/**
 * 
 */

package CMCDatabase;
import java.util.*;
import java.util.List;
import java.awt.*;
import other.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;
import dblibrary.project.csci230.*;

/**
 * @author lneuensch001
 *
 */
public class DBController {

	private UniversityDBLibrary library;
	
	/**
	 * Creates a DBController object.
	 */
	public DBController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Gets the details for the profile of username.
	 * 
	 * @param String username
	 * @return List with all the details of the profile
	 */
	public List getDetailsProfile(String username){
		return null;
	}
	/**
	 * Gets the details for the university with name school.
	 * 
	 * @param String school the name of the school
	 * @return a Collection of the details for that University
	 */
	public Collection getDetailsUni(String school) {
		return null;
	}
	/**
	 * Checks the database to see if that username exists in the database.
	 * 
	 * @param username
	 * @return boolean true if the username is in the database or false if the username is not in the database
	 */
	public boolean isUserReal(String username) {
		return false;
	}
	/**
	 * 
	 * 
	 * @param username
	 */
	public void editUser(User user) {
		this.library.user_editUser(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPasssword(), user.getType(), user.getStatus());
	}
	/**
	 * 
	 */
	public  List<University> loadUniversities() {
		String[][] arrayUnis = library.university_getUniversities();
		List<University> listUnis= new ArrayList<University>();
		String schoolName;
		String schoolState;
		String schoolLocation;
		String schoolControl;
		int numberStudents;
		int percentFemale;
		int verbalSAT;
		int mathSAT;
		int schoolExpenses;
		int percentFinancialAid;
		int numApplicants;
		int percentAdmitted;
		int percentEnrolled;
		int academicScale;
		int socialScale;
		int qualityScale;
		for(int i = 0; i <= arrayUnis.length; i++) {
			schoolName = arrayUnis[i][0];
			schoolState = arrayUnis[i][1];
			schoolLocation = arrayUnis[i][2];
			schoolControl = arrayUnis[i][3];
			numberStudents = Integer.parseInt(arrayUnis[i][4]);
			percentFemale = Integer.parseInt(arrayUnis[i][5]);
			verbalSAT = Integer.parseInt(arrayUnis[i][6]);
			mathSAT = Integer.parseInt(arrayUnis[i][7]);
			schoolExpenses = Integer.parseInt(arrayUnis[i][8]);
			percentFinancialAid = Integer.parseInt(arrayUnis[i][9]);
			numApplicants = Integer.parseInt(arrayUnis[i][10]);
			percentAdmitted = Integer.parseInt(arrayUnis[i][11]);
			percentEnrolled = Integer.parseInt(arrayUnis[i][12]);
			academicScale = Integer.parseInt(arrayUnis[i][13]);
			socialScale = Integer.parseInt(arrayUnis[i][14]);
			qualityScale = Integer.parseInt(arrayUnis[i][15]);
			University uni = new University(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
			listUnis.add(uni);
		}
		return listUnis;
	}
	/**
	 * 
	 * @param search
	 */
	public void compareSearchCriteria(SearchCriteria search) {
		//TODO
	}
	/**
	 * 
	 * @param search
	 */
	public void updateUniversity(SearchCriteria search) {
		//TODO
	}
	/**
	 * 
	 * @param list of UserSchool's
	 */
	public void updateSavedSschoolsList(List list) {
		//TODO
	}
	/**
	 * 
	 */
	public void loadUsers() {
		//TODO
	}
	/**
	 * 
	 * @param status
	 */
	public void updateStatus(String status) {
		//TODO
	}
	/**
	 * 
	 * @param type
	 */
	public void updateType(String type) {
		//TODO
	}
	/**
	 * 
	 * @return
	 */
	public String getPassword(String username) {
		return null;
	}
	/**
	 * 
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param profilePic
	 * @param Type
	 * @param Status
	 */
	public void addUser(String password, String firstName, String lastName, String email, String profilePic, String Type, String Status) {
		//TODO
	}
	/**
	 * 
	 * @param type
	 */
	public void update(String type) {
		
	}
	/**
	 * 
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public boolean compareAccountInfo(String email, String firstName, String lastName) {
		return false;
	}
	/**
	 * 
	 */
	public void sendRecoverEmail() {
		//TODO
	}
	/**
	 * 
	 * @param list of UserSchool's
	 */
	public void emailSavedSchoolsList(List list) {
		//TODO
	}
	/**
	 * 
	 * @param jpeg
	 */
	public void updateProfilePic(String jpeg) {
		
	}
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkPasswordRequirements(String password) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsLowerCase(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsUpperCase(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsSpecialCharacter(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsNumber(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		//TODO
	}
}