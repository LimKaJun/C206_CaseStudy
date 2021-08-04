
public class Student {
	
	private int studentId;
	private String name;
	private int grade;
	private char classLetter;
	private String teacher;
	
	public Student(int studentId, String name, int grade, char classLetter, String teacher) {
		this.studentId = studentId;
		this.name = name;
		this.grade = grade;
		this.classLetter = classLetter;
		this.teacher = teacher;
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
	
	
	
	


}
