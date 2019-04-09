package AdminFunctionalities;

import java.util.List;
import java.util.Scanner;
import CMCDatabase.DBController;
import UniversityFunctionalities.University;
import UniversityFunctionalities.UniversityController;

/**
 * 
 * @authorCtrlAltElite
 * 
 */

public class AdminInteraction {

	// instance variable
	private AdminFunctionalityController adminFController;
	private DBController dbController;
	private UniversityController uc;

	// constructor
	public AdminInteraction() {
		adminFController = new AdminFunctionalityController();
		dbController = new DBController();
		uc = new UniversityController();
	}

	public void addToSavedSchoolsList4() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter username to add a school to their saved school list");
		String username = sc.nextLine();
		System.out.println("Enter school to add to " + username + "'s saved school list.");
		String schoolName = sc.nextLine();
		sc.close();
		adminFController.addToSavedSchoolsList3(username, schoolName);
	}



	/**
	 * Adds a new university to the database by calling addUniversity() in
	 * AdminFunctionalityController
	 */
	public boolean addUniversity() {
		//adminFController.addUniversity();
		DBController dbc = new DBController();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter school name to be added or 'q' to quit");
		String schoolName = sc.nextLine();

		boolean success = false;

		int i = 0;
		// searches through list of universities retrieved through loadUniversities()
		while (i < dbc.loadUniversities().size()) {

			String name = dbc.loadUniversities().get(i).getSchoolName();

			// confirms that the uniToFind exists
			if (name.toUpperCase().equals(schoolName.toUpperCase())) {
				// e= true;
				System.out.println(schoolName + " exists, choose a different name.");
				sc.close();
				
				addUniversity();

			}

			else if(schoolName.equals("q")) {
				sc.close();
				break;
			}

			else {
				
			System.out.println("Enter School State: \n");
			String schoolState = sc.nextLine();
			System.out.println("Enter School Location: \n");
			String schoolLocation = sc.nextLine();
			System.out.println("Enter School Control: \n");
			String schoolControl = sc.nextLine();
			System.out.println("Enter Number of Students: \\n");
			int numberStudents = sc.nextInt();
			System.out.println("Enter Percent Female Students: \n");
			int percentFemale = sc.nextInt();
			System.out.println("Enter Average Verbal SAT Score: \n");
			int verbalSAT = sc.nextInt();
			System.out.println("Enter Average Math SAT Score: \n");
			int mathSAT = sc.nextInt();
			System.out.println("Enter School Cost: \n");
			int schoolExpenses = sc.nextInt();
			System.out.println("Enter Percent of Students Receiving Financial Aid: \n");
			int percentFinancialAid = sc.nextInt();
			System.out.println("Enter Number of Applicants: \n");
			int numApplicants = sc.nextInt();
			System.out.println("Enter Percent of Students Admitted: \n");
			int percentAdmitted = sc.nextInt();
			System.out.println("Enter Percent of Students Enrolled: \n");
			int percentEnrolled = sc.nextInt();
			System.out.println("Enter Academic Scale Rating (1-5): \n");
			int academicScale = sc.nextInt();
			System.out.println("Enter Social Scale Rating (1-5): \n");
			int socialScale = sc.nextInt();
			System.out.println("Enter Quality Scale Rating (1-5): \n");
			int qualityScale = sc.nextInt();
			// List<String> emphasis = sc.nextLine();
			sc.close();

			adminFController.addUniversity(schoolName, schoolState, schoolLocation, schoolControl, numberStudents,
					percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants,
					percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
			success = true;
			break;
			}
		}
		return success;
	}



	/**
	 * Removes a stored university from the database by calling
	 * removeUniversityDB(String) in AdminFunctionalityController
	 * 
	 * @param schoolName
	 */
	public void removeUniversityDB() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter school to be removed: \n");
		String schoolName = scan.nextLine();
		adminFController.removeUniversityDB(schoolName);
		scan.close();
	}
	
	
	
	// /**
	// * Updates the status of users in database
	// * @param status
	// */
	// public void updateStatus(String status) {
	// //TODO
	// }
	//
	// /**
	// * Updates type of user in database
	// * @param Type
	// */
	// public void updateType(String Type) {
	// //TODO
	// }

	
	
	/**
	 * Adds a new user to the database by calling addUser() in
	 * AdminFunctionalityController
	 */
	public void addUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter first name: \n");
		String firstName = sc.nextLine();
		System.out.println("Please enter last name: \n");
		String lastName = sc.nextLine();
		System.out.println("Please enter email/username: \n");
		String username = sc.nextLine();
		System.out.println("Please enter password: \n");
		String password = sc.nextLine();
		System.out.println("Please enter type: \n");
		char type = sc.next().charAt(0); 
		sc.close();
		adminFController.addUser(firstName, lastName, username, password, type);
	}

	public boolean editUniversity() {

		List<University> uniList = dbController.loadUniversities();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter school to be edited: \n");
		String nameToFind = scan.nextLine().toUpperCase();
		int i = 0;
		boolean e = false;

		while (i < uniList.size()) {

			String name = uniList.get(i).getSchoolName().toUpperCase();
			
			if (name.equals(nameToFind)) {
				e = true;
				System.out.println("YES, " + nameToFind + " exists.\n ");
				break;
			}

			if (i == (uniList.size()) - 1) {
				System.out.print(nameToFind + " does NOT exist.\n ");
				System.out.print(uniList.get(i).getSchoolName());
			}
			i++;
		}
		if (e) {
			System.out.println("Enter state: \n");
			String editstate = scan.nextLine();
			System.out.println("Enter location: \n");
			String editlocation = scan.nextLine();
			System.out.println("Enter control: ");
			String editcontrol = scan.nextLine();
			System.out.println("Enter number of students: \n");
			int editnumberOfStudents = scan.nextInt();
			System.out.println("Enter percent females: \n");
			double editpercentFemales = scan.nextDouble();
			System.out.println("Enter SATVerbal: \n");
			double editSATVerbal = scan.nextDouble();
			System.out.println("Enter SATMath: \n");
			double editSATMath = scan.nextDouble();
			System.out.println("Enter expenses: \n");
			double editexpenses = scan.nextDouble();
			System.out.println("Enter percent Financal Aid: \n");
			double editpercentFinancialAid = scan.nextDouble();
			System.out.println("Enter number of applicants: \n");
			int editnumberOfApplicants = scan.nextInt();
			System.out.println("Enter percent admitted: \n");
			double editpercentAdmitted = scan.nextDouble();
			System.out.println("Enter percent enrolled: \n");
			double editpercentEnrolled = scan.nextDouble();
			System.out.println("Enter academics scale: \n");
			int editacademicsScale = scan.nextInt();
			System.out.println("Enter social scale: \n");
			int editsocialScale = scan.nextInt();
			System.out.println("Enter quality of life: \n");
			int editqualityOfLifeScale = scan.nextInt();

			uc.editUniversity(nameToFind, editstate, editlocation, editcontrol, editnumberOfStudents,
					editpercentFemales, editSATVerbal, editSATMath, editexpenses, editpercentFinancialAid,
					editnumberOfApplicants, editpercentAdmitted, editpercentEnrolled, editacademicsScale,
					editsocialScale, editqualityOfLifeScale);
		}
		scan.close();
		return e;
	}
	
	
	
	/**
	 * shows the admin the list of universities by calling viewUniversities() in the
	 * AdminFunctionalityController
	 */
	public void viewUniversities() {
		adminFController.viewUniversities();
	}

	

	/**
	 * Displays all users and their information in the database by calling
	 * viewUsers() in AdminFunctionalityController
	 */
	public void viewUsers() {
		adminFController.viewUsers();
	}
}
