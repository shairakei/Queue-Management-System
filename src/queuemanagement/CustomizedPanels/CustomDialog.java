package queuemanagement.CustomizedPanels;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomDialog extends JDialog {
    private boolean accepted;

    public CustomDialog(String lastName, String firstName, String middleName, String email,
                        String documentType, String proofOfPayment, String purpose, String trackingNumber) {
    	
        setTitle("Appointment Details");
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        
        //a placeholder Box for spacing
        Box spaceBox = Box.createVerticalBox();
        spaceBox.setBackground(new Color(49, 62, 138));
        spaceBox.add(Box.createVerticalStrut(10)); //to adjust the space
        
        //create empty boxes for left and right spacing
        Box leftSpaceBox = Box.createHorizontalBox();
        leftSpaceBox.setBackground(new Color(49, 62, 138));
        leftSpaceBox.add(Box.createHorizontalStrut(10)); //adjust the space as needed

        Box rightSpaceBox = Box.createHorizontalBox();
        rightSpaceBox.setBackground(new Color(49, 62, 138));
        rightSpaceBox.add(Box.createHorizontalStrut(10)); //adjust the space as needed


        //a panel to display the details
        JPanel detailsPanel = new RoundPanels(30);
        detailsPanel.setLayout(new GridLayout(8, 2));
        detailsPanel.setBackground(new Color(249, 249, 249));
        detailsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        detailsPanel.setForeground(Color.WHITE);

        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setForeground(new Color(16,16,16));
        lblLastName.setFont(new Font("Dialog", Font.BOLD, 12));
        detailsPanel.add(lblLastName);
        detailsPanel.add(new JLabel(lastName));
        
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setFont(new Font("Dialog", Font.BOLD, 12));
        lblFirstName.setForeground(new Color(16,16,16));
        detailsPanel.add(lblFirstName);
        detailsPanel.add(new JLabel(firstName));
        
        JLabel lblMiddleName = new JLabel("Middle Name:");
        lblMiddleName.setFont(new Font("Dialog", Font.BOLD, 12));
        lblMiddleName.setForeground(new Color(16,16,16));
        detailsPanel.add(lblMiddleName);
        detailsPanel.add(new JLabel(middleName));
        
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Dialog", Font.BOLD, 12));
        lblEmail.setForeground(new Color(16,16,16));
        detailsPanel.add(lblEmail);
        detailsPanel.add(new JLabel(email));
        
        JLabel lblDocumentType = new JLabel("Document Type:");
        lblDocumentType.setFont(new Font("Dialog", Font.BOLD, 12));
        lblDocumentType.setForeground(new Color(16,16,16));
        detailsPanel.add(lblDocumentType);
        detailsPanel.add(new JLabel(documentType));
        
        JLabel lblProofOfPayment = new JLabel("Proof Of Payment:");
        lblProofOfPayment.setFont(new Font("Dialog", Font.BOLD, 12));
        lblProofOfPayment.setForeground(new Color(16,16,16));
        detailsPanel.add(lblProofOfPayment);
        detailsPanel.add(new JLabel(proofOfPayment));
        
        JLabel lblPurpose = new JLabel("Purpose:");
        lblPurpose.setFont(new Font("Dialog", Font.BOLD, 12));
        lblPurpose.setForeground(new Color(16,16,16));
        detailsPanel.add(lblPurpose);
        detailsPanel.add(new JLabel(purpose));
        
        JLabel lblTrackingNumber = new JLabel("Tracking Number:");
        lblTrackingNumber.setFont(new Font("Dialog", Font.BOLD, 12));
        lblTrackingNumber.setForeground(new Color(16,16,16));
        detailsPanel.add(lblTrackingNumber);
        detailsPanel.add(new JLabel(trackingNumber));

        
        // Create buttons for accept and decline
        RoundedButton acceptButton = new RoundedButton("Accept");
        acceptButton.setBackground(new Color(1,50,32));
        RoundedButton declineButton = new RoundedButton("Decline");
        declineButton.setBackground(new Color(64,0,0));

        detailsPanel.add(acceptButton);
        detailsPanel.add(declineButton);
        
        // Mouse hover effect for acceptButton
        acceptButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	acceptButton.setBackground(new Color(16,16,16)); // Change background color on hover
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	acceptButton.setBackground(new Color(1,50,32)); // Revert background color when not hovered
		    }
		});
        
        // Mouse hover effect for acceptButton
        declineButton.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
		    	declineButton.setBackground(new Color(16,16,16)); // Change background color on hover
		    }

		    @Override
		    public void mouseExited(MouseEvent e) {
		    	declineButton.setBackground(new Color(64,0,0)); // Revert background color when not hovered
		    }
		});
        

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accepted = true;
                dispose();
            }
        });

        declineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accepted = false;
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.setBackground(new Color(249,249,249));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        buttonPanel.add(Box.createHorizontalGlue()); // Add horizontal glue to center components
        buttonPanel.add(acceptButton);
        buttonPanel.add(Box.createHorizontalStrut(10)); // Add horizontal space
        buttonPanel.add(declineButton);
        buttonPanel.add(Box.createHorizontalGlue()); // Add horizontal glue to center components


        getContentPane().setBackground(new Color(249,249,249));
        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(spaceBox);
        getContentPane().add(leftSpaceBox);
        getContentPane().add(rightSpaceBox);
        getContentPane().add(detailsPanel);
        getContentPane().add(buttonPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public boolean isAccepted() {
        return accepted;
    }
}
