
/**
 * Package containing the class
 */
package co.edu.unbosque.view;

import java.util.Scanner;
/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */

public class View {
	
	/**
	 * This method is the constructor of the class.
	 */	

	public View() {
	}

	/**
	 * This method is for show messages.
	 * <b>pre</b>The String parameter must be defined.<br>
	 * <b>post</b> The message must be printed in the JOptionPane messages.<br>
	 * @param pSms is parameter String for show  the messages.
	 */
	
	public void showMessage(String pSms) {
		System.out.println(pSms);
	}

	/**
	 * This method is for read data.
	 * <b>pre</b>The Scanner must be instance.<br>
	 * <b>post</b> The String returned must be different of null.<br>
	 * @return is the String returned that is captured.
	 */	
	
	public String readData() {
		Scanner scanner = new Scanner(System.in);
		String data = "";
		data = scanner.nextLine();
		return data;

	}
	
	/**
	 * This method print the adyacency matrix of Floyd.
	 * <b>pre</b>The matrix must have at least one value<br>
	 * <b>post</b>The information would be showed.<br>
	 * @param matrix is a matrix. matrix must be != null and != " ".
	 */
	public void printMatrixOfFloyd(int matrix[][]) {
		for (int i = 0; i < matrix.length; ++i) {
			for (int j = 0; j < matrix.length; ++j) {
				if (matrix[i][j] == 9999)
					System.out.print("INF");
				else
					System.out.print(matrix[i][j] + "  ");
			}
			System.out.println();
		}
	}
	/**
	 * This method print a matrix.
	* <b>pre</b>The matrix must have at least one value<br>
	 * <b>post</b>The information would be showed.<br>
	 * @param c is a matrix. matrix must be != null and != " ". 
	 */
	public void printMatrix(int c[][]) {
		for (int x = 0; x < c.length; x++) {
			System.out.print("|");
			for (int y = 0; y < c[x].length; y++) {
				System.out.print(c[x][y]);
				if (y != c[x].length - 1)
					System.out.print("\t");
			}
			System.out.println("|");
		}
	}
}
