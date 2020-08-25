package coom.junit5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;

class StringTest {
private String str = "";
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
	@Disabled
	@RepeatedTest(3)
	void contains_basic() {
		assertFalse("abcdefgh".contains("ijk"));
	}
	@Test
	@Disabled
	void performanceTest() {
		assertTimeout(Duration.ofSeconds(5), () -> {
			for (int i = 0; i <= 1000000; i++) {
				int j = i;
				System.out.println(j);
			}
		});
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
	

	@Nested
	@DisplayName("For an empty String")
	class EmptyStringTests {
		@BeforeEach
		void setToEmpty() {
			str = "";
		}

		@Test
		@DisplayName("length should be zero")
		void lengthIsZero() {
			String str;
			assertEquals(0, str.length());
		}

		@Test
		@DisplayName("upper case is empty")
		void uppercaseIsEmpty() {
			assertEquals("", str.toUpperCase());
		}
	//  JUnit Patterns - xunitpatterns
// JUnit 5 = Platform + Jupiter + Vintage
		
	
}}
