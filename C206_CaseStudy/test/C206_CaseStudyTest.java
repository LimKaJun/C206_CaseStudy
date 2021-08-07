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

	@Before
	public void setUp() throws Exception {
		parentAccount1 = new ParentAccount(0, "Aloysius", 12345, 'C', "Desmond", "Mary", "mary@gmail.com",
				"Pasir Ris Avenue 3 520511", 91234567);
		parentAccount2 = new ParentAccount(1, "Aseerah", 54321, 'D', "Desmond", "Jason", "aseerah@gmail.com",
				"Pasir Ris Avenue 6 520522", 98765432);

		student1 = new Student(0, "Aloysius", 3, 'C', "Desmond");
		student2 = new Student(1, "Aseerah", 4, 'D', "Jason");

		ParentAccountList = new ArrayList<ParentAccount>();
		StudentList = new ArrayList<Student>();

	}

	@After
	public void tearDown() throws Exception {
		parentAccount1 = null;
		parentAccount2 = null;
		ParentAccountList = null;

		student1 = null;
		student2 = null;
		StudentList = null;

	}

	@Test
	public void addStudentTest() {
		// Item list is not null, so that can add a new item - boundary
		assertNotNull("Check if there is valid Student arraylist to add ", StudentList);

		// add items in the studentList
		C206_CaseStudy.addStudent(StudentList, student1);
		
		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		assertEquals("Check that Student arraylist size is 1", 1, StudentList.size());
		// The item just added is as same as the first item of the list
		assertSame("Check that Student is added", student1, StudentList.get(0));

		// Add another item. test The size of the list is 2 - normal
		C206_CaseStudy.addStudent(StudentList, student2);
		assertEquals("Check that Student arraylist size is 2", 2, StudentList.size());
		// The item just added is as same as the second item of the list
		assertSame("Check that Student is added", student2, StudentList.get(1));
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

		// test if the expected output string same as the list of students retrieved
		// from the C206_CaseStudy
		viewStudent = C206_CaseStudy.retrieveAllStudent(StudentList);
		testOutput = String.format("%-15d %-15s %-10s %-10s %-15s \n", 0, "Aloysius", 3, 'C', "Desmond");
		testOutput += String.format("%-15d %-15s %-10s %-10s %-15s \n", 1, "Aseerah", 4, 'D', "Jason");
		assertEquals("Test that viewStudentList shows the same output", testOutput, viewStudent);

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

}
