import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardGui {

	private Board board;
	private SquareGui[][] newBoard;
	JPanel panel = new JPanel();
	
	public BoardGui() {
		this.board = new Board();
		newBoard = new SquareGui[this.board.getBoard().length][this.board.getBoard()[0].length];
		
	}
    
	public void generateBoardGui() {
		Square[][] myBoard = board.getBoard();
		for(int row=0;row<myBoard.length;row++) {
			for(int col=0;col<myBoard[row].length;col++) {
				switch(myBoard[row][col].letter) {
					case "K":
						newBoard[row][col] = new SquareGui("Kitchen");
						break;
					case "S":
						newBoard[row][col] = new SquareGui("Start");
						break;
					case "C":
						newBoard[row][col] = new SquareGui("Conservatory");
						break;
					case "D":
						newBoard[row][col] = new SquareGui("DiningRoom");
						break;
					case "R":
						newBoard[row][col] = new SquareGui("BilliardRoom");
						break;
					case "X":
						newBoard[row][col] = new SquareGui("Wall");
						break;
					case "L":
						newBoard[row][col] = new SquareGui("Library");
						break;
					case "T":
						newBoard[row][col] = new SquareGui("Study");
						break;
					case "H":
						newBoard[row][col] = new SquareGui("Hall");
						break;
					case "O":
						newBoard[row][col] = new SquareGui("Lounge");
						break;
					default:
						break;
				}
			}
		}
	}
	  private static final int LEFT_MARGIN = 40;
	    private static final int TOP_MARGIN = 40;
	    private static final int CELL_SIZE = 25;

	    /**
	     * Draw the grid of cells on the screen, and the Worker 
	     */
	    public void drawBoard() {
	        
	        // draw cells
	    	for(int row=0;row<this.newBoard.length;row++) {
	    		for(int col=0;col<this.newBoard[row].length;col++) {
	                drawCell(row, col);
	    		}}
	       
	    }

		private void drawCell(int row, int col) {
			// TODO Auto-generated method stub
			double left = LEFT_MARGIN+(CELL_SIZE* col);
	        double top = TOP_MARGIN+(CELL_SIZE* row);
	        JLabel panelj = newBoard[row][col].imageLogo;
	        panel.add(panelj);
			
		}
	    	
}
