/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import ecocycle.EcoStyle;
import javax.swing.*;
import java.awt.*;

public class DeletePurchaseForm extends JFrame {

    private JTextField productNameField;

    public DeletePurchaseForm(JFrame dashboard) {

        setTitle("EcoCycle - Delete Purchase");
        setSize(550, 350);
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

        JPanel formPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        formPanel.setBackground(new Color(245, 249, 245));

        JLabel instruction = new JLabel(
            "Enter the product name to delete:"
        );
        EcoStyle.styleLabel(instruction);

        productNameField = new JTextField();

        formPanel.add(instruction);
        formPanel.add(productNameField);

        JButton deleteButton = new JButton("Delete Purchase");
        EcoStyle.styleButton(deleteButton);
        JButton backButton = new JButton("Back to Dashboard");
        EcoStyle.styleBackButton(backButton);

        deleteButton.addActionListener(e -> {

            String productName = productNameField.getText().trim();

            if (productName.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a product name."
                );

            } else {

                int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete "
                    + productName + "?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {

                    JOptionPane.showMessageDialog(
                        this,
                        "Deletion requested for: " + productName
                    );
                }
            }
        });

        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 249, 245));
        buttonPanel.add(deleteButton);
        buttonPanel.add(backButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(EcoStyle.header("Delete Purchase", "Remove a purchase from your history"), BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }
}

