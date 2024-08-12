package queuemanagement.QueueManagementSystem;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import Main.LandingPage;
import queuemanagement.CustomizedPanels.TransparentPanel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class RegistrarDashboard extends JFrame {

    private JPanel contentPane;
    private AppointmentViewerPanel appointmentViewer;
    private AppointmentRequestPanel appointmentReq;
    private DashboardPanel dashboardPanel;
    private RequestAppointmentPanel requestAppointmentPanel;

    
    public RegistrarDashboard() {
    	
    	//Initializing components
    	
        appointmentViewer = new AppointmentViewerPanel();
        appointmentReq = new AppointmentRequestPanel(requestAppointmentPanel, dashboardPanel);
        appointmentReq.setBounds(0, 0, 1016, 637);
        dashboardPanel = new DashboardPanel();
        
        //JFrame settings
        
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1232, 701);
        setLocationRelativeTo(null);
       
        //Main content pane
        
        contentPane = new JPanel();
        contentPane.setLayout(null);
        
                
        //Panel for the menu
        
        JPanel panel_menu = new JPanel() {
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
                
                panel_menu.setBounds(0, 0, 217, 701);
                contentPane.add(panel_menu);
                panel_menu.setLayout(null);
                
                
                JPanel contentPanel = new JPanel();
                contentPanel.setBackground(new Color(249, 249, 249));
                contentPanel.setBounds(216, 64, 1016, 637);
                contentPane.add(contentPanel);
                contentPanel.setLayout(null);
                
                contentPanel.add(appointmentReq);
                contentPanel.add(dashboardPanel);
                contentPanel.add(appointmentViewer);

                menuClicked(dashboardPanel);
                
                //Logo label
                
                JLabel img_univLogo = new JLabel("");
                img_univLogo.setIcon(new ImageIcon("imgs\\dashboard_nu.png"));
                img_univLogo.setBounds(58, 79, 97, 112);
                panel_menu.add(img_univLogo);
                
                //Queue label text
                
                JLabel lbl_queue = new JLabel("Queue");
                lbl_queue.setForeground(new Color(255, 255, 255));
                lbl_queue.setFont(new Font("Dialog", Font.PLAIN, 25));
                lbl_queue.setBounds(71, 194, 75, 45);
                panel_menu.add(lbl_queue);
                
                //Management label text

                JLabel lbl_management = new JLabel("Management");
                lbl_management.setBounds(33, 221, 148, 45);
                panel_menu.add(lbl_management);
                lbl_management.setForeground(Color.WHITE);
                lbl_management.setFont(new Font("Dialog", Font.PLAIN, 25));
                
                //System label text

                JLabel lbl_system = new JLabel("System");
                lbl_system.setForeground(Color.WHITE);
                lbl_system.setFont(new Font("Dialog", Font.PLAIN, 25));
                lbl_system.setBounds(66, 250, 89, 45);
                panel_menu.add(lbl_system);
                                
                //Separator
                
                JSeparator separator = new JSeparator();
                separator.setForeground(new Color(255, 255, 255));
                separator.setBounds(36, 306, 148, 16);
                panel_menu.add(separator);
                 
                 JButton btn_signOut = new JButton("");
                 btn_signOut.addActionListener(new ActionListener() {
                 	public void actionPerformed(ActionEvent e) {
                 		                 		
                 		LandingPage landingpage = new LandingPage();
                 		landingpage.setVisible(true);
                 		dispose();
                 	}
                 });
                 btn_signOut.setIcon(new ImageIcon("imgs\\signout_icon.png"));
                 btn_signOut.setForeground(Color.WHITE);
                 btn_signOut.setFont(new Font("Dialog", Font.PLAIN, 14));
                 btn_signOut.setFocusPainted(false);
                 btn_signOut.setContentAreaFilled(false);
                 btn_signOut.setBorderPainted(false);
                 btn_signOut.setBounds(0, 639, 44, 39);
                 panel_menu.add(btn_signOut);
                 
                 TransparentPanel panel = new TransparentPanel();
                 panel.addMouseListener(new MouseAdapter() {
                 	@Override
                 	public void mouseClicked(MouseEvent e) {
                 		menuClicked(dashboardPanel);
                 	}
                 });
                 panel.setBounds(0, 333, 217, 45);
                 panel_menu.add(panel);
                 panel.setLayout(null);
                                 
                 JLabel lblNewLabel = new JLabel("Dashboard");
                 lblNewLabel.setForeground(new Color(255, 255, 255));
                 lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
                 lblNewLabel.setBounds(51, 11, 143, 23);
                 panel.add(lblNewLabel);
                 
                 JLabel lblNewLabel_1 = new JLabel("");
                 lblNewLabel_1.setIcon(new ImageIcon("imgs\\home_icon (1).png"));
                 lblNewLabel_1.setBounds(10, 0, 39, 45);
                 panel.add(lblNewLabel_1);
                 
                 TransparentPanel panel_1 = new TransparentPanel();
                 panel_1.addMouseListener(new MouseAdapter() {
                 	@Override
                 	public void mouseClicked(MouseEvent e) {
                 		
                 		menuClicked(appointmentReq);
                 	}
                 });
                 panel_1.setBounds(0, 377, 217, 45);
                 panel_menu.add(panel_1);
                 panel_1.setLayout(null);
                 
                 JLabel lblAppointmentViewer = new JLabel("Appointment Requests");
                 lblAppointmentViewer.setForeground(new Color(255, 255, 255));
                 lblAppointmentViewer.setFont(new Font("Dialog", Font.PLAIN, 14));
                 lblAppointmentViewer.setBounds(51, 11, 143, 23);
                 panel_1.add(lblAppointmentViewer);
                 
                 JLabel lblNewLabel_1_1 = new JLabel("");
                 lblNewLabel_1_1.setIcon(new ImageIcon("imgs\\request_icon.png"));
                 lblNewLabel_1_1.setBounds(10, 0, 39, 45);
                 panel_1.add(lblNewLabel_1_1);
                 
                 TransparentPanel panel_2 = new TransparentPanel();
                 panel_2.addMouseListener(new MouseAdapter() {
                 	@Override
                 	public void mouseClicked(MouseEvent e) {
                 		
                 		menuClicked(appointmentViewer);
                 	}
                 });
                 panel_2.setBounds(0, 421, 217, 45);
                 panel_menu.add(panel_2);
                 panel_2.setLayout(null);
                 
                 JLabel lblAppointmentViewer_1 = new JLabel("Appointment Viewer");
                 lblAppointmentViewer_1.setForeground(new Color(255, 255, 255));
                 lblAppointmentViewer_1.setFont(new Font("Dialog", Font.PLAIN, 14));
                 lblAppointmentViewer_1.setBounds(51, 11, 143, 23);
                 panel_2.add(lblAppointmentViewer_1);
                 
                 JLabel lblNewLabel_1_1_1 = new JLabel("");
                 lblNewLabel_1_1_1.setIcon(new ImageIcon("imgs\\view_icon.png"));
                 lblNewLabel_1_1_1.setBounds(10, 0, 39, 45);
                 panel_2.add(lblNewLabel_1_1_1);
                 
               
                //Panel for the header
                JPanel panel_header = new JPanel();
                panel_header.setBackground(new Color(255, 255, 255));
                panel_header.setBounds(216, 0, 1016, 64);
                contentPane.add(panel_header);
                panel_header.setLayout(null);
                
                //Contents for panel_header
                JLabel lbl_regName = new JLabel("Registrar");
                lbl_regName.setForeground(new Color(49, 62, 138));
                lbl_regName.setFont(new Font("Dialog", Font.BOLD, 13));
                lbl_regName.setBounds(839, 11, 66, 18);
                panel_header.add(lbl_regName);
                
                JLabel lblRegistrar = new JLabel("Dashboard");
                lblRegistrar.setForeground(new Color(49, 62, 138));
                lblRegistrar.setFont(new Font("Dialog", Font.PLAIN, 13));
                lblRegistrar.setBounds(839, 35, 127, 18);
                panel_header.add(lblRegistrar);
                
                JLabel lbl_userProfile = new JLabel("");
                lbl_userProfile.setIcon(new ImageIcon("imgs\\user_prof.png"));
                lbl_userProfile.setBounds(931, 11, 52, 42);
                panel_header.add(lbl_userProfile);
        
                setContentPane(contentPane);
    }
    
    public void menuClicked(JPanel panel) {
    	
    	dashboardPanel.setVisible(false);
    	appointmentReq.setVisible(false);
    	appointmentViewer.setVisible(false);
    	
    	panel.setVisible(true);
    }
}
