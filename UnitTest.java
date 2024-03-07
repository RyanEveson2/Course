import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class UnitTest {
	ArrayList<Course> courses = new ArrayList<>();
	Courses L = new Courses();
	
	@Test
		void ListAllTest() {
		L.loadCourses();
		ArrayList<String> s1 = L.listAll();
		ArrayList<String> s2 = L.ListAllIter();		
		ArrayList<String> s3 = L.listAllStream();
		assertEquals(s1,s2);
		assertEquals(s2,s3);
		assertEquals(s1,s3);
		
	}
	@Test
	void countTest() {
		L.loadCourses();
		int expected = 7;
		assertEquals(L.countCourses(),expected);
	}
	@Test
	void databseTest() {
		L.loadCourses();
		int expected = 1;
		ArrayList<String> filtered = L.databaseContainers();
		assertEquals(L.databaseContainers().size(),expected);
		assertEquals(filtered.isEmpty(), false);
		
	}
	@Test
	void DisplayTest() {
		L.loadCourses();
		assertEquals(L.displayCourse("111"),new String[]{"COSC","111","Computer Programming I","Introduction to the design, implementation, and understanding of computer programs. Topics include problem solving, algorithm design, and data and procedural abstraction, with emphasis on the development of working programs. This course should be followed by COSC 121.\\n\"+\r\n"
				+ "								\"Pre-reqs: A score of 70% or higher in one of PREC 12, MATH 12, MATH 125, MATH 126","PREC 12, MATH 12, MATH 125, MATH 126"} );
	}
	@Test
	void SortedTest() {
		L.loadCourses();
		
		int[] expected = {111,121,122,211,222,301,303};
		assertTrue(L.sortedByNumber().get(0)==expected[0]);
		assertTrue(L.sortedByNumber().get(1)==expected[1]);
		assertTrue(L.sortedByNumber().get(2)==expected[2]);
		assertTrue(L.sortedByNumber().get(3)==expected[3]);
		assertTrue(L.sortedByNumber().get(4)==expected[4]);
		assertTrue(L.sortedByNumber().get(5)==expected[5]);
		assertTrue(L.sortedByNumber().get(6)==expected[6]);
	}
	
}
