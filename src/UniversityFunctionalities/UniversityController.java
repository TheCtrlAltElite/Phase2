/**
 * 
 */
package UniversityFunctionalities;

import java.util.*;
import java.util.Map.Entry;

import CMCDatabase.DBController;
import UserFunctionalities.User;
import UserFunctionalities.UserFunctionalityController;

/**
 * @author CtrlAltElite
 *
 * University Controller class
 */
public class UniversityController {

	/**
	 * Instance variables for University Controller
	 */
	private DBController dbc;
	private List<University> listUnis;
	private TreeMap<Float, University> scores;
	//private UserFunctionalityController ufc;
	

	/**
	 * University Controller constructor creates DBController object
	 */
	public UniversityController() {
		dbc = new DBController();
		//ufc = new UserFunctionalityController();
	}
	

	/**
	 * Saves a University to the specified user's saved schools list
	 * @param String user - user that school will be added to
	 * @param String schoolName - the name of the school that will be added to the user's Saved Schools List
	 */
	public int addToSavedSchoolsList2(String user, String schoolName) {	
		String uniToFind = schoolName.toUpperCase();
		Map<String, String> savedSchools = dbc.getSavedSchoolsList(user);
		int result2 = 3;
		int i = 0;  	
		int uniSize = dbc.loadUniversities().size();

		
		//searches through list of universities retrieved through loadUniversities() method
		while(i<dbc.loadUniversities().size()) {

			String name = dbc.loadUniversities().get(i).getSchoolName();

			//confirms that the uniToFind exists
			//if (name.toUpperCase().equals(uniToFind) && !savedSchools.containsKey(uniToFind)){
			if (name.toUpperCase().equals(uniToFind)){
				//e= true;
				result2 = 4;
				System.out.println("YES, " + uniToFind + " exists. \n");   			
				break;
			}

			//if the while loop reaches the end of the list, uniToFind does not exist
			if(i == uniSize-1) {
				result2 = 5;
				System.out.print(uniToFind + " does NOT exist. \n");
				break;
				
			}
			i++;    			
		}
		outerloop:
		//if uniToFind exists, calls addToSavedSchoolsList1() from DBController 
		if(result2 == 4) {

			Map<String, String> savedList = dbc.getSavedSchoolsList(user);

			for (Map.Entry entry : savedList.entrySet()){

				if(schoolName.toUpperCase().equals(entry.getKey().toString().toUpperCase())) {
					System.out.println("School is already in the list.");
					result2 = 6;
					break outerloop;
				} 
			}
			if(result2 == 4) {
				dbc.addToSavedSchoolsList1(user, uniToFind);
			}
		}
		//System.out.println(result2);
		return result2;
	}
	
	/**
	 * Removes a University from the specified user's saved school list
	 * @param user that school will be removed from
	 * @param university that will be removed
	 */
//	public boolean removeFromList(String user, String university) {
//		boolean e = false;
//		int numSchool = dbc.removeFromSavedSchoolsList(user, university);
//		if (numSchool == -1) {
//			return e;
//		}
//		else {
//			e = true;
//		}
//		return e;
//	}
	
	/**
	 * compares a University To the rest of the universities and returns a map with the score between each University
	 * @param university that will be used to compare to the rest of the universities
	 * @return map of score and university associated with that score
	 */
	public Map<Float, University> compareUniversity(University university) {	
		this.listUnis = dbc.loadUniversities();
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
					score += (Math.abs(Integer.valueOf(university.getNumberStudents()).floatValue() - students)) / (dbc.maxNumStudents() - dbc.minNumStudents()); //
					float temp = (Math.abs(Integer.valueOf(university.getNumberStudents()).floatValue() - students)) / (dbc.maxNumStudents() - dbc.minNumStudents());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "num students: " + temp);
				}
				if(university.getPercentFemale() == -1 || listUnis.get(i).getPercentFemale() == -1) {			//PercentFemale with -1 field
					score += 1;
				}
				else if(university.getPercentFemale() != listUnis.get(i).getPercentFemale()) {  //PercentFemale
					float percent = (Integer.valueOf(listUnis.get(i).getPercentFemale()).floatValue());						 //int percent is the PercentFemale for listUnis[i][5]
					score += (Math.abs(Integer.valueOf(university.getPercentFemale()).floatValue() - percent)) / (dbc.maxFemale() - dbc.minFemale()); 
					float temp = (Math.abs(Integer.valueOf(university.getPercentFemale()).floatValue() - percent)) / (dbc.maxFemale() - dbc.minFemale());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "percentfe: " + temp);
				}
				if(university.getVerbalSAT() == -1 || listUnis.get(i).getVerbalSAT() == -1) {		//VerbalSAT with -1 field
					score += 1;
				}
				else if(university.getVerbalSAT() != listUnis.get(i).getVerbalSAT()) {  //Verbal SAT Score
					float verbSat = (Integer.valueOf(listUnis.get(i).getVerbalSAT()).floatValue());					 //int verbSat is the math SAT score for listUnis[i][7]
					score += (Math.abs(Integer.valueOf(university.getVerbalSAT()).floatValue()  - verbSat)) / (dbc.maxSATVerbal() - dbc.minSATVerbal()); 
					float temp = (Math.abs(Integer.valueOf(university.getVerbalSAT()).floatValue() - verbSat)) / (dbc.maxSATVerbal() - dbc.minSATVerbal());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "verb sat: " + temp);
				}
				if(university.getMathSAT() == -1 || listUnis.get(i).getMathSAT() == -1) {		//MathSAT with -1 field
					score += 1;
				}
				else if(university.getMathSAT() != listUnis.get(i).getMathSAT()) {  //Math SAT Score
					float mathSat = (Integer.valueOf(listUnis.get(i).getMathSAT()).floatValue());					 //int mathSAT is the math SAT score for listUnis[i][7]
					score += (Math.abs(Integer.valueOf(university.getMathSAT()).floatValue() - mathSat)) / (dbc.maxSATMath() - dbc.minSATMath()); 
					float temp = (Math.abs(Integer.valueOf(university.getMathSAT()).floatValue() - mathSat)) / (dbc.maxSATMath() - dbc.minSATMath());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "math sat: " + temp);
				}
				if(university.getSchoolExpenses() == -1 || listUnis.get(i).getSchoolExpenses() == -1) {		//School Expenses with -1 field
					score += 1;
				}
				else if(university.getSchoolExpenses() != listUnis.get(i).getSchoolExpenses()) {  //Expenses
					float exp = (Integer.valueOf(listUnis.get(i).getSchoolExpenses()).floatValue());					      //int exp is the expenses for listUnis[i][8]
					score += (Math.abs(Integer.valueOf(university.getSchoolExpenses()).floatValue() - exp)) / (dbc.maxExpenses() - dbc.minExpenses());
					float temp = (Math.abs(Integer.valueOf(university.getSchoolExpenses()).floatValue() - exp)) / (dbc.maxExpenses() - dbc.minExpenses());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "school exp: " + temp);
				}
				if(university.getPercentFinancialAid() == -1 || listUnis.get(i).getPercentFinancialAid() == -1) {		//PercentFinancialAid with -1 field
					score += 1;
				}
				else if(university.getPercentFinancialAid() != listUnis.get(i).getPercentFinancialAid()) {  //Percent Financial Aid
					float aid = (Integer.valueOf(listUnis.get(i).getPercentFinancialAid()).floatValue());					      //int aid is the percent financial aid for listUnis[i][9]
					score += (Math.abs(Integer.valueOf(university.getPercentFinancialAid()).floatValue() - aid)) / (dbc.maxFinancialAid() - dbc.minFinancialAid()); 
					float temp = (Math.abs(Integer.valueOf(university.getPercentFinancialAid()).floatValue() - aid)) / (dbc.maxFinancialAid() - dbc.minFinancialAid());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "percent fin aid: " + temp);
				}
				if(university.getNumApplicants() == -1 || listUnis.get(i).getNumApplicants() == -1) {		//NumApplicants with -1 field
					score += 1;
				}
				else if(university.getNumApplicants() != listUnis.get(i).getNumApplicants()) {  
					float numApplicants = (Integer.valueOf(listUnis.get(i).getNumApplicants()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getNumApplicants()).floatValue() - numApplicants)) / (dbc.maxNumApplicants() - dbc.minNumApplicants());
					float temp = (Math.abs(Integer.valueOf(university.getNumApplicants()).floatValue() - numApplicants)) / (dbc.maxNumApplicants() - dbc.minNumApplicants());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "num applicants: " + temp);
				}
				if(university.getPercentAdmitted() == -1 || listUnis.get(i).getPercentAdmitted() == -1) {		//PercentAdmitted with -1 field
					score += 1;
				}
				else if(university.getPercentAdmitted() != listUnis.get(i).getPercentAdmitted()) {  
					float percentAdmitted = (Integer.valueOf(listUnis.get(i).getPercentAdmitted()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getPercentAdmitted()).floatValue() - percentAdmitted)) / (dbc.maxPercentAdmitted() - dbc.minPercentAdmitted()); 
					float temp = (Math.abs(Integer.valueOf(university.getPercentAdmitted()).floatValue() - percentAdmitted)) / (dbc.maxPercentAdmitted() - dbc.minPercentAdmitted());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "percent admitted: " + temp);
				}
				if(university.getPercentEnrolled() == -1 || listUnis.get(i).getPercentEnrolled() == -1) {		//PercentEnrolled with -1 field
					score += 1;
				}
				else if(university.getPercentEnrolled() != listUnis.get(i).getPercentEnrolled()) {  
					float percentEnrolled = (Integer.valueOf(listUnis.get(i).getPercentEnrolled()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getPercentEnrolled()).floatValue()  - percentEnrolled)) / (dbc.maxPercentEnrolled() - dbc.minPercentEnrolled());
					float temp = (Math.abs(Integer.valueOf(university.getPercentEnrolled()).floatValue() - percentEnrolled)) / (dbc.maxPercentEnrolled() - dbc.minPercentEnrolled());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "percent enrolled: " + temp);
				}
				if(university.getAcademicScale() == -1 || listUnis.get(i).getAcademicScale() == -1) {		//AcademicScale with -1 field
					score += 1;
				}
				else if(university.getAcademicScale() != listUnis.get(i).getAcademicScale()) {  
					float academicScale = (Integer.valueOf(listUnis.get(i).getAcademicScale()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getAcademicScale()).floatValue() - academicScale)) / (dbc.maxAcademicScale() - dbc.minAcademicScale()); 
					float temp = (Math.abs(Integer.valueOf(university.getAcademicScale()).floatValue() - academicScale)) / (dbc.maxAcademicScale() - dbc.minAcademicScale());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "academic scale: " + temp);
				}
				if(university.getSocialScale() == -1 || listUnis.get(i).getSocialScale() == -1) {		//SocialScale with -1 field
					score += 1;
				}
				else if(university.getSocialScale() != listUnis.get(i).getSocialScale()) {  			//SocialScale
					float socialScale = (Integer.valueOf(listUnis.get(i).getSocialScale()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getSocialScale()).floatValue() - socialScale)) / (dbc.maxSocialScale() - dbc.minSocialScale());
					float temp = (Math.abs(Integer.valueOf(university.getSocialScale()).floatValue() - socialScale)) / (dbc.maxSocialScale() - dbc.minSocialScale());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "social scale: " + temp);
				}
				if(university.getQualityScale() == -1 || listUnis.get(i).getQualityScale() == -1) {		//QualityScale with -1 field
					score += 1;
				}
				else if(university.getQualityScale() != listUnis.get(i).getQualityScale()) {  			//QualityScale
					float qualityScale = (Integer.valueOf(listUnis.get(i).getQualityScale()).floatValue());			           
					score += (Math.abs(Integer.valueOf(university.getQualityScale()).floatValue() - qualityScale)) / (dbc.maxQualityOfLifeScale() - dbc.minQualityOfLifeScale());
					float temp = (Math.abs(Integer.valueOf(university.getQualityScale()).floatValue() - qualityScale)) / (dbc.maxQualityOfLifeScale() - dbc.minQualityOfLifeScale());
//					System.out.println(listUnis.get(i).getSchoolName() + " " + "quality scale: " + temp);
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
	 * returns a list of 5 recommended schools
	 * @param University university - university that will be used to compare to the rest of the universities
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
	public boolean editUniversity(String nameToFind, String editState, String editLocation, String editControl, int editNumberOfStudents, double editPercentFemales, double editSATVerbal, double editSATMath, double editExpenses, double editPercentFinancialAid, int editNumberOfApplicants, double editPercentAdmitted, double editPercentEnrolled, int editAcademicsScale, int editSocialScale, int editQualityOfLifeScale) {
		boolean e = false;
		int num = dbc.updateUniversity(nameToFind, editState, editLocation, editControl, editNumberOfStudents, editPercentFemales, editSATVerbal, editSATMath, editExpenses, editPercentFinancialAid, editNumberOfApplicants, editPercentAdmitted, editPercentEnrolled, editAcademicsScale, editSocialScale, editQualityOfLifeScale);
		listUnis = dbc.loadUniversities();
		List<String> schools = new ArrayList<String>();
		for(int i = 0; i < listUnis.size(); i++) {
			schools.add(listUnis.get(i).getSchoolName());
		}
		if (num == -1 || !schools.contains(nameToFind)) {
        	return e;
        }
        else {
        	e = true;
        }
        return e;
	}
	
	/**
	 * adds a University by taking information and calling addUniversity() from DBController()
	 */
	public int addUniversityInfo(String schoolName, String schoolState, String schoolLocation, String schoolControl, int numberStudents,
			int percentFemale, int verbalSAT, int mathSAT, int schoolExpenses, int percentFinancialAid, int numApplicants,
			int percentAdmitted, int percentEnrolled, int academicScale, int socialScale, int qualityScale, List<String> emphases) {		


		int addUniNum = dbc.addUniversity(schoolName, schoolState, schoolLocation, schoolControl, numberStudents,
				percentFemale, verbalSAT, mathSAT, schoolExpenses, percentFinancialAid, numApplicants,
				percentAdmitted, percentEnrolled, academicScale, socialScale, qualityScale);
		if(addUniNum != -1) {
			int counter = 0;
			for (int i = 0; i < emphases.size(); i++) {
				int num = dbc.addUniversityEmphasis(schoolName, emphases.get(i));
				if (num != -1) {
					counter++;
				}
			}
			if(counter != emphases.size()) {
				return -2;
			}
			return 0;
		}
		else {
			return -1;
		}
    }
	
	/**
	 * gets details of a specific University
	 * @param String schoolName - name of the University to get details on.
	 * @return string of all details of a university
	 */
	public List<String> getDetailsUni(String schoolName) {
		List<String> details = new ArrayList<String>();
		List<University> universities = dbc.loadUniversities();
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
