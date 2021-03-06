/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms. By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
 *
 * @author jake
 */

public class EvenFibonacciNumbers {
	public static void main(String[] args){

		System.out.println(findEvenFibonacci(4_000_000)); // 4613732
	}

	public static int findEvenFibonacci(int limit){
		int sum = 0;
		int tempA = 1;
		int tempB = 0;
		for (int i = 1; i < limit; i=i){
			tempB = tempA;
			tempA = i;
			i = tempA + tempB;
			if (i % 2 == 0){
				sum += i;
			}
		}
		return sum;
	}
}