import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class ShapeTest {
	
	private Screen screen = new Screen();
	private List<Integer> parameters = new ArrayList<Integer>();

	@Test
	public void addShapeTest() {
		parameters.add(4);
		parameters.add(6);
		assertTrue(screen.addShape(ShapeType.Rectangle, new Point(2, 3), parameters));
		parameters.clear();
		parameters.add(4);
		assertTrue(screen.addShape(ShapeType.Square, new Point(2, 3), parameters));
		assertTrue(screen.addShape(ShapeType.Circle, new Point(2, 3), parameters));
	}
	
	@Test
	public void deleteShapeTest(){
		parameters.add(4);
		parameters.add(6);
		assertTrue(screen.addShape(ShapeType.Rectangle, new Point(2, 3), parameters));
		assertTrue(screen.deleteShape(ShapeType.Rectangle, new Point(2, 3), parameters));
	}
}
