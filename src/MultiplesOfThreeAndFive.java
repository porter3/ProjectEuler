/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 * @author jake
 */

public class MultiplesOfThreeAndFive {
	public static void main(String[] args){

		System.out.println(sumMultiplesOfThreeAndFive(1000)); // 233168
	}

	public static int sumMultiplesOfThreeAndFive(int limit){
		int sum = 0;
		for (int i = 0; i < limit; i++){
			if((i % 3 == 0) || (i % 5 == 0)){
				sum += i;
			}
		}
		return sum;
	}
}