package Q2;

public class Board {

	// represents the piece on each square of the game board. Can be X, O, or EMPTY.
	// row index 0 represents the bottom row of the board.
	Piece[][] theBoard;

	boolean isXTurn;


	// these two constants represent the size of the game board
	public static final int NUMROWS = 6;
	public static final int NUMCOLS = 8;


	// Constructor. Copies values from parameter to theBoard, and sets turn to X
	public Board(Piece[][] oldBoard) {
		theBoard = new Piece[NUMROWS][NUMCOLS];

		for (int i = 0; i < NUMROWS; i++) {
			for (int j = 0; j < NUMCOLS; j++) {
				theBoard[i][j] = oldBoard[i][j];
			}
		}
		isXTurn = true;
	}

	public Piece getPiece(int row, int col) {
		return theBoard[row][col];
	}

	public Piece[][] getPieceArray() {
		return theBoard;
	}


	// Returns the first (lowest) row in the parameter column where the Piece is EMPTY, or -1 if none exist.
	public int findFirstFreeRow(int column) {
		for (int i = 0; i < NUMROWS; i++) {
			if (theBoard[i][column] == Piece.EMPTY) {
				return i;
			}
		}
		return -1;
	}

	// returns true if the selected column is within the bounds of the board and also has an empty row, and false otherwise.
	public boolean isLegal(int nextMove) {
		return nextMove >= 0 && nextMove < NUMCOLS && findFirstFreeRow(nextMove) > -1;
	}


	// Returns true if there exists at least one column which has an empty row, and false otherwise.
	// In other words, returns false if the board is completely full, and true otherwise.
	public boolean existLegalMoves() {
		for (int i = 0; i < NUMCOLS; i++) {
			if (isLegal(i)) {
				return true;
			}
		}
		return false;
	}

	// Checks for 4 consecutive pieces of the same type in any column.
	// Returns the Piece of the first occurrence, or EMPTY if none exist.
	private Piece checkVerticalWins() {

		Piece lastPiece;
		int sequenceNum;

		for (int j = 0; j < NUMCOLS; j++) {
			sequenceNum = 1;
			lastPiece = theBoard[0][j];
			for (int i = 1; i < NUMROWS; i++) {
				if (lastPiece != Piece.EMPTY && theBoard[i][j] == lastPiece) {
					sequenceNum++;
					if (sequenceNum == 4) {
						return theBoard[i][j];
					}
				} else if (theBoard[i][j] != lastPiece) {
					sequenceNum = 1;
				}
				lastPiece = theBoard[i][j];
			}
		}
		return Piece.EMPTY;
	}

	// Checks for 4 consecutive pieces of the same type in any row.
	// Returns the Piece of the first occurrence, or EMPTY if none exist.
	private Piece checkHorizontalWins() {

		Piece lastPiece;
		int sequenceNum;

		for (int i = 0; i < NUMROWS; i++) {
			sequenceNum = 1;
			lastPiece = theBoard[i][0];
			for (int j = 1; j < NUMCOLS; j++) {
				if (lastPiece != Piece.EMPTY && theBoard[i][j] == lastPiece) {
					sequenceNum++;
					if (sequenceNum == 4) {
						return theBoard[i][j];
					}
				} else if (theBoard[i][j] != lastPiece) {
					sequenceNum = 1;
				}
				lastPiece = theBoard[i][j];
			}
		}
		return Piece.EMPTY;
	}


	// Checks for 4 consecutive pieces of the same type in any line from the bottom left to top right. ( / )
	// Returns the Piece of the first occurrence, or EMPTY if none exist.
	private Piece checkRightDiagonalWins() {

		Piece lastPiece;
		int sequenceNum;

		for (int row = 0; row < NUMROWS - 3; row++) {
			int i = row;
			int j = 0;
			sequenceNum = 1;
			lastPiece = theBoard[i][j];
			i++;
			j++;
			while (j < NUMCOLS && i < NUMROWS) {
				if (lastPiece != Piece.EMPTY && theBoard[i][j] == lastPiece) {
					sequenceNum++;
					if (sequenceNum == 4) {
						return theBoard[i][j];
					}
				} else if (theBoard[i][j] != lastPiece) {
					sequenceNum = 1;
				}
				lastPiece = theBoard[i][j];
				i++;
				j++;
			}
		}

		for (int col = 0; col < NUMCOLS - 3; col++) {
			int i = 0;
			int j = col;
			sequenceNum = 1;
			lastPiece = theBoard[i][j];
			i++;
			j++;
			while (i < NUMROWS && j < NUMCOLS) {
				if (lastPiece != Piece.EMPTY && theBoard[i][j] == lastPiece) {
					sequenceNum++;
					if (sequenceNum == 4) {
						return theBoard[i][j];
					}
				} else if (theBoard[i][j] != lastPiece) {
					sequenceNum = 1;
				}
				lastPiece = theBoard[i][j];
				i++;
				j++;
			}
		}
		return Piece.EMPTY;
	}


	// Checks for 4 consecutive pieces of the same type in any line from the bottom right to top left ( \ ).
	// Returns the Piece of the first occurrence, or EMPTY if none exist.
	private Piece checkLeftDiagonalWins() {
		Piece lastPiece;
		int sequenceNum;

		for (int row = 0; row < NUMROWS - 3; row++) {
			int i = row;
			int j = NUMCOLS - 1;
			sequenceNum = 1;
			lastPiece = theBoard[i][j];
			i++;
			j--;
			while (j >= 0 && i < NUMROWS) {
				if (lastPiece != Piece.EMPTY && theBoard[i][j] == lastPiece) {
					sequenceNum++;
					if (sequenceNum == 4) {
						return theBoard[i][j];
					}
				} else if (theBoard[i][j] != lastPiece) {
					sequenceNum = 1;
				}
				lastPiece = theBoard[i][j];
				i++;
				j--;
			}
		}

		for (int col = 3; col < NUMCOLS; col++) {
			int i = 0;
			int j = col;
			sequenceNum = 1;
			lastPiece = theBoard[i][j];
			i++;
			j--;
			while (i < NUMROWS && j >= 0) {
				if (lastPiece != Piece.EMPTY && theBoard[i][j] == lastPiece) {
					sequenceNum++;
					if (sequenceNum == 4) {
						return theBoard[i][j];
					}
				} else if (theBoard[i][j] != lastPiece) {
					sequenceNum = 1;
				}
				lastPiece = theBoard[i][j];
				i++;
				j--;
			}
		}
		return Piece.EMPTY;
	}

	// Checks the board for 4 consecutive pieces of the same type in a row in any direction.
	// Returns the Piece of the first found instance, or EMPTY if none exist.
	public Piece getWinner() {

		Piece p = checkHorizontalWins();
		if (p != Piece.EMPTY) {
			return p;
		}
		p = checkVerticalWins();
		if (p != Piece.EMPTY) {
			return p;
		}
		p = checkRightDiagonalWins();
		if (p != Piece.EMPTY) {
			return p;
		}
		p = checkLeftDiagonalWins();
		return p;
	}

	// places the player's piece on the board at the specified column, and switches the turn to the next player.
	void updateBoard(int moveChoice, Piece move) {
		theBoard[findFirstFreeRow(moveChoice)][moveChoice] = move;
		isXTurn = !isXTurn;
	}


	// Used for starting a new game.
	// Initializes all the Pieces of the array to EMPTY and returns a Board object created from that array.
	public static Board GenerateEmptyBoard() {
		Piece[][] newBoard = new Piece[NUMROWS][NUMCOLS];
		for (int i = 0; i < NUMROWS; i++) {
			for (int j = 0; j < NUMCOLS; j++) {
				newBoard[i][j] = Piece.EMPTY;
			}
		}
		return new Board(newBoard);
	}

}