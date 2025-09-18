package ca.utoronto.utm.assignment1.othello;

/**
 * The goal here is to print out the probability that Random wins and Greedy
 * wins as a result of playing 10000 games against each other with P1=Random and
 * P2=Greedy. What is your conclusion, which is the better strategy?
 * @author arnold
 *
 */
public class OthelloControllerRandomVSGreedy {

	/**
	 * Run main to execute the simulation and print out the two line results.
	 * Output looks like: 
	 * Probability P1 wins=.75 
	 * Probability P2 wins=.20
	 * @param args
	 */
	public static void main(String[] args) {
		int randomPlayerWins = 0;
		int greedyPlayerWins = 0;
		final int totalGames = 10000;  // The number of games to simulate

		// Simulate multiple games between Random and Greedy players
		for (int gameIndex = 0; gameIndex < totalGames; gameIndex++) {

			// Create a new game instance
			Othello othello = new Othello();
			PlayerRandom playerRandom = new PlayerRandom(othello, OthelloBoard.P1);
			PlayerGreedy playerGreedy = new PlayerGreedy(othello, OthelloBoard.P2);

			// Play the game until completion
			while (!othello.isGameOver()) {
				Move move = null;
				char whosTurn = othello.getWhosTurn();

				// Determine whose turn it is and get the corresponding move
				if (othello.getWhosTurn() == OthelloBoard.P1) {
					move = playerRandom.getMove();
				} else if (othello.getWhosTurn() == OthelloBoard.P2) {
					move = playerGreedy.getMove();
				}
				othello.move(move.getRow(), move.getCol());
			if (othello.getWinner() == OthelloBoard.P1) {
				randomPlayerWins++;
			} else if (othello.getWinner() == OthelloBoard.P2) {
				greedyPlayerWins++;
			}
			}
		}
		double percentageRandom = (double) randomPlayerWins / (double) totalGames;
		double percentageGreedy = (double) greedyPlayerWins / (double) totalGames;
		System.out.println("Random player wins: " + percentageRandom);
		System.out.println("Greedy player wins: " + percentageGreedy);
	}
}