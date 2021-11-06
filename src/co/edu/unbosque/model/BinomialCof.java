package co.edu.unbosque.model;

public class BinomialCof {

	public int coefBin(int num1, int num2) {
		int i;
		int j;
		int[][] table = new int[num1 + 1][num1 + 1];

		if (num2 == 0 || num2 == num1) {
			return 1;
		} else {
			for (i = 0; i <= num1; i++) {
				table[i][0] = 1;
			}

			for (i = 1; i <= num1; i++) {
				table[i][1] = i;
			}

			for (i = 2; i <= num2; i++) {
				table[i][i] = 1;
			}

			for (i = 3; i <= num1; i++) {
				for (j = 2; j < num1; j++) {
					if (j <= num2) {
						table[i][j] = table[i - 1][j - 1] + table[i - 1][j];
					}
				}
			}
		}

		return table[num1][num2];
	}

}
