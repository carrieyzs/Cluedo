
public class PlainSquare extends Square {

	public PlainSquare(String name) {
		super(name);
	}

	@Override
	public boolean isAccessible() {
		if (name.equals("X"))
			return false;

		return true;
	}


}
