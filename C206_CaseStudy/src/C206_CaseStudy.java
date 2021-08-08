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
		pa.setRegistrationID(5);
		ParentAccountList.add(pa);

		StudentAccount sa = new StudentAccount(1, "Aseerah", 4, 'D', "Jason", "aseerah@gmail.com",
				"Pasir Ris Avenue 6 520522", 98765432);
		sa.setRegistrationID(10);
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

							int studentId = Helper.readInt("Enter student Id > ");
							if (!C206_CaseStudy.checkStudentId(studentId, StudentList)) {

								String name = Helper.readString("Enter Name > ");
								int grade = Helper.readInt("Enter grade > ");
								char classLetter = Helper.readChar("Enter class > ");
								String teacher = Helper.readString("Enter teacher's name > ");

								Student student = new Student(studentId, name, grade, classLetter, teacher);
								C206_CaseStudy.addStudent(StudentList, student);

								System.out.println("successfully added !");
							} else {
								System.out.println("Student ID already exist.");
							}

						} else if (staffOption == 2) {

							C206_CaseStudy.viewStudent(StudentList);

						} else if (staffOption == 3) {

							C206_CaseStudy.viewStudent(StudentList);

							int delete = Helper.readInt("Enter the student id that you wish to delete > ");
							C206_CaseStudy.deleteStudent(StudentList, delete);

						} else if (staffOption == 4) {
							C206_CaseStudy.addCCADetails(CCAList, C206_CaseStudy.inputDetails());

						} else if (staffOption == 5) {
							C206_CaseStudy.viewCCADetails(CCAList);

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
							char update = Helper.readChar("Would you like to update any parent account here?(y/n) > ");
							if (update == 'y' || update == 'Y') {
								int accountUpdated = Helper
										.readInt("Enter Registration ID of parent account to update > ");
								C206_CaseStudy.updateMenu();
								int updateIndex = Helper.readInt("Enter attribute to update > ");
								if (updateIndex == 1 || updateIndex == 3 || updateIndex == 9 || updateIndex == 10) {
									int value = Helper.readInt("Enter new value > ");
									C206_CaseStudy.updateParentAccountInt(updateIndex, accountUpdated,
											ParentAccountList, value);
								} else if (updateIndex == 4) {
									char value = Helper.readChar("Enter new value > ");
									C206_CaseStudy.updateParentAccountChar(updateIndex, accountUpdated,
											ParentAccountList, value);
								} else {
									String value = Helper.readString("Enter new value");
									C206_CaseStudy.updateParentAccountString(updateIndex, accountUpdated,
											ParentAccountList, value);
								}
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
					while (accountOption != 3) {
						C206_CaseStudy.accountMenu();
						accountOption = Helper.readInt("Enter an option > ");
						if (accountOption == 1) {

						} else if (accountOption == 2) {

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
						ParentAccount parentAccount = new ParentAccount(studentId, name, grade, classLetter, teacher,
								parentName, parentEmail, parentAddress, parentContact);
						C206_CaseStudy.addParentAccount(parentAccount, ParentAccountList);
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
						String studentEmail = Helper.readString("Enter email > ");
						String studentAddress = Helper.readString("Enter address > ");
						int studentContact = Helper.readInt("Enter contact > ");
						StudentAccount studentAccount = new StudentAccount(studentId, name, grade, classLetter, teacher,
								studentEmail, studentAddress, studentContact);
						C206_CaseStudy.addStudentAccount(studentAccount, StudentAccountList);
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

	// -----------------------Update Menu---------------------------//
	public static void updateMenu() {
		C206_CaseStudy.setHeader("UPDATE MENU");
		System.out.println("1. Student ID");
		System.out.println("2. Name");
		System.out.println("3. Grade");
		System.out.println("4. Class");
		System.out.println("5. Teacher");
		System.out.println("6. Parent's name");
		System.out.println("7. Parent's email");
		System.out.println("8. Parent's address");
		System.out.println("9. Parent's contact");
		System.out.println("10. Registration ID");
		System.out.println("11. CCA Registered");
		Helper.line(80, "-");
	}

	public static void updateParentAccountInt(int updateIndex, int accountUpdated,
			ArrayList<ParentAccount> ParentAccountList, int value) {
		for (int i = 0; i < ParentAccountList.size(); i++) {
			if (ParentAccountList.get(i).getRegistrationID() == accountUpdated) {
				if (updateIndex == 1) {
					ParentAccountList.get(i).setStudentId(value);
				} else if (updateIndex == 3) {
					ParentAccountList.get(i).setGrade(value);
				} else if (updateIndex == 9) {
					ParentAccountList.get(i).setParentContact(value);
				} else if (updateIndex == 10) {
					ParentAccountList.get(i).setRegistrationID(value);
				}
			}
		}
	}
	
	public static void updateParentAccountChar(int updateIndex, int accountUpdated,
			ArrayList<ParentAccount> ParentAccountList, char value) {
		for (int i = 0; i < ParentAccountList.size(); i++) {
			if (ParentAccountList.get(i).getRegistrationID() == accountUpdated) {
				ParentAccountList.get(i).setClassLetter(value);
			}
		}
	}
	
	public static void updateParentAccountString(int updateIndex, int accountUpdated,
			ArrayList<ParentAccount> ParentAccountList, String value) {
		for (int i = 0; i < ParentAccountList.size(); i++) {
			if (ParentAccountList.get(i).getRegistrationID() == accountUpdated) {
				if (updateIndex == 2) {
					ParentAccountList.get(i).setName(value);
				} else if (updateIndex == 5) {
					ParentAccountList.get(i).setTeacher(value);
				} else if (updateIndex == 6) {
					ParentAccountList.get(i).setParentName(value);
				} else if (updateIndex == 7) {
					ParentAccountList.get(i).setParentEmail(value);
				}else if (updateIndex == 8) {
					ParentAccountList.get(i).setParentAddress(value);
				}else if (updateIndex == 11) {
					ParentAccountList.get(i).setCcaRegistered(value);
				}
			}
		}
	}

	// ---------------------------------------Staff Login------------------------------------------------//
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

	// ------------------------------------------Account Login------------------------------------------//
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

	// ------------------------------------------Account Menu------------------------------------------//
	public static void accountMenu() {
		C206_CaseStudy.setHeader("USER MENU");
		System.out.println("1. Register for CCA");
		System.out.println("2. View Details of current CCA");
		System.out.println("3. Quit");
		Helper.line(80, "-");
	}

	// ------------------------------------------Check Student Id------------------------------------------//
	public static boolean checkStudentId(int studentId, ArrayList<Student> sa) {
		for (int i = 0; i < sa.size(); i++) {
			if (studentId == sa.get(i).getStudentId()) {
				return true;
			}
		}
		return false;
	}

	// ------------------------------------------Check Registration------------------------------------------//
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

	// ------------------------------------------Add student------------------------------------------//

	public static void addStudent(ArrayList<Student> StudentList, Student student) {

		StudentList.add(student);	
	}
	
	//---------------------------------------Add CCA details----------------------------------------------//
		public static CCA inputDetails() {
			String title = Helper.readString("Enter title > ");
			String desc = Helper.readString("Enter description > ");
			int size = Helper.readInt("Enter class size > ");
			String day = Helper.readString("Enter day of week > ");
			String time = Helper.readString("Enter duration of CCA > ");
			String venue = Helper.readString("Enter CCA venue > ");
			String instructor = Helper.readString("Enter instructor name > ");
			String category = Helper.readString("Enter CCA category > ");
			
			CCA cca = new CCA(title, desc, size, day, time, venue, instructor, category);
			
			return cca;
		}

		public static void addCCADetails(ArrayList<CCA> CCAList, CCA cca) {
			CCAList.add(cca);
			System.out.println("==========CCA details added!==========");
		}

	// ------------------------------------------Add Parent Account------------------------------------------//
	public static void addParentAccount(ParentAccount parentAccount, ArrayList<ParentAccount> ParentAccountList) {
		ParentAccountList.add(parentAccount);
		int highest = 0;
		for (int i = 0; i < ParentAccountList.size(); i++) {
			if (ParentAccountList.get(i).getRegistrationID() > highest) {
				highest = ParentAccountList.get(i).getRegistrationID();
			}
		}
		parentAccount.setRegistrationID(highest + 1);
	}

	// ------------------------------------------Add Student Account------------------------------------------//
	public static void addStudentAccount(StudentAccount studentAccount, ArrayList<StudentAccount> StudentAccountList) {
		StudentAccountList.add(studentAccount);
		int highest = 0;
		for (int i = 0; i < StudentAccountList.size(); i++) {
			if (StudentAccountList.get(i).getRegistrationID() > highest) {
				highest = StudentAccountList.get(i).getRegistrationID();
			}
		}
		studentAccount.setRegistrationID(highest + 1);
	}

	// ------------------------------------------View Student List------------------------------------------//
	public static void viewStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("STUDENT LIST");
		String output = String.format("%-15s %-15s %-10s %-10s %-15s \n", "STUDENT ID", "NAME", "GRADE", "CLASS",
				"TEACHER");
		output += C206_CaseStudy.retrieveAllStudent(studentList);
		System.out.println(output);
	}	
	
	//--------------------------------View CCA Details-----------------------------------//
		public static void viewCCADetails(ArrayList<CCA> CCAList) {
			C206_CaseStudy.setHeader("VIEW CCA DETAILS");
			
			String output = String.format("%-15s %-30s %-15s %-20s %-20s %-20s %-25s\n", "TITLE", "DESCRIPTION", "CLASS SIZE", 
					"DAY OF WEEK", "TIME", "VENUE", "INSTRUCTOR IN-CHARGE", "CATEGORY");
			output += C206_CaseStudy.retrieveAllCCADetails(CCAList);
			System.out.println(output);
		}

	// ------------------------------------------View Parent Account------------------------------------------//
	public static void viewParentAccount(ArrayList<ParentAccount> ParentAccountList) {
		C206_CaseStudy.setHeader("PARENT ACCOUNT LIST");
		String output = String.format("%-15s %-15s %-10s %-10s %-15s %-15s %-20s %-30s %-15s %-20s %-15s \n",
				"STUDENT ID", "NAME", "GRADE", "CLASS", "TEACHER", "PARENT NAME", "PARENT EMAIL", "PARENT ADDRESS",
				"PARENT CONTACT", "REGISTRATION ID", "CCA REGISTERED");
		output += C206_CaseStudy.retrieveAllParentAccount(ParentAccountList);
		System.out.println(output);
	}

	// ------------------------------------------View Student Account------------------------------------------//
	public static void viewStudentAccount(ArrayList<StudentAccount> StudentAccountList) {
		C206_CaseStudy.setHeader("STUDENT ACCOUNT LIST");
		String output = String.format("%-15s %-15s %-10s %-10s %-15s %-20s %-30s %-15s %-20s %-15s \n", "STUDENT ID",
				"NAME", "GRADE", "CLASS", "TEACHER", "STUDENT EMAIL", "STUDENT ADDRESS", "STUDENT CONTACT",
				"REGISTRATION ID", "CCA REGISTERED");
		output += C206_CaseStudy.retrieveAllStudentAccount(StudentAccountList);
		System.out.println(output);
	}

	// ------------------------------------------Retrieve All student List------------------------------------------//
	public static String retrieveAllStudent(ArrayList<Student> studentList) {
		String output = "";
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%-15s %-15s %-10s %-10s %-15s \n", studentList.get(i).getStudentId(),
					studentList.get(i).getName(), studentList.get(i).getGrade(), studentList.get(i).getClassLetter(),
					studentList.get(i).getTeacher());
		}
		return output;
	}
	
	//--------------------------------Retrieve All CCA Details------------------------------------//
		public static String retrieveAllCCADetails(ArrayList<CCA> CCAList) {
			String output = "";
			for (int i = 0; i < CCAList.size(); i++) {
				CCA cca = CCAList.get(i);
				output += String.format("%-15s %-30s %-15s %-20s %-20s %-20s %-25s\n", cca.getTitle(), cca.getDescription(),
						cca.getClassSize(), cca.getDayOfWeek(), cca.getTime(), cca.getVenue(), cca.getInstructorName(), cca.getCategory());	
			}
			return output;
		}

	// ------------------------------------------Retrieve All Parent Account------------------------------------------//
	public static String retrieveAllParentAccount(ArrayList<ParentAccount> ParentAccountList) {
		String output = "";
		for (int i = 0; i < ParentAccountList.size(); i++) {
			output += String.format("%-15d %-15s %-10d %-10c %-15s %-15s %-20s %-30s %-15d %-20d %-15s \n",
					ParentAccountList.get(i).getStudentId(), ParentAccountList.get(i).getName(),
					ParentAccountList.get(i).getGrade(), ParentAccountList.get(i).getClassLetter(),
					ParentAccountList.get(i).getTeacher(), ParentAccountList.get(i).getParentName(),
					ParentAccountList.get(i).getParentEmail(), ParentAccountList.get(i).getParentAddress(),
					ParentAccountList.get(i).getParentContact(), ParentAccountList.get(i).getRegistrationID(),
					ParentAccountList.get(i).getCcaRegistered());
		}
		return output;
	}

	// ------------------------------------------Retrieve All Student Account------------------------------------------//
	public static String retrieveAllStudentAccount(ArrayList<StudentAccount> StudentAccountList) {
		String output = "";
		for (int i = 0; i < StudentAccountList.size(); i++) {
			output += String.format("%-15s %-15s %-10s %-10s %-15s %-20s %-30s %-15s %-20s %-15s \n",
					StudentAccountList.get(i).getStudentId(), StudentAccountList.get(i).getName(),
					StudentAccountList.get(i).getGrade(), StudentAccountList.get(i).getClassLetter(),
					StudentAccountList.get(i).getTeacher(), StudentAccountList.get(i).getStudentEmail(),
					StudentAccountList.get(i).getStudentAddress(), StudentAccountList.get(i).getStudentContact(),
					StudentAccountList.get(i).getRegistrationID(), StudentAccountList.get(i).getCcaRegistered());
		}
		return output;
	}

	// ------------------------------------------Delete Student List------------------------------------------//
	public static void deleteStudent(ArrayList<Student> StudentList, int delete) {
		boolean removed = false;
		int deleted = 0;
		String output = " ";
		for (int i = 0; i < StudentList.size(); i++) {
			if (StudentList.get(i).getStudentId() == delete) {
				deleted = StudentList.get(i).getStudentId();
				StudentList.remove(i);
				removed = true;
				break;
			}
		}
		if (removed) {
			output = ("Student id " + deleted + " has been deleted from the system.");
			System.out.println(output);
			
		} else {
			output = ("Student ID do not exist.");
			System.out.println(output);

		}
	}

	// -------------------------------------------Delete Parent Account------------------------------------------//
	public static void deleteParentAccount(ArrayList<ParentAccount> ParentAccountList, int registrationId) {
		boolean removed = false;
		int accountRemoved = 0;
		for (int i = 0; i < ParentAccountList.size(); i++) {
			if (ParentAccountList.get(i).getRegistrationID() == registrationId) {
				accountRemoved = ParentAccountList.get(i).getRegistrationID();
				ParentAccountList.remove(i);
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

	// ------------------------------------------Delete Student Account------------------------------------------//
	public static void deleteStudentAccount(ArrayList<StudentAccount> StudentAccountList, int registrationId) {
		boolean removed = false;
		int accountRemoved = 0;
		for (int i = 0; i < StudentAccountList.size(); i++) {
			if (StudentAccountList.get(i).getRegistrationID() == registrationId) {
				accountRemoved = StudentAccountList.get(i).getRegistrationID();
				StudentAccountList.remove(i);
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