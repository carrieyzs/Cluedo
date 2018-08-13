/**
 * PlainSquares are those that have no special functionality within the game.
 * @author Carrie
 */
public class PlainSquare extends Square {

	public PlainSquare(String letter, Position pos) {
		super(letter, pos);
	}

	/**
	 * Squares marked as "X" are inaccessible, 
	 * while blank squares and doors are accessible if a player doesn't currently occupy them.
	 */
	@Override
	public boolean isAccessible() {
		if (letter.equals("X") || isOccupied())
			return false;
		
		return true;
	}
}
