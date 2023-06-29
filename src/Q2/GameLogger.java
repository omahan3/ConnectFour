package Q2;


// keeps track of the moves made during one game.
public class GameLogger {
    private int[] moveList;
    private int size;
    private int numMoves;

    public GameLogger () {
        moveList = new int[2];
        size = 2;
        numMoves = 0;
    }

    // adds a move (column number) to the memory array.
    // If there is no room for the new move, create a new one with double the size and deep copy everything over.
    public void addMove (int newMove) {

        if (numMoves < size) {
            moveList[numMoves++] = newMove;
        } else {
            int[] temp = new int[size];
            for (int i = 0; i < size; i++) {
                temp[i] = moveList[i];
            }
            moveList = new int[2*size];
            for (int i = 0; i < size; i++) {
                moveList[i] = temp[i];
            }
            moveList[numMoves++] = newMove;
            size = size*2;
        }
    }


    // Prints the moves made during a game.
    // Only prints the column number of the next move, not a recreation of the game board after each move.
    public void printGameFromList() {
        for (int i = 0; i < numMoves; i++) {
            if (i%2 == 0) {
                System.out.println("X\t" + moveList[i]);
            } else {
                System.out.println("O\t" + moveList[i]);
            }
        }
    }
}
