package queuemanagement.CustomizedPanels;

import javax.swing.*;
import java.awt.*;

public class RoundedCornerTextField extends JTextField {

    private Color backgroundColor;
    private Color borderColor;

    public RoundedCornerTextField() {
        setOpaque(false);
        backgroundColor = Color.WHITE; // Set the desired background color
        borderColor = Color.GRAY; // Set the desired border color
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int height = getHeight();
        int arc = height - 1; // Adjust the arc to control the roundness of the corners

        // Paint the background with rounded corners
        g2d.setColor(backgroundColor);
        g2d.fillRoundRect(0, 0, getWidth() - 1, height - 1, arc, arc);

        // Paint the border with rounded corners
        g2d.setColor(borderColor);
        g2d.drawRoundRect(0, 0, getWidth() - 1, height - 1, arc, arc);

        g2d.dispose();

        super.paintComponent(g);
    }
}      




  