/**
 * Package containing the class
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class BinomialCof {

	
	/**
	 * This method create a matrix to combine each row with each column. 
	 * <b>pre</b>The numbers would be integer.<br>
	 * <b>post</b>The maximum combination of the matrix would be show.<br>
	 * @param n is a number. n != null and n >= 0.
	 * @param k is a number. k != null and k >= 0.
	 * @return the combination of the two numbers.
	 */
	public int binomialCoeff(int n, int k) {
		int C[][] = new int[n + 1][k + 1];
		int i, j;

		// Calculate value of Binomial
		// Coefficient in bottom up manner
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= min(i, k); j++) {
				// Base Cases
				if (j == 0 || j == i)
					C[i][j] = 1;

				// Calculate value using
				// previously stored values
				else
					C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
			}
		}

		return C[n][k];
	}

	/**
	 * This method calculates the minimum number.
	 * <b>pre</b>The numbers would be integer.<br>
	 * <b>post</b>The comparison would throw a result.<br>
	 * @param a is a number. a != null and a >= 0.
	 * @param b is a number. b != null and b >= 0.
	 * @return the minimum number.
	 */
	public int min(int a, int b) {
		return (a < b) ? a : b;
	}

}
