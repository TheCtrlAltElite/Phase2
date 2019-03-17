package UniversityFunctionalities;
import java.util.List;

/**
 * 
 */

/**
 * @author rclintsma001
 *
 */
public class University {

	
	/**
	 * Instance Variables
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
	 * Creates a University Object
	 */
	public University(String schoolName, String schoolState, String schoolLocation, String schoolControl, int numberStudents, int percentFemale, int verbalSAT, int mathSAT, int schoolExpenses, int percentFinancialAid, int numApplicants, int percentAdmitted, int percentEnrolled, int academicScale, int socialScale, int qualityScale) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the schoolName
	 */
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * @return the schoolState
	 */
	public String getSchoolState() {
		return schoolState;
	}

	/**
	 * @return the schoolLocation
	 */
	public String getSchoolLocation() {
		return schoolLocation;
	}

	/**
	 * @return the schoolControl
	 */
	public String getSchoolControl() {
		return schoolControl;
	}

	/**
	 * @return the numberStudents
	 */
	public int getNumberStudents() {
		return numberStudents;
	}

	/**
	 * @return the percentFemale
	 */
	public int getPercentFemale() {
		return percentFemale;
	}

	/**
	 * @return the verbalSAT
	 */
	public int getVerbalSAT() {
		return verbalSAT;
	}

	/**
	 * @return the mathSAT
	 */
	public int getMathSAT() {
		return mathSAT;
	}

	/**
	 * @return the schoolExpenses
	 */
	public int getSchoolExpenses() {
		return schoolExpenses;
	}

	/**
	 * @return the percentFinancialAid
	 */
	public int getPercentFinancialAid() {
		return percentFinancialAid;
	}

	/**
	 * @return the numApplicants
	 */
	public int getNumApplicants() {
		return numApplicants;
	}

	/**
	 * @return the percentAdmitted
	 */
	public int getPercentAdmitted() {
		return percentAdmitted;
	}

	/**
	 * @return the percentEnrolled
	 */
	public int getPercentEnrolled() {
		return percentEnrolled;
	}

	/**
	 * @return the academicScale
	 */
	public int getAcademicScale() {
		return academicScale;
	}

	/**
	 * @return the socialScale
	 */
	public int getSocialScale() {
		return socialScale;
	}

	/**
	 * @return the qualityScale
	 */
	public int getQualityScale() {
		return qualityScale;
	}

	/**
	 * @return the emphasis
	 */
	public List<String> getEmphasis() {
		return emphasis;
	}

}
