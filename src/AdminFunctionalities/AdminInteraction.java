package AdminFunctionalities;

import java.util.List;
import java.util.Scanner;

import CMCDatabase.DBController;
import UniversityFunctionalities.University;
import UniversityFunctionalities.UniversityController;

//imports
//import java.util.*;

//import UserFunctionalities.*;

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
	}

	public void addToSavedSchoolsList4(String username, String schoolName) {
		adminFController.addToSavedSchoolsList3(username, schoolName);
	}

	/**
	 * shows the admin the list of universities by calling viewUniversities() in the
	 * AdminFunctionalityController
	 */
	public void viewUniversities() {
		adminFController.viewUniversities();
	}

	/**
	 * Adds a new university to the database by calling addUniversity() in
	 * AdminFunctionalityController
	 */
	public void addUniversity() {
		adminFController.addUniversity();
		DBController dbc = new DBController();

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter School Name");
		String schoolName = sc.nextLine();

		int i = 0;
		// searches through list of universities retrieved through loadUniversities()
		// method
		while (i < dbc.loadUniversities().size()) {

			String name = dbc.loadUniversities().get(i).getSchoolName();

			// confirms that the uniToFind exists
			if (name.toUpperCase().equals(schoolName)) {
				// e= true;
				System.out.println(schoolName + " exists, choose a different name.");
				break;
			}

			System.out.println("Enter School State");
			String schoolState = sc.nextLine();
			System.out.println("Enter School Location");
			String schoolLocation = sc.nextLine();
			System.out.println("Enter School Control");
			String schoolControl = sc.nextLine();
			System.out.println("Enter Number of Students");
			int numberStudents = sc.nextInt();
			System.out.println("Enter Percent Female Students");
			int percentFemale = sc.nextInt();
			System.out.println("Enter Average Verbal SAT Score");
			int verbalSAT = sc.nextInt();
			System.out.println("Enter Average Math SAT Score");
			int mathSAT = sc.nextInt();
			System.out.println("Enter School Cost");
			int schoolExpenses = sc.nextInt();
			System.out.println("Enter Percent of Students Receiving Financial Aid");
			int percentFinancialAid = sc.nextInt();
			System.out.println("Enter Number of Applicants");
			int numApplicants = sc.nextInt();
			System.out.println("Enter Percent of Students Admitted");
			int percentAdmitted = sc.nextInt();
			System.out.println("Enter Percent of Students Enrolled");
			int percentEnrolled = sc.nextInt();
			System.out.println("Enter Academic Scale Rating (1-5)");
			int academicScale = sc.nextInt();
			System.out.println("Enter Social Scale Rating (1-5)");
			int socialScale = sc.nextInt();
			System.out.println("Enter Quality Scale Rating (1-5)");
			int qualityScale = sc.nextInt();
			// List<String> emphasis = sc.nextLine();
			
			uc.addUniversityInfo(schoolName, schoolState, schoolLocation, schoolControl, numberStudents,
					percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants,
					percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
			sc.close();
		}
	}

	/**
	 * Displays all users and their information in the database by calling
	 * viewUsers() in AdminFunctionalityController
	 */
	public void viewUsers() {
		adminFController.viewUsers();
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
		adminFController.addUser();
	}

	/**
	 * Removes a stored university from the database by calling
	 * removeUniversityDB(String) in AdminFunctionalityController
	 * 
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		adminFController.removeUniversityDB(schoolName);
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
				System.out.println("YES, " + nameToFind + " exists.");
				break;
			}

			if (i == (uniList.size()) - 1) {
				System.out.print(nameToFind + " does NOT exist.");
				System.out.print(uniList.get(i).getSchoolName());
			}
			i++;
		}
		if (e) {

			System.out.println("Enter state: \n");
			String editstate = scan.nextLine();
			System.out.println("Enter location: ");
			String editlocation = scan.nextLine();
			System.out.println("Enter control: ");
			String editcontrol = scan.nextLine();
			System.out.println("Enter number of students: ");
			int editnumberOfStudents = scan.nextInt();
			System.out.println("Enter percent females: ");
			double editpercentFemales = scan.nextDouble();
			System.out.println("Enter SATVerbal: ");
			double editSATVerbal = scan.nextDouble();
			System.out.println("Enter SATMath: ");
			double editSATMath = scan.nextDouble();
			System.out.println("Enter expenses: ");
			double editexpenses = scan.nextDouble();
			System.out.println("Enter percent Financal Aid: ");
			double editpercentFinancialAid = scan.nextDouble();
			System.out.println("Enter number of applicants: ");
			int editnumberOfApplicants = scan.nextInt();
			System.out.println("Enter percent admitted: ");
			double editpercentAdmitted = scan.nextDouble();
			System.out.println("Enter percent enrolled: ");
			double editpercentEnrolled = scan.nextDouble();
			System.out.println("Enter academics scale: ");
			int editacademicsScale = scan.nextInt();
			System.out.println("Enter social scale: ");
			int editsocialScale = scan.nextInt();
			System.out.println("Enter quality of life: ");
			int editqualityOfLifeScale = scan.nextInt();

			uc.editUniversity(nameToFind, editstate, editlocation, editcontrol, editnumberOfStudents,
					editpercentFemales, editSATVerbal, editSATMath, editexpenses, editpercentFinancialAid,
					editnumberOfApplicants, editpercentAdmitted, editpercentEnrolled, editacademicsScale,
					editsocialScale, editqualityOfLifeScale);
		}
		scan.close();
		return e;
	}
}
