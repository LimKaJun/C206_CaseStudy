import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private ParentAccount parentAccount1;
	private ParentAccount parentAccount2;
	private ArrayList<ParentAccount> ParentAccountList;

	private Student student1;
	private Student student2;
	private ArrayList<Student> StudentList;
	
	private CCA basketball;
	private CCA bakery;
	private CCA soccer;
	private ArrayList<CCA> CCAList;
	private ArrayList<String> categoryList; 
private String cat1;
private String cat2;
	@Before
	public void setUp() throws Exception {
		parentAccount1 = new ParentAccount(0, "Aloysius", 12345, 'C', "Desmond", "Mary", "mary@gmail.com",
				"Pasir Ris Avenue 3 520511", 91234567);
		parentAccount2 = new ParentAccount(1, "Aseerah", 54321, 'D', "Desmond", "Jason", "aseerah@gmail.com",
				"Pasir Ris Avenue 6 520522", 98765432);

		cat1 = "Sports";
		cat2 = "Dance";
		student1 = new Student(0, "Aloysius", 3, 'C', "Desmond");
		student2 = new Student(1, "Aseerah", 4, 'D', "Jason");
		
		basketball = new CCA("Basketball", "Playing balls with hand", 12, "Monday", "3:00PM - 4:00PM",
				"Basketball Court", "Naziran", "Sports");
		bakery = new CCA("Bakery", "Baking cookies and cakes!", 5, "Wednesday", "1:00PM - 2:00PM", "Kitchen Lab",
				"Kajun", "Cooking");
		soccer = new CCA("Soccer", "Playing balls with leg", 20, "Tuesday", "4:00PM - 6:00PM", "Soccer Field",
				"Naziran", "Sports");
		
		categoryList = new ArrayList<String>();
		ParentAccountList = new ArrayList<ParentAccount>();
		StudentList = new ArrayList<Student>();
		CCAList = new ArrayList<CCA>();

	}

	@After
	public void tearDown() throws Exception {
		parentAccount1 = null;
		parentAccount2 = null;
		ParentAccountList = null;

		student1 = null;
		student2 = null;
		StudentList = null;
		
		basketball = null;
		bakery = null;
		soccer = null;
		CCAList = null;

	}

	@Test
	public void addStudentTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Student arraylist to add ", StudentList);
		System.out.println("Add Test - student list is valid");

		// add items in the studentList
		C206_CaseStudy.addStudent(StudentList, student1);
		System.out.println("Add Test - student 1 successfully added");

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		assertEquals("Check that Student arraylist size is 1", 1, StudentList.size());
		System.out.println("Add Test - student list size is 1");

		
		// The item just added is as same as the first item of the list
		assertSame("Check that Student is added", student1, StudentList.get(0));
		System.out.println("Add Test - student 1 is the first item");


		// Add another item. test The size of the list is 2 - normal
		C206_CaseStudy.addStudent(StudentList, student2);
		System.out.println("Add Test - student 2 is successfully added");

		assertEquals("Check that Student arraylist size is 2", 2, StudentList.size());
		System.out.println("Add Test - student list size is 2");

		// The item just added is as same as the second item of the list
		assertSame("Check that Student is added", student2, StudentList.get(1));
		System.out.println("Add Test - student 2 is the second item");

	}
	
	@Test
	public void testAddCCADetails() {
		// CCAList is not null, so that can add new CCA - boundary
		assertNotNull("Check if there is valid CCA arraylist to add to", CCAList);
		
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is same as the first item of the list
		C206_CaseStudy.addCCADetails(CCAList, basketball);
		assertEquals("Check that CCA arraylist size is 1", 1, CCAList.size());
		assertSame("Test that basketball is added", basketball, CCAList.get(0));
		
		// Add another item. Test that the size of the list is 2 - normal
		// Item just added is same as the second item of the list
		C206_CaseStudy.addCCADetails(CCAList, bakery);
		assertEquals("Check that CCA arraylist size is 2", 2, CCAList.size());
		assertSame("Test that bakery is added", bakery, CCAList.get(1));
		
		// Add 3rd item. Test that the size of the list is 3 - normal
		// Item just added is same as the third item of the list
		C206_CaseStudy.addCCADetails(CCAList, soccer);
		assertEquals("Check that CCA arraylist size is 3", 3, CCAList.size());
		assertSame("Test that soccer is added", soccer, CCAList.get(2));
	}

	@Test
	public void testAddParentAccount() {
		assertNotNull(ParentAccountList);
		C206_CaseStudy.addParentAccount(parentAccount1, ParentAccountList);
		assertEquals(1, ParentAccountList.size());
		assertSame(parentAccount1, ParentAccountList.get(0));

		C206_CaseStudy.addParentAccount(parentAccount2, ParentAccountList);

		assertEquals(2, ParentAccountList.size());
		assertSame(parentAccount2, ParentAccountList.get(1));

		assertTrue(parentAccount1.getRegistrationID() != -1);
	}

	@Test
	public void retrieveAllStudentTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve students detail", StudentList);

		// test if the list of Students retrieved from the C206_CaseStudy is empty -
		// boundary
		String viewStudent = C206_CaseStudy.retrieveAllStudent(StudentList);
		String testOutput = "";
		assertEquals("Check that ViewStudentlist shows the same (which is nothing)", testOutput, viewStudent);

		// Given an empty list, after adding 2 items, test if the size of the list is 2
		// - normal
		C206_CaseStudy.addStudent(StudentList, student1);
		C206_CaseStudy.addStudent(StudentList, student2);
		assertEquals("Test that Student arraylist size is 2", 2, StudentList.size());
		System.out.println("View Test - student list size is 2");

		

		// test if the expected output string same as the list of students retrieved
		// from the C206_CaseStudy
		viewStudent = C206_CaseStudy.retrieveAllStudent(StudentList);
		testOutput = String.format("%-15d %-15s %-10s %-10s %-15s \n", 0, "Aloysius", 3, 'C', "Desmond");
		testOutput += String.format("%-15d %-15s %-10s %-10s %-15s \n", 1, "Aseerah", 4, 'D', "Jason");
		assertEquals("Test that viewStudentList shows the same output", testOutput, viewStudent);
		System.out.println("View Test - Student list has the same output as the assigned");

	}
	
	@Test
	public void retrieveAllCCADetails() {
		// Test if CCA list is not null but empty - boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve details", CCAList);
		
		// Test if the list of CCA details retrieved from the C206_CaseStudy is empty - boundary
		String allCCADetails = C206_CaseStudy.retrieveAllCCADetails(CCAList);
		String testOutput = "";
		assertEquals("Check that ViewAllCCAlist", testOutput, allCCADetails);
		
		// Given an empty list, after adding 3 items, test if the size of the list is 3 - normal
		C206_CaseStudy.addCCADetails(CCAList, basketball);
		C206_CaseStudy.addCCADetails(CCAList, bakery);
		C206_CaseStudy.addCCADetails(CCAList, soccer);
		assertEquals("Test that CCA arraylist size is 3", 3, CCAList.size());
		
		// Test if the expected output string same as the list of CCA details retrieved from the C206_CaseStudy
		allCCADetails = C206_CaseStudy.retrieveAllCCADetails(CCAList);
		testOutput = String.format("%-15s %-30s %-15s %-20s %-20s %-20s %-25s\n", "Basketball", "Playing balls with hand", 12, "Monday", "3:00PM - 4:00PM",
				"Basketball Court", "Naziran", "Sports");
		testOutput += String.format("%-15s %-30s %-15s %-20s %-20s %-20s %-25s\n", "Bakery", "Baking cookies and cakes!", 5, "Wednesday", "1:00PM - 2:00PM", "Kitchen Lab",
				"Kajun", "Cooking");
		testOutput += String.format("%-15s %-30s %-15s %-20s %-20s %-20s %-25s\n", "Soccer", "Playing balls with leg", 20, "Tuesday", "4:00PM - 6:00PM", "Soccer Field",
				"Naziran", "Sports");
		
		assertEquals("Test that viewALLCCAList", testOutput, allCCADetails);
	}

	@Test
	public void testViewParentAccount() {
		assertNotNull(ParentAccountList);

		String test = "";
		String allParentAccount = C206_CaseStudy.retrieveAllParentAccount(ParentAccountList);
		assertEquals(test, allParentAccount);

		C206_CaseStudy.addParentAccount(parentAccount1, ParentAccountList);
		C206_CaseStudy.addParentAccount(parentAccount2, ParentAccountList);
		assertNotEquals(0, ParentAccountList.size());

		allParentAccount = C206_CaseStudy.retrieveAllParentAccount(ParentAccountList);
		test = String.format("%-15d %-15s %-10d %-10c %-15s %-15s %-20s %-30s %-15d %-20d %-15s \n", 0, "Aloysius",
				12345, 'C', "Desmond", "Mary", "mary@gmail.com", "Pasir Ris Avenue 3 520511", 91234567, 1, "NONE");
		test += String.format("%-15d %-15s %-10d %-10c %-15s %-15s %-20s %-30s %-15d %-20d %-15s \n", 1, "Aseerah",
				54321, 'D', "Desmond", "Jason", "aseerah@gmail.com", "Pasir Ris Avenue 6 520522", 98765432, 2, "NONE");
		assertEquals(test, allParentAccount);

	}

	@Test
	public void deleteStudentTest() {
		// Test if Item list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve item", StudentList);

		// After adding 2 items, test if the size of the list is 2 - normal
		C206_CaseStudy.addStudent(StudentList, student1);
		C206_CaseStudy.addStudent(StudentList, student2);
		assertEquals("Test that Student arraylist size is 2", 2, StudentList.size());

		// Delete item index 0 - normal
		C206_CaseStudy.deleteStudent(StudentList, 0);
		// Test if the size of the list is 1 - normal
		assertEquals("Test that Student arraylist size is 1", 1, StudentList.size());
		// After deleting the item index 0, test if the item is not there by getting it
		assertNotEquals(student1, StudentList.get(0));

		
		// Delete item index 1 - normal
		C206_CaseStudy.deleteStudent(StudentList, 1);
		// Test if the size of the list is 1 - normal
		assertEquals("Test that Student arraylist size is 0", 0, StudentList.size());

	}
	
	@Test
	public void deleteCCADetailsTest() {
		// Test if CCA list is not null but empty - boundary
		assertNotNull("Test if there is valid CCA arraylist to retrieve details", CCAList);
		
		// Given an empty list, after adding 3 items, test if the size of the list is 3 - normal
		C206_CaseStudy.addCCADetails(CCAList, basketball);
		C206_CaseStudy.addCCADetails(CCAList, bakery);
		C206_CaseStudy.addCCADetails(CCAList, soccer);
		assertEquals("Test that CCA arraylist size is 3", 3, CCAList.size());
		
		// Delete basketball CCA - normal
		// Test that the size of the list is 2 - normal
		CCAList.remove(0);
		assertEquals("Test that CCA arrayList size is 2", 2, CCAList.size());
		
		// Delete bakery CCA - normal
		// Test that the size of the list is 1 - normal
		CCAList.remove(0);
		assertEquals("Test that CCA arrayList size is 1", 1, CCAList.size());
		
		// Delete soccer CCA - normal
		// Test that the size of the list is 0 - normal
		CCAList.remove(0);
		assertEquals("Test that CCA arrayList size is 0", 0, CCAList.size());		
	}

	@Test
	public void testDeleteParentAccount() {
		assertNotNull(ParentAccountList);
		C206_CaseStudy.addParentAccount(parentAccount1, ParentAccountList);
		C206_CaseStudy.addParentAccount(parentAccount2, ParentAccountList);

		assertEquals(2, ParentAccountList.size());
		C206_CaseStudy.deleteParentAccount(ParentAccountList, 1);
		assertEquals(1, ParentAccountList.size());

		assertNotEquals(parentAccount1, ParentAccountList.get(0));

		C206_CaseStudy.deleteParentAccount(ParentAccountList, 2);
		assertEquals(0, ParentAccountList.size());

	}
	
	@Test
	public void testAddCategory() {
		assertNotNull(categoryList);
		C206_CaseStudy.addCCACategory(categoryList, cat1);
		assertEquals(categoryList.size(),1);
		assertSame(categoryList.get(0), cat1);
		C206_CaseStudy.addCCACategory(categoryList, cat2);
		assertEquals(categoryList.size(),2);
		assertSame(categoryList.get(1), cat2);
	}
	
	@Test
	public void testDeleteCategory() {
		assertNotNull(categoryList);
		C206_CaseStudy.addCCACategory(categoryList, cat1);
		assertEquals(categoryList.size(),1);
		assertSame(categoryList.get(0), cat1);
		C206_CaseStudy.addCCACategory(categoryList, cat2);
		assertEquals(categoryList.size(),2);
		assertSame(categoryList.get(1), cat2);
		C206_CaseStudy.deleteCCACategory(categoryList, cat2);
		assertEquals(categoryList.size(), 1);
		assertSame(categoryList.get(0), cat1);
	}
	
	@Test
	public void testViewCategory() {
		assertNotNull(categoryList);
		C206_CaseStudy.addCCACategory(categoryList, cat1);
		assertEquals(categoryList.size(),1);
		assertSame(categoryList.get(0), cat1);
		C206_CaseStudy.addCCACategory(categoryList, cat2);
		assertEquals(categoryList.size(),2);
		assertSame(categoryList.get(1), cat2);
		String output = "";
		String test = C206_CaseStudy.retrieveAllCCACategory(categoryList);
		output += String.format("%s\n", "Sports");
		output += String.format("%s\n", "Dance");
		assertSame(output, test);

	}

}
