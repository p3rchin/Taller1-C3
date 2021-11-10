package co.edu.unbosque.model;

public class MatrixChainMultiplication {

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
