/**
 * Package containing the class
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class TravellerAlgorithm {

	/**
	 * This method calculate the distances between cities.
	 * <b>pre</b>The arrays must have at least one value.<br>
	 * <b>post</b>The traveler have to return to the origin.<br>
	 * @param a is an array. a must be != " " and != null.
	 * @param start is the origin. start must be != null and >= 0. 
	 * @return the distance travelled.
	 */
	
	public int travel(int a[][], int start) {
		int n = a.length;
		int row = 1 << n;
		int table[][] = new int[row][n];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < n; j++) {
				table[i][j] = -1;
			}
		}

		int minResult = util(a, table, 1, start, start);

		return minResult;
	}

	/**
	 * This method calculate the amount between two nodes. 
	 * <b>pre</b>The matrixes must have at least one value.<br>
	 * <b>post</b>The method calculate a minimum distance.<br>
	 * @param a is an array. a must be != " " and != null.
	 * @param table is an array. table must be != " " and != null.
	 * @param mask is the mask. mask must be != null and >= 0. 
	 * @param pos  is the position. mask must be != null and >= 0. 
	 * @param start is the origin. start must be != null and >= 0. 
	 * @return a distance.
	 */
	
	public int util(int a[][], int table[][], int mask, int pos, int start) {

		if (mask == ((1 << a.length) - 1)) {
			return a[pos][start];
		}
		if (table[mask][pos] != -1) {
			return table[mask][pos];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if ((mask & (1 << i)) == 0) {
				int temp = a[pos][i] + util(a, table, (mask | (1 << i)), i, start);
				ans = Math.min(ans, temp);
			}
		}
		table[mask][pos] = ans;
		return ans;
	}
}
