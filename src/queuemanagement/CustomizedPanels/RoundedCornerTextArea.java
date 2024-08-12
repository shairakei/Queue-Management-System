package queuemanagement.CustomizedPanels;

import javax.swing.*;
import java.awt.*;

public class RoundedCornerTextArea extends JTextArea {

    private Color backgroundColor;
    private Color borderColor;
    private int arc;

    public RoundedCornerTextArea() {
        setOpaque(false);
        backgroundColor = Color.WHITE; // Set the desired background color
        borderColor = Color.GRAY; // Set the desired border color
        arc = 20; // Adjust the arc to control the roundness of the corners
        setLineWrap(true); // Enable line wrapping for the text area
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int height = getHeight();

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






