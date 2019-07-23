
public class MathOperation {

	/**
	 * @param num1 first number
	 * @param num2 second number
	 * @return L.C.M of num1 and num2
	 */
	public  static int lcmOfNumbers( int num1, int num2 ) {
		//find big number
		int bigNum = num1 > num2 ? num1 : num2;             
		if( num1 == 1 && num2 == 1)
			return 1;
		else{
			for( int factor = 2; factor <= bigNum; factor++){
				if( num1 % factor == 0 && num2 % factor == 0)
					//both number divisible by factor
					return factor * lcmOfNumbers( num1 / factor, num2 / factor );
				else if( num1 % factor == 0 )
					//only first number divisible by factor
					return factor * lcmOfNumbers(num1 / factor, num2);		
				else if( num2 % factor == 0 )
					//only second number divisible by factor
					return factor * lcmOfNumbers(num1, num2 / factor);
			}
			return bigNum;
		}                                   
	}

	/**
	 * @param num1 first number
	 * @param num2 second number
	 * @return H.C.F of num1 and num2 using Euclid’s algorithm
	 * Euclid’s algorithm based on fact that the H.C.F of num1 and num2 is same as hcf num2 and num1 % num2
	 */
	public static int hcfOfNumbers(int num1, int num2) {
		//check second number is zero
		if (num2 == 0) {                               
			return num1;
		}
		//using Euclid's algorithm
		return hcfOfNumbers(num2, num1 % num2);        
	}
}
