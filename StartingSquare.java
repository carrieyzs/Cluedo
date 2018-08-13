
/**
 * A StartingSquare is the primary location that a player must be placed on, at the start of the game.
 * There are 6 StartingSquares, one designated for each player.
 * @author Carrie
 */
public class StartingSquare extends Square {
	private String playerLabel;

	/**
	 * A StartingSquare has an extra parameter for the player that belongs to it.
	 * @param letter
	 * @param pos
	 * @param playerLabel
	 */
	public StartingSquare(String letter, Position pos, String playerLabel) {
		super(letter, pos);
		this.playerLabel = playerLabel;
	}

	/**
	 * A StartingSquare is accessible only by the player whose name matches the name marked out on it.
	 * Otherwise, it is inaccessible during the game.
	 */
	@Override
	public boolean isAccessible() {
		if (playerLabel.equals(player.getToken().toString()))
			return true;

		return false;
	}

	/**
	 * @return the name of the character assigned to this StartingSquare
	 */
	public String getPlayerLabel() {
		return playerLabel;
	}
}
