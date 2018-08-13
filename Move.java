import java.util.Arrays;

public class Move {

	private int diceRoll;
	private String[] moveSequence;

	/**
	 * The user's move sequence are separated by commas. So if user just enter one sequence, that needs to end
	 * with a comma.
	 * @param moveSequence
	 * @param diceRoll
	 */
	public Move(String moveSequence, int diceRoll) {
		if (moveSequence.length() <= 1)			
			throw new IllegalArgumentException("Invalid move sequence. Please make a correct move!");
		
		this.diceRoll = diceRoll;
		
		String modifiedSequence = validateMoveSequence(moveSequence);
		this.moveSequence = modifiedSequence.split(",");

		
	}

	/**
	 * Method checks the validity of the move sequence. The loops increment by 3 to skip over commas.
	 * Method checks if the move sequence follows the pattern, the no. of steps matches the no. on the dice
	 * and that no position in the sequence is repeated.
	 * @param moveSequence
	 * @return
	 */
	private String validateMoveSequence(String moveSequence) {
		String result = moveSequence.trim();
		int sum = 0;

		// checks for valid direction
		for (int i=0; i<result.length(); i+=3) {
			String c = Character.toString(result.charAt(i));
			
			if ( !(c.equalsIgnoreCase("U") || c.equalsIgnoreCase("D") ||
					c.equalsIgnoreCase("L") || c.equalsIgnoreCase("R")) )
				throw new IllegalArgumentException("Invalid move sequence! Unspecified direction: " + result.charAt(i));
		}

		// checks for valid no. of steps
		for (int i=1; i<result.length(); i+=3) {
			int step = Integer.parseInt(result.substring(i, i+1));		// throws NumberFormatException -- should handle this?..
			sum += step;

		}
		if (sum != diceRoll)
			throw new IllegalArgumentException("Invalid move sequence! Number of steps do not match dice roll");

		// checks for moving backwards
		
		return result;
	}

	/**
	 * Indicates whether or not there's still moves left to make.
	 * @return
	 */
	public boolean isFinish() {
		return moveSequence.length == 0;
	}

	/**
	 * Method to get the next position from the current position, in the direction specified.
	 * If the position is any one of those on the edges of the board, null is returned.
	 * Note that the y values increase as you go down, since that's the way the board is read and displayed.
	 * @param dir direction to move towards
	 * @param current position to move from
	 * @return the incremental position from the current position
	 */
	public Position getDir(String dir, Position current) {
		int row = current.getRow();
		int col = current.getCol();
		boolean isValid = false;

		switch(dir) {										
		case "U": case "u":			// one row up
			isValid = (row==0) ? false : true;
			row -= 1;					
			break;
		case "D": case "d":			// one row down
			isValid = (row==Board.HEIGHT-1) ? false : true;
			row += 1;
			break;
		case "L": case "l":			// one column left
			isValid = (col==0) ? false : true;
			col -= 1;
			break;
		case "R": case "r":			// one column right
			isValid = (col==Board.WIDTH-1) ? false : true;
			col += 1;
		}

		if (!isValid)
			return null;

		return new Position(row, col);
	}

	/**
	 * This method returns the first parts of the move sequence. So when that part is returned, the index 
	 * increments and doesn't return, so this method should be called just once.
	 * @return first part of the move sequence by user input
	 */
	public String get() {
		if (isFinish())
			return null;

		String result = moveSequence[0];		// returns the first part of the move sequence
		moveSequence = Arrays.copyOfRange(moveSequence, 1, moveSequence.length);	// rest of the moves
		return result;
	}
}
