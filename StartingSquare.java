
public class StartingSquare extends Square {
	private String playerName;

	public StartingSquare(String name, String playerName) {
		super(name);
		this.playerName = playerName;
	}

	@Override
	public boolean isAccessible() {
		// if the name of the player does not match the name stored by this square then it isn't accessible
		return false;
	}


}
