package ca.utoronto.utm.assignment1.othello;

/**
 * Determine whether the first player or second player has the advantage when
 * both are playing a Random Strategy.
 * 
 * Do this by creating two players which use a random strategy and have them
 * play each other for 10000 games. What is your conclusion, does the first or
 * second player have some advantage, at least for a random strategy? 
 * State the null hypothesis H0, the alternate hypothesis Ha and 
 * about which your experimental results support. Place your short report in
 * randomVsRandomReport.txt.
 * 
 * @author arnold
 *
 */
public class OthelloControllerRandomVSRandom {
	/**
	 * Run main to execute the simulation and print out the two line results.
	 * Output looks like 
	 * Probability P1 wins=.75 
	 * Probability P2 wins=.20
	 * @param args
	 */
	public static void main(String[] args) {
		int randomPlayerWins1 = 0;
		int randomPlayerWins2 = 0;
		final int totalGames = 10000;  // The number of games to simulate

		// Simulate multiple games between Random and Greedy players
		for (int gameIndex = 0; gameIndex < totalGames; gameIndex++) {

			// Create a new game instance
			Othello othello = new Othello();
			PlayerRandom playerRandom1 = new PlayerRandom(othello, OthelloBoard.P1);
			PlayerRandom playerRandom2 = new PlayerRandom(othello, OthelloBoard.P2);

			// Play the game until completion
			while (!othello.isGameOver()) {
				Move move = null;

				// Determine whose turn it is and get the corresponding move
				if (othello.getWhosTurn() == OthelloBoard.P1) {
					move = playerRandom1.getMove();
				} else if (othello.getWhosTurn() == OthelloBoard.P2) {
					move = playerRandom2.getMove();
				}
				othello.move(move.getRow(), move.getCol());
				if (othello.getWinner() == OthelloBoard.P1) {
					randomPlayerWins1++;
				} else if (othello.getWinner() == OthelloBoard.P2) {
					randomPlayerWins2++;
				}
			}
		}
		double percentageRandom1 = (double) randomPlayerWins1 / (double) totalGames;
		double percentageRandom2 = (double) randomPlayerWins2 / (double) totalGames;
		System.out.println("Random player1 wins: " + percentageRandom1);
		System.out.println("Random player2 wins: " + percentageRandom2);
	}
}
