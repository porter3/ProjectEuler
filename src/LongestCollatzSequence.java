/*
 * The following iterative sequence is defined for the set of positive integers:
 * 
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 * 
 * Using the rule above and starting with 13, we generate the following sequence:
 * 
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * 
 * Which starting number, under one million, produces the longest chain?
 * 
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */


public class LongestCollatzSequence {

	public static void main(String[] args) {
		System.out.println(findLongestCollatzSequence(1_000_000)); // 837799
	}

	private static long findLongestCollatzSequence(int limit) {
		
		long collatzNum;
		long chainCount;
		long highestChainCount = 0;
		long longestChainNum = 0;
		for (long i = 2; i < limit; i++) {
			collatzNum = i;
			chainCount = 0;
			while (collatzNum != 1) {
				if (collatzNum % 2 == 0) {
					collatzNum = collatzNum / 2;
				}
				else {
					collatzNum = 3 * collatzNum + 1;
				}
				chainCount++;
				if (chainCount > highestChainCount) {
					highestChainCount = chainCount;
					longestChainNum = i;
				}
			}
		}
		return longestChainNum;
	}
}
