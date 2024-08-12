package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import queuemanagement.CustomizedPanels.RoundPanels;
import javax.swing.ImageIcon;

public class DashboardPanel extends JPanel {
	
	private JTextField numOfApproved;
	private JTextField numOfDeclined;
	private JTextField numOfPending;	
	private JTextField numOfTotal;
	private RequestAppointmentPanel requestAppointmentPanel;
	private AppointmentRequestPanel appointmentRequestPanel;
	private AppointmentViewerPanel appointmentViewerPanel;
	
	private int approvedCount = 0;
	private int declinedCount = 0;
	private int pendingCount = 0;
	
	public JTextField getNumOfPending() {
		return numOfPending;
	}

	public void setNumOfPending(JTextField numOfPending) {
		this.numOfPending = numOfPending;
	}

	public JTextField getNumOfTotal() {
		return numOfTotal;
	}

	public void setNumOfTotal(JTextField numOfTotal) {
		this.numOfTotal = numOfTotal;
	}

	public int getApprovedCount() {
		return approvedCount;
	}

	public void setApprovedCount(int approvedCount) {
		this.approvedCount = approvedCount;
	}

	public int getDeclinedCount() {
		return declinedCount;
	}

	public void setDeclinedCount(int declinedCount) {
		this.declinedCount = declinedCount;
	}

	
	//method to update the number of approved appointments
    public void updateApprovedCount(int count) {
        approvedCount = count;
        numOfApproved.setText(String.valueOf(approvedCount));
        numOfTotal.setText(String.valueOf(getTotalCount()));
    }

    //method to update the number of declined appointments
    public void updateDeclinedCount(int count) {
        declinedCount = count;
        numOfDeclined.setText(String.valueOf(declinedCount));
        numOfTotal.setText(String.valueOf(getTotalCount()));
    }

    //method to update the number of pending appointments
    public void updatePendingCount(int count) {
        pendingCount = count;
        numOfPending.setText(String.valueOf(pendingCount));
        numOfTotal.setText(String.valueOf(getTotalCount()));
    }
    

    //method to calculate the total number of appointments
    private int getTotalCount() {
        return approvedCount + declinedCount + pendingCount;
    }
    
    public void setPendingCount(int pendingCount) {
        this.pendingCount = pendingCount;
    }
    
    public int getPendingCount() {
        return pendingCount;
    }
    
    
    public void increasePendingCount() {
        pendingCount++;
        numOfPending.setText(String.valueOf(pendingCount));
        numOfTotal.setText(String.valueOf(getTotalCount()));
        appointmentRequestPanel.updateCounts();
    }

    public int processRequestAndReturnNewCount(int newPendingCount) {
        pendingCount = newPendingCount;
        numOfPending.setText(String.valueOf(pendingCount));
        numOfTotal.setText(String.valueOf(getTotalCount()));
        appointmentRequestPanel.updateCounts();
        return pendingCount;
    }


	/**
	 * Create the panel.
	 */
	
	public DashboardPanel() {
				
        appointmentRequestPanel = new AppointmentRequestPanel(requestAppointmentPanel, this);
        appointmentViewerPanel = new AppointmentViewerPanel();
						
        setSize(1016, 637);
		setBackground(new Color(244, 246, 255));
		setLayout(null);
		
		RoundPanels approvedAppointmentPanel = new RoundPanels(40);
		approvedAppointmentPanel.setLayout(null);
		approvedAppointmentPanel.setBackground(new Color(255, 255, 255));
		approvedAppointmentPanel.setBounds(284, 354, 204, 241);
		add(approvedAppointmentPanel);
		
		JLabel lbl_approved = new JLabel("Approved");
		lbl_approved.setBackground(new Color(49, 62, 138));
		lbl_approved.setForeground(new Color(49, 62, 138));
		lbl_approved.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_approved.setBounds(45, 93, 116, 37);
		approvedAppointmentPanel.add(lbl_approved);
		
		JLabel lbl_appointments1 = new JLabel("Appointments");
		lbl_appointments1.setForeground(new Color(49, 62, 138));
		lbl_appointments1.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_appointments1.setBounds(20, 122, 166, 33);
		approvedAppointmentPanel.add(lbl_appointments1);
		
		numOfApproved = new JTextField();
		numOfApproved.setEditable(false);
        numOfApproved.setText(String.valueOf(appointmentViewerPanel.getRowCount()));
        numOfApproved.setHorizontalAlignment(SwingConstants.CENTER);
		numOfApproved.setOpaque(false);
		numOfApproved.setForeground(new Color(49, 62, 138));
		numOfApproved.setFont(new Font("Dialog", Font.BOLD, 50));
		numOfApproved.setColumns(10);
		numOfApproved.setBorder(null);
		numOfApproved.setBounds(10, 166, 184, 64);
		approvedAppointmentPanel.add(numOfApproved);
		
		JLabel imgApproved = new JLabel("");
		imgApproved.setIcon(new ImageIcon("imgs\\dashboard1\\8.png"));
		imgApproved.setBounds(67, 19, 71, 63);
		approvedAppointmentPanel.add(imgApproved);
		
		RoundPanels declinedAppointmentPanel = new RoundPanels(40);
		declinedAppointmentPanel.setLayout(null);
		declinedAppointmentPanel.setBackground(new Color(255, 255, 255));
		declinedAppointmentPanel.setBounds(751, 354, 204, 241);
		add(declinedAppointmentPanel);
		
		JLabel lbl_declined = new JLabel("Declined");
		lbl_declined.setForeground(new Color(49, 62, 138));
		lbl_declined.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_declined.setBounds(48, 94, 104, 33);
		declinedAppointmentPanel.add(lbl_declined);
		
		JLabel lbl_appointments3 = new JLabel("Appointments");
		lbl_appointments3.setForeground(new Color(49, 62, 138));
		lbl_appointments3.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_appointments3.setBounds(20, 122, 164, 33);
		declinedAppointmentPanel.add(lbl_appointments3);
		
		numOfDeclined = new JTextField();
		numOfDeclined.setEditable(false);
		numOfDeclined.setText(String.valueOf(appointmentRequestPanel.getDeclinedCount()));
        numOfDeclined.setHorizontalAlignment(SwingConstants.CENTER);
		numOfDeclined.setOpaque(false);
		numOfDeclined.setForeground(new Color(49, 62, 138));
		numOfDeclined.setFont(new Font("Dialog", Font.BOLD, 50));
		numOfDeclined.setColumns(10);
		numOfDeclined.setBorder(null);
		numOfDeclined.setBounds(10, 166, 184, 64);
		declinedAppointmentPanel.add(numOfDeclined);
		
		JLabel imgDeclined = new JLabel("");
		imgDeclined.setIcon(new ImageIcon("imgs\\dashboard1\\9.png"));
		imgDeclined.setBounds(64, 20, 71, 63);
		declinedAppointmentPanel.add(imgDeclined);
		
		RoundPanels pendingAppointmentPanel = new RoundPanels(40);
		pendingAppointmentPanel.setLayout(null);
		pendingAppointmentPanel.setBackground(new Color(255, 255, 255));
		pendingAppointmentPanel.setBounds(519, 354, 204, 241);
		add(pendingAppointmentPanel);
		
		JLabel lbl_pending = new JLabel("Pending");
		lbl_pending.setForeground(new Color(49, 62, 138));
		lbl_pending.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_pending.setBounds(53, 95, 98, 33);
		pendingAppointmentPanel.add(lbl_pending);
		
		JLabel lbl_appointments2 = new JLabel("Appointments");
		lbl_appointments2.setForeground(new Color(49, 62, 138));
		lbl_appointments2.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_appointments2.setBounds(20, 122, 164, 33);
		pendingAppointmentPanel.add(lbl_appointments2);
		
		int numOfRows = appointmentRequestPanel.getRowCount();

		numOfPending = new JTextField();
		numOfPending.setEditable(false);
		numOfPending.setText(String.valueOf(numOfRows));
        numOfPending.setHorizontalAlignment(SwingConstants.CENTER);
		numOfPending.setOpaque(false);
		numOfPending.setForeground(new Color(49, 62, 138));
		numOfPending.setFont(new Font("Dialog", Font.BOLD, 50));
		numOfPending.setColumns(10);
		numOfPending.setBorder(null);
		numOfPending.setBounds(10, 166, 184, 64);
		pendingAppointmentPanel.add(numOfPending);
		
		JLabel imgPending = new JLabel("");
		imgPending.setIcon(new ImageIcon("imgs\\dashboard1\\10.png"));
		imgPending.setBounds(65, 21, 71, 63);
		pendingAppointmentPanel.add(imgPending);
		
		RoundPanels totalAppointmentPanel = new RoundPanels(40);
		totalAppointmentPanel.setLayout(null);
		totalAppointmentPanel.setBackground(Color.WHITE);
		totalAppointmentPanel.setBounds(47, 354, 204, 241);
		add(totalAppointmentPanel);
		
		JLabel lbl_total = new JLabel("Total");
		lbl_total.setForeground(new Color(49, 62, 138));
		lbl_total.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_total.setBackground(new Color(49, 62, 138));
		lbl_total.setBounds(70, 92, 59, 37);
		totalAppointmentPanel.add(lbl_total);
		
		JLabel lbl_appointments = new JLabel("Appointments");
		lbl_appointments.setForeground(new Color(49, 62, 138));
		lbl_appointments.setFont(new Font("Dialog", Font.BOLD, 25));
		lbl_appointments.setBounds(20, 122, 166, 33);
		totalAppointmentPanel.add(lbl_appointments);
		
		numOfTotal = new JTextField();
		numOfTotal.setEditable(false);
		numOfTotal.setText(String.valueOf(appointmentViewerPanel.getRowCount() + appointmentRequestPanel.getRowCount() + appointmentRequestPanel.getDeclinedCount()));
        numOfTotal.setHorizontalAlignment(SwingConstants.CENTER);
		numOfTotal.setOpaque(false);
		numOfTotal.setForeground(new Color(49, 62, 138));
		numOfTotal.setFont(new Font("Dialog", Font.BOLD, 50));
		numOfTotal.setColumns(10);
		numOfTotal.setBorder(null);
		numOfTotal.setBounds(10, 166, 184, 64);
		totalAppointmentPanel.add(numOfTotal);
		
		JLabel imgTotal = new JLabel("");
		imgTotal.setIcon(new ImageIcon("imgs\\dashboard1\\7.png"));
		imgTotal.setBounds(65, 18, 71, 63);
		totalAppointmentPanel.add(imgTotal);
		
		RoundPanels welcomePanel = new RoundPanels(40);
		welcomePanel.setBackground(new Color(255, 255, 255));
		welcomePanel.setBounds(47, 107, 908, 181);
		add(welcomePanel);
		welcomePanel.setLayout(null);
		
		JLabel imgDashboard = new JLabel("");
		imgDashboard.setIcon(new ImageIcon("imgs\\person.png"));
		imgDashboard.setBounds(573, -75, 325, 256);
		welcomePanel.add(imgDashboard);
		
		JLabel lblWelcome = new JLabel("Welcome to your dashboard");
		lblWelcome.setForeground(new Color(49, 62, 138));
		lblWelcome.setFont(new Font("Dialog", Font.BOLD, 35));
		lblWelcome.setBounds(58, 42, 505, 52);
		welcomePanel.add(lblWelcome);
		
		JLabel lblRegDashboard = new JLabel("Queue Management System / Registrar's Dashboard");
		lblRegDashboard.setForeground(new Color(49, 62, 138));
		lblRegDashboard.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblRegDashboard.setBounds(58, 86, 505, 41);
		welcomePanel.add(lblRegDashboard);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setForeground(new Color(49, 62, 138));
		lblReports.setFont(new Font("Dialog", Font.PLAIN, 22));
		lblReports.setBounds(47, 310, 77, 33);
		add(lblReports);
		
		JLabel dashboardIcon = new JLabel("");
		dashboardIcon.setIcon(new ImageIcon("imgs\\dashboard_icon.png"));
		dashboardIcon.setBounds(47, 31, 71, 52);
		add(dashboardIcon);
		
		JLabel lblDashboard = new JLabel("Dashboard");
		lblDashboard.setForeground(new Color(49, 62, 138));
		lblDashboard.setFont(new Font("Dialog", Font.BOLD, 50));
		lblDashboard.setBounds(120, 31, 270, 52);
		add(lblDashboard);
		
		JLabel imgDashboard1 = new JLabel("");
		imgDashboard1.setIcon(new ImageIcon("imgs\\person.png"));
		imgDashboard1.setBounds(620, 32, 325, 256);
		add(imgDashboard1);

	}
}
