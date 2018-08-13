import java.util.Random;

/**
 * The Die class represents one die.
 * In the Cluedo game, 2 dice is used to move the player around the board.
 */
public class Die {
	Integer[][] dice;
	private static final int DICE_VALUES = 6;

	/**
	 * Creates a Die object.
	 * @param numOfDice no. of dice required
	 */
	public Die(int numOfDice) {
		dice = new Integer[numOfDice][DICE_VALUES];

		for (int i=0; i<dice.length; i++) {		// initialise the values for each dice
			for (int j=0; j<DICE_VALUES; j++) {
				dice[i][j] = j+1;
			}
		}
	}

	/**
	 * This method generates random values from the dice to simulate a dice roll.
	 * @return the no. of steps player has to take during a move
	 */
	public int roll() {
		int sum = 0;

		for (int i=0; i<dice.length; i++)
			sum += dice[i][new Random().nextInt(6)];			// gets random dice value

		return sum;
	}
}
