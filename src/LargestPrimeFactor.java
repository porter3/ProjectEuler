/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600851475143 ?
 *
 * @author jake
 */

public class LargestPrimeFactor {
	public static void main(String[] args){

		System.out.println(largestPrime(600_851_475_143L)); // 6857
	}

	private static long largestPrime(long x){
		for (long i = 2; i < x; i++){
			if (x % i == 0 && isPrime(x / i)){
				return x / i;
			}
		}
		return 0; // indicates number doesn't have a prime factor
	}

	private static boolean isPrime(long x){
		for (long i = 2; i < x; i++){
			if (x % i == 0){
				return false;
			}
		}
		return true;
	}
}