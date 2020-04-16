import helpers.PrimeChecker;

/*
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 */

// Takes a little while longer. Will try and see if there's a more efficient solution in the future.

public class SummationOfPrimes {
	public static void main(String[] args) {
		
		System.out.println(findSummationOfPrimes(2_000_000));	// 142913828922
	}

	private static long findSummationOfPrimes(long n) {
		long sum = 0;
		for (long i = 2; i < n; i++) {
			System.out.println(i);
			if (PrimeChecker.isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}
}
