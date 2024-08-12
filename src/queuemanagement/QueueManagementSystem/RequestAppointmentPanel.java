package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import queuemanagement.AppointmentRequest;
import queuemanagement.CustomizedPanels.RoundedButton;
import queuemanagement.CustomizedPanels.RoundedCornerTextArea;
import queuemanagement.CustomizedPanels.RoundedCornerTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class RequestAppointmentPanel extends JPanel {

	private RoundedCornerTextField textField_middleName;
	private RoundedCornerTextField textField_email;
	private RoundedCornerTextField textField_firstName;
	private RoundedCornerTextField textField_surname;
	private RoundedCornerTextArea textArea_purposeOfAppointment;
	private RoundedButton btnFileRequest;
    private AppointmentRequestPanel appointmentRequestPanel;
    private RequestAppointmentPanel requestAppointmentPanel;
	private DashboardPanel dashboardPanel; 
	
	RoundedCornerTextField textField_proofOfPayment = new RoundedCornerTextField();
	JComboBox<String> comboBox_documentType = new JComboBox<>();

	/**
	 * Create the panel.
	 */
	
	public RequestAppointmentPanel(AppointmentRequestPanel appointmentRequestPanel, DashboardPanel dashboardPanel) {
					    
	    this.appointmentRequestPanel = appointmentRequestPanel;
	    this.dashboardPanel = dashboardPanel;
	    	    
		setSize(1232, 640);
		setLayout(null);
		setVisible(true);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1232, 640);
		add(panel);
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);

		addRequestTitle(panel);
		addSeparators(panel);
		addNameLabels(panel);
		addNameFields(panel);
		addEmailLabel(panel);
		addEmailField(panel);
		addDocumentTypeComboBox(panel);
		addProofOfPaymentButton(panel);
		addPurposeLabel(panel);
		addPurposeTextArea(panel);
		addFileRequestButton(panel);
		addNUImage(panel);
		
		JLabel placeholder_proofOfPayment = new JLabel("Upload Proof of Payment *");
		placeholder_proofOfPayment.setForeground(new Color(155, 155, 155));
		placeholder_proofOfPayment.setFont(new Font("Dialog", Font.PLAIN, 12));
		placeholder_proofOfPayment.setBounds(318, 333, 178, 14);
		panel.add(placeholder_proofOfPayment);
		
	}

	private void addRequestTitle(JPanel panel) {
		JTextArea requestTitleTextArea = new JTextArea();
		requestTitleTextArea.setBounds(54, 27, 404, 158);
		panel.add(requestTitleTextArea);
		requestTitleTextArea.setText("Request an\r\nAppointment");
		requestTitleTextArea.setOpaque(false);
		requestTitleTextArea.setForeground(new Color(49, 62, 138));
		requestTitleTextArea.setFont(new Font("Dialog", Font.BOLD, 60));
		requestTitleTextArea.setEditable(false);
		requestTitleTextArea.setAlignmentY(0.0f);
	}

	private void addSeparators(JPanel panel) {
		JSeparator separator = new JSeparator();
		separator.setBounds(54, 184, 526, 16);
		panel.add(separator);
		separator.setForeground(Color.WHITE);
		separator.setBackground(new Color(155, 155, 155));
	}

	private void addNameLabels(JPanel panel) {
		JLabel placeholder_firstName = new JLabel("First Name *");
		placeholder_firstName.setBounds(280, 200, 75, 13);
		panel.add(placeholder_firstName);
		placeholder_firstName.setForeground(new Color(155, 155, 155));
		placeholder_firstName.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel placeholder_surname = new JLabel("Surname *");
		placeholder_surname.setBounds(54, 199, 60, 14);
		panel.add(placeholder_surname);
		placeholder_surname.setForeground(new Color(155, 155, 155));
		placeholder_surname.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel placeholder_middleName = new JLabel("Middle Name");
		placeholder_middleName.setBounds(463, 200, 117, 13);
		panel.add(placeholder_middleName);
		placeholder_middleName.setForeground(new Color(155, 155, 155));
		placeholder_middleName.setFont(new Font("Dialog", Font.PLAIN, 12));
	}

	private void addNameFields(JPanel panel) {
		textField_middleName = new RoundedCornerTextField();
		textField_middleName.setBounds(463, 224, 117, 31);
		panel.add(textField_middleName);
		textField_middleName.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_middleName.setColumns(10);
		textField_middleName.setBorder(null);

		textField_firstName = new RoundedCornerTextField();
		textField_firstName.setBounds(280, 224, 173, 31);
		panel.add(textField_firstName);
		textField_firstName.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_firstName.setColumns(10);
		textField_firstName.setBorder(null);

		textField_surname = new RoundedCornerTextField();
		textField_surname.setBounds(54, 224, 216, 31);
		panel.add(textField_surname);
		textField_surname.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_surname.setBorder(null);
	}

	private void addEmailLabel(JPanel panel) {
		JLabel placeholder_emailAd = new JLabel("Active Email Address *");
		placeholder_emailAd.setBounds(54, 266, 133, 14);
		panel.add(placeholder_emailAd);
		placeholder_emailAd.setForeground(new Color(155, 155, 155));
		placeholder_emailAd.setFont(new Font("Dialog", Font.PLAIN, 12));
	}

	private void addEmailField(JPanel panel) {
		textField_email = new RoundedCornerTextField();
		textField_email.setBounds(54, 291, 526, 31);
		panel.add(textField_email);
		textField_email.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_email.setColumns(10);
		textField_email.setBorder(null);
	}

	private void addDocumentTypeComboBox(JPanel panel) {
		comboBox_documentType.setBounds(54, 357, 216, 31);
		panel.add(comboBox_documentType);
		comboBox_documentType.setForeground(new Color(128, 128, 128));
		comboBox_documentType.setFont(new Font("Dialog", Font.BOLD, 14));
		comboBox_documentType.setBackground(new Color(255, 255, 255));
		comboBox_documentType.setModel(new DefaultComboBoxModel<>(new String[]{"Form 137", "Form 138", "Good Moral", "Certified True Copy of Grades", "Transcript of Records", "Diploma"}));
	}
	
	// Method to update the pending count in the dashboard panel
    private void updatePendingCountInDashboard(int count) {
        dashboardPanel.updatePendingCount(count);
    }

	private void addProofOfPaymentButton(JPanel panel) {
			
		// Create the textField_proofOfPayment to display the selected file path
		textField_proofOfPayment.setBounds(371, 358, 209, 31);
		panel.add(textField_proofOfPayment);
		textField_proofOfPayment.setFont(new Font("Dialog", Font.PLAIN, 12));
		textField_proofOfPayment.setColumns(10);
		textField_proofOfPayment.setBorder(null);
		
		JButton btn_proofOfPayment = new JButton("");
		btn_proofOfPayment.setBounds(280, 352, 117, 41);
		panel.add(btn_proofOfPayment);
		btn_proofOfPayment.setIcon(new ImageIcon("imgs\\attach_icon.png"));
		btn_proofOfPayment.setOpaque(false);
		btn_proofOfPayment.setForeground(new Color(128, 128, 128));
		btn_proofOfPayment.setFont(new Font("Dialog", Font.BOLD, 14));
		btn_proofOfPayment.setFocusPainted(false);
		btn_proofOfPayment.setContentAreaFilled(false);
		btn_proofOfPayment.setBorderPainted(false);
		
		btn_proofOfPayment.addActionListener(new ActionListener() {
			
		    public void actionPerformed(ActionEvent e) {
		    	
		        JFileChooser fileChooser = new JFileChooser();
		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		            File selectedFile = fileChooser.getSelectedFile();

		            //process the selected file
		            textField_proofOfPayment.setText(selectedFile.getAbsolutePath());

		            try {
		                Image image = ImageIO.read(selectedFile);
		                if (image == null) {
		                    throw new IOException("Invalid image file.");
		                }
		            } catch (IOException ex) {
		                JOptionPane.showMessageDialog(null, "Invalid image file. Please select a valid image file.", "Error", JOptionPane.ERROR_MESSAGE);
		                textField_proofOfPayment.setText(""); //clear the text field
		                return; //exit the method to prevent further execution
		            }

		        }
		    }
		});
	
	}

	private void addPurposeLabel(JPanel panel) {
		JLabel placeholder_documentType = new JLabel("Type of Document *");
		placeholder_documentType.setBounds(54, 333, 122, 14);
		panel.add(placeholder_documentType);
		placeholder_documentType.setForeground(new Color(155, 155, 155));
		placeholder_documentType.setFont(new Font("Dialog", Font.PLAIN, 12));

		JLabel placeholder_purpose = new JLabel("Kindly specify the purpose of your appointment request *");
		placeholder_purpose.setBounds(54, 412, 315, 14);
		panel.add(placeholder_purpose);
		placeholder_purpose.setForeground(new Color(155, 155, 155));
		placeholder_purpose.setFont(new Font("Dialog", Font.PLAIN, 12));
	}

	private void addPurposeTextArea(JPanel panel) {
		textArea_purposeOfAppointment = new RoundedCornerTextArea();
		textArea_purposeOfAppointment.setBounds(54, 437, 526, 121);
		panel.add(textArea_purposeOfAppointment);
		textArea_purposeOfAppointment.setFont(new Font("Dialog", Font.PLAIN, 12));
		textArea_purposeOfAppointment.setBorder(null);
	}	
	
	private void addNUImage(JPanel panel) {
		
		JLabel img_NU = new JLabel("");
		img_NU.setBounds(710, 19, 590, 591);
		panel.add(img_NU);
		img_NU.setIcon(new ImageIcon("imgs\\img_nu.png"));
		
	}
	 
	public String[] getEnteredData() {
	    String surname = textField_surname.getText();
	    String firstName = textField_firstName.getText();
	    String middleName = textField_middleName.getText();
	    String email = textField_email.getText();
	    String documentType = comboBox_documentType.getSelectedItem().toString();
	    String proofOfPayment = textField_proofOfPayment.getText();
	    String purpose = textArea_purposeOfAppointment.getText();

	    return new String[]{surname, firstName, middleName, email, documentType, proofOfPayment, purpose};
	}
	
	private String generateTrackingNumber() {
	    long timestamp = System.currentTimeMillis();
	    int randomNumber = (int) (Math.random() * 10000);
	    return "TRK-" + timestamp + "-" + randomNumber;
	}

	
	private void addFileRequestButton(JPanel panel) {
				
		btnFileRequest = new RoundedButton("File a Request");
		
		btnFileRequest.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
	            if (isFieldsFilled()) {	               
	            	
	            	//generate tracking number
	                String trackingNumber = generateTrackingNumber();
	            		
	            	String[] data = getEnteredData();
	            	
	            	 //update the file with the tracking number
	                updateFileWithTrackingNumber(data, trackingNumber);
	                
	                appointmentRequestPanel.addAppointmentRequest(data[0], data[1], data[2], data[3], data[4], data[5], data[6], trackingNumber);
	                
	                //update the DashboardPanel
	                if (dashboardPanel != null) {
	                dashboardPanel.increasePendingCount(); // Increment the pending count
	                }
	                
	                //display success message and for copying the tracking number to the clip board
	                String successMessage = "File request submitted!\nTracking number: " + trackingNumber;
	                JOptionPane.showMessageDialog(null, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
	                StringSelection stringSelection = new StringSelection(trackingNumber);
	                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	                clipboard.setContents(stringSelection, null);

	                clearFields();
	                	              	            	
	            } else {
	                //check individual conditions and display specific error messages
	                if (textField_proofOfPayment.getText().isEmpty()) {
	                	
	                    JOptionPane.showMessageDialog(null, "Please select a file for proof of payment.", "Error", JOptionPane.ERROR_MESSAGE);
	                    
	                } else if (!textField_surname.getText().matches("[A-Za-z ]{2,}") || !textField_firstName.getText().matches("[A-Za-z ]{2,}") || !textField_middleName.getText().matches("[A-Za-z ]*")) {
	                	
	                    JOptionPane.showMessageDialog(null, "Invalid name format. Names should only contain alphabetical characters and have at least 2 letters.", "Error", JOptionPane.ERROR_MESSAGE);
	                    
	                } else if (!textField_email.getText().matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b")) {
	                	
	                    JOptionPane.showMessageDialog(null, "Invalid email format. Please enter a valid email address.", "Error", JOptionPane.ERROR_MESSAGE);
	                    
	                } else if (textArea_purposeOfAppointment.getText().length() < 2) {
	                	
	                    JOptionPane.showMessageDialog(null, "Purpose of appointment should have at least 2 characters.", "Error", JOptionPane.ERROR_MESSAGE);
	                    
	                } else {
	                    File file = new File(textField_proofOfPayment.getText());
	                    if (!file.exists() || !file.isFile()) {
	                        JOptionPane.showMessageDialog(null, "Invalid file path or file does not exist.", "Error", JOptionPane.ERROR_MESSAGE);
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Please fill in all the required fields.", "Error", JOptionPane.ERROR_MESSAGE);
	                    	
	                    }
	                }
	            }        			
			}
		});
				
		btnFileRequest.setText("File a request");
		btnFileRequest.setForeground(new Color(255, 255, 255));
		btnFileRequest.setFont(new Font("Dialog", Font.BOLD, 13));
		btnFileRequest.setBackground(new Color(49, 62, 138));
		btnFileRequest.setBounds(229, 569, 167, 41);
		panel.add(btnFileRequest);

		//mouse hover effect for btn_fileRequest
		btnFileRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFileRequest.setBackground(new Color(70, 86, 191)); //change background color on hover
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnFileRequest.setBackground(new Color(49, 62, 138)); //revert background color when not hovered
			}
		});
	}
	
	private boolean isFieldsFilled() {
		
	    String firstName = textField_firstName.getText();
	    String surname = textField_surname.getText();
	    String middleName = textField_middleName.getText();
	    String email = textField_email.getText();
	    String purpose = textArea_purposeOfAppointment.getText();
	    String proofOfPayment = textField_proofOfPayment.getText();
	    String documentType = comboBox_documentType.getSelectedItem().toString();

	    // Check if any of the required fields are empty
	    if (firstName.isEmpty() || surname.isEmpty() || email.isEmpty() ||
	            purpose.isEmpty() || proofOfPayment.isEmpty() || documentType.isEmpty()) {
	        return false; // Return false if any of the required fields are empty
	    }

	    // Check if first name, surname, and middle name contain only A-Z characters and have at least 2 letters
	    if (!firstName.matches("[A-Za-z ]{2,}") || !surname.matches("[A-Za-z ]{2,}") || !middleName.matches("[A-Za-z ]*")) {
	        return false; // Return false if any of the names contain non-alphabet characters or have less than 2 letters
	    }

	    // Check if the email is valid
	    if (!email.matches("\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b")) {
	        return false; // Return false if the email format is invalid
	    }

	    // Check if the purpose of appointment has at least 2 characters
	    if (purpose.length() < 2) {
	        return false; // Return false if the purpose has less than 2 characters
	    }

	    // Check if the proof of payment file exists
	    File file = new File(proofOfPayment);
	    if (!file.exists() || !file.isFile()) {
	        return false; // Return false if the file does not exist or is not a file
	    }

	    return true; // All required fields are filled and conditions are satisfied
	}
	
	private void clearFields() {
		textField_firstName.setText("");
		textField_surname.setText("");
		textField_email.setText("");
		textArea_purposeOfAppointment.setText("");
		textField_proofOfPayment.setText("");
		textField_middleName.setText("");
		comboBox_documentType.setSelectedIndex(0);

	}
	
	private void updateFileWithTrackingNumber(String[] data, String trackingNumber) {
		
        String fileName = appointmentRequestPanel.getFileName();
        
		String appointmentData = String.format("%s,%s,%s,%s,%s,%s,%s,%s%n", data[0], data[1], data[2], data[3], data[4], data[5], data[6], trackingNumber);
	    try  {
	        FileWriter writer = new FileWriter(fileName, true);
	        writer.write(appointmentData);
	        writer.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	
}
