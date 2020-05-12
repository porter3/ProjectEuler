import java.util.Map;

/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * 
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 * 
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 */

public class NumberLetterCounts {

	public static void main(String[] args) {
		System.out.println(calculateNumberLetterSum(1000));	// 21124
	}

	// limit is inclusive, currently won't work above 1000
	private static int calculateNumberLetterSum(int limit) {
		int letterSum = 0;
		for (int i = 1; i <= limit; i++) {
			letterSum += getLetterCount(i);
		}
		return letterSum;
	}
	
	private static int getLetterCount(int n) {
		int[] digits = toIntArray(n);
		int letterCount = 0;
		
		// if the number has one digit:
		if (digits.length == 1) {
			letterCount += singleDigitCounts.get(digits[0]);
		}
		
		// if the number has two digits:
		if (digits.length == 2) {
			// if the number is between 11 and 19 inclusive:
			if (digits[0] == 1) {
				letterCount += tenToNineteenCounts.get(digits[1]);
			}
			else {
				letterCount += twentyToNinetyCounts.get(digits[0]);
				if (digits[1] != 0) {
					letterCount += singleDigitCounts.get(digits[1]);
				}
			}
		}
		
		if (digits.length == 3) {
			letterCount += singleDigitCounts.get(digits[0]);
			letterCount += 7; // # of letters in "hundred"
			
			// number has non-zero digits after the first digit
			if (digits[1] != 0 || digits[2] != 0) {
				letterCount += 3; // # of letters in "and"
			
				// if the remaining two digits are between 10 and 19 inclusive:
				if (digits[1] == 1) {
					letterCount += tenToNineteenCounts.get(digits[2]);
				}
				else if (digits[1] > 1) {
					letterCount += twentyToNinetyCounts.get(digits[1]);
					// if the last digit is not 0:
					if (digits[2] != 0) {
						letterCount += singleDigitCounts.get(digits[2]);
					}
				}
				// if ONLY the last digit is not zero:
				else {
					letterCount += singleDigitCounts.get(digits[2]);
				}
			}
		}
		
		if (digits.length == 4) {
			letterCount += singleDigitCounts.get(digits[0]);
			letterCount += 8; // # of letters in "thousand"
		}
		
		return letterCount;
	}
	
	private static int[] toIntArray(int n) {
		String intString = Integer.toString(n);
		int[] intArr = new int[intString.length()];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = intString.charAt(i) - '0';
		}
		return intArr;
	}
	
	private static Map<Integer, Integer> singleDigitCounts = Map.of(
		1, 3,
		2, 3,
		3, 5,
		4, 4,
		5, 4,
		6, 3,
		7, 5,
		8, 5,
		9, 4			
	);
	
	private static Map<Integer, Integer> tenToNineteenCounts = Map.of(
		0, 3,
		1, 6,
		2, 6,
		3, 8,
		4, 8,
		5, 7,
		6, 7,
		7, 9,
		8, 8,
		9, 8
	);
	
	private static Map<Integer, Integer> twentyToNinetyCounts = Map.of(
		2, 6,
		3, 6,
		4, 5,
		5, 5,
		6, 5,
		7, 7,
		8, 6,
		9, 6
	);
	
}