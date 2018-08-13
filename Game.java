import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	String state = "start";
	int numOfPlayers;
	Board gameboard;
	List<Player> players;
	//List<Card> deck;
	//List<Card> envelope;	// stores the 3 solution cards in the order: PlayerCard, WeaponCard, RoomCard
	Player currentPlayer;			// Miss Scarlett always plays first;
	Player nextPlayer;
	
	public Game() {
		// Get new board and players
		gameboard = new Board();
		players = new ArrayList<Player>();
		
		// Get the number of players
		System.out.println("Welcome to Cluedo!\nHow many players will there be?(minimum 3)\n");
		Scanner reader = new Scanner(System.in);

		do {
			try {

				System.out.print("Enter no. of players: ");
				String num = reader.next();
				numOfPlayers = Integer.parseInt(num);
			}
			catch (NumberFormatException e) {				// checks user entered an int
				System.out.println("Please enter number of players in valid numeric form!");
			}
		}
		while (!validatePlayers(numOfPlayers));			// checks user entered correct number of players
		reader.close();

		System.out.println(gameboard.toString());
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
}
