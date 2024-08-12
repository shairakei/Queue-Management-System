package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import queuemanagement.RegistrarCredentials;

import javax.swing.JPasswordField;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class LoginFrame extends JPanel {

    private JTextField email;
    private JPasswordField password;
    private ArrayList<RegistrarCredentials> regCredentialsList;
    private JLabel loadingLabel;

    private void performLogin(String email, char[] passwordChars) {
    	
        String password = new String(passwordChars);

        // Check if the entered username and password match the expected values
        if (email.equals("registrar@national-u.edu.ph") && password.equals("Registrar_01")) {
            // Credentials are valid, show loading effect
            startLoadingAnimation();

            // Simulate a delay for the loading effect
            try {
                Thread.sleep(2000); // 2 seconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Stop the loading animation
            stopLoadingAnimation();

            // Redirect to RegistrarDashboard class
            RegistrarDashboard dashboard = new RegistrarDashboard();
            dashboard.setVisible(true);

            // Get the parent JFrame of the LoginFrame
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(LoginFrame.this);
            frame.dispose(); // Dispose the JFrame to close the window

        } else {
            // Invalid credentials, display an error message
            JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void startLoadingAnimation() {
        loadingLabel = new JLabel(new ImageIcon("loading.gif"));
        loadingLabel.setBounds(550, 450, 128, 128);
        add(loadingLabel);
        revalidate();
        repaint();
    }

    private void stopLoadingAnimation() {
        if (loadingLabel != null) {
            remove(loadingLabel);
            loadingLabel = null;
            revalidate();
            repaint();
        }
    }

    private void checkLoginFields() {
        stopLoadingAnimation();

        String username = email.getText();
        char[] passwordChars = password.getPassword();

        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your username", "Error", JOptionPane.WARNING_MESSAGE);
        } else if (passwordChars.length == 0) {
            JOptionPane.showMessageDialog(null, "Please enter your password", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            performLogin(username, passwordChars);

            // Clear the password field after login attempt
            email.setText("");
            password.setText("");
        }
    }

    public LoginFrame() {
        setSize(1233, 682);
        setBackground(new Color(49, 62, 138));
        setLayout(null);

        //initialize the user credentials list
        regCredentialsList = new ArrayList<>();

        //add admin credentials
        regCredentialsList.add(new RegistrarCredentials("registrar@national-u.edu.ph", "Registrar_01"));

        password = new JPasswordField();
        password.setOpaque(false);
        password.setForeground(new Color(49, 62, 138));
        password.setFont(new Font("Dialog", Font.PLAIN, 14));
        password.setBorder(null);
        password.setBounds(528, 369, 218, 36);
        add(password);

        email = new JTextField();
        email.setOpaque(false);
        email.setForeground(new Color(49, 62, 138));
        email.setFont(new Font("Dialog", Font.PLAIN, 14));
        email.setBorder(null);
        email.setBounds(528, 303, 218, 36);
        add(email);
        email.setColumns(10);

        // Add a KeyListener to the text field to listen for Enter key press event
        email.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkLoginFields();
                }
            }
        });

        // Add a KeyListener to the password field to listen for Enter key press event
        password.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    checkLoginFields();
                }
            }
        });

        JLabel img_signIn = new JLabel();
        img_signIn.setBounds(0, 0, 1232, 682);
        ImageIcon originalIcon = new ImageIcon("imgs\\signInPage.png");
        int cornerRadius = 90; // Adjust the corner radius as desired
        ImageIcon roundedIcon = createRoundedIcon(originalIcon, cornerRadius);
        img_signIn.setIcon(roundedIcon);
        add(img_signIn);
    }

    private ImageIcon createRoundedIcon(ImageIcon originalIcon, int cornerRadius) {
        int width = originalIcon.getIconWidth();
        int height = originalIcon.getIconHeight();

        // Create a new BufferedImage with ARGB transparency
        BufferedImage roundedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        // Create a Graphics2D object to draw on the roundedImage
        Graphics2D g2d = roundedImage.createGraphics();

        // Set the rendering hints to enable antialiasing and improve quality
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Create a rounded rectangle shape with the specified corner radius
        Shape roundedRect = new RoundRectangle2D.Double(0, 0, width, height, cornerRadius, cornerRadius);

        // Clear the image with transparent color
        g2d.setColor(new Color(0, 0, 0, 0));
        g2d.fillRect(0, 0, width, height);

        // Set the rounded rectangle as the clip region for the Graphics2D object
        g2d.clip(roundedRect);

        // Draw the originalIcon onto the roundedImage
        originalIcon.paintIcon(null, g2d, 0, 0);

        // Dispose the Graphics2D object
        g2d.dispose();

        // Create a new ImageIcon from the roundedImage
        return new ImageIcon(roundedImage);
    }
}
