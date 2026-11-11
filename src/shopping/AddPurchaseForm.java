/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shopping;

import ecocycle.EcoStyle;
import javax.swing.*;
import java.awt.*;

public class AddPurchaseForm extends JFrame {

    private JTextField productNameField;
    private JTextField priceField;
    private JComboBox<String> categoryBox;
    private JComboBox<String> typeBox;
    private JComboBox<String> sustainabilityBox;
    private JTextField ecoLabelField;
    private JComboBox<String> packagingBox;

    public AddPurchaseForm(JFrame dashboard) {

        setTitle("EcoCycle - Add Purchase");
        setSize(560, 580);
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

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(245, 249, 245));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 35, 25, 35)
        );

        JPanel formPanel = new JPanel(new GridLayout(7, 2, 12, 14));
        formPanel.setBackground(new Color(245, 249, 245));

        productNameField = new JTextField();
        priceField = new JTextField();

        categoryBox = new JComboBox<>(
            new String[]{
                "Food", "Clothing", "Electronics", "Household", "Other"
            }
        );

        typeBox = new JComboBox<>(
            new String[]{"Eco-friendly", "Standard"}
        );

        sustainabilityBox = new JComboBox<>(
            new String[]{"A (very sustainable)", "B (sustainable)", "C (average)", "D (poor)"}
        );

        ecoLabelField = new JTextField();
        packagingBox = new JComboBox<>(
            new String[]{"Plastic", "Cardboard", "Glass", "Metal", "No packaging"}
        );

        formPanel.add(formLabel("Product Name:"));
        formPanel.add(productNameField);

        formPanel.add(formLabel("Category:"));
        formPanel.add(categoryBox);

        formPanel.add(formLabel("Price (€):"));
        formPanel.add(priceField);

        formPanel.add(formLabel("Purchase Type:"));
        formPanel.add(typeBox);

        formPanel.add(formLabel("Sustainability Class:"));
        formPanel.add(sustainabilityBox);

        // Extra details depending on the type of purchase
        formPanel.add(formLabel("Eco Label:"));
        formPanel.add(ecoLabelField);

        formPanel.add(formLabel("Packaging Type:"));
        formPanel.add(packagingBox);

        typeBox.addActionListener(e -> updateTypeFields());
        updateTypeFields();

        JButton saveButton = new JButton("Save Purchase");
        EcoStyle.styleButton(saveButton);
        JButton clearButton = new JButton("Clear");
        EcoStyle.styleBackButton(clearButton);
        JButton backButton = new JButton("Back to Dashboard");
        EcoStyle.styleBackButton(backButton);

        clearButton.addActionListener(e -> clearForm());

        saveButton.addActionListener(e -> submitPurchase());

        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 249, 245));
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(EcoStyle.header("Add Purchase", "Fill in the details of your purchase"), BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    // Checks the form before saving
    public void submitPurchase() {

        if (validateInput()) {
            JOptionPane.showMessageDialog(
                this,
                "Purchase form completed!"
            );
        }
    }

    // Makes sure the name and price are filled in correctly
    public boolean validateInput() {

        if (productNameField.getText().trim().isEmpty() || priceField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete all fields.");
            return false;
        }
        try {
            Double.parseDouble(priceField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Price must be a number.");
            return false;
        }
        return true;
    }

    // Only turns on the fields that match the chosen purchase type
    private void updateTypeFields() {

        boolean eco = typeBox.getSelectedItem().equals("Eco-friendly");
        ecoLabelField.setEnabled(eco);
        packagingBox.setEnabled(!eco);
    }

    // Empties all the fields on the form
    private void clearForm() {

        productNameField.setText("");
        priceField.setText("");
        ecoLabelField.setText("");
        categoryBox.setSelectedIndex(0);
        typeBox.setSelectedIndex(0);
        sustainabilityBox.setSelectedIndex(0);
        packagingBox.setSelectedIndex(0);
    }

    // Creates a label for the form in the EcoCycle style
    private JLabel formLabel(String text) {

        JLabel label = new JLabel(text);
        EcoStyle.styleLabel(label);
        return label;
    }
}
