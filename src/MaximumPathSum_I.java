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
				"04 62 98 27 23 09 70 98 73 93 38 53 60 04 23", 15
			)
		);
	}
	
	private static int findMaximumPathSum(String triangleStr, int levels) {
		String[] triangleStrArr = triangleStr.split("\\s");
		
		// convert triangle to 2D array of ints
		int[][] triangle = new int [levels][];
		int triangleIterator = 0;
		// iterate over level (row)
		for (int i = 0; i < levels; i++) {
			// create a new array for each level
			triangle[i] = new int[i + 1];
			// iterate over each element in level
			for (int j = 0; j < i + 1; j++) {
				triangle[i][j] = Integer.parseInt(triangleStrArr[triangleIterator]);
				System.out.print(triangle[i][j] + " ");
				triangleIterator++;
			}
			System.out.println();
		}
		
		int maxPathSum = 0;
		int pathSum = 0;
		int greaterParent = 0;
		int rowIndex;
		// the indices of an element's 'children' will be: (that element's index + the child's row), (that element's index + the child's row + 1)
		
		// using a 'bottoms-up' approach to avoid trying every path. Should be able to achieve that trying the greatest path from each element in the bottom row
		
		// iterate over an element on the bottom level
		for (int i = 0; i < levels; i++) {
			pathSum = triangle[levels - 1][i];
			rowIndex = i;
			// iterate over the path to the top
			for (int j = levels; j > 0; j--) {
				System.out.println("current row: " + (j - 1));
				// conditionals for if an element is at the beginning or end of the row (avoiding IndexOutOfBounds)
				int parentA = rowIndex != 0 ? triangle[j - 2][rowIndex - 1] : 0;
				int parentB = rowIndex != (triangle[j - 1].length - 1) ? triangle[j - 2][rowIndex] : 0;
				if (parentA > parentB) {
					greaterParent = parentA;
					rowIndex -= 1;
				} else {
					greaterParent = parentB;
				}
				System.out.println("Greater parent: " + greaterParent);
				pathSum += greaterParent;
			}
			if (pathSum > maxPathSum) {
				maxPathSum = pathSum;
			}
		}
		
		return maxPathSum;
	}

}
