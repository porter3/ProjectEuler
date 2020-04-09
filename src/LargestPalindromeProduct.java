import java.util.Arrays;

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * @author jake
 */
public class LargestPalindromeProduct {
	public static void main(String[] args){

		System.out.println(calculateLargestPalindrome()); // 906609
	}

	public static int calculateLargestPalindrome(){
		int largestPalindrome = 0;
		int product;
		for (int i = 100; i < 1000; i++){
			for (int j = 100; j < 1000; j++){
				product = i * j;
				if (isPalindromeNumber(product) && product > largestPalindrome){
					largestPalindrome = product;
				}
			}
		}
		return largestPalindrome;
	}

	public static boolean isPalindromeNumber(int n){
		char[] originalOrder = Integer.toString(n).toCharArray();
		char[] reversedOrder = new char[originalOrder.length];

		for (int i = 0; i < originalOrder.length; i++){
			reversedOrder[i] = originalOrder[originalOrder.length - i - 1];
		}
		return Arrays.equals(originalOrder, reversedOrder);
	}
}
