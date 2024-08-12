package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import queuemanagement.AppointmentRequest;
import queuemanagement.CustomizedPanels.BlueTableCellRenderer;
import queuemanagement.CustomizedPanels.CustomDialog;
import queuemanagement.CustomizedPanels.RoundPanels;
import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.CustomizedTable;

import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

public class AppointmentRequestPanel extends JPanel {

    private JTable appointmentTable;
    private DefaultTableModel tableModel;
    private RequestAppointmentPanel requestAppointmentPanel;
    private AppointmentRequestPanel appointmentRequestPanel;
    private List<AppointmentRequest> appointmentRequests;
    private AppointmentViewerPanel appointmentViewerPanel;
    private DashboardPanel dashboardPanel;
    
    private JLabel acceptedCountLabel;
    private JLabel rejectedCountLabel;
    private JLabel totalCountLabel; 

    String fileName = "appointment_data.txt";
    String fileAccepted = "Accepted.txt";
    String fileRejected = "Rejected.txt"; 


    public AppointmentRequestPanel(RequestAppointmentPanel requestAppointmentPanel, DashboardPanel dashboardPanel) {
    	
         this.requestAppointmentPanel = requestAppointmentPanel;
         this.dashboardPanel = dashboardPanel;
         
    	appointmentRequests = new ArrayList<>();    
    	
    	//initialize the count labels
        acceptedCountLabel = new JLabel();
        rejectedCountLabel = new JLabel();
        totalCountLabel = new JLabel();
       
        setSize(1016, 637);
        setBackground(new Color(244, 246, 255));
    	setLayout(null);   	

        //creates the table model with column names
        tableModel = new DefaultTableModel(
                new Object[]{"Last Name", "First Name", "Middle Name", "Email", "Document Type", "Proof Of Payment", "Purpose", "Tracking Number"}, 0);
        setLayout(null);
                        
        appointmentTable = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // disable cell editing
            }

            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new JTableHeader(columnModel) {
                    @Override
                    public void updateUI() {
                        super.updateUI();
                        setForeground(Color.WHITE); // set custom foreground color for the table header
                        setBackground(new Color(49, 62, 138)); // set custom background color for the table header
                        setFont(getFont().deriveFont(Font.BOLD)); // set custom font for the table header
                    }
                };
            }
        };

        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            appointmentTable.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(tableModel.getColumnName(i));
        }

         
        appointmentTable.setFont(new Font("Dialog", Font.BOLD, 15));
        appointmentTable.setForeground(new Color(49, 62, 138));
        appointmentTable.setDefaultRenderer(Object.class, new BlueTableCellRenderer());
         
         appointmentTable.addMouseListener(new MouseAdapter() {
        	    @Override
        	    public void mouseClicked(MouseEvent e) {
        	        if (e.getClickCount() == 1) {
        	            int selectedRow = appointmentTable.getSelectedRow();
        	            int clickedColumn = appointmentTable.columnAtPoint(e.getPoint());
        	            if (selectedRow >= 0) {
        	                String proofOfPaymentURL = tableModel.getValueAt(selectedRow, 5).toString();
        	                if (clickedColumn == 5) {
        	                    try {
        	                    	
        	                        //check if the proofOfPaymentURL is a valid URL
        	                        URL url;
        	                        if (proofOfPaymentURL.startsWith("http")) {
        	                            url = new URL(proofOfPaymentURL);
        	                        } else {
        	                            //assuming it's a local file path
        	                            File file = new File(proofOfPaymentURL);
        	                            url = file.toURI().toURL();
        	                        }

        	                        //load the image from the URL
        	                        ImageIcon imageIcon = new ImageIcon(url);

        	                        //display the image in a custom dialog
        	                        JLabel label = new JLabel(imageIcon);
        	                        JOptionPane.showMessageDialog(null, label, "Proof of Payment", JOptionPane.PLAIN_MESSAGE);
        	                        
        	                    } catch (IOException ex) {
        	                        ex.printStackTrace();
        	                        JOptionPane.showMessageDialog(null, "Failed to load the image.", "Error", JOptionPane.ERROR_MESSAGE);
        	                    }
        	                    
        	                } else {
        	                	
        	                    //handle other columns or actions
        	                    String lastName = tableModel.getValueAt(selectedRow, 0).toString();
        	                    String firstName = tableModel.getValueAt(selectedRow, 1).toString();
        	                    String middleName = tableModel.getValueAt(selectedRow, 2).toString();
        	                    String email = tableModel.getValueAt(selectedRow, 3).toString();
        	                    String documentType = tableModel.getValueAt(selectedRow, 4).toString();
        	                    String proofOfPayment = tableModel.getValueAt(selectedRow, 5).toString();
        	                    String purpose = tableModel.getValueAt(selectedRow, 6).toString();
        	                    String trackingNumber = tableModel.getValueAt(selectedRow, 7).toString();

        	                    //create a custom dialog to display the details
        	                    CustomDialog dialog = new CustomDialog(lastName, firstName, middleName, email,
        	                            documentType, proofOfPayment, purpose, trackingNumber);
        	                    
        	                    boolean accepted = dialog.isAccepted();

        	                    //perform actions based on the registrar's choice       	                    
        	                     if (accepted) {
        	                    	updateAccepted(lastName, firstName, middleName, email,
            	                            documentType, proofOfPayment, purpose, trackingNumber);
        	                        //accept button clicked
        	                    } else {
        	                    	updateDecline(lastName, firstName, middleName, email,
            	                            documentType, proofOfPayment, purpose, trackingNumber);
        	                        //decline button clicked

        	                    }
        	                }
        	            }
        	        }
        	    }
        	});
              	
        JScrollPane scrollPane = new JScrollPane(appointmentTable);
        scrollPane.setForeground(new Color(49, 62, 138));
        scrollPane.setFont(new Font("Dialog", Font.PLAIN, 12));
        scrollPane.setBounds(10, 98, 996, 510);
        add(scrollPane);
        
        JLabel lblAppointmentRequest = new JLabel("Appointment Request");
        lblAppointmentRequest.setForeground(new Color(49, 62, 138));
        lblAppointmentRequest.setFont(new Font("Dialog", Font.BOLD, 40));
        lblAppointmentRequest.setBounds(290, 0, 406, 98);
        add(lblAppointmentRequest);
                
        //read the data from the file and populate the table
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");  //use comma as the delimiter
                if (data.length == 8) {
                    tableModel.addRow(data);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void addAppointmentRequest(String surname, String firstName, String middleName, String email, String documentType, String proofOfPayment, String purpose, String trackingNumber) {
    	
        tableModel.addRow(new Object[]{surname, firstName, middleName, email, documentType, proofOfPayment, purpose, trackingNumber});
        
        AppointmentRequest appointmentRequest = new AppointmentRequest(surname, firstName, middleName, email,
                documentType, proofOfPayment, purpose, trackingNumber);

        appointmentRequests.add(appointmentRequest);
        
        updateCounts();
    }
    
    public String getFileName() {
        return fileName;
    }
    
    public String getFileAccepted() {
    	return fileAccepted;
    }
    
    public String checkAppointmentStatus(String trackingNumber) {
		
	    for (AppointmentRequest appointmentRequest : appointmentRequests) {
	        if (appointmentRequest.getTrackingNumber().equals(trackingNumber)) {
	            // Assuming you have a status property in the AppointmentRequest class
	            String status = appointmentRequest.getStatus();
	            return status;
	        }		
	    }
	    return "Appointment not found";
	}
    
    private int countLinesInFile(String filePath) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lineCount;
    }
 
    public void updateCounts() {
        //update the counts based on the data in the files
        int acceptedCount = countLinesInFile(fileAccepted);
        int rejectedCount = countLinesInFile(fileRejected);
        int totalCount = acceptedCount + rejectedCount;

        //update the count labels
        acceptedCountLabel.setText("Accepted: " + acceptedCount);
        rejectedCountLabel.setText("Rejected: " + rejectedCount);
        totalCountLabel.setText("Total: " + totalCount);
    }

   
    public int getRowCount() {
        return appointmentTable.getRowCount();
    }
    
    
    private void updateAccepted(String lastName, String firstName, String middleName, String email, String documentType, String proofOfPayment, String purpose, String trackingNumber) {
        //define the time, month, and date options
        String[] times = {"Morning (8-12nn)", "Afternoon (1-4pm)"};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        String[] dates = new String[31];
        for (int i = 1; i <= 31; i++) {
            dates[i - 1] = String.valueOf(i);
        }

        //create combo boxes for time, month, and date
        JComboBox<String> timeComboBox = new JComboBox<>(times);
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        JComboBox<String> dateComboBox = new JComboBox<>(dates);

        //create a panel to hold the combo boxes
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(new JLabel("Select a time:"));
        panel.add(timeComboBox);
        panel.add(new JLabel("Select a month:"));
        panel.add(monthComboBox);
        panel.add(new JLabel("Select a date:"));
        panel.add(dateComboBox);

        //show the dialog and get the user's selection
        int result = JOptionPane.showConfirmDialog(null, panel, "Set Date and Time", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) { // User clicked "OK"
            String selectedTime = (String) timeComboBox.getSelectedItem();
            String selectedMonth = (String) monthComboBox.getSelectedItem();
            String selectedDate = (String) dateComboBox.getSelectedItem();
          
            String scheduledDateTime = selectedTime + ", " + selectedMonth + " " + selectedDate;

            //format the data as a string
            String data = lastName + "," + firstName + "," + middleName + "," + documentType + "," +
                    trackingNumber + "," + scheduledDateTime;

            //save the data to the file
            saveDataToFile(fileAccepted, data);

            //add the data to the table in AppointmentViewerPanel
            if (appointmentViewerPanel != null) {
                appointmentViewerPanel.addRowToTable(new Object[]{lastName, firstName, middleName, documentType, trackingNumber, scheduledDateTime});
            }
            
            int selectedRow = appointmentTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
                deleteFromTextFile(fileName, trackingNumber);
            }

            updateCounts();
        }
    }


    private void updateDecline(String lastName, String firstName, String middleName, String email, String documentType, String proofOfPayment, String purpose, String trackingNumber) {
        //prompt the user to enter the reason for rejection
        String reason = JOptionPane.showInputDialog(null, "Reason for Rejection:", "Enter Reason", JOptionPane.PLAIN_MESSAGE);

        if (reason != null) { //user clicked "OK" and entered a reason
            String rowText = lastName + "," + firstName + "," + middleName + "," + documentType + "," +
                    trackingNumber + "," + reason + System.lineSeparator(); // Append the reason and a newline

            //save the data to the file
            saveDataToFile(fileRejected, rowText);

            int selectedRow = appointmentTable.getSelectedRow();
            if (selectedRow >= 0) {
                tableModel.removeRow(selectedRow);
                deleteFromTextFile(fileName, trackingNumber);

            }
            
            updateCounts();
        }
    }
    
    public int getDeclinedCount() {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileRejected))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                
                //check if the line has the expected number of elements
                if (data.length >= 6) {
                    String trackingNumber = data[4];
                    String reason = data[5];

                    //check if the appointment was declined based on the reason
                    if (reason != null && !reason.isEmpty()) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return count;
    }

   
    private void saveDataToFile(String filePath, String data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving data to file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void deleteFromTextFile(String fileName, String trackingNumber) {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            //copy all lines to the temporary file except the one with the matching trackingNumber
            while ((currentLine = reader.readLine()) != null) {
                String[] data = currentLine.split(",");
                if (data.length == 8 && !data[7].equals(trackingNumber)) {
                    writer.write(currentLine);
                    writer.newLine();
                }
            }

            writer.close();
            reader.close();

            //replace the original file with the temporary file
            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    throw new IOException("Failed to rename temporary file");
                }
            } else {
                throw new IOException("Failed to delete original file");
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error deleting data from file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}

