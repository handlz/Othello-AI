package ca.utoronto.utm.assignment1.othello;

/**
 * This controller uses the Model classes to allow the Human player P1 to play
 * the computer P2. The computer, P2 uses a random strategy. 
 * 
 * @author arnold
 *
 */
public class OthelloControllerHumanVSRandom {
	
	/**
	 * Run main to play a Human (P1) against the computer P2. 
	 * The computer uses a random strategy, that is, it randomly picks 
	 * one of its possible moves.
	 * The output should be almost identical to that of OthelloControllerHumanVSHuman.

	 * @param args
	 */
	protected Othello othello;
	PlayerHuman playerHuman;
	PlayerRandom playerRandom;

	public OthelloControllerHumanVSRandom() {
		othello = new Othello();
		this.playerHuman = new PlayerHuman(this.othello, OthelloBoard.P1);
		this.playerRandom = new PlayerRandom(this.othello, OthelloBoard.P2);
	}

	/**
	 * Play a game of othello to completion
	 */
	public void play() {
		while (!othello.isGameOver()) {
			this.report();
			Move move = null;
			char whosTurn = this.othello.getWhosTurn();

			if (this.othello.getWhosTurn() == OthelloBoard.P1) {
				move = this.playerHuman.getMove();
			} else if (this.othello.getWhosTurn() == OthelloBoard.P2) {
				move = this.playerRandom.getMove();
			}
			this.reportMove(whosTurn, move);
			othello.move(move.getRow(), move.getCol());
		}
		this.reportFinal();
	}

	private void reportMove(char whosTurn, Move move) {
		System.out.println(whosTurn + " makes move " + move + "\n");
	}

	private void report() {
		String s = othello.getBoardString() + OthelloBoard.P1 + ":"
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2) + "  "
				+ othello.getWhosTurn() + " moves next";
		System.out.println(s);
	}

	private void reportFinal() {
		String s = othello.getBoardString() + OthelloBoard.P1 + ":"
				+ othello.getCount(OthelloBoard.P1) + " "
				+ OthelloBoard.P2 + ":" + othello.getCount(OthelloBoard.P2)
				+ "  " + othello.getWinner() + " won\n";
		System.out.println(s);
	}

	public static void main(String[] args) {
		OthelloControllerHumanVSRandom oc = new OthelloControllerHumanVSRandom();
		oc.play();
	}
}
