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
	public void compareUniversity(University university) {
		List<University> listUnis = database.loadUniversities();
		
		List<Integer> listOfStudents = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][4]) != -1) {
				listOfStudents.add(Integer.parseInt(listUnis[j][4]));
			}
		}
		Collections.sort(listOfStudents);
		int minStudents = listOfStudents.get(0);
		int maxStudents = listOfStudents.get(listOfStudents.size() - 1); //Subtracts 1 to ensure that the 
																		 //index of the array is realigned
		 
		
		List<Integer> percentFemale = new ArrayList<Integer>();
		for (int j = 0; j < listUnis.length; j++) {
			if(Integer.parseInt(listUnis[j][5]) != -1) {
				percentFemale.add(Integer.parseInt(listUnis[j][5]));
			}
		}
		Collections.sort(percentFemale);
		int minFemale = percentFemale.get(0);
		int maxFemale = percentFemale.get(percentFemale.size() - 1); //Subtracts 1 to ensure that the 
																	 //index of the array is realigned
		
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
				
		
		for (int i = 0; i < listUnis.length; i++) {
			float score = 0;
			if(!university.getSchoolState().equals(listUnis[i][1])) { 		//State
				score += 1;
			}
			//Location
			// Urban: 3, Suburban: 2, Small-city: 1 
			// If '-1', then increase score by 1.
			if(!university.getSchoolLocation().equals(listUnis[i][2])) { 	
				if(university.getSchoolLocation().equals("SUBURBAN") && listUnis[i][2].equals("SMALL-CITY")) {
					score += (2-1)/(3-1); // (suburban - smallcity)/(max - min)
				}
				else if(university.getSchoolLocation().equals("SUBURBAN") && listUnis[i][2].equals("URBAN")) {
					score += (3-2)/(3-1);
				}
				else if(university.getSchoolLocation().equals("SMALL-CITY") && listUnis[i][2].equals("SUBURBAN")) {
					score += (2-1)/(3-1);   
				}
				else if(university.getSchoolLocation().equals("SMALL-CITY") && listUnis[i][2].equals("URBAN")) {
					score += (3-1)/(3-1);   
				}
				else if(university.getSchoolLocation().equals("URBAN") && listUnis[i][2].equals("SUBURBAN")) {
					score += (3-2)/(3-1);  
				}
				else if(university.getSchoolLocation().equals("URBAN") && listUnis[i][2].equals("SMALL-CITY")) {
					score += (3-1)/(3-1);  
				}
				else if(listUnis[i][2].equals("-1")) {
					score += 1;	//Max score of 1 because school has incomplete information '-1'
				}
			}
			else if(university.getSchoolLocation().equals("-1")) { 	//When the university passed location is '-1'
				score += 1;											//awards 1 because data is insufficient
			}														
			if(!university.getSchoolControl().equals(listUnis[i][3])) { 	//Control
				score += 1;
			}
			if(university.getNumberStudents() != Integer.parseInt(listUnis[i][4])) { //NumberOfStudents
				int students = Integer.parseInt(listUnis[i][4]);					 //int students is the numberOfStudents for listUnis[i][4]
				score += (Math.abs(university.getNumberStudents() - students)) / (maxStudents - minStudents); //
			}
			if(university.getPercentFemale() != Integer.parseInt(listUnis[i][5])) {  //PercentFemale
				int percent = Integer.parseInt(listUnis[i][5]);						 //int percent is the PercentFemale for listUnis[i][5]
				score += (Math.abs(university.getPercentFemale() - percent)) / (maxFemale - minFemale); 
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
			if(university.getNumberOfApplicants() != Integer.parseInt(listUnis[i][10])) {  //Number Of applicants
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
