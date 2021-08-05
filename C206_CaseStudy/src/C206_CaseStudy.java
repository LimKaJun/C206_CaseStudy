import java.util.ArrayList;
import java.util.Random;

public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<String> CategoryList = new ArrayList<String>();
		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		ArrayList<Student> StudentList = new ArrayList<Student>();
		ArrayList<ParentAccount> ParentAccountList = new ArrayList<ParentAccount>();
		ArrayList<StudentAccount> StudentAccountList = new ArrayList<StudentAccount>();

		CCAList.add(new CCA("Basketball", "Playing balls with hand", 12, "Monday", "3:00PM - 4:00PM",
				"Basketball Court", "Naziran", "Sports"));
		CCAList.add(new CCA("Bakery", "Baking cookies and cakes!", 5, "Wednesday", "1:00PM - 2:00PM", "Kitchen Lab",
				"Kajun", "Cooking"));
		CCA soccer = new CCA("Soccer", "Playing balls with leg", 20, "Tuesday", "4:00PM - 6:00PM", "Soccer Field",
				"Naziran", "Sports");
		CCAList.add(soccer);
		soccer.setStudentsRegistered("Aseerah");

		CategoryList.add("Sports");
		CategoryList.add("Cooking");
		CategoryList.add("Leisure");

		StaffList.add(new Staff("admin", "admin"));

		StudentList.add(new Student(0, "Aloysius", 3, 'C', "Desmond"));
		StudentList.add(new Student(1, "Aseerah", 4, 'D', "Jason"));
		StudentList.add(new Student(2, "Faith", 2, 'A', "James"));

		ParentAccount pa = new ParentAccount(0, "Aloysius", 3, 'C', "Desmond", "Mary", "mary@gmail.com",
				"Pasir Ris Avenue 3 520511", 91234567);
		pa.setRegistrationID(12345);
		ParentAccountList.add(pa);

		StudentAccount sa = new StudentAccount(1, "Aseerah", 4, 'D', "Jason", "aseerah@gmail.com",
				"Pasir Ris Avenue 6 520522", 98765432);
		sa.setRegistrationID(54321);
		sa.setCcaRegistered("Soccer");
		StudentAccountList.add(sa);

		int option = -1;

		while (option != 5) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == 1) {
				String username = Helper.readString("Enter username > ");
				String password = Helper.readString("Enter password > ");
				boolean correct = C206_CaseStudy.staffLogin(username, password, StaffList);
				if (correct) {
					int staffOption = -1;
					while (staffOption != 13) {
						C206_CaseStudy.staffMenu();
						staffOption = Helper.readInt("Enter an option > ");
						if (staffOption == 1) {

						} else if (staffOption == 2) {

						} else if (staffOption == 3) {

						} else if (staffOption == 4) {

						} else if (staffOption == 5) {

						} else if (staffOption == 6) {

						} else if (staffOption == 7) {

						} else if (staffOption == 8) {

						} else if (staffOption == 9) {

						} else if (staffOption == 10) {
							C206_CaseStudy.viewParentAccount(ParentAccountList);
							char delete = Helper.readChar("Would you like to delete any parent account here?(y/n) > ");
							if (delete == 'y' || delete == 'Y') {
								int accountDeleted = Helper
										.readInt("Enter Registration ID of parent account to delete > ");
								C206_CaseStudy.deleteParentAccount(ParentAccountList, accountDeleted);
							}
						} else if (staffOption == 11) {
							C206_CaseStudy.viewStudentAccount(StudentAccountList);
							char delete = Helper.readChar("Would you like to delete any student account here?(y/n) > ");
							if (delete == 'y' || delete == 'Y') {
								int accountDeleted = Helper
										.readInt("Enter Registration ID of student account to delete > ");
								C206_CaseStudy.deleteStudentAccount(StudentAccountList, accountDeleted);
							}
						} else if (staffOption == 12) {

						} else if (staffOption == 13) {

						}
					}
				} else {
					System.out.println("Username and password invalid!");
				}
			} else if (option == 2) {
				int registrationID = Helper.readInt("Enter Registration ID > ");
				boolean correct = C206_CaseStudy.accountLogin(registrationID, ParentAccountList, StudentAccountList);
				if (correct) {
					int accountOption = -1;
					while (accountOption != 4) {
						C206_CaseStudy.accountMenu();
						accountOption = Helper.readInt("Enter an option > ");
						if (accountOption == 1) {

						} else if (accountOption == 2) {

						} else if (accountOption == 3) {

						}
					}
				} else {
					System.out.println("Registration ID invalid!");
				}
			} else if (option == 3) {
				int studentId = Helper.readInt("Enter student ID > ");
				if (C206_CaseStudy.checkStudentId(studentId, StudentList)) {
					if (C206_CaseStudy.checkRegistration(studentId, ParentAccountList, StudentAccountList)) {
						String name = Helper.readString("Enter Name > ");
						int grade = Helper.readInt("Enter grade > ");
						char classLetter = Helper.readChar("Enter Class > ");
						String teacher = Helper.readString("Enter teacher's name > ");
						String parentName = Helper.readString("Enter parent's name > ");
						String parentEmail = Helper.readString("Enter parent's email > ");
						String parentAddress = Helper.readString("Enter parent's address > ");
						int parentContact = Helper.readInt("Enter parent's contact > ");
						C206_CaseStudy.addParentAccount(studentId, name, grade, classLetter, teacher, parentName,
								parentEmail, parentAddress, parentContact, ParentAccountList);
						System.out.println("Your registration ID have been sent to your email.");
					} else {
						System.out.println("This student ID has already registered an account.");
					}
				} else {
					System.out.println("Student ID does not exist.");
				}

			} else if (option == 4) {
				int studentId = Helper.readInt("Enter student ID > ");
				if (C206_CaseStudy.checkStudentId(studentId, StudentList)) {
					if (C206_CaseStudy.checkRegistration(studentId, ParentAccountList, StudentAccountList)) {
						String name = Helper.readString("Enter Name > ");
						int grade = Helper.readInt("Enter grade > ");
						char classLetter = Helper.readChar("Enter Class > ");
						String teacher = Helper.readString("Enter teacher's name > ");
						String studentEmail = Helper.readString("Enter parent's email > ");
						String studentAddress = Helper.readString("Enter parent's address > ");
						int studentContact = Helper.readInt("Enter parent's contact > ");
						C206_CaseStudy.addStudentAccount(studentId, name, grade, classLetter, teacher, studentEmail,
								studentAddress, studentContact, StudentAccountList);
						System.out.println("Your registration ID have been sent to your email.");
					} else {
						System.out.println("This student ID has already registered an account.");
					}
				} else {
					System.out.println("Student ID does not exist.");
				}
			}
		}

	}

	// -----------------------Menu---------------------------//
	public static void menu() {
		C206_CaseStudy.setHeader("CCA REGISTRATION SYSTEM");
		System.out.println("1. Login as Staff");
		System.out.println("2. Login with Registration ID");
		System.out.println("3. Register as Parent");
		System.out.println("4. Register as Student");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}

	// ---------------------------------------Staff
	// Login------------------------------------------------//
	public static boolean staffLogin(String username, String password, ArrayList<Staff> StaffList) {
		for (int i = 0; i < StaffList.size(); i++) {
			if (StaffList.get(i).getUsername().equals(username) && StaffList.get(i).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	// ------------------Staff Menu--------------//
	public static void staffMenu() {
		C206_CaseStudy.setHeader("STAFF MENU");
		System.out.println("1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Add CCA");
		System.out.println("5. View CCA");
		System.out.println("6. Delete CCA");
		System.out.println("7. Add CCA category");
		System.out.println("8. View CCA categories");
		System.out.println("9. Delete CCA category");
		System.out.println("10. View registered parent accounts");
		System.out.println("11. View registered student accounts");
		System.out.println("12. Select CCA to view students registered");
		System.out.println("13. Quit");

		Helper.line(80, "-");
	}

	// ------------------------------------------------Account
	// Login------------------------------------------------------//
	public static boolean accountLogin(int registrationID, ArrayList<ParentAccount> pa, ArrayList<StudentAccount> sa) {
		for (int i = 0; i < pa.size(); i++) {
			if (registrationID == pa.get(i).getRegistrationID()) {
				return true;
			}
		}
		for (int i = 0; i < sa.size(); i++) {
			if (registrationID == sa.get(i).getRegistrationID()) {
				return true;
			}
		}
		return false;
	}

	// -------------------Account Menu------------------//
	public static void accountMenu() {
		C206_CaseStudy.setHeader("USER MENU");
		System.out.println("1. Register for CCA");
		System.out.println("2. View Details of current CCA");
		System.out.println("3. Drop out of current CCA");
		System.out.println("4. Quit");
		Helper.line(80, "-");
	}

	// --------------------------Check Student
	// Id----------------------------------//
	public static boolean checkStudentId(int studentId, ArrayList<Student> sa) {
		for (int i = 0; i < sa.size(); i++) {
			if (studentId == sa.get(i).getStudentId()) {
				return true;
			}
		}
		return false;
	}

	// ----------------------------------------------Check
	// Registration---------------------------------------------------//
	public static boolean checkRegistration(int studentId, ArrayList<ParentAccount> pa, ArrayList<StudentAccount> sa) {
		for (int i = 0; i < pa.size(); i++) {
			if (studentId == pa.get(i).getRegistrationID()) {
				return false;
			}
		}
		for (int i = 0; i < sa.size(); i++) {
			if (studentId == sa.get(i).getRegistrationID()) {
				return false;
			}
		}
		return true;
	}

	// -------------------------------------------Add Parent
	// Account-------------------------------------------------//
	public static void addParentAccount(int studentId, String name, int grade, char classLetter, String teacher,
			String parentName, String parentEmail, String parentAddress, int parentContact,
			ArrayList<ParentAccount> ParentAccountList) {
		ParentAccount parentAccount = new ParentAccount(studentId, name, grade, classLetter, teacher, parentName,
				parentEmail, parentAddress, parentContact);
		ParentAccountList.add(parentAccount);
		int id = -1;
		for (int i = 0; i < ParentAccountList.size(); i++) {
			if (ParentAccountList.get(i).equals(null)) {
				id = i;
			}
		}
		parentAccount.setRegistrationID(id);
	}

	// ------------------------------------------Add Student
	// Accouunt----------------------------------------------//
	public static void addStudentAccount(int studentId, String name, int grade, char classLetter, String teacher,
			String studentEmail, String studentAddress, int studentContact,
			ArrayList<StudentAccount> StudentAccountList) {
		StudentAccount studentAccount = new StudentAccount(studentId, name, grade, classLetter, teacher, studentEmail,
				studentAddress, studentContact);
		StudentAccountList.add(studentAccount);
		int id = -1;
		for (int i = 0; i < StudentAccountList.size(); i++) {
			if (StudentAccountList.get(i).equals(null)) {
				id = i;
			}
		}
		studentAccount.setRegistrationID(id);
	}

	// -----------------------------View Parent
	// Account----------------------------------//
	public static void viewParentAccount(ArrayList<ParentAccount> ParentAccountList) {
		C206_CaseStudy.setHeader("PARENT ACCOUNT LIST");
		String output = String.format("%-10s %-15s %-10s %-10s %-15s %-15s %-20s %-30s %-15s %-20s %-15s \n",
				"STUDENT ID", "NAME", "GRADE", "CLASS", "TEACHER", "PARENT NAME", "PARENT EMAIL", "PARENT ADDRESS",
				"PARENT CONTACT", "REGISTRATION ID", "CCA REGISTERED");
		output += C206_CaseStudy.retrieveAllParentAccount(ParentAccountList);
		System.out.println(output);
	}

	// -------------------------------View Student
	// Account----------------------------------//
	public static void viewStudentAccount(ArrayList<StudentAccount> StudentAccountList) {
		C206_CaseStudy.setHeader("STUDENT ACCOUNT LIST");
		String output = String.format("%-10s %-15s %-10s %-10s %-15s %-20s %-30s %-15s %-20s %-15s \n", "STUDENT ID",
				"NAME", "GRADE", "CLASS", "TEACHER", "STUDENT EMAIL", "STUDENT ADDRESS", "STUDENT CONTACT",
				"REGISTRATION ID", "CCA REGISTERED");
		output += C206_CaseStudy.retrieveAllStudentAccount(StudentAccountList);
		System.out.println(output);
	}

	// --------------------------------Retrieve All Parent
	// Account------------------------------------//
	public static String retrieveAllParentAccount(ArrayList<ParentAccount> ParentAccountList) {
		String output = "";
		for (int i = 0; i < ParentAccountList.size(); i++) {
			output += String.format("%-10d %-15s %-10d %-10c %-15s %-15s %-20s %-30s %-15d %-20d %-15s \n",
					ParentAccountList.get(i).getStudentId(), ParentAccountList.get(i).getName(),
					ParentAccountList.get(i).getGrade(), ParentAccountList.get(i).getClassLetter(),
					ParentAccountList.get(i).getTeacher(), ParentAccountList.get(i).getParentName(),
					ParentAccountList.get(i).getParentEmail(), ParentAccountList.get(i).getParentAddress(),
					ParentAccountList.get(i).getParentContact(), ParentAccountList.get(i).getRegistrationID(),
					ParentAccountList.get(i).getCcaRegistered());
		}
		return output;
	}

	// ------------------------------Retrieve All Student
	// Account---------------------------------------//
	public static String retrieveAllStudentAccount(ArrayList<StudentAccount> StudentAccountList) {
		String output = "";
		for (int i = 0; i < StudentAccountList.size(); i++) {
			output += String.format("%-10s %-15s %-10s %-10s %-15s %-20s %-30s %-15s %-20s %-15s \n",
					StudentAccountList.get(i).getStudentId(), StudentAccountList.get(i).getName(),
					StudentAccountList.get(i).getGrade(), StudentAccountList.get(i).getClassLetter(),
					StudentAccountList.get(i).getTeacher(), StudentAccountList.get(i).getStudentEmail(),
					StudentAccountList.get(i).getStudentAddress(), StudentAccountList.get(i).getStudentContact(),
					StudentAccountList.get(i).getRegistrationID(), StudentAccountList.get(i).getCcaRegistered());
		}
		return output;
	}

	// -------------------------------------Delete Parent
	// Account---------------------------------------------//
	public static void deleteParentAccount(ArrayList<ParentAccount> ParentAccountList, int registrationId) {
		boolean removed = false;
		int accountRemoved = 0;
		for (int i = 0; i < ParentAccountList.size(); i++) {
			if (ParentAccountList.get(i).getRegistrationID() == registrationId) {
				ParentAccountList.remove(i);
				accountRemoved = i;
				removed = true;
				break;
			}
		}
		if (removed) {
			System.out.println("Account with registration ID " + accountRemoved + " removed!");
		} else {
			System.out.println("Registration ID do not exist.");
		}
	}

	// ----------------------------------------Delete Student
	// Account--------------------------------------------//
	public static void deleteStudentAccount(ArrayList<StudentAccount> StudentAccountList, int registrationId) {
		boolean removed = false;
		int accountRemoved = 0;
		for (int i = 0; i < StudentAccountList.size(); i++) {
			if (StudentAccountList.get(i).getRegistrationID() == registrationId) {
				StudentAccountList.remove(i);
				accountRemoved = i;
				removed = true;
				break;
			}
		}
		if (removed) {
			System.out.println("Account with registration ID " + accountRemoved + " removed!");
		} else {
			System.out.println("Registration ID do not exist.");
		}
	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}