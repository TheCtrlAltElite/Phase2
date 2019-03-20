package UniversityFunctionalities;

import java.util.List;

/**
 * University Class
 * 
 * @author Ctrl Alt Elite
 *
 */
public class University {
	
	/**
	 * Instance Variables for the University class
	 */
	private String schoolName;
	private String schoolState;
	private String schoolLocation;
	private String schoolControl;
	private int numberStudents;
	private int percentFemale;
	private int verbalSAT;
	private int mathSAT;
	private int schoolExpenses;
	private int percentFinancialAid;
	private int numApplicants;
	private int percentAdmitted;
	private int percentEnrolled;
	private int academicScale;
	private int socialScale;
	private int qualityScale;
	private List<String> emphasis;																																				
	
	/**
	 * University Constructor that creates a University Object
	 * @param schoolName the name of the school
	 * @param schoolState the state if the school
	 * @param schoolControl the control of the school
	 * @param numberStudents the number of students in the school
	 * @param percentFemale the percent of females at the school
	 * @param verbalSAT the average verbalSAT of the school 
	 * @param mathSAT the average mathSAT of the school
	 * @param schoolExpenses the cost of the school
	 * @param percentFinancialAid the percent of students that receive financial aid
	 * @param numApplicants the number of students who applied to the school
	 * @param percentAdmitted the percent of students who applied that get accepted
	 * @param percentEnrolled the percent of students who applied that enrolled to the school
	 * @param academicScale the school's score in academics
	 * @param socialScale  the school's score in social
	 * @param qualityScale  the school's score in quality
	 */
	public University(String schoolName, String schoolState, String schoolLocation, String schoolControl, int numberStudents, int percentFemale, int verbalSAT, int mathSAT, int schoolExpenses, int percentFinancialAid, int numApplicants, int percentAdmitted, int percentEnrolled, int academicScale, int socialScale, int qualityScale) {
		this.schoolName = schoolName;
		this.schoolState = schoolState;
		this.schoolLocation = schoolLocation;
		this.schoolControl = schoolControl;
		this.numberStudents = numberStudents;
		this.percentFemale = percentFemale;
		this.verbalSAT = verbalSAT;
		this.mathSAT = mathSAT;
		this.schoolExpenses = schoolExpenses;
		this.percentFinancialAid = percentFinancialAid;
		this.numApplicants = numApplicants;
		this.percentAdmitted = percentAdmitted;
		this.percentEnrolled = percentEnrolled;
		this.academicScale = academicScale;
		this.socialScale = socialScale;
		this.qualityScale = qualityScale;
		this.emphasis = null;
	}


	/**
	 * A get method to get the university's name
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}


	/**
	 * A get method to get the university's State
	 * @return the schoolState
	 */
	public String getSchoolState() {
		return schoolState;
	}


	/**
	 *A get method to get the university's location
	 * @return the schoolLocation
	 */
	public String getSchoolLocation() {
		return schoolLocation;
	}


	/**
	 * A get method to get the university's control
	 * @return the schoolControl
	 */
	public String getSchoolControl() {
		return schoolControl;
	}


	/**
	 * A get method to get the university's number of students
	 * @return the numberStudents
	 */
	public int getNumberStudents() {
		return numberStudents;
	}


	/**
	 * A get method to get the university's percent of female's
	 * @return the percentFemale
	 */
	public int getPercentFemale() {
		return percentFemale;
	}


	/**
	 * A get method to get the university's average VerbalSAT score
	 * @return the verbalSAT
	 */
	public int getVerbalSAT() {
		return verbalSAT;
	}


	/**
	 * A get method to get the university's average MathSAT score
	 * @return the mathSAT
	 */
	public int getMathSAT() {
		return mathSAT;
	}


	/**
	 * A get method to get the university's cost to attend
	 * @return the schoolExpenses
	 */
	public int getSchoolExpenses() {
		return schoolExpenses;
	}


	/**
	 * A get method to get the university's percent of students who get financial aid
	 * @return the percentFinancialAid
	 */
	public int getPercentFinancialAid() {
		return percentFinancialAid;
	}


	/**
	 * A get method to return the number of applicants who applied to the school
	 * @return the numApplicants
	 */
	public int getNumApplicants() {
		return numApplicants;
	}


	/**
	 *  A get method to get the percent of applicants who applied to the school and got admitted
	 * @return the percentAdmitted
	 */
	public int getPercentAdmitted() {
		return percentAdmitted;
	}


	/**
	 * A get method to get the number of applicants who applied to the school and are enrolled
	 * @return the percentEnrolled
	 */
	public int getPercentEnrolled() {
		return percentEnrolled;
	}


	/**
	 * A get method to get the schoool's score in terms of academics
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return academicScale;
	}


	/**
	 * A get method to get the schoool's score in terms of social life
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}


	/**
	 * A get method to get the schoool's score in terms of quality of life
	 * @return the qualityScale
	 */
	public int getQualityScale() {
		return qualityScale;
	}


	/**
	 * A get method that gets all of the school's emphasizes
	 * @return the emphasis
	 */
	public List<String> getEmphasis() {
		return emphasis;
	}


	/**
	 * A set method to set the university's name
	 * @param schoolName the schoolName to set
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}


	/**
	 * A set method to set the university's State
	 * @param schoolState the schoolState to set
	 */
	public void setSchoolState(String schoolState) {
		this.schoolState = schoolState;
	}


	/**
	 * A set method to set the university's location
	 * @param schoolLocation the schoolLocation to set
	 */
	public void setSchoolLocation(String schoolLocation) {
		this.schoolLocation = schoolLocation;
	}


	/**
	 *  A set method to set the university's control
	 * @param schoolControl the schoolControl to set
	 */
	public void setSchoolControl(String schoolControl) {
		this.schoolControl = schoolControl;
	}


	/**
	 * A set method to set the number of students in the university 
	 * @param numberStudents the numberStudents to set
	 */
	public void setNumberStudents(int numberStudents) {
		this.numberStudents = numberStudents;
	}


	/**
	 * A set method to set the university's percent of female's
	 * @param percentFemale the percentFemale to set
	 */
	public void setPercentFemale(int percentFemale) {
		this.percentFemale = percentFemale;
	}


	/**
	 * A set method to set the university's average VerbalSAT score
	 * @param verbalSAT the verbalSAT to set
	 */
	public void setVerbalSAT(int verbalSAT) {
		this.verbalSAT = verbalSAT;
	}


	/**
	 * A set method to set the university's average mathSAT score
	 * @param mathSAT the mathSAT to set
	 */
	public void setMathSAT(int mathSAT) {
		this.mathSAT = mathSAT;
	}


	/**
	 * A set method to set the university's cost to attend
	 * @param schoolExpenses the schoolExpenses to set
	 */
	public void setSchoolExpenses(int schoolExpenses) {
		this.schoolExpenses = schoolExpenses;
	}


	/**
	 * A set method to set the university's percent of students who get financial aid
	 * @param percentFinancialAid the percentFinancialAid to set
	 */
	public void setPercentFinancialAid(int percentFinancialAid) {
		this.percentFinancialAid = percentFinancialAid;
	}


	/**
	 * A set method to set the number of applicants who applied to the school
	 * @param numApplicants the numApplicants to set
	 */
	public void setNumApplicants(int numApplicants) {
		this.numApplicants = numApplicants;
	}


	/**
	 * A set method to set the percent of applicants who applied to the school and got admitted
	 * @param percentAdmitted the percentAdmitted to set
	 */
	public void setPercentAdmitted(int percentAdmitted) {
		this.percentAdmitted = percentAdmitted;
	}


	/**
	 * A set method to set the percent of number of applicants who applied to the school and Enrolled
	 * @param percentEnrolled the percentEnrolled to set
	 */
	public void setPercentEnrolled(int percentEnrolled) {
		this.percentEnrolled = percentEnrolled;
	}


	/**
	 * A set method to set the schoool's score in terms of academics
	 * @param academicScale the academicScale to set
	 */
	public void setAcademicScale(int academicScale) {
		this.academicScale = academicScale;
	}


	/**
	 * A set method to set the schoool's score in terms of social life
	 * @param socialScale the socialScale to set
	 */
	public void setSocialScale(int socialScale) {
		this.socialScale = socialScale;
	}


	/**
	 * A set method to set the schoool's score in terms of quality of life
	 * @param qualityScale the qualityScale to set
	 */
	public void setQualityScale(int qualityScale) {
		this.qualityScale = qualityScale;
	}


	/**
	 *  A set method to set the schoool's emphasis
	 * @param emphasis the emphasis to set
	 */
	public void setEmphasis(List<String> emphasis) {
		this.emphasis = emphasis;
	}
}
