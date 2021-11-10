package co.edu.unbosque.model;

public class TravellerAlgorithm {

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
