import java.util.Scanner;

/**
 * @author Admin
 *
 */
public class StringOperations {

	public static void main(String[] args) {
		String str;
		System.out.print("enter string : ");
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();
		System.out.println("1.compare two strings\n2.reverse of string\n3.convert characters\n4.largest word in string");

		int task = 0;
		try {
			task = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("invalid action");
		}
		switch (task) {
		case 1:
			// another string for comparison
			System.out.print("another string : ");
			Scanner scanner1 = new Scanner(System.in);
			String str2 = scanner1.nextLine();
			System.out.println("" + compare(str, str2));
			break;
		case 2:
			System.out.println(reverse(str));
			break;
		case 3:
			System.out.println(convertCharacters(str));
			break;
		case 4:
			System.out.println(largestWord(str));
			break;
		default:
			break;
		}
	}

	/**
	 * @param str string
	 * @param str2 another string for comparison
	 * @return 1 if strings are equal else 0
	 */
	private static int compare(String str, String str2) {
		if (str.length() == str2.length()) {
			str = str.toUpperCase(); //for case insensitive comparison
			str2 = str2.toUpperCase();
			for (int i = 0; i < str.length() && i < str2.length(); i++) {
				if (str.charAt(i) != str2.charAt(i))
					return 0;
			}
			return 1;
		} else
			return 0;
	}

	/**
	 * @param str string for convert into reverse string
	 * @return reverse of str string
	 */
	private static String reverse(String str) {
		String revStr = "";
		for (int i = str.length() - 1; i >= 0; i--) 
			revStr += str.charAt(i);
		return revStr;
	}

	/**
	 * @param str string 
	 * @return convert string in which lower case character of str convert into upper case and vica-versa
	 */
	private static String convertCharacters(String str) {
		char ch = ' ';
		String convertStr = "";
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i); //check each character
			if (Character.isUpperCase(ch)) {
				ch = Character.toLowerCase(ch);
				convertStr += ch;
			} else if (Character.isLowerCase(ch)) {
				ch = Character.toUpperCase(ch);
				convertStr += ch;
			} else
				convertStr += ch;
		}
		return convertStr;
	}

	/**
	 * @param str string
	 * @return largest word of str string
	 */
	private static String largestWord(String str) {
		String largeStr = "";
		String[] words = new String[100];
		int length = 0;
		// Add extra space after string to get the last word in the given string
		str = str + " ";
		for (int i = 0; i < str.length(); i++) {
			// Split the string into words
			if (str.charAt(i) != ' ') {
				largeStr = largeStr + str.charAt(i);
			} else {
				// Add word to array words
				words[length] = largeStr;
				length++;
				largeStr = "";
			}
		}
		largeStr = words[0];
		for (int i = 0; i < length; i++) {
			if (largeStr.length() <= words[i].length())
				largeStr = words[i];
		}
		return largeStr;
	}

}
