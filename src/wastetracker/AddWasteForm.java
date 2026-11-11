/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wastetracker;

import ecocycle.EcoStyle;
import javax.swing.*;
import java.awt.*;

public class AddWasteForm extends JFrame {

    private JTextField nameField;
    private JTextField quantityField;
    private JComboBox<String> categoryBox;
    private JComboBox<String> disposalBox;
    private JTextField materialField;
    private JComboBox<String> binBox;
    private JCheckBox hazardousBox;

    public AddWasteForm(JFrame dashboard) {

        setTitle("EcoCycle - Add Waste");
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

        nameField = new JTextField();
        quantityField = new JTextField();

        categoryBox = new JComboBox<>(
            new String[]{"Recyclable", "General Waste"}
        );

        disposalBox = new JComboBox<>(
            new String[]{"Recycling", "General Bin", "Composting"}
        );

        formPanel.add(formLabel("Waste Item Name:"));
        formPanel.add(nameField);

        formPanel.add(formLabel("Quantity:"));
        formPanel.add(quantityField);

        formPanel.add(formLabel("Category:"));
        formPanel.add(categoryBox);

        formPanel.add(formLabel("Disposal Method:"));
        formPanel.add(disposalBox);

        // Extra details depending on the type of waste
        materialField = new JTextField();
        binBox = new JComboBox<>(
            new String[]{"Green Bin", "Brown Bin", "Bottle Bank", "Recycling Centre"}
        );
        hazardousBox = new JCheckBox("This item is hazardous");
        hazardousBox.setBackground(new Color(245, 249, 245));

        formPanel.add(formLabel("Material Type:"));
        formPanel.add(materialField);

        formPanel.add(formLabel("Recycling Bin:"));
        formPanel.add(binBox);

        formPanel.add(formLabel("General Waste:"));
        formPanel.add(hazardousBox);

        categoryBox.addActionListener(e -> updateTypeFields());
        updateTypeFields();

        JButton saveButton = new JButton("Save Record");
        EcoStyle.styleButton(saveButton);
        JButton clearButton = new JButton("Clear");
        EcoStyle.styleBackButton(clearButton);
        JButton backButton = new JButton("Back to Dashboard");
        EcoStyle.styleBackButton(backButton);

        clearButton.addActionListener(e -> clearForm());

        saveButton.addActionListener(e -> submitRecord());

        backButton.addActionListener(e -> dispose());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(245, 249, 245));
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(backButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(EcoStyle.header("Add Waste Record", "Fill in the details of the waste item"), BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    // Checks the form before saving
    public void submitRecord() {

        if (validateInput()) {
            JOptionPane.showMessageDialog(
                this,
                "Waste record form completed!",
                "EcoCycle",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
    }

    // Makes sure the name and quantity are filled in correctly
    public boolean validateInput() {

        if (nameField.getText().trim().isEmpty() || quantityField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete all fields.");
            return false;
        }
        try {
            Integer.parseInt(quantityField.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Quantity must be a whole number.");
            return false;
        }
        return true;
    }

    // Only turns on the fields that match the chosen waste type
    private void updateTypeFields() {

        boolean recyclable = categoryBox.getSelectedItem().equals("Recyclable");
        materialField.setEnabled(recyclable);
        binBox.setEnabled(recyclable);
        hazardousBox.setEnabled(!recyclable);
    }

    // Empties all the fields on the form
    private void clearForm() {

        nameField.setText("");
        quantityField.setText("");
        materialField.setText("");
        categoryBox.setSelectedIndex(0);
        disposalBox.setSelectedIndex(0);
        binBox.setSelectedIndex(0);
        hazardousBox.setSelected(false);
    }

    // Creates a label for the form in the EcoCycle style
    private JLabel formLabel(String text) {

        JLabel label = new JLabel(text);
        EcoStyle.styleLabel(label);
        return label;
    }
}
