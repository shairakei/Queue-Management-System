package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import queuemanagement.CustomizedPanels.RoundPanels;

import java.awt.Font;
import javax.swing.ImageIcon;

public class About extends JPanel {

	/**
	 * Create the panel.
	 */
	public About() {
		setBackground(new Color(49, 62, 138));
		
		setSize(1232,682);
		setLayout(null);
		
		RoundPanels contentPanel = new RoundPanels(90);
		contentPanel.setOpaque(false);
		contentPanel.setBackground(new Color(255, 255, 255));
		contentPanel.setBounds(0, 0, 1233, 682);
		add(contentPanel);
		contentPanel.setLayout(null);
		
		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setEditable(false);
		txtrDescription.setBounds(328, 162, 576, 89);
		contentPanel.add(txtrDescription);
		txtrDescription.setText("          With just a few clicks, alumni and students can request their transcripts and \r\n     schedule an appointment to claim their official documents. This system eliminates \r\n       the need for lengthy paperwork and ensures a smooth and hassle-free process \r\n                                                for obtaining important records.");
		txtrDescription.setForeground(new Color(49, 62, 138));
		txtrDescription.setFont(new Font("Dialog", Font.PLAIN, 15));
		txtrDescription.setBackground(Color.WHITE);
		
		JLabel lblTagline2 = new JLabel("and hello to a streamlined experience.");
		lblTagline2.setBounds(289, 99, 666, 61);
		contentPanel.add(lblTagline2);
		lblTagline2.setForeground(new Color(49, 62, 138));
		lblTagline2.setFont(new Font("Dialog", Font.PLAIN, 40));
		
		JLabel lblTagline = new JLabel("Say goodbye to long, frustrating lines");
		lblTagline.setBounds(228, 23, 803, 113);
		contentPanel.add(lblTagline);
		lblTagline.setForeground(new Color(49, 62, 138));
		lblTagline.setFont(new Font("Dialog", Font.BOLD, 45));
		
		JLabel imgFeature1 = new JLabel("");
		imgFeature1.setBounds(166, 276, 292, 285);
		contentPanel.add(imgFeature1);
		imgFeature1.setIcon(new ImageIcon("imgs\\feature_1.png"));
		
		JLabel imgFeature2 = new JLabel("");
		imgFeature2.setBounds(488, 276, 292, 285);
		contentPanel.add(imgFeature2);
		imgFeature2.setIcon(new ImageIcon("imgs\\feature_2.png"));
		
		JLabel imgFeature3 = new JLabel("");
		imgFeature3.setBounds(810, 276, 292, 285);
		contentPanel.add(imgFeature3);
		imgFeature3.setIcon(new ImageIcon("imgs\\feature_3.png"));
	}

}
