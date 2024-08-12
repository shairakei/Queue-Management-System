package Main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextArea;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import queuemanagement.QueueManagementSystem.About;
import queuemanagement.QueueManagementSystem.Contacts;
import queuemanagement.QueueManagementSystem.FAQ;
import queuemanagement.QueueManagementSystem.LandingFramePanel;
import queuemanagement.QueueManagementSystem.LoginFrame;
import queuemanagement.CustomizedPanels.ImgRoundedPanel;
import queuemanagement.CustomizedPanels.RoundPanels;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LandingPage extends JFrame {

	private JPanel contentPane;
	ImageIcon imageIcon = new ImageIcon("imgs/nu_bg (1).png"); 
	Image backgroundImage = imageIcon.getImage();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	private About aboutPanel;
	private Contacts contactsPanel;
	private FAQ FAQPanel;
	private LoginFrame login;
	private LandingFramePanel landingFrame;
	

	private ImageIcon loadImageIcon(String imagePath) {
		try {
			Image image = ImageIO.read(getClass().getResource(imagePath));
			return new ImageIcon(image);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {

		SwingUtilities.invokeLater(() -> {
			LandingPage frame = new LandingPage();
			frame.setVisible(true);
		});
	}

	/**
	 * Create the frame.
	 */

	public LandingPage() {
		
		aboutPanel = new About();
		contactsPanel = new Contacts();
		FAQPanel = new FAQ();
		login = new LoginFrame();
		landingFrame = new LandingFramePanel();
		
		setBounds(new Rectangle(0, 0, 1232, 701));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create the content pane
		contentPane = new JPanel();
		setContentPane(contentPane);
	    setUndecorated(true); // Remove default frame decorations
		setLocationRelativeTo(null);
		contentPane.setLayout(null);

		JPanel bgPanel = new JPanel();
		bgPanel.setBackground(new Color(49, 62, 138));
		bgPanel.setBounds(0, 0, 1232, 700);
		contentPane.add(bgPanel);
		bgPanel.setLayout(null);
        
		RoundPanels contentPanel = new RoundPanels(90);
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBounds(0, 68, 1232, 682);
		bgPanel.add(contentPanel);
		contentPanel.setLayout(null);
		
		contentPanel.add(landingFrame);
		contentPanel.add(aboutPanel);
		contentPanel.add(contactsPanel);
		contentPanel.add(FAQPanel);
		contentPanel.add(login);
		
		menuClicked(landingFrame);

			
		JLabel lbl_logoImg = new JLabel("");
		lbl_logoImg.setIcon(new ImageIcon("imgs\\National_University_seal (3).png"));
		lbl_logoImg.setBounds(88, 0, 43, 67);
		bgPanel.add(lbl_logoImg);

		JLabel lbl_about = new JLabel("About");
		lbl_about.setForeground(new Color(255, 255, 255));
		lbl_about.setFont(new Font("Dialog", Font.BOLD, 15));
		lbl_about.setBounds(795, 0, 64, 67);
		bgPanel.add(lbl_about);

		JLabel lbl_FAQ = new JLabel("FAQ");
		lbl_FAQ.setBounds(962, 0, 37, 67);
		bgPanel.add(lbl_FAQ);
		lbl_FAQ.setForeground(new Color(255, 255, 255));
		lbl_FAQ.setFont(new Font("Dialog", Font.BOLD, 15));

		JLabel lbl_contacts = new JLabel("Contacts");
		lbl_contacts.setBounds(869, 0, 71, 67);
		bgPanel.add(lbl_contacts);
		lbl_contacts.setForeground(new Color(255, 255, 255));
		lbl_contacts.setFont(new Font("Dialog", Font.BOLD, 15));

			JLabel lbl_logoName = new JLabel("National University");			
			lbl_logoName.setForeground(new Color(255, 255, 255));
			lbl_logoName.setFont(new Font("Dialog", Font.BOLD, 20));
			lbl_logoName.setBounds(141, 0, 184, 67);
			bgPanel.add(lbl_logoName);

			lbl_logoName.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {	
					menuClicked(landingFrame);
				}
				@Override
				public void mouseEntered(MouseEvent e) {
					lbl_logoName.setForeground(new Color(241, 212, 61)); // Set the foreground color when mouse enters
				}

				@Override
				public void mouseExited(MouseEvent e) {
					 lbl_logoName.setForeground(new Color(255, 255, 255)); // Set the foreground color when mouse exits
				}								
			});
	
		RoundedButton btn_signIn = new RoundedButton("Sign in");
		btn_signIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LoginFrame login = new LoginFrame();
				login.setVisible(true);				
				
			}
		});
		btn_signIn.setForeground(new Color(49, 62, 138));
		btn_signIn.setBackground(new Color(255, 255, 255));
		btn_signIn.setFont(new Font("Dialog", Font.BOLD, 13));
		btn_signIn.setBounds(1051, 16, 86, 41);
		bgPanel.add(btn_signIn);	
		

		
		lbl_about.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        lbl_about.setForeground(new Color(241, 212, 61)); // Set the foreground color when mouse enters
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        lbl_about.setForeground(new Color(255, 255, 255)); // Set the foreground color when mouse exits
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(aboutPanel);
				
			}
		});

		lbl_contacts.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        lbl_contacts.setForeground(new Color(241, 212, 61)); // Set the foreground color when mouse enters
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        lbl_contacts.setForeground(new Color(255, 255, 255)); // Set the foreground color when mouse exits
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(contactsPanel);
				
			}
		});

		lbl_FAQ.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        lbl_FAQ.setForeground(new Color(241, 212, 61)); // Set the foreground color when mouse enters
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        lbl_FAQ.setForeground(new Color(255, 255, 255)); // Set the foreground color when mouse exits
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(FAQPanel);
			}
		});


		// Mouse hover effect for btn_signIn
		btn_signIn.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		        btn_signIn.setBackground(new Color(240, 240, 240)); // Change background color on hover
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		        btn_signIn.setBackground(new Color(255, 255, 255)); // Revert background color when not hovered
		    }
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(login);
			}
		});	
		
	}
	
	 public void menuClicked(JPanel panel) {
	    	
	    	aboutPanel.setVisible(false);
	    	contactsPanel.setVisible(false);
	    	FAQPanel.setVisible(false);
	    	login.setVisible(false);
	    	landingFrame.setVisible(false);
	    	
	    	panel.setVisible(true);
	    }
}
