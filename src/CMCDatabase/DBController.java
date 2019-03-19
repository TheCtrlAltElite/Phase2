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
	private List<University> listUnis;
	private List<User> listUsers;
	
	/**
	 * Creates a DBController object.
	 */
	public DBController() {
		  library = new UniversityDBLibrary("ctrlaltd","csci230");	
	}
	
	
	public UniversityDBLibrary getUnivDBlib(){
	    return library;
	}

	public void rMethod() {
	    System.out.println("Driver is Working and is communicating with DBController \n");
	}
	
	
	public void testAdd() {
		library.university_addUniversity("ZTESTUNI", "MN", "RURAL", "Private", 10000, 99, 1600, 1600, 2, 100, 1000, 999, 4000, 5, 5, 5);
	}
	
	
	/**
	 * Gets the details for the profile of username.
	 * 
	 * @param String username
	 * @return List with all the details of the profile
	 */
	public List<String> getDetailsProfile(String username){
		List<String> details = new ArrayList<String>();
		List<User> users = loadUsers();
		for(int i = 0; i < users.size(); i++) {
			if(username.equals(users.get(i).getEmail())) {
				details.add(users.get(i).getEmail());
				details.add(users.get(i).getFirstName());
				details.add(users.get(i).getLastName());
				details.add(users.get(i).getPassword());
				details.add(Character.toString(users.get(i).getType()));
				details.add(Character.toString(users.get(i).getStatus()));
			}
		}
		return details;
	}
	/**
	 * Gets the details for the university with name school.
	 * 
	 * @param String school the name of the school
	 * @return a Collection of the details for that University
	 */
	public List<String> getDetailsUni(String schoolName) {
		List<String> details = new ArrayList<String>();
		List<University> universities = loadUniversities();
		for(int i = 0; i < universities.size(); i++) {
			if(schoolName.equals(universities.get(i).getSchoolName())) {
				details.add(universities.get(i).getSchoolName());
				details.add(universities.get(i).getSchoolState());
				details.add(universities.get(i).getSchoolLocation());
				details.add(universities.get(i).getSchoolControl());
				details.add(Integer.toString(universities.get(i).getNumberStudents()));
				details.add(Integer.toString(universities.get(i).getPercentFemale()));
				details.add(Integer.toString(universities.get(i).getVerbalSAT()));
				details.add(Integer.toString(universities.get(i).getMathSAT()));
				details.add(Integer.toString(universities.get(i).getSchoolExpenses()));
				details.add(Integer.toString(universities.get(i).getPercentFinancialAid()));
				details.add(Integer.toString(universities.get(i).getNumApplicants()));
				details.add(Integer.toString(universities.get(i).getPercentAdmitted()));
				details.add(Integer.toString(universities.get(i).getPercentEnrolled()));
				details.add(Integer.toString(universities.get(i).getAcademicScale()));
				details.add(Integer.toString(universities.get(i).getSocialScale()));
				details.add(Integer.toString(universities.get(i).getQualityScale()));
			}
		}
		System.out.println(details.toString());
		for (int i =0; i < details.size(); i++) {
			System.out.println(details.get(i));
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
		List<User> users = loadUsers();
		for(int i =0; i < users.size(); i++) {
			if(username.equals(users.get(i).getEmail())) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * 
	 * @param username
	 */
	public void editUser(User user) {
		this.library.user_editUser(user.getEmail(), user.getFirstName(), user.getLastName(), user.getPassword(), user.getType(), user.getStatus());
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
			//System.out.println(uni.getSchoolName());
			listUnis.add(uni);
			
		}
		//System.out.println(listUnis.get(54).getSchoolName());   //will return university at index 54 which is Harvard
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
	public void updateUniversity(String school, String state, String location, java.lang.String control, int numberOfStudents, double percentFemales, double SATVerbal, double SATMath, double expenses, double percentFinancialAid, int numberOfApplicants, double percentAdmitted, double percentEnrolled, int academicsScale, int socialScale, int qualityOfLifeScale) {
		
		library.university_editUniversity(school, state, location,control, numberOfStudents, percentFemales, SATVerbal, SATMath, expenses, percentFinancialAid, numberOfApplicants, percentAdmitted, percentEnrolled, academicsScale, socialScale, qualityOfLifeScale);
	}
	
	/**
	 * Adds a new university to the database
	 * 
	 * @param newUni
	 */
	public void addUniversity(University newUni) {
		library.university_addUniversity(newUni.getSchoolName(), newUni.getSchoolState(), 
											  newUni.getSchoolLocation(), newUni.getSchoolControl(), 
											  newUni.getNumberStudents(), newUni.getPercentFemale(), 
											  newUni.getVerbalSAT(), newUni.getMathSAT(), newUni.getSchoolExpenses(), 
											  newUni.getPercentFinancialAid(), newUni.getNumApplicants(), 
											  newUni.getPercentAdmitted(), newUni.getPercentEnrolled(), 
											  newUni.getAcademicScale(), newUni.getSocialScale(), newUni.getQualityScale());
	}
	
	/**
	 * 
	 * @param list of UserSchool's
	 */
	public void addToSavedSchoolsList(String username, String school) {
		library.user_saveSchool(username, school);
	}
	
	public void removeFromSavedSchoolsList(String username, String school) {
		library.user_removeSchool(username, school);
	}
	
	
	/**
	 * Pulls user information from database, creates a user object, and adds the object to a list that is returned. 
	 * 
	 * @return List of all users in the database
	 */
	public List<User> loadUsers() {
		String [][] arrayUsers = library.user_getUsers();
		this.listUsers = new ArrayList<User>();
		String email;
		String firstName;
		String lastName;
		String password;
		String type;
		String status; 
		for(int i = 0; i <= arrayUsers.length; i++) {
		email = arrayUsers[i][0];
		firstName = arrayUsers[i][1];
		lastName = arrayUsers[i][2];
		password = arrayUsers[i][3];
		type = arrayUsers[i][4];
		status = arrayUsers[i][5];	
		User user = new User(email, firstName, lastName, password, type.charAt(0), status.charAt(0));
		listUsers.add(user);
		}
		return listUsers;
	}

	/**
	 * 
	 * @return
	 */
	public String getPassword(String username) {
		List<User> users = loadUsers();
		for(int i = 0; i < users.size(); i++) {
			if(username.equals(users.get(i).getEmail())) {
				return users.get(i).getPassword();
			}
		}
		return "That user does not exist.";
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
	public void addUser(String password, String firstName, String lastName, String email, char type) {
		library.user_addUser(firstName, lastName, email, password, type);
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
		if(this.containsLowerCase(password) && this.containsUpperCase(password) && this.containsNumber(password) && this.passwordLength(password)) {
			return true;
		}
		System.out.println("Did not meet password requirements.");
		return false;
	}
	/**
	 * 
	 * @param array
	 * @return
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
	 * 
	 * @param array
	 * @return
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
	 * 
	 * @param array
	 * @return
	 */
	public boolean passwordLength(String password) {
		if(password.length() >= 10) {
			return true;
		}
		System.out.println("Password must be 10 characters long.");
		return false;
	}
	/**
	 * 
	 * @param array
	 * @return
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
	 * 
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		library.university_deleteUniversity(schoolName);
	}
	
	public int maxNumStudents() {
		List<Integer> listOfStudents = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumberStudents() != -1) {
				listOfStudents.add(listUnis.get(j).getNumberStudents());
			}
		}
		Collections.sort(listOfStudents);
		int maxStudents = listOfStudents.get(listOfStudents.size() - 1);	//Subtracts 1 to ensure that the 
		return maxStudents;													//index of the array is realigned
	}
	
	public int minNumStudents() {
		List<Integer> listOfStudents = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumberStudents() != -1) {
				listOfStudents.add(listUnis.get(j).getNumberStudents());
			}
		}
		Collections.sort(listOfStudents);
		int minStudents = listOfStudents.get(0);
		return minStudents;
	}
	
	public int maxFemale() {
		List<Integer> percentFemale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFemale() != -1) {
				percentFemale.add(listUnis.get(j).getPercentFemale());
			}
		}
		Collections.sort(percentFemale);
		int maxFemale = percentFemale.get(percentFemale.size() - 1); //Subtracts 1 to ensure that the 
		return maxFemale;											 //index of the array is realigned
	}
	
	public int minFemale() {
		List<Integer> percentFemale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFemale() != -1) {
				percentFemale.add(listUnis.get(j).getPercentFemale());
			}
		}
		Collections.sort(percentFemale);
		int minFemale = percentFemale.get(0);  
		return minFemale;											 
	}
	
	public int maxSATVerbal() {
		List<Integer> satVerbal = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getVerbalSAT() != -1) {
				satVerbal.add(listUnis.get(j).getVerbalSAT());
			}
		}
		Collections.sort(satVerbal);
		int maxSATVerbal = satVerbal.get(satVerbal.size() - 1); //Subtracts 1 to ensure that the 
		return maxSATVerbal;									//index of the array is realigned										 
	}
	
	public int minSATVerbal() {
		List<Integer> satVerbal = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getVerbalSAT() != -1) {
				satVerbal.add(listUnis.get(j).getVerbalSAT());
			}
		}
		Collections.sort(satVerbal);
		int minSATVerbal = satVerbal.get(0); 					
		return minSATVerbal;																		 
	}
	
	public int maxSATMath() {
		List<Integer> satMath = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getMathSAT() != -1) {
				satMath.add(listUnis.get(j).getMathSAT());
			}
		}
		Collections.sort(satMath);
		int maxSATMath = satMath.get(satMath.size() - 1); //Subtracts 1 to ensure that the 
		return maxSATMath;									//index of the array is realigned										 
	}
	
	public int minSATMath() {arg0
		List<Integer> satMath = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getMathSAT() != -1) {
				satMath.add(listUnis.get(j).getMathSAT());
			}
		}
		Collections.sort(satMath);
		int minSATMath = satMath.get(0); 					
		return minSATMath;																		 
	}
	
	public int maxExpenses() {
		List<Integer> expenses = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSchoolExpenses() != -1) {
				expenses.add(listUnis.get(j).getSchoolExpenses());
			}
		}
		Collections.sort(expenses);
		int maxExpenses = expenses.get(expenses.size() - 1); //Subtracts 1 to ensure that the 
		return maxExpenses;									//index of the array is realigned										 
	}
	
	public int minExpenses() {
		List<Integer> expenses = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSchoolExpenses() != -1) {
				expenses.add(listUnis.get(j).getSchoolExpenses());
			}
		}
		Collections.sort(expenses);
		int minExpenses = expenses.get(0); 
		return minExpenses;																		 
	}
	
	public int maxFinancialAid() {
		List<Integer> aid = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFinancialAid() != -1) {
				aid.add(listUnis.get(j).getPercentFinancialAid());
			}
		}
		Collections.sort(aid);
		int maxAid = aid.get(aid.size() - 1); 			//Subtracts 1 to ensure that the 
		return maxAid;									//index of the array is realigned										 
	}
	
	public int minFinancialAid() {
		List<Integer> aid = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFinancialAid() != -1) {
				aid.add(listUnis.get(j).getPercentFinancialAid());
			}
		}
		Collections.sort(aid);
		int minAid = aid.get(0); 						
		return minAid;																			 
	}
	
	public int maxNumApplicants() {
		List<Integer> numApps = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumApplicants() != -1) {
				numApps.add(listUnis.get(j).getNumApplicants());
			}
		}
		Collections.sort(numApps);
		int maxApps = numApps.get(numApps.size() - 1);  //Subtracts 1 to ensure that the 
		return maxApps;									//index of the array is realigned										 
	}
	
	public int minNumApplicants() {
		List<Integer> numApps = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumApplicants() != -1) {
				numApps.add(listUnis.get(j).getNumApplicants());
			}
		}
		Collections.sort(numApps);
		int minApps = numApps.get(0); 					
		return minApps;																		 
	}
	
	public int maxPercentAdmitted() {
		List<Integer> percentAdmitted = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentAdmitted() != -1) {
				percentAdmitted .add(listUnis.get(j).getPercentAdmitted());
			}
		}
		Collections.sort(percentAdmitted );
		int maxAdmitted = percentAdmitted.get(percentAdmitted .size() - 1);  //Subtracts 1 to ensure that the 
		return maxAdmitted;									//index of the array is realigned										 
	}
	
	public int minPercentAdmitted() {
		List<Integer> percentAdmitted = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentAdmitted() != -1) {
				percentAdmitted .add(listUnis.get(j).getPercentAdmitted());
			}
		}
		Collections.sort(percentAdmitted );
		int minAdmitted = percentAdmitted.get(0);  //Subtracts 1 to ensure that the 
		return minAdmitted;									//index of the array is realigned										 
	}
	
	public int maxPercentEnrolled() {
		List<Integer> percentEnrolled = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentEnrolled() != -1) {
				percentEnrolled .add(listUnis.get(j).getPercentEnrolled());
			}
		}
		Collections.sort(percentEnrolled);
		int maxEnrolled = percentEnrolled.get(percentEnrolled .size() - 1);  //Subtracts 1 to ensure that the 
		return maxEnrolled;													 //index of the array is realigned										 
	}
	
	public int minPercentEnrolled() {
		List<Integer> percentEnrolled = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentEnrolled() != -1) {
				percentEnrolled .add(listUnis.get(j).getPercentEnrolled());
			}
		}
		Collections.sort(percentEnrolled);
		int maxEnrolled = percentEnrolled.get(0);  		 
		return maxEnrolled;																			 
	}
	
	public int maxAcademicScale() {
		List<Integer> academicScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getAcademicScale() != -1) {
				academicScale .add(listUnis.get(j).getAcademicScale());
			}
		}
		Collections.sort(academicScale);
		int maxAcademicScale = academicScale.get(academicScale .size() - 1); 		 //Subtracts 1 to ensure that the 
		return maxAcademicScale;													 //index of the array is realigned										 
	}
	
	public int minAcademicScale() {
		List<Integer> academicScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getAcademicScale() != -1) {
				academicScale .add(listUnis.get(j).getAcademicScale());
			}
		}
		Collections.sort(academicScale);
		int minAcademicScale = academicScale.get(0); 		 
		return minAcademicScale;													 										 
	}
	
	public int maxSocialScale() {
		List<Integer> socialScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSocialScale() != -1) {
				socialScale .add(listUnis.get(j).getSocialScale());
			}
		}
		Collections.sort(socialScale);
		int maxSocialScale = socialScale.get(socialScale .size() - 1); 		 //Subtracts 1 to ensure that the 
		return maxSocialScale;													 //index of the array is realigned										 
	}
	
	public int minSocialScale() {
		List<Integer> socialScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSocialScale() != -1) {
				socialScale .add(listUnis.get(j).getSocialScale());
			}
		}
		Collections.sort(socialScale);
		int minSocialScale = socialScale.get(0); 		  
		return minSocialScale;																					 
	}
	
	public int maxQualityOfLifeScale() {
		List<Integer> qualityScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getQualityScale() != -1) {
				qualityScale .add(listUnis.get(j).getQualityScale());
			}
		}
		Collections.sort(qualityScale);
		int maxQualityScale = qualityScale.get(qualityScale .size() - 1); 		 //Subtracts 1 to ensure that the 
		return maxQualityScale;													 //index of the array is realigned										 
	}
	
	public int minQualityOfLifeScale() {
		List<Integer> qualityScale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getQualityScale() != -1) {
				qualityScale .add(listUnis.get(j).getQualityScale());
			}
		}
		Collections.sort(qualityScale);
		int minQualityScale = qualityScale.get(0); 		 
		return minQualityScale;													 									 
	}

}