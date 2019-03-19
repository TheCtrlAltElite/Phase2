package AdminFunctionalities;

import java.util.*;
import CMCDatabase.*;
import UniversityFunctionalities.*;
import UserFunctionalities.*;

/**
 * @author Ctrl Alt Elite
 */
public class AdminFunctionalityController {

	private DBController database;
	private UniversityController uniController;
	
	public AdminFunctionalityController() {
		// TODO Auto-generated constructor stub
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
	 */
	public void viewUniversities() {
		database.loadUniversities();
	}
	
	/**
	 * Adds a new university to the database.
	 */
	public void addUniversity() {
		uniController.addUniversityInfo();
	}
	
	/**
	 * Edits the info stored for a university
	 */
	public void editUniversity() {
		uniController.editUniversity();;
	}
	
	/**
	 * Retrieves user info from database 
	 */
	public List<User> viewUsers() {
		return database.loadUsers();
	}
	
	/**
	 * Adds a user to the database
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
		System.out.println("Please enter type:.");
		char type = sc.next().charAt(0); 
		dbc.addUser(firstName, lastName, username, password, type);
		sc.close();
	}
	
	/**
	 * Removes university from the database
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
