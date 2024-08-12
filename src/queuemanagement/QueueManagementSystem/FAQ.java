package queuemanagement.QueueManagementSystem;

import javax.swing.JButton;
import java.awt.Component;
import java.awt.Container;
import java.awt.Color;
import javax.swing.Timer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import queuemanagement.CustomizedPanels.RoundPanels;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextArea;

public class FAQ extends JPanel  {
	
	RoundPanels panel = new RoundPanels(90);

	/**
	 * Create the panel.
	 */
	
	public FAQ() {
		
		setSize(1232, 682);
		setBackground(new Color(49, 62, 138));
		setLayout(null);
		
		panel.setOpaque(false);
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1233, 682);
		add(panel);
		panel.setLayout(null);
		
		JTextArea txtrAnswer3 = new JTextArea();
		txtrAnswer3.setEditable(false);
		txtrAnswer3.setVisible(false);
		txtrAnswer3.setText("If a student or alumni is unable to collect their requested document on the designated day, they have the opportunity to claim it on subsequent Tuesdays or Fridays. This is because the documents are released on those specific days, provided that they have already been processed.");
		txtrAnswer3.setLineWrap(true);
		txtrAnswer3.setForeground(new Color(49, 62, 138));
		txtrAnswer3.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtrAnswer3.setBounds(38, 509, 575, 64);
		panel.add(txtrAnswer3);
		
		JLabel lblFAQ = new JLabel("Our Frequently Asked Questions");
		lblFAQ.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFAQ.setForeground(new Color(49, 62, 138));
		lblFAQ.setBounds(463, 47, 310, 31);
		panel.add(lblFAQ);
		
		JLabel lblHaveAnyQuestions = new JLabel("Have any questions?");
		lblHaveAnyQuestions.setForeground(new Color(49, 62, 138));
		lblHaveAnyQuestions.setFont(new Font("Dialog", Font.BOLD, 50));
		lblHaveAnyQuestions.setBounds(361, 68, 506, 64);
		panel.add(lblHaveAnyQuestions);
		
		RoundPanels panelFAQ1 = new RoundPanels(30);
		panelFAQ1.setBackground(new Color(100, 115, 200));
		panelFAQ1.setBounds(38, 186, 575, 56);
		panel.add(panelFAQ1);
		panelFAQ1.setLayout(null);
		
		JButton btnFAQ1 = new JButton("▼");
		btnFAQ1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFAQ1.setForeground(new Color(255, 255, 255));
		btnFAQ1.setBorderPainted(false);
		btnFAQ1.setContentAreaFilled(false);
		btnFAQ1.setFocusPainted(false);
		btnFAQ1.setOpaque(false);
		btnFAQ1.setBounds(505, 11, 60, 38);
		panelFAQ1.add(btnFAQ1);
		
		JLabel lblQuestion1 = new JLabel("How do I schedule an appointment to claim my academic records?");
		lblQuestion1.setForeground(new Color(255, 255, 255));
		lblQuestion1.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuestion1.setBounds(10, 0, 485, 56);
		panelFAQ1.add(lblQuestion1);
		
		RoundPanels panelFAQ2 = new RoundPanels(30);
		panelFAQ2.setBackground(new Color(100, 115, 200));
		panelFAQ2.setBounds(38, 313, 575, 56);
		panel.add(panelFAQ2);
		panelFAQ2.setLayout(null);
		
		JButton btnFAQ2 = new JButton("▼");
		btnFAQ2.setOpaque(false);
		btnFAQ2.setForeground(new Color(255, 255, 255));
		btnFAQ2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFAQ2.setFocusPainted(false);
		btnFAQ2.setContentAreaFilled(false);
		btnFAQ2.setBorderPainted(false);
		btnFAQ2.setBounds(505, 11, 60, 34);
		panelFAQ2.add(btnFAQ2);
		
		JLabel lblQuestion2 = new JLabel("Can I check the status of my requested documents?");
		lblQuestion2.setForeground(new Color(255, 255, 255));
		lblQuestion2.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuestion2.setBounds(10, 0, 485, 56);
		panelFAQ2.add(lblQuestion2);
		
		RoundPanels panelFAQ3 = new RoundPanels(30);
		panelFAQ3.setBackground(new Color(100, 115, 200));
		panelFAQ3.setBounds(38, 449, 575, 56);
		panel.add(panelFAQ3);
		panelFAQ3.setLayout(null);
		
		JButton btnFAQ3 = new JButton("▼");
		btnFAQ3.setOpaque(false);
		btnFAQ3.setForeground(new Color(255, 255, 255));
		btnFAQ3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFAQ3.setFocusPainted(false);
		btnFAQ3.setContentAreaFilled(false);
		btnFAQ3.setBorderPainted(false);
		btnFAQ3.setBounds(505, 11, 60, 38);
		panelFAQ3.add(btnFAQ3);
		
		JLabel lblQuestion3 = new JLabel("What happens if I fail to claim my requested document on the scheduled day?");
		lblQuestion3.setForeground(new Color(255, 255, 255));
		lblQuestion3.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuestion3.setBounds(10, 0, 555, 56);
		panelFAQ3.add(lblQuestion3);
		
		RoundPanels panelFAQ4 = new RoundPanels(30);
		panelFAQ4.setBackground(new Color(100, 115, 200));
		panelFAQ4.setBounds(623, 186, 575, 56);
		panel.add(panelFAQ4);
		panelFAQ4.setLayout(null);
		
		JButton btnFAQ4 = new JButton("▼");
		btnFAQ4.setOpaque(false);
		btnFAQ4.setForeground(new Color(255, 255, 255));
		btnFAQ4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFAQ4.setFocusPainted(false);
		btnFAQ4.setContentAreaFilled(false);
		btnFAQ4.setBorderPainted(false);
		btnFAQ4.setBounds(505, 11, 60, 38);
		panelFAQ4.add(btnFAQ4);
		
		JLabel lblQuestion4 = new JLabel("Is the appointment system only for students, or can alumni also use it?");
		lblQuestion4.setForeground(new Color(255, 255, 255));
		lblQuestion4.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuestion4.setBounds(10, 0, 453, 56);
		panelFAQ4.add(lblQuestion4);
		
		RoundPanels panelFAQ5 = new RoundPanels(30);
		panelFAQ5.setForeground(new Color(100, 115, 200));
		panelFAQ5.setBackground(new Color(100, 115, 200));
		panelFAQ5.setBounds(623, 313, 575, 56);
		panel.add(panelFAQ5);
		panelFAQ5.setLayout(null);
		
		JButton btnFAQ5 = new JButton("▼");
		btnFAQ5.setOpaque(false);
		btnFAQ5.setForeground(new Color(255, 255, 255));
		btnFAQ5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFAQ5.setFocusPainted(false);
		btnFAQ5.setContentAreaFilled(false);
		btnFAQ5.setBorderPainted(false);
		btnFAQ5.setBounds(505, 11, 60, 38);
		panelFAQ5.add(btnFAQ5);
		
		JLabel lblQuestion5 = new JLabel("How will I be notified of any updates or changes regarding my appointment?");
		lblQuestion5.setForeground(new Color(255, 255, 255));
		lblQuestion5.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuestion5.setBounds(10, 0, 527, 56);
		panelFAQ5.add(lblQuestion5);
		
		RoundPanels panelFAQ6 = new RoundPanels(30);
		panelFAQ6.setLayout(null);
		panelFAQ6.setBackground(new Color(100, 115, 200));
		panelFAQ6.setBounds(623, 449, 575, 56);
		panel.add(panelFAQ6);
		
		JButton btnFAQ6 = new JButton("▼");
		btnFAQ6.setOpaque(false);
		btnFAQ6.setForeground(new Color(255, 255, 255));
		btnFAQ6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFAQ6.setFocusPainted(false);
		btnFAQ6.setContentAreaFilled(false);
		btnFAQ6.setBorderPainted(false);
		btnFAQ6.setBounds(505, 11, 60, 38);
		panelFAQ6.add(btnFAQ6);
		
		JLabel lblQuestion6 = new JLabel("How long does it take to receive appointment confirmation after requesting?");
		lblQuestion6.setForeground(new Color(255, 255, 255));
		lblQuestion6.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblQuestion6.setBounds(10, 0, 505, 56);
		panelFAQ6.add(lblQuestion6);
		
		JTextArea txtrAnswer1 = new JTextArea();
		txtrAnswer1.setEditable(false);
		txtrAnswer1.setVisible(false);
		txtrAnswer1.setForeground(new Color(49, 62, 138));
		txtrAnswer1.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtrAnswer1.setLineWrap(true);
		txtrAnswer1.setText("The online scheduling feature allows you to request appointments by providing your complete name, active email address, and selecting the type of document you wish to request. You also need to upload proof of payment for the requested document and specify the purpose of their appointment request. ");
		txtrAnswer1.setBounds(38, 251, 575, 56);
		panel.add(txtrAnswer1);
		
		JTextArea txtrAnswer2 = new JTextArea();
		txtrAnswer2.setEditable(false);
		txtrAnswer2.setVisible(false);
		txtrAnswer2.setForeground(new Color(49, 62, 138));
		txtrAnswer2.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtrAnswer2.setLineWrap(true);
		txtrAnswer2.setText("Yes, the system provides a status checker feature. Users can enter the tracking number provided to monitor the journey of their requested documents. The status checker displays real-time information regarding the approval status of the documents, whether they are approved, declined,or pending review. Once approved, users can view their scheduled appointment time for document collection. ");
		txtrAnswer2.setBounds(38, 375, 575, 75);
		panel.add(txtrAnswer2);
		
		JTextArea txtrAnswer4 = new JTextArea();
		txtrAnswer4.setEditable(false);
		txtrAnswer4.setVisible(false);
		txtrAnswer4.setLineWrap(true);
		txtrAnswer4.setForeground(new Color(49, 62, 138));
		txtrAnswer4.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtrAnswer4.setText("The appointment system is available for both current students and alumni. They can schedule appointments to access and obtain their academic records.");
		txtrAnswer4.setBounds(623, 253, 575, 42);
		panel.add(txtrAnswer4);
		
		JTextArea txtrAnswer5 = new JTextArea();
		txtrAnswer5.setEditable(false);
		txtrAnswer5.setVisible(false);
		txtrAnswer5.setText("By utilizing your tracking number and entering it into the Status Checker, you will gain access to updates and modifications pertaining to your appointment. This will enable you to view the current status of your document.");
		txtrAnswer5.setLineWrap(true);
		txtrAnswer5.setForeground(new Color(49, 62, 138));
		txtrAnswer5.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtrAnswer5.setBounds(623, 377, 575, 59);
		panel.add(txtrAnswer5);
		
		JTextArea txtrAnswer6 = new JTextArea();
		txtrAnswer6.setEditable(false);
		txtrAnswer6.setVisible(false);
		txtrAnswer6.setText("Once you have submitted your appointment request, the confirmation for your appointment is typically sent shortly thereafter. It is important to make note of your tracking number provided in the confirmation.");
		txtrAnswer6.setLineWrap(true);
		txtrAnswer6.setForeground(new Color(49, 62, 138));
		txtrAnswer6.setFont(new Font("Dialog", Font.PLAIN, 12));
		txtrAnswer6.setBounds(623, 509, 575, 42);
		panel.add(txtrAnswer6);
		
		handleButtonClick(btnFAQ1, txtrAnswer1, panelFAQ2, panelFAQ3, panelFAQ4, panelFAQ5, panelFAQ6);
        handleButtonClick(btnFAQ2, txtrAnswer2, panelFAQ3, panelFAQ4, panelFAQ5, panelFAQ6);
        handleButtonClick(btnFAQ3, txtrAnswer3, panelFAQ4, panelFAQ5, panelFAQ6);
        handleButtonClick(btnFAQ4, txtrAnswer4, panelFAQ5, panelFAQ6);
        handleButtonClick(btnFAQ5, txtrAnswer5, panelFAQ6);
        handleButtonClick(btnFAQ6, txtrAnswer6);
	    
	}
	
	private void handleButtonClick(JButton button, JTextArea answer, RoundPanels... panels) {
	    button.addActionListener(new ActionListener() {
	        boolean isExpanded = false;
	        int answerHeight = answer.getPreferredSize().height;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            isExpanded = !isExpanded;
	            if (isExpanded) {
	                answer.setVisible(true);
	                expandPanels(answerHeight, panels);
	                button.setText("▲"); // Change button text to arrow up
	            } else {
	                answer.setVisible(false);
	                collapsePanels(answerHeight, panels);
	                button.setText("▼"); // Change button text back to arrow down
	            }
	        }
	    });

	    button.addMouseListener(new java.awt.event.MouseAdapter() {
	        public void mouseEntered(java.awt.event.MouseEvent evt) {
	            button.setForeground(new Color(244, 212, 43)); // Change button text color when hovered
	        }

	        public void mouseExited(java.awt.event.MouseEvent evt) {
	            button.setForeground(new Color(255, 255, 255)); // Change button text color back to default
	        }
	    });
	}



	private void expandPanels(int answerHeight, RoundPanels... panels) {
	    int containerHeight = panel.getPreferredSize().height;
	    int targetHeight = containerHeight + answerHeight + 20;

	    Timer timer = new Timer(10, new ActionListener() {
	        int currentHeight = containerHeight;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (currentHeight >= targetHeight) {
	                ((Timer) e.getSource()).stop();
	            } else {
	                currentHeight += 5;
	                panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, currentHeight));
	                panel.revalidate();
	                panel.repaint();
	            }
	        }
	    });
	    timer.start();
	}

	
	private void collapsePanels(int answerHeight, RoundPanels... panels) {
	    int containerHeight = panel.getPreferredSize().height;
	    int targetHeight = containerHeight - answerHeight - 20;

	    Timer timer = new Timer(10, new ActionListener() {
	        int currentHeight = containerHeight;

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            if (currentHeight <= targetHeight) {
	                ((Timer) e.getSource()).stop();
	            } else {
	                currentHeight -= 5;
	                panel.setPreferredSize(new Dimension(panel.getPreferredSize().width, currentHeight));
	                panel.revalidate();
	                panel.repaint();
	            }
	        }
	    });
	    timer.start();
	}


}

	