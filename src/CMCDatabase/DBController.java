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
	public Collection<String> getDetailsUni(String school) {
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
		for(int i = 0; i <= arrayUnis.length; i++) {
			schoolName = arrayUnis[i][0];
			System.out.println(schoolName);
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
	 * Pulls user information from database, creates a user object, and adds the object to a list that is returned. 
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
	
	public int minSATMath() {
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