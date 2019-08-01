package question1;
import static org.junit.Assert.*;
import org.junit.Test;

public class EvaluationTest {

	@Test
	public void evaluationWithValidInput() {
		InfixEvaluation expression = new InfixEvaluation("( 2 + 3 ) / 4 % 5 > 2 || 3 < 1 && 3 > 1 ");
		assertEquals("false", expression.evaluate());	
	}

	@Test(expected = AssertionError.class)
	public void evaluationWithInvalidInput() {
		InfixEvaluation expression1 = new InfixEvaluation("( 2 + 3 ) / 0 % 5 > 2 || 3 < 1 && 3 > 1 ");
		expression1.evaluate();
		InfixEvaluation expression2 = new InfixEvaluation("( 2 + 3 )) / 0 % 5 > 2 || 3 < 1 && 3 > 1 ");
		expression2.evaluate();
	}
}
