import java.util.Scanner;

public class Area {

	public static void main(String[] args) {
		double width,height,radius;//for all shape
		System.out.println("choose shape\n1.Triangle\n2.Rectangle\n3.Square\n4.Circle");
		int shape=0;
		try {
			shape=new Scanner(System.in).nextInt();
		} catch (Exception e) {
			System.out.println("invalid action");
		}
		try {
			switch (shape) {
			case 1:
				System.out.print("width : ");
				width=new Scanner(System.in).nextDouble();
				System.out.print("height : ");
				height=new Scanner(System.in).nextDouble();
				System.out.print("Area of triangle : "+areaOfTriangle(width,height));//are of triangle
				break;
			case 2:
				System.out.print("width : ");
				width=new Scanner(System.in).nextDouble();
				System.out.print("height : ");
				height=new Scanner(System.in).nextDouble();
				System.out.print("Area of rectangle : "+areaOfRectangle(width,height));
				break;
			case 3:
				System.out.print("width : ");
				width=new Scanner(System.in).nextDouble();
				System.out.print("Area of square : "+areaOfSquare(width));
				break;
			case 4:
				System.out.print("radius : ");
				radius=new Scanner(System.in).nextDouble();
				System.out.print("Area of circle : "+areaOfCircle(radius));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			System.out.println("please enter a valid number");
		}

	}

	/**
	 * @param width of triangle
	 * @param height of triangle
	 * @return area of triangle which is multipication of width and height multiple by 1/2
	 */
	private static double areaOfTriangle(double width, double height) {
		double area=(width*height)/2;
		return area;
	}

	/**
	 * @param width of rectangle
	 * @param height of rectangle
	 * @return area of rectangle which is width muliple by height of rectangle
	 */
	private static double areaOfRectangle(double width, double height) {
		double area=width*height;
		return area;
	}

	/**
	 * @param width of square
	 * @return area of square which is square of width
	 */
	private static double areaOfSquare(double width) {
		double area=width*width;
		return area;
	}

	/**
	 * @param radius of circle
	 * @return area of circle which is square of radius multiple by pi=3.14
	 */
	private static double areaOfCircle(double radius) {
		double pi=3.14;
		double area=pi*(radius*radius);
		return area;
	}

}
