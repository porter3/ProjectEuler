/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * 
 * What is the sum of the digits of the number 2^1000?
 */

import java.math.BigDecimal;
import helpers.StringSplitter;

public class PowerDigitSum {

	public static void main(String[] args) {

		System.out.println(calculatePowerDigitSum(2, 1000));	// 1366
	}
	
	private static int calculatePowerDigitSum(int base, int exponent) {
		
		int powerDigitSum = 0;
		BigDecimal power = new BigDecimal(String.valueOf(base)).pow(exponent);
		String[] powerStringArr = StringSplitter.splitByChar(power.toString());
		for (int i = 0; i < powerStringArr.length; i++) {
			powerDigitSum += Integer.parseInt(powerStringArr[i]);
		}
		return powerDigitSum;
	}
	
}
