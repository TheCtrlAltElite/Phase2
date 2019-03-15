/**
 * 
 */
package UniversityFunctionalities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import CMCDatabase.DBController;
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
	private List<University> listUnis = database.loadUniversities();
	
	public UniversityController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 
	 * @param university
	 */
	public void addToList(University university) {
		
	}

	/**
	 * 
	 * @param university
	 */
	/**
	public int maxNumStudents() {
		List<Integer> listOfStudents = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumberStudents() != -1) {
				listOfStudents.add(listUnis.get(j).getNumberStudents());
			}
		}
		Collections.sort(listOfStudents);
		int maxStudents = listOfStudents.get(listOfStudents.size() - 1);	//Subtracts 1 to ensure that the 
		return maxStudents;													//index of the array is realigned
	}
	
	
	public int minNumStudents() {
		List<Integer> listOfStudents = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumberStudents() != -1) {
				listOfStudents.add(listUnis.get(j).getNumberStudents());
			}
		}
		Collections.sort(listOfStudents);
		int minStudents = listOfStudents.get(0);
		return minStudents;
	}
	
	public int maxFemale() {
		List<Integer> percentFemale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFemale() != -1) {
				percentFemale.add(listUnis.get(j).getPercentFemale());
			}
		}
		Collections.sort(percentFemale);
		int maxFemale = percentFemale.get(percentFemale.size() - 1); //Subtracts 1 to ensure that the 
		return maxFemale;											 //index of the array is realigned
	}
	
	public int minFemale() {
		List<Integer> percentFemale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFemale() != -1) {
				percentFemale.add(listUnis.get(j).getPercentFemale());
			}
		}
		Collections.sort(percentFemale);
		int minFemale = percentFemale.get(0);  
		return minFemale;											 
	}
	
	public int maxSATVerbal() {
		List<Integer> satVerbal = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getVerbalSAT() != -1) {
				satVerbal.add(listUnis.get(j).getVerbalSAT());
			}
		}
		Collections.sort(satVerbal);
		int maxSATVerbal = satVerbal.get(satVerbal.size() - 1); //Subtracts 1 to ensure that the 
		return maxSATVerbal;									//index of the array is realigned										 
	}
	
	public int minSATVerbal() {
		List<Integer> satVerbal = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getVerbalSAT() != -1) {
				satVerbal.add(listUnis.get(j).getVerbalSAT());
			}
		}
		Collections.sort(satVerbal);
		int minSATVerbal = satVerbal.get(0); 					
		return minSATVerbal;																		 
	}
	
	public int maxSATMath() {
		List<Integer> satMath = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getMathSAT() != -1) {
				satMath.add(listUnis.get(j).getMathSAT());
			}
		}
		Collections.sort(satMath);
		int maxSATMath = satMath.get(satMath.size() - 1); //Subtracts 1 to ensure that the 
		return maxSATMath;									//index of the array is realigned										 
	}
	
	public int minSATMath() {
		List<Integer> satMath = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getMathSAT() != -1) {
				satMath.add(listUnis.get(j).getMathSAT());
			}
		}
		Collections.sort(satMath);
		int minSATMath = satMath.get(0); 					
		return minSATMath;																		 
	}
	
	public int maxExpenses() {
		List<Integer> expenses = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSchoolExpenses() != -1) {
				expenses.add(listUnis.get(j).getSchoolExpenses());
			}
		}
		Collections.sort(expenses);
		int maxExpenses = expenses.get(expenses.size() - 1); //Subtracts 1 to ensure that the 
		return maxExpenses;									//index of the array is realigned										 
	}
	
	public int minExpenses() {
		List<Integer> expenses = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getSchoolExpenses() != -1) {
				expenses.add(listUnis.get(j).getSchoolExpenses());
			}
		}
		Collections.sort(expenses);
		int minExpenses = expenses.get(0); 
		return minExpenses;																		 
	}
	
	public int maxFinancialAid() {
		List<Integer> aid = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFinancialAid() != -1) {
				aid.add(listUnis.get(j).getPercentFinancialAid());
			}
		}
		Collections.sort(aid);
		int maxAid = aid.get(aid.size() - 1); 			//Subtracts 1 to ensure that the 
		return maxAid;									//index of the array is realigned										 
	}
	
	public int minFinancialAid() {
		List<Integer> aid = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getPercentFinancialAid() != -1) {
				aid.add(listUnis.get(j).getPercentFinancialAid());
			}
		}
		Collections.sort(aid);
		int minAid = aid.get(0); 						
		return minAid;																			 
	}
	
	public int maxNumApplicants() {
		List<Integer> numApps = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumApplicants() != -1) {
				numApps.add(listUnis.get(j).getNumApplicants());
			}
		}
		Collections.sort(numApps);
		int maxApps = numApps.get(numApps.size() - 1);  //Subtracts 1 to ensure that the 
		return maxApps;									//index of the array is realigned										 
	}
	
	public int minNumApplicants() {
		List<Integer> numApps = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.size(); j++) {
			if(listUnis.get(j).getNumApplicants() != -1) {
				numApps.add(listUnis.get(j).getNumApplicants());
			}
		}
		Collections.sort(numApps);
		int minApps = numApps.get(0); 					
		return minApps;																		 
	}
	*/
	
	public void compareUniversity(University university) {			     
		 
		

		/*
		List<Integer> satVerbal = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][6]) != -1) {
				satVerbal.add(Integer.parseInt(listUnis[j][6]));
			}
		}
		Collections.sort(satVerbal);
		int minSatVerbal = satVerbal.get(0);
		int maxSatVerbal = satVerbal.get(satVerbal.size() - 1); //Subtracts 1 to ensure that the 
															    //index of the array is realigned
		
		List<Integer> satMath = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][7]) != -1) {
				satMath.add(Integer.parseInt(listUnis[j][7]));
			}
		}
		Collections.sort(satMath);
		int minSatMath = satMath.get(0);
		int maxSatMath = satMath.get(satMath.size() - 1); //Subtracts 1 to ensure that the 
														  //index of the array is realigned
		
		List<Integer> expenses = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][8]) != -1) {
				expenses.add(Integer.parseInt(listUnis[j][8]));
			}
		}
		Collections.sort(expenses);
		int minExpenses = expenses.get(0);
		int maxExpenses = expenses.get(expenses.size() - 1); //Subtracts 1 to ensure that the 
															 //index of the array is realigned
		
		List<Integer> financialAid = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][9]) != -1) {
				financialAid.add(Integer.parseInt(listUnis[j][9]));
			}
		}
		Collections.sort(financialAid);
		int minAid = financialAid.get(0);
		int maxAid = financialAid.get(financialAid.size() - 1); //Subtracts 1 to ensure that the 
															    //index of the array is realigned
		
		List<Integer> applicants = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][10]) != -1) {
				applicants.add(Integer.parseInt(listUnis[j][10]));
			}
		}
		Collections.sort(applicants);
		int minApps = applicants.get(0);
		int maxApps = applicants.get(applicants.size() - 1); //Subtracts 1 to ensure that the 
															 //index of the array is realigned
		
		List<Integer> percentAdmitted = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][11]) != -1){
				percentAdmitted.add(Integer.parseInt(listUnis[j][11]));
			}
		}
		Collections.sort(percentAdmitted);
		int minAdmitted = percentAdmitted.get(0);
		int maxAdmitted = percentAdmitted.get(percentAdmitted.size() - 1); //Subtracts 1 to ensure that the 
															               //index of the array is realigned
		
		List<Integer> percentEnrolled = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][12]) != -1) {
				percentEnrolled.add(Integer.parseInt(listUnis[j][12]));
			}
		}
		Collections.sort(percentEnrolled);
		int minEnrolled = percentEnrolled.get(0);
		int maxEnrolled = percentEnrolled.get(percentEnrolled.size() - 1); //Subtracts 1 to ensure that the 
															               //index of the array is realigned
			*/	
		
		for (int i = 0; i < listUnis.size(); i++) {
			float score = 0;
			if(!university.getSchoolState().equals(listUnis.get(i).getSchoolState())) { 		//State
				score += 1;
			}
			
			/*
			//Location
			// Urban: 3, Suburban: 2, Small-city: 1 
			// If '-1', then increase score by 1.
			if(!university.getSchoolLocation().equals()) { 	
			}
			else if(university.getSchoolLocation().equals("-1")) { 	//When the university passed location is '-1'
				score += 1;											//awards 1 because data is insufficient
			}	
			*/
			
			if(!university.getSchoolControl().equals(listUnis[i][3])) { 	//Control
				score += 1;
			}
			if(university.getNumberStudents() != listUnis.get(i).getNumberStudents()) { //NumberOfStudents
				int students = (listUnis.get(i).getNumberStudents());					                    //int students is the numberOfStudents for listUnis[i][4]
				score += (Math.abs(university.getNumberStudents() - students)) / (database.maxNumStudents() - database.minNumStudents()); //
			}
			if(university.getPercentFemale() != listUnis.get(i).getPercentFemale()) {  //PercentFemale
				int percent = listUnis.get(i).getPercentFemale();						 //int percent is the PercentFemale for listUnis[i][5]
				score += (Math.abs(university.getPercentFemale() - percent)) / (database.maxFemale() - database.minFemale()); 
			}

			if(university.getVerbalSAT() != Integer.parseInt(listUnis[i][7])) {  //Verbal SAT Score
				int verbSat = Integer.parseInt(listUnis[i][7]);					 //int verbSat is the math SAT score for listUnis[i][7]
				score += (Math.abs(university.getVerbalSAT() - verbSat)) / (maxSatMath - minSatMath); 
			}
			if(university.getMathSAT() != Integer.parseInt(listUnis[i][7])) {  //Verbal SAT Score
				int mathSat = Integer.parseInt(listUnis[i][7]);					 //int verbMath is the math SAT score for listUnis[i][7]
				score += (Math.abs(university.getVerbalSAT() - mathSat)) / (maxSatMath - minSatMath); 
			}
			if(university.getSchoolExpenses() != Integer.parseInt(listUnis[i][8])) {  //Expenses
				int exp = Integer.parseInt(listUnis[i][8]);					      //int exp is the expenses for listUnis[i][8]
				score += (Math.abs(university.getVerbalSAT() - exp)) / (maxExpenses - minExpenses); 
			}
			if(university.getPercentFinancialAid() != Integer.parseInt(listUnis[i][9])) {  //Percent Financial Aid
				int aid = Integer.parseInt(listUnis[i][9]);					      //int aid is the percent financial aid for listUnis[i][9]
				score += (Math.abs(university.getVerbalSAT() - aid)) / (maxAid - minAid); 
			}
			if(university.getNumApplicants() != Integer.parseInt(listUnis[i][10])) {  //Number Of applicants
				int numApplicants = Integer.parseInt(listUnis[i][10]);			           //int numApplicants is the number of applicants for listUnis[i][10]
				score += (Math.abs(university.getVerbalSAT() - numApplicants)) / (maxApps - minApps); 
			}
		}
		
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
	public Collection getDetailsUni() {
		return null;
	}
	
	/**
	 * 
	 * @param search
	 */
	public void addUniversity(SearchCriteria search) {
		
	}
}
