package queuemanagement.CustomizedPanels;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TransparentPanel extends JPanel {
	
    private Color transparentColor = new Color(0, 0, 0, 0); // Transparent color
    private Color hoverColor = new Color(70, 86, 191); // Color when hovered

    public TransparentPanel() {
        setOpaque(false); // Make the panel transparent

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setOpaque(true); // Make the panel opaque
                setBackground(hoverColor); // Set hover color when the mouse enters the panel
                repaint(); // Refresh the panel to apply the changes
            }
            
            public void mouseReleased(MouseEvent e) {
                setOpaque(true); // Make the panel opaque
                setBackground(hoverColor); // Set hover color when the mouse enters the panel
                repaint(); // Refresh the panel to apply the changes
            }
            
            public void mousePressed(MouseEvent e) {
                setOpaque(true); // Make the panel opaque
                setBackground(new Color(112,128,144)); // Set hover color when the mouse enters the panel
                repaint(); // Refresh the panel to apply the changes
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setOpaque(false); // Make the panel transparent again
                repaint(); // Refresh the panel to apply the changes
            }
        });
    }

    public void setHoverColor(Color hoverColor) {
        this.hoverColor = hoverColor;
    }
}
