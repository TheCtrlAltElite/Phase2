package AdminFunctionalities;

//imports
import java.util.*;
import AccountFunctionalities.Account;
import CMCDatabase.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;

/**
 * @author CtrlAltElite
 */
public class AdminFunctionalityController {

	//instance variables
	private DBController database;
	private UniversityController uniController;
	private UserFunctionalityController ufc;
	
	//constructor
	public AdminFunctionalityController() {
		
	database = new DBController();
	uniController = new UniversityController();
	ufc = new UserFunctionalityController();
	}
	
	
	
	/**
	 * adds a university to a User's saves schools list
	 */
	public boolean addToSavedSchoolsList3(String username, String schoolName){
		
		DBController dbc = new DBController();
    	String userToFind = username;
    	
    	int i = 0;  		
    	boolean e = false;
    	outerloop:
    		
    	while(i<dbc.loadUsers().size()) {
    		String name = dbc.loadUsers().get(i).getEmail().toUpperCase();
   			
    		if (name.equals(userToFind.toUpperCase())){
   				e= true;
   				System.out.println("YES, " + userToFind + " exists.");   			
   				break outerloop;
    		}
    			
    		if(i == (dbc.loadUsers().size())-1) {
		   		System.out.print(userToFind + " does NOT exist.");
    		}
    		
   			i++;    			
   		}
	
   		if(e) {
   			UniversityController unc = new UniversityController();
   			unc.addToSavedSchoolsList2(userToFind, schoolName);
    	}	
   		return e;
	}

	
	
	/**
	 * Adds a new university to the database.
	 * by calling addUniversityInfo() in UniversityController 
	 */
	public void addUniversity(String schoolName, String schoolState, String schoolLocation, String schoolControl, int numberStudents,
			int percentFemale, int verbalSAT, int mathSAT, int schoolExpenses, int percentFinancialAid, int numApplicants,
			int percentAdmitted, int percentEnrolled, int academicScale, int socialScale, int qualityScale) {
		
		uniController.addUniversityInfo(schoolName, schoolState, schoolLocation, schoolControl, numberStudents,
				percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants,
				percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
	}


	
	/**
	 * Adds a user to the database
	 * by getting the information from the user
	 */
	public boolean addUser(String firstName, String lastName, String username, String password, char type) {
		
		DBController dbc = new DBController();
		List<Account> users = dbc.loadUsers();

		boolean added = false;
		//this.database.checkPasswordRequirements(password);
		
		if((this.database.checkPasswordRequirements(password)== false)) {
			System.out.println("This username is taken or password does not meet requirements.");
			return added;
		}
		
		for (int i = 0; i < users.size(); i ++) {
			
			if(username.toUpperCase().equals(users.get(i).getEmail().toUpperCase()) ) {
				break;
			}
		
			
			else {
				dbc.addUser(firstName, lastName, username, password, type);
//				Account acc = new Account(username, firstName, lastName,  password,  type, 'Y');

				added = true;
			}
		}	
		if(!added) {
			System.out.println("This username is taken or password does not meet requirements.");
		}
	
		System.out.println("User was added: " + added);

		return added;
	}
	
	
	
	/**
	 * Removes university from the database
	 * by making sure the University is not in the 
	 * saved schools list of any users
	 * then calls removeUniversity() in DBController
	 */
	public boolean removeUniversityDB(String schoolName) {		
		int j = 0;  		
		boolean e = false;
		
		//searches through list of universities retrieved through loadUniversities() method
		while(j<database.loadUniversities().size()) {
			
			String name = database.loadUniversities().get(j).getSchoolName();
			
			//confirms that the uniToFind exists
			if (name.toUpperCase().equals(schoolName.toUpperCase())){
					e= true;
					System.out.println("YES, " + schoolName + " exists.");   			
					break;
			}
			
			//if the while loop reaches the end of the list, uniToFind does not exist
			if(j == (database.loadUniversities().size())-1) {
		   		System.out.println("School does not exist, did not remove school.");
				return e;
			}
				j++;    			
			}
		
		boolean success = true;
		//if uniToFind exists, 
			if(e) {
				
				List<Account> users = database.loadUsers();	
				
				
				for (int i = 0; i < users.size(); i++) {
					 Map<String, String> savedList = ufc.getSavedSchoolsList(users.get(i).getEmail());
					 
					 for (Map.Entry entry : savedList.entrySet()){
						 
						 if(schoolName.toUpperCase().equals(entry.getKey().toString().toUpperCase())) {
							 success = false;
							 System.out.println("School was removed: " + success);
							 break;
						 } 
					 }
				}
				
				if(success) {
					database.removeUniversityDB(schoolName);
					System.out.println("School was removed: " + success );
				}
				
		}
			return success;
		
	}
	
	
	
	/**
	 * Retrieves universities from database
	 * by calling loadUniversities() in DBController
	 */
	public List<University> viewUniversities() {
		List<University> listUnis = database.loadUniversities();
		for(int i = 0; i < listUnis.size(); i++) {
			System.out.println(listUnis.get(i).getSchoolName());
		}		
		return listUnis;
	}
	
	
	
	/**
	 * Retrieves user info from database 
	 * by calling loadUsers() on a DBController object and returning it
	 * @return List of Users
	 */
	public List<Account> viewUsers() {
		List<Account> listUsers = database.loadUsers();
		for(int i = 0; i < listUsers.size(); i++) {
			System.out.println(listUsers.get(i).getFirstName() + " " + listUsers.get(i).getLastName() + " " + listUsers.get(i).getEmail() + " " + listUsers.get(i).getStatus() + " " + listUsers.get(i).getType());
		}	
		return listUsers;
	}
	
}
