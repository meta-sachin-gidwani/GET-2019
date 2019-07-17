import static org.junit.Assert.*;
import org.junit.Test;

public class CountClumpsTest {

	@Test
	public void countClumpsNotContainError() {
		assertEquals( 2, ArrOperation.countClumps( new int[]{1, 2, 2, 3, 4, 4}));
		assertEquals( 2, ArrOperation.countClumps( new int[]{1, 1, 2, 1, 1}));
		assertEquals( 1, ArrOperation.countClumps( new int[]{1, 1, 1, 1, 1}));
		assertEquals( 0, ArrOperation.countClumps( new int[]{1}));
	}
	
	@Test
	public void countClumpsContainEmptyArray(){
		try {
			ArrOperation.countClumps(new int[]{});
		} catch (AssertionError e) {
			System.out.println("Array is empty\n" + e);
		}
	}
}
