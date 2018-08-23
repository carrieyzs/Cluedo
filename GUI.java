import javax.swing.JFrame;
import javax.swing.JPanel;
public class GUI extends JFrame{
	JPanel panel = new JPanel();
	private Square[][] board = new Square[25][24];
	private static int ROWS = 24;
	private static int COLUMNS = 25;
    private static int SQUARE_HEIGHT = 400/ROWS;
	private static int SQUARE_WIDTH = 400/COLUMNS;
	private static final int LEFT_MARGIN = 40;
    private static final int TOP_MARGIN = 40;
    private static final int CELL_SIZE = 25;
	//player's position??
	public static void main(String[] args) {
		new GUI();
		
	}
	public GUI() {
		//creates the main window to display everything
		super("CLUEDO GAME");
		BoardGui test = new BoardGui();
		this.getContentPane().add(test.panel);
		setSize(1000,1000);
		setResizable(true);
		setVisible(true);
		setupGUI();
		//doLoad();
	}
        private void setupGUI() {
		// TODO Auto-generated method stub
		
	}
		
        	
        }
