import java.util.ArrayList;
import java.util.List;

/**
 * Represents the set of cards that a player has. 
 * @author Carrie
 */
public class Hand {
	private List<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	/**
	 * Adds card to this player's hand.
	 * The card must not be null, and must not be the solution card.
	 * @param c card to add
	 * @return hand with added card
	 */
	public Hand add(Card c) {
		if (c == null)
			throw new IllegalArgumentException("Invalid card! Card is null");

		if (hand.contains(c))	
			throw new IllegalArgumentException("Invalid card! Card already exists in hand.");

		if (c.isSolution())
			throw new IllegalArgumentException("Invalid card! Cannot add solution card to hand");

		hand.add(c);
		return this;
	}

}
