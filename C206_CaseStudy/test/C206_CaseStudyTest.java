import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private ParentAccount parentAccount1;
	private ParentAccount parentAccount2;
	private ArrayList<ParentAccount> ParentAccountList;

	@Before
	public void setUp() throws Exception {
		parentAccount1 = new ParentAccount(0, "Aloysius", 12345, 'C', "Desmond", "Mary", "mary@gmail.com",
				"Pasir Ris Avenue 3 520511", 91234567);
		parentAccount2 = new ParentAccount(1, "Aseerah", 54321, 'D', "Desmond", "Jason", "aseerah@gmail.com",
				"Pasir Ris Avenue 6 520522", 98765432);

		ParentAccountList = new ArrayList<ParentAccount>();
	}

	@After
	public void tearDown() throws Exception {
		parentAccount1 = null;
		parentAccount2 = null;
		ParentAccountList = null;
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
	public void testUpdateParentAccount() {
		assertNotNull(ParentAccountList);
		
		C206_CaseStudy.addParentAccount(parentAccount1, ParentAccountList);
		C206_CaseStudy.addParentAccount(parentAccount2, ParentAccountList);
		
		C206_CaseStudy.updateParentAccountInt(1, 1, ParentAccountList, 123);
		assertEquals(123,parentAccount1.getStudentId());
		C206_CaseStudy.updateParentAccountString(2, 1, ParentAccountList, "123");
		assertEquals("123",parentAccount1.getName());
		
		C206_CaseStudy.updateParentAccountInt(3, 2, ParentAccountList, 123);
		assertEquals(123,parentAccount2.getGrade());
		C206_CaseStudy.updateParentAccountChar(4, 2, ParentAccountList, 'A');
		assertEquals('A',parentAccount2.getClassLetter());
		C206_CaseStudy.updateParentAccountString(5, 2, ParentAccountList, "123");
		assertEquals("123",parentAccount2.getTeacher());
		C206_CaseStudy.updateParentAccountString(6, 2, ParentAccountList, "123");
		assertEquals("123",parentAccount2.getParentName());
		C206_CaseStudy.updateParentAccountString(7, 2, ParentAccountList, "123");
		assertEquals("123",parentAccount2.getParentEmail());
		C206_CaseStudy.updateParentAccountString(8, 2, ParentAccountList, "123");
		assertEquals("123",parentAccount2.getParentAddress());
		C206_CaseStudy.updateParentAccountInt(9, 2, ParentAccountList,123);
		assertEquals(123,parentAccount2.getParentContact());
		C206_CaseStudy.updateParentAccountInt(10, 2, ParentAccountList, 123);
		assertEquals(123,parentAccount2.getRegistrationID());
		C206_CaseStudy.updateParentAccountString(11, 123, ParentAccountList, "123");
		assertEquals("123",parentAccount2.getCcaRegistered());
		String allParentAccount = C206_CaseStudy.retrieveAllParentAccount(ParentAccountList);
		String test = String.format("%-15d %-15s %-10d %-10c %-15s %-15s %-20s %-30s %-15d %-20d %-15s \n", 123, "123",
				12345, 'C', "Desmond", "Mary", "mary@gmail.com", "Pasir Ris Avenue 3 520511", 91234567, 1, "NONE");
		test += String.format("%-15d %-15s %-10d %-10c %-15s %-15s %-20s %-30s %-15d %-20d %-15s \n", 1, "Aseerah",
				123, 'A', "123", "123", "123", "123", 123, 123, "123");
		assertEquals(test, allParentAccount);
	}

}
//testing 123 please comment below if you receive this
