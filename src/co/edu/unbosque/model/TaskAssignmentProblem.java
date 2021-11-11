/**
 * Package containing the class
 */
package co.edu.unbosque.model;


/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */
public class TaskAssignmentProblem {
	
	/**
	 * This method calculate the amount of tasks. 
	 * <b>pre</b>The arrays must have at least one value.<br>
	 * <b>post</b>Must be a selection of the tasks.<br>
	 * @param high is a array. high must be != " " and != null.
	 * @param low is a array. low must be != " " and != null.
	 * @param n is a number. n != null and j >= 0.
	 * @return the amount of tasks.
	 */
	public int maxTasks(int high[], int low[], int n) {

		// If n is less than equal to 0,
		// then no solution exists
		if (n <= 0)
			return 0;

		/*
		 * Determines which task to choose on day n, then returns the maximum till that
		 * day
		 */
		return Math.max(high[n - 1] + maxTasks(high, low, (n - 2)), low[n - 1] + maxTasks(high, low, (n - 1)));
	}
}
