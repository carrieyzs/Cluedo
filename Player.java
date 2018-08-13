
/**
 * There is a token corresponding to each player.
 * Player needs to know its location (the Square it is on), the cards in his hand and moves he can make.
 */
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
		 * @return the next token clockwise from this PlayerToken (in order of play)
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
	 * The starting location of the player must be on a StartingSquare.(?)
	 * @param name of player as entered by user
	 * @param startLocation StartingSquare to place player (which is also the token player takes)
	 */
	public Player(String name, Square location, PlayerToken token) {
		//Square.validateSquare(location);
		this.name = name;
		this.location = location;
		this.token = token;
		location.setOccupied(true, this);
		hand = new Hand();
	}

	// GETTERS
		/**
		 * @return player's name as entered at the start
		 */
		public String getName() {
			return this.name;
		}

		/**
		 * @return the square that the player currently occupies
		 */
		public Square getSquare() {
			return this.location;
		}

		/**
		 * @return corresponding player token
		 */
		public PlayerToken getToken() {
			return token;
		}

		/**
		 * @return player's hands
		 */
		public Hand getHand() {
			return hand;
		}

		/**
		 * Sets player's hand to the new hand
		 */
		public void setHand(Hand newHand) {
			hand = newHand;
		}

		/**
		 * Moves this player from current location to the new location.
		 * The location must be unoccupied, accessible and not null.
		 * @param location
		 */
		public void move(Square newLocation) {
			//Square.validateSquare(newLocation);
			Square prevLocation = location;
			location = newLocation;
			location.setOccupied(true, this);
			prevLocation.setOccupied(false, null);
			
		}

		// refute method
}