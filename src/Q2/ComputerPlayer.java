package Q2;

import java.util.ArrayList;
import java.util.Stack;

public class ComputerPlayer implements Player {
	private final int MAX_PLY = 6;


	public int chooseMove(Board b, Piece turn) {
		//return 0;
        return minimaxEvaluation(b, MAX_PLY, turn);
	}

	private int minimaxEvaluation(Board b, int plyLeft, Piece turn) {
		if (b.getWinner() != Piece.EMPTY) {
			return -1000;
		}

		if (!b.existLegalMoves()) {
			return 0; // this number is a tie
		}

		if (plyLeft <= 0) {
			return heuristic(b, turn);
		}

		int maxSoFar = -100000;

		ArrayList<Integer> allLegal = getAllLegalMoves(b);

		int bestMove = allLegal.get(0);

		for (Integer oneMove : allLegal) {
			Board latestBoard = new Board(b.getPieceArray());
			latestBoard.updateBoard(oneMove, turn);
			int thisMoveValue;


			if (latestBoard.getWinner() != Piece.EMPTY) {
				thisMoveValue = 1000;
				maxSoFar = 1000 + 10 * plyLeft;
				bestMove = oneMove;
				break;
			} else {
				thisMoveValue = - minimaxEvaluation(latestBoard, plyLeft-1, getOppositeTurn(turn));
			}

			if (thisMoveValue > maxSoFar) {
				maxSoFar = thisMoveValue;
				bestMove = oneMove;
			}
		}

		if (plyLeft == MAX_PLY) {
			return bestMove;
		} else {
			return maxSoFar;
		}
	}

	//this method assumes that piece is either X or O and not empty
	private Piece getOppositeTurn(Piece turn) {
		if (turn == Piece.O) {
			return Piece.X;
		} else {
			return Piece.O;
		}
	}

	private ArrayList<Integer> getAllLegalMoves(Board b) {
		ArrayList<Integer> allMoves = new ArrayList<Integer>();
		for (int i = 0; i < Board.NUMCOLS; i++) {
			if (b.isLegal(i)) {
				allMoves.add(i);
			}
		}

		return allMoves;
	}

	public int heuristic(Board b, Piece turn) {

		//NOTE: You may add other methods below that you find useful such as imminentWin() or getTotalTriples()

		if (imminentWin(b, turn)) {
			return 1000;
		} else if (forked(b, turn)) {
			return -900;
		} else if (canFork(b, turn)) {
			return 800;
		} else {
			int ownTriples = getTotalTriples(b, turn, false);
			int oppTriples = getTotalTriples(b, getOppositeTurn(turn), false);
			return ownTriples - oppTriples;
		}
	}


	//the following methods are 100% optional, but you may find them useful to write as you will repeat these computations many times

	//returns true if the input board b has an imminent win for the player "turn" . I.e. if turn has 3 in a row and can make a 4th move
	private boolean imminentWin(Board b, Piece turn) {
		// TODO:


		return true;
	}


	//returns the total number of 3 in a rows for player p. If requiredOpening is true then this filters out cases where it is blocked
	//by an opponents piece or the move is not yet playable because the column isn't yet filled enough to play here
	private int getTotalTriples(Board b, Piece p, boolean requiredOpening) {
		// TODO:
		return 0;
	}

	private boolean forked(Board b, Piece p) {

		if (getTotalTriples(b, p, true) > 1) {
			// TODO:
			// check the triples can't both be blocked with one move
			return true;
		} else {
			return false;
		}
	}

	private boolean canFork(Board b, Piece p) {

		// TODO:
		// check if p's player can generate a fork
		return true;
	}
}