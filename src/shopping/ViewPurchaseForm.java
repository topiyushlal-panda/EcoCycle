/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import ecocycle.EcoStyle;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewPurchaseForm extends JFrame {

    public ViewPurchaseForm(JFrame dashboard) {

        setTitle("EcoCycle - Purchase History");
        setSize(800, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Bring the dashboard back when this window is closed
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                dashboard.setVisible(true);
            }
        });

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(245, 249, 245));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 25, 25, 25)
        );

        String[] columns = {
            "Product Name", "Category", "Price (€)",
            "Type", "Sustainability", "Score"
        };

        DefaultTableModel model = new DefaultTableModel(columns, 0);

        JTable purchaseTable = new JTable(model);
        EcoStyle.styleTable(purchaseTable);
        purchaseTable.setRowHeight(28);

        JScrollPane scrollPane = new JScrollPane(purchaseTable);

        JLabel message = new JLabel(
            "Your recorded purchases will appear here."
        );
        message.setHorizontalAlignment(SwingConstants.CENTER);

        JButton backButton = new JButton("Back to Dashboard");
        EcoStyle.styleBackButton(backButton);

        backButton.addActionListener(e -> dispose());

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(245, 249, 245));
        bottomPanel.add(message, BorderLayout.CENTER);
        JPanel backPanel = new JPanel();
        backPanel.setBackground(EcoStyle.BACKGROUND);
        backPanel.add(backButton);
        bottomPanel.add(backPanel, BorderLayout.SOUTH);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(EcoStyle.header("Purchase History", "All the purchases you have recorded"), BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }
}

