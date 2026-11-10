/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ecocycle;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MainMenuFrame extends JFrame {

    // Tips shown at the bottom of the main menu
    private final String[] tips = {
        "Rinse food containers before recycling so they don't contaminate the bin.",
        "Bring a reusable bag when you go shopping.",
        "Buy loose fruit and veg to cut down on plastic packaging.",
        "Products with an eco label usually have a lower environmental impact.",
        "Plan your meals so you only buy what you need and waste less food."
    };

    private JLabel tipLabel;

    public MainMenuFrame() {

        // The settings for Windows
        setTitle("EcoCycle - Sustainable Living");
        setSize(850, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // The main background
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(245, 249, 245));

        // The heading section
        JPanel headingPanel = new JPanel();
        headingPanel.setLayout(new BoxLayout(headingPanel, BoxLayout.Y_AXIS));
        headingPanel.setBackground(new Color(29, 75, 55));
        headingPanel.setBorder(BorderFactory.createEmptyBorder(35, 20, 35, 20));

        JLabel title = new JLabel("EcoCycle");
        title.setFont(new Font("Arial", Font.BOLD, 38));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel(
            "Make Every Choice Count for Our Planet"
        );
        subtitle.setFont(new Font("Arial", Font.PLAIN, 17));
        subtitle.setForeground(Color.WHITE);
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        headingPanel.add(title);
        headingPanel.add(Box.createVerticalStrut(12));
        headingPanel.add(subtitle);

        // The section for navigation
        JPanel navigationPanel = new JPanel(new GridLayout(1, 2, 25, 0));
        navigationPanel.setBackground(new Color(245, 249, 245));
        navigationPanel.setBorder(
            BorderFactory.createEmptyBorder(40, 45, 30, 45)
        );

        // The Waste Tracker button
        JButton wasteButton = new JButton(
            "<html><center>WASTE TRACKER<br><br>"
            + "Record and manage your waste</center></html>"
        );

        // The Sustainable Shopping button
        JButton shoppingButton = new JButton(
            "<html><center>SUSTAINABLE SHOPPING<br><br>"
            + "Track your sustainable purchases</center></html>"
        );

        // The styling for the buttons
        styleButton(wasteButton);
        styleButton(shoppingButton);

        // The navigation for Waste Tracker
        wasteButton.addActionListener(e -> openWasteTracker());

        // The navigation for Sustainable Shopping
        shoppingButton.addActionListener(e -> openShopping());

        navigationPanel.add(wasteButton);
        navigationPanel.add(shoppingButton);

        // The footer with a sustainability tip
        tipLabel = new JLabel();
        tipLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        tipLabel.setForeground(new Color(29, 75, 55));

        JButton tipButton = new JButton("New Tip");
        EcoStyle.styleBackButton(tipButton);
        tipButton.addActionListener(e -> showTip());

        JPanel tipPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 0));
        tipPanel.setBackground(new Color(245, 249, 245));
        tipPanel.add(tipLabel);
        tipPanel.add(tipButton);

        JLabel footer = new JLabel(
            "Supporting UN Sustainable Development Goal 12"
        );
        footer.setHorizontalAlignment(SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.ITALIC, 13));
        footer.setBorder(BorderFactory.createEmptyBorder(12, 10, 18, 10));

        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(245, 249, 245));
        bottomPanel.add(tipPanel, BorderLayout.CENTER);
        bottomPanel.add(footer, BorderLayout.SOUTH);

        showTip();

        // Adding everything to the main window
        mainPanel.add(headingPanel, BorderLayout.NORTH);
        mainPanel.add(navigationPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    // Reusable method for styling the buttons
    private void styleButton(JButton button) {

        button.setFont(new Font("Arial", Font.BOLD, 19));
        button.setBackground(new Color(55, 125, 85));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(
            BorderFactory.createEmptyBorder(25, 15, 25, 15)
        );
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    // Opens the Waste Tracker section
    public void openWasteTracker() {

        new wastetracker.WasteTrackerFrame().setVisible(true);
        dispose();
    }

    // Opens the Sustainable Shopping section
    public void openShopping() {

        new shopping.ShoppingFrame().setVisible(true);
        dispose();
    }

    // Shows a random sustainability tip
    public void showTip() {

        String tip = tips[new Random().nextInt(tips.length)];
        tipLabel.setText("Eco tip: " + tip);
    }
}
