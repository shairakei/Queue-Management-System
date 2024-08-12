package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class StatusCheckerPanel extends JPanel {
	
    private JTextField textField_trackNumber;

    public StatusCheckerPanel() {
        setBounds(0, 0, 1232, 640);
        setLayout(null);

        JTextArea txtr_note = new JTextArea();
        txtr_note.setEditable(false);
        txtr_note.setBounds(393, 400, 457, 44);
        add(txtr_note);
        txtr_note.setForeground(new Color(255, 255, 255));
        txtr_note.setFont(new Font("Dialog", Font.BOLD, 15));
        txtr_note.setText("                  Enter your tracking number to see the status\r\n    (pending/approved/declined) of your requested document.");
        txtr_note.setOpaque(false);

        JButton btn_search = new JButton("");
        btn_search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String trackingCode = textField_trackNumber.getText();	
                checkFilesForCode(trackingCode);
            }
        });
        btn_search.setBounds(836, 320, 43, 40);
        add(btn_search);
        btn_search.setIcon(new ImageIcon("imgs\\btn_search.png"));
        btn_search.setBorder(null);
        btn_search.setOpaque(false);
        btn_search.setFocusPainted(false);
        btn_search.setContentAreaFilled(false); // Remove default content area fill
        btn_search.setBorderPainted(false);

        textField_trackNumber = new RoundedCornerTextField();
        textField_trackNumber.setBounds(347, 303, 546, 73);
        add(textField_trackNumber);
        
        textField_trackNumber.setForeground(new Color(49, 62, 138));
        textField_trackNumber.setFont(new Font("Dialog", Font.PLAIN, 25));
        textField_trackNumber.setBorder(null);
        textField_trackNumber.setColumns(10);

        JLabel lbl_statusChecker = new JLabel("STATUS CHECKER");
        lbl_statusChecker.setBounds(260, 176, 740, 100);
        add(lbl_statusChecker);
        lbl_statusChecker.setFont(new Font("Dialog", Font.BOLD, 80));
        lbl_statusChecker.setForeground(new Color(255, 255, 255));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setBounds(0, 0, 1232, 641);
        add(lblNewLabel);
        lblNewLabel.setIcon(new ImageIcon("imgs\\bg_statusTracker.png"));

      
    }

    public void checkFilesForCode(String trackingCode) {
        boolean found = false;
        
        try {
        	
            if (checkFileForCode("Accepted.txt", trackingCode)) {
                String line = getStringLineFromFile("Accepted.txt", trackingCode);
                if (line != null) {
                	 String[] details = line.split(",");
                     String message = "Status: Accepted\n";
                     message += "Name: " + details[0] + ", " + details[1] + ", " + details[2] + "\n";
                     message += "Code: " + details[4] + "\n";
                     message += "Document Type: " + details[3] + "\n";
                     message += "Scheduled Date: " + details[5] + "\n";
                     message += "Scheduled Time: " + details[6] + "\n";

                     JOptionPane.showMessageDialog(null, message, "File Search", JOptionPane.INFORMATION_MESSAGE);
              
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid line found in Accepted.txt", "File Search",
                            JOptionPane.ERROR_MESSAGE);
                }
                found = true;
                
            } else if (checkFileForCode("Rejected.txt", trackingCode)) {
                String line = getStringLineFromFile("Rejected.txt", trackingCode);
                if (line != null) {
                    String[] details = line.split(",");
                    String message = "Status: Rejected\n";
                    message += "Name: " + details[0] + ", " + details[1] + ", " + details[2] + "\n";
                    message += "Code: " + details[4] + "\n";
                    message += "Document Type: " + details[3] + "\n";
                    message += "Reason for Rejection: " + details[5] + "\n";

                    JOptionPane.showMessageDialog(null, message, "File Search", JOptionPane.INFORMATION_MESSAGE);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid line found in Rejected.txt", "File Search",
                            JOptionPane.ERROR_MESSAGE);
                }
                
                found = true;
                
            } else if (checkFileForCode("appointment_data.txt", trackingCode)) {
                JOptionPane.showMessageDialog(null, "Your request is pending", "File Search",
                        JOptionPane.INFORMATION_MESSAGE);
                found = true;
            }

            if (!found) {
                JOptionPane.showMessageDialog(null, "Your code is invalid", "File Search",
                        JOptionPane.ERROR_MESSAGE);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error reading files.", "File Reading Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean checkFileForCode(String fileName, String searchString) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    return true;
                }
            }
            
            
        }
        
        return false;
    }
    
    private String getStringLineFromFile(String fileName, String searchString) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains(searchString)) {
                    return line;
                }
            }
        }
        return null;
    }
    
}