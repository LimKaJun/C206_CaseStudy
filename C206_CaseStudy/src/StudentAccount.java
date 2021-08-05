
public class StudentAccount extends Student{
	private String studentEmail;
	private String studentAddress;
	private int studentContact;
	private int registrationID;
	private String ccaRegistered;
	
	public StudentAccount(int studentId, String name, int grade, char classLetter, String teacher, String studentEmail,
			String studentAddress, int studentContact) {
		super(studentId, name, grade, classLetter, teacher);
		this.studentEmail = studentEmail;
		this.studentAddress = studentAddress;
		this.studentContact = studentContact;
		this.registrationID = -1;
		this.ccaRegistered = "NONE";
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public int getStudentContact() {
		return studentContact;
	}

	public void setStudentContact(int studentContact) {
		this.studentContact = studentContact;
	}
	
	public int getRegistrationID() {
		return registrationID;
	}

	public void setRegistrationID(int registrationID) {
		this.registrationID = registrationID;
	}

	public String getCcaRegistered() {
		return ccaRegistered;
	}

	public void setCcaRegistered(String ccaRegistered) {
		this.ccaRegistered = ccaRegistered;
	}
	
	
	
}
