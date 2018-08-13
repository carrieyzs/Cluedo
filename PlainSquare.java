
/**
 * PlainSquares are those that have no special functionality within the game.
 * @author Carrie
 */
public class PlainSquare extends Square {

	public PlainSquare(String name) {
		super(name);
	}

	/**
	 * Squares marked as "X" are inaccessible, while blank squares are accessible (represents a path).
	 */
	@Override
	public boolean isAccessible() {
		if (name.equals("X"))
			return false;

		return true;
	}

}
