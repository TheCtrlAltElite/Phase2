/**
 * 
 */

package CMCDatabase;
import java.awt.List;
import java.util.Collection;
import other.*;
import UniversityFunctionalities.*;

/**
 * @author lneuensch001
 *
 */
public class DBController {

	/**
	 * 
	 */
	public DBController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @return
	 */
	public List getDetailsProfile(String username){
		return null;
	}
	/**
	 * 
	 * @param school
	 * @return
	 */
	public Collection getDetailsUni(String school) {
		return null;
	}
	/**
	 * 
	 * @param username
	 * @return
	 */
	public boolean isUserReal(String username) {
		return false;
	}
	/**
	 * 
	 * @param username
	 */
	public void updateAccount(String username, String firstName, String lastName, String password) {
		
	}
	/**
	 * 
	 */
	public void loadUniversities() {
		//TODO
	}
	/**
	 * 
	 * @param search
	 */
	public void compareSearchCriteria(SearchCriteria search) {
		//TODO
	}
	/**
	 * 
	 * @param search
	 */
	public void updateUniversity(SearchCriteria search) {
		//TODO
	}
	/**
	 * 
	 * @param list
	 */
	public void updateSavedSschoolsList(List<UserSchool> list) {
		//TODO
	}
	/**
	 * 
	 */
	public void loadUsers() {
		//TODO
	}
	/**
	 * 
	 * @param status
	 */
	public void updateStatus(String status) {
		//TODO
	}
	/**
	 * 
	 * @param type
	 */
	public void updateType(String type) {
		//TODO
	}
	/**
	 * 
	 * @return
	 */
	public String getPassword(String username) {
		return null;
	}
	/**
	 * 
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param profilePic
	 * @param Type
	 * @param Status
	 */
	public void addUser(String password, String firstName, String lastName, String email, String profilePic, String Type, String Status) {
		//TODO
	}
	/**
	 * 
	 * @param type
	 */
	public void update(String type) {
		
	}
	/**
	 * 
	 * @param email
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public boolean compareAccountInfo(String email, String firstName, String lastName,) {
		return false;
	}
	/**
	 * 
	 */
	public void sendRecoverEmail() {
		//TODO
	}
	/**
	 * 
	 * @param list
	 */
	public void emailSavedSchoolsList(List<UserSchool> list) {
		//TODO
	}
	/**
	 * 
	 * @param jpeg
	 */
	public void updateProfilePic(String jpeg) {
		
	}
	/**
	 * 
	 * @param password
	 * @return
	 */
	public boolean checkPasswordRequirements(String password) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsLowerCase(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsUpperCase(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsSpecialCharacter(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param array
	 * @return
	 */
	public boolean containsNumber(String[] array) {
		return true;
	}
	/**
	 * 
	 * @param schoolName
	 */
	public void removeUniversityDB(String schoolName) {
		//TODO
	}
}