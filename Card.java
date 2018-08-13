import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Card {
	public enum Type{
		PLAYERCARD, WEAPONCARD, ROOMCARD;
	}

	public enum PlayerCard{
		MISS_SCARLETT, COLONEL_MUSTARD, MRS_WHITE, MR_GREEN, MRS_PEACOCK, PROFESSOR_PLUM;
	}

	public enum WeaponCard{
		CANDLESTICK, DAGGER, LEAD_PIPE, REVOLVER, ROPE, SPANNER;
	}

	public enum RoomCard{
		KITCHEN, BALLROOM, CONSERVATORY, DINING_ROOM, BILLIARD_ROOM, LIBRARY, LOUNGE, HALL, STUDY;
	}

	private Type type;
	private String name;
	private boolean isSolution;


	public Card(Type type, String name) {
		//validateCard(type, name);
		this.type = type;
		this.name = name;
	}

	// GETTERS
	public Type getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public boolean isSolution() {
		return isSolution;
	}

	// SETTERS
	public void setSolution(boolean flag) {
		isSolution = flag;
	}

	/**
	 *
	 * @param type
	 * @param name
	 * @return
	 */
	private boolean validateCard(Type type, String name) {
		if (type != Type.PLAYERCARD || type != Type.ROOMCARD || type != Type.WEAPONCARD)
			throw new IllegalArgumentException("Incorrect card type!");
		if (type == Type.PLAYERCARD && Arrays.asList(PlayerCard.values()).contains(PlayerCard.valueOf(name)))
			throw new IllegalArgumentException("Name does not exist for this card type!");
		if (type == Type.WEAPONCARD && Arrays.asList(WeaponCard.values()).contains(WeaponCard.valueOf(name)))
			throw new IllegalArgumentException("Name does not exist for this card type!");
		if (type == Type.ROOMCARD && Arrays.asList(RoomCard.values()).contains(RoomCard.valueOf(name)))
			throw new IllegalArgumentException("Name does not exist for this card type!");

		return true;
	}

	/**
	 * @return - a full deck of cards
	 */
	public static List<Card> getDeck(){
		List<Card> result = new ArrayList<Card>();

		// Adding WeaponCards
		for (WeaponCard w: WeaponCard.values())
			result.add(new Card(Type.WEAPONCARD, w.toString()));

		// Adding PlayerCards
		for (PlayerCard p: PlayerCard.values())
			result.add(new Card(Type.PLAYERCARD, p.toString()));

		// Adding RoomCards
		for (RoomCard r: RoomCard.values())
			result.add(new Card(Type.ROOMCARD, r.toString()));

		return result;
	}

	/**
	 * @return - the 3 solution cards in the order: PlayerCard, RoomCard, WeaponCard
	 */
	public static Card[] getSolution(){
		Card[] result = new Card[3];
		int randIndex;
		randIndex = new Random().nextInt(6);			// Add the PlayerCard
		result[0] = new Card(Type.PLAYERCARD, PlayerCard.values()[randIndex].toString());

		randIndex = new Random().nextInt(9);			// Add the RoomCard
		result[1] = new Card(Type.ROOMCARD, RoomCard.values()[randIndex].toString());

		randIndex = new Random().nextInt(6);			// Add the WeapomCard
		result[2] = new Card(Type.WEAPONCARD, WeaponCard.values()[randIndex].toString());

		return result;
	}
}
