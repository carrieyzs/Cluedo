import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Board {
	// 25 down, 24 across
	public static final int WIDTH = 24;
	public static final int HEIGHT = 25;

	private Square[][] board;

	// the name of the player designated for each StartingSquare,
	// starting from the top (as read in from the file)
	private String SplayerName = "MRS_WHITE";
	Player.PlayerToken Scurrent = Player.PlayerToken.valueOf(SplayerName);

	public Board() {
		board = new Square[HEIGHT][WIDTH];			
		createNewBoard();
	}

	/**
	 * Method initialises the board field. 
	 * The gameboard.txt file is read, Squares are generated and added into it.
	 */
	private void createNewBoard() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("gameboard.txt"));
			String name;

			// Reads the list of squares into the board array
			int i = 0, j = 0, c;

			while ( ((c = br.read()) != -1) && i < board.length) {
				char cc = (char)c;
				if (cc == '\n')				// buffered reader adds new line every so often, so did this to get 
					continue;				// rid of it

				name = String.valueOf(cc);
				Position p = new Position(i, j);
				Square sq = getSquare(name, p);		// get the relevant Square
				board[i][j++] = sq;						// put in board
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
	 * Gets the square based on the name read from the file.
	 * This method only helps generates squares based on the format of the file being read in.
	 * @param name
	 * @param p
	 * @return
	 */
	private Square getSquare(String name, Position p) {
		Square sq;

		if (name.equals("X") || name.equals(" ") || name.equals("-")) {
			sq = new PlainSquare(name, p);
		}
		else if (name.equals("S")) {
			sq = new StartingSquare(name, p, SplayerName);

			// gets the next player's name as shown on the board
			if (SplayerName.equals("MRS_PEACOCK"))
				Scurrent = Player.PlayerToken.COLONEL_MUSTARD;
			else if (SplayerName.equals("COLONEL_MUSTARD"))
				Scurrent = Player.PlayerToken.PROFESSOR_PLUM;
			else
				Scurrent = Player.PlayerToken.getNext(Scurrent);

			SplayerName = Scurrent.name();
		}
		else {										
			sq = new RoomSquare(name, p);					
		}

		return sq;
	}

	/**
	 *@return String representation of this board
	 */
	public String toString() {
		String res = "";

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				res += board[i][j].toString();
				if (j == board[i].length-1)
					res += "\n";

			}

		}

		return res;
	}


	/**
	 * @param p
	 * @return  the Square in the board that i associated with the given position
	 */
	public Square getSquareFromPosition(Position p) {
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[i].length; j++) {
				if (p.getRow() == i && p.getCol() == j)
					return board[i][j];
			}
		}

		return null;
	}
}
