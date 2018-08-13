public class StartingSquare extends Square {
	private String playerLabel;

	public StartingSquare(String name, String playerLabel) {
		super(name);
		this.playerLabel = playerLabel;
	}

	/**
	 * A StartingSquare is accessible only by the player whose name matches the name marked out on it.
	 * Otherwise, it is inaccessible during the game.
	 */
	//@Override
	public boolean isAccessible() {
		// if the name of the player does not match the name stored by this square then it isn't accessible
		if (playerLabel.equals(player.getName()))
			return true;
		
		return false;
	}

	public String getPlayerLabel() {
		return playerLabel;
	}
}