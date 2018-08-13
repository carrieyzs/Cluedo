import java.util.HashMap;
import java.util.Map;


public class RoomSquare extends Square {
	public enum Weapon{
		CANDLESTICK, DAGGER, LEAD_PIPE, REVOLVER, ROPE, SPANNER;
	}

	public enum Room{
		KITCHEN, BALLROOM, CONSERVATORY, DINING_ROOM, BILLIARD_ROOM, LIBRARY, LOUNGE, HALL, STUDY;

		// fields
		private Player player;
		private boolean hasPlayer, hasWeapon;
		private Weapon weapon;

		public boolean hasPlayer() {
			return hasPlayer;
		}

		public boolean hasWeapon() {
			return hasWeapon;
		}

		public void setPlayer(boolean flag, Player p) {
			this.player = p;
			hasPlayer = flag;
		}

		public void setWeapon(Weapon w) {
			hasWeapon = true;
			this.weapon = w;
		}
	}

	// ======================================================================================================
	//		RoomSquare
	// ======================================================================================================
	// fields
	private static Map<String, Room> rooms;
	private Room room;
	private boolean hasWeapon;

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

	public boolean hasWeapon() {
		return hasWeapon;
	}

	public String toString() {
		if (hasWeapon)
			return "!";
		else if (isOccupied)
			return player.getName();

		return letter;
	}

	// SETTERS

	/**
	 * When player is occupying a RoomSquare, the Room will have this information as well.
	 * A player cannot occupy a Square that has a weapon.
	 */
	public void setOccupied(boolean flag, Player p) {
		super.setOccupied(flag, p);
		room.setPlayer(flag, p);
	}

	public void setWeapon() {
		hasWeapon = true;
	}

}
