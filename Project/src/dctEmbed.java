import java.awt.Color;

public class dctEmbed extends createFrame {
	public dctEmbed() {
		super();
		setTitle("DCT Encode");
		getContentPane().setBackground(Color.PINK);
		buttonActionPerformed(getBtnNewButton_2());
		buttonActionPerformed(getBtnHome());
		
	}
	
	public static void main(String[] args){
		dctEmbed frame = new dctEmbed();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
}