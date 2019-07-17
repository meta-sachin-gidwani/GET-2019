import static org.junit.Assert.*;

import org.junit.Test;


public class MaxMirrorTest {

	@Test
	public void test1() {
		assertEquals( 3,ArrOperation.maxMirror(new int[]{1, 2, 3, 8, 9, 3, 2, 1}));
		assertEquals( 2,ArrOperation.maxMirror(new int[]{7, 1, 4, 9, 7, 4, 1}));
		assertEquals( 3,ArrOperation.maxMirror(new int[]{1, 2, 1, 4}));
		assertEquals( 7,ArrOperation.maxMirror(new int[]{1, 4, 5, 3, 5, 4, 1}));
	}
	@Test
	public void test2(){
		try {
			ArrOperation.maxMirror(new int[]{});
		} catch (AssertionError e) {
			System.out.println("Array is empty");
		}
	}

}
