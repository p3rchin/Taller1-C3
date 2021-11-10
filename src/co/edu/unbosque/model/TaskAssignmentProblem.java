package co.edu.unbosque.model;

public class TaskAssignmentProblem {
	
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
