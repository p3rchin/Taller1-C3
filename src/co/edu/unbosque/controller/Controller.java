package co.edu.unbosque.controller;

import co.edu.unbosque.model.BinomialCof;
import co.edu.unbosque.model.Floyd;
import co.edu.unbosque.view.View;

public class Controller {

	private Floyd floyd;
	private BinomialCof bino;
	private View view;

	public Controller() {
		floyd = new Floyd();
		bino = new BinomialCof();
		view = new View();
		run();
	}

	private void run() {
		String exercise = "\n————————————————————————————————————————————————\n"
				+ "         BosqueSW - Dinamic programming" + "————————————————————————————————————————————————\n"
				+ "1. Use Floyd algorithm\n" + "2. Use binomial coeficients\n" + "3. Use matrix multiplication\n"
				+ "4. Use Traveller algorithm\n" + "5. Use the assignment algorithm\n" + "6. Finish\n" + "\n";
		view.showMessage(exercise);
		String option = view.readData();
		switch (exercise) {
		case "1":
			break;
		case "2":
			break;

		}

	}

}
