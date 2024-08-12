package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import queuemanagement.CustomizedPanels.RoundPanels;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;


public class Contacts extends JPanel {

    RoundPanels contactPhone = new RoundPanels(30);
    JLabel phoneNumber = new JLabel("+(63) 917 820 5566");

    RoundPanels contactEmail = new RoundPanels(30);
    JLabel regEmail = new JLabel("registrar@nu-manila.edu.ph");

    RoundPanels location = new RoundPanels(30);
    JTextArea txtrMfJhocson = new JTextArea();

    /**
     * Create the panel.
     */
    public Contacts() {

        setSize(1232, 682);

        setBackground(new Color(49, 62, 138));
        setLayout(null);

        RoundPanels panel = new RoundPanels(90);
        panel.setOpaque(false);
        panel.setBackground(new Color(255, 255, 255));
        panel.setBounds(0, 0, 1233, 682);
        add(panel);
        panel.setLayout(null);

        JLabel lblGetInTouch = new JLabel("Get in touch!");
        lblGetInTouch.setFont(new Font("Dialog", Font.BOLD, 50));
        lblGetInTouch.setForeground(new Color(49, 62, 138));
        lblGetInTouch.setBounds(472, 53, 307, 61);
        panel.add(lblGetInTouch);

        JLabel lblContactUs = new JLabel("We'd like to hear from you");
        lblContactUs.setForeground(new Color(49, 62, 138));
        lblContactUs.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblContactUs.setBounds(503, 112, 231, 32);
        panel.add(lblContactUs);
        contactPhone.setOpaque(false);

        // contacts panel
        contactPhone.setBackground(new Color(249, 249, 249));
        contactPhone.setBounds(313, 166, 194, 114);
        panel.add(contactPhone);
        contactPhone.setLayout(null);

        JLabel imgPhone = new JLabel("");
        imgPhone.setIcon(new ImageIcon("imgs\\phone_icon (1).png"));
        imgPhone.setBounds(81, 11, 37, 59);
        contactPhone.add(imgPhone);

        phoneNumber.setForeground(new Color(49, 62, 138));
        phoneNumber.setFont(new Font("Dialog", Font.PLAIN, 12));
        phoneNumber.setBounds(43, 70, 113, 22);
        contactPhone.add(phoneNumber);
        contactEmail.setOpaque(false);

        // email panel
        contactEmail.setLayout(null);
        contactEmail.setBackground(new Color(249, 249, 249));
        contactEmail.setBounds(530, 166, 194, 114);
        panel.add(contactEmail);

        JLabel emailImg = new JLabel("");
        emailImg.setIcon(new ImageIcon("imgs\\mail_icon (1).png"));
        emailImg.setBounds(77, 11, 37, 58);
        contactEmail.add(emailImg);

        regEmail.setForeground(new Color(49, 62, 138));
        regEmail.setFont(new Font("Dialog", Font.PLAIN, 12));
        regEmail.setBounds(18, 66, 155, 22);
        contactEmail.add(regEmail);
        location.setOpaque(false);

        // location panel
        location.setLayout(null);
        location.setBackground(new Color(249, 249, 249));
        location.setBounds(745, 166, 194, 114);
        panel.add(location);

        JLabel locationImg = new JLabel("");
        locationImg.setIcon(new ImageIcon("imgs\\location_icon (1).png"));
        locationImg.setBounds(77, 11, 37, 58);
        location.add(locationImg);

        txtrMfJhocson.setForeground(new Color(49, 62, 138));
        txtrMfJhocson.setFont(new Font("Dialog", Font.PLAIN, 12));
        txtrMfJhocson.setText("551 M.F. Jhocson St, Sampaloc, \r\n    Manila, 1008 Metro Manila");
        txtrMfJhocson.setEditable(false);
        txtrMfJhocson.setOpaque(false);
        txtrMfJhocson.setBounds(10, 61, 174, 42);
        location.add(txtrMfJhocson);

        JLabel img_map = new JLabel("");
        img_map.setIcon(new ImageIcon("imgs\\NU_location.png"));
        img_map.setBounds(190, 296, 873, 228);
        panel.add(img_map);

        contactPhone.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                copyInformation(contactPhone);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                contactPhone.setBackground(new Color(220, 220, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contactPhone.setBackground(new Color(249, 249, 249));
            }
        });

        contactEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                copyInformation(contactEmail);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                contactEmail.setBackground(new Color(220, 220, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                contactEmail.setBackground(new Color(249, 249, 249));
            }
        });

        location.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                copyInformation(location);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                location.setBackground(new Color(220, 220, 220));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                location.setBackground(new Color(249, 249, 249));
            }
        });

    }

    private void copyInformation(RoundPanels panel) {
        if (panel == contactPhone) {
            copyToClipboard(phoneNumber.getText());
        } else if (panel == contactEmail) {
            copyToClipboard(regEmail.getText());
        } else if (panel == location) {
            copyToClipboard(txtrMfJhocson.getText());
        }
    }

    private void copyToClipboard(String text) {
        StringSelection selection = new StringSelection(text);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, null);
    }
}
