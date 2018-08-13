
/**
 * Position class specifies the position of the squares on the board. 
 */
public class Position {

	private int row, col;
	
	/**
	 * In the game, a Position is made for each square as it is being read in from the file.
	 * @param row
	 * @param col
	 */
	public Position(int row, int col) {
		this.row = row;
		this.col = col;
	}

	/**
	 * @return row position
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * @return column position
	 */
	public int getCol() {
		return col;
	}
}
