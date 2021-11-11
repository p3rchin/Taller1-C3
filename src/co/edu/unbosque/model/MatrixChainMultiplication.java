/**
 * Package containing the class
 */
package co.edu.unbosque.model;

/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class MatrixChainMultiplication {

	/**
	 * This method calculates the minimum number of multiplications in a matrix chain.
	 * <b>pre</b>The array always must have +1 in the size.<br>
	 * <b>post</b>The multiplication of the matrixes would show a number.<br>
	 * @param p is a matrix. p must be != " " and != null.
	 * @param i is a number. i != null and i >= 0.
	 * @param j is a number. j != null and j >= 0.
	 * @return is a number of a multiplication needed.
	 */
	 public int matrixChainOrder(int p[], int i, int j)
	    {
	        if (i == j)
	            return 0;
	 
	        int min = Integer.MAX_VALUE;
	 
	        // place parenthesis at different places between
	        // first and last matrix, recursively calculate
	        // count of multiplications for each parenthesis
	        // placement and return the minimum count
	        for (int k = i; k < j; k++)
	        {
	            int count = matrixChainOrder(p, i, k)
	                        + matrixChainOrder(p, k + 1, j)
	                        + p[i - 1] * p[k] * p[j];
	 
	            if (count < min)
	                min = count;
	        }
	 
	        // Return minimum count
	        return min;
	    }

}
