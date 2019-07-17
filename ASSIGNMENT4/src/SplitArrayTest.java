import static org.junit.Assert.*;
import org.junit.Test;

public class SplitArrayTest {

	@Test
	public void splitArrayNotContainError() {
		assertEquals( 3, ArrOperation.splitArray( new int[]{1, 1, 1, 2, 1}));
		assertEquals( -1, ArrOperation.splitArray( new int[]{2, 1, 1, 2, 1}));
		assertEquals( 1, ArrOperation.splitArray( new int[]{10, 10}));
		assertEquals( -1, ArrOperation.splitArray( new int[]{1}));
	}
	
	@Test
	public void splitArrayContainEmptyArray(){
		try {
			ArrOperation.splitArray(new int[]{});
		} catch (AssertionError e) {
			System.out.println("Array is empty\n" + e);
		}
	}
}
