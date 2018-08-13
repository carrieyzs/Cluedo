
public abstract class Square {
	protected Position pos;
	protected String letter;
	protected boolean isOccupied, isAccessible;
	protected Player player;

	public Square(String letter, Position pos) {
		this.letter = letter;
		this.pos = pos;
	}

	// GETTERS
	/**
	 * Some squares are accessible, depending on the the progression of the game.
	 * @return - accessibility of this Square
	 */
	public abstract boolean isAccessible();

	/**
	 * @return - position of this Square on the board
	 */
	public Position getPosition() {
		return pos;
	}

	/**
	 * @return - the String representation of the Square
	 * @return
	 */
	public String toString() {
		if (isOccupied)
			return player.getName();

		return letter;
	}

	/**
	 * @return - whether a player currently occupies this Square
	 */
	public boolean isOccupied(){;
		return isOccupied;
	}

	/**
	 * @return - the current player occupying this Square
	 */
	public Player getPlayer() {
		return player;
	}

	// SETTERS
	/**
	 * Indicates whether the current square is already occupied by another player.
	 * A square that is occupied, is not accessible to any other players.
	 * Used to move player from one Square to another.
	 * @param flag
	 */
	public void setOccupied(boolean flag, Player p) {
		player = p;
		isOccupied = flag;
		if (flag == true)
			isAccessible = false;
	}


	/**
	 * Method checks if the square is available for players to move onto.
	 * @param from
	 * @param s
	 * @return
	 */
	public static boolean validateSquare(Square from, Square s) {
		if (s == null)
			throw new IllegalArgumentException();

		if (!s.isAccessible())
			throw new IllegalArgumentException("Can't move there! Square is not accessible to players.");

		if (s.isOccupied())
			throw new IllegalArgumentException("Can't move there! Square is already occupied.");

		if (from.toString().equals(" ") && (s instanceof RoomSquare))
			throw new IllegalArgumentException("Can't move into a wall!");
		
		if ((s instanceof RoomSquare) && ((RoomSquare)s).hasWeapon())
			throw new IllegalArgumentException("Can't move there! Square is occupied by a weapon.");

		

		return true;
	}
}
