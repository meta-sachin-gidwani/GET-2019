import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

	@RunWith(Parameterized.class)
	public class MathOperationTest {
	    @Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {     
	                 { 4, 16, 16 }, { 4, 6, 12 }, { 14, 6, 42 },{ 2, 3, 6 }  
	           });
	    }

	    private int fInput1;
	    private int fInput2;
	    private int fExpected;

	    public MathOperationTest(int Input1, int Input2, int expected) {
	        this.fInput1 = Input1;
	        this.fInput2 = Input2;
	        this.fExpected = expected;
	    }

	@Test
	public void lcmMethodTest() {
		assertEquals(fExpected, MathOperation.lcmOfNumbers(fInput1, fInput2));
	}
	
	@Test
	public void hcfMethodTest() {
		assertEquals( 2, MathOperation.hcfOfNumbers(4, 6));
		assertEquals( 4, MathOperation.hcfOfNumbers(4, 16));
		assertEquals( 2, MathOperation.hcfOfNumbers(14, 6));
		assertEquals( 1, MathOperation.hcfOfNumbers(7, 11));
	}

}
