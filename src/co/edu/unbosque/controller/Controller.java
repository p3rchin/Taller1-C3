package co.edu.unbosque.controller;

import co.edu.unbosque.model.BinomialCof;
import co.edu.unbosque.model.Floyd;
import co.edu.unbosque.model.MatrixChainMultiplication;
import co.edu.unbosque.model.TravellerAlgorithm;
import co.edu.unbosque.view.View;

public class Controller {

	private Floyd floyd;
	private BinomialCof bino;
	private MatrixChainMultiplication matrix;
	private TravellerAlgorithm traveller;
	private View view;

	public Controller() {
		floyd = new Floyd();
		bino = new BinomialCof();
		matrix = new MatrixChainMultiplication();
		traveller = new TravellerAlgorithm();
		view = new View();
		run();
	}

	private void run() {
		String exercise = "\n覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧\n"
				+ "         BosqueSW - Dinamic programming\n" + "覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧覧\n"
				+ "1. Use Floyd algorithm\n" + "2. Use binomial coeficients\n" + "3. Use matrix multiplication\n"
				+ "4. Use Traveller algorithm\n" + "5. Use the assignment algorithm\n" + "6. Finish\n";
		view.showMessage(exercise);
		String option = view.readData();
		switch (option) {
		case "1":
			view.showMessage("For this exercise the gragh must be required as a adyacency matrix");
			view.showMessage("Write the size of the graph");
			String size = view.readData();
			int nSize = Integer.parseInt(size);
			int[][] graph = new int[nSize][nSize];
			for (int i = 0; i < nSize; i++) {
				for (int j = 0; j < nSize; j++) {
					view.showMessage(
							"Please write the values of the graph and the nodes\nadvice: if the nodes does not have a connection please write a big number such as 9999");
					String v = view.readData();
					graph[i][j] = Integer.parseInt(v);
				}
			}
			view.showMessage("The program will show in a matrix the minimum distance between two nodes\n");
			view.printMatrixOfFloyd(floyd.floydWarshall(graph, nSize));
			break;
		case "2":
			view.showMessage("Please write the first number");
			String s1 = view.readData();
			int n1 = Integer.parseInt(s1);
			view.showMessage("Please write the second number");
			String s2 = view.readData();
			int n2 = Integer.parseInt(s2);
			view.showMessage("The Value of C(" + n1 + "," + n2 + ") is " + bino.binomialCoeff(n1, n2));
			break;
		case "3":
			view.showMessage("Please write the number of matrixes that you want");
			String sm = view.readData();
			int numberSm = (Integer.parseInt(sm)) + 1;
			int[] matrixMulti = new int[numberSm];
			for (int i = 0; i < numberSm; i++) {
				view.showMessage(
						"Please write the dimensions of the matrixes\ntake into account that the columns of the matrix A would be the same for the rows in B in turn");
				String m = view.readData();
				matrixMulti[i] = Integer.parseInt(m);
			}
			view.showMessage("Minimum number of multiplications is "
					+ matrix.matrixChainOrder(matrixMulti, 1, matrixMulti.length - 1));
			break;
		case "4":
			view.showMessage("For this exercise the cities and distances must be required as a adyacency matrix");
			view.showMessage("Write the number of the cities");
			String cities = view.readData();
			int nCities = Integer.parseInt(cities);
			int[][] distances = new int[nCities][nCities];
			for (int i = 0; i < nCities; i++) {
				for (int j = 0; j < nCities; j++) {
					view.showMessage("Please write the distances between each city");
					String d = view.readData();
					distances[i][j] = Integer.parseInt(d);
				}
			}
			view.showMessage("Write the number of the city where the traveller has to begin");
			String start = view.readData();
			int nStart = Integer.parseInt(start);
			int result = traveller.travel(distances, nStart);
			view.showMessage("The distance that the traveller have to move was " + result+ " units");
		}

	}
}