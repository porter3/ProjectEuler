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
			letterCount += getLetterCountSingleDigit(digits[0]);
		}
		
		// if the number has two digits:
		if (digits.length == 2) {
			// if the number is between 11 and 19 inclusive:
			if (digits[0] == 1) {
				letterCount += getLetterCountTenToNineteen(digits[1]);
			}
			else {
				letterCount += getLetterCountTwentyToNinety(digits[0]);
				if (digits[1] != 0) {
					letterCount += getLetterCountSingleDigit(digits[1]);
				}
			}
		}
		
		if (digits.length == 3) {
			letterCount += getLetterCountSingleDigit(digits[0]);
			letterCount += 7; // # of letters in "hundred"
			
			// number has non-zero digits after the first digit
			if (digits[1] != 0 || digits[2] != 0) {
				letterCount += 3; // # of letters in "and"
			
				// if the remaining two digits are between 10 and 19 inclusive:
				if (digits[1] == 1) {
					letterCount += getLetterCountTenToNineteen(digits[2]);
				}
				else if (digits[1] > 1) {
					letterCount += getLetterCountTwentyToNinety(digits[1]);
					// if the last digit is not 0:
					if (digits[2] != 0) {
						letterCount += getLetterCountSingleDigit(digits[2]);
					}
				}
				// if ONLY the last digit is not zero:
				else {
					letterCount += getLetterCountSingleDigit(digits[2]);
				}
			}
		}
		
		if (digits.length == 4) {
			letterCount += getLetterCountSingleDigit(digits[0]);
			letterCount += 8; // # of letter in "thousand"
		}
		
		return letterCount;
	}
	
	
	private static int getLetterCountSingleDigit(int digit) {
		switch(digit) {
			case 1:
				return 3;
			case 2:
				return 3;
			case 3:
				return 5;
			case 4:
				return 4;
			case 5:
				return 4;
			case 6:
				return 3;
			case 7:
				return 5;
			case 8:
				return 5;
			case 9:
				return 4;
			default:
				return 0;
			
		}
	}
	
	private static int getLetterCountTenToNineteen(int secondDigit) {
		// Number is ten for case 0, eleven for case 1, etc.
		switch(secondDigit) {
			case 0:
				return 3;
			case 1:
				return 6;
			case 2:
				return 6;
			case 3:
				return 8;
			case 4:
				return 8;
			case 5:
				return 7;
			case 6:
				return 7;
			case 7:
				return 9;
			case 8:
				return 8;
			case 9:
				return 8;
			default:
				return 0;
		}
	}
	
	private static int getLetterCountTwentyToNinety(int firstDigit) {
		switch(firstDigit) {
			case 2:
				return 6;
			case 3:
				return 6;
			case 4:
				return 5;
			case 5:
				return 5;
			case 6:
				return 5;
			case 7:
				return 7;
			case 8:
				return 6;
			case 9:
				return 6;
			default:
				return 0;
		}
	}
	
	private static int[] toIntArray(int n) {
		String intString = Integer.toString(n);
		int[] intArr = new int[intString.length()];
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = intString.charAt(i) - '0';
		}
		return intArr;
	}
}