/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import ecocycle.EcoStyle;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SearchPurchaseForm extends JFrame {

    private JTextField searchField;
    private JTable resultsTable;

    public SearchPurchaseForm(JFrame dashboard) {

        setTitle("EcoCycle - Search Purchase");
        setSize(700, 520);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Bring the dashboard back when this window is closed
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                dashboard.setVisible(true);
            }
        });
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(20, 20));
        mainPanel.setBackground(new Color(245, 249, 245));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(30, 35, 30, 35)
        );

        JPanel searchPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        searchPanel.setBackground(new Color(245, 249, 245));

        JLabel instruction = new JLabel(
            "Enter the product name:"
        );
        EcoStyle.styleLabel(instruction);

        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(0, 36));

        searchPanel.add(instruction);
        searchPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        EcoStyle.styleButton(searchButton);
        JButton backButton = new JButton("Back to Dashboard");
        EcoStyle.styleBackButton(backButton);

        searchButton.addActionListener(e -> searchPurchases());

        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 249, 245));
        buttonPanel.add(searchButton);
        buttonPanel.add(backButton);

        // Table where the matching records will be shown
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"Product Name", "Category", "Price (\u20ac)", "Type", "Sustainability"}, 0
        );
        resultsTable = new JTable(model);
        resultsTable.setRowHeight(28);
        EcoStyle.styleTable(resultsTable);

        JPanel centrePanel = new JPanel(new BorderLayout(10, 15));
        centrePanel.setBackground(new Color(245, 249, 245));
        centrePanel.add(searchPanel, BorderLayout.NORTH);
        centrePanel.add(new JScrollPane(resultsTable), BorderLayout.CENTER);

        mainPanel.add(centrePanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(EcoStyle.header("Search Purchases", "Find a purchase by product name"), BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    // Searches the records by name (results will be added with file storage)
    public void searchPurchases() {

        String productName = searchField.getText().trim();

        if (productName.isEmpty()) {

            JOptionPane.showMessageDialog(
                this,
                "Please enter a product name."
            );

        } else {

            JOptionPane.showMessageDialog(
                this,
                "Search requested for: " + productName
            );
        }
    }
}
