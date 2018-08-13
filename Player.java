
public class Player {

	/**
	 * The tokens that players use in the game. They are assigned to the players in this order, starting with
	 * Miss Scarlett being the first one to play.
	 */
	public enum PlayerToken{
		MISS_SCARLETT,
		COLONEL_MUSTARD,
		MRS_WHITE,
		MR_GREEN,
		MRS_PEACOCK,
		PROFESSOR_PLUM;

		/**
		 * @return - the next token clockwise from this PlayerToken
		 */
		public static PlayerToken getNext(PlayerToken current) {
			if (current == PROFESSOR_PLUM)
				return MISS_SCARLETT;

			return PlayerToken.values()[current.ordinal() + 1];
		}
	}

	// ======================================================================================================
	//		PLAYER 
	// ======================================================================================================

	private String name;
	private PlayerToken token;
	private Square location;		// the Square that the player is currently on
	private Hand hand;
	
	/**
	 * A player is created at the start of the game on their specific StartingSquare.
	 * The starting location of the player must be on a StartingSquare.
	 * @param name - of player as entered by user
	 * @param startLocation - StartingSquare to place player (which is also the token player takes)
	 */
	public Player(String name, Square startLocation) {
		if (!(startLocation instanceof StartingSquare))
			throw new IllegalArgumentException("Can't place here! Player must start on a starting square.");
		this.name = name;
		token = PlayerToken.valueOf(((StartingSquare)startLocation).getPlayerLabel());
		this.location = startLocation;
	}
	
	// GETTERS
	/**
	 * @return - player's name as entered at the start
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return - the square that the player currently occupies
	 */
	public Square getSquare() {
		return this.location;
	}
	
	/**
	 * @return - this player's hand of cards
	 */
	public Hand getHand() {
		return hand;
	}
	
	/**
	 * String representation of the player, as displayed to the board. 
	 */
	public String toString() {
		return "#";
	}

	// SETTERS
	
	/**
	 * Moves this player from current location to the new location.
	 * The location must be unoccupied, accessible and not null. 
	 * @param location
	 */
	public void move(Square newLocation) {
		if (newLocation == null)
			throw new IllegalArgumentException();
		
		if (!newLocation.isAccessible())
			throw new IllegalArgumentException("Can't move there! Square is not accessible to players.");
		
		if (newLocation.isOccupied())
			throw new IllegalArgumentException("Can't move there! Square is already occupied.");
		
		location.setOccupied(false, null);
		location = newLocation;
	}
}
