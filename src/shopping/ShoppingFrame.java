/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package shopping;

import ecocycle.EcoStyle;
import javax.swing.*;
import java.awt.*;

public class ShoppingFrame extends JFrame {

    public ShoppingFrame() {

        setTitle("EcoCycle - Sustainable Shopping");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBackground(new Color(245, 249, 245));
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(25, 30, 25, 30)
        );

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 15, 15));
        buttonPanel.setBackground(new Color(245, 249, 245));

        JButton addButton = new JButton("Add Purchase");
        EcoStyle.styleButton(addButton);
        addButton.addActionListener(e -> openAddForm());
        
        JButton viewButton = new JButton("View Purchase History");
        EcoStyle.styleButton(viewButton);
        viewButton.addActionListener(e -> openViewForm());
        
        JButton searchButton = new JButton("Search Purchase");
        EcoStyle.styleButton(searchButton);
        searchButton.addActionListener(e -> openSearchForm());
        
        JButton deleteButton = new JButton("Delete Purchase");
        EcoStyle.styleButton(deleteButton);
        deleteButton.addActionListener(e -> openDeleteForm());

        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(deleteButton);

        JButton backButton = new JButton("Back to Main Menu");
        EcoStyle.styleBackButton(backButton);

        backButton.addActionListener(e -> {
            new ecocycle.MainMenuFrame().setVisible(true);
            dispose();
        });

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(245, 249, 245));
        bottomPanel.add(backButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(EcoStyle.header("Sustainable Shopping", "Track your purchases and make more sustainable choices."), BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    // Opens the add form and hides this screen until it is closed
    public void openAddForm() {

        new AddPurchaseForm(this).setVisible(true);
        setVisible(false);
    }

    // Opens the list of all records and hides this screen until it is closed
    public void openViewForm() {

        new ViewPurchaseForm(this).setVisible(true);
        setVisible(false);
    }

    // Opens the search form and hides this screen until it is closed
    public void openSearchForm() {

        new SearchPurchaseForm(this).setVisible(true);
        setVisible(false);
    }

    // Opens the delete form and hides this screen until it is closed
    public void openDeleteForm() {

        new DeletePurchaseForm(this).setVisible(true);
        setVisible(false);
    }
}
