/*
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class SmallestMultiple {

	public static void main(String[] args) {
		System.out.println(findSmallestMultiple(20)); // 232792560
	}

	private static int findSmallestMultiple(int limit) {
		
		int n = 1;
		
		while (true) {
			for (int i = 1; i <= limit; i++) {
				if (n % i != 0) {
					break;
				}
				if (i == limit) {
					return n;
				}
			}
			n++;
		}
	}
}
