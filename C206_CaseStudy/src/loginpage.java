
public class loginpage {

	private int studentid;
	private int registrationid;
	
	public loginpage(int studentid, int registrationid) {
		super();
		this.studentid = studentid;
		this.registrationid = registrationid;
	}
	
	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	public int getRegistrationid() {
		return registrationid;
	}
	public void setRegistrationid(int registrationid) {
		this.registrationid = registrationid;
	}
}
