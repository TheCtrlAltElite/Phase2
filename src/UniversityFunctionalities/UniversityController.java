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

	
	
	public void compareUniversity(University university) {			     
		 
		

		
		
		for (int i = 0; i < listUnis.size(); i++) {
			float score = 0;
			if(!university.getSchoolState().equals(listUnis.get(i).getSchoolState())) { 		//State
				score += 1;
			}
			
			
			//Location
			// Urban: 3, Suburban: 2, Small-city: 1 
			// If '-1', then increase score by 1.
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
