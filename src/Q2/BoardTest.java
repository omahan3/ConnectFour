//package Q2;
//
//import junit.framework.Assert;
//import junit.framework.TestCase;
//
//
//public class BoardTest extends TestCase {
//    private String fullName;
//
//    public BoardTest(String name) {
//	super(name);
//	this.fullName = getClass() + ", " + name + "()";
//    }
//
//    Piece e = Piece.EMPTY;
//    Piece w = Piece.BLACK;
//    Piece r = Piece.RED;
//
//	//empty board
//    Piece[][][] boards ={ { {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//    //testing next available square
//     { {w,r,e,e,e,e,e,e}, {r,e,e,e,e,e,e,e}, {w,e,e,e,e,e,e,e}, {r,e,e,e,e,e,e,e}, {w,e,e,e,e,e,e,e}, {r,e,e,e,e,e,e,e}},
//
//    //testing black winning
//     { {w,r,e,e,e,e,e,e}, {w,r,e,e,e,e,e,e}, {w,r,e,e,e,e,e,e}, {w,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//     { {w,w,w,w,e,e,e,e}, {r,r,r,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//     { {w,r,w,w,e,e,e,e}, {r,w,r,r,e,e,e,e}, {r,r,w,w,e,e,e,e}, {e,e,e,w,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//
//    //testing red winning
// { {r,w,e,e,e,e,e,w}, {r,w,e,e,e,e,e,e}, {r,w,e,e,e,e,e,e}, {r,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//    { {r,r,r,r,e,e,e,w}, {w,w,w,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//     { {r,w,r,r,e,e,e,w}, {w,r,w,w,e,e,e,e}, {w,w,r,r,e,e,e,e}, {e,e,e,r,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//
//
//     { {r,r,w,e,r,r,w,e}, {w,r,r,e,r,r,r,r}, {w,w,r,e,w,w,r,e}, {w,r,w,e,w,e,r,e}, {r,w,w,e,w,e,e,e}, {w,w,w,e,e,e,e,e}},
//
//     { {r,e,w,w,r,w,r,r}, {w,e,e,w,r,r,r,r}, {w,e,e,w,e,e,e,e}, {w,e,e,e,e,e,e,e}, {r,e,e,e,e,e,e,e}, {w,e,e,e,e,e,e,e}},
//
//
//    //testing no more legal moves
//  { {w,w,r,r,w,r,w,r}, {r,r,w,r,w,r,w,r}, {w,w,r,r,w,r,w,r}, {r,w,w,r,w,r,w,r}, {w,r,r,w,r,w,r,w}, {r,w,w,r,w,r,w,r}}};
//
//    Piece[][] board10 = { {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}};
//
//
//    public static void checkInitAndGetters(Piece[][] board) {
//	Board b = new Board(board);
//	Assert.assertEquals("Error because the final NUMROWS is not set correctly", 6, b.NUMROWS);
//	Assert.assertEquals("Error because the final NUMCOLS is not set correctly", 8, b.NUMCOLS);
//
//        for (int i=0; i < b.NUMROWS; i++) {
//		for (int j=0; j<b.NUMCOLS; j++) {
//			Assert.assertEquals("Initialization of board or reading from board is not correct", board[i][j], b.getPiece(i,j));
//		}
//	}
//
//        if (board[0][0] == Piece.BLACK) {
//		board[0][0] = Piece.RED;
//		Assert.assertEquals("Constructor for board does not make a duplicate *copy* of the original array. You only assigned the reference", Piece.BLACK, b.getPiece(0,0));
//	}
//        else if (board[0][0] == Piece.RED) {
//		board[0][0] = Piece.BLACK;
//		Assert.assertEquals("Constructor for board does not make a duplicate *copy* of the original array. You only assigned the reference", Piece.RED, b.getPiece(0,0));
//	}
//   }
//
//
//    public void testInitializationAndGetters()
//    {
//	for (int i=0; i < 9; i++) {
//		checkInitAndGetters(boards[i]);
//	}
//    }
//
//    public void testFindFirstFreeRow()
//    {
//	Board b = new Board(boards[1]);
//
//	Assert.assertEquals("Test failed because getting the next free space is not correct", -1, b.findFirstFreeRow(0));
//	Assert.assertEquals("Test failed because getting the next free space is not correct", 1, b.findFirstFreeRow(1));
//	Assert.assertEquals("Test failed because getting the next free space is not correct", 0, b.findFirstFreeRow(2));
//    }
//
//    public void testWinnerEvaluation()
//    {
//	System.out.println("Testing winner evaluation");
//	for (int i=2; i <5; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Test failed because it did not properly evaluate the winner", Piece.BLACK, b.getWinner());
//	}
//
//	for (int i=5; i <10; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Test failed because it did not properly evaluate the winner", Piece.RED, b.getWinner());
//	}
//
//	for (int i=0; i <2; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Test failed because it did not properly evaluate the winner", Piece.EMPTY, b.getWinner());
//	}
//    }
//
//    public void testCheckLegalMoves()
//    {
//	for (int i=0; i <9; i++) {
//		Board b = new Board(boards[i]);
//		boolean expected = i == 10 ? false : true;
//		Assert.assertEquals("Test check existLegalMoves() failed.", expected, b.existLegalMoves());
//	}
//    }
//
//    public void testIsLegal()
//    {
//	Board b = new Board(boards[1]);
//
//	Assert.assertEquals("Test isLegal() failed", false, b.isLegal(-1));
//	Assert.assertEquals("Test isLegal() failed", false, b.isLegal(8));
//	Assert.assertEquals("Test isLegal() failed", false, b.isLegal(0));
//	Assert.assertEquals("Test isLegal() failed", true, b.isLegal(1));
//    }
//
//    public void testGenerateEmptyBoard()
//    {
//	Board b = Board.GenerateEmptyBoard();
//
//	for (int i=0; i < Board.NUMROWS; i++) {
//		for (int j=0; j < Board.NUMCOLS; j++) {
//			Assert.assertEquals("Test generateEmptyBoard failed. The method does not return an empty piece", Piece.EMPTY, b.getPiece(i,j));
//		}
//	}
//    }
//
//    public void testUpdateBoard()
//    {
//	Board b = Board.GenerateEmptyBoard();
//	b.updateBoard(0,Piece.RED);
//        b.updateBoard(0,Piece.RED);
//	b.updateBoard(0,Piece.RED);
//	b.updateBoard(0,Piece.BLACK);
//	b.updateBoard(1,Piece.BLACK);
//
//	Assert.assertEquals("Test update board failed.", Piece.RED, b.getPiece(0,0));
//	Assert.assertEquals("Test update board failed.", Piece.RED, b.getPiece(1,0));
//	Assert.assertEquals("Test update board failed.", Piece.RED, b.getPiece(2,0));
//	Assert.assertEquals("Test update board failed.", Piece.BLACK, b.getPiece(3,0));
//	Assert.assertEquals("Test update board failed.", Piece.BLACK, b.getPiece(0,1));
//    }
//
//    public static void main(String[] args) {
//	junit.swingui.TestRunner.run(BoardTest.class);
//    }
//}
