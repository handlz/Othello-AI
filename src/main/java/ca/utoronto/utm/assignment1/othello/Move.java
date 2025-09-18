package ca.utoronto.utm.assignment1.othello;
/**
 * 
 * @author arnold
 *
 */
public class Move {
	private int row, col;

	public Move(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public int getCol() {
		return col;
	}

	/**
	 * @return the string representation of row and col
	 */
	public String toString() {
		return "(" + this.row + "," + this.col + ")";
	}
}
