
public class Student {
	
	private String student_id;
	private String grade;
	private String student_class;
	private String form_teacher;
	
	
	public Student(String student_id, String grade, String student_class, String form_teacher) {
		this.student_id = student_id;
		this.grade = grade;
		this.student_class = student_class;
		this.form_teacher = form_teacher;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getStudent_class() {
		return student_class;
	}


	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}


	public String getForm_teacher() {
		return form_teacher;
	}


	public void setForm_teacher(String form_teacher) {
		this.form_teacher = form_teacher;
	}


}
