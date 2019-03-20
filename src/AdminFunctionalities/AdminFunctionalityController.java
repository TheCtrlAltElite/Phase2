package AdminFunctionalities;

//imports
import java.util.*;
import CMCDatabase.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;
import other.*;

/**
 * @author Ctrl Alt Elite
 */
public class AdminFunctionalityController {

	//instance variables
	private DBController database;
	private UniversityController uniController;
//	private Account acc;
	
	//constructor
	public AdminFunctionalityController() {
	database = new DBController();
	}
	
//	/**
//	 * Sets the status for an account
//	 */
//	public void setStatus() {
//		//TODO
//	}
//	
//	/**
//	 *  Sets Type for an account
//	 */
//	public void setType() {
//		//TODO
//	}
	
	/**
	 * adds a university to a User's saves schools list
	 */

	public void addToSavedSchoolsList3(){
		DBController dbc = new DBController();
		Scanner scan = new Scanner(System.in);
    	System.out.println("Enter username to add University to: \n");
    	String userToFind = scan.nextLine();
    	
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
		   		scan.close();
    		}
   			i++;    			
   		}
    	
   		if(e) {
   			UniversityController unc = new UniversityController();
   			unc.addToSavedSchoolsList2(userToFind);
    	}		
	}
	
	
	
	
	
	/**
	 * Retrieves universities from database
	 * by calling loadUniversities() in DBController
	 */
	public void viewUniversities() {
		database.viewAllUnis();
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
		uniController.editUniversity();;
	}
	
	/**
	 * Retrieves user info from database 
	 * by calling loadUsers() on a DBController object and returning it
	 * @return List of Users
	 */
	public void viewUsers() {
		database.viewAllUsers();
	}
	
	/**
	 * Adds a user to the database
	 * by getting the information from the user
	 */
	public void addUser() {
		DBController dbc = new DBController();

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
		dbc.addUser(firstName, lastName, username, password, type);
//		Account acc = new Account(username, firstName, lastName,  password,  type, 'Y');
		sc.close();
	}
	
	/**
	 * Removes university from the database
	 * by making sure the University is not in the 
	 * saved schools list of any users
	 * then calls removeUniversity() in DBController
	 */
	public void removeUniversityDB(String schoolName) {
		List<User> users = database.loadUsers();
		List<University> unis;		
		for (int i = 0; i < users.size(); i++) {
			unis = users.get(i).getSavedSchoolsList();
			if(unis.contains(unis.get(i))) {
				System.out.println("This School Cannot be Removed");
				break;
			}
		}
		database.removeUniversityDB(schoolName);
	}
}
