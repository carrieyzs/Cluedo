import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Board to be used in the Cluedo game. It is represented, in the game, as Strings -- similar to how it was
 * stored in the gameboard.txt file. 
 * @author Carrie
 */
public class Board {
	private Square[][] board;
	
	// the name of the player designated for each StartingSquare, 
	// starting from the top (as read in from the file)
	private String SplayerName = "MRS_WHITE"; 
	Player.PlayerToken Scurrent = Player.PlayerToken.valueOf(SplayerName);
	List<StartingSquare> startingSquares;
	
	/**
	 * Generates a new board. A Board consists of 25 rows of Squares, each with 24 columns.
	 */
	public Board() {
		startingSquares = new ArrayList<StartingSquare>();
		board = new Square[25][24];			// 25 down, 24 across
		createNewBoard();
	}

	/**
	 * Reads the gameboard.txt file. Converts every character to a Square, and stores that Square into 
	 * board.
	 */
	public void createNewBoard() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("gameboard.txt"));
			String name;

			// Reads the list of squares into the board array
			int i = 0, j = 0, c;

			while ( ((c = br.read()) != -1) && i < board.length) {
				char cc = (char)c;
				if (cc == '\n') continue;
				
				name = String.valueOf(cc);
				Square sq = getSquare(name);

				board[i][j++] = sq;
				if (j == board[i].length) {
					j = 0;
					i++;
				}
			}

			br.close();

		} catch (IOException e) {
			System.out.println("File reading failed");
			e.printStackTrace();
		}

	}

	/**
	 * Method that returns a Square given the name. This is used in generating a new board. 
	 * @param name
	 * @return
	 */
	private Square getSquare(String name) {
		Square sq;

		if (name.equals("X") || name.equals(" ")) {
			sq = new PlainSquare(name);
		} else if (name.equals("S")) { 
			sq = new StartingSquare(name, SplayerName);
			startingSquares.add((StartingSquare)sq);
			// gets the next player's name as shown on the board
			Scurrent = Player.PlayerToken.getNext(Scurrent);
			SplayerName = Scurrent.name();
		} else if (name.equals("-")) {
			sq = new DoorSquare(name);
		} else {
			sq = new RoomSquare(name);
		}

		return sq;
	}
	
	/**
	 * @return - list of starting squares in order of play
	 */
	public List<StartingSquare> getStartingSquares(){
		List<StartingSquare> result = new ArrayList<StartingSquare>();
		
		// reorder the list
		int size = startingSquares.size();
		Player.PlayerToken[] playersInOrder = Player.PlayerToken.values();
		
		// go through enum ordering of names, and find the Square that matches the name of the PlayerToken
		for (int i=0; i<size; i++) {
			for (int j=0; i<size; i++) {
				// put that Square into result list, thereby ordering the list
				if (startingSquares.get(j).getPlayerLabel().equals(playersInOrder[i].name())) 
					result.add(startingSquares.get(j));
			}
		}
		
		return result;
	}

	/**
	 *@return - String representation of this board
	 */
	public String toString() {
		String res = "";

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				res += board[i][j].toString();
			}
			//res += "*";
		}

		return res;
	}
}
