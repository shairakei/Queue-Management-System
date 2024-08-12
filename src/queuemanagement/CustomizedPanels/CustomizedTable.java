package queuemanagement.CustomizedPanels;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class CustomizedTable extends JTable {

    public CustomizedTable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
        customizeTable();
    }

    private void customizeTable() {
        // Customize the table header
        JTableHeader tableHeader = getTableHeader();
        tableHeader.setDefaultRenderer(new CustomTableCellHeaderRenderer());
        tableHeader.setBackground(Color.YELLOW);
        tableHeader.setForeground(Color.RED);

        // Customize the table cells
        DefaultTableCellRenderer cellRenderer = new CustomTableCellRenderer();
        setDefaultRenderer(Object.class, cellRenderer);
        setSelectionBackground(Color.CYAN);
        setSelectionForeground(Color.BLUE);
    }

    // Custom table cell renderer
    private static class CustomTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Customize the cell background and foreground colors
            rendererComponent.setBackground(Color.WHITE);
            rendererComponent.setForeground(Color.BLACK);
            return rendererComponent;
        }
    }

    // Custom table header cell renderer
    private static class CustomTableCellHeaderRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            // Customize the header background and foreground colors
            rendererComponent.setBackground(Color.GRAY);
            rendererComponent.setForeground(Color.WHITE);
            return rendererComponent;
        }
    }
}

