package de.clientside;


import de.tiere.Schwein;

public class Main {


	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		final Schwein schwein = new Schwein("Miss Piggy");

		for (int i = 0; i < 11; i++) {
			schwein.fuettern();
		}


	}



}






