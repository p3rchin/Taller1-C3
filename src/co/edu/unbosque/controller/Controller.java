/**
 * Package containing the class
 */
package co.edu.unbosque.controller;

import co.edu.unbosque.model.BinomialCof;
import co.edu.unbosque.model.Floyd;
import co.edu.unbosque.model.MatrixChainMultiplication;
import co.edu.unbosque.model.TaskAssignmentProblem;
import co.edu.unbosque.model.TravellerAlgorithm;
import co.edu.unbosque.view.View;


/**
 * 
 * @author Santiago Acevedo Rodríguez and Fabián Camilo Gómez Céspedes
 *
 */

public class Controller {

	/**
	 * floyd is the instance of Floyd.
	 */
	
	private Floyd floyd;
	
	/**
	 * bino is the instance of Binomial.
	 */
	private BinomialCof bino;
	
	/**
	 * matrix is the instance of MatrixChainMultiplication.
	 */
	private MatrixChainMultiplication matrix;
	/**
	 * traveller is the instance of TravellerAlgorithm.
	 */
	private TravellerAlgorithm traveller;
	
	/**
	 * task is the instance of TaskAssignmentProblem.
	 */
	private TaskAssignmentProblem task;
	/*
	 * view is the instance of View.
	 */
	private View view;

	
	/**
	 * This constructor define the instances.
	 * <b>pre</b>Must exist declarations of the instances.<br>
	 * <b>post</b>The instances of a class.<br>
	 */
	
	public Controller() {
		floyd = new Floyd();
		bino = new BinomialCof();
		matrix = new MatrixChainMultiplication();
		traveller = new TravellerAlgorithm();
		task = new TaskAssignmentProblem();
		view = new View();
		run();
	}

	/**
	 * This method verifies that the received String only has numbers. 
	 * <b>pre</b>The parameter String must be a number.<br>
	 * <b>post</b> If the method complete correctly is because the String had a number. In other case the method return a false.<br>
	 * @param pNumber is the String number: pNumber need to be != null and != " ".
	 * @return is the boolean value that is returned of the method.
	 */

	public boolean onlyNumbers(String pNumber) {
		for (int i = 0; i < pNumber.length(); i++) {
			char aux = pNumber.charAt(i);
			int digit = aux - '0';
			if (digit > 9 || digit < 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method is the execution of the program.
	 *<b>pre</b>The instances in the constructor must be exist.<br>
	 *<b>post</b>The program should show results.<br>
	 */
	
	private void run() {
		String exercise = "\n————————————————————————————————————————————————\n"
				+ "         BosqueSW - Dinamic programming\n" + "————————————————————————————————————————————————\n"
				+ "1. Use Floyd algorithm\n" + "2. Use binomial coeficients\n" + "3. Use matrix multiplication\n"
				+ "4. Use Traveller algorithm\n" + "5. Use the assignment algorithm\n" + "6. Finish\n";
		view.showMessage(exercise);
		String option = view.readData();
		switch (option) {
		case "1":
			view.showMessage("For this exercise the gragh must be required as a adyacency matrix");
			view.showMessage("Write the size of the graph");
			String size = view.readData();
			while (!onlyNumbers(size) || size.equals("")) {
				view.showMessage("Error. Rewrite the size of the graph");
				size = view.readData();
			}
			int nSize = Integer.parseInt(size);
			int[][] graph = new int[nSize][nSize];
			for (int i = 0; i < nSize; i++) {
				for (int j = 0; j < nSize; j++) {
					view.showMessage(
							"Please write the values of the graph and the nodes\nAdvice: if the nodes does not have a connection please write a big number such as 9999");
					String v = view.readData();
					while (!onlyNumbers(v) || v.equals("")) {
						view.showMessage("Error. Rewrite the values of the graph and the nodes");
						v = view.readData();
					}
					graph[i][j] = Integer.parseInt(v);
				}
			}
			view.showMessage("The program will show in a matrix the minimum distance between two nodes\n");
			view.printMatrixOfFloyd(floyd.floydWarshall(graph, nSize));
			break;
		case "2":
			view.showMessage("Please write the first number");
			String s1 = view.readData();
			while (!onlyNumbers(s1) || s1.equals("")) {
				view.showMessage("Error. Rewrite the first number");
				s1 = view.readData();
			}
			int n1 = Integer.parseInt(s1);
			view.showMessage("Please write the second number");
			String s2 = view.readData();
			while (!onlyNumbers(s2) || s2.equals("")) {
				view.showMessage("Error. Rewrite the second number");
				s2 = view.readData();
			}
			int n2 = Integer.parseInt(s2);
			view.showMessage("The Value of C(" + n1 + "," + n2 + ") is " + bino.binomialCoeff(n1, n2));
			run();
			break;
		case "3":
			view.showMessage("Please write the number of matrixes that you want");
			String sm = view.readData();
			while (!onlyNumbers(sm) || sm.equals("")) {
				view.showMessage("Error. Rewrite the number of matrixes that you want");
				sm = view.readData();
			}
			int numberSm = (Integer.parseInt(sm)) + 1;
			int[] matrixMulti = new int[numberSm];
			for (int i = 0; i < numberSm; i++) {
				view.showMessage(
						"Please write the dimensions of the matrixes\nTake into account that the columns of the matrix A would be the same for the rows in B in turn");
				String m = view.readData();
				while (!onlyNumbers(m) || m.equals("")) {
					view.showMessage("Error. Rewrite the dimensions of the matrixes\\nTake into account that the columns of the matrix A would be the same for the rows in B in turn");
					m = view.readData();
				}
				matrixMulti[i] = Integer.parseInt(m);
			}
			view.showMessage("Minimum number of multiplications is "
					+ matrix.matrixChainOrder(matrixMulti, 1, matrixMulti.length - 1));
			run();
			break;
		case "4":
			view.showMessage("For this exercise the cities and distances must be required as a adyacency matrix");
			view.showMessage("Write the number of the cities");
			String cities = view.readData();
			while (!onlyNumbers(cities) || cities.equals("")) {
				view.showMessage("Error. Rewrite the number of the cities");
				cities = view.readData();
			}
			int nCities = Integer.parseInt(cities);
			int[][] distances = new int[nCities][nCities];
			for (int i = 0; i < nCities; i++) {
				for (int j = 0; j < nCities; j++) {
					view.showMessage("Please write the distances between each city");
					String d = view.readData();
					while (!onlyNumbers(d) || d.equals("")) {
						view.showMessage("Error. Rewrite the number of the cities");
						d = view.readData();
					}
					distances[i][j] = Integer.parseInt(d);
				}
			}
			view.showMessage("Write the number of the city where the traveller has to begin");
			String start = view.readData();
			while (!onlyNumbers(start) || start.equals("")) {
				view.showMessage("Error. Rewrite the number of the city where the traveller has to begin");
				start = view.readData();
			}
			int nStart = Integer.parseInt(start);
			int result = traveller.travel(distances, nStart);
			view.showMessage("The distance that the traveller have to move was " + result + " units");
			run();
			break;
		case "5":
			view.showMessage("For this exercise is required n days to evaluate the amount of tasks to do");
			view.showMessage("Please write the number of tasks for low and high effort effort");
			String assign = view.readData();
			while (!onlyNumbers(assign) || assign.equals("")) {
				view.showMessage("Error. Rewrite the number of tasks for low and high effort effort");
				assign = view.readData();
			}
			int nTask = Integer.parseInt(assign);
			int[] low = new int[nTask];
			int[] high = new int[nTask];
			for (int i = 0; i < nTask; i++) {
				view.showMessage("Please insert the effort of the low tasks");
				String l = view.readData();
				while (!onlyNumbers(l) || l.equals("")) {
					view.showMessage("Error. Reinsert the effort of the low tasks");
					l = view.readData();
				}
				low[i] = Integer.parseInt(l);
			}
			for (int i = 0; i < nTask; i++) {
				view.showMessage("Please insert the effort of the high tasks");
				String h = view.readData();
				while (!onlyNumbers(h) || h.equals("")) {
					view.showMessage("Error. Reinsert the effort of the high tasks");
					h = view.readData();
				}
				high[i] = Integer.parseInt(h);
			}
			view.showMessage("Please write the day to evaluate what tasks to do");
			String day = view.readData();
			while (!onlyNumbers(day) ||day.equals("")) {
				view.showMessage("Error. Rewrite the day to evaluate what tasks to do");
				day = view.readData();
			}
			view.showMessage("The maximum amount of tasks is " + task.maxTasks(high, low, Integer.parseInt(day)));
			run();
			break;
		case "6":
			view.showMessage("See you soon, the program was shut down");
			System.exit(0);
			break;

		default:
			view.showMessage("Invalid option, please try again");
			run();
			break;
		}

	}
}