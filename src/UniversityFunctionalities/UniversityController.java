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
	public boolean addToSavedSchoolsList2(String user, String schoolName) {
		
		DBController dbc = new DBController();		
		String uniToFind = schoolName.toUpperCase(); 
    	int i = 0;  		
    	boolean e = false;
    	
    	//searches through list of universities retrieved through loadUniversities() method
    	while(i<dbc.loadUniversities().size()) {
    		
    		String name = dbc.loadUniversities().get(i).getSchoolName();
    		
    		//confirms that the uniToFind exists
    		if (name.toUpperCase().equals(uniToFind)){
   				e= true;
   				System.out.println("YES, " + uniToFind + " exists.");   			
   				break;
    		}
    		
    		//if the while loop reaches the end of the list, uniToFind does not exist
    		if(i == (dbc.loadUniversities().size())-1) {
		   		System.out.print(uniToFind + " does NOT exist. \n");
    		}
   			i++;    			
   		}
    	
    	//if uniToFind exists, calls addToSavedSchoolsList1() from DBController 
   		if(e) {
   			dbc.addToSavedSchoolsList1(user, uniToFind);
    	}
   		return e;
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
				if(university.getSchoolState().equals("-1") || listUnis.get(i).getSchoolState().equals("-1")) {		//Awards 1 if either school has "-1" in the field SchoolState
					score += 1;
				}
				else if(!university.getSchoolState().equals(listUnis.get(i).getSchoolState())) { 		//State
					score += 1;
				}
				if(university.getSchoolLocation().equals("-1") || listUnis.get(i).getSchoolLocation().equals("-1")) {
					score += 1;
				}
				else if(!university.getSchoolLocation().equals(listUnis.get(i).getSchoolLocation())) {	//Location
					score += 1;
				}
				if(university.getSchoolControl().equals("-1")|| listUnis.get(i).getSchoolControl().equals("-1")) {
					score += 1;
				}
				else if(!university.getSchoolControl().equals(listUnis.get(i).getSchoolControl())) { 	//Control
					score += 1;
				}
				if(university.getNumberStudents() == -1 || listUnis.get(i).getNumberStudents() == -1) {		//NumberOfStudents -1 field
					score += 1;
				}
				else if(university.getNumberStudents() != listUnis.get(i).getNumberStudents()) { //NumberOfStudents
					float students = (Integer.valueOf(listUnis.get(i).getNumberStudents()).floatValue());					                    //int students is the numberOfStudents for listUnis.get(i)
					score += (Math.abs(Integer.valueOf(university.getNumberStudents()).floatValue() - students)) / (database.maxNumStudents() - database.minNumStudents()); //
					float temp = (Math.abs(Integer.valueOf(university.getNumberStudents()).floatValue() - students)) / (database.maxNumStudents() - database.minNumStudents());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "num students: " + temp);
				}
				if(university.getPercentFemale() == -1 || listUnis.get(i).getPercentFemale() == -1) {			//PercentFemale with -1 field
					score += 1;
				}
				else if(university.getPercentFemale() != listUnis.get(i).getPercentFemale()) {  //PercentFemale
					float percent = (Integer.valueOf(listUnis.get(i).getPercentFemale()).floatValue());						 //int percent is the PercentFemale for listUnis[i][5]
					score += (Math.abs(Integer.valueOf(university.getPercentFemale()).floatValue() - percent)) / (database.maxFemale() - database.minFemale()); 
					float temp = (Math.abs(Integer.valueOf(university.getPercentFemale()).floatValue() - percent)) / (database.maxFemale() - database.minFemale());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "percentfe: " + temp);
				}
				if(university.getVerbalSAT() == -1 || listUnis.get(i).getVerbalSAT() == -1) {		//VerbalSAT with -1 field
					score += 1;
				}
				else if(university.getVerbalSAT() != listUnis.get(i).getVerbalSAT()) {  //Verbal SAT Score
					float verbSat = (Integer.valueOf(listUnis.get(i).getVerbalSAT()).floatValue());					 //int verbSat is the math SAT score for listUnis[i][7]
					score += (Math.abs(Integer.valueOf(university.getVerbalSAT()).floatValue()  - verbSat)) / (database.maxSATVerbal() - database.minSATVerbal()); 
					float temp = (Math.abs(Integer.valueOf(university.getVerbalSAT()).floatValue() - verbSat)) / (database.maxSATVerbal() - database.minSATVerbal());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "verb sat: " + temp);
				}
				if(university.getMathSAT() == -1 || listUnis.get(i).getMathSAT() == -1) {		//MathSAT with -1 field
					score += 1;
				}
				else if(university.getMathSAT() != listUnis.get(i).getMathSAT()) {  //Verbal SAT Score
					float mathSat = (Integer.valueOf(listUnis.get(i).getMathSAT()).floatValue());					 //int mathSAT is the math SAT score for listUnis[i][7]
					score += (Math.abs(Integer.valueOf(university.getMathSAT()).floatValue() - mathSat)) / (database.maxSATMath() - database.minSATMath()); 
					float temp = (Math.abs(Integer.valueOf(university.getMathSAT()).floatValue() - mathSat)) / (database.maxSATMath() - database.minSATMath());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "math sat: " + temp);
				}
				if(university.getSchoolExpenses() == -1 || listUnis.get(i).getSchoolExpenses() == -1) {		//School Expenses with -1 field
					score += 1;
				}
				else if(university.getSchoolExpenses() != listUnis.get(i).getSchoolExpenses()) {  //Expenses
					float exp = (Integer.valueOf(listUnis.get(i).getSchoolExpenses()).floatValue());					      //int exp is the expenses for listUnis[i][8]
					score += (Math.abs(Integer.valueOf(university.getSchoolExpenses()).floatValue() - exp)) / (database.maxExpenses() - database.minExpenses());
					float temp = (Math.abs(Integer.valueOf(university.getSchoolExpenses()).floatValue() - exp)) / (database.maxExpenses() - database.minExpenses());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "school exp: " + temp);
				}
				if(university.getPercentFinancialAid() == -1 || listUnis.get(i).getPercentFinancialAid() == -1) {		//PercentFinancialAid with -1 field
					score += 1;
				}
				else if(university.getPercentFinancialAid() != listUnis.get(i).getPercentFinancialAid()) {  //Percent Financial Aid
					float aid = (Integer.valueOf(listUnis.get(i).getPercentFinancialAid()).floatValue());					      //int aid is the percent financial aid for listUnis[i][9]
					score += (Math.abs(Integer.valueOf(university.getPercentFinancialAid()).floatValue() - aid)) / (database.maxFinancialAid() - database.minFinancialAid()); 
					float temp = (Math.abs(Integer.valueOf(university.getPercentFinancialAid()).floatValue() - aid)) / (database.maxFinancialAid() - database.minFinancialAid());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "percent fin aid: " + temp);
				}
				if(university.getNumApplicants() == -1 || listUnis.get(i).getNumApplicants() == -1) {		//NumApplicants with -1 field
					score += 1;
				}
				else if(university.getNumApplicants() != listUnis.get(i).getNumApplicants()) {  
					float numApplicants = (Integer.valueOf(listUnis.get(i).getNumApplicants()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getNumApplicants()).floatValue() - numApplicants)) / (database.maxNumApplicants() - database.minNumApplicants());
					float temp = (Math.abs(Integer.valueOf(university.getNumApplicants()).floatValue() - numApplicants)) / (database.maxNumApplicants() - database.minNumApplicants());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "num applicants: " + temp);
				}
				if(university.getPercentAdmitted() == -1 || listUnis.get(i).getPercentAdmitted() == -1) {		//PercentAdmitted with -1 field
					score += 1;
				}
				else if(university.getPercentAdmitted() != listUnis.get(i).getPercentAdmitted()) {  
					float percentAdmitted = (Integer.valueOf(listUnis.get(i).getPercentAdmitted()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getPercentAdmitted()).floatValue() - percentAdmitted)) / (database.maxPercentAdmitted() - database.minPercentAdmitted()); 
					float temp = (Math.abs(Integer.valueOf(university.getPercentAdmitted()).floatValue() - percentAdmitted)) / (database.maxPercentAdmitted() - database.minPercentAdmitted());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "percent admitted: " + temp);
				}
				if(university.getPercentEnrolled() == -1 || listUnis.get(i).getPercentEnrolled() == -1) {		//PercentEnrolled with -1 field
					score += 1;
				}
				else if(university.getPercentEnrolled() != listUnis.get(i).getPercentEnrolled()) {  
					float percentEnrolled = (Integer.valueOf(listUnis.get(i).getPercentEnrolled()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getPercentEnrolled()).floatValue()  - percentEnrolled)) / (database.maxPercentEnrolled() - database.minPercentEnrolled());
					float temp = (Math.abs(Integer.valueOf(university.getPercentEnrolled()).floatValue() - percentEnrolled)) / (database.maxPercentEnrolled() - database.minPercentEnrolled());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "percent enrolled: " + temp);
				}
				if(university.getAcademicScale() == -1 || listUnis.get(i).getAcademicScale() == -1) {		//AcademicScale with -1 field
					score += 1;
				}
				else if(university.getAcademicScale() != listUnis.get(i).getAcademicScale()) {  
					float academicScale = (Integer.valueOf(listUnis.get(i).getAcademicScale()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getAcademicScale()).floatValue() - academicScale)) / (database.maxAcademicScale() - database.minAcademicScale()); 
					float temp = (Math.abs(Integer.valueOf(university.getAcademicScale()).floatValue() - academicScale)) / (database.maxAcademicScale() - database.minAcademicScale());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "academic scale: " + temp);
				}
				if(university.getSocialScale() == -1 || listUnis.get(i).getSocialScale() == -1) {		//SocialScale with -1 field
					score += 1;
				}
				else if(university.getSocialScale() != listUnis.get(i).getSocialScale()) {  			//SocialScale
					float socialScale = (Integer.valueOf(listUnis.get(i).getSocialScale()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getSocialScale()).floatValue() - socialScale)) / (database.maxSocialScale() - database.minSocialScale());
					float temp = (Math.abs(Integer.valueOf(university.getSocialScale()).floatValue() - socialScale)) / (database.maxSocialScale() - database.minSocialScale());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "social scale: " + temp);
				}
				if(university.getQualityScale() == -1 || listUnis.get(i).getQualityScale() == -1) {		//QualityScale with -1 field
					score += 1;
				}
				else if(university.getQualityScale() != listUnis.get(i).getQualityScale()) {  			//QualityScale
					float qualityScale = (Integer.valueOf(listUnis.get(i).getQualityScale()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getQualityScale()).floatValue() - qualityScale)) / (database.maxQualityOfLifeScale() - database.minQualityOfLifeScale());
					float temp = (Math.abs(Integer.valueOf(university.getQualityScale()).floatValue() - qualityScale)) / (database.maxQualityOfLifeScale() - database.minQualityOfLifeScale());
					System.out.println(listUnis.get(i).getSchoolName() + " " + "quality scale: " + temp);
				}
			scores.put(score, listUnis.get(i));
//			for(Entry<Float, University> entry : scores.entrySet()) {
//				System.out.println(entry.getKey() + " " + entry.getValue().getSchoolName());
//		    }
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
		int y = 0;
		for(Entry<Float, University> entry : scores.entrySet()) {
			y++;
		   System.out.println(y + ": " + entry.getKey() + " " + entry.getValue().getSchoolName());	   
        }
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
		
		int i = 0;
		//searches through list of universities retrieved through loadUniversities() method
    	while(i<dbc.loadUniversities().size()) {
    		
    		String name = dbc.loadUniversities().get(i).getSchoolName();
    		
    		//confirms that the uniToFind exists
    		if (name.toUpperCase().equals(schoolName)){
   				//e= true;
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
		//List<String> emphasis = sc.nextLine();
		University newUni = new University(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, 
										   percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, 
										   numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
		dbc.addUniversity(newUni);
		sc.close();
    	}
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
