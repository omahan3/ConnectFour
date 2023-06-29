package Q2;

import java.util.Scanner;

public class ConnectFour {

	public static Piece currentTurn;
	public static final int NUMROWS = 6;
	public static final int NUMCOLS = 8;

	public static void main(String[] args) {

		//int acceptedPlayers = 0;
		currentTurn = Piece.X;

		Player p1 = promptForNextPlayer("X");
		Player p2 = promptForNextPlayer("O");

		Board currentBoard = Board.GenerateEmptyBoard();
		GameLogger logger = new GameLogger();

		while (currentBoard.getWinner() == Piece.EMPTY && currentBoard.existLegalMoves()) {
			printBoard(currentBoard.getPieceArray());
			int moveChoice = -1;
			while (!currentBoard.isLegal(moveChoice)) {
				if (currentTurn == Piece.X) {
					moveChoice = p1.chooseMove(currentBoard, currentTurn);
				} else {
					moveChoice = p2.chooseMove(currentBoard, currentTurn);
				}
			}

			currentBoard.updateBoard(moveChoice, currentTurn);
			logger.addMove(moveChoice);
//			printBoard(currentBoard.getPieceArray());

			if (currentTurn == Piece.X) {
				currentTurn = Piece.O;
			} else {
				currentTurn = Piece.X;
			}
		}

		printBoard(currentBoard.getPieceArray());

		System.out.println("The current winner is " + currentBoard.getWinner());
		System.out.println("The game recap is: ");
		logger.printGameFromList();
	}

	// prints the parameter array to the console.
	// Top of board corresponds to last index of array, so must print rows in reverse (top to bottom)
	// Also includes row numbers underneath the board for easy identification during Human Player's turn.
	public static void printBoard (Piece[][] board) {
		for (int i = NUMROWS - 1; i >= 0 ; i--) {
			for (int j = 0; j < NUMCOLS; j++) {
				if (board[i][j] == Piece.EMPTY) {
					System.out.print("_ ");
				} else {
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < NUMCOLS; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	// Used for deciding whether each player is Human or Computer
	public static Player promptForNextPlayer(String playerName) {
		String input = "";
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Player " + playerName + ", would you like a human (h) or computer (c) player?");
			input = s.next();
			if (input.charAt(0) == 'h') {
				return new HumanPlayer();
			}

			if (input.charAt(0) == 'c') {
				return new ComputerPlayer();
			}
		}
	}
}