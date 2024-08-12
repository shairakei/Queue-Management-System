package queuemanagement.QueueManagementSystem;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import queuemanagement.CustomizedPanels.ImgRoundedPanel;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.Timer;

import queuemanagement.CustomizedPanels.RoundedButton;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class LandingFramePanel extends JPanel {
	
	ImageIcon imageIcon = new ImageIcon("imgs/nu_bg (1).png"); 
	Image backgroundImage = imageIcon.getImage();
	

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
	 * Create the panel.
	 */
	public LandingFramePanel() {
		setBackground(new Color(49, 62, 138));
		
		setSize(1232,682);
		setLayout(null);
		
		ImgRoundedPanel mainPanel = new ImgRoundedPanel(backgroundImage);
		mainPanel.setLayout(null);
		mainPanel.setBackground(new Color(0, 0, 0, 0));
		mainPanel.setBounds(-1, 0, 1234, 682);
		add(mainPanel);
		
		JLabel lbl_tagline2 = new JLabel("Transforming Appointments, Enhancing Productivity");
		lbl_tagline2.setForeground(new Color(49, 62, 138));
		lbl_tagline2.setFont(new Font("Dialog", Font.PLAIN, 20));
		lbl_tagline2.setBounds(377, 241, 455, 56);
		mainPanel.add(lbl_tagline2);
		
		JLabel lbl_QueueMngmt = new JLabel("Queue Management System");
		lbl_QueueMngmt.setForeground(new Color(49, 62, 138));
		lbl_QueueMngmt.setFont(new Font("Dialog", Font.BOLD, 55));
		lbl_QueueMngmt.setBounds(235, 126, 735, 114);
		mainPanel.add(lbl_QueueMngmt);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(49, 62, 138));
		separator.setBounds(339, 241, 519, 18);
		mainPanel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(49, 62, 138));
		separator_1.setBounds(339, 296, 519, 18);
		mainPanel.add(separator_1);
		
		RoundedButton btn_reqAppointment = new RoundedButton("Request an Appointment Now");
		btn_reqAppointment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UserPage userPage = new UserPage();
				userPage.setLocationRelativeTo(null);
				userPage.setVisible(true);
				
				//get the parent JFrame of the LandingFramePanel
		        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LandingFramePanel.this);
		        frame.dispose(); //dispose the JFrame to close the window			
			}
		});
		
		btn_reqAppointment.setForeground(Color.WHITE);
		btn_reqAppointment.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_reqAppointment.setBackground(new Color(49, 62, 138));
		btn_reqAppointment.setBounds(485, 325, 241, 52);
		mainPanel.add(btn_reqAppointment);
		
		JButton btn_scrollDown = new JButton("");
		   btn_scrollDown.addActionListener(new ActionListener() {
		   	public void actionPerformed(ActionEvent e) {
		   		
		   		UserPage userPage = new UserPage();
				userPage.setLocationRelativeTo(null);
		   		userPage.setVisible(true);
		   		
		   		//get the parent JFrame of the LandingFramePanel
		        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LandingFramePanel.this);
		        frame.dispose(); //dispose the JFrame to close the window		
		   	}
		   });
	        btn_scrollDown.setOpaque(false);
	        btn_scrollDown.setContentAreaFilled(false);
	        btn_scrollDown.setBorderPainted(false);
	        btn_scrollDown.setIcon(new ImageIcon("imgs\\scroll (1).png"));
	        btn_scrollDown.setBackground(new Color(240, 240, 240));
	        btn_scrollDown.setBounds(580, 424, 59, 57);
	        mainPanel.add(btn_scrollDown);

	     // Timer for bouncing animation
	        Timer timer = new Timer(200, new ActionListener() {
	            private int startY = btn_scrollDown.getY();
	            private int direction = -1; // Start moving upwards

	            @Override
	            public void actionPerformed(ActionEvent e) {
	                int currentY = btn_scrollDown.getY();
	                int newY = currentY + (5 * direction); // Adjust the speed of bouncing

	                if (newY <= startY - 10) {
	                    direction = 1; // Change direction to move downwards
	                } else if (newY >= startY) {
	                    direction = -1; // Change direction to move upwards
	                }

	                btn_scrollDown.setLocation(btn_scrollDown.getX(), newY);
	            }
	        });
	        timer.setRepeats(true);
	        timer.start();
     
	        // Mouse hover effect for btn_reqAppointment
			btn_reqAppointment.addMouseListener(new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        btn_reqAppointment.setBackground(new Color(70, 86, 191)); // Change background color on hover
			    }

			    @Override
			    public void mouseExited(MouseEvent e) {
			        btn_reqAppointment.setBackground(new Color(49, 62, 138)); // Revert background color when not hovered
			    }
			});
			
	}
		
	
}
