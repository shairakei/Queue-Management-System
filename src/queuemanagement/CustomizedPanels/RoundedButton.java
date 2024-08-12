package queuemanagement.CustomizedPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedButton extends JButton {
    private static final int ARC_RADIUS = 20; // Adjust this value to change the roundness

    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape shape = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), ARC_RADIUS, ARC_RADIUS);
        g2d.setColor(getBackground());
        g2d.fill(shape);

        if (getModel().isPressed()) {
            g2d.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            g2d.setColor(getBackground().brighter());
        } else {
            g2d.setColor(getBackground());
        }

        g2d.setClip(shape);
        g2d.setFont(getFont());
        FontMetrics fontMetrics = g2d.getFontMetrics();
        Rectangle stringBounds = fontMetrics.getStringBounds(getText(), g2d).getBounds();
        int textX = getWidth() / 2 - stringBounds.width / 2;
        int textY = getHeight() / 2 - stringBounds.height / 2 + fontMetrics.getAscent();
        g2d.setColor(getForeground());
        g2d.drawString(getText(), textX, textY);
        g2d.dispose();
    }
}
