package coom.junit5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

class StringTest {

	@Test
	void whateveryouwant() {
		
		// the name of the test method doesn't matter, but it should be annotated with @Test 
	// write test code 
		//invoke a method
		//check in junit called Assertions.
	}

	@BeforeEach // @Before
	void beforeEach(TestInfo info) {
	System.out.println("Initialize Test Data for "+ info.getDisplayName() );
	}
	@AfterEach // @After
	void afterEach(TestInfo info) {
	System.out.println("Clean up Test Data");
	}
	
	@Test
	void containsBasic() {
		String abc = "abc";
		boolean result = abc.contains("abc");
		assertTrue(result);
		}
	
	
	@Test
	void split_basic() {
		String str = "abc def ghi";
		String actualResult[] = str.split(" ");
		String[] expectedResult = new String[] { "abc1", "def", "ghi" };
		assertArrayEquals(expectedResult, actualResult);
	}
}
