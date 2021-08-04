import java.util.ArrayList;


public class C206_CaseStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<CCA> CCAList = new ArrayList<CCA>();
		ArrayList<String> CategoryList = new ArrayList<String>();
		ArrayList<Staff> StaffList = new ArrayList<Staff>();
		ArrayList<Student> StudentList = new ArrayList<Student>();
		ArrayList<ParentAccount> ParentAccountList = new ArrayList<ParentAccount>();
		ArrayList<StudentAccount> StudentAccountList = new ArrayList<StudentAccount>();
		
		CCAList.add(new CCA("Basketball","Playing balls with hand",12,"Monday","3:00PM - 4:00PM","Basketball Court","Naziran","Sports"));
		CCAList.add(new CCA("Bakery","Baking cookies and cakes!",5,"Wednesday","1:00PM - 2:00PM","Kitchen Lab","Kajun","Cooking"));
		CCA soccer = new CCA ("Soccer","Playing balls with leg",20,"Tuesday","4:00PM - 6:00PM","Soccer Field","Naziran","Sports");
		CCAList.add(soccer);
		soccer.setStudentsRegistered("Aseerah");
		
		CategoryList.add("Sports");
		CategoryList.add("Cooking");
		CategoryList.add("Leisure");
		
		StaffList.add(new Staff("admin","admin"));
		
		StudentList.add(new Student(0,"Aloysius",3,'C',"Desmond"));
		StudentList.add(new Student(1,"Aseerah",4,'D',"Jason"));
		StudentList.add(new Student(2,"Faith",2,'A',"James"));
		
		ParentAccount pa = new ParentAccount(0,"Aloysius",3,'C',"Desmond","Mary","mary@gmail.com","Pasir Ris Avenue 3 520511",91234567);
		pa.setRegistrationID(0);
		ParentAccountList.add(pa);
		
		
		StudentAccount sa = new StudentAccount(1,"Aseerah",4,'D',"Jason","aseerah@gmail.com","Pasir Ris Avenue 6 520522",98765432);
		sa.setRegistrationID(1);
		sa.setCcaRegistered("Soccer");
		StudentAccountList.add(sa);
		
		int option = -1;
		
		while(option != 5) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");
			
			if(option == 1) {
				String username = Helper.readString("Enter username > ");
				String password = Helper.readString("Enter password > ");
				boolean correct = C206_CaseStudy.staffLogin(username, password, StaffList);
				if(correct) {
					option = -1;
					while(option != 13) {
						C206_CaseStudy.staffMenu();
						option = Helper.readInt("Enter an option > ");
					}
				}else {
					System.out.println("Username and password invalid!");
				}
			}else if(option ==2) {
				
			}else if(option ==3) {
				
			}else if(option ==4) {
				
			}
		}
		
	
	}
	
	public static void menu() {
		C206_CaseStudy.setHeader("CCA REGISTRATION SYSTEM");
		System.out.println("1. Login as Staff");
		System.out.println("2. Login with Registration ID");
		System.out.println("3. Register as Parent");
		System.out.println("4. Register as Student");
		System.out.println("5. Quit");
		Helper.line(80, "-");

	}
	
	public static boolean staffLogin(String username,String password,ArrayList<Staff> StaffList) {
		for(int i = 0; i < StaffList.size();i++) {
			if(StaffList.get(i).getUsername().equals(username)&&StaffList.get(i).getPassword().equals(password)) {
				return true;
			}
			
		}
		return false;
	}
	
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
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

}