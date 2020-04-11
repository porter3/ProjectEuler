/*
 * The sum of the squares of the first ten natural numbers is:
 * 1^2 + 2^2 + ... + 10^2 = 385
 * 
 * The square of the sum of the first ten natural numbers is:
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 * 
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class SumSquareDifference {
	public static void main(String[] args) {

		System.out.println(findSumSquareDiff(100)); // 25164150
	}
	
	private static long findSumSquareDiff(long range) {
		long regularSum = 0;
		long sumOfSquares = 0;
		for (long i = 1; i <= range; i++) {
			regularSum += i;
			sumOfSquares += i*i;
		} 
		return (regularSum * regularSum) - sumOfSquares;
	}

}
