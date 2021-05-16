import static org.junit.Assert.*;

import org.junit.Test;


public class SearchNumberTest {

	@Test
	public void elementExistInArrayLinearSearch() {
	assertEquals( 3, SearchNumber.linearSearch(new int[]{1, 2, 3, 4, 5},3));
	assertEquals( 6, SearchNumber.linearSearch(new int[]{1, 2, 10, 5, 4, 3},3));
	assertEquals( 1, SearchNumber.linearSearch(new int[]{11, 21, 33, 40, 58},11));
	assertEquals( 2, SearchNumber.linearSearch(new int[]{7, 27, 32, 41, 50},27));
	}

	@Test
	public void elementNotExistInArrayLinearSearch() {
		try {
			assertEquals(3, SearchNumber.linearSearch(new int[]{1, 2, 3, 4, 5},7));
		} catch (AssertionError e) {
			System.out.println("Element is not Exist in Array\n"+e);
		}
	}
	
	@Test
	public void elementExistInArrayBinarySearch() {
	assertEquals( 3, SearchNumber.binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7},3));
	assertEquals( 6, SearchNumber.binarySearch(new int[]{1, 2, 7, 10, 14, 31},31));
	assertEquals( 1, SearchNumber.binarySearch(new int[]{11, 21, 33, 40, 58},11));
	assertEquals( 2, SearchNumber.binarySearch(new int[]{7, 27, 32, 41, 50},27));
	}
	
	@Test
	public void elementNotExistInArrayBinarSearch() {
		try {
			assertEquals(3, SearchNumber.binarySearch(new int[]{1, 2, 3, 4, 5},7));
		} catch (Exception e) {
			System.out.println("Element is not Exist in Array\n"+e);
		}
	}
}
