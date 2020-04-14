/*
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a2 + b2 = c2.
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 * 
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 */

public class SpecialPythagoreanTriplet {
	public static void main(String[] args) {

		System.out.println(findPythagoreanTripletProduct(1000));	// 31,875,000
	}

	private static double findPythagoreanTripletProduct(int number) {
		double c;
		for (double i = 1; i < number / 2; i++) {
			for (double j = 1; j <= number / 2; j++) {
				c = findPartOfTriplet(i, j);
				if (i+j+c == number) {
					return i*j*c;
				}
			}
		}
		return 0;	// no Pythagorean triplet exists that would add up to the argument
	}
	
	private static double findPartOfTriplet(double a, double b) {
		return Math.sqrt((a*a) + (b*b));
	}
}
