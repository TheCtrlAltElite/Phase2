package UserFunctionalities;

import java.util.*;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import CMCDatabase.*;
import UniversityFunctionalities.*;
//import other.*;
import other.SMTPAuthenticator;

/**
 * 
 */

/**
 * @author rclintsma001 UserFunctionalityContoller is a class which receives
 *         information from methods in DBController, edits them/searches the
 *         data received, and makes it available for UserInteraction.
 */
public class UserFunctionalityController {

	/**
	 * Instance Variables
	 */
	// private User user;
	// private University university;
	private DBController dbc;
	private UniversityController unc;
	// private String firstName;
	// private String lastName;
	// private String email;
	// private String profilePic;
	// private String status;
	// private String type;
	// private String password;

	public UserFunctionalityController() {
		dbc = new DBController();
		unc = new UniversityController();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Searches schools based on the criteria the user gave.
	 * 
	 * @param the
	 *            search criteria that can be used to find a specific school
	 */
	public List<University> searchSchools(String schoolName, String schoolState, String schoolLocation,
			String schoolControl, String numberStudents1, String numberStudents2, String percentFemale1,
			String percentFemale2, String verbalSAT1, String verbalSAT2, String mathSAT1, String mathSAT2,
			String schoolExpenses1, String schoolExpenses2, String percentFinancialAid1, String percentFinancialAid2,
			String numApplicants1, String numApplicants2, String percentAdmitted1, String percentAdmitted2,
			String percentEnrolled1, String percentEnrolled2, String academicScale1, String academicScale2,
			String socialScale1, String socialScale2, String qualityScale1, String qualityScale2,
			List<String> emphases) {
		DBController dbc = new DBController();
		List<University> listUnis = dbc.loadUniversities();
		List<University> matchingUnis = new ArrayList<University>();
		int counter = 0;
		Map<String, List<String>> emphasesMapDB = dbc.getUniversityNamesWithEmphases();
		Set<String> keys = emphasesMapDB.keySet();
		for (int i = 0; i < listUnis.size(); i++) {
			if (schoolName != null) {

				counter++;
				if (!(listUnis.get(i).getSchoolName()).contains(schoolName)) {
					continue;
				}
			}
			if (schoolState != null) {
				counter++;
				if (!(listUnis.get(i).getSchoolState()).contains(schoolState)) {
					continue;
				}
			}
			if (schoolLocation != null) {
				counter++;
				if (!schoolLocation.equals(listUnis.get(i).getSchoolLocation())) {
					continue;
				}
			}
			if (schoolControl != null) {
				counter++;
				if (!schoolControl.equals(listUnis.get(i).getSchoolControl())) {
					continue;
				}
			}
			if (numberStudents1 != null && numberStudents2 != null) {
				counter++;
				if (!((Integer.parseInt(numberStudents1) <= (listUnis.get(i).getNumberStudents())
						&& (listUnis.get(i).getNumberStudents()) <= Integer.parseInt(numberStudents2)))) {
					continue;
				}
			}
			if (percentFemale1 != null && percentFemale2 != null) {
				counter++;
				if (!((Integer.parseInt(percentFemale1) <= (listUnis.get(i).getPercentFemale())
						&& (listUnis.get(i).getPercentFemale()) <= Integer.parseInt(percentFemale2)))) {
					continue;
				}
			}
			if (verbalSAT1 != null && verbalSAT2 != null) {
				counter++;
				if (!((Integer.parseInt(verbalSAT1) <= (listUnis.get(i).getVerbalSAT())
						&& (listUnis.get(i).getVerbalSAT()) <= Integer.parseInt(verbalSAT2)))) {
					continue;
				}
			}
			if (mathSAT1 != null && mathSAT2 != null) {
				counter++;
				if (!((Integer.parseInt(mathSAT1) <= (listUnis.get(i).getMathSAT())
						&& (listUnis.get(i).getMathSAT()) <= Integer.parseInt(mathSAT2)))) {
					continue;
				}
			}
			if (schoolExpenses1 != null && schoolExpenses2 != null) {
				counter++;
				if (!((Integer.parseInt(schoolExpenses1) <= (listUnis.get(i).getSchoolExpenses())
						&& (listUnis.get(i).getSchoolExpenses()) <= Integer.parseInt(schoolExpenses2)))) {
					continue;
				}
			}
			if (percentFinancialAid1 != null && percentFinancialAid2 != null) {
				counter++;
				if (!((Integer.parseInt(percentFinancialAid1) <= (listUnis.get(i).getPercentFinancialAid())
						&& (listUnis.get(i).getPercentFinancialAid()) <= Integer.parseInt(percentFinancialAid2)))) {
					continue;
				}
			}
			if (numApplicants1 != null && numApplicants2 != null) {
				counter++;
				if (!((Integer.parseInt(numApplicants1) <= (listUnis.get(i).getNumApplicants())
						&& (listUnis.get(i).getNumApplicants()) <= Integer.parseInt(numApplicants2)))) {
					continue;
				}
			}
			if (percentAdmitted1 != null && percentAdmitted2 != null) {
				counter++;
				if (!((Integer.parseInt(percentAdmitted1) <= (listUnis.get(i).getPercentAdmitted())
						&& (listUnis.get(i).getPercentAdmitted()) <= Integer.parseInt(percentAdmitted2)))) {
					continue;
				}
			}
			if (percentEnrolled1 != null && percentEnrolled2 != null) {
				counter++;
				if (!((Integer.parseInt(percentEnrolled1) <= (listUnis.get(i).getPercentEnrolled())
						&& (listUnis.get(i).getPercentEnrolled()) <= Integer.parseInt(percentEnrolled2)))) {
					continue;
				}
			}
			if (academicScale1 != null && academicScale2 != null) {
				counter++;
				if (!((Integer.parseInt(academicScale1) <= (listUnis.get(i).getAcademicScale())
						&& (listUnis.get(i).getAcademicScale()) <= Integer.parseInt(academicScale2)))) {
					continue;
				}
			}
			if (socialScale1 != null && socialScale2 != null) {
				counter++;
				if (!((Integer.parseInt(socialScale1) <= (listUnis.get(i).getSocialScale())
						&& (listUnis.get(i).getSocialScale()) <= Integer.parseInt(socialScale2)))) {
					continue;
				}
			}
			if (qualityScale1 != null && qualityScale2 != null) {
				counter++;
				if (!((Integer.parseInt(qualityScale1) <= (listUnis.get(i).getQualityScale())
						&& (listUnis.get(i).getQualityScale()) <= Integer.parseInt(qualityScale2)))) {
					continue;
				}
			}
			if (emphases != null) {
				counter++;
				// List<String> emphasesInDB = dbc.getUniversityEmphases();
				// int emphasesCounter = 0;
				// for (int j = 0; j < emphases.size(); j++) {
				// for (int k = 0; k < emphasesInDB.size(); k++) {
				// if (emphases.get(j).equals(emphasesInDB.get(k))) {
				// emphasesCounter++;
				// }
				// }
				// }
				// if(emphasesCounter == 0) {
				// continue;
				// }
				int emphasesCounter = 0;
				if (keys.contains(listUnis.get(i).getSchoolName())) {
					for (int j = 0; j < emphases.size(); j++) {
						// for (String key : keys) {
						if (emphasesMapDB.get(listUnis.get(i).getSchoolName()).contains(emphases.get(j))) {
							emphasesCounter++;
							// }
						}
					}
				}
				if (emphasesCounter == 0) {
					continue;
				}
			}
			matchingUnis.add(listUnis.get(i));
		}
		if (counter > 0) {
			for (int i = 0; i < matchingUnis.size(); i++) {
				System.out.println(matchingUnis.get(i).getSchoolName());
			}
			return matchingUnis;
		} else {
			System.out.println("You have not entered any arguments to search for.");
			throw new NullPointerException("Enter some arguments.");
		}
	}

	/**
	 * Saves a school to the User's savedSchoolsList
	 * 
	 * @param String
	 *            schoolName - name of the school
	 */
	public boolean addToSavedSchoolsList3(String userName, String school) {
		if (unc.addToSavedSchoolsList2(userName, school) == 4) {
			return true;
		} else
			return false;
	}

	/**
	 * Presents the user with the information of a school
	 * 
	 * @param String
	 *            schoolName - name of the school
	 */
	public List<String> viewSchool(String schoolName) {
		return unc.getDetailsUni(schoolName);
	}

	/**
	 * Removes a school from the user's savedSchoolsList
	 * 
	 * @param String
	 *            schoolName - name of the school
	 */
	public boolean removeSavedSchool(String username, String uniToFind) {

		int i = 0;
		boolean e = false;

		// searches through list of saved schools for the user
		Map<String, String> schoolsList = dbc.getSavedSchoolsList(username);
		for (Map.Entry<String, String> entry : schoolsList.entrySet()) {
			String name = entry.getKey();

			// confirms that the uniToFind is in that user's saved schools list
			if (name.equals(uniToFind)) {
				e = true;
				System.out.println("YES, " + uniToFind + " exists.");
				break;
			}

			// if the while loop reaches the end of the list, uniToFind is not in that
			// user's saved schools list
			if (i == (dbc.getSavedSchoolsList(username).size()) - 1) {
				System.out.print(uniToFind + " is not in that users saved schools list. \n");
			}
			i++;
		}

		// if uniToFind exists in the saved schools list, calls
		// removeFromSavedSchoolsList1() from DBController
		if (e) {
			dbc.removeFromSavedSchoolsList(username, uniToFind);
		}
		return e;
	}

	/**
	 * Email's the user's savedSchoolsList to the user's email
	 */
	public boolean emailSavedSchools(String username) throws MessagingException {
		boolean status = false;
		if (dbc.isUserReal(username)) {
			status = true;
		}
		Map<String, String> savedSchoolsList = getSavedSchoolsList(username);
		String mail_body = "Your saved schools list: \n";

		try {
			Properties props = new Properties();
			props.put("mail.smtp.user", "cmcdatabase2019@gmail.com"); // sets email to be sent from
																		// cmcdatabase2019@gmail.com
			props.put("mail.smtp.host", "smtp.gmail.com"); // sets server host as gmail
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "587"); // sets the port

			System.out.println(props); // displays server information

			Authenticator auth = new SMTPAuthenticator();
			Session session = Session.getInstance(props, auth);

			for (Map.Entry entry : savedSchoolsList.entrySet()) {
				mail_body += entry.getKey() + " " + entry.getValue() + " \n"; // body of email
			}

			MimeMessage message = new MimeMessage(session); // creates MimeMessage object to send email
			message.setFrom(new InternetAddress("cmcdatabase2019@gmail.com")); // sets from email which is
																				// cmcdatabase2019@gmail.com
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("rclintsma001@csbsju.edu")); // receiver
																											// of the
																											// email
			message.setSubject("Your Saved Schools List"); // subject of the email
			message.setText(mail_body); // sets the body of the email to mail_body

			System.out.println(message); // shows email has begun to send out
			Transport.send(message); // Sends out email
			System.out.println("Message sent!"); // Informs message is sent

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;

	}

	/**
	 * Fetches the user's savedSchoolsList
	 */
	public Map<String, String> getSavedSchoolsList(String username) {
		Map<String, String> savedSchoolsList = dbc.getSavedSchoolsList(username);
		System.out.println(savedSchoolsList);
		return savedSchoolsList;
	}
}
