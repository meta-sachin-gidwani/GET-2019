import java.util.Scanner;

public class Marksheet {

	public static void main(String[] args) {
		System.out.println("no of students : ");
		Scanner scanner=new Scanner(System.in);
		int noOfStudents=0; //no of students initialize
		try {
			noOfStudents=scanner.nextInt();
		} catch (Exception e) {
			System.out.println("please enter valid number");
		}
		float[] grades=new float[noOfStudents];
		float grade=0;
		for(int i=0;i<noOfStudents;i++) {
			System.out.print("enter grades of student "+(i+1)+" : ");
			try {
				grade=scanner.nextInt();
				if(grade>=0&&grade<=100)
					grades[i]=grade;
				else {
					System.out.println("grades should be between 1 to 100");
				}
			} catch (Exception e) {
				System.out.println("please enter valid number");
			}
		}
		System.out.printf("average of all grades : %.2f\nmaximum of all grades : %.2f\nminimum of all grades : %.2f\npercentage of students passed : %.2f",averageOfGrades(grades),maxOfGrades(grades),minOfGrades(grades),perOfStudentsPass(grades));
		//floating-point values upto 2 decimal places
	}

	/**
	 * @param grades of students
	 * @return average of grades
	 */
	private static float averageOfGrades(float[] grades) {
		float average=0;
		for(int i=0;i<grades.length;i++) {
			average+=average+grades[i];
		}
		average=average/grades.length; //average of grades
		return average;
	}

	/**
	 * @param grades of students
	 * @return maximum of grades
	 */
	private static float maxOfGrades(float[] grades) {
		float maxGrade=grades[0];
		for(int i=1;i<grades.length;i++) {
			if(maxGrade<grades[i])
				maxGrade=grades[i];
		}
		return maxGrade;
	}

	/**
	 * @param grades of students
	 * @return minimum of grades
	 */
	private static float minOfGrades(float[] grades) {
		float minGrade=grades[0];
		for(int i=1;i<grades.length;i++) {
			if(minGrade>grades[i])
				minGrade=grades[i];
		}
		return minGrade;
	}

	/**
	 * @param grades of students
	 * @return percentage of passed students which have grades more than or equal to 40
	 */
	private static float perOfStudentsPass(float[] grades) {
		float percentage;
		int passedStudent=0;
		for(int i=0;i<grades.length;i++) {
			if(grades[i]>=40)
				passedStudent++;
		}
		percentage=((float)passedStudent/grades.length)*100; //percentage formula
		return percentage;
	}

}
