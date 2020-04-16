package helpers;

public class PrimeChecker {

	public static boolean isPrime(long x){
		for (long i = 2; i < x; i++){
			if (x % i == 0){
				return false;
			}
		}
		return true;
	}
}
