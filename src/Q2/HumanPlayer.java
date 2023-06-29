package Q2;

import java.util.Scanner;

public class HumanPlayer implements Player {

	// Prompts the user to enter their move, then returns the next int they enter.
	// No checking is needed, as checking is handled by the calling method.
	public int chooseMove(Board b, Piece turn) {

		String player;
		if (b.isXTurn) {
			player = "'X'";
		} else {
			player = "'O'";
		}

		System.out.println("Player " + player + ", enter the column number of your move.");

		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
}