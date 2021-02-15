import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Image;
import java.awt.Cursor;
import javax.swing.SwingConstants;

public class createFrame extends JFrame  {

	private JPanel contentPane;
	private BufferedImage img = null;
	private JButton btnHome, btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3;

	public BufferedImage getImg() {
		return img;
	}

	public void setImg(BufferedImage img) {
		this.img = img;
	}

	public JButton getBtnHome() {
		return btnHome;
	}

	public void setBtnHome(JButton btnHome) {
		this.btnHome = btnHome;
	}

	public JButton getBtnNewButton() {
		return btnNewButton;
	}

	public void setBtnNewButton(JButton btnNewButton) {
		this.btnNewButton = btnNewButton;
	}

	public JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public void setBtnNewButton_1(JButton btnNewButton_1) {
		this.btnNewButton_1 = btnNewButton_1;
	}

	public JButton getBtnNewButton_2() {
		return btnNewButton_2;
	}

	public void setBtnNewButton_2(JButton btnNewButton_2) {
		this.btnNewButton_2 = btnNewButton_2;
	}

	public JButton getBtnNewButton_3() {
		return btnNewButton_3;
	}

	public void setBtnNewButton_3(JButton btnNewButton_3) {
		this.btnNewButton_3 = btnNewButton_3;
	}

	public createFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 120, 1200, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(0, 0, 200, 750);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnHome = new JButton("Home");
		btnHome.setHorizontalAlignment(SwingConstants.LEFT);
		Image homeIcon =new ImageIcon(createFrame.class.getResource("Home-icon.png")).getImage();
	    btnHome.setIcon(new ImageIcon(homeIcon));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnHome.setBackground(Color.LIGHT_GRAY);
		btnHome.setBounds(20, 80, 150, 70);
		panel.add(btnHome);
		buttonActionPerformed(btnHome);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				homeFrame hf = new homeFrame();
				hf.setVisible(true);
				hf.setLocationRelativeTo(null);	
			}});

		
		btnNewButton = new JButton("LSB Encode");
		Image mainLsbEncodeIcon =new ImageIcon(createFrame.class.getResource("main lsb encode.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(mainLsbEncodeIcon));
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(20, 205, 150, 70);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				lsbEmbed embedLsb = new lsbEmbed();
				embedLsb.setVisible(true);
				embedLsb.setLocationRelativeTo(null);
			}});


		btnNewButton_1 = new JButton("LSB Decode");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEFT);
		Image mainLsbDecodeIcon =new ImageIcon(createFrame.class.getResource("main lsb decode.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(mainLsbDecodeIcon));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1.setBounds(20, 330, 150, 70);
		panel.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				lsbDecode decodeLsb = new lsbDecode();
				decodeLsb.setVisible(true);
				decodeLsb.setLocationRelativeTo(null);					
			}
		});

		
		btnNewButton_2 = new JButton("DCT Encode");
		Image mainDctEncodeIcon =new ImageIcon(createFrame.class.getResource("main dct encode.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(mainDctEncodeIcon));
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_2.setBackground(Color.LIGHT_GRAY);
		btnNewButton_2.setBounds(20, 455, 150, 70);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				dctEmbed embedDct = new dctEmbed();
				embedDct.setVisible(true);
				embedDct.setLocationRelativeTo(null);
			}});

		btnNewButton_3 = new JButton("DCT Decode");
		Image mainDctDecodeIcon =new ImageIcon(createFrame.class.getResource("main dct decode.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(mainDctDecodeIcon));
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_3.setBackground(Color.LIGHT_GRAY);
		btnNewButton_3.setBounds(20, 580, 150, 70);
		panel.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				dctDecode decodeDct = new dctDecode();
				decodeDct.setVisible(true);
				decodeDct.setLocationRelativeTo(null);
			}
		});

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Operations");
		menuBar.add(mnNewMenu);
		
		JMenu mnNewMenu_2 = new JMenu("LSB");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Encode");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				lsbEmbed le = new lsbEmbed();
				le.setVisible(true);
				le.setLocationRelativeTo(null);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Decode");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				lsbDecode ld = new lsbDecode();
				ld.setVisible(true);
				ld.setLocationRelativeTo(null);
			}});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_3 = new JMenu("DCT");
		mnNewMenu.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Encode");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				dctEmbed de = new dctEmbed();
				de.setVisible(true);
				de.setLocationRelativeTo(null);
			}});
		mnNewMenu_3.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Decode");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isShowing())
					removeNotify();
				dctDecode dd = new dctDecode();
				dd.setVisible(true);
				dd.setLocationRelativeTo(null);
			}});
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Exit");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		mnNewMenu.add(mntmNewMenuItem_6);

	}
	 public void buttonActionPerformed(JButton btn){  
		 if(btn.isEnabled())
		 	btn.setEnabled(false);
		 else
			 btn.setEnabled(true);
	 } 
	 
	 public java.io.File openFile(boolean open) {
		    JFileChooser fc = new JFileChooser("Open an image");
		    
		    javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter() {
		       public boolean accept(java.io.File f) {
		          String name = f.getName().toLowerCase();
		          if(open)
		             return f.isDirectory() || name.endsWith(".jpg") || name.endsWith(".jpeg") ||
		                name.endsWith(".png") || name.endsWith(".gif") || name.endsWith(".tiff") ||
		                name.endsWith(".bmp") || name.endsWith(".dib");
		          return f.isDirectory() || name.endsWith(".png") ||    name.endsWith(".bmp");
		          }
		       public String getDescription() {
		          if(open)
		             return "Image (*.jpg, *.jpeg, *.png, *.gif, *.tiff, *.bmp, *.dib)";
		          return "Image (*.png, *.bmp)";
		          }
		       };
		    fc.setAcceptAllFileFilterUsed(false);
		    fc.addChoosableFileFilter(ff);
		 
		    java.io.File f = null;
		   if(open && fc.showOpenDialog(this) == fc.APPROVE_OPTION)
		       f = fc.getSelectedFile();
		    else if(!open && fc.showSaveDialog(this) == fc.APPROVE_OPTION)
		       f = fc.getSelectedFile();

		    return f;
		    }
	 
	 public int getBitValue(int n, int digit_place) {
		 /* 100  01100100
		  *  65	 01000000
		  * &or  01000000
							*/
		 	if((n&(int)Math.pow(2, digit_place))==(int)Math.pow(2, digit_place))
		 		return 1;
		 	else 
		 		return 0;
		    }
	 
	 public int setBitValue(int n, int strBit, int bit) {
		 int z = (int) Math.pow(2, strBit), bin = getBitValue(n, strBit);
		 if(bin == bit)
		    return n;
		 if(bin == 0 && bit == 1)
		    n |= z; // lsb value set 1
		 else if(bin == 1 && bit == 0)
		    n ^= z; //change lsb value
		 return n;	
		 }

	 
	public static void main(String[] args) {
		createFrame frame = new createFrame();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}