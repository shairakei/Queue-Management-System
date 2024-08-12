package queuemanagement.CustomizedPanels;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class ImgRoundedPanel extends JPanel {
	
	    public ImgRoundedPanel(Image backgroundImage) {
	        setOpaque(false); // Set panel's opaque property to false
	        this.backgroundImage = backgroundImage;

	    }
	    
	    private Image backgroundImage;

	    @Override
	    protected void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int arcRadius = 90; // Adjust this value to change the roundness

	        Graphics2D graphics = (Graphics2D) g;
	        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

	        // Create a rounded rectangle shape
	        RoundRectangle2D roundedRectangle = new RoundRectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1, arcRadius, arcRadius);

	        // Create a clipping area using the rounded rectangle shape
	        Shape oldClip = graphics.getClip();
	        graphics.clip(roundedRectangle);

	        // Paint the background image
	        if (backgroundImage != null) {
	            graphics.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
	        }

	        // Reset the clipping area
	        graphics.setClip(oldClip);

	        // Paint the rounded corners
	        graphics.setColor(getBackground());
	        graphics.fill(roundedRectangle); // Use fill method instead of fillRoundRect
	        graphics.setColor(getForeground());
	        graphics.draw(roundedRectangle); // Use draw method instead of drawRoundRect
	    }


}