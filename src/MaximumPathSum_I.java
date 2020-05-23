import java.util.Arrays;

/*
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * 
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 * 
 * That is, 3 + 7 + 4 + 9 = 23.
 * 
 * Find the maximum total from top to bottom of the triangle below:
 * 
 *                75
 *               95 64
 *              17 47 82
 *            18 35 87 10
 *           20 04 82 47 65
 *          19 01 23 75 03 34
 *         88 02 77 73 07 63 67
 *        99 65 04 28 06 16 70 92
 *       41 41 26 56 83 40 80 70 33
 *      41 48 72 33 47 32 37 16 94 29
 *     53 71 44 65 25 43 91 52 97 51 14
 *    70 11 33 28 77 73 17 78 39 68 17 57
 *   91 71 52 38 17 14 91 43 58 50 27 29 48
 *  63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 * 
 * NOTE: As there are only 16384 routes, it is possible to solve this problem by trying every route.
 * However, Problem 67 is the same challenge with a triangle containing one-hundred rows; it cannot be solved by brute force, and requires a clever method!
 */
public class MaximumPathSum_I {

	public static void main(String[] args) {
		System.out.println(
			findMaximumPathSum(
				               "75 " + 
				              "95 64 " +
				             "17 47 82 " +
				            "18 35 87 10 " +
				           "20 04 82 47 65 " +
				          "19 01 23 75 03 34 " +
				         "88 02 77 73 07 63 67 " +
				        "99 65 04 28 06 16 70 92 " +
				      "41 41 26 56 83 40 80 70 33 " +
				     "41 48 72 33 47 32 37 16 94 29 " +
				    "53 71 44 65 25 43 91 52 97 51 14 " +
				   "70 11 33 28 77 73 17 78 39 68 17 57 " +
				  "91 71 52 38 17 14 91 43 58 50 27 29 48 " +
				 "63 66 04 68 89 53 67 30 73 16 69 87 40 31 " +
				"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23", 15, " "
			)
		);	// 1074
	}
	
	private static int findMaximumPathSum(String triangleStr, int rows, String delimiter) {
		int[][] triangle = toTriangleArray(triangleStr, rows, delimiter);

		// initialize buffer row with the bottom row's values
		int[] bufferRow = Arrays.copyOf(triangle[rows - 1], rows);

		/*
		Using a 'bottoms-up' approach to avoid trying every path.
		Each iteration will compare i and i+1 of the elements of a buffer array
		which will be initialized with the elements of the bottom row.
		Whichever element is greater will be added to the ith element of the row above
		and stored in the buffer array at the ith index.
		 */
		
		// iterate over bottom row of triangle
		for (int i = rows; i > 1; i--) {
			// iterate over each element in buffer row
			for (int j = 0; j < i - 1; j++) {
				if (bufferRow[j] > bufferRow[j + 1]) {
					bufferRow[j] = bufferRow[j] + triangle[i - 2][j];
				} else {
					bufferRow[j] = bufferRow[j + 1] + triangle[i - 2][j];
				}
			}
		}
		return Arrays.stream(bufferRow).max().getAsInt();
	}

	private static int[][] toTriangleArray(String triangleStr, int rows, String delimiter) {
		String[] triangleStrArr = triangleStr.split(delimiter);

		// convert triangle to 2D array of ints
		int[][] triangle = new int [rows][];
		int triangleIterator = 0;
		// iterate over row
		for (int i = 0; i < rows; i++) {
			// create a new array for each row
			triangle[i] = new int[i + 1];
			// iterate over each element in row and assign int value
			for (int j = 0; j < i + 1; j++) {
				triangle[i][j] = Integer.parseInt(triangleStrArr[triangleIterator]);
				triangleIterator++;
			}
		}
		return triangle;
	}
}
