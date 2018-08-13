

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	import java.util.Random;

	public class Card {
		public enum Type{
			PlayerCard, WeaponCard, RoomCard;
		}
		
		public enum Name{
			MISS_SCARLETT, COLONEL_MUSTARD, MRS_WHITE, MR_GREEN, MRS_PEACOCK, PROFESSOR_PLUM,
			CANDLESTICK, DAGGER, LEAD_PIPE, REVOLVER, ROPE, SPANNER,
			KITCHEN, BALLROOM, CONSERVATORY, DINING_ROOM, BILLIARD_ROOM, LIBRARY, LOUNGE, HALL, STUDY;
		}

		protected final Name name;
		protected final Type type;
		protected boolean isSolution;
		protected static Map<Type, List<Name>> cards;
		
		/**
		 * Constructs a new Card object
		 * Checks whether the type given is an actual type. Then checks whether the name given is the correct
		 * name for that type. 
		 * @param type
		 * @param name
		 */
		public Card(Card.Type type, Card.Name name) {
			cards = new HashMap<Type, List<Name>>();
			fillMap();
			
			// Checks card validity
			if (!(cards.containsKey(type)))
				throw new IllegalArgumentException("Incorrect card type!");
			if (!(cards.get(type)).contains(name))
				throw new IllegalArgumentException("Incorrect card name for card type: " + type.toString());
			
			// Store info
			this.type = type;
			this.name = name;
		}
		
		/**
		 * Maps the Card.Type to the correct Card.Name
		 */
		private void fillMap() {
			List<Name> players = Arrays.asList((Arrays.copyOfRange(Name.values(), 0, 6)));
			List<Name> weapons = Arrays.asList((Arrays.copyOfRange(Name.values(), 6, 12)));
			List<Name> rooms = Arrays.asList((Arrays.copyOfRange(Name.values(), 12, 22)));
			
			cards.put(Type.PlayerCard, players);
			cards.put(Type.WeaponCard, weapons);
			cards.put(Type.RoomCard, rooms);
		}
		
		// GETTERS
		/**
		 * @return - this Card's type
		 */
		public Type getCardType() {
			return type;
		}
		
		/**
		 * @return - name of this Card
		 */
		public Name getCardName() {
			return name;
		}
		
		/**
		 * @return - whether this card is one of cards in the solution
		 */
		public boolean isSolution() {
			return isSolution;
		}
		
		// SETTERS
		/**
		 * @param flag - indicates that the card is a solution card
		 */
		public void setSolution(boolean flag) {
			isSolution = flag;
		}

		/**
		 * @return - the deck of cards in the order as stored in the map
		 */
		public static List<Card> getDeck(){
			List<Card> deckOfAllCards = new ArrayList<Card>();
			//System.out.println("ccc");
			for (Type t: cards.keySet()) {
				

				for (Name n: cards.get(t)) {
					Card c = new Card(t, n);
					deckOfAllCards.add(c);
					//System.out.println("ccc");
				}
			}
			
			return deckOfAllCards;
		}
		
		/**
		 * @return - solution for the game. Gets each card type randomly.
		 */
		public static List<Card> getSolution(){
			List<Card> solution = new ArrayList<Card>();
			// randomly get weapon, player, room
			Card player = getDeck().get(new Random().nextInt(6));		// random nos. from 0-5
			Card weapon = getDeck().get(new Random().nextInt(6) + 6);	// random nos. from 6-11
			Card room = getDeck().get(new Random().nextInt(11) + 12);	// random nos. from 12-21
			
			solution.add(player); 
			solution.add(weapon);
			solution.add(room);
			
			return solution;
		}
	}



