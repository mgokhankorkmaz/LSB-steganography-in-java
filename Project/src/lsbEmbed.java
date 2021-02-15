import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Image;

public class lsbEmbed extends createFrame {


	private BufferedImage img2 = null;
	private JTextField maxLength;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	
	public lsbEmbed() {
		super();
		setTitle("LSB Encode");
		getContentPane().setBackground(new Color(0, 102, 153));
		buttonActionPerformed(getBtnNewButton());
		buttonActionPerformed(getBtnHome());
	
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(233, 20, 682, 325);
		getContentPane().add(scrollPane_2);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBackground(new Color(250, 250, 210));
		scrollPane_2.setViewportView(textArea);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(235, 395, 440, 328);
		getContentPane().add(scrollPane);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(710, 395, 440, 328);
		getContentPane().add(scrollPane_1);
		
		maxLength = new JTextField();
		maxLength.setHorizontalAlignment(SwingConstants.CENTER);
		maxLength.setText("Choose an image");
		maxLength.setEditable(false);
		maxLength.setBounds(815, 345, 100, 25);
		getContentPane().add(maxLength);
		maxLength.setColumns(10);
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		Image openIcon =new ImageIcon(createFrame.class.getResource("open.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(openIcon));
		btnNewButton.setBounds(1000, 52, 110, 40);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				java.io.File f = openFile(true);
			    try {   
			    	setImg(ImageIO.read(f));
			        JLabel l = new JLabel(new ImageIcon(getImg()));
			        scrollPane.setViewportView(l);
			        
			        int imgSize = getImg().getWidth() * getImg().getHeight() / 8 - 4;
			        String maxLen= Integer.toString(imgSize);
			        maxLength.setText(maxLen);
			    } 
			    catch(Exception ex) { ex.printStackTrace(); }
		}});
		
		JButton btnNewButton_1 = new JButton("Embed");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		Image embedIcon =new ImageIcon(createFrame.class.getResource("encode.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(embedIcon));
		btnNewButton_1.setBounds(1000, 124, 110, 40);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getImg() == null) {
					  JOptionPane.showMessageDialog(null, "Please choose an image to continue ", 
							  				   "No images selected", JOptionPane.ERROR_MESSAGE);
					  return;
			}
				if(textArea.getText().length() * 8 + 32 > getImg().getWidth()*getImg().getHeight()) {
					JOptionPane.showMessageDialog(null, "Message is too long for the chosen image",
				               "Message too long!", JOptionPane.ERROR_MESSAGE);
						       return;
				}
				
			    img2 = getImg().getSubimage(0,0,getImg().getWidth(),getImg().getHeight());
			    
			    embedLength(img2, textArea.getText().length(), 0, 0);
			    byte b[] = textArea.getText().getBytes();
			    for(int i=0; i<b.length; i++)
			        embedByte(img2, b[i], i*8+32, 0);
			    JLabel l = new JLabel(new ImageIcon(img2));
			    scrollPane_1.setViewportView(l);
			}});

		
		JButton btnNewButton_2 = new JButton("Save");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		Image saveIcon =new ImageIcon(createFrame.class.getResource("save.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(saveIcon));
		btnNewButton_2.setBounds(1000, 196, 110, 40);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (img2 == null) {
					  JOptionPane.showMessageDialog(null, "No message has been embedded!", 
							  				"Nothing to save", JOptionPane.ERROR_MESSAGE);
					  return;
			}
				
				    java.io.File f = openFile(false);
				    String name = f.getName();
				    String ext = name.substring(name.lastIndexOf(".")+1).toLowerCase();
				    if(!ext.equals("png") && !ext.equals("bmp") &&   !ext.equals("dib")) {
				          ext = "png";
				          f = new java.io.File(f.getAbsolutePath()+".png");
				          }
				    try {
				       if(f.exists()) f.delete();
				       ImageIO.write(img2, ext.toUpperCase(), f);
				       } catch(Exception ex) { ex.printStackTrace(); }
					scrollPane.setViewportView(null);
					scrollPane_1.setViewportView(null);
					resetInterface();
			}});

		
		JButton btnNewButton_3 = new JButton("Reset");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		Image resetIcon =new ImageIcon(createFrame.class.getResource("reset.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(resetIcon));
		btnNewButton_3.setBounds(1000, 268, 110, 40);
		getContentPane().add(btnNewButton_3);	
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetInterface();
			}});
	}
		 
	 private void embedLength(BufferedImage img, int text_length, int start, int strBit) {
		    int maxX = img.getWidth(), maxY = img.getHeight(),
		    		startX = start/maxY, startY = start - startX*maxY, digit_place=0;
		    for(int i=startX; i<maxX && digit_place<32; i++) {
		       for(int j=startY; j<maxY && digit_place<32; j++) {
		          int rgb = img.getRGB(i, j), bit = getBitValue(text_length, digit_place);
		          rgb = setBitValue(rgb, strBit, bit);
		          img.setRGB(i, j, rgb);
		          digit_place++;
		          }
		       }
		    }
		 
		 private void embedByte(BufferedImage img, byte b, int start, int strBit) {
		    int maxX = img.getWidth(), maxY = img.getHeight(), 
		    		startX = start/maxY, startY = start - startX*maxY, digit_place=0;
		    for(int i=startX; i<maxX && digit_place<8; i++) {
		       for(int j=startY; j<maxY && digit_place<8; j++) {
		          int rgb = img.getRGB(i, j), bit = getBitValue(b, digit_place);
		          rgb = setBitValue(rgb, strBit, bit);
		          img.setRGB(i, j, rgb);
		          digit_place++;
		          }
		       }
		    }
		 
		 private void resetInterface() {
			scrollPane.setViewportView(null);
			scrollPane_1.setViewportView(null);
			textArea.setText(null);
			maxLength.setText("Choose an image");
			img2=null;
			setImg(null);
		 }
	
	public static void main(String[] args) {
		lsbEmbed frame = new lsbEmbed();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
	}
}