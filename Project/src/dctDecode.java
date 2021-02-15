import java.awt.Color;

public class dctDecode extends createFrame {

	public dctDecode() {
		super();
		setTitle("DCT Decode");
		getContentPane().setBackground(Color.PINK);
		buttonActionPerformed(getBtnNewButton_3());
		buttonActionPerformed(getBtnHome());
	}
	
	public static void main(String[] args) {
		dctDecode frame = new dctDecode();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}