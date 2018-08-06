import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Board {
	private Square[][] board; // 25 down, 24 across
	private String playerNameAtStart = "MRS_WHITE"; // the name of the player designated for each StartingSquare,
													// starting from the top

	public Board() {
		// reads the gameboard.txt file
		// convert to square
		// put in board

		board = new Square[25][24];
		createNewBoard();
	}

	public Square[][] createNewBoard() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("gameboard.txt"));
			String name;
			char c;

			// Reads the list of squares into the board array
			int i = 0, j = 0;

			while (((c = (char) br.read()) != -1) && (i < board.length) && (j < board[i].length)) {


				name = String.valueOf(c);
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

		return board;
	}

	private Square getSquare(String name) {
		Square sq;

		if (name.equals("X") || name.equals(" ")) {
			sq = new PlainSquare(name);
		} else if (name.equals("S")) { // put player name in here and convert to string, store in playerNameAtStart
			sq = new StartingSquare(name, playerNameAtStart);
			Player.PlayerToken p = Player.PlayerToken.valueOf(playerNameAtStart);
			playerNameAtStart = p.getNext().name(); // get next player
		} else if (name.equals("-")) {
			sq = new DoorSquare(name);
		} else {
			sq = new RoomSquare(name);
		}

		return sq;
	}

	public String toString() {
		String res = "";

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				res += board[i][j].toString();
			}
		}

		return res;
	}
}
