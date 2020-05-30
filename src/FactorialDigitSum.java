/*
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 *
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

import java.math.BigDecimal;

public class FactorialDigitSum {
    public static void main(String[] args) {
        System.out.println(getFactorialDigitSum(100));  // 648
    }

    private static int getFactorialDigitSum(int number) {
        int digitSum = 0;
        BigDecimal factorial = getFactorial(number);
        // split factorial into array of ints
        String factorialStr = factorial.toString();
        for (int i = 0; i < factorialStr.length(); i++) {
            digitSum += Character.getNumericValue(factorialStr.charAt(i));
        }
        return digitSum;
    }

    private static BigDecimal getFactorial(int number) {
        BigDecimal factorial = new BigDecimal("1");
        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(new BigDecimal(Integer.toString(i)));
        }
        return factorial;
    }
}
