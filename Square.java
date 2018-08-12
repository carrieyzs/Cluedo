

/**
 * The Square class corresponds to the different types of Squares objects that make up the board.
 * The subclasses are PlainSquare, StartingSquare, RoomSquare and DoorSquare depends on players' positions
 * as the game progresses.
 * @author yangcarr
 */
public abstract class Square {
	protected String name;
	protected Player player;
	protected boolean isOccupied, isAccessible;

	public Square(String name) {
		this.name = name;
	}
	
	// GETTERS
	/**
	 * Some squares are accessible, depending on the the progression of the game. 
	 * @return - accessibility of this Square
	 */
	public abstract boolean isAccessible();	
	
	/**
	 * @return - the initial representing the name of this Square(as stored in gameboard.txt)
	 */
	@Override
	public String toString() {
		// if the square is occupied, string is #, otherwise it is the name
		return name;
	}
	
	/**
	 * @return - whether a player currently occupies this Square
	 */
	public boolean isOccupied(){
		return player == null;
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
	

}
