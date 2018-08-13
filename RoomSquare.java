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
		
		public boolean hasPlayer() {
			return hasPlayer;
		}
		
		public void setPlayer(boolean flag) {
			hasPlayer = flag;
		}
	}
	
	// ======================================================================================================
	//		RoomSquare 
	// ======================================================================================================
	// fields
	private static Map<String, Room> rooms;
	private Room room;
	
	public RoomSquare(String letter, Position pos) {
		super(letter, pos);
		rooms = new HashMap<String, Room>();
		fillMap();
		room = rooms.get(letter);
	}

		/**
		 * Links the RoomSquares to the corresponding Rooms
		 */
	private final void fillMap() {
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

	// incomplete method 
	@Override
	public boolean isAccessible() {
		return true;		// just for compiling
	}
	


}
