/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wastetracker;

import ecocycle.EcoStyle;
import javax.swing.*;
import java.awt.*;

public class DeleteWasteForm extends JFrame {

    private JTextField itemNameField;

    public DeleteWasteForm(JFrame dashboard) {

        setTitle("EcoCycle - Delete Waste");
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
            "Enter the name of the waste item to delete:"
        );
        EcoStyle.styleLabel(instruction);

        itemNameField = new JTextField();

        formPanel.add(instruction);
        formPanel.add(itemNameField);

        JButton deleteButton = new JButton("Delete Record");
        EcoStyle.styleButton(deleteButton);
        JButton backButton = new JButton("Back to Dashboard");
        EcoStyle.styleBackButton(backButton);

        deleteButton.addActionListener(e -> {

            String itemName = itemNameField.getText().trim();

            if (itemName.isEmpty()) {

                JOptionPane.showMessageDialog(
                    this,
                    "Please enter a waste item name."
                );

            } else {

                int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Are you sure you want to delete " + itemName + "?",
                    "Confirm Deletion",
                    JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {
                    JOptionPane.showMessageDialog(
                        this,
                        "Deletion requested for: " + itemName
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

        add(EcoStyle.header("Delete Waste Record", "Remove a waste record"), BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }
}

