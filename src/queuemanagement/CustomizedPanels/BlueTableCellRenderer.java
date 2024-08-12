package queuemanagement.CustomizedPanels;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class BlueTableCellRenderer extends DefaultTableCellRenderer {
    private static final long serialVersionUID = 1L;

    public BlueTableCellRenderer() {
        setOpaque(true);
        setForeground(new Color(49,62,138));
        setFont(new Font("Dialog", Font.PLAIN, 12));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        rendererComponent.setForeground(new Color(49,62,138));
        rendererComponent.setFont(new Font("Dialog", Font.PLAIN, 12));
        return rendererComponent;
    }
}
