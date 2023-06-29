//package Q2;
//
//import junit.framework.Assert;
//import junit.framework.TestCase;
//
//
//public class ComputerPlayerTest extends TestCase {
//    private String fullName;
//
//    public ComputerPlayerTest(String name) {
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
//    //testing imminent black win
//     { {w,r,e,e,e,e,e,e}, {w,r,e,e,e,e,e,e}, {w,r,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//     { {w,w,w,e,e,e,e,e}, {r,r,r,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//     { {w,r,w,w,e,e,e,e}, {r,w,r,r,e,e,e,e}, {r,r,w,w,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//
//    //testing imminent red win
// { {r,w,e,e,e,e,e,e}, {r,w,e,e,e,e,e,e}, {r,w,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//    { {r,r,r,e,e,e,e,e}, {w,w,w,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//     { {r,w,r,r,e,e,e,e}, {w,r,w,w,e,e,e,e}, {w,w,r,r,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//
//    //testing fork for red when it's black's turn
// { {r,r,r,e,e,e,e,e}, {r,w,e,e,e,e,e,e}, {r,w,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//
//
//    //testing fork for black when it's reds turn
//     { {w,w,w,e,e,e,e,e}, {w,r,e,e,e,e,e,e}, {w,r,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//
//   //testing chance for black to fork
//     { {e,w,w,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}},
//
//
//
//    //testing chance for red to fork
//     { {e,r,r,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}} ,
//
//	//test counting of threes
//     { {r,r,e,e,e,e,r,e}, {r,r,e,e,e,e,r,e}, {r,r,e,e,e,e,r,e}, {w,w,e,e,e,e,w,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}} ,
//
//	//test counting of threes
//     { {r,r,e,e,e,e,r,w}, {r,r,e,e,e,e,r,w}, {r,r,e,e,e,e,r,w}, {w,w,e,e,e,e,w,r}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}} ,
//
//	//testing that no imminent win is found because the square is not yet playable (column isn't filled)
//     { {w,w,w,r,r,r,e,e}, {e,w,r,e,e,e,e,e}, {e,e,w,r,e,e,e,w}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}} ,
//
//	};
//    int[] expectedValues = {0,0,1000,1000,1000,1000,1000,1000,0};
//    Piece[] turn = {Piece.RED, Piece.RED, Piece.BLACK, Piece.BLACK, Piece.BLACK, Piece.RED, Piece.RED, Piece.RED, Piece.BLACK};
//
//
//    Piece[][] board10 = { {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}, {e,e,e,e,e,e,e,e}};
//
//    public final int IMMINENT_WIN_POINTS = 1000;
//    public final int OPPONENT_FORK_POINTS = -900;
//    public final int FORK_OPPORTUNITY = 800;
//
//    public void testHeuristic()
//    {
//        ComputerPlayer c = new ComputerPlayer();
//	for (int i=2; i < 5; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Heuristic failed to output the correct value in case imminent win for BLACK", IMMINENT_WIN_POINTS, c.heuristic(b, Piece.BLACK));
//	}
//	System.out.println("Passed all imminent wins for black");
//
//	for (int i=5; i < 8; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Heuristic failed to output the correct value in case imminent win for RED", IMMINENT_WIN_POINTS, c.heuristic(b, Piece.RED));
//	}
//	System.out.println("Passed all imminent wins for red");
//
//	for (int i=8; i < 9; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Heuristic failed to detect a correct value when it was BLACKs turn, but RED had a fork", OPPONENT_FORK_POINTS, c.heuristic(b, Piece.BLACK));
//	}
//	System.out.println("Passed all fork detections on blacks turn when red made a fork");
//
//	for (int i=9; i < 10; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Heuristic failed to detect a correct value when it was RED's turn, but BLACK had a fork", OPPONENT_FORK_POINTS, c.heuristic(b, Piece.RED));
//	}
//	System.out.println("Passed all fork detections on reds turn when black made a fork");
//
//	for (int i=10; i < 11; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Heuristic failed to detect a correct value when it was BLACK has a chance to fork", FORK_OPPORTUNITY, c.heuristic(b, Piece.BLACK));
//	}
//	System.out.println("Passed all fork detections on blacks turn for red making a fork");
//
//	for (int i=11; i < 12; i++) {
//		Board b = new Board(boards[i]);
//		Assert.assertEquals("Heuristic failed to detect a correct value when it was RED has a chance to fork", FORK_OPPORTUNITY, c.heuristic(b, Piece.RED));
//	}
//	System.out.println("Passed all fork detections on reds turn when red can make a fork");
//
//	Board b = new Board(boards[12]);
//	Assert.assertEquals("Heuristic failed to correctly count all groups of three in a row", 3, c.heuristic(b, Piece.RED));
//
//	b = new Board(boards[13]);
//	Assert.assertEquals("Heuristic failed to subtract opponents groups of three in a row", 2, c.heuristic(b, Piece.RED));
//
//	b = new Board(boards[14]);
//	Assert.assertEquals("Heuristic says imminent win when the move is not immediately allowed", 0, c.heuristic(b, Piece.BLACK));
//    }
//
//    public static void main(String[] args) {
//	junit.swingui.TestRunner.run(ComputerPlayerTest.class);
//    }
//}
