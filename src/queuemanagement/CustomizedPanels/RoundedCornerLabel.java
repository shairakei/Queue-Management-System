package queuemanagement.CustomizedPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedCornerLabel extends JLabel {
    private static final int ARC_RADIUS = 70; // Adjust this value to change the roundness

    public RoundedCornerLabel() {
    
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int width = getWidth();
        int height = getHeight();

        Shape shape = new RoundRectangle2D.Double(0, 0, width - 1, height - 1, ARC_RADIUS, ARC_RADIUS);
        g2d.setColor(getBackground());
        g2d.fill(shape);

        super.paintComponent(g2d);
        g2d.dispose();
    }
}
