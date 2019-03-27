/**
 * 
 */
package UniversityFunctionalities;


import java.util.*;
import java.util.Map.Entry;

import CMCDatabase.DBController;
import UserFunctionalities.User;

/**
 * @author CtrlAltElite
 *
 * University Controller class
 */
public class UniversityController {

	/**
	 * Instance variables for University Controller
	 */
	private DBController database;
	private List<University> listUnis;
	private TreeMap<Float, University> scores;
	

	/**
	 * University Controller constructor creates DBController object
	 */
	public UniversityController() {
		database = new DBController();
	}
	

	/**
	 * Saves a University to the specified user's saved school
	 * @param user that school will be added to
	 */
	public void addToSavedSchoolsList2(String user) {
		DBController dbc = new DBController();
		Scanner scan2 = new Scanner(System.in);
    	System.out.println("Enter school to be added to " + user + "'s list: \n");
    	//asks for university that will be added to the user's saved school list
    	String uniToFind = scan2.nextLine().toUpperCase();
    	scan2.close();
    	
    	int i = 0;  		
    	boolean e = false;
    	
    	//searches through list of universities retrieved through loadUniversities() method
    	while(i<dbc.loadUniversities().size()) {
    		String name = dbc.loadUniversities().get(i).getSchoolName();
   			
    		//confirms that the uniToFind exists
    		if (name.equals(uniToFind)){
   				e= true;
   				System.out.println("YES, " + uniToFind + " exists.");   			
   				break;
    		}
    		
    		//if the while loop reaches the end of the list, uniToFind does not exist
    		if(i == (dbc.loadUniversities().size())-1) {
		   		System.out.print(uniToFind + " does NOT exist. \n");
	    		//System.out.print(dbc.loadUniversities().get(i).getSchoolName());   //prints last uni in list
    		}
   			i++;    			
   		}
    	
    	//if uniToFind exists, calls addToSavedSchoolsList1() from DBController 
   		if(e) {
   			//System.out.println("reached 2nd if");
   			dbc.addToSavedSchoolsList1(user, uniToFind);
    	}
	}
	
	
	
	
	/**
	 * Removes a University from the specified user's saved school list
	 * @param user that school will be removed from
	 * @param university that will be removed
	 */
	public void removeFromList(String user, String university) {
		database.removeFromSavedSchoolsList(user, university);
	}
	

	
	
	/**
	 * compares a University To the rest of the universities and returns map with the score between each
	 * @param university that will be used to compare to the rest of the universities
	 * @return map of score and university associated with that score
	 */
	public Map<Float, University> compareUniversity(University university) {	
		this.listUnis = database.loadUniversities();
		this.scores = new TreeMap<>();
		for (int i = 0; i < listUnis.size(); i++) {
			float score = 0;
			if(!university.getSchoolName().equals(listUnis.get(i).getSchoolName()))
			{
				if(!university.getSchoolState().equals(listUnis.get(i).getSchoolState())) { 		//State
					score += 1;
				}
				if(!university.getSchoolLocation().equals(listUnis.get(i).getSchoolLocation())) { 
					score += 1;
				}
				else if(university.getSchoolLocation().equals("-1")) { 	//When the university passed location is '-1'
					score += 1;											//awards 1 because data is insufficient
				}	
				if(!university.getSchoolControl().equals(listUnis.get(i).getSchoolControl())) { 	//Control
					score += 1;
				}
				else if(university.getSchoolControl().equals("-1")) { 	//When the university passed location is '-1'
					score += 1;											//awards 1 because data is insufficient
				}
				if(university.getNumberStudents() != listUnis.get(i).getNumberStudents()) { //NumberOfStudents
					float students = (Integer.valueOf(listUnis.get(i).getNumberStudents()).floatValue());					                    //int students is the numberOfStudents for listUnis.get(i)
					score += (Math.abs(Integer.valueOf(university.getNumberStudents()).floatValue() - students)) / (database.maxNumStudents() - database.minNumStudents()); //
	//				float temp = (Math.abs(university.getNumberStudents() - students)) / (database.maxNumStudents() - database.minNumStudents());
	//				System.out.println("num students: " + temp);
				}
				if(university.getPercentFemale() != listUnis.get(i).getPercentFemale()) {  //PercentFemale
					float percent = (Integer.valueOf(listUnis.get(i).getPercentFemale()).floatValue());						 //int percent is the PercentFemale for listUnis[i][5]
					score += (Math.abs(Integer.valueOf(university.getPercentFemale()).floatValue() - percent)) / (database.maxFemale() - database.minFemale()); 
				}
//JAKE START HERE
				if(university.getVerbalSAT() != listUnis.get(i).getVerbalSAT()) {  //Verbal SAT Score
					float verbSat = listUnis.get(i).getVerbalSAT();					 //int verbSat is the math SAT score for listUnis[i][7]
					score += (Math.abs(university.getVerbalSAT() - verbSat)) / (database.maxSATVerbal() - database.minSATVerbal()); 
				}
				if(university.getMathSAT() != listUnis.get(i).getMathSAT()) {  //Verbal SAT Score
					float mathSat = listUnis.get(i).getMathSAT();					 //int mathSAT is the math SAT score for listUnis[i][7]
					score += (Math.abs(university.getVerbalSAT() - mathSat)) / (database.maxSATMath() - database.minSATMath()); 
				}
				if(university.getSchoolExpenses() != listUnis.get(i).getSchoolExpenses()) {  //Expenses
					float exp = listUnis.get(i).getSchoolExpenses();					      //int exp is the expenses for listUnis[i][8]
					score += (Math.abs(university.getVerbalSAT() - exp)) / (database.maxExpenses() - database.minExpenses()); 
				}
				if(university.getPercentFinancialAid() != listUnis.get(i).getPercentFinancialAid()) {  //Percent Financial Aid
					float aid = listUnis.get(i).getPercentFinancialAid();					      //int aid is the percent financial aid for listUnis[i][9]
					score += (Math.abs(university.getVerbalSAT() - aid)) / (database.maxFinancialAid() - database.minFinancialAid()); 
				}
				if(university.getNumApplicants() != listUnis.get(i).getNumApplicants()) {  
					float numApplicants = listUnis.get(i).getNumApplicants();			           
					score += (Math.abs(university.getVerbalSAT() - numApplicants)) / (database.maxNumApplicants() - database.minNumApplicants()); 
				}
				if(university.getPercentAdmitted() != listUnis.get(i).getPercentAdmitted()) {  
					float percentAdmitted = listUnis.get(i).getPercentAdmitted();			           
					score += (Math.abs(university.getVerbalSAT() - percentAdmitted)) / (database.maxPercentAdmitted() - database.minPercentAdmitted()); 
				}
				if(university.getPercentEnrolled() != listUnis.get(i).getPercentEnrolled()) {  
					float percentEnrolled = listUnis.get(i).getPercentEnrolled();			           
					score += (Math.abs(university.getVerbalSAT() - percentEnrolled)) / (database.maxPercentEnrolled() - database.minPercentEnrolled()); 
				}
				if(university.getAcademicScale() != listUnis.get(i).getAcademicScale()) {  
					float academicScale = listUnis.get(i).getAcademicScale();			           
					score += (Math.abs(university.getVerbalSAT() - academicScale)) / (database.maxAcademicScale() - database.minAcademicScale()); 
				}
				if(university.getSocialScale() != listUnis.get(i).getSocialScale()) {  
					float socialScale = listUnis.get(i).getSocialScale();			           
					score += (Math.abs(university.getVerbalSAT() - socialScale)) / (database.maxSocialScale() - database.minSocialScale()); 
				}
				if(university.getQualityScale() != listUnis.get(i).getQualityScale()) {  
					float qualityScale = listUnis.get(i).getQualityScale();			           
					score += (Math.abs(university.getVerbalSAT() - qualityScale)) / (database.maxQualityOfLifeScale() - database.minQualityOfLifeScale()); 
				}
			scores.put(score, listUnis.get(i));
//			for(Entry<Float, University> entry : scores.entrySet()) {
//				System.out.println(entry.getKey() + " " + entry.getValue().getSchoolName());
//			}
			}		
		}
		return scores;
	}
	
	
	
	
	/**
	 * returns list of 5 recommended schools
	 * @param university that will be used to compare to the rest of the universities
	 * @return list of 5 recommendedSchools
	 */
	public List<University> recommendedSchools(University university) {
		compareUniversity(university);
		List<University> recommendedSchools = new ArrayList<University>();
			for(int i = 0; i < 5; i++) {
				float key = this.scores.firstKey();
				recommendedSchools.add(this.scores.get(key));
				this.scores.remove(key);
				System.out.println(recommendedSchools.get(i).getSchoolName());
		}
			
		return recommendedSchools;
	}
	
	
	
	
	
	/**
	 * edits a University by taking in information to be changed and calling updateUniversity() in DBController
	 */
	public void editUniversity() {
		
		DBController dbc = new DBController();
		
		List<University> uniList = dbc.loadUniversities();
		Scanner scan = new Scanner(System.in);
    	System.out.println("Enter school to be edited: \n");
    	String nameToFind = scan.nextLine().toUpperCase();
    	int i = 0;
    		
    	boolean e = false;
    	
    		while(i<uniList.size()) {
    			
    			String name = uniList.get(i).getSchoolName().toUpperCase();
    			if (name.equals(nameToFind)){
    				e= true;
       			System.out.println("YES, " + nameToFind + " exists.");   			
        		break;
    			}
    			
    			if(i == (uniList.size())-1) {
    		System.out.print(nameToFind + " does NOT exist.");
    		System.out.print(uniList.get(i).getSchoolName());
    	}
    			i++;		
    		}
    		if(e) {
    			
    			System.out.println("Enter state: \n");
    			String editstate = scan.nextLine();
    			System.out.println("Enter location: ");
    			String editlocation = scan.nextLine();
    			System.out.println("Enter control: ");
    			String editcontrol =scan.nextLine();
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
    			
    			dbc.updateUniversity(nameToFind, editstate, editlocation, editcontrol, editnumberOfStudents, editpercentFemales, editSATVerbal, editSATMath, editexpenses, editpercentFinancialAid, editnumberOfApplicants, editpercentAdmitted, editpercentEnrolled, editacademicsScale, editsocialScale, editqualityOfLifeScale);
    		}
    	scan.close();
    }
	
	
	
	
	
	/**
	 * adds a University by taking information and calling addUniversity() from DBController()
	 */
	public void addUniversityInfo() {
		
		DBController dbc = new DBController();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter School Name");
		String schoolName = sc.nextLine();
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
		//List<String> emphasis = sc.nextLine();
		University newUni = new University(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, 
										   percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, 
										   numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
		dbc.addUniversity(newUni);
		sc.close();
	}
	
	/**
	 * gets details of one University
	 * @return string of all details of a university
	 */
	public List<String> getDetailsUni(String schoolName) {
		List<String> details = new ArrayList<String>();
		List<University> universities = database.loadUniversities();
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
}
