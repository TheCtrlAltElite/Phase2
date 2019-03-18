/**
 * 
 */
package UniversityFunctionalities;


import java.util.*;

import CMCDatabase.DBController;
import UserFunctionalities.User;
import other.*;

/**
 * @author lneuensch001
 *
 */
public class UniversityController {

	/**
	 * 
	 */
	private DBController database;
	private List<University> listUnis;
	private TreeMap<Float, University> scores;
	
	public UniversityController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param university
	 */
	public void addToList(User user, University university) {
		
		database.addToSavedSchoolsList(user.getEmail(), university.getSchoolName());
	}
	
	public void removeFromList(User user, University university) {
		
		database.removeFromSavedSchoolsList(user.getEmail(), university.getSchoolName());
	}
	

	
	
	public Map<Float, University> compareUniversity(University university) {	
		this.listUnis = database.loadUniversities();
		this.scores = new TreeMap<>();
		for (int i = 0; i < listUnis.size(); i++) {
			float score = 0;
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
				int students = (listUnis.get(i).getNumberStudents());					                    //int students is the numberOfStudents for listUnis[i][4]
				score += (Math.abs(university.getNumberStudents() - students)) / (database.maxNumStudents() - database.minNumStudents()); //
			}
			if(university.getPercentFemale() != listUnis.get(i).getPercentFemale()) {  //PercentFemale
				int percent = listUnis.get(i).getPercentFemale();						 //int percent is the PercentFemale for listUnis[i][5]
				score += (Math.abs(university.getPercentFemale() - percent)) / (database.maxFemale() - database.minFemale()); 
			}

			if(university.getVerbalSAT() != listUnis.get(i).getVerbalSAT()) {  //Verbal SAT Score
				int verbSat = listUnis.get(i).getVerbalSAT();					 //int verbSat is the math SAT score for listUnis[i][7]
				score += (Math.abs(university.getVerbalSAT() - verbSat)) / (database.maxSATVerbal() - database.minSATVerbal()); 
			}
			if(university.getMathSAT() != listUnis.get(i).getMathSAT()) {  //Verbal SAT Score
				int mathSat = listUnis.get(i).getMathSAT();					 //int verbMath is the math SAT score for listUnis[i][7]
				score += (Math.abs(university.getVerbalSAT() - mathSat)) / (database.maxSATMath() - database.minSATMath()); 
			}
			if(university.getSchoolExpenses() != listUnis.get(i).getSchoolExpenses()) {  //Expenses
				int exp = listUnis.get(i).getSchoolExpenses();					      //int exp is the expenses for listUnis[i][8]
				score += (Math.abs(university.getVerbalSAT() - exp)) / (database.maxExpenses() - database.minExpenses()); 
			}
			if(university.getPercentFinancialAid() != listUnis.get(i).getPercentFinancialAid()) {  //Percent Financial Aid
				int aid = listUnis.get(i).getPercentFinancialAid();					      //int aid is the percent financial aid for listUnis[i][9]
				score += (Math.abs(university.getVerbalSAT() - aid)) / (database.maxFinancialAid() - database.minFinancialAid()); 
			}
			if(university.getNumApplicants() != listUnis.get(i).getNumApplicants()) {  
				int numApplicants = listUnis.get(i).getNumApplicants();			           
				score += (Math.abs(university.getVerbalSAT() - numApplicants)) / (database.maxNumApplicants() - database.minNumApplicants()); 
			}
			if(university.getPercentAdmitted() != listUnis.get(i).getPercentAdmitted()) {  
				int percentAdmitted = listUnis.get(i).getPercentAdmitted();			           
				score += (Math.abs(university.getVerbalSAT() - percentAdmitted)) / (database.maxPercentAdmitted() - database.minPercentAdmitted()); 
			}
			if(university.getPercentEnrolled() != listUnis.get(i).getPercentEnrolled()) {  
				int percentEnrolled = listUnis.get(i).getPercentEnrolled();			           
				score += (Math.abs(university.getVerbalSAT() - percentEnrolled)) / (database.maxPercentEnrolled() - database.minPercentEnrolled()); 
			}
			if(university.getAcademicScale() != listUnis.get(i).getAcademicScale()) {  
				int academicScale = listUnis.get(i).getAcademicScale();			           
				score += (Math.abs(university.getVerbalSAT() - academicScale)) / (database.maxAcademicScale() - database.minAcademicScale()); 
			}
			if(university.getSocialScale() != listUnis.get(i).getSocialScale()) {  
				int socialScale = listUnis.get(i).getSocialScale();			           
				score += (Math.abs(university.getVerbalSAT() - socialScale)) / (database.maxSocialScale() - database.minSocialScale()); 
			}
			if(university.getQualityScale() != listUnis.get(i).getQualityScale()) {  
				int qualityScale = listUnis.get(i).getQualityScale();			           
				score += (Math.abs(university.getVerbalSAT() - qualityScale)) / (database.maxQualityOfLifeScale() - database.minQualityOfLifeScale()); 
			}
			scores.put(score, listUnis.get(i));
		}
		return scores;
	}
	
	public List<University> recommendedSchools(University university) {
		compareUniversity(university);
		List<University> recommendedSchools = new ArrayList<University>();
			for(int i = 0; i < 5; i++) {
				float key = this.scores.firstKey();
				recommendedSchools.add(this.scores.get(key));
				this.scores.remove(key);
		}
		return recommendedSchools;
	}
	
	/**
	 * 
	 */
	public void editUniversity() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getDetailsUni(University university) {
		
		List<String> details = new ArrayList<>();
		String schoolName = university.getSchoolName();
		details.add(schoolName);
		String schoolState = university.getSchoolState();
		details.add(schoolState);
		String schoolLocation = university.getSchoolLocation();
		details.add(schoolLocation);
		String schoolControl = university.getSchoolControl();
		details.add(schoolControl);
	    int numberStudents = university.getNumberStudents();
	    details.add(Integer.toString(numberStudents));
		int percentFemale = university.getPercentFemale();
		details.add(Integer.toString(percentFemale));
		int verbalSAT = university.getVerbalSAT();
		details.add(Integer.toString(verbalSAT));
		int mathSAT = university.getMathSAT();
		details.add(Integer.toString(mathSAT));
		int schoolExpenses = university.getSchoolExpenses();
		details.add(Integer.toString(schoolExpenses));
		int percentFinancialAid = university.getPercentFinancialAid();
		details.add(Integer.toString(percentFinancialAid));
		int numApplicants = university.getNumApplicants();
		details.add(Integer.toString(numApplicants));
		int percentAdmitted = university.getPercentAdmitted();
		details.add(Integer.toString(percentAdmitted));
		int percentEnrolled = university.getPercentEnrolled();
		details.add(Integer.toString(percentEnrolled));
		int academicScale = university.getAcademicScale();
		details.add(Integer.toString(academicScale));
		int socialScale = university.getSocialScale();
		details.add(Integer.toString(socialScale));
		int qualityScale = university.getQualityScale();
		details.add(Integer.toString(qualityScale));
				
	
		return details;
	}
	
	/**
	 * 
	 * @param search
	 */
	public void addUniversityInfo() {
		
		DBController dbc = new DBController();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter School Name");
		String schoolName = sc.nextLine();
		String schoolState = sc.nextLine();
	    String schoolLocation = sc.nextLine();
	    String schoolControl = sc.nextLine();
		int numberStudents = Integer.parseInt(sc.nextLine());
		int percentFemale = Integer.parseInt(sc.nextLine());
		int verbalSAT = Integer.parseInt(sc.nextLine());
		int mathSAT = Integer.parseInt(sc.nextLine());
		int schoolExpenses = Integer.parseInt(sc.nextLine());
		int percentFinancialAid = Integer.parseInt(sc.nextLine());
		int numApplicants = Integer.parseInt(sc.nextLine());
		int percentAdmitted = Integer.parseInt(sc.nextLine());
		int percentEnrolled = Integer.parseInt(sc.nextLine());
		int academicScale = Integer.parseInt(sc.nextLine());
		int socialScale = Integer.parseInt(sc.nextLine());
		int qualityScale = Integer.parseInt(sc.nextLine());
		//List<String> emphasis = sc.nextLine();
		University newUni = new University(schoolName, schoolState, schoolLocation, schoolControl, numberStudents, 
										   percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, 
										   numApplicants, percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
		dbc.addUniversity(newUni);
		
	}
}
