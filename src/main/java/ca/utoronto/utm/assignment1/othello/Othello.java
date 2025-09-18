package ca.utoronto.utm.assignment1.othello;

import java.util.Random;

/**
 * Capture an Othello game. This includes an OthelloBoard as well as knowledge
 * of how many moves have been made, whosTurn is next (OthelloBoard.P1 or
 * OthelloBoard.P2). It knows how to make a move using the board and can tell
 * you statistics about the game, such as how many tokens P1 has and how many
 * tokens P2 has. It knows who the winner of the game is, and when the game is
 * over.
 * 
 * See the following for a short, simple introduction.
 * https://www.youtube.com/watch?v=Ol3Id7xYsY4
 * 
 * @author arnold
 *
 */
public class Othello {
	public static final int DIMENSION = 8; // This is an 8x8 game
	private char whosTurn = OthelloBoard.P1; // P1 moves first!
	private int numMoves = 0;
	private OthelloBoard theOthelloBoard = new OthelloBoard(DIMENSION);
	private OthelloBoard board;

	public Othello() {
		this.theOthelloBoard = new OthelloBoard(DIMENSION);

	}
	/**
	 * return P1,P2 or EMPTY depending on who moves next.
	 * 
	 * @return P1, P2 or EMPTY
	 */
	public char getWhosTurn() {
		return this.whosTurn;
	}

	/**
	 * Attempt to make a move for P1 or P2 (depending on whos turn it is) at
	 * position row, col. A side effect of this method is modification of whos turn
	 * and the move count.
	 * 
	 * @param row
	 * @param col
	 * @return whether the move was successfully made.
	 */
	public boolean move(int row, int col) {
		if (getWhosTurn() == OthelloBoard.EMPTY) { /* checks to see if game is over*/
			return false;
		}
		boolean successfulMove = false;
		boolean moveMade = this.theOthelloBoard.move(row, col, getWhosTurn());
		if (moveMade) { /* if this is false you either dont have a move or you picked the wrong spot*/
			numMoves++;
			successfulMove = true;
		}
		//no more moves left
		if (this.theOthelloBoard.hasMove() == OthelloBoard.EMPTY) {
			this.whosTurn = OthelloBoard.EMPTY;
			return successfulMove;
		// If u make an invalid move but you can still make a correct move it remains your turn
		} else if (!successfulMove && (this.theOthelloBoard.hasMove() == getWhosTurn() || this.theOthelloBoard.hasMove() == OthelloBoard.BOTH)) {
			return successfulMove;
		// If the other player cant make a move you get to make a move again
		} else if (this.theOthelloBoard.hasMove() != OthelloBoard.otherPlayer(getWhosTurn()) && this.theOthelloBoard.hasMove() != OthelloBoard.BOTH) {
			return successfulMove;
		} else {
			this.whosTurn = OthelloBoard.otherPlayer(getWhosTurn());
			return successfulMove;
		}
	}

	/**
	 * Returns count of player
	 * @param player P1 or P2
	 * @return the number of tokens for player on the board
	 */
	public int getCount(char player) {
		return this.theOthelloBoard.getCount(player);
	}

	/**
	 * Returns the winner of the game.
	 * 
	 * @return P1, P2 or EMPTY for no winner, or the game is not finished.
	 */
	public char getWinner() {
		if (!isGameOver()) {
			return OthelloBoard.EMPTY;
		}
		int p1Total = getCount(OthelloBoard.P1);
		int p2Total = getCount(OthelloBoard.P2);
		if (p1Total > p2Total) {
			return OthelloBoard.P1;
		} else if (p1Total < p2Total) {
			return OthelloBoard.P2;
		} else {
			return 't';
		}
	}

	/**
	 * @return whether the game is over (no player can move next)
	 */
	public boolean isGameOver() {
		return getWhosTurn() == OthelloBoard.EMPTY;
	}

	/**
	 * @return a string representation of the board.
	 */
	public String getBoardString() {
		return this.theOthelloBoard.toString();
	}

	/**
	 *
	 * @param row starting row, in {0,...,dim-1} (typically {0,...,7})
	 * @param col starting col, in {0,...,dim-1} (typically {0,...,7})
	 * @return P1,P2 or EMPTY, EMPTY is returned for an invalid (row,col)
	 */
	public char getPoint(int row, int col) {
		return this.theOthelloBoard.get(row, col);
	}

	/**
	 * run this to test the current class. We play a completely random game. DO NOT
	 * MODIFY THIS!! See the assignment page for sample outputs from this.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Random rand = new Random();

		Othello o = new Othello();
		System.out.println(o.getBoardString());
		while (!o.isGameOver()) {
			int row = rand.nextInt(8);
			int col = rand.nextInt(8);

			if (o.move(row, col)) {
				System.out.println("makes move (" + row + "," + col + ")");
				System.out.println(o.getBoardString() + o.getWhosTurn() + " moves next");
			}
		}

	}
}