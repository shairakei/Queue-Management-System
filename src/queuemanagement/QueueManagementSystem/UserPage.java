package queuemanagement.QueueManagementSystem;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Main.LandingPage;
import queuemanagement.CustomizedPanels.TransparentPanel;

import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class UserPage extends JFrame {

    //declare the components
	private JPanel contentPane;
	private JLabel logo_NU;
	private JLabel lbl_NationalU;	
	private StatusCheckerPanel statusChecker;
	private RequestAppointmentPanel reqAppointment;
    private RequestAppointmentPanel requestAppointmentPanel;
    private DashboardPanel dashboardPanel;

	/**
	 * Create the frame.
	 */
	
	public UserPage() {
		
        //create the appointmentRequestPanel
	    AppointmentRequestPanel appointmentRequestPanel = new AppointmentRequestPanel(requestAppointmentPanel, dashboardPanel);
		
        //initialize the components
		statusChecker = new StatusCheckerPanel();
		reqAppointment = new RequestAppointmentPanel(appointmentRequestPanel, dashboardPanel);
		
        //set frame properties
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1232, 701);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        //create the content panel
		JPanel contentPanel = new JPanel();
		contentPanel.setBounds(0, 61, 1232, 640);
		contentPane.add(contentPanel);
		contentPanel.setLayout(null);
		
        //add the panels to the content panel
		contentPanel.add(reqAppointment);
		contentPanel.add(statusChecker);
		
        //set the default menu selection
		menuClicked(reqAppointment);
		
        //create the gradient panel
		JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;

                // Define the gradient colors
                Color startColor = new Color(49, 62, 138); 
                Color endColor = new Color(36, 59, 85); 

                // Create the gradient paint object
                GradientPaint gradient = new GradientPaint(
                        0, 0, startColor,
                        0, getHeight(), endColor);

                // Set the paint to the graphics object
                g2d.setPaint(gradient);

                // Fill the entire panel with the gradient
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
		panel.setBounds(0, 0, 1232, 61);
		contentPane.add(panel);
		panel.setLayout(null);
		
        //add the National University logo
		logo_NU = new JLabel("");
		logo_NU.setIcon(new ImageIcon("imgs/National_University_seal (3).png"));
		logo_NU.setBounds(56, 0, 49, 61);
		panel.add(logo_NU);
		
        //add the National University label
		lbl_NationalU = new JLabel("National University");
		lbl_NationalU.setForeground(new Color(255, 255, 255));
		lbl_NationalU.setFont(new Font("Dialog", Font.BOLD, 20));
		lbl_NationalU.setBounds(104, 11, 186, 39);
		panel.add(lbl_NationalU);
		
        //create the status tracker panel
		TransparentPanel panel_statusTracker = new TransparentPanel();
		panel_statusTracker.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(statusChecker);
				
			}
		});
		panel_statusTracker.setLayout(null);
		panel_statusTracker.setBounds(951, 0, 200, 61);
		panel.add(panel_statusTracker);
		
        //add the status tracker label
		JLabel lblStatusTracker = new JLabel("Status Tracker");
		lblStatusTracker.setForeground(Color.WHITE);
		lblStatusTracker.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStatusTracker.setBounds(63, 11, 110, 39);
		panel_statusTracker.add(lblStatusTracker);
		
        //add the status icon to the status tracker panel
		JLabel imgStatusTracker = new JLabel("");
		imgStatusTracker.setIcon(new ImageIcon("imgs/status_icon.png"));
		imgStatusTracker.setBounds(22, 11, 39, 39);
		panel_statusTracker.add(imgStatusTracker);
		
        //create the request appointment panel
		TransparentPanel panel_reqAppointment = new TransparentPanel();
		panel_reqAppointment.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				menuClicked(reqAppointment);
			}
		});
		panel_reqAppointment.setLayout(null);
		panel_reqAppointment.setBounds(707, 0, 244, 61);
		panel.add(panel_reqAppointment);
		
        //add the request an appointment label
		JLabel lblRequestAnAppointment = new JLabel("Request an Appointment");
		lblRequestAnAppointment.setForeground(Color.WHITE);
		lblRequestAnAppointment.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRequestAnAppointment.setBounds(51, 11, 173, 39);
		panel_reqAppointment.add(lblRequestAnAppointment);
		
        //add the request appointment icon to the request appointment panel
		JLabel imgReqAppointment = new JLabel("");
		imgReqAppointment.setIcon(new ImageIcon("imgs/req_app icon.png"));
		imgReqAppointment.setBounds(10, 11, 39, 39);
		panel_reqAppointment.add(imgReqAppointment);
		
        //add the sign out button
		JButton btn_signOut = new JButton("");
		btn_signOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LandingPage landingPage = new LandingPage();
				landingPage.setVisible(true);
				dispose();
			}
		});
		btn_signOut.setIcon(new ImageIcon("imgs/signout_icon.png"));
		btn_signOut.setForeground(Color.WHITE);
		btn_signOut.setFont(new Font("Dialog", Font.PLAIN, 14));
		btn_signOut.setFocusPainted(false);
		btn_signOut.setContentAreaFilled(false);
		btn_signOut.setBorderPainted(false);
		btn_signOut.setBounds(1161, 11, 44, 39);
		panel.add(btn_signOut);	
		
	}
	
	/**
     * Switches the menu panel to the selected panel.
     * 
     * @param panel the selected panel to show
     */
	
	  public void menuClicked(JPanel panel) {
	    	
	    	reqAppointment.setVisible(false);
	    	statusChecker.setVisible(false);
	    	
	    	panel.setVisible(true);
	    }
}
