import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Game {
	private boolean isPlaying;
	int numOfPlayers;
	Board gameboard;
	List<Player> players;
	List<Card> deck;
	Card[] envelope;	// stores the 3 solution cards in the order: PlayerCard, WeaponCard, RoomCard
	Player currentPlayer;			// Miss Scarlett always plays first;
	Player nextPlayer;
	Die dice;

	// constant lists of positions to place players and weapons
	private static final ArrayList<Position> startPositions = new ArrayList<>(Arrays.asList(new Position(24,7), new Position(17,0), new Position(0,9),
																							new Position(0,14), new Position(6,23), new Position(19,23)));

	private static final ArrayList<Position> weaponPositions = new ArrayList<>(Arrays.asList(new Position(3,3), new Position(3,13), new Position(2, 21),
																							new Position(11,2), new Position(10,21), new Position(16,22),
																							new Position(22,4), new Position(22,13), new Position(23,21)));

	public Game() {
		// Get new board and players
		gameboard = new Board();
		players = new ArrayList<Player>();
		deck = Card.getDeck();
		dice = new Die(2);

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
		System.out.println();

		// At this point, will have correct no. of players
		// So we can go ahead and set the players to the correct positions on the gameboard

		for (int i=0; i<numOfPlayers; i++) {
			Square s = gameboard.getSquareFromPosition(startPositions.get(i));
			Player.PlayerToken t = Player.PlayerToken.valueOf(((StartingSquare)s).getPlayerLabel());
			Player p = new Player(Integer.toString(i+1), s, t);
			players.add(p);
		}

		initialise();
		reader.close();

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
	 * Initialiase the game: sets up the solution
	 */
	public void initialise() {
		currentPlayer = players.get(0);
		nextPlayer = players.get(1);
		isPlaying = true;
		envelope = Card.getSolution();
		distributeCards();
		setWeapons();
		setPlayerState();
		System.out.println(gameboard.toString());
		playGame();
	}

	/**
	 * Gets the solutions, shuffles the remaining cards and distribute them to players.
	 */
	public void distributeCards() {
		for (Card c: envelope) 				// remove the solution cards from the deck
			deck.remove(c);

		Collections.shuffle(deck); 							// shuffle

		for (Player p: players) {				// distribute
			p.setHand(p.getHand().add(deck.remove(0)));
		}
	}

	/**
	 * Sets random Weapons in random Rooms
	 */
	public void setWeapons() {
		// gets the list of weapons and rooms

		ArrayList<RoomSquare.Weapon> weapons = new ArrayList<RoomSquare.Weapon>(Arrays.asList(RoomSquare.Weapon.values()));
		ArrayList<RoomSquare.Room> rooms = new ArrayList<RoomSquare.Room>(Arrays.asList(RoomSquare.Room.values()));

		// remove the solution room and weapon
		weapons.remove(RoomSquare.Weapon.valueOf(envelope[2].getName()));
		rooms.remove(RoomSquare.Room.valueOf(envelope[1].getName()));

		// put a random weapon into each random room
		Collections.shuffle(Arrays.asList(weapons));
		Collections.shuffle(Arrays.asList(rooms));


		for (int i=0, j=0; i<weapons.size(); i++) {
			RoomSquare s = (RoomSquare)gameboard.getSquareFromPosition(weaponPositions.get(j));
			do {				// get the correct RoomSquare corresponding to the Room
				s = (RoomSquare)gameboard.getSquareFromPosition(weaponPositions.get(j));
				j++;
			}
			while(s.getRoom() != rooms.get(i));
			s.setWeapon();
			rooms.get(i).setWeapon(weapons.get(i));
		}
	}

	/**
	 * Sets the mode of play for each player.
	 * The current player should be the one playing (ie. making moves, suggestions, accusations)
	 * whereas everyone else should only be able to refute.
	 *
	 */
	public void setPlayerState() {
		/*currentPlayer.setPlay(true);
		for (Player p: players) {
			if (!p.equals(currentPlayer))
				p.setPlay(false);
		}*/

		// if a player's accusation is wrong, then that player can only move and refute
	}

	/**
	 * Plays the game. Game stops when a player's accusation matches the solution.
	 */
	public void playGame() {
		// Instruction for play
		System.out.println("\n You may move in the directions U(up), D(down), L(left), R(right).\n "
				+ "Each direction should be followed by the number of steps you want to take in that direction. \n"
				+ "Each directed move should be separated by a comma, with no spaces: (eg) U2,L3,D1 \n");

		Scanner reader = new Scanner(System.in);
		int playerIndex = 1;		// get next player from nextPlayer

		while (isPlaying) {
			int steps = dice.roll();
			Move m = null;
			boolean isValid;
			

			do {
						// gets player's move sequence
				try {
					System.out.println("\nPlayer " + currentPlayer.getName() + " rolling dice...\n Dice value: "+ steps);
					System.out.print("How do you want to move? : ");
					m = new Move(reader.nextLine(), steps);			// try-catch?
					isValid = true;
					movePlayer(m);
				}
				catch (IllegalArgumentException e) {
					isValid = false;
					e.printStackTrace();
					System.out.println("Oops! Try another move!");
				}
			}
			while (!isValid);
			
			// move play along to other players
			System.out.println("before switch :" + playerIndex);
			//currentPlayer = nextPlayer;
			//nextPlayer = players.get(playerIndex++);
			currentPlayer = players.get(playerIndex++);
			System.out.println("after switch :" + playerIndex);
			
			System.out.println("Player current: " + currentPlayer.getName());
			if (playerIndex == players.size())			
				playerIndex = 0;						// return play back to player 1
			
			System.out.println("\n" + gameboard.toString());
			System.out.println("=================================================");
		}
	}

	public void movePlayer(Move m) {
		if (m == null)
			throw new IllegalArgumentException("Move can't be null!");
		
		Move move = m;
		Position currentpos = currentPlayer.getSquare().getPosition();
		Square sq = gameboard.getSquareFromPosition(currentpos);
		
		while (!move.isFinish()) {
			String partMoveSequence = move.get();	// get first move sequence
			String dir = Character.toString(partMoveSequence.charAt(0));
			String steps = Character.toString(partMoveSequence.charAt(1));
			
			// checks to see if user's path is valid
			for (int j = 0; j < Integer.parseInt(steps); j++) {
				Position newPos = move.getDir(dir, currentpos);		// get position on that move
				sq = gameboard.getSquareFromPosition(currentpos);		// get square related to that position
				Square to = gameboard.getSquareFromPosition(newPos);
				Square.validateSquare(sq, to);							// check if new square is valid
				currentpos = newPos;				// move position incrementally
				
				// if new position gives a room square, ask user for info for suggestion
			}
			currentPlayer.move(gameboard.getSquareFromPosition(currentpos));
		}
		
		// when it reaches here, we know that all the squares in the sequence are valid
		// so can put the player on that square
		
	}

	public static void main(String[] args) {
		new Game();
	}
}

