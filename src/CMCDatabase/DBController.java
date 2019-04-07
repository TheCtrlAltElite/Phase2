/**
 * Java.DBController
 */

package CMCDatabase;

import java.sql.Timestamp;
import java.util.*;

import AccountFunctionalities.Account;
import UniversityFunctionalities.*;
import UserFunctionalities.*;
import dblibrary.project.csci230.*;

/**
 * @author CtrlAltElite
 *
 */
public class DBController {

	private UniversityDBLibrary library;
	private List<University> listUnis;
	private List<Account> listUsers;
	
	/**
	 * Creates a DBController object.
	 */
	public DBController() {
		  library = new UniversityDBLibrary("ctrlaltd","csci230");	
		  
	}
	
	/**
	 * Test method for the library
	 * 
	 * @return
	 */
	public UniversityDBLibrary getUnivDBlib(){
	    return library;
	}

	/**
	 * Test method for the Driver
	 */
	public void rMethod() {
	    System.out.println("Driver is Working and is communicating with DBController \n");
	}
	
	/**
	 * Test method for the add functionality
	 */
	public void testAdd() {
		library.university_addUniversity("ZCSB", "MN", "RURAL", "Private", 10000, 99, 1600, 1600, 2, 100, 1000, 999, 4000, 5, 5, 5);
	}
	
	/**
	 * Test method for saving a university to a saved schools list
	 */
	public void testSaveUni() {
		String name = "juser";
		String uni = "BROWN";
		library.user_saveSchool(name, uni);
		//return 1;
	}
	
	
	/**
	 * Gets the details for the profile of username.
	 * 
	 * @param String username
	 * @return List with all the details of the profile
	 */
	public List<String> getDetailsProfile2(String userName){
		List<String> details = new ArrayList<String>();
		List<Account> users = loadUsers();
		for(int i = 0; i < users.size(); i++) {
			if(userName.equals(users.get(i).getEmail())) {				
				details.add(users.get(i).getFirstName());
				details.add(users.get(i).getLastName());
				details.add(users.get(i).getEmail());
				details.add(users.get(i).getPassword());
				details.add(Character.toString(users.get(i).getType()));
				details.add(Character.toString(users.get(i).getStatus()));
			}
		}
		return details;
	}

	/**
	 * Checks the database to see if that username exists in the database.
	 * 
	 * @param username
	 * @return boolean true if the username is in the database or false if the username is not in the database
	 */
	public boolean isUserReal(String username) {
		List<Account> users = loadUsers();
		for(int i = 0; i < users.size(); i++) {
			if(username.equals(users.get(i).getEmail())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Gets user information from database
	 * 
	 * @param username the user of which to get the details for
	 */
	public int editUser(Account account) {
		return this.library.user_editUser(account.getEmail(), account.getFirstName(), account.getLastName(), account.getPassword(), account.getType(), account.getStatus());
	}
	
	
	
	
	
	/**
	 * Returns a list of all of the universities in the database.
	 * 
	 * @return List of universities
	 */
	public  List<University> loadUniversities() {
		String[][] arrayUnis = library.university_getUniversities();
		this.listUnis= new ArrayList<University>();
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
		for(int i = 0; i < arrayUnis.length; i++) {
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
			//System.out.println(listUnis.get(i).getSchoolName());    //prints all universities
		}
		//System.out.println(listUnis.get(54).getSchoolName());   //will return university at index 54 which is Harvard
		return listUnis;
	}

	/**
	 * Updates the information for a university in the database.
	 * 
	 * @param search
	 */
	public int updateUniversity(String school, String state, String location, java.lang.String control, int numberOfStudents, double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		return library.university_editUniversity(school, state, location,control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
	
	/**
	 * Adds a new university to the database
	 * 
	 * @param newUni
	 */
	public void addUniversity(String schoolName, String schoolState, String schoolLocation, String schoolControl, int numberStudents,
			int percentFemale, int verbalSAT, int mathSAT, int schoolExpenses, int percentFinancialAid, int numApplicants,
			int percentAdmitted, int percentEnrolled, int academicScale, int socialScale, int qualityScale) {
		
		library.university_addUniversity(schoolName, schoolState, schoolLocation, schoolControl, numberStudents,
				percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants,
				percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
	}

	/**
	 * Adds a university to a saved schools list
	 * 
	 * @param String username, the user to whom the saved schools list being added to belongs
	 * @param String school, the school name of the school to save to the saved schools list
	 */
	public void addToSavedSchoolsList1(String username, String school) {
		library.user_saveSchool(username, school);
	}
	
	
	
	
	/**
	 * Removes a school from a saved schools list
	 * 
	 * @param username the user whose saved schools will be changed
	 * @param school the name of the schools to remove from the user's saved schools list
	 */
	public int removeFromSavedSchoolsList(String username, String school) {
		return library.user_removeSchool(username, school);
	}
	
	public Map<String, String> getSavedSchoolsList(String username) {
		String[][] listUserSave	= library.user_getUsernamesWithSavedSchools();
		Map<String, String> mapUserSave = new TreeMap<>();
		for (int i = 0; i < listUserSave.length; i++) {
			if (username.equals(listUserSave[i][0])){
				mapUserSave.put(listUserSave[i][1], listUserSave[i][2]);
			}
		}
		return mapUserSave;
	}
	
	
	/**
	 * Pulls user information from database, creates a user object, and adds the object to a list that is returned. 
	 * 
	 * @return List of all users in the database
	 */
	public List<Account> loadUsers() {
		String [][] arrayUsers = library.user_getUsers();
		this.listUsers = new ArrayList<Account>();
		String firstName;
		String lastName;
		String emailUserName;
		String password;
		String type;
		String status; 
		for(int i = 0; i < arrayUsers.length; i++) {
		firstName = arrayUsers[i][0];
		lastName = arrayUsers[i][1];
		emailUserName = arrayUsers[i][2];
		password = arrayUsers[i][3];
		type = arrayUsers[i][4];
		status = arrayUsers[i][5];	
		Account account = new Account(emailUserName, firstName, lastName, password, type.charAt(0), status.charAt(0));
		listUsers.add(account);
		}
		return listUsers;
	}
	
	

	/**
	 * Gets the password for a user from the database
	 * 
	 * @param username the user to search the database for
	 * @return String the password the user
	 */
	public String getPassword(String username) {
		List<Account> users = loadUsers();
		for(int i = 0; i < users.size(); i++) {
			if(username.equals(users.get(i).getEmail())) {
				return users.get(i).getPassword();
			}
		}
		return "That user does not exist.";
	}
	
	/**
	 * Adds a account to the database
	 * 
	 * @param firstName the first name of the new account
	 * @param lastName the last name of the new account
	 * @param username the username/email for the new account
	 * @param password the password for the new account
	 * @param type the type of the new account
	 */
	public void addUser(String firstName, String lastName, String username, String password, char type) {
		library.user_addUser(firstName, lastName, username, password, type);
	}

	/**
	 * Compares the given information to the information for an account from the database with an email matching the email parameter
	 * 
	 * @param email the username/email to compare
	 * @param firstName the first name to compare
	 * @param lastName the last name to compare
	 * @return true if all the parameters match the database's information
	 * @return false if any of the parameters do not match the database's information
	 */
	public boolean compareAccountInfo(String userName, String firstName, String lastName) {
		List<String> details = getDetailsProfile2(userName);
		//User user = new User(details.get(0), details.get(1), details.get(2), details.get(3), details.get(4).charAt(0), details.get(5).charAt(0));
		//if(email.equals(user.getEmail()) && firstName.equals(user.getFirstName()) && lastName.equals(user.getLastName())) {
		if(userName.equals(details.get(2)) && firstName.equals(details.get(0)) && lastName.equals(details.get(1))) {
			System.out.println("Success");
			return true;
		}
		else {
		System.out.println("Your email, first name, or last name was incorrect.");
		return false;
		}
	}
	
	/**
	 * Sets the account's new profile picture
	 * 
	 * @param jpeg the name of the new image for the profile
	 */
	public void updateProfilePic(String jpeg) {
		
	}
	/**
	 * Checks the new password against the systems password requirements
	 * 
	 * @param password the new password to check against the requirements
	 * @return true if the parameter password contains all the password requirements
	 * @return false if the parameter password does not contain all password requirements
	 */
	public boolean checkPasswordRequirements(String password) {
		if(this.containsLowerCase(password) && this.containsUpperCase(password) && this.containsNumber(password) && this.passwordLength(password)) {
			System.out.println("Your password meets the requirements.");
			return true;
		}
		System.out.println("Did not meet password requirements.");
		return false;
	}
	/**
	 * Checks to see if the password contains a lower case character
	 * 
	 * @param password the password to check
	 * @return true if the password contains a lower case character
	 * @return false if the password does not contains a lower case character
	 */
	public boolean containsLowerCase(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLowerCase(password.charAt(i))){
				return true;
			}
		}
		System.out.println("Password must contain a lower case letter.");
		return false;
	}
	/**
	 * Checks to see if the password contains a upper case character
	 * 
	 * @param password the password to check
	 * @return true if the password contains a upper case character
	 * @return false if the password does not contains a upper case character
	 */
	public boolean containsUpperCase(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isUpperCase(password.charAt(i))){
				return true;
			}
		}
		System.out.println("Password must contain an upper case letter.");
		return false;
	}
	/**
	 * Checks to see if the password is of sufficient length for the password requirements
	 * 
	 * @param password the password to check
	 * @return true if the password if of sufficient length
	 * @return false if the password is not of sufficient length
	 */
	public boolean passwordLength(String password) {
		if(password.length() >= 10) {
			return true;
		}
		System.out.println("Password must be 10 characters long.");
		return false;
	}
	/**
	 * Checks to see if the password contains a number character
	 * 
	 * @param password the password to check
	 * @return true if the password contains a number character
	 * @return false if the password does not contains a number character
	 */
	public boolean containsNumber(String password) {
		for(int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))){
				return true;
			}
		}
		System.out.println("Password must contain a number.");
		return false;
	}
	/**
	 * Removes a university from the database
	 * 
	 * @param schoolName the name of the school to remove from the database
	 */
	public void removeUniversityDB(String schoolName) {
		library.university_deleteUniversity(schoolName);
	}
	
	/**
	 * Gets the max number of students of the universities in the database
	 * 
	 * @return float the max number of students of the universities in the database
	 */
	public float maxNumStudents() {
		List<Integer> listOfStudents = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumberStudents() != -1) {
				listOfStudents.add(listUnis.get(j).getNumberStudents());
			}
		}
		Collections.sort(listOfStudents);
		float maxStudents = listOfStudents.get(listOfStudents.size() - 1);	//Subtracts 1 to ensure that the 
		return maxStudents;		//index of the array is realigned
	}
	
	/**
	 * Gets the min number of students of the universities in the database
	 * 
	 * @return float the min number of students of the universities in the database
	 */
	public float minNumStudents() {
		List<Integer> listOfStudents = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumberStudents() != -1) {
				listOfStudents.add(listUnis.get(j).getNumberStudents());
			}
		}
		Collections.sort(listOfStudents);
		float minStudents = listOfStudents.get(0);
		return minStudents;
	}
	
	/**
	 * Gets the max percent female of the universities in the database
	 * 
	 * @return float the max percent female of the universities in the database
	 */
	public float maxFemale() {
		List<Integer> percentFemale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFemale() != -1) {
				percentFemale.add(listUnis.get(j).getPercentFemale());
			}
		}
		Collections.sort(percentFemale);
		float maxFemale = percentFemale.get(percentFemale.size() - 1); //Subtracts 1 to ensure that the 
		return maxFemale;											 //index of the array is realigned
	}
	/**
	 * Gets the min percent female of the universities in the database
	 * 
	 * @return float the min percent female of the universities in the database
	 */
	public float minFemale() {
		List<Integer> percentFemale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFemale() != -1) {
				percentFemale.add(listUnis.get(j).getPercentFemale());
			}
		}
		Collections.sort(percentFemale);
		float minFemale = percentFemale.get(0);  
		return minFemale;											 
	}
	
	/**
	 * Gets the max verbal SAT of the universities in the database
	 * 
	 * @return float the max verbal SAT of the universities in the database
	 */
	public float maxSATVerbal() {
		List<Integer> satVerbal = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getVerbalSAT() != -1) {
				satVerbal.add(listUnis.get(j).getVerbalSAT());
			}
		}
		Collections.sort(satVerbal);
		float maxSATVerbal = satVerbal.get(satVerbal.size() - 1); //Subtracts 1 to ensure that the 
		return maxSATVerbal;									//index of the array is realigned										 
	}
	
	/**
	 * Gets the min verbal SAT of the universities in the database
	 * 
	 * @return float the min verbal SAT of the universities in the database
	 */
	public float minSATVerbal() {
		List<Integer> satVerbal = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getVerbalSAT() != -1) {
				satVerbal.add(listUnis.get(j).getVerbalSAT());
			}
		}
		Collections.sort(satVerbal);
		float minSATVerbal = satVerbal.get(0); 		
		return minSATVerbal;																		 
	}
	
	/**
	 * Gets the max math SAT of the universities in the database
	 * 
	 * @return float the max math SAT of the universities in the database
	 */
	public float maxSATMath() {
		List<Integer> satMath = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getMathSAT() != -1) {
				satMath.add(listUnis.get(j).getMathSAT());
			}
		}
		Collections.sort(satMath);
		float maxSATMath = satMath.get(satMath.size() - 1); //Subtracts 1 to ensure that the
		return maxSATMath;									//index of the array is realigned										 
	}
	
	/**
	 * Gets the min math SAT of the universities in the database
	 * 
	 * @return float the min math SAT of the universities in the database
	 */
	public float minSATMath() {
		List<Integer> satMath = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getMathSAT() != -1) {
				satMath.add(listUnis.get(j).getMathSAT());
			}
		}
		Collections.sort(satMath);
		float minSATMath = satMath.get(0); 		
		return minSATMath;																		 
	}
	
	/**
	 * Gets the max expenses of the universities in the database
	 * 
	 * @return float the max expenses of the universities in the database
	 */
	public float maxExpenses() {
		List<Integer> expenses = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSchoolExpenses() != -1) {
				expenses.add(listUnis.get(j).getSchoolExpenses());
			}
		}
		Collections.sort(expenses);
		float maxExpenses = expenses.get(expenses.size() - 1); //Subtracts 1 to ensure that the 
		return maxExpenses;									//index of the array is realigned										 
	}
	
	/**
	 * Gets the min expenses of the universities in the database
	 * 
	 * @return float the min expenses of the universities in the database
	 */
	public float minExpenses() {
		List<Integer> expenses = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSchoolExpenses() != -1) {
				expenses.add(listUnis.get(j).getSchoolExpenses());
			}
		}
		Collections.sort(expenses);
		float minExpenses = expenses.get(0); 
		return minExpenses;																		 
	}
	
	/**
	 * Gets the max amount of financial aid of the universities in the database
	 * 
	 * @return float the max amount of financial aid of the universities in the database
	 */
	public float maxFinancialAid() {
		List<Integer> aid = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFinancialAid() != -1) {
				aid.add(listUnis.get(j).getPercentFinancialAid());
			}
		}
		Collections.sort(aid);
		float maxAid = aid.get(aid.size() - 1); 			//Subtracts 1 to ensure that the 
		return maxAid;									//index of the array is realigned										 
	}
	
	/**
	 * Gets the min amount of financial aid of the universities in the database
	 * 
	 * @return float the min amount of financial aid of the universities in the database
	 */
	public float minFinancialAid() {
		List<Integer> aid = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFinancialAid() != -1) {
				aid.add(listUnis.get(j).getPercentFinancialAid());
			}
		}
		Collections.sort(aid);
		float minAid = aid.get(0); 	
		return minAid;																			 
	}
	
	/**
	 * Gets the max number of applicants of the universities in the database
	 * 
	 * @return float the max number of applicants of the universities in the database
	 */
	public float maxNumApplicants() {
		List<Integer> numApps = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumApplicants() != -1) {
				numApps.add(listUnis.get(j).getNumApplicants());
			}
		}
		Collections.sort(numApps);
		float maxApps = numApps.get(numApps.size() - 1);  //Subtracts 1 to ensure that the 
		return maxApps;									//index of the array is realigned										 
	}
	
	/**
	 * Gets the min number of applicants of the universities in the database
	 * 
	 * @return float the min number of applicants of the universities in the database
	 */
	public float minNumApplicants() {
		List<Integer> numApps = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumApplicants() != -1) {
				numApps.add(listUnis.get(j).getNumApplicants());
			}
		}
		Collections.sort(numApps);
		float minApps = numApps.get(0); 	
		return minApps;																		 
	}
	
	/**
	 * Gets the max percent of students admitted of the universities in the database
	 * 
	 * @return float the max percent of students admitted of the universities in the database
	 */
	public float maxPercentAdmitted() {
		List<Integer> percentAdmitted = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentAdmitted() != -1) {
				percentAdmitted .add(listUnis.get(j).getPercentAdmitted());
			}
		}
		Collections.sort(percentAdmitted );
		float maxAdmitted = percentAdmitted.get(percentAdmitted .size() - 1);  //Subtracts 1 to ensure that the 
		return maxAdmitted;									//index of the array is realigned										 
	}
	
	/**
	 * Gets the min percent of students admitted of the universities in the database
	 * 
	 * @return float the min percent of students admitted of the universities in the database
	 */
	public float minPercentAdmitted() {
		List<Integer> percentAdmitted = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentAdmitted() != -1) {
				percentAdmitted .add(listUnis.get(j).getPercentAdmitted());
			}
		}
		Collections.sort(percentAdmitted );
		float minAdmitted = percentAdmitted.get(0);  //Subtracts 1 to ensure that the 
		return minAdmitted;									//index of the array is realigned										 
	}
	
	/**
	 * Gets the max percent of students enrolled of the universities in the database
	 * 
	 * @return float the max percent of students enrolled of the universities in the database
	 */
	public float maxPercentEnrolled() {
		List<Integer> percentEnrolled = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentEnrolled() != -1) {
				percentEnrolled .add(listUnis.get(j).getPercentEnrolled());
			}
		}
		Collections.sort(percentEnrolled);
		float maxEnrolled = percentEnrolled.get(percentEnrolled .size() - 1);  //Subtracts 1 to ensure that the
		return maxEnrolled;													 //index of the array is realigned										 
	}
	
	/**
	 * Gets the min percent of students enrolled of the universities in the database
	 * 
	 * @return float the min percent of students enrolled of the universities in the database
	 */
	public float minPercentEnrolled() {
		List<Integer> percentEnrolled = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentEnrolled() != -1) {
				percentEnrolled .add(listUnis.get(j).getPercentEnrolled());
			}
		}
		Collections.sort(percentEnrolled);
		float maxEnrolled = percentEnrolled.get(0);  		 
		return maxEnrolled;																			 
	}
	
	/**
	 * Gets the max academic scale of the universities in the database
	 * 
	 * @return float the max academic scale of the universities in the database
	 */
	public float maxAcademicScale() {
		List<Integer> academicScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getAcademicScale() != -1) {
				academicScale .add(listUnis.get(j).getAcademicScale());
			}
		}
		Collections.sort(academicScale);
		float maxAcademicScale = academicScale.get(academicScale .size() - 1); 		 //Subtracts 1 to ensure that the 
		return maxAcademicScale;													 //index of the array is realigned										 
	}
	
	/**
	 * Gets the min academic scale of the universities in the database
	 * 
	 * @return float the min academic scale of the universities in the database
	 */
	public float minAcademicScale() {
		List<Integer> academicScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getAcademicScale() != -1) {
				academicScale .add(listUnis.get(j).getAcademicScale());
			}
		}
		Collections.sort(academicScale);
		float minAcademicScale = academicScale.get(0); 		 
		return minAcademicScale;													 										 
	}
	
	/**
	 * Gets the max social scale of the universities in the database
	 * 
	 * @return float the max social scale of the universities in the database
	 */
	public float maxSocialScale() {
		List<Integer> socialScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSocialScale() != -1) {
				socialScale .add(listUnis.get(j).getSocialScale());
			}
		}
		Collections.sort(socialScale);
		float maxSocialScale = socialScale.get(socialScale .size() - 1); 		 //Subtracts 1 to ensure that the 
		return maxSocialScale;													 //index of the array is realigned										 
	}
	
	/**
	 * Gets the min social scale of the universities in the database
	 * 
	 * @return float the min social scale of the universities in the database
	 */
	public float minSocialScale() {
		List<Integer> socialScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSocialScale() != -1) {
				socialScale .add(listUnis.get(j).getSocialScale());
			}
		}
		Collections.sort(socialScale);
		float minSocialScale = socialScale.get(0); 		  
		return minSocialScale;																					 
	}
	
	/**
	 * Gets the max quality of life scale of the universities in the database
	 * 
	 * @return float the max quality of life scale of the universities in the database
	 */
	public float maxQualityOfLifeScale() {
		List<Integer> qualityScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getQualityScale() != -1) {
				qualityScale .add(listUnis.get(j).getQualityScale());
			}
		}
		Collections.sort(qualityScale);
		float maxQualityScale = qualityScale.get(qualityScale .size() - 1); 		 //Subtracts 1 to ensure that the 
		return maxQualityScale;													 //index of the array is realigned										 
	}
	
	/**
	 * Gets the min quality of life scale of the universities in the database
	 * 
	 * @return float the min quality of life scale of the universities in the database
	 */
	public float minQualityOfLifeScale() {
		List<Integer> qualityScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getQualityScale() != -1) {
				qualityScale .add(listUnis.get(j).getQualityScale());
			}
		}
		Collections.sort(qualityScale);
		float minQualityScale = qualityScale.get(0); 		 
		return minQualityScale;													 									 
	}

}