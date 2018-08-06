

/**
 * The Square class corresponds to the different types of Squares objects that make up the board.
 * There are PlainSquares, which are accessible(blank) or inaccessible(X).
 * The accessibility of the other Squares (StartingSquare, RoomSquare, DoorSquare) depends on players' positions
 * as the game progresses.
 * @author yangcarr
 */
public abstract class Square {
	protected String name;

	public Square(String name) {
		this.name = name;
	}

	/**
	 * Returns the initial representing the name of this Square, as stored in gameboard.txt.
	 */
	public String toString() {
		return name;
	}

	/**
	 * 2 basic squares are those that the players can move onto.
	 * Squares marked as 'X' are inaccessible. Blank squares and starting squares are accessible.
	 * Other squares (those in a room and those with a door) have accessibility depending on the progression
	 * of the game as other players move around the board.
	 * @return
	 */
	public abstract boolean isAccessible();		// maybe not abstract? if a player occupies this square, then it isn't accessible

	//public abstract Weapon getWeapon();

	//public abstract Player getPlayer();
}
