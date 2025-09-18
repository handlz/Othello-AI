package ca.utoronto.utm.assignment1.othello;

import java.util.ArrayList;
import java.util.Random;

/**
 * PlayerRandom makes a move by first determining all possible moves that this
 * player can make, putting them in an ArrayList, and then randomly choosing one
 * of them.
 * 
 * @author arnold
 *
 */
public class PlayerRandom {
	private Random rand = new Random();
	private Random randomGenerator;
	public static final int DIMENSION = 8; // This is an 8x8 game
	private OthelloBoard theOthelloBoard = new OthelloBoard(DIMENSION);
	private Othello othello;
	private char player;

	public PlayerRandom(Othello othello, char player) {
		this.othello = othello;
		this.randomGenerator = new Random();
		this.player = player;
	}

	/**
	 * Get and return a random move from all the posssible move this player can maek
	 * @return the move
	 */
	public Move getMove() {
		ArrayList<Move> availableMoves = gatherValidMoves();

		if (availableMoves.isEmpty()) {
			return null;
		}

		int randomIndex = randomGenerator.nextInt(availableMoves.size());
		return availableMoves.get(randomIndex);
	}


	private ArrayList<Move> gatherValidMoves() {
		boolean success = false;
		ArrayList<Move> validMoves = new ArrayList<>();
		// what if i only do this if hasmove;		then i dont need that if statement 		i CANt do that has move doesnt return a move
		for (int r = 0; r < theOthelloBoard.getDimension(); r++) {
			for (int c = 0; c < theOthelloBoard.getDimension(); c++) {
				if (this.othello.getPoint(r, c) == OthelloBoard.EMPTY) {
					// collect all moves and do a random one 	I LWOKEY DID THIS IN HASMOVE
					for (int r1 = 0; r1 < theOthelloBoard.getDimension(); r1++) {
						for (int c1 = 0; c1 < theOthelloBoard.getDimension(); c1++) {
							theOthelloBoard.set(r1, c1, this.othello.getPoint(r1, c1));// this line gets the current char at the game board and changes the copy board to reflect the old board
						}
					}
					// maybe i can do has move instead NO hasmove has 4 for loops
					success = theOthelloBoard.move(r, c, this.player);
					if (success) {
						validMoves.add(new Move(r, c));
					}
					theOthelloBoard = new OthelloBoard(DIMENSION);
				}
			}
		}
		return validMoves;
	}
}
