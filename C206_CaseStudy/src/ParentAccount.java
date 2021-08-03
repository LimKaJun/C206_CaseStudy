public class ParentAccount {
	
	private int studentId;
	private String name;
	private int grade;
	private char classLetter;
	private String teacher;
	private String parentName;
	private String parentEmail;
	private String parentAddress;
	private int parentContact; 
	
	public ParentAccount(int studentId, String name, int grade, char classLetter, String teacher, String parentName,
			String parentEmail, String parentAddress, int parentContact) {
		this.studentId = studentId;
		this.name = name;
		this.grade = grade;
		this.classLetter = classLetter;
		this.teacher = teacher;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.parentAddress = parentAddress;
		this.parentContact = parentContact;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public char getClassLetter() {
		return classLetter;
	}

	public void setClassLetter(char classLetter) {
		this.classLetter = classLetter;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public void setParentEmail(String parentEmail) {
		this.parentEmail = parentEmail;
	}

	public String getParentAddress() {
		return parentAddress;
	}

	public void setParentAddress(String parentAddress) {
		this.parentAddress = parentAddress; 
	}

	public int getParentContact() {
		return parentContact;
	}

	public void setParentContact(int parentContact) {
		this.parentContact = parentContact;
	}
	
	
}

