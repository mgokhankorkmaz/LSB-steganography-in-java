import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class homeFrame extends createFrame {

	private BufferedImage image;
	private JLabel homeImageLabel;
	public homeFrame() {
		super();
		setTitle("Home");
		getContentPane().setBackground(new Color(0, 128, 128));
	 
		try {image = ImageIO.read(this.getClass().getResource("homeImage.jpeg"));} catch (IOException e) {e.printStackTrace();}
		
		homeImageLabel = new JLabel(new ImageIcon(image));
		homeImageLabel.setLocation(200, 0);
		homeImageLabel.setSize(990, 750);
		getContentPane().add(homeImageLabel);
	}
	
	public static void main(String[] args) {
		homeFrame frame = new homeFrame();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
}