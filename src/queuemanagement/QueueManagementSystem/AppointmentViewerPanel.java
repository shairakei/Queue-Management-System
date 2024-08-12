package queuemanagement.QueueManagementSystem;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import queuemanagement.CustomizedPanels.BlueTableCellRenderer;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AppointmentViewerPanel extends JPanel {

    private JTable table;
    private DefaultTableModel tableModel;

    private AppointmentRequestPanel appointmentRequestPanel;
    private RequestAppointmentPanel requestAppointmentPanel;
    private DashboardPanel dashboardPanel;

    /**
     * Create the frame.
     */

    public AppointmentViewerPanel() {

        appointmentRequestPanel = new AppointmentRequestPanel(requestAppointmentPanel, dashboardPanel);

        setSize(1016, 637);
        setLayout(null);
        setBackground(new Color(249, 249, 249));

        tableModel = new DefaultTableModel(
                new Object[]{"Last Name", "First Name", "Middle Name", "Document Type", "Tracking Number",
                        "Scheduled Time", "Scheduled Day"}, 0);
        setLayout(null);
        
        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // disable cell editing
            }

            @Override
            protected JTableHeader createDefaultTableHeader() {
                return new JTableHeader(columnModel) {
                    @Override
                    public void updateUI() {
                        super.updateUI();
                        setForeground(Color.WHITE); // set custom foreground color for the table header
                        setBackground(new Color(49, 62, 138)); // set custom background color for the table header
                        setFont(getFont().deriveFont(Font.BOLD)); // set custom font for the table header
                    }
                };
            }
        };

        for (int i = 0; i < tableModel.getColumnCount(); i++) {
            table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(tableModel.getColumnName(i));
        }
        
        table.setFont(new Font("Dialog", Font.BOLD, 15));
        table.setForeground(new Color(49, 62, 138));
        table.setDefaultRenderer(Object.class, new BlueTableCellRenderer());

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setForeground(new Color(49, 62, 138));
        scrollPane.setFont(new Font("Dialog", Font.PLAIN, 12));
        scrollPane.setBounds(10, 98, 996, 510);
        add(scrollPane);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(new Color(244, 246, 255));
        mainPanel.setBounds(0, 0, 1016, 637);
        add(mainPanel);
        mainPanel.setLayout(null);

        JLabel lblAppointmentViewer = new JLabel("Appointment Viewer");
        lblAppointmentViewer.setBounds(300, 0, 380, 99);
        mainPanel.add(lblAppointmentViewer);
        lblAppointmentViewer.setForeground(new Color(49, 62, 138));
        lblAppointmentViewer.setFont(new Font("Dialog", Font.BOLD, 40));

        // Read the data from the file and populate the table
        String fileName = appointmentRequestPanel.getFileAccepted(); // Provide the path to the file
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                tableModel.addRow(data);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        updateTable();
    }
    
    public void addRowToTable(Object[] rowData) {
        tableModel.addRow(rowData);
    }
    
    public int getRowCount() {
        return table.getRowCount();
    }

    
    public void updateTable() {
        String fileName = appointmentRequestPanel.getFileAccepted(); // Provide the path to the file
        
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");
                
                // Check if the data is already in the table
                boolean found = false;
                for (int row = 0; row < tableModel.getRowCount(); row++) {
                    boolean match = true;
                    for (int col = 0; col < tableModel.getColumnCount(); col++) {
                        String cellValue = tableModel.getValueAt(row, col).toString();
                        if (!cellValue.equals(data[col])) {
                            match = false;
                            break;
                        }
                    }
                    if (match) {
                        found = true;
                        break;
                    }
                }
                
                // If the data is not already in the table, add it
                if (!found) {
                    tableModel.addRow(data);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
