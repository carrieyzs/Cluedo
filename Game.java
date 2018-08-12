import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Generates a digital version of the Cluedo board game. This version is simplified and purely
 * text-based. All players are assumed to be real people, involved in the game. The game operates via
 * input-output between players' choices and the implemented game logic.
 *
 * @author Carrie
 */
public class Game {
	String state = "start";
	
	int numOfPlayers;
	Map<Player, Player.PlayerToken> players;
	Board gameboard;
	List<Card> deck;
	List<Card> solution;
	
	/**
	 * Generates a new game.
	 */
	public Game() {
		players = new HashMap<Player, Player.PlayerToken>();
		deck = new ArrayList<Card>();
		gameboard = new Board();
		
		// Get the number of players
		System.out.println("Welcome to Cluedo!\nHow many players will there be?(minimum 3)\n");
		Scanner reader = new Scanner(System.in);
		
		do {
			try {
				
				System.out.print("Enter no. of players: ");
				//numOfPlayers = reader.nextInt();		//catching InputMismatchException didn't handle str
				String num = reader.next();
				numOfPlayers = Integer.parseInt(num);
			}
			catch (NumberFormatException e) {			//catch (InputMismatchException e) {
				System.out.println("Please enter number of players in valid numeric form!");
			}
		}
		while (!validatePlayers(numOfPlayers));
		
		System.out.println(numOfPlayers);
		System.out.println(gameboard.getStartingSquares().size());
		System.out.println(gameboard.size());
		System.out.println(gameboard.toString());
		
		// At this point, will have correct no. of players
		// So we can go ahead and set the players to the correct positions
		/*for (int i=0; i<numOfPlayers; i++) {
			System.out.println();
			System.out.print("Player " + (i+1) + " name : "); // issue here: board doesn't read sq properly
			StartingSquare characterSquare = gameboard.getStartingSquares().get(i);
			Player p = new Player(reader.next(), characterSquare);
			players.put(p, Player.PlayerToken.valueOf(characterSquare.getPlayerLabel()));
		}*/
		
		reader.close();
		initialise();			// Initialise the game
	}
	

	/**
	 * Checks whether the input from the user is valid for the game.
	 * Number of players must be [3,6]
	 * @param num - no. of players to check
	 * @return
	 */
	public boolean validatePlayers(int num) {
		if (num < 3 || num > 6) {
			System.out.println("Sorry! Only 3-6 players are allowed!");
			return false;
		}

		return true;
	}
	
	/**
	 * Sets up the game to be played. 
	 * The solution of the game is chosen and put in the envelope. The remaining deck of cards is then
	 * shuffled and distributed to the players. 
	 */
	public void initialise() {
		state = "play";					// The state of the game is now on playing mode
		
		deck = Card.getDeck();			// get the deck of cards
		solution = Card.getSolution(); // get the solution and remove it from the deck
		for (Card c: solution) 
			deck.remove(c);
		
		Collections.shuffle(deck); 				// shuffle the remaining deck of cards
		distributeCards();
		playGame();
	}
	
	public void distributeCards() {
		// go through each of the list of players (map.keyset)
		// get the player's hand and add current card to it (deck.remove(0))
		// keep doing this for each of the players
	}
	
	public void playGame() {
		// while the state is not end
		// currentplayer.move --> diceroll
		// then if current player is in a room, offer to suggest
		// else state changes to refute
		// switch to next player
		
		// have a player state(?) --> that changes the state of current player to move, and every other 
											// player to refute
	}

	public static void main(String[] args) {
		new Game();
	}

//==========================================================================================================
// INNER CLASS (ENVELOPE) ----- maybe not needed?....
//==========================================================================================================
	/**
	 * Private inner class, Envelope, represents the envelope in the game that is used to store the 3 cards,
	 * PlayerCard, WeaponCard, RoomCard, representing the solution of the game.
	 *
	 * @author Carrie
	 */
	private class Envelope{
		// 3 Card fields
		private Card weapon, character, room;
		
		/**
		 * Input 3 cards into the Envelope. Checks that the cards are WeaponCard, PlayerCard and RoomCard
		 * types. 
		 * @param weapon
		 * @param character
		 * @param room
		 */
		private Envelope(Card player, Card weapon, Card room) {
			this.weapon = weapon;
			this.character = character;
			this.room = room;
		}
		
		
		/**
		 * @return - String representation of the contents of the envelope (the solution of the game)
		 */
		private String show() {
			return "The crime was committed in the " + room.getCardName().toString() 
					+" by " + character.getCardName().toString() 
					+ " with the " + weapon.getCardName().toString();
		}
}
}