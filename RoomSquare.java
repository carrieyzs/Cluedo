import java.util.HashMap;
import java.util.Map;

/**
 * Each RoomSquare is associated with a Room. A Room will have a collective information for the general
 * RoomSquare, eg. if a RoomSquare has a Weapon, then the Room has a Weapon.
 * @author Carrie
 */
public class RoomSquare extends Square {
	/**
	 * Class that represents the Weapon tokens used in the game.
	 */
	public enum Weapon{
		CANDLESTICK, DAGGER, LEAD_PIPE, REVOLVER, ROPE, SPANNER;
	}

	/**
	 * Class that represents the Rooms in the game. A Room has collective information on the individual
	 * RoomSquares.
	 */
	public enum Room{
		KITCHEN, BALLROOM, CONSERVATORY, DINING_ROOM, BILLIARD_ROOM, LIBRARY, LOUNGE, HALL, STUDY;

		// fields
		private Player player;
		private boolean hasPlayer, hasWeapon;
		private Weapon weapon;

		/**
		 * @return whether a player is in the room
		 */
		public boolean hasPlayer() {
			return hasPlayer;
		}

		/**
		 * @return whether a Weapon was stored in this Room
		 */
		public boolean hasWeapon() {
			return hasWeapon;
		}

		/**
		 * Remembers the player that is in this room
		 * @param flag
		 * @param p
		 */
		public void setPlayer(boolean flag, Player p) {
			this.player = p;
			hasPlayer = flag;
		}

		/**
		 * Assign a weapon to this room
		 * @param w
		 */
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

	/**
	 * The corresponding Square is mapped to the relevant Room, to link the 2 as one kind of location.
	 * @param letter
	 * @param pos
	 */
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

	/**
	 * Modified from the superclass, Square.
	 * If this RoomSquare is the one that has the Weapon, indicates as such.
	 */
	@Override
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

	/**
	 * This square contains the weapon. 
	 * Since it is so, the user doesn't actually interact with the Weapon, so the Weapon's position will never
	 * change from this Square.
	 */
	public void setWeapon() {
		hasWeapon = true;
	}

}
