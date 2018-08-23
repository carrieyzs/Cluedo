import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class SquareGui {
	public ImageIcon imageIcon;
	JLabel imageLogo = new JLabel();
	
	 
	
	public SquareGui(String type) {
		String path="";
		switch(type) {
		case "Kitchen":
		case "Conservatory":
		case "DiningRoom":
		case "BilliardRoom":
		case "Library":
		case "Study":
		case "Hall":
		case "Lounge":
			path = "greySquare.jpg";
			break;

		case "Wall":
			path = "emptyPath.jpg";
			break;

		case "Empty":
			path = "yelloSquare.jpg";
			break;
		default:
			break;
			
		}
		
		
	    BufferedImage img = null;
	    try {
	        img = ImageIO.read(new File(path));
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Image dimg = img.getScaledInstance(25,25,
	            Image.SCALE_SMOOTH);
	    this.imageIcon = new ImageIcon(dimg);
	    imageLogo.setIcon(this.imageIcon);
	    
	}

	public void draw(double left, double top, int cellSize) {
		// TODO Auto-generated method stub
		
	}
	
}
