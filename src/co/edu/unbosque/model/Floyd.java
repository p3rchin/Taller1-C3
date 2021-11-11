/**
 * Package containing the class
 */
package co.edu.unbosque.model;
/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class Floyd {

	/**
	 * This method calculates the minimum distance between two nodes.
	 * <b>pre</b>The matrix must have at least one value.<br>
	 * <b>post</b>The matrix must change in the comparison with the original one.<br>
	 * @param graph is an adyacency matrix. graph must be != " " and != null.
	 * @param tam is a size of the adyacency matrix. tam != null and tam >= 0.
	 * @return a matrix with the minimum distances.
	 */
	// Implementing floyd warshall algorithm
	public int[][] floydWarshall(int graph[][], int tam) {
		int matrix[][] = new int[tam][tam];
		int i, j, k;

		for (i = 0; i < tam; i++)
			for (j = 0; j < tam; j++)
				matrix[i][j] = graph[i][j];

		// Adding vertices individually
		for (k = 0; k < tam; k++) {
			for (i = 0; i < tam; i++) {
				for (j = 0; j < tam; j++) {
					if (matrix[i][k] + matrix[k][j] < matrix[i][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
				}
			}
		}
		return matrix;
	}

	

}
