import java.util.HashMap;
import java.util.Map;



public class RoomSquare extends Square {
	// Squares that are rooms are treated as one location
	// so players can be placed anywhere in a room
	public enum Room{
		KITCHEN,
		BALLROOM,
		CONSERVATORY,
		DINING_ROOM,
		BILLIARD_ROOM,
		LIBRARY,
		LOUNGE,
		HALL,
		STUDY;
	}

	// fields
	private static Map<String, Room> rooms;
	private boolean isAccessible;

	public RoomSquare(String name) {
		super(name);
		rooms = new HashMap<String, Room>();
		fillMap();
	}

	private static final void fillMap() {
		rooms.put("K", Room.KITCHEN);
		rooms.put("B", Room.BALLROOM);
		rooms.put("C", Room.CONSERVATORY);
		rooms.put("D", Room.DINING_ROOM);
		rooms.put("R", Room.BILLIARD_ROOM);
		rooms.put("L", Room.LIBRARY);
		rooms.put("O", Room.LOUNGE);
		rooms.put("H", Room.HALL);
		rooms.put("T", Room.STUDY);
	}


	/**
	 *
	 */
	@Override
	public boolean isAccessible() {
		// if player is on the square, then the square is not accessible
		return true;		// true for now
	}

	// get the room
}
