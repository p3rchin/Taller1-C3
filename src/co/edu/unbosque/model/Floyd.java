package co.edu.unbosque.model;

public class Floyd {
	final static int INF = 9999;

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
