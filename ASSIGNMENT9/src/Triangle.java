import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
public class Triangle implements Shape{
	
	Point originPoint;
	int base;
	int height;
	Timestamp timestamp;
	
	public Triangle(Point originPoint, List<Integer> parameters, Timestamp timestamp) {
		this.originPoint = originPoint;
		this.base = parameters.get(0);
		this.height = parameters.get(1);
		this.timestamp = timestamp;
	}
	
	@Override
	public double getArea() {
		double s = getPerimeter()/2;
		return (height * base) / 2;			
	}

	@Override
	public double getPerimeter() {
		return  (3 * base);
	}

	@Override
	public Point getOrigin() {
		return originPoint;
	}

	@Override
	public List<Integer> getParameters() {
		List<Integer> parameters = new ArrayList<Integer>();
		parameters.add(base);
		parameters.add(height);
		return parameters;
	}
	
	@Override
	public Timestamp getTimestamp() {
		return timestamp;
	}
	
	@Override
	public ShapeType getShapeType() {
		return ShapeType.Triangle;
	}

	@Override
	public boolean isPointEnclosed(Point point) {
		return false;
	}	
}
