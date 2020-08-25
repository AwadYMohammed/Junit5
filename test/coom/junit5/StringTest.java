package coom.junit5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
	System.out.println("Clean up Test Data for "+ info.getDisplayName()  );
	}
	@BeforeAll
	static void beforeAll() {
	System.out.println("Initialize connection to database");
	}

	@AfterAll
	static void afterAll() {
	System.out.println("Close connection to database");
	}
	@Test
	 @DisplayName("When length is null, throw an exception")
	void length_exception() {
	String str = null;
	assertThrows(NullPointerException.class,
	() -> {
	str.length();
	}
	);
	}
	@Test
	void containsBasic() {
		String abc = "abc";
		boolean result = abc.contains("abc");
		assertTrue(result);
		}
	@ParameterizedTest
	@ValueSource(strings = { "ABCD", "ABC", "A", "DEF" })
	void length_greater_than_zero_using_parameterized_test(String str) {
		assertTrue(str.length() > 0);
	}
	@Test
	@RepeatedTest(3)
	void contains_basic() {
		assertFalse("abcdefgh".contains("ijk"));
	}
	@Test
	void split_basic() {
		String str = "abc def ghi";
		String actualResult[] = str.split(" ");
		String[] expectedResult = new String[] { "abc1", "def", "ghi" };
		assertArrayEquals(expectedResult, actualResult);
	}
	
//naming @ParameterizedTest with indexes
	@ParameterizedTest(name = "{0} length is {1}")
	@CsvSource(value = { "abcd, 4", "abc, 3", "'',0", "abcdefg, 7" })
	void length(String word, int expectedLength) {
		assertEquals(expectedLength, word.length());
	}
}
