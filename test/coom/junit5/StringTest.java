package coom.junit5;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

class StringTest {

	@Test
	void whateveryouwant() {
		
		// the name of the test method doesn't matter, but it should be annotated with @Test 
	// write test code 
		//invoke a method
		//check in junit called Assertions.
	}

	
	@Test
	void containsBasic() {
		String abc = "abc";
		boolean result = abc.contains("abc");
		assertFalse(result);
		}
}
