package ca.utoronto.utm.assignment1.othello;

/**
 * PlayerGreedy makes a move by considering all possible moves that the player
 * can make. Each move leaves the player with a total number of tokens.
 * getMove() returns the first move which maximizes the number of
 * tokens owned by this player. In case of a tie, between two moves,
 * (row1,column1) and (row2,column2) the one with the smallest row wins. In case
 * both moves have the same row, then the smaller column wins.
 *
 * Example: Say moves (2,7) and (3,1) result in the maximum number of tokens for
 * this player. Then (2,7) is returned since 2 is the smaller row.
 *
 * Example: Say moves (2,7) and (2,4) result in the maximum number of tokens for
 * this player. Then (2,4) is returned, since the rows are tied, but (2,4) has
 * the smaller column.
 *
 * See the examples supplied in the assignment handout.
 *
 * @author arnold
 *
 */
// all we need to do is return new move(par1, par2)
	// i dont have to worry with makimg a new board the controller does that


public class PlayerGreedy {
	public static final int DIMENSION = 8; // This is an 8x8 game
	private OthelloBoard theOthelloBoard = new OthelloBoard(DIMENSION);
	private Othello othello;
	private char player;

	public PlayerGreedy(Othello othello, char player) {
		this.othello = othello;
		this.player = player;
	}

	/**
	 * Get and return the first move that results in the most number of tokens for this player
	 * @return the move
	 */
	public Move getMove() {
		int maxFlip = 0; // see which iteration of move caused the most flips
		int[] coordinate = {0,0};
		int premove = this.othello.getCount(this.player);

		// go through all positions on the board
		for (int r = 0; r < Othello.DIMENSION; r++) {
			for (int c = 0; c < Othello.DIMENSION; c++) {
				// check to see if it is possible to play on this posiiton
				if (this.othello.getPoint(r, c) == OthelloBoard.EMPTY) {
					// create a copy board
					for (int r1 = 0; r1 < theOthelloBoard.getDimension(); r1++) {
						for (int c1 = 0; c1 < theOthelloBoard.getDimension(); c1++) {
							// gets the current char at the game board and changes the copy board to reflect the old board
							theOthelloBoard.set(r1, c1, this.othello.getPoint(r1, c1));
						}
					}
					theOthelloBoard.move(r, c, this.player);
					// checks to see if the move made is indeed the best or not
					if (theOthelloBoard.getCount(this.player) - premove > maxFlip) {
						maxFlip = theOthelloBoard.getCount(this.player) - premove;
						coordinate = new int[]{r, c};
					}
					// delete the old board and put a new one in its place
					theOthelloBoard = new OthelloBoard(DIMENSION);
				}
			}
		}
		return new Move(coordinate[0], coordinate[1]);
	}
}