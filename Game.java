import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Generates a digital version of the Cluedo board game. This version is simplified and purely
 * text-based. All players are assumed to be real people, involved in the game. The game operates via
 * input-output between players' choices and the implemented game logic.
 *
 * @author Carrie
 */
public class Game {
	// Fields
	private int num;			// number of players in game
	private Board gameboard;

	/**
	 * Creates a new game.
	 */
	public Game(){
		// ask how many players
		do {
			try {
				Scanner reader = new Scanner(System.in);
				System.out.println("Enter no. of players: ");
				num = reader.nextInt();
				reader.close();
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter number of players in valid numeric form!");
			}
		}
		while (!validatePlayers(num));

		gameboard = new Board();	// generate new board with player positions (initialise() method)
		updateGame();			// draws the current game

		// (randomly choose players?)
		// start game (all the dice rolls and moves, etc)
		// end game (print out message, stop the game?)
	}

	/**
	 * Checks whether the input from the user is valid for the game.
	 * @param num - no. of players to check
	 * @return
	 */
	public boolean validatePlayers(int num) {
		if (num < 3 || num > 6) {		// number of players must be [3,6]
			System.out.println("Sorry! Only 3-6 players are allowed!");
			return false;
		}

		return true;
	}

	public void updateGame() {
		System.out.println(gameboard.toString());		// prints the board
		// prints respective player's turn
	}

	/*
	 * make a method to validate the state of the game each time?
	 * - check only one envelope allowed
	 * - check move is legal or not
	 * - check the suggestions or accusations are valid(?)
	 * - check if game is won(?)
	 */

	public static void main(String[] args) {
		new Game();

	}

//==========================================================================================================
// ENVELOPE CLASS
//==========================================================================================================
	/**
	 * Private inner class, Envelope, represents the envelope in the game that is used to store the 3 cards,
	 * PlayerCard, WeaponCard, RoomCard, representing the solution of the game.
	 *
	 * @author Carrie
	 */
	private class Envelope{
		// 3 Card fields

		/**
		 * A new envelope stores the 3 cards containing the solution to the murder.
		 * When a new envelope is made, it is hidden (in this case, placed on the center of the board).
		 */
		private Envelope() {		// Constructor takes in 3 cards and stores in fields

		}

		/**
		 * @return - contents of the envelope (the solution of the game)
		 */
		private String show() {
			return "The crime was committed in the ROOM by PERSON with the WEAPON";
		}

		/**
		 * Returns the string representation of the envelope
		 */
		private String getName() {
			return "Case File CONFIDENTIAL";
		}
	}
}
