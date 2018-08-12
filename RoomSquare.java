import java.util.HashMap;
import java.util.Map;



public class RoomSquare extends Square {
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
		
		private boolean hasPlayer;
	}

	// fields
	private static Map<String, Room> rooms;
	private Room room;
	

	public RoomSquare(String name) {
		super(name);
		rooms = new HashMap<String, Room>();
		fillMap();
		room = rooms.get(name);
	}

	/**
	 * Links the RoomSquares to the corresponding Rooms
	 */
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

	// GETTERS
	/**
	 * @return - the room corresponding to this RoomSquare
	 */
	public Room getRoom() {
		return room;
	}

	
	// SETTERS
	
	/**
	 * 
	 */
	@Override
	public boolean isAccessible() {
		// if player is on the square, then the square is not accessible
		return true;		// true for now
	}
}
