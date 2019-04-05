package AdminFunctionalities;

//imports
import java.util.*;
import CMCDatabase.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;
//import other.*;

/**
 * @author CtrlAltElite
 */
public class AdminFunctionalityController {

	//instance variables
	private DBController database;
	private UniversityController uniController;
	private UserFunctionalityController ufc;
//	private Account acc;
	
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
    	
    	while(i<dbc.loadUsers().size()) {
    		String name = dbc.loadUsers().get(i).getEmail().toUpperCase();
   			
    		if (name.equals(userToFind.toUpperCase())){
   				e= true;
   				System.out.println("YES, " + userToFind + " exists.");   			
   				break;
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
	 * Adds a new university to the database.
	 * by calling addUniversityInfo() in UniversityController 
	 */
	public void addUniversity() {
		uniController.addUniversityInfo();
	}
	
	/**
	 * Edits the info stored for a university
	 * by calling editUniversity() in UniversityController
	 */
	public void editUniversity() {
		uniController.editUniversity();
	}
	
	/**
	 * Retrieves user info from database 
	 * by calling loadUsers() on a DBController object and returning it
	 * @return List of Users
	 */
	public List<User> viewUsers() {
		List<User> listUsers = database.loadUsers();
		for(int i = 0; i < listUsers.size(); i++) {
			System.out.println(listUsers.get(i).getFirstName() + " " + listUsers.get(i).getLastName() + " " + listUsers.get(i).getEmail() + " " + listUsers.get(i).getStatus() + " " + listUsers.get(i).getType());
		}	
		return listUsers;
	}
	
	/**
	 * Adds a user to the database
	 * by getting the information from the user
	 */
	public void addUser() {
		DBController dbc = new DBController();
		List<User> users = dbc.loadUsers();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter first name: ");
		String firstName = sc.nextLine();
		System.out.println("Please enter last name: ");
		String lastName = sc.nextLine();
		System.out.println("Please enter email/username: ");
		String username = sc.nextLine();
		System.out.println("Please enter password: ");
		String password = sc.nextLine();
		
		System.out.println("Please enter type: ");
		char type = sc.next().charAt(0); 
		boolean o = true;
		//this.database.checkPasswordRequirements(password);
		for (int i = 0; i < users.size(); i ++) {
			if(username.equals(users.get(i).getEmail()) || (this.database.checkPasswordRequirements(password)== false)) {//FINAL PRODUCT WILL NOT HAVE PRINT STATEMENT
				System.out.println("This username is taken or password does not meet requirements.");	
				break;
			}
			else {
				dbc.addUser(firstName, lastName, username, password, type);
			}
		}		
//		Account acc = new Account(username, firstName, lastName,  password,  type, 'Y');
		sc.close();
	}
	
	/**
	 * Removes university from the database
	 * by making sure the University is not in the 
	 * saved schools list of any users
	 * then calls removeUniversity() in DBController
	 */
	public boolean removeUniversityDB(String schoolName) {
		List<User> users = database.loadUsers();	
		boolean success = true;
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
		return success;
	}
	
}
