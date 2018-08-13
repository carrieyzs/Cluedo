import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Board {
	private Square[][] board;
	
	// the name of the player designated for each StartingSquare,
	// starting from the top (as read in from the file)
	private String SplayerName = "MRS_WHITE";
	Player.PlayerToken Scurrent = Player.PlayerToken.valueOf(SplayerName);
	List<StartingSquare> startingSquares;
	
	public Board() {
		board = new Square[25][24];			// 25 down, 24 across
		createNewBoard();
	}

	private void createNewBoard() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("gameboard.txt"));
			String name;

			// Reads the list of squares into the board array
			int i = 0, j = 0, c;

			while ( ((c = br.read()) != -1) && i < board.length) {
				char cc = (char)c;
				if (cc == '\n') continue;
				
				name = String.valueOf(cc);
				Position p = new Position(i, j);
				Square sq = getSquare(name, p);
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
	
	private Square getSquare(String name, Position p) {
		Square sq;

		if (name.equals("X") || name.equals(" ") || name.equals("-")) {
			sq = new PlainSquare(name, p);
		}
		else if (name.equals("S")) {
			sq = new StartingSquare(name, p, SplayerName);
			startingSquares.add((StartingSquare)sq);

			// gets the next player's name as shown on the board
			if (SplayerName.equals("MRS_PEACOCK"))
				Scurrent = Player.PlayerToken.COLONEL_MUSTARD;
			else if (SplayerName.equals("COLONEL_MUSTARD"))
				Scurrent = Player.PlayerToken.PROFESSOR_PLUM;
			else
				Scurrent = Player.PlayerToken.getNext(Scurrent);

			SplayerName = Scurrent.name();
		}
		else {											//else if (name.equals("-")) {
			sq = new RoomSquare(name, p);						//sq = new DoorSquare(name); }
		}

		return sq;
	}

	/**
	 *@return - String representation of this board
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
}
