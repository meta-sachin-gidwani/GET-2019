import java.util.Scanner;

public class HexCalc {
	/*
	 * HexCalc calculate two hexadecimal numbers convert hexadecimal to decimal
	 * convert decimal to hexadecimal
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("first hexadecimal : ");
		String firstHexNum = scanner.nextLine();
		System.out.println("second hexadecimal : ");
		String secondHexNum = scanner.nextLine();
		if (isValidHex(firstHexNum) && isValidHex(secondHexNum)) {
			int task = 0;
			do {
				System.out.println("\n1.add 2.subtract 3.multiple 4.divide 5.compare 6.Exit\nwhat you want to do : ");
				try {
					task = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("invalid action");
				}
				// task for hexadecimal numbers
				switch (task) {
				case 1:

					System.out.println(add(firstHexNum, secondHexNum));
					break;
				case 2:
					System.out.println(subtract(firstHexNum, secondHexNum));
					break;
				case 3:
					System.out.println(multiple(firstHexNum, secondHexNum));
					break;
				case 4:
					System.out.println(divide(firstHexNum, secondHexNum));
					break;
				case 5:
					System.out.println(compare(firstHexNum, secondHexNum));
					break;
				default:
					break;
				}
			} while (task != 6);
		} else
			System.out.println("invalid hexadecimal numbers");
	}
        // compare two hexadecimal numbers
	private static String compare(String firstHexNum, String secondHexNum) {
		if (isValidHex(firstHexNum) && isValidHex(secondHexNum)) {
			firstHexNum=removeZero(firstHexNum);
			secondHexNum=removeZero(secondHexNum);
			int firstNumLength = firstHexNum.length();
			int secondNumLength = secondHexNum.length();
			if (firstNumLength > secondNumLength)
				return "first number is greater than second";
			else if (secondNumLength > firstNumLength)
				return "second number is greater than first";
			else {
				firstHexNum = firstHexNum.toUpperCase();
				secondHexNum = secondHexNum.toUpperCase();
				for (int i = 0; i < firstNumLength; i++) {
					if (firstHexNum.charAt(i) > secondHexNum.charAt(i))
						return "first number is greater than second";
					if (secondHexNum.charAt(i) > firstHexNum.charAt(i))
						return "second number is greater than first";
				}
				return "both numbers are equal";
			}
		}else
			return "invalid hexadecimal numbers";
	}
        //remove intial zeros in hexadecimal number
	private static String removeZero(String hexNum) {
		StringBuilder newHex=new StringBuilder();
		int i;
		for(i=0;i<hexNum.length();i++){
			if(hexNum.charAt(i)!='0')
			  break;
		}
		for(int j=i;j<hexNum.length();j++)
			newHex.append(hexNum.charAt(j));
		return (newHex.toString());
	}
        // divide two hexadecimal numbers
	private static String divide(String firstHexNum, String secondHexNum) {
		long firstNum = hexToDecimal(firstHexNum);
		long secondNum = hexToDecimal(secondHexNum);
		return decimalToHex(firstNum / secondNum);
	}
        // multiple two hexadecimal numbers
	private static String multiple(String firstHexNum, String secondHexNum) {
		long firstNum = (long)hexToDecimal(firstHexNum);
		long secondNum = (long)hexToDecimal(secondHexNum);
		return decimalToHex((long) firstNum * secondNum);
	}
        // subtract two hexadecimal numbers
	private static String subtract(String firstHexNum, String secondHexNum) {
		long firstNum = hexToDecimal(firstHexNum);
		long secondNum = hexToDecimal(secondHexNum);
		if (firstNum > secondNum)
			return decimalToHex(firstNum - secondNum);
		else
			return "first number should be greater than second number";
	}
        // add two hexadecimal numbers
	private static String add(String firstHexNum, String secondHexNum) {
		long firstNum = hexToDecimal(firstHexNum);
		long secondNum = hexToDecimal(secondHexNum);
		return decimalToHex(firstNum + secondNum);
	}
        // convert hexadecimal to decimal
	public static long hexToDecimal(String hexNum) {
		String digits = "0123456789ABCDEF";
		hexNum = hexNum.toUpperCase();
		int val = 0;
		for (int i = 0; i < hexNum.length(); i++) {
			char c = hexNum.charAt(i);
			int d = digits.indexOf(c);
			val = 16 * val + d;
		}
		return val;
	}
        // covert decimal to hexadecimal
	public static String decimalToHex(long decimalNum) {
		int rem;
		String hex = "";
		char hexchars[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9','A', 'B', 'C', 'D', 'E', 'F' };
		if (decimalNum == 0)
			return 0 + "";
		while (decimalNum > 0) {
			rem = (int) (decimalNum % 16);
			hex = hexchars[rem] + hex;
			decimalNum = decimalNum / 16;
		}
		return hex;
	}
        // check valid hexadecimal number or not
	public static boolean isValidHex(String hexNum) {
		hexNum = hexNum.toUpperCase();
		for (int i = 0; i < hexNum.length(); i++) {
			char c = hexNum.charAt(i);
			if (c < '0' || (c > '9' && c < 'A') || c > 'F')
				return false;
		}
		return true;
	}
	

}
