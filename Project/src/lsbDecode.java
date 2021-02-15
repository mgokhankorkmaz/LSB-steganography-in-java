import javax.swing.JScrollPane;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class lsbDecode extends createFrame {
	
	private JScrollPane scrollPane;
	private JTextArea textArea;
	
	public lsbDecode() {	
		super();
		setTitle("LSB Decode");
		getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 10));
		getContentPane().setBackground(new Color(0, 102, 153));
		
		buttonActionPerformed(getBtnNewButton_1());
		buttonActionPerformed(getBtnHome());
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 100, 515, 540);
		getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(795, 100, 365, 540);
		getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane_1.setViewportView(textArea);
		textArea.setBackground(new Color(250, 250, 210));
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetInterface();
				
			}
		});
		
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		Image resetIcon =new ImageIcon(createFrame.class.getResource("reset.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(resetIcon));
		btnNewButton.setBounds(1050, 35, 110, 40);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Open");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		Image openIcon =new ImageIcon(createFrame.class.getResource("open.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(openIcon));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.io.File f = openFile(true);
			    try {   
			    	setImg(ImageIO.read(f));
			        JLabel l = new JLabel(new ImageIcon(getImg()));
			        scrollPane.setViewportView(l);} 
			    catch(Exception ex) { ex.printStackTrace(); }
			}
		});
		btnNewButton_1.setBounds(235, 640, 110, 40);
		getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Decode");
		Image decodeIcon =new ImageIcon(createFrame.class.getResource("decode.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(decodeIcon));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				if(getImg()==null)
					return;
				int len = decodeLength(getImg(), 0, 0);
			    byte b[] = new byte[len];
			    for(int i=0; i<len; i++)
			       b[i] = decodeByte(getImg(), i*8+32, 0);
			    textArea.setText(new String(b));	
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setBounds(1050, 640, 110, 40);
		getContentPane().add(btnNewButton_2);

	}
	 
		private int decodeLength(BufferedImage img, int start, int strBit) {
		   int maxX = img.getWidth(), maxY = img.getHeight(), 
			   startX = start/maxY, startY = start - startX*maxY , digit_place=0;
		   int length = 0;
		   for(int i=startX; i<maxX && digit_place<32; i++) {
			   for(int j=startY; j<maxY && digit_place<32; j++) {
		          int rgb = img.getRGB(i, j), bit = getBitValue(rgb, strBit);
		          length = setBitValue(length, digit_place, bit);
		          digit_place++;
		          }
		       }
		    return length;
		    }
		 
		private byte decodeByte(BufferedImage img, int start, int strBit) {
		    int maxX = img.getWidth(), maxY = img.getHeight(), 
		       startX = start/maxY, startY = start - startX*maxY, digit_place=0;
		    byte b = 0;
		    for(int i=startX; i<maxX && digit_place<8; i++) {
		       for(int j=startY; j<maxY && digit_place<8; j++) {
		          int rgb = img.getRGB(i, j), bit = getBitValue(rgb, strBit);
		          b = (byte)setBitValue(b, digit_place, bit);
		          digit_place++;
		          }
		       }
		    return b;
		    }

		 private void resetInterface() {
			scrollPane.setViewportView(null);
			textArea.setText(null);
			setImg(null);
		 }
		 
	public static void main(String[] args) {
		lsbDecode frame = new lsbDecode();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}