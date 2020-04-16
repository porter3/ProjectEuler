import helpers.PrimeChecker;

/*
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 */

public class _10001stPrime {
	public static void main(String[] args) {

		System.out.println("This thing is running");
		System.out.println(findNthPrime(10_001));	// 104743
	}
	
	private static long findNthPrime(int n){
		long i = 1;
		int primeCounter = 0;
		while (primeCounter <= n) {
			if (PrimeChecker.isPrime(i)) {
				primeCounter++; 
			}
			i++;
		}
		return i-1;
	}
	
}
