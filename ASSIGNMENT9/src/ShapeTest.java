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

	@Test
	public void pointEnclosingTest(){
		parameters.add(4);
		parameters.add(6);
		assertTrue(screen.addShape(ShapeType.Rectangle, new Point(2, 3), parameters));
		List<Shape> shapeList = screen.shapeEnclosingPoint(new Point(3, 4));
		assertEquals(shapeList.get(0).getShapeType(), screen.shapeList.get(0).getShapeType());
	}

	@Test
	public void sortByAreaTest(){
		parameters.add(3);
		screen.addShape(ShapeType.Square,new Point(1,3), parameters );
		parameters.add(6);
		screen.addShape(ShapeType.Rectangle,new Point(3,5), parameters );	
		assertEquals(screen.sortByArea().get(0).getShapeType(), ShapeType.Square);
		assertEquals(screen.sortByArea().get(1).getShapeType(), ShapeType.Rectangle);
	}
	
	@Test
	public void sortByPerimeterTest(){
		parameters.add(3);
		screen.addShape(ShapeType.Square,new Point(1,3), parameters );
		parameters.add(6);
		screen.addShape(ShapeType.Rectangle,new Point(3,5), parameters );
		assertEquals(screen.sortByPerimeter().get(0).getShapeType(), ShapeType.Square);
		assertEquals(screen.sortByPerimeter().get(1).getShapeType(), ShapeType.Rectangle);
	}
	
	@Test
	public void sortByTimestampTest(){
		parameters.add(3);
		screen.addShape(ShapeType.Square,new Point(1,3), parameters );
		parameters.add(6);
		screen.addShape(ShapeType.Rectangle,new Point(3,5), parameters );
		assertEquals(screen.sortByTimestamp().get(0).getShapeType(), ShapeType.Square);
		assertEquals(screen.sortByTimestamp().get(1).getShapeType(), ShapeType.Rectangle);
	}
	
	@Test
	public void sortByOriginDistanceTest(){
		parameters.add(3);
		screen.addShape(ShapeType.Square,new Point(1,3), parameters );
		parameters.add(6);
		screen.addShape(ShapeType.Rectangle,new Point(3,5), parameters );
		assertEquals(screen.sortByOriginDistance().get(0).getShapeType(), ShapeType.Square);
		assertEquals(screen.sortByOriginDistance().get(1).getShapeType(), ShapeType.Rectangle);
	}
}
